package com.sellerportal.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.util.Base64;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.anm.hibernate.DAOException;
import com.sellerportal.ism.AutoPopulateBeanHelper;
import com.sellerportal.ism.Constants;
import com.sellerportal.ism.ErrorMessagesBean;
import com.sellerportal.ism.SessionVariablesBean;
import com.sellerportal.ism.bam.beans.ForgotPasswordStep1Bean;
import com.sellerportal.ism.bam.beans.StagingLoginBean;
import com.sellerportal.ism.bam.beans.StagingResetPasswordBean;
import com.sellerportal.ism.bam.beans.UserLoginBean;
import com.sellerportal.dao.IsmacrDAO;
import com.sellerportal.model.Ismipt;
import com.sellerportal.dao.IsmiptDAO;
import com.sellerportal.model.Ismubi;
import com.sellerportal.dao.IsmubiDAO;
import com.sellerportal.model.OctParam;
import com.sellerportal.dao.OctParamDAO;
import com.sellerportal.model.OctSlr;
import com.sellerportal.dao.OctSlrDAO;
import com.sellerportal.dao.OctSlrRatingDAO;
import com.sellerportal.model.OctSlrUsr;
import com.sellerportal.dao.OctSlrUsrDAO;
import com.sellerportal.dao.OctSlvDAO;
import com.sellerportal.model.OctSlvUsr;
import com.sellerportal.dao.OctSlvUsrDAO;
import com.sellerportal.model.SlrCategoryAssociation;
import com.sellerportal.repository.IsmacrCustomRepo;
import com.sellerportal.repository.IsmacrRepo;
import com.sellerportal.repository.IsmubiRepo;
import com.sellerportal.repository.LoginRepository;
import com.sellerportal.repository.ParamRepo;
import com.sellerportal.repository.SlrRepo;
import com.sellerportal.repository.SlrScoreRepo;
import com.sellerportal.repository.SlrUsrRepo;
import com.sellerportal.repository.SlvRepo;
import com.sellerportal.repository.SlvUsrRepo;
import com.sellerportal.dao.SlrCategoryAssociationDAO;
import com.sellerportal.integra.impl.octashop.utils.OctashopUtils;
import com.sellerportal.ism.i18n.I18nHelper;
import com.sellerportal.ism.utils.EncryptDecrypt;
import com.anm.jsf.utils.FacesUtils;
import com.sellerportal.mail.AbstractMailApi;
import com.sellerportal.tisl.commons.CommonsUtils;
import com.sellerportal.tisl.commons.listener.SessionListener;
import com.sellerportal.tisl.security.utils.CSRFUtil;
import com.sellerportal.tisl.seller.listproduct.utils.ProductConst;
import com.sellerportal.tisl.servlet.ResetPasswordConstants;

@Service
@Component
public class UserLoginActionBean {

	private static final Log LOGGER = LogFactory.getLog(UserLoginActionBean.class);
	private Properties applicationConfiguration = I18nHelper.loadResource("appConfig.properties");
	private Long loginAttempts;

	@Autowired
	private UserLoginBean ulb;

	@Autowired
	private SessionVariablesBean svb;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private HttpServletResponse response;

	@Autowired
	private UserValidationActionBean uvab;

	@Autowired
	private LoginRepository loginDao;

	@Autowired
	private Environment env;

	@Autowired
	private Ismubi ismubi;

	@Autowired
	private SlvUsrRepo octslvusrDao;

	@Autowired
	private SlrUsrRepo octslrusrDao;

	@Autowired
	private SlrRepo octslrDao;

	@Autowired
	private ParamRepo octparamDao;

	@Autowired
	private SlvRepo octslvDao;

	@Autowired
	private SlrScoreRepo slrscoreDao;

	@Autowired
	private OctParam userType;

	@Autowired
	EncryptDecrypt encDec;
	
	@Autowired
	IsmubiRepo ismubiDao;
	
	@Autowired
	IsmacrRepo ismacrDao;

	private Timestamp timestamp;

	private SimpleDateFormat simpleDateFormat;

	@Autowired
	public UserLoginActionBean(SimpleDateFormat simpleDateFormat, Timestamp timestamp) {
		this.simpleDateFormat = simpleDateFormat;
		this.timestamp = timestamp;
	}

	public String userLogin_initAction() {
		return null;
	}

