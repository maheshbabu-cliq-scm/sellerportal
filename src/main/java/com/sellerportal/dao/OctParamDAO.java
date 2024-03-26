/* 
 * Auto Generated on Mon Mar 02 14:59:59 IST 2015
 *
 * Copyright (c) 2005, Anmsoft Technologies Pvt. Ltd.
 * All rights reserved.
 *
 * Unit No. 219-220, Building No. 2, Sector-1, 
 * Millennium Business Park,
 * Mahape, Navi Mumbai - 400710, INDIA.
 * Tel: +912227782326/27782327
 */
package com.sellerportal.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import com.anm.hibernate.DAOException;
import com.anm.hibernate.HibernateConnection;
import com.anm.hibernate.SuperDAO;
import com.sellerportal.model.OctParam;
import com.sellerportal.model.OctSlr;





//import com.anm.integra.impl.octashop.utils.OctashopUtils;   

/**
 * 
 *
 * Generated DAO Class for oct_param Table.
 *
 * All Queries related to this table should be here.
 * NOTE: 
 *	Do not put user defined queries in the generated DAO class. 
 *	USE hibernate-dao-oct_param-class-code.txt
 * */
@SuppressWarnings("squid:S2583")
public class OctParamDAO extends SuperDAO
{
	
	/**
	 * Find object by primary key.
	 * @param pk the pk of the object to find.
	 */
	public  OctParam findByPK( Serializable pk ) throws com.anm.hibernate.DAOException
	{
		OctParam retval = null;
		retval = (OctParam)super.findByPk( pk );
		return retval;
	}


	/**
	 * @param obj
	 * @return
	 */
	protected Criteria createCriteria(Object object) {
		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
		Criteria criteria = hibSession.createCriteria(OctParam.class);

		OctParam obj = (OctParam)object;



		//Pk getParamrfnum
		if (obj.getParamrfnum() != null) {
			criteria.add(Expression.eq("paramrfnum", obj.getParamrfnum()));
		}

		//Set the many2one and one2one relation objects

		return criteria;
	}

