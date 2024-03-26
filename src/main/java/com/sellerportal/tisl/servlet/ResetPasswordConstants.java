package com.sellerportal.tisl.servlet;

public class ResetPasswordConstants {

	public static final String FAILURE_RESPONSE_KEY = "failure";
	public static final String SUCCESS_RESPONSE_KEY = "success";
	public static final String LOGIN_ID_NOT_FOUND = "Provided user id Not found";
	public static final String NOT_A_MP_USER = "Provided user is not a Marketplace user";
	public static final String NOT_A_VALID_PASSWORD = "Provided password is not as per guidelines";
	public static final String INVALID_LOGIN_ID = "Provided Login id or password can't be null or empty";
	public static final String ERROR_CODE_101 = "101";
	public static final String ERROR_CODE_102 = "102";
	public static final String ERROR_CODE_103 = "103";
	public static final String ERROR_CODE_104 = "104";
	public static final String ERROR_CODE_105 = "105";
	public static final String SLASH_SYMBOL = "/";
	public static final String RESET_PASSWORD_FOR_MP_USERS = "resetPasswordForMpUsers";
	public static final Long MARKETPLACE_USER_TYPE = 1L;
	public static final String YES = "Y";
	public static final String NO = "N";
	public static final String DEFAULT_START_DATE = "01/01/2001";
	public static final String SIMPLE_DATE_FORMAT = "dd/MM/yyyy";
	public static final int EXPIRY_DATE_DURATION = 180;
	public static final String MAX_ALLOWED_USER_COUNT_PROPERTY_KEY = "resetPasswordApi.max.allowed.user.count";
}