	public String userLogin_submitAction() throws DAOException {

		boolean result = false;

		HttpSession session = request.getSession(false);
//		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//		Timestamp timestamp = timestamp.valueOf(System.currentTimeMillis()+"");

//		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

		if (session != null) {
			session.invalidate();
		}
		String contextPath = request.getContextPath();

//		SessionVariablesBean svb=svb;
		UserLoginBean userLoginBean = (UserLoginBean) AutoPopulateBeanHelper.populate(request, ulb);
		String sellerRfnum = null;
		String imgPath = "";
		if (userLoginBean.getLoginId() != null && userLoginBean.getPassword() != null) {
			String loginId = userLoginBean.getLoginId();
			String password = userLoginBean.getPassword();
			String validityResult = validateForm(userLoginBean);

			if (!OctashopUtils.isEmpty(validityResult)) {
				try {
					String endPass = encDec.encrypt(password);

					result = uvab.loginAction(loginId, endPass);
					session = request.getSession(true);

					if (result) {
						ismubi = loginDao.findByUbilogin(loginId);
						loginAttempts = ismubi.getLoginAttempts();

						System.out.println(env.getProperty("maximumLoginAttempts"));
						if (loginAttempts != null
								&& loginAttempts >= Long.parseLong(env.getProperty("maximumLoginAttempts"))) {
							ismubi.setLoginAttempts(loginAttempts + 1);
							userLoginBean.setAttemptCount(loginAttempts + 1);
							loginDao.save(ismubi);
							FacesMessage msg = null;
							msg = I18nHelper.getMessage(
									"You have been blocked because of too many attempts. Please contact system administrator.",
									null);
							String message = msg.getSummary();
							userLoginBean.setMessage(message);
//							errorBean.setErrorMessage(message);

						} else {
							userLoginBean.setAttemptCount(0l);
							Date loginBlockTime = ismubi.getLoginBlockTime();
							Date defaultCheckDate = simpleDateFormat.parse("0001-01-01 01:01:01.0");
							Timestamp defaultCheckTimeStamp = getTimestamp(defaultCheckDate);

							if (timestamp.after(loginBlockTime) || defaultCheckTimeStamp.equals(loginBlockTime)) {

								Date parsedDate = simpleDateFormat.parse("01-01-01 01:01:01.000000000");
								Timestamp defaultTimeStamp = getTimestamp(parsedDate);
								ismubi.setLoginAttempts(0l);
								ismubi.setLoginBlockTime(defaultTimeStamp);
								userLoginBean.setAttemptCount(0l);
								loginDao.save(ismubi);

								if (ismubi.getOctParam() != null) {
									userType = ismubi.getOctParam();
									if (userType != null) {
										if (!"Y".equalsIgnoreCase(ismubi.getIsAccountexpired())) {
											Date lastlogin = ismubi.getLastlogin();
											Date currentDate = new Date();
											int diffInDays = (int) ((currentDate.getTime() - lastlogin.getTime())
													/ (1000 * 60 * 60 * 24));
											if (diffInDays < 31) {
												if (ismubi.getPwdexpiry() == null) {
													GregorianCalendar cal = new GregorianCalendar();
													cal.setTime(new Date());
													cal.add(Calendar.DATE, 180);
													ismubi.setPwdexpiry(cal.getTime());
												}
												Date pwdexpiry = ismubi.getPwdexpiry();
												if (pwdexpiry.compareTo(new Date()) > 0) {
													if ((int) ((pwdexpiry.getTime() - currentDate.getTime())
															/ (1000 * 60 * 60 * 24)) < 8) {
														svb.setDayforExpiry(
																((pwdexpiry.getTime() - currentDate.getTime())
																		/ (1000 * 60 * 60 * 24)) + "");
													}
													if (userType.getParamcode() != null
															&& userType.getParamcode().equalsIgnoreCase("SLV")) {
														OctSlvUsr octslvusr = octslvusrDao
																.findByIsmubi(ismubi.getUbirfnum());
														if (octslvusr != null) {
															svb.setOctSlvRfNum(
																	octslvusr.getOctSlv().getOctslvrfnum().toString());
															svb.setUserCode(octslvusr.getOctSlv().getOctslvcode());
															svb.setSlaveCode(octslvusr.getOctSlv().getOctslvcode());
															svb.setSellerCode(
																	octslvusr.getOctSlv().getOctSlr().getOctslrlcode());
															String slvType = octslvusr.getOctSlv().getOctslvtype()
																	.getParamrfnum() + "";
															svb.setSlvType(slvType);
															svb.setIsCNC(
																	octslvusr.getOctSlv().getOctslvCollectEnable());
															if (octslvusr.getOctSlv().getOctslvisactive() != null) { // Active
																														// Check
																														// commented
																														// Slave
																														// user
																														// login
																														// without
																														// Tax
																														// Setup
																OctSlr octslr = octslrDao.getById(octslvusr.getOctSlv()
																		.getOctSlr().getOctslrrfnum());
																svb.setIsEnablement(octslr.getOctslrCollectEnable());
																Date contactInfoLastModifiedDate = octslvusr.getOctSlv()
																		.getContactInfoModiDate();
																if (!OctashopUtils
																		.isObjectEmpty(contactInfoLastModifiedDate)) {
																	OctParam periodicPromptIntervalParam = octparamDao
																			.findByParamcode(
																					Constants.CONTACTINFO_PROMPT_INTERVAL);
																	String isPeriodicPromptRequired = checkForContactInfoUpdate(
																			contactInfoLastModifiedDate,
																			Long.valueOf(periodicPromptIntervalParam
																					.getParamvalue()));
																	svb.setIsContactInfoUpdateRequired(
																			isPeriodicPromptRequired);

																	if ("Y".equals(isPeriodicPromptRequired)) {
																		Object contactDetailsObj = octslvDao
																				.findBySlaveCode(octslvusr.getOctSlv()
																						.getOctslvcode());
																		Object[] objects = (Object[]) contactDetailsObj;
																		svb.setSlaveFirstName(
																				String.valueOf(objects[0]));
																		svb.setSlavePhoneNumber(
																				String.valueOf(objects[1]));
																	}
																}

																// R2.3 Return To Store start
																if (!OctashopUtils
																		.isObjectEmpty(octslvusr.getOctSlv())) {
																	if ("Y".equals(octslvusr.getOctSlv()
																			.getOctSlvIsReturnToStore())) {
																		svb.setIsReturnToStore("Y");
																	} else {
																		svb.setIsReturnToStore("N");
																	}
																} else {
																	svb.setIsReturnToStore("N");
																}
																// R2.3 Return To Store end

																if (octslr != null && octslr.getOctslrisactive() != null
																		&& octslr.getOctslrisactive()
																				.equalsIgnoreCase("N")) {
																	userLoginBean.setMessage(
																			"You are not authenticated to login.");
																	return null;
																}
															} else {
																userLoginBean.setMessage(
																		"You are not authenticated to login.");
																return null;
															}
															if (!OctashopUtils.isObjectEmpty(octslvusr.getOctSlv())
																	&& !OctashopUtils.isEmpty(
																			octslvusr.getOctSlv().getOctslvlname())) {
																svb.setUserName(octslvusr.getOctSlv().getOctslvlname());
															}
														} else {
															userLoginBean.setMessage("No such a user.");
															return null;
														}
													}
													if (userType.getParamcode() != null
															&& userType.getParamcode().equalsIgnoreCase("SLR")) {
														OctSlrUsr octslrusr = octslrusrDao
																.findByIsmubi(ismubi.getUbirfnum());
														if (!OctashopUtils.isObjectEmpty(octslrusr)) {
															sellerRfnum = octslrusr.getOctSlr().getOctslrrfnum()
																	.toString();
															svb.setSellerRefNo(
																	octslrusr.getOctSlr().getOctslrrfnum().toString());
															svb.setUserCode(octslrusr.getOctSlr().getOctslrlcode());
															svb.setSellerCode(octslrusr.getOctSlr().getOctslrlcode());
															// Suraj T:: slrRatingLogo

															setSlrTypeUrl(octslrusr.getOctSlr().getOctslrlcode());

															// for click and collect enablement by Jitendra @Raju R2
															// Merged
															OctSlr octslr = octslrDao
																	.getById(octslrusr.getOctSlr().getOctslrrfnum());
															svb.setIsEnablement(octslr.getOctslrCollectEnable());

															// @gulab For Fine Jewellery R3.1 Start
															SlrCategoryAssociation slrcatass = new SlrCategoryAssociationDAO()
																	.findBySellercodeCatgoryCode(svb.getUserCode(),
																			ProductConst.L1_FINE_CAT);
															if (!OctashopUtils.isObjectEmpty(slrcatass)) {
																svb.setIsFineJewelleryEnable("Y");
															} else {
																svb.setIsFineJewelleryEnable("N");
															}
															// R3.1 End

															// R2.3 Return To Store start
															if (!OctashopUtils.isObjectEmpty(octslr)) {
																if ("Y".equals(octslr.getOctslrisreturntostore())) {
																	svb.setIsReturnToStore("Y");
																} else {
																	svb.setIsReturnToStore("N");
																}
															} else {
																svb.setIsReturnToStore("N");
															}

															// R2.3 Return To Store end
//															if(ismubi != null){
//																String prfCmpltVal =new CreateSellerActionBean().
//																		getProfileComptionPercentage(octslrusr.getIsmubi().getUbirfnum()+"");  
//																if(prfCmpltVal != null && !prfCmpltVal.equals("")){
//																	svb.setProfilePercentage(prfCmpltVal);
//																}										
//															}
															if (!OctashopUtils.isObjectEmpty(octslrusr.getOctSlr())
																	&& !OctashopUtils.isEmpty(
																			octslrusr.getOctSlr().getOctslrlname())) {
																svb.setUserName(octslrusr.getOctSlr().getOctslrlname());
															}
														}
													}

													setIsDisplayReports();
													setPageAuthDetails(ismubi.getUbirfnum());
													session.setAttribute("pageAccess", svb.getPageAuth());
													session = request.getSession(true);
													session.setAttribute("loggedIn", "Y");
													session.setAttribute("sessionUserID",
															ismubi.getUbirfnum().toString());
													session.setAttribute("usercode", svb.getUserCode());
													if (ismubi != null && ismubi.getUbirfnum() != null)
														SessionListener.activeSessions++;
													// I18nFilter.userSessionMap.put(ismubi.getUbirfnum().toString(),
													// session.getId()); //Commented as per QA Suggestion
													LOGGER.info("Valid  loginId For Octashop....");
													Long ubirfnum = new Long(ismubi.getUbirfnum().toString());

													ismubi.setUbirfnum(ubirfnum);
													ismubi.setLastlogin(new java.util.Date());
													String sDate1 = "01/01/2001";
													Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
													ismubi.setLoginBlockTime(date1);
													ismubiDao.save(ismubi);
													long ubinum = ubirfnum.longValue();
													svb.setUserRefNo("" + ubinum);
													// loginId = OctashopUtils.formatName(loginId,9);
													svb.setUserLoginId(loginId);
													svb.setUserType(userType.getParamdesc());
													session.setAttribute("usertype", svb.getUserType());
													svb.setIpAddress(request.getRemoteAddr());

													// @Nikhil.S Need to change
													String finance = env.getProperty("financeuser");
													String legal = env.getProperty("legalUser");
													if ("MarketPlace".equals(svb.getUserType())
															&& !ismubi.getUbilogin().equalsIgnoreCase(finance)
															&& !ismubi.getUbilogin().equalsIgnoreCase(legal)) {
														svb.setDigitalslrType("MP");
													} else if (ismubi.getUbilogin().equalsIgnoreCase(finance)) {
														svb.setDigitalslrType("F");
													} else if (ismubi.getUbilogin().equalsIgnoreCase(legal)) {
														svb.setDigitalslrType("L");
													}

													// @Nikhil.S Need to change

													svb.setUserTypeCode(userType.getParamcode());
													svb.setUserLoginPassword(password);
													svb.setLoggedInTime(System.currentTimeMillis() / 1000);
													if (userType.getParamvalue() != null) {
														svb.setModuleHomeLink(
																contextPath + "/faces/" + userType.getParamvalue());
													}

													if (userType.getParamvalue() != null
															&& !"".equals(userType.getParamvalue())) {
														if (userType.getParamcode() != null
																&& userType.getParamcode().equalsIgnoreCase("SLR")) {
															OctSlrUsr slrUsr = octslrusrDao.findByIsmubi(ubirfnum);
															if (slrUsr != null) {
																OctSlr slr = slrUsr.getOctSlr();
																String isSellerAccepted = slr.getOctslrisaccepted();
																String isSellerApproved = slr.getOctslrisapprove();
																if ("W".equals(isSellerAccepted))
																	isSellerAccepted = "N";
																svb.setIsSellerAccepted(isSellerAccepted);
																svb.setIsSellerApproved(isSellerApproved);
																session.setAttribute("requestedSlr", sellerRfnum);
																session.setAttribute("isSellerRejected",
																		slr.getOctslrisaccepted());
																if (slr.getOctslrisprocessed() == null) {
																	session.setAttribute("isSellerProcessed", "N");
																	svb.setIsSellerProcessed("N");
																} else {
																	session.setAttribute("isSellerProcessed",
																			slr.getOctslrisprocessed());
																	svb.setIsSellerProcessed("Y");
																}
																if (!OctashopUtils.isEmpty(isSellerAccepted)
																		&& isSellerAccepted.equalsIgnoreCase("Y")
																		&& "Y".equals(isSellerApproved)) {
																	response.sendRedirect(contextPath + "/faces/"
																			+ userType.getParamvalue());
																} else {
																	response.sendRedirect(
																			contextPath + "/faces/mp/createSeller.jsp");
																}
															}
//															ctx.responseComplete();
															// @Nikhil.S Digital Agreement start
														} else if (userType.getParamcode() != null
																&& userType.getParamcode().equalsIgnoreCase("DSLR")) {
															response.sendRedirect(
																	contextPath + "/faces/" + userType.getParamvalue());
														} // @Nikhil.S Digital Agreement end
													}
												} else {
													FacesMessage msg = null;
													msg = I18nHelper.getMessage("Your password is expired please reset",
															new String[] { loginId });
													String message = msg.getSummary();
													userLoginBean.setMessage(message);
//													errorBean.setErrorMessage(message);
//													ctx.addMessage(null, msg);
												}
											} else {
												ismubi.setIsAccountexpired("Y");
												new IsmubiDAO().update(ismubi);
												FacesMessage msg = null;
												msg = I18nHelper.getMessage(
														"Your account is expired please contact Tata Cliq",
														new String[] { loginId });
												String message = msg.getSummary();
												userLoginBean.setMessage(message);
//												errorBean.setErrorMessage(message);
//												ctx.addMessage(null, msg);
											}
										} else {
											FacesMessage msg = null;
											msg = I18nHelper.getMessage(
													"Your account is expired please contact Tata Cliq",
													new String[] { loginId });
											String message = msg.getSummary();
											userLoginBean.setMessage(message);
//											errorBean.setErrorMessage(message);
//											ctx.addMessage(null, msg);
										}
									}

								} else {

									FacesMessage msg = null;
									msg = I18nHelper.getMessage("invalid", new String[] { loginId });
									String message = msg.getSummary();
									userLoginBean.setMessage(message);
//									errorBean.setErrorMessage(message);
//									ctx.addMessage(null, msg);
								}
								svb.setIsSuperoms(ismubi.getIssuperoms());// superoms

							} else {
								FacesMessage msg = null;
								msg = I18nHelper.getMessage("invalid", null);
								String message = msg.getSummary();
								userLoginBean
										.setMessage(
												"You have been blocked. Please try again after "
														+ TimeUnit.MILLISECONDS.toMinutes(
																loginBlockTime.getTime() - timestamp.getTime())
														+ " minutes.");
//							errorBean.setErrorMessage(message);
							}
						}
					} else {

						result = uvab.loginUserAction(loginId);
						if (result) {
							ismubi = new IsmubiDAO().findByUserId(loginId);
							loginAttempts = ismubi.getLoginAttempts();

							if (loginAttempts != null && loginAttempts >= Long
									.valueOf(applicationConfiguration.getProperty("maximumLoginAttempts"))) {
								ismubi.setLoginAttempts(loginAttempts + 1);
								userLoginBean.setAttemptCount(loginAttempts + 1);
								new IsmubiDAO().update(ismubi);
								FacesMessage msg = null;
								msg = I18nHelper.getMessage(
										"You have been blocked because of too many attempts. Please contact system administrator.",
										null);
								String message = msg.getSummary();
								userLoginBean.setMessage(message);
//								errorBean.setErrorMessage(message);

							} else if (loginAttempts < 5) {
								if (loginAttempts == 4) {
									Calendar cal = Calendar.getInstance();
									cal.setTime(timestamp);
									cal.add(Calendar.MINUTE, 10);
									ismubi.setLoginBlockTime(new Timestamp(cal.getTime().getTime()));
								}

								ismubi.setLoginAttempts(loginAttempts + 1);
								userLoginBean.setAttemptCount(loginAttempts + 1);
								new IsmubiDAO().update(ismubi);
								FacesMessage msg = null;
								msg = I18nHelper.getMessage(
										"Password Incorrect.You have " + (4 - loginAttempts) + " attempts left", null);
								String message = msg.getSummary();
								userLoginBean.setMessage(message);

							} else {
								ismubi.setLoginAttempts(loginAttempts + 1);
								userLoginBean.setAttemptCount(loginAttempts + 1);
								Calendar cal = Calendar.getInstance();
								cal.setTime(timestamp);
								cal.add(Calendar.MINUTE, 10);
								ismubi.setLoginBlockTime(new Timestamp(cal.getTime().getTime()));
								new IsmubiDAO().update(ismubi);

								FacesMessage msg = null;
								msg = I18nHelper.getMessage("You have been blocked. Please try after 10 minutes.",
										null);
								String message = msg.getSummary();
								userLoginBean.setMessage(message);
//								errorBean.setErrorMessage(message);
							}
						} else {
							FacesMessage msg = null;
							msg = I18nHelper.getMessage("invalid", new String[] { loginId });
							String message = msg.getSummary();
							userLoginBean.setMessage(message);
//							errorBean.setErrorMessage(message);
//							ctx.addMessage(null, msg);

						}
					}
					// @Nishant added TPR-6575
					if (userType.getParamcode() != null && userType.getParamcode().equalsIgnoreCase("SLV")) {
						OctSlvUsr octslvusr = new OctSlvUsrDAO().findByUbirfnum(ismubi.getUbirfnum());
						if (!OctashopUtils.isObjectEmpty(octslvusr)
								&& !OctashopUtils.isObjectEmpty(octslvusr.getOctSlv())) {
							if ("Y".equals(octslvusr.getOctSlv().getIsAllowErPanel())) {
								svb.setIsERPanelEligible("Y");
							} else {
								svb.setIsERPanelEligible("N");
							}
						} else {
							svb.setIsERPanelEligible("N");
						}
					}
					// Shankar Start
					if (userType.getParamcode() != null && userType.getParamcode().equalsIgnoreCase("SLR")) {
						OctSlrUsr octslrusr = new OctSlrUsrDAO().findByUbirfnum(ismubi.getUbirfnum());
						if (!OctashopUtils.isObjectEmpty(octslrusr)) {
							OctSlr octslr = new OctSlrDAO().findByPK(octslrusr.getOctSlr().getOctslrrfnum());
							if (OctashopUtils.isNotEmpty(octslr)) {
								if ("Y".equals(octslr.getIsERPanelEligible())) {
									svb.setIsERPanelEligible("Y");
								} else {
									svb.setIsERPanelEligible("N");
								}
							} else {
								svb.setIsERPanelEligible("N");
							}
						}
					}
					// Shankar End
					// Nishant Start maskcustdata TPR-10774
					if (!OctashopUtils.isObjectEmpty(ismubi) && !OctashopUtils.isEmpty(ismubi.getMaskCustData())) {
						svb.setMaskCustData(ismubi.getMaskCustData());
					} else {
						svb.setMaskCustData("0");
					}
					// Nishant End maskcustdata TPR-10774

					CSRFUtil.attachCSRFToken();

				} catch (Exception e) {
					String errMsg = "";
					FacesMessage msg = I18nHelper.getMessage("Could_not_verify_logon_from_sso", null);
//					ctx.addMessage(null, msg);
					LOGGER.info(errMsg);
					userLoginBean.setMessage(errMsg);
//					errorBean.setErrorMessage(errMsg);
					LOGGER.info("Message :: " + e.toString() + " Cause :: " + e.getCause(), e);
					return null;
				}
			}
		}
		return null;
	}