	public OctParam findUserTypeList(Long rfNum) {
		Session hibSession = null;
		OctParam retObj=null;
		List retvallist = null;        
		try
		{	
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			if(rfNum!=null){
				query=hibSession.createQuery("From OctParam oct where oct.paramrfnum >="+ rfNum );
				retvallist=query.list();
			}
			if (retvallist != null && retvallist.size() > 0 )
				retObj = (OctParam) retvallist.get(0);
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return retObj;
	}

	public List getParamsByParamGroup(String groupName){
		Session hibSession = null;
		List retvallist = new ArrayList();        
		try
		{	
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			if(groupName != null){
				query=hibSession.createQuery("select paramrfnum,paramvalue from OctParam oct where oct.paramgroup=:groupName");
				query.setString("groupName" ,groupName);
				retvallist=query.list();
			}	
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return retvallist;
	} 





	public List getParamsByParamGroup1(String groupName){
		Session hibSession = null;
		List retvallist = new ArrayList();        
		try
		{	
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			if(groupName != null){
				query=hibSession.createQuery("select paramvalue,paramvalue from OctParam oct where oct.paramgroup=:groupName");
				query.setString("groupName" ,groupName);
				retvallist=query.list();
			}	
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return retvallist;
	} 












	public List getParamsByParamGroupPeriod(String groupName){
		Session hibSession = null;
		List retvallist = new ArrayList();        
		try
		{	
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			if(groupName != null){
				query=hibSession.createQuery("select paramrfnum, concat(paramcode,'-',paramdesc) from OctParam oct where oct.paramgroup=:groupName and deleted !='Y'");
				query.setString("groupName" ,groupName);
				retvallist=query.list();
			}	
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return retvallist;
	} 
	
	public List getOctParamByParamGroup(String groupName, String isITRFiled){
		Session hibSession = null;
		List retvallist = new ArrayList();        
		try
		{	
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			if(groupName != null){
				if(isITRFiled.equals("Y")) {
					query=hibSession.createQuery("from OctParam oct where oct.paramgroup=:groupName and deleted !='Y' "
							+ "and paramcode in ('C3','E1','G1','T2')");
				}
				else {
					query=hibSession.createQuery("from OctParam oct where oct.paramgroup=:groupName and deleted !='Y' "
							+ "and paramcode in ('P3','E4','G5','T3')");
				}
				query.setString("groupName" ,groupName);
				retvallist=query.list();
			}	
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return retvallist;
	} 



	public List getSlvTypeByParamGroup(String groupName){
		Session hibSession = null;
		List retvallist = new ArrayList();        
		try
		{	
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			if(groupName != null){
				query=hibSession.createQuery("select paramrfnum, paramvalue from OctParam oct where oct.paramgroup=:groupName");
				query.setString("groupName" ,groupName);
				retvallist=query.list();
			}

		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return retvallist;
	} 

	/**
	 	@author pramod
		@see To obtain the list of Object Type OctParam based on GROUP CODE & CODE 
	 **/
	@SuppressWarnings("unchecked")
	public OctParam findPojoByParamGroupNCode(String paramGroup ,String paramCode){
		Session hibSession = null;
		OctParam param = null;
		try
		{	
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			if(paramGroup != null && paramCode != null){
				query=hibSession.createQuery(" from OctParam oct where oct.paramgroup=:groupName and oct.paramcode=:paramcode ");
				query.setString("groupName" ,paramGroup);
				query.setString("paramcode" ,paramCode);
				param = (OctParam) query.uniqueResult();
			}
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return param;
	}


	/**
 	@author pramod
	@see To obtain the list of PK based on GROUP CODE & CODE 
	 **/
	public List<Long> findByParamGroupNCodes(String paramGroup ,List<String> paramCodeList){
		Session hibSession = null;
		List<Long> paramRfList = null;
		try{	
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			if(paramGroup != null && paramCodeList != null && paramCodeList.size() > 0 ){
				query=hibSession.createQuery("select oct.paramrfnum from OctParam oct where oct.paramgroup=:groupName and oct.paramcode in(:paramcodes) ");
				query.setString("groupName" ,paramGroup);
				query.setParameterList("paramcodes" ,paramCodeList);
				paramRfList = query.list();
			}
		}catch( HibernateException e){
			throw new DAOException( e );
		}
		return paramRfList;
	}

	/** (non-Javadoc)
	 * @see com.anm.hibernate.SuperDAO#getPojoObj()
	 */



	protected Object getPojoObj() {  

		return new OctParam();

	}

	/**
	 * @return Octparamgroup List 
	 * @return List
	 * @throws DAOException
	 */

	public List findByAllGroup() throws DAOException {
		List groupList = null;
		Session hibSession = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select distinct(param.paramgroup) from OctParam param where param.deleted='N' order by param.paramgroup");
			groupList = query.list();
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		} finally {

		}
		return groupList;
	}
	/*return parameter master list*/
	public List findParamMastersByCondition(String parameterGroup, String parameterCode, String parameterValue)
			throws DAOException {
		Session hibSession = null;
		boolean flag=false;
		String sqlQuery = "select distinct(param) from OctParam param";

		sqlQuery = sqlQuery + " where ";
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			if(parameterGroup != null)
			{
				flag=true;
				sqlQuery=sqlQuery+"param.paramgroup= :parameterGroup";
			}
			if(parameterCode != null)
			{ 
				if(flag)
					sqlQuery = sqlQuery + " and ";
				else
					flag=true;
				sqlQuery = sqlQuery + "  param.paramcode= :parameterCode ";

			}
			if(parameterValue != null)
			{ 
				if(flag)
					sqlQuery = sqlQuery + " and ";
				else
					flag=true;
				sqlQuery = sqlQuery + "  param.paramvalue= :parameterValue ";

			}		

			sqlQuery = sqlQuery + " and param.deleted ='N' order by param.paramrfnum desc";
			Query query = hibSession.createQuery( sqlQuery);

			if(parameterGroup != null)
			{
				flag=true;
				query.setString("parameterGroup" , parameterGroup);
			}
			if(parameterCode != null)
			{ 
				if(flag)
				{}
				else
					flag=true;
				query.setString("parameterCode" , parameterCode);

			}
			if(parameterValue != null)
			{ 
				if(flag)
				{}
				else
					flag=true;
				query.setString("parameterValue" , parameterValue);
			}

			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public int deleteOctParam(long octrfnum) {
		Session hibSession = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "UPDATE OctParam param set param.deleted = 'Y' WHERE param.paramrfnum = :octsparamrfnum";
			Query query =hibSession.createQuery(queryString).setParameter("octsparamrfnum",octrfnum);
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);
			return result;
		}catch (HibernateException e) {
			throw new DAOException(e);
		}
		finally
		{

		}


		//return 0;
	}



	public String findParamValue(Long user){
		List retVal=null;
		Session hibSession=null;
		String roleName=null;
		Query query=null;
		try{
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			query=hibSession.createQuery("select paramvalue From OctParam oct where oct.paramrfnum =:user");
			query.setLong("user", user);
			retVal=query.list();
		}catch(HibernateException e){
			e.printStackTrace();
		}
		if(retVal!=null && retVal.size()>0){
			roleName = (String)retVal.get(0);
		}
		return roleName;
	}

	public static  Long findParamId(String userType){
		List retVal=null;
		Query query=null;
		Long rfNum=null;
		try{
			Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
			query = hibSession.createQuery("select oct.paramrfnum from OctParam oct where oct.paramdesc=:userType");
			query.setString("userType", userType);
			retVal=query.list();
		}catch(HibernateException e){
			e.printStackTrace();
		}	
		if(retVal!=null && retVal.size()>0)	
			rfNum=(Long)retVal.get(0);
		return rfNum;
	}

	public List editParam(long paramrfnum){
		List retVal=null;
		Query query=null;
		try{
			Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
			query = hibSession.createQuery("from OctParam oct where oct.paramrfnum=:octsparamrfnum");
			query.setParameter("octsparamrfnum", paramrfnum);
			retVal=query.list();
		}catch(HibernateException e){
			e.printStackTrace();
		}	

		return retVal;
	}



	public OctParam findObjectByParamVal(String paramCode){
		Session hibSession = null;
		OctParam param = null;
		try
		{	
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			query=hibSession.createQuery(" from OctParam oct where oct.paramvalue=:paramCode");
			query.setString("paramCode" ,paramCode);
			param = (OctParam) query.uniqueResult();
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return param;
	}

	public OctParam findObjectByParamCode(String paramCode){
		Session hibSession = null;
		OctParam param = null;
		try
		{	
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			query=hibSession.createQuery("from OctParam oct where oct.paramcode=:paramCode");
			query.setString("paramCode" ,paramCode);
			param = (OctParam) query.uniqueResult();
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return param;
	}


	public List<OctParam> findByGroup(String groupName) {
		List<OctParam> retVal=null;
		Query query=null;
		try{
			Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
			query = hibSession.createQuery("from OctParam oct where oct.paramgroup=:groupName and oct.deleted='N'");
			query.setParameter("groupName", groupName);
			retVal=query.list();
		}catch(HibernateException e){
			e.printStackTrace();
		}	
		return retVal;
	}


	public static List<OctParam> findUserLevels(String userType){
		List<OctParam> retval=null;
		try{
			Session hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=hibSession.createQuery("from OctParam param1 where param1.paramgroup ='USER_PRIVILIGE_LEVEL'"
					+ " and param1.paramvalue>= (select param2.paramvalue from OctParam param2 where"
					+ " param2.paramgroup ='USER_PRIVILIGE_LEVEL' and param2.paramdesc=:userType)");

			query.setString("userType", userType);
			retval=query.list();
		}catch(HibernateException e){
			e.printStackTrace();
		}
		return retval;
	}

	public static OctParam findUserDetails(String userType){
		OctParam param = null;
		try{
			Session hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=hibSession.createQuery("from OctParam oct where oct.paramgroup ='USER_PRIVILIGE_LEVEL' and "
					+ "oct.paramdesc=:userType");
			query.setString("userType", userType);
			param = (OctParam) query.uniqueResult();
		}catch(HibernateException e){
			e.printStackTrace();
		}
		return param;
	}

	public static OctParam findRoles(String userType){
		OctParam paramObj=null;
		List retVal=null;
		List<OctParam> retval = null;
		String val="";
		try{
			Session hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query1=hibSession.createQuery("select paramcode from OctParam where paramdesc=:userType and paramgroup='USER_PRIVILIGE_LEVEL'");
			query1.setString("userType", userType);
			retVal=query1.list();
			if(retVal != null && retVal.size()>0){
				val=(String)retVal.get(0);
			}

			Query query2=hibSession.createQuery("from OctParam where paramgroup='USER_TYPE_STATUS_ROLE' and paramcode like :val");
			query2.setParameter("val","%"+val+"%"); 
			retval=query2.list();
			if (retval.size() > 0 )
				paramObj = (OctParam) retval.get(0);
		}catch(HibernateException e){
			e.printStackTrace();
		}
		return paramObj;
	}



	public static List<OctParam> getApprovalList() throws DAOException {
		List<OctParam> groupList = null;
		Session hibSession = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query=hibSession.createQuery("from OctParam where paramgroup='APPROVAL_LEVEL_GROUP'");
			groupList = query.list();
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		} finally {

		}
		return groupList;
	}
	public  List<OctParam> findRfNum(){
		List<OctParam> retval=null;
		try{
			Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query=hibSession.createQuery("from OctParam where paramgroup='APPROVAL_LEVEL_GROUP'");
			retval = query.list();
		}catch(HibernateException e){
			e.printStackTrace();
		}
		return retval;
	}

	public OctParam findParamRfNumByParamCode(String paramCode){
		OctParam rfNum=null;
		List<OctParam> retval=null;
		try{
			Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query=hibSession.createQuery("from OctParam where paramcode=:paramCode");
			query.setString("paramCode", paramCode);
			retval=query.list();
			if(retval!=null && retval.size()>0)
				rfNum=(OctParam)retval.get(0);
		}catch(HibernateException e){
			throw new  DAOException(e);
		}
		return rfNum;

	}

	//Kanchan :: Added to retrieve product status list using group
	@SuppressWarnings("unchecked")
	public List<OctParam> findPojoByParamGroup(String paramGroup) {
		Session hibSession = null;
		List<OctParam> statusList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = null;
			if (paramGroup != null) {
				query = hibSession
						.createQuery(" from OctParam oct where oct.paramgroup=:groupName ");
				query.setString("groupName", paramGroup);
				statusList = query.list();
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return statusList;
	}



	public OctParam findUserType(Long rfNum) {
		Session hibSession = null;
		OctParam retObj=null;
		List<OctParam> retvallist = null;        
		try
		{	
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			if(rfNum!=null){
				query=hibSession.createQuery("From OctParam oct where oct.paramrfnum =:rfNum");
				query.setLong("rfNum",rfNum);
				retvallist=query.list();
			}
			if (retvallist != null && retvallist.size() > 0 )
				retObj = (OctParam) retvallist.get(0);
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return retObj;
	}

	public List<OctParam> findByParamGroup(String paramGroup){
		Session hibSession = null;
		List<OctParam> statusList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = null;
			if (paramGroup != null) {
				query = hibSession.createQuery(" from OctParam param where param.paramgroup=:groupName order by param.paramvalue");
				query.setString("groupName", paramGroup);
				statusList = query.list();
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return statusList;
	}

	public OctParam findUserTypeByParamCode(String paramCode){
		Session hibSession = null;
		OctParam param = null;
		try
		{	
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			query=hibSession.createQuery(" from OctParam oct where oct.paramcode=:paramCode and paramgroup='USER_TYPE'");
			query.setString("paramCode" ,paramCode);
			param = (OctParam) query.uniqueResult();
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return param;
	}

	public OctParam findByParamGroupCode(String paramGroup,String paramCode){
		Session hibSession = null;
		OctParam param = null;
		List tmpList = null;
		try{
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			query=hibSession.createQuery(" from OctParam oct where oct.paramcode=:paramCode and paramgroup=:paramGroup");
			query.setString("paramCode" ,paramCode);
			query.setString("paramGroup" ,paramGroup);
			tmpList = query.list();
		}catch( HibernateException e){
			throw new  DAOException( e );
		} finally {
			HibernateConnection.commitTransaction();
		}
		if(tmpList != null && tmpList.size() > 0){
			param = (OctParam)tmpList.get(0);
		}
		return param;
	}
	public List<String> findParamValueByUserType(String userType){
		Session hibSession = null;
		List param = null;
		try
		{	
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			query=hibSession.createQuery("select paramvalue from OctParam oct where paramgroup='USER_TYPE_STATUS_ROLE' and paramcode =:userType");
			query.setString("userType" ,userType);
			param=query.list();
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return param;
	}

	public OctParam findParamUser(String userType){
		Session hibSession = null;
		OctParam paramObj=null;
		List param = null;
		try
		{	
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			query=hibSession.createQuery("from OctParam oct where paramgroup='USER_TYPE_STATUS_ROLE' and paramcode =:userType");
			query.setString("userType" ,userType);
			param=query.list();
			paramObj=(OctParam)param.get(0);
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return paramObj;
	}

	public OctParam findSlaveRoles(){
		List retVal=null;
		OctParam paramObj=null;
		Session hibSession = null;
		try{
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			query=hibSession.createQuery("from OctParam oct where paramgroup='USER_TYPE_STATUS_ROLE' and paramcode ='SLV_AD'");
			retVal=query.list();
			if(retVal!=null){
				paramObj=(OctParam)retVal.get(0);
			}
		}catch(HibernateException e){
			throw new  DAOException(e);
		}
		return paramObj;
	}


	public OctParam findbyParamgroupAndParamvalue(String paramGroup, String paramValue) {
		Session hibSession = null;
		OctParam param = null;
		List retList=new ArrayList();
		try{	
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			query=hibSession.createQuery(" from OctParam oct where oct.paramgroup=:paramGroup and oct.paramvalue=:paramValue");
			query.setString("paramValue" ,paramValue);
			query.setString("paramGroup" ,paramGroup);
			retList=query.list();
			if(retList!=null && retList.size()>0)
				param=(OctParam) retList.get(0);
		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return param;
	}


	public OctParam findUserTypeByParamDesc(String paramDesc){
		Session hibSession = null;
		OctParam param = null;
		try
		{	
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			query=hibSession.createQuery(" from OctParam oct where oct.paramdesc=:paramDesc and paramgroup='USER_TYPE'");
			query.setString("paramDesc" ,paramDesc);
			param = (OctParam) query.uniqueResult();
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return param;
	}

	public List findfailList() {
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select distinct  oct.paramdesc, oct.paramcode From OctParam oct where oct.paramgroup='REJECTION_REASON'";
			Query query = hibSession.createQuery(queryString);
			retvalList = query.list();

		} catch (HibernateException e) {
			throw new DAOException(e);
		}finally{		
		}
		return retvalList;
	}

	public List findRTOReasonList() {
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select distinct  oct.paramdesc, oct.paramcode From OctParam oct where oct.paramgroup='RETURN_TO_ORIGIN_REASON'";
			Query query = hibSession.createQuery(queryString);
			retvalList = query.list();

		} catch (HibernateException e) {
			throw new DAOException(e);
		}finally{		
		}
		return retvalList;
	}

	public List findLITfailList() {
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select distinct  oct.paramdesc, oct.paramcode From OctParam oct where oct.paramgroup='LIT_REASON'";
			Query query = hibSession.createQuery(queryString);
			retvalList = query.list();

		} catch (HibernateException e) {
			throw new DAOException(e);
		}finally{		
		}
		return retvalList;

	}

	public List findLITReasonList() {
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select distinct  oct.paramdesc, oct.paramcode From OctParam oct where oct.paramgroup='LOST_IN_TRANSIT_REASON'";
			Query query = hibSession.createQuery(queryString);
			retvalList = query.list();

		} catch (HibernateException e) {
			throw new DAOException(e);
		}finally{		
		}
		return retvalList;

	}


	public List findReturnReasonList() {
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select distinct  oct.paramdesc, oct.paramcode From OctParam oct where oct.paramgroup='RETURN_REASON'";
			Query query = hibSession.createQuery(queryString);
			retvalList = query.list();

		} catch (HibernateException e) {
			throw new DAOException(e);
		}finally{		
		}
		return retvalList;

	}

	public List findTicketTypeList() {
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select distinct  oct.paramdesc, oct.paramcode From OctParam oct where oct.paramgroup='TICKET_TYPE'";
			Query query = hibSession.createQuery(queryString);
			retvalList = query.list();

		} catch (HibernateException e) {
			throw new DAOException(e);
		}finally{		
		}
		return retvalList;

	}


	public List findParam(String paramCode) {
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "from OctParam param where paramcode=:paramCode";
			Query query = hibSession.createQuery(queryString);
			query.setString("paramCode", paramCode);
			retvalList = query.list();

		} catch (HibernateException e) {
			throw new DAOException(e);
		}finally{		
		}
		return retvalList;
	}

	public OctParam findCategory() {
		OctParam obj=null;
		List retvalList = null;
		Session hibSession = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "from OctParam param where paramgroup='ELECTRONICS'";
			Query query = hibSession.createQuery(queryString);
			retvalList=query.list();
			if(retvalList.size()>0){
				obj = (OctParam)retvalList.get(0);
			}
		}catch(HibernateException e){
			e.printStackTrace();
		}
		return obj;
	}

	public List getParamsByParamGroupMinIndicator(String groupName){
		Session hibSession = null;
		List retvallist = new ArrayList();        
		try
		{	
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			if(groupName != null){
				query=hibSession.createQuery("select paramrfnum, concat(paramcode,'-',paramdesc) from OctParam oct where oct.paramgroup=:groupName");
				query.setString("groupName" ,groupName);
				retvallist=query.list();
			}	
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return retvallist;
	}

	public List<OctParam> findByParamGroupAndVal(String paramGroup, String paramVal){
		Session hibSession = null;
		List<OctParam> statusList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = null;
			if (paramGroup != null && paramVal != null) {
				query = hibSession
						.createQuery(" from OctParam param where param.paramgroup=:groupName and param.paramvalue = :val");
				query.setString("groupName", paramGroup);
				query.setString("val", paramVal);
				statusList = query.list();
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return statusList;
	}
	public List findByGroupAndCode(String paramGroup ,String paramCode) {
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "from OctParam param where param.paramgroup=:paramGroup and param.paramcode = :paramCode";
			Query query = hibSession.createQuery(queryString);
			query.setString("paramGroup", paramGroup);
			query.setString("paramCode", paramCode);
			retvalList = query.list();

		} catch (HibernateException e) {
			throw new DAOException(e);
		}finally{		
		}
		return retvalList;
	}

	/* Added by Jitendra for verify the user authentication code */
	public OctParam isExistsSecurityAuthCode(String authCode) {
		Session hibSession = null;
		OctParam octParam = null;
		List retvallist = new ArrayList();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = null;
			if (authCode != null) {
				query = hibSession.createQuery("from OctParam param where param.paramvalue=:authCode");
				query.setString("authCode", authCode);
				retvallist = query.list();
				if (retvallist.size() > 0) {
					octParam = (OctParam) retvallist.get(0);
				}
			}		
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return octParam;
	}

	public List<OctParam> findAllTicketType() {
		Session hibSession = null;
		List<OctParam> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "from OctParam param where param.paramgroup ='TICKET_TYPE'";
			Query query = hibSession.createQuery(queryString);

			retvalList = query.list();

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}

	public List<OctParam> findSlrConsumerChargeTax() {
		Session hibSession = null;
		List<OctParam> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "from OctParam param where param.paramvalue ='Sales Tax' or param.paramvalue ='Service Tax'";
			Query query = hibSession.createQuery(queryString);

			retvalList = query.list();

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}


	public List<Object> findValueByParamcode(String paramcode){
		OctSlr obj=null;
		Session hibSession = null;
		List<Object> result=null;
		try{

			String queryString="select param.paramvalue from OctParam param where param.paramcode=:ParamCode";
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery(queryString); 
			query.setString("ParamCode", paramcode.trim());
			result= query.list();

		}catch(Exception e){
		}
		return result;
	}


	public List<Object> findDetailByParamGroupCode(String paramGroup,List paramCodelist){
		OctSlr obj=null;
		Session hibSession = null;
		List<Object> result=null;
		try{
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			query=hibSession.createQuery("select oct.paramcode,oct.paramrfnum from OctParam oct where oct.paramcode IN(:paramCodelist) and paramgroup=:paramGroup");
			query.setParameterList("paramCodelist" ,paramCodelist);
			query.setString("paramGroup" ,paramGroup);
			result = query.list();
		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return result;
	}

	/*****************@ Gulab Start For SellerDashboard Report***************/
	public List<String> findByParamRfNum(String Paramrfnum) {
		Session hibSession = null;
		List<String> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select param.paramcode from OctParam param where param.paramrfnum =:Paramrfnum";
			Query query = hibSession.createQuery(queryString);
			query.setLong("Paramrfnum", new Long(Paramrfnum));
			retvalList = query.list();

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}


	public List<String> findbyparamCode(String fulfillmenttype) throws DAOException {
		Session hibSession = null;
		List<String> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession
					.createQuery("select param.paramrfnum from OctParam param where param.paramcode in ("+fulfillmenttype+")");
			retvalList = query.list();
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		} 
		return retvalList;
	}
	public List<String> findbyparamCode1(String fulfillmenttype) throws DAOException {
		Session hibSession = null;
		List<String> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select param.paramrfnum from OctParam param where param.paramcode  =:fulfillmenttype");
			query.setString("fulfillmenttype", fulfillmenttype);
			retvalList = query.list();
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		} 
		return retvalList;
	}

	/*****************@ Gulab End For SellerDashboard Report***************/

	public List<Object> findDetailByParamRef(Long paramrfnum){
		OctSlr obj=null;
		Session hibSession = null;
		List<Object> result=null;
		try{
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			query=hibSession.createQuery("select oct.paramcode,oct.paramrfnum from OctParam oct where oct.paramrfnum=:paramGroup");
			query.setLong("paramGroup" ,paramrfnum);
			result = query.list();
		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return result;
	}  	


	/*****************@ Gulab Start R3***************/
	@SuppressWarnings("rawtypes")
	public OctParam findbyparamcode(String paramcode){
		Session hibSession = null;
		OctParam octParam = null;
		List retvallist = new ArrayList();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = null;

			query = hibSession.createQuery("from OctParam param where param.paramcode=:paramcode");
			query.setString("paramcode", paramcode);
			retvallist = query.list();
			if (retvallist.size() > 0) {
				octParam = (OctParam) retvallist.get(0);
			}

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return octParam;
	}

	public List<Object []> findObjectByParamGroup(String paramGroup){
		Session hibSession = null;
		List<Object []> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = null;
			if (paramGroup != null) {
				query = hibSession
						.createQuery("select paramrfnum,paramcode,paramvalue from OctParam  where paramgroup=:groupName order by paramvalue");
				query.setString("groupName", paramGroup);
				retvalList = query.list();
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}

	/*****************@ Gulab End R3***************/

	//@Raju OPTIMIZATION
	public List<OctParam> findRTSRefundByGroup(String groupNameList) {
		List<OctParam> retVal=null;
		Query query=null;
		try{
			Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
			query = hibSession.createQuery("from OctParam oct where oct.paramgroup IN("+groupNameList+") and oct.deleted='N'");
			retVal=query.list();
		}catch(HibernateException e){
			e.printStackTrace();
		}	
		return retVal;
	}

	public List<Object> getServiceCode(String paramGroup){

		Session hibSession = null;
		List<Object> retVal=null;
		try{
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			query=hibSession.createQuery("select oct.paramcode,oct.paramdesc from OctParam oct where oct.paramgroup =:paramGroup");
			query.setString("paramGroup",paramGroup);
			retVal = query.list();
		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return retVal;
	}

	public String findByserviceCode(String serviceCode) {
		Session hibSession = null;
		String ServiceCode = null;
		List retvalList= null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "Select paramcode from OctParam where paramcode =:serviceCode ";
			Query query = hibSession.createQuery(queryString);
			query.setParameter("serviceCode", serviceCode);

			retvalList = query.list();
			if(!retvalList.isEmpty()){
				ServiceCode = retvalList.get(0)+"";
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return ServiceCode;
	}
	//@nikhil Fashion Jewellery:START
	public List<OctParam> paramValues(String paramcode)
	{
		Session hibSession = null;
		OctParam octParam = null;
		List retvallist = new ArrayList();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = null;
			query=hibSession.createQuery("from OctParam oct where oct.paramcode=:paramcode");
			query.setString("paramcode" ,paramcode);
			retvallist = query.list();
		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return retvallist;
	}  	
	//@nikhil Fashion Jewellery:END

	public OctParam findbyCodeNGroup(String paramcode,String paramgrp){
		Session hibSession = null;
		OctParam octParam = null;
		List retvallist = new ArrayList();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = null;
			query = hibSession.createQuery("from OctParam param where param.paramcode=:paramcode and param.paramgroup=:paramgrp");
			query.setString("paramcode", paramcode);
			query.setString("paramgrp", paramgrp);
			retvallist = query.list();
			if (retvallist.size() > 0) {
				octParam = (OctParam) retvallist.get(0);
			}

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return octParam;
	}

	//@Suyog, get data using param group and param value start
	@SuppressWarnings("unchecked")
	public OctParam findPojoByParamGroupNValue(String paramGroup ,String paramvalue){
		Session hibSession = null;
		OctParam param = null;
		try
		{	
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			if(paramGroup != null && paramvalue != null){
				query=hibSession.createQuery(" from OctParam oct where oct.paramgroup=:groupName and oct.paramvalue=:paramvalue ");
				query.setString("groupName" ,paramGroup);
				query.setString("paramvalue" ,paramvalue);
				param = (OctParam) query.uniqueResult();
			}
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return param;
	}
	//@Suyog, get data using param group and param value end

	//@Deepak Deshekar :: TPR -6575 Start

	public double getParamvalByParamGroup(String groupName){
		Session hibSession = null;
		List retvallist = new ArrayList();  
		double result=0d;
		try
		{	
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			if(groupName != null){
				query=hibSession.createQuery("select paramvalue from OctParam oct where oct.paramgroup=:groupName");
				query.setString("groupName" ,groupName);
				query.setMaxResults(1);
				retvallist=query.list();
				if(retvallist.size()>0 && retvallist.get(0) !=null){
					result=Double.parseDouble(retvallist.get(0)+"");
				}
			}	
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return result;
	} 

	public Long findbyrfNum(String paramgrp,String paramcode){ 
		Session hibSession = null;
		Long octParam =null;
		List retvallist = new ArrayList();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = null;
			query = hibSession.createQuery("select param.paramrfnum from OctParam param where param.paramgroup=:paramgrp and param.paramcode=:paramcode");
			query.setString("paramgrp", paramgrp);
			query.setString("paramcode", paramcode);
			retvallist = query.list();
			if (retvallist.size() > 0) {
				octParam = (Long) retvallist.get(0);
			}

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return octParam;
	}


	public String findDescbyCodeNGroup(String paramcode,String paramgrp){
		Session hibSession = null;
		String parmadesc = null;
		List retvallist = new ArrayList();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = null;
			query = hibSession.createQuery("select param.paramdesc from OctParam param where param.paramcode=:paramcode and param.paramgroup=:paramgrp");
			query.setString("paramcode", paramcode);
			query.setString("paramgrp", paramgrp);
			query.setMaxResults(1);
			retvallist = query.list();

			if (retvallist.size() > 0) {
				parmadesc =  (String) retvallist.get(0);
			}

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return parmadesc;
	}
	//@Deepak Deshekar :: TPR -6575 End

	//@siddhesh :  TPR-5266
	public String findParamCode(Long user){
		List retVal=null;
		Session hibSession=null;
		String roleName=null;
		Query query=null;
		try{
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			query=hibSession.createQuery("select oct.paramcode From OctParam oct where oct.paramrfnum =:user");
			query.setLong("user", user);
			retVal=query.list();
		}catch(HibernateException e){
			e.printStackTrace();
		}
		if(retVal!=null && retVal.size()>0){
			roleName = (String)retVal.get(0);
		}
		return roleName;
	}
	//TPR-5266

	public String findParamValueByCode(String code){
		List retVal=null;
		Session hibSession=null;
		String roleName=null;
		Query query=null;
		try{
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			query=hibSession.createQuery("select oct.paramvalue From OctParam oct where oct.paramcode =:code");
			query.setString("code", code);
			retVal=query.list();
		}catch(HibernateException e){
			e.printStackTrace();
		}
		if(retVal!=null && retVal.size()>0){
			roleName = (String)retVal.get(0);
		}
		return roleName;
	}

	//@nikhil.Shinge TPR-9732_Reject reason start

	public List<Object []> findRejectReasonByParamGroup(String paramGroup){
		Session hibSession = null;
		List<Object []> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = null;
			if (paramGroup != null) {
				query = hibSession
						.createQuery("select paramrfnum,paramdesc from OctParam  where paramgroup=:groupName order by paramcode");
				query.setString("groupName", paramGroup);
				retvalList = query.list();
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}

	public OctParam findbyParamDesc(String paramdesc){
		Session hibSession = null;
		OctParam octParam = null;
		List retvallist = new ArrayList();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = null;
			query = hibSession.createQuery("from OctParam param where param.paramdesc=:paramdesc");
			query.setString("paramdesc", paramdesc);
			retvallist = query.list();
			if (retvallist.size() > 0) {
				octParam = (OctParam) retvallist.get(0);
			}

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return octParam;
	}


	//@nikhil.Shinge TPR-9732_Reject reason end


	//sidhu
	public List getCodeNDesc(String paramGroup){

		Session hibSession = null;
		List retVal=null;
		try{
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			query=hibSession.createQuery("select oct.paramcode,oct.paramdesc from OctParam oct where oct.paramgroup =:paramGroup order by oct.paramvalue");
			query.setString("paramGroup",paramGroup);
			retVal = query.list();
		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return retVal;
	}

	//Suraj T. TPR::9732
	public ScrollableResults getRejectCodeNRejectDesc(String paramGroup){
		Session hibSession = null;
		ScrollableResults rs = null;
		StringBuffer buffer = new StringBuffer();
		try{
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			query=hibSession.createQuery("select oct.paramcode,oct.paramdesc from OctParam oct where oct.paramgroup =:paramGroup and oct.deleted='N' order by oct.paramvalue");
			query.setString("paramGroup",paramGroup);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		}catch (HibernateException e) {
			throw new DAOException(e);
		} finally {
		}
		return rs;
	}

	//@Nikhil.S commission multiple group for all

	public List<Object []> findByParamGroupAll(String paramGroup){
		Session hibSession = null;
		List<Object []> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = null;
			if (paramGroup != null) {   
				query = hibSession
						.createQuery("select paramrfnum,paramdesc from OctParam  where paramgroup in("+paramGroup+") and deleted='N' order by paramdesc");
				//query.setString("groupName", paramGroup);
				retvalList = query.list();
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}

	public List<Object []> findByParamGroupAllByCode(String paramGroup){
		Session hibSession = null;
		List<Object []> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = null;
			if (paramGroup != null) {   
				query = hibSession
						.createQuery("select paramcode,paramdesc from OctParam  where paramgroup in("+paramGroup+") and deleted='N' order by paramdesc");
				//query.setString("groupName", paramGroup);
				retvalList = query.list();
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}
	//@Parag Davkhar TPR-10041 start
	public OctParam findParamValueByCode(String code,String group){
		Session hibSession=null;
		OctParam octParam = null;
		Query query=null;
		List retVal = new ArrayList();
		try{
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			query=hibSession.createQuery("From OctParam oct where oct.paramcode =:code and oct.paramgroup =:group");
			query.setString("code", code);
			query.setString("group", group);
			retVal=query.list();
			if (retVal.size() > 0) {
				octParam = (OctParam) retVal.get(0);
			}
		}catch(HibernateException e){
			e.printStackTrace();
		}
		return octParam;
	}
	//@Parag Davkhar TPR-10041 end
	//@Deepak Deshekar :: Digital Agreement Start
	public List<Object[]> findParamByParamGroup(String paramGroup){
		Session hibSession = null;
		List<Object[]> statusList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = null;
			if (paramGroup != null) {
				query = hibSession.createQuery("select paramrfnum,paramvalue from OctParam param where param.paramgroup=:groupName order by param.paramvalue");
				query.setString("groupName", paramGroup);
				statusList = query.list();
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return statusList;
	}

	public Object[] findBynameByParamRfNum(Long Paramrfnum) {
		Session hibSession = null;
		List<Object[]> retvalList = null;
		Object[] result=null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select param.paramvalue,param.paramcode from OctParam param where param.paramrfnum =:Paramrfnum";
			Query query = hibSession.createQuery(queryString);
			query.setLong("Paramrfnum",Paramrfnum);
			query.setMaxResults(1);
			retvalList = query.list();
			if(retvalList !=null && retvalList.size()>0) {
				result = (Object[])retvalList.get(0);
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return result;
	}
	//@Deepak Deshekar :: Digital Agreement End

	//@Rohit Start TPR-8560 Digitizing Seller Agreement
	public List<Object []> findRfAndValByGroup(String paramGroup){
		Session hibSession = null;
		List<Object []> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = null;
			if (paramGroup != null) {
				query = hibSession.createQuery("select paramrfnum,paramvalue from OctParam  where paramgroup=:groupName and deleted='N' order by paramcode");
				query.setString("groupName", paramGroup);
				retvalList = query.list();
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}
	//@Rohit End TPR-8560 Digitizing Seller Agreement
	public OctParam findParambyCode(String paramgrp,String paramcode){ 
		Session hibSession = null;
		OctParam octParam =null;
		List retvallist = new ArrayList();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = null;
			query = hibSession.createQuery("from OctParam param where param.paramgroup=:paramgrp and param.paramcode=:paramcode");
			query.setString("paramgrp", paramgrp);
			query.setString("paramcode", paramcode);
			retvallist = query.list();
			if (retvallist.size() > 0) {
				octParam = (OctParam) retvallist.get(0);
			}

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return octParam;
	}
	
	public List<Long> getParamrfnumlst(List<String> paramcode,String paramgrp){
		Session hibSession = null;
		OctParam octParam =null;
		List<Long> retvallist = new ArrayList();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = null;
			query = hibSession.createQuery("select paramrfnum from OctParam param where param.paramgroup=:paramgrp and param.paramcode in (:paramcode)");
			query.setString("paramgrp", paramgrp);
			query.setParameterList("paramcode", paramcode);
			retvallist = query.list();

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvallist;
	}
	
	public Long getParamrfnum(String paramcode,String paramgrp){
		Session hibSession = null;
		OctParam octParam =null;
		List<Long> retvallist = new ArrayList();
		Long pararfnum= null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = null;
			query = hibSession.createQuery("select paramrfnum from OctParam param where param.paramgroup=:paramgrp and param.paramcode in (:paramcode)");
			query.setString("paramgrp", paramgrp);
			query.setString("paramcode", paramcode);
			retvallist = query.list();
			if(retvallist !=null && retvallist.size()>0) {
				pararfnum=retvallist.get(0);
			}

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return pararfnum;
	}
	public List<Object[]> getSDD(String SDD){
		Session hibSession = null;
        List<Object[]> result=null;
    	try{
    		String queryString="select paramdesc,paramgroup,paramrfnum,paramvalue from OctParam where paramgroup=:SDD";    		
    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		Query query = hibSession.createQuery(queryString); 
    		query.setString("SDD", SDD);
    		result= query.list();
            
    	}catch(Exception e){
    		throw new  DAOException(e);
		}
    	return result;
	}
	
	public Long getRfnumByCode(String paramcode){
		Session hibSession = null;
		OctParam octParam =null;
		List<Long> retvallist = new ArrayList();
		Long pararfnum= null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = null;
			query = hibSession.createQuery("select paramrfnum from OctParam param where param.paramcode in (:paramcode)");
			query.setString("paramcode", paramcode);
			retvallist = query.list();
			if(retvallist !=null && retvallist.size()>0) {
				pararfnum=retvallist.get(0);
			}

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return pararfnum;
	}
	
	//Shankar Start : Issue :Rejected Reason Activate
	public OctParam findbyParamGroupAndDesc(String paramGroup,String paramdesc){
		Session hibSession = null;
		OctParam octParam = null;
		List<OctParam> retvallist = new ArrayList<>();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = null;
			query = hibSession.createQuery("from OctParam param where param.paramgroup=:paramgroup and param.paramdesc=:paramdesc and deleted='N' ");
			query.setString("paramgroup", paramGroup);
			query.setString("paramdesc", paramdesc);
			query.setMaxResults(1);
			retvallist = query.list();
			if (retvallist != null && !retvallist.isEmpty()) {
				octParam = (OctParam) retvallist.get(0);
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return octParam;
	}
	//Shankar End : Issue :Rejected Reason Activate
	
	public List getParamsByParamGroupNew(String groupName){
		Session hibSession = null;
		List retvallist = new ArrayList();        
		try
		{	
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			if(groupName != null){
				query=hibSession.createQuery("select paramrfnum,paramvalue from OctParam oct where oct.paramgroup=:groupName and oct.deleted='N'");
				query.setString("groupName" ,groupName);
				retvallist=query.list();
			}	
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return retvallist;
	} 
	
	//@Nikhil.S SHD
	public String findParamValueByCodeSHD(String paramcode){
		List retVal=null;
		Session hibSession=null;
		String paramdesc=null;
		Query query=null;
		try{
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			query=hibSession.createQuery("select oct.paramdesc From OctParam oct where oct.paramcode =:paramcode and oct.paramgroup='REJECTION_REASON_SHD'");
			query.setString("paramcode", paramcode);
			retVal=query.list();
		}catch(HibernateException e){
			e.printStackTrace();
		}
		if(retVal!=null && retVal.size()>0){
			paramdesc = (String)retVal.get(0);
		}
		return paramdesc;
	}
	
	//Aniket
	public OctParam findByGroupNCodeisDeleteN(String groupName,String paramcode) {
		OctParam retVal=null;
		Query query=null;
		List<OctParam> retvallist = new ArrayList<>();
		try{
			Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
			query = hibSession.createQuery("from OctParam oct where oct.paramgroup=:groupName and paramcode = :paramcode");
			query.setParameter("groupName", groupName);
			query.setParameter("paramcode", paramcode);
			retvallist= query.list();
			if (retvallist != null && !retvallist.isEmpty()) {
				retVal = (OctParam) retvallist.get(0);
			}
		}catch(HibernateException e){
			e.printStackTrace();
		}	
		return retVal;
	}
	
	public OctParam findByGroupNCodelistisDeleteN(String groupName,List paramcode) {
		OctParam retVal=null;
		Query query=null;
		List<OctParam> retvallist = new ArrayList<>();
		try{
			Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
			query = hibSession.createQuery("from OctParam oct where oct.paramgroup=:groupName and paramcode in (:paramcode)");
			query.setParameter("groupName", groupName);
			query.setParameterList("paramcode", paramcode);
			retvallist= query.list();
			if (retvallist != null && !retvallist.isEmpty()) {
				retVal = (OctParam) retvallist.get(0);
			}
		}catch(HibernateException e){
			e.printStackTrace();
		}	
		return retVal;
	}
	
	//@siddhesh :: kafka
	public Long findRfnumByParamGroupCodeNew(String paramGroup,String paramCode){
		Session hibSession = null;
		List<Long> retvallist = new ArrayList();
		Long pararfnum= null;
		try{
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			query=hibSession.createQuery("select oct.paramrfnum from OctParam oct where oct.paramcode=:paramCode and paramgroup=:paramGroup");
			query.setString("paramCode" ,paramCode);
			query.setString("paramGroup" ,paramGroup);
			retvallist = query.list();
		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		if(retvallist !=null && retvallist.size()>0) {
			pararfnum=retvallist.get(0);
		}
		return pararfnum;
	}
	
	public String findValueByParamGroupCodeNew(String paramGroup,String paramCode){
		Session hibSession = null;
		List<String> retvallist = new ArrayList();
		String pararfnum= null;
		try{
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			query=hibSession.createQuery("select oct.paramvalue from OctParam oct where oct.paramcode=:paramCode and paramgroup=:paramGroup");
			query.setString("paramCode" ,paramCode);
			query.setString("paramGroup" ,paramGroup);
			retvallist = query.list();
		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		if(retvallist !=null && retvallist.size()>0) {
			pararfnum=retvallist.get(0);
		}
		return pararfnum;
	}
	//@siddhesh :: kafka
	
	//Shankar Start
	public List<Object []> getRefundTypeList(String paramGroup){
		Session hibSession = null;
		List<Object []> retvalList = null;
		StringBuffer buffer = new StringBuffer();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			if (paramGroup != null) {
				buffer.append("select paramcode,paramvalue from OctParam where paramgroup=:groupName ");
			}
			if(paramGroup != null && "REFUNDTYPE".equals(paramGroup)){
				buffer.append("order by PARAMCODE desc");
			}
			Query query = hibSession.createQuery(buffer.toString());
			query.setString("groupName",paramGroup);
			retvalList = query.list();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}
	//Shankar End
	public OctParam findParamObject(Long paramRfNum){
		OctParam obj=null;
		Session hibSession = null;
		List<OctParam> result=null;
		try{
			String queryString="From OctParam where paramrfnum=:paramRfNum";
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery(queryString); 
			query.setLong("paramRfNum",paramRfNum);
			result= query.list();
			if(!result.isEmpty()){
				obj = result.get(0);
			}
		}catch(Exception e){
			throw new DAOException(e);
		}
		return obj;
	}
	
	//Shankar Start
	public List getParamCodeListByGroup(String groupName){
		Session hibSession = null;
		List retvallist = new ArrayList();        
		try
		{	
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			query=hibSession.createQuery("select paramcode,paramvalue from OctParam where paramgroup=:groupName and deleted='N'");
			query.setString("groupName" ,groupName);
			retvallist=query.list();
		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return retvallist;
	} 
	//Shankar End
	
	public int findCriteriaExistense(String paramcode,String paramgroup){
		Session hibSession = null;
		List retvallist = null;
		long count = 0l;
		try{
			String queryString = "select paramseq from OctParam where paramcode=:paramcode and paramgroup=:paramgroup";
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery(queryString);
			query.setString("paramcode", paramcode);
			query.setString("paramgroup", paramgroup);
			retvallist= query.list();
			if(retvallist!=null && !retvallist.isEmpty()){
				count = (long) retvallist.get(0);
			}
		}catch(Exception e){
			throw new  DAOException(e);
		}
		return (int) count;
	}
	 public List findParamMappingByL4(String l4CODE){
	        Session hibSession = null;
	        List retvallist = null;
	        String Variant=null;

	        try{
	            String queryString = "select Sizevarient,Colorvarient from VarrientMapping where l4CODE =:l4CODE ";
	            hibSession = com.anm.hibernate.HibernateConnection.getSession();
	            Query query = hibSession.createQuery(queryString);
	            query.setString("l4CODE", l4CODE);
	            retvallist= query.list();

	        }catch(Exception e){
	        throw new  DAOException(e);
	        }
	    return retvallist;
	    } 
	 
		public boolean checkIfValueContainsForParamGroupAndCode(String paramGroup, String paramCode, String paramValue) {
			Session hibSession = null;
			Integer count = null;
			boolean valueContainsFlag = false;
			try {
				hibSession = com.anm.hibernate.HibernateConnection.getSession();
				Query query = hibSession.createQuery("select count(*) from OctParam oct where oct.paramcode=:paramCode and paramgroup=:paramGroup and paramvalue like concat(concat('%', :paramValue), '%') ");
				query.setString("paramCode", paramCode);
				query.setString("paramGroup", paramGroup);
				query.setString("paramValue", paramValue);
				count = (Integer) query.list().get(0);
			} catch (HibernateException e) {
				throw new DAOException(e);
			}
			if (count > 0) {
				valueContainsFlag = true;
			}
			return valueContainsFlag;
		}
	 }