	public Timestamp getTimestamp(Date date) {
		Timestamp timestamp = new java.sql.Timestamp(date.getTime());
		return timestamp;

	}

	public String forgotPassword() {
		String navigation = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) ctx.getExternalContext().getRequest();
		HttpSession session = request.getSession(false);

		if (session != null) {
			session.invalidate();
		}
		UserLoginBean userLoginBean = (UserLoginBean) FacesUtils.getManagedBean("UserLoginBean");
		navigation = "resetpassword";
		if (userLoginBean.getLoginId() != null) {
			String loginId = userLoginBean.getLoginId();
			Ismubi ismubi = new Ismubi();
			ismubi = new IsmubiDAO().findByUserId(loginId);
			Long userrefnum = new Long(ismubi.getUbirfnum().toString());
			request.setAttribute("userrefnum", userrefnum);
			navigation = "resetpassword";
		}

		return navigation;
	}

	public String isUserExist() {
		String availiable = null;
		String msg = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		FacesMessage facesmsg = null;
		Ismubi ismubi = null;
		Long userRfnum = null;
		ForgotPasswordStep1Bean backingBean = (ForgotPasswordStep1Bean) FacesUtils
				.getManagedBean("ForgotPasswordStep1Bean");
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		AutoPopulateBeanHelper.populate(req, backingBean);
		String userEmailId = (String) backingBean.getLoginIdval();
		String comm_email = "";
		String mobile = "";
		String pamFlag = new OctParamDAO().findObjectByParamCode("ENABLE_PAM_INTEGRATION").getParamvalue();
		try {
			if (userEmailId != null) {
				ismubi = new IsmubiDAO().findbyCommunicateEmaiID(userEmailId);
			}

			if (ismubi == null) {
				LOGGER.info(">>>>>>>>>>>User is Not Availiable");
				// Harsh:
				req.setAttribute("NotExist",
						"An email has been sent to the address on record.If mail is not received shortly then please contact the Administrator");
			} else if (ismubi.getOctParam().getParamrfnum().equals(ResetPasswordConstants.MARKETPLACE_USER_TYPE)
					&& pamFlag.equalsIgnoreCase("TRUE")) {
				LOGGER.info(
						"Marketplace user: " + userEmailId + "is not allowed to reset the password from this channel");
				req.setAttribute("MpUser",
						"You are not allowed to reset the password via this channel. Please reset via PAM or contact the Administrator");
			} else {
				LOGGER.info(">>>>>User is AVAILIABLE");
				availiable = "Exist";
				req.setAttribute("userEmailId", userEmailId);
				userRfnum = ismubi.getUbirfnum();
				if (ismubi.getUbilogin() != null && !ismubi.getUbilogin().equals("")) {
					comm_email = ismubi.getUbilogin();
				}
				if (ismubi.getMobile() != null && !ismubi.getMobile().equals("")) {
					mobile = ismubi.getMobile();
				}

				if (comm_email != null && !comm_email.equals("")) {
					req.setAttribute("email2", comm_email);
				} else if (OctashopUtils.ValidationEmail(userEmailId)) {
					req.setAttribute("email2", userEmailId);
				}

				if (mobile != null && !mobile.equals("")) {
					req.setAttribute("mobile", mobile);
				}
				req.setAttribute("userRfnum", userRfnum);
			}

		} catch (Exception e1) {
			LOGGER.error(e1.getStackTrace());
			LOGGER.error("SSO Login Error: [" + e1.getMessage() + "]");
			String errMsg = "Could not verify logon from sso [" + e1.getMessage() + "]";
			facesmsg = I18nHelper.getMessage("Could_not_verify_logon_from_sso", null);
			msg = facesmsg.getSummary();
			LOGGER.info(errMsg);

		}
		req.setAttribute(availiable, availiable);
		return availiable;

	}

//	public String sendMail2SecondaryEmail() {
//		FacesContext ctx = FacesContext.getCurrentInstance();
//		final Configuration conf = new Configuration();
//		AbstractMailApi absMail = AbstractMailApi.getInstance(
//				conf.getMailServerIP(), conf.getMailTemplateUploadLocation());
//		LOGGER.info("calling sendMail2SecondaryEmail method");
//
//		Ismipt ipt = new IsmiptDAO().findObjectForName("resetPasswordMailer");
//		Long iptMdmValue = new Long(ipt.getIptvalue());
//		ForgotPasswordStep1Bean bean = (ForgotPasswordStep1Bean) FacesUtils.getManagedBean("ForgotPasswordStep1Bean");
//		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
//
//		String email_authcode = null;
//		Calendar cal = Calendar.getInstance();
//		String expiryDatestr = null;
//
//
//		Ismipt ipt1 = new IsmiptDAO().findObjectForName("passwordexpirydays");
//		Long expiryNoOfDays = new Long(ipt1.getIptvalue());
//		String expiredays = "";
//		expiredays = expiryNoOfDays.toString();
//		int days = Integer.parseInt(expiredays);
//		cal.add(Calendar.DATE, days);
//		expiryDatestr = cal.get(Calendar.YEAR) + "-"
//				+ (cal.get(Calendar.MONTH) + 1) + "-"
//				+ cal.get(Calendar.DATE);
//		Calendar curr = Calendar.getInstance();
//		curr.add(Calendar.DATE, +days);
//		email_authcode=generateCode();
//
//		AutoPopulateBeanHelper.populate(req, bean);
//		Ismubi ismubipojo =new Ismubi();
//		IsmubiDAO ismdao =new IsmubiDAO();
//		HashMap params = new HashMap();
//		String subject = "Password Reset";
//		params.put("LOGIN_ID", bean.getLoginIdval());
//		String userRfnum="";
//		try {
//			if(req.getParameter("forgotloginID")!=null){
//				if(req.getParameter("forgotloginID").indexOf('@')<0){
//					ismubipojo = ismdao.findbyUserMobile(req.getParameter("forgotloginID"));
//				}else{
//					ismubipojo = ismdao.findbyCommunicateEmaiID(req.getParameter("forgotloginID"));  //findUserLogin	 
//				}
//			}
//			new CommonsUtils().sendMailToUser(ismubipojo.getUbirfnum(), ismubipojo.getUbilogin(), iptMdmValue, "Forgot Password");
//			if (ismubipojo != null) {
//			}
//		} catch (Exception e) {
//			LOGGER.error(e.getStackTrace());
//		}
//		return null;
//	}

	public String generateCode() {
		long nextId;
		nextId = System.currentTimeMillis() % 1000000;
		return String.valueOf(nextId);
	}

	public static String invokeVelocityEngine(final Map params, final File templateFile) {

		StringWriter writer = null;
		BufferedReader reader = null;
		String result = null;
		try {
			VelocityEngine _engine = new VelocityEngine();
			_engine.init();
			VelocityContext context = new VelocityContext(params);
			writer = new StringWriter();
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(templateFile)));
			_engine.evaluate(context, writer, "velocity template", reader);
			StringBuffer buffer = writer.getBuffer();
			result = buffer.toString();
		} catch (Exception e) {

			LOGGER.info("Message :: " + e.toString() + " Cause :: " + e.getCause());
		}
		return result;
	}

	public String stagingResetPassword() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		StagingResetPasswordBean backingBean = (StagingResetPasswordBean) FacesUtils
				.getManagedBean("StagingResetPasswordBean");
		HttpServletRequest request = (HttpServletRequest) ctx.getExternalContext().getRequest();
		// getting from mail link
		String csrfToken = (String) request.getParameter("csrfToken");
//        CSRFUtil.checkTokenValidity(csrfToken);
		FacesMessage msgResponse = null;
		AutoPopulateBeanHelper.populate(request, backingBean);
		try {
			Ismubi ubi = null;
			if (backingBean.getUbiRfNum() != null && !backingBean.getUbiRfNum().equals("")) {
				String decUbiRfnum = OctashopUtils
						.getDecreptedData(new String(Base64.decodeBase64(backingBean.getUbiRfNum())));
				if (decUbiRfnum != null && !decUbiRfnum.equals("")) {
					ubi = new IsmubiDAO().findByPK(new Long(decUbiRfnum));
					// if(ubi != null && !ubi.equals("")){
					if (!OctashopUtils.isObjectEmpty(ubi)) {
						if (backingBean.getPassword1() != null && !backingBean.getPassword1().equals("")) {
							if (backingBean.getPassword2() != null && !backingBean.getPassword2().equals("")) {
								if (backingBean.getPassword1().equals(backingBean.getPassword2())) {

									if (!ubi.getResetpassword().equalsIgnoreCase("Y")) {
										EncryptDecrypt encry = new EncryptDecrypt();
										String encryPass = encry.encrypt(backingBean.getPassword1());
										ubi.setUbipass(encryPass);
										ubi.setResetpassword(("Y"));
//										ubi.setCreatedate(new Date());
										ubi.setModidate(new Date());
										ubi.setDeleted("N");
										ubi.setLastlogin(new Date());
										// @Suraj TPR-7367
										GregorianCalendar cal = new GregorianCalendar();
										cal.setTime(new Date());
										// @Nishant commented following line and change 90 to 180 TPR-7852
										// cal.add(Calendar.DATE, 90);
										cal.add(Calendar.DATE, 180);
										ubi.setPwdexpiry(cal.getTime());
										String sDate1 = "01/01/2001";
										Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
										ubi.setLoginBlockTime(date1);
										// @suraj TPR-7367
										new IsmubiDAO().update(ubi);
									} else {
										FacesContext.getCurrentInstance().addMessage(null,
												new FacesMessage("Your link is expired"));
										msgResponse = I18nHelper.getMessage("Your link is expired", null);
										request.setAttribute("msgResponse", msgResponse.getSummary());
										return null;
									}
								} else {
									FacesContext.getCurrentInstance().addMessage(null,
											new FacesMessage("Password Doesn not match"));
									msgResponse = I18nHelper.getMessage("Password Does not match", null);
									request.setAttribute("msgResponse", msgResponse.getSummary());
									return null;
								}

							} else {
								FacesContext.getCurrentInstance().addMessage(null,
										new FacesMessage("Confirm Password Empty"));
								msgResponse = I18nHelper.getMessage("Re enter Password Empty", null);
								request.setAttribute("msgResponse", msgResponse.getSummary());
								return null;
							}
						} else {
							FacesContext.getCurrentInstance().addMessage(null,
									new FacesMessage("Reset Password is Empty"));
							msgResponse = I18nHelper.getMessage("New Password is Empty", null);
							request.setAttribute("msgResponse", msgResponse.getSummary());
							return null;
						}
					} else {
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User Does Not Exist"));
						msgResponse = I18nHelper.getMessage("User Does Not Exist", null);
						request.setAttribute("msgResponse", msgResponse.getSummary());
						return null;
					}
				}
			}

		} catch (Exception e) {
			LOGGER.info("Message :: " + e.toString() + " Cause :: " + e.getCause());
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Password Reset Successfully please go to login page "));
		msgResponse = I18nHelper.getMessage("Password Reset Successfully please go to login page", null);
		request.setAttribute("msgResponse", msgResponse.getSummary());
		return null;
	}

	public String stagingResetPassword_initAction() throws java.text.ParseException {
		FacesContext ctx = FacesContext.getCurrentInstance();
		FacesMessage facesmsg = null;
		String msg = null;
		LOGGER.info("In resetPassword_initAction Method");
		StagingResetPasswordBean passwordBean = (StagingResetPasswordBean) FacesUtils
				.getManagedBean("StagingResetPasswordBean");
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		AutoPopulateBeanHelper.populate(req, passwordBean);

		String usrRfNum = req.getParameter("userLoginId");
		String emailAuthCode = req.getParameter("emailauthcode");
		IsmubiDAO ubiDAO = new IsmubiDAO();
		Ismubi ubiPojo = new Ismubi();
		String encEmailCode = null;

		try {
			// String DecryUbiRfNum =
			// OctashopUtils.getDecreptedData(URLDecoder.decode(usrRfNum, "UTF-8"));
			// String DecryAuthCode = OctashopUtils.getDecreptedData(emailAuthCode);
			String DecryUbiRfNum = OctashopUtils.getDecreptedData(new String(Base64.decodeBase64(usrRfNum)));
			String DecryAuthCode = OctashopUtils.getDecreptedData(new String(Base64.decodeBase64(emailAuthCode)));
			LOGGER.info("user userRefnum >>>" + DecryUbiRfNum);
			if (DecryUbiRfNum != null && !DecryUbiRfNum.equals("")) {
				ubiPojo = ubiDAO.findByPK(new Long(DecryUbiRfNum));
				if (ubiPojo != null) {
					encEmailCode = ubiPojo.getEmailauthcode();
					if (encEmailCode.equals(DecryAuthCode)) {
						if (ubiPojo.getUbilogin() != null && !ubiPojo.getUbilogin().equals("")) {
							passwordBean.setLoginId(ubiPojo.getUbilogin());
						}

						if (ubiPojo.getUbirfnum() != null && !"".equals(ubiPojo.getUbirfnum().toString())) {
							String ecUbiRfnum = Base64.encodeBase64URLSafeString(
									OctashopUtils.getEncryptedData(ubiPojo.getUbirfnum().toString()).getBytes());

							// String ubiRefno =
							// OctashopUtils.getEncryptedEncodedURLParam(ubiPojo.getUbirfnum()+"");
							passwordBean.setUbiRfNum(ecUbiRfnum);
						}
					} else {
						facesmsg = I18nHelper.getMessage("Invalid Link", null);
						LOGGER.info("Invalid Link");
						req.setAttribute("passwordmessage", facesmsg.getSummary());

					}
				} else {
					facesmsg = I18nHelper.getMessage("Invalid User", null);
					LOGGER.info("Invalid user");
					req.setAttribute("Invalid User", facesmsg.getSummary());
				}
			}
		} catch (Exception e) {
			LOGGER.error("Error in reset Password" + e.getMessage());
		}
		return msg;

	}

	public String validateForm(UserLoginBean userLoginBean) {
		String validityform = "T";

		String captchaG = userLoginBean.getCaptchaG();
		String captchaR = userLoginBean.getCaptchaR();

		if (captchaR != null) {

			if (!captchaR.equals(captchaG)) {
				FacesMessage msg = I18nHelper.getMessage("Invalid Captcha", null);
				String message = msg.getSummary();
				userLoginBean.setMessage(message);
				userLoginBean.setAttemptCount(3l);
				return null;
			}

		}

		String id = userLoginBean.getLoginId();
		if (id == null || id.equals("")) {
			FacesMessage msg = I18nHelper.getMessage("Please_enter_loginid", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}
		int Str1 = id.indexOf(' ');
		if (Str1 == 0) {
			FacesMessage msg = I18nHelper.getMessage("Please_do_not_leave_space_before_loginid", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}

		if ((Str1 > 0) && (Str1 < (id.length()))) {
			FacesMessage msg = I18nHelper.getMessage("Please_do_not_use_spaces_loginid", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}

		String password = userLoginBean.getPassword();
		if (password == null || password.toString().equals("")) {
			FacesMessage msg = I18nHelper.getMessage("Please_enter_password", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}

		int str2 = password.indexOf(' ');
		if (str2 == 0) {
			FacesMessage msg = I18nHelper.getMessage("Please_do_not_leave_space_before_pasword", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}

		if ((str2 > 0) && (str2 < (password.length()))) {
			FacesMessage msg = I18nHelper.getMessage("Please_do_not_use_spaces_password", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}

		return validityform;

	}

	public String moduleLogin() {
		String navigation = null;
		try {
			FacesContext ctx = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) ctx.getExternalContext().getRequest();
			HttpServletResponse response = (HttpServletResponse) ctx.getExternalContext().getResponse();
			HttpSession session = request.getSession();
			SessionVariablesBean svb = (SessionVariablesBean) FacesUtils.getManagedBean("SessionVariablesBean");
			String userLoginId = svb.getUserLoginId();
			String userLoginPwd = svb.getUserLoginPassword();
			String contextPath = request.getContextPath();
			String url = "";
			if (OctashopUtils.isEmpty(userLoginId) || OctashopUtils.isEmpty(userLoginPwd)) {
				response.sendRedirect(contextPath + "/faces/commons/userLogin.jsp");
				ctx.responseComplete();
				url = contextPath + "/faces/commons/userLogin.jsp";
				FacesMessage msg = I18nHelper.getMessage("Please_Enter_Valid_User_Id_And_Password", null);
				ctx.addMessage(null, msg);
			} else {
				FacesMessage moduleNameErrorMsg = null;
				FacesMessage errorMsg = null;

				String moduleName = request.getParameter("moduleName");
				String moduleUrl1 = request.getParameter("moduleUrl1");
				String moduleUrl2 = request.getParameter("moduleUrl2");
				if (!OctashopUtils.isEmpty(moduleName)) {
					if ("HOME".equalsIgnoreCase(moduleName)) {
						response.sendRedirect(contextPath + "/faces/commons/welcome.jsp");
						ctx.responseComplete();
					} else if ("EDM".equalsIgnoreCase(moduleName)) {
						/*
						 * StagingLoginBean staging = (StagingLoginBean)
						 * FacesUtils.getManagedBean("StagingLoginBean");
						 * staging.getLoginId().setValue(userLoginId);
						 * staging.getPassword().setValue(userLoginPwd); navigation = new
						 * StagingLoginActionBean().stagingLogin_loginAction();
						 * if("success".equalsIgnoreCase(navigation)){ url = moduleUrl1; } else {
						 * moduleNameErrorMsg = I18nHelper.getMessage("EDM",null); errorMsg =
						 * I18nHelper.getMessage("invalid_user_id_or_password_for_module",new
						 * String[]{moduleNameErrorMsg.getDetail().toString()});
						 * session.setAttribute("nomoduleaccess",errorMsg.getDetail().toString());
						 * response.sendRedirect(contextPath+"/faces/commons/welcome.jsp");
						 * ctx.responseComplete(); }
						 */}

					else if ("OMS".equalsIgnoreCase(moduleName)) {
						/*
						 * ReportLoginBean input =
						 * (ReportLoginBean)FacesUtils.getManagedBean("ReportLoginBean");
						 * input.getUserID().setValue(userLoginId);
						 * input.getPassword().setValue(userLoginPwd); navigation = new
						 * ReportLoginActionBean().reportLogin_submitAction();
						 * if("success".equalsIgnoreCase(navigation)){ url = moduleUrl1; } else{
						 * moduleNameErrorMsg = I18nHelper.getMessage("OMS",null); errorMsg =
						 * I18nHelper.getMessage("invalid_user_id_or_password_for_module",new
						 * String[]{moduleNameErrorMsg.getDetail().toString()});
						 * session.setAttribute("nomoduleaccess",errorMsg.getDetail().toString());
						 * response.sendRedirect(contextPath+"/faces/commons/welcome.jsp");
						 * ctx.responseComplete(); }
						 */}

					else if ("USER".equalsIgnoreCase(moduleName)) {
						/*
						 * StagingLoginBean staging = (StagingLoginBean)
						 * FacesUtils.getManagedBean("StagingLoginBean");
						 * staging.getLoginId().setValue(userLoginId);
						 * staging.getPassword().setValue(userLoginPwd); navigation = new
						 * StagingLoginActionBean().stagingLogin_loginAction();
						 * if("success".equalsIgnoreCase(navigation)){ url = moduleUrl1; } else {
						 * moduleNameErrorMsg = I18nHelper.getMessage("USER",null); errorMsg =
						 * I18nHelper.getMessage("invalid_user_id_or_password_for_module",new
						 * String[]{moduleNameErrorMsg.getDetail().toString()});
						 * session.setAttribute("nomoduleaccess",errorMsg.getDetail().toString());
						 * response.sendRedirect(contextPath+"/faces/commons/welcome.jsp");
						 * ctx.responseComplete(); }
						 */} else if ("LOGOUT".equalsIgnoreCase(moduleName)) {
						svb.setUserLoginId(null);
						svb.setUserLoginPassword(null);
						svb.setUserRefNo(null);
						svb.setIpAddress(null);
						session.invalidate();
						FacesMessage msg = I18nHelper.getMessage("User_Logout_Successfully", null);
						ctx.addMessage(null, msg);
						response.sendRedirect(contextPath + "/faces/commons/userLogin.jsp");
						ctx.responseComplete();
					} else if ("MP".equalsIgnoreCase(moduleName)) {
						StagingLoginBean staging = (StagingLoginBean) FacesUtils.getManagedBean("StagingLoginBean");
						staging.getLoginId().setValue(userLoginId);
						staging.getPassword().setValue(userLoginPwd);
						navigation = new StagingLoginActionBean().stagingLogin_loginAction(request.getRemoteAddr());
						if ("success".equalsIgnoreCase(navigation)) {
							url = moduleUrl1;
						} else {
							moduleNameErrorMsg = I18nHelper.getMessage("EDM", null);
							errorMsg = I18nHelper.getMessage("invalid_user_id_or_password_for_module",
									new String[] { moduleNameErrorMsg.getDetail().toString() });
							session.setAttribute("nomoduleaccess", errorMsg.getDetail().toString());
							navigation = "goToWelcomePage";
						}
					} else if ("SECURITY".equalsIgnoreCase(moduleName)) {
						url = moduleUrl1;
					}
				} else {
					response.sendRedirect(contextPath + "/faces/commons/userLogin.jsp");
					ctx.responseComplete();
				}
			}

			if ("goToCommonLoginPage".equalsIgnoreCase(navigation)) {
				url = contextPath + "/faces/commons/userLogin.jsp";
			} else if ("goToWelcomePage".equalsIgnoreCase(navigation)) {
				url = contextPath + "/faces/commons/welcome.jsp";
			}
			if (!OctashopUtils.isEmpty(url)) {
				svb.setModuleHomeLink(url);
				ctx.getExternalContext().redirect(url);
			}

		} catch (Exception e) {
			LOGGER.info("Message :: " + e.toString() + " Cause :: " + e.getCause());
		}
		return navigation;
	}

	public void setIsDisplayReports() {
		try {
			OctParam param = octparamDao.findByParamgroupAndParamcode("REPORTS_AUTHORIZATION", "REPORTS");
			OctParam paramForLink = octparamDao.findByParamgroupAndParamcode("REPORTS_AUTHORIZATION", "REPORTSWITHLINK");
			String isreportdisable = env.getProperty("reportdisable");
			String isreportdisableR2 = env.getProperty("reportdisableR2");
			// from DB
			if (!OctashopUtils.isObjectEmpty(param)) {
				if (!OctashopUtils.isEmpty(param.getParamvalue())) {
					svb.setIsDisplayReports(param.getParamvalue().trim());
					svb.setIsDisplayReportsR2(param.getParamvalue().trim());
				}
			} else {
				svb.setIsDisplayReports("Y");
				svb.setIsDisplayReportsR2("Y");
			}

			if (!OctashopUtils.isObjectEmpty(paramForLink)) {
				if (!OctashopUtils.isEmpty(paramForLink.getParamvalue())) {
					svb.setIsDisplayReportsForLink(paramForLink.getParamvalue().trim());
					svb.setIsDisplayReportsR2ForLink(paramForLink.getParamvalue().trim());
				}
			} else {
				svb.setIsDisplayReportsForLink("Y");
				svb.setIsDisplayReportsR2ForLink("Y");
			}

			// from App config
			if (!OctashopUtils.isEmpty(isreportdisable)) {
				if ("Y".equalsIgnoreCase(isreportdisable)) {
					svb.setIsDisplayReports("N");
					svb.setIsDisplayReportsForLink("N");
				} else {
					svb.setIsDisplayReports("Y");
					svb.setIsDisplayReportsForLink("Y");
				}
			}
			//// from App config for R2
			if (!OctashopUtils.isEmpty(isreportdisableR2)) {
				if ("Y".equalsIgnoreCase(isreportdisableR2)) {
					svb.setIsDisplayReportsR2("N");
					svb.setIsDisplayReportsR2ForLink("N");
				} else {
					svb.setIsDisplayReportsR2("Y");
					svb.setIsDisplayReportsR2ForLink("Y");
				}
			}

		} catch (Exception e) {
			System.out.println(e);

		}
	}

	public void setPageAuthDetails(Long userId) {
		try {
			List pageList = ismacrDao.findByUserIdOrCommandOrPagename(userId,null,null);
			if (pageList != null && !pageList.isEmpty()) {
				LinkedHashMap<String, String> pageMap = new LinkedHashMap<>();
				for (int i = 0; i < pageList.size(); i++) {
					Object[] obj = (Object[]) pageList.get(i);
					if (OctashopUtils.isNotEmpty(obj)) {
						if (pageMap.get(obj[0].toString()) != null) {
							pageMap.put(obj[0].toString(), pageMap.get(obj[0].toString()) + "," + obj[1].toString());
						} else {
							pageMap.put(obj[0].toString(), obj[1].toString());
						}
					}
				}
				svb.setPageAuth(pageMap);
			}

		} catch (Exception e) {

		}
	}

	public void setSlrTypeUrl(String slrCode) {
		try {
			Object[] imgRating = slrscoreDao.findImgUrl(slrCode, "7");
			if (OctashopUtils.isNotEmpty(imgRating)) {
				svb.setSlrTypeLogoUrl("Your score: " + imgRating[3].toString() + " out of 5 ");
				svb.setSlrRatingType(" Click here to download detailed report");
				svb.setSlrRatingPdf(imgRating[2].toString());
			}
		} catch (Exception e) {

		}
	}

	public String checkForContactInfoUpdate(Date contactInfoLastModifiedDate, Long periodicPromptInterval) {
		LOGGER.info("inside UserLoginActionBean checkForContactInfoUpdate() for Slave");
		LocalDate contactInfoLastUpdatedDate = null;
		LocalDate currentDateMinusPromptInterval = null;
		String isPeriodicPromptRequired = "N";

		try {
			contactInfoLastUpdatedDate = contactInfoLastModifiedDate.toInstant().atZone(ZoneId.systemDefault())
					.toLocalDate();
			currentDateMinusPromptInterval = LocalDate.now().minusDays(periodicPromptInterval);

			LOGGER.info("Slave Contact Details Last Updated on :-- " + contactInfoLastUpdatedDate + "----"
					+ "Date post Prompt Interval calculation :-- " + currentDateMinusPromptInterval + "----"
					+ " Periodic Prompt Interval :-- " + periodicPromptInterval);

			if (contactInfoLastUpdatedDate.isBefore(currentDateMinusPromptInterval)) {
				isPeriodicPromptRequired = "Y";
			}
		} catch (Exception exception) {
			LOGGER.error("Message :: " + exception.toString() + " Cause :: " + exception.getCause());

		}
		LOGGER.info("UserLoginActionBean checkForContactInfoUpdate() for Slave execution completed");
		return isPeriodicPromptRequired;
	}
}