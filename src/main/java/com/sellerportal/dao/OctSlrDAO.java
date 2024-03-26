/* 
 * Auto Generated on Sat Mar 14 12:16:03 IST 2015
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
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.type.StandardBasicTypes;

import com.anm.hibernate.DAOException;
import com.anm.hibernate.HibernateConnection;
import com.anm.hibernate.SuperDAO;
import com.sellerportal.model.OctSlr;

/**
 * 
 * 
 * Generated DAO Class for oct_slr Table.
 * 
 * All Queries related to this table should be here. NOTE: Do not put user
 * defined queries in the generated DAO class. USE
 * hibernate-dao-oct_slr-class-code.txt
 * */
public class OctSlrDAO extends SuperDAO {

	/**
	 * Find object by primary key.
	 * 
	 * @param pk
	 *            the pk of the object to find.
	 */
	public OctSlr findByPK(Serializable pk)
			throws com.anm.hibernate.DAOException {
		OctSlr retval = null;
		retval = (OctSlr) super.findByPk(pk);
		return retval;
	}

	/**
	 * @param obj
	 * @return
	 */
	protected Criteria createCriteria(Object object) {
		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
		Criteria criteria = hibSession.createCriteria(OctSlr.class);

		OctSlr obj = (OctSlr) object;

		// Pk getOctslrrfnum
		if (obj.getOctslrrfnum() != null) {
			criteria.add(Expression.eq("octslrrfnum", obj.getOctslrrfnum()));
		}

		// Set the many2one and one2one relation objects
		if (obj.getOctslrislisting() != null) {
			criteria.add(Expression.eq("octslrislisting", obj.getOctslrislisting()));
			criteria.setFetchMode("octslrislisting", FetchMode.DEFAULT);
		}
		
		if (obj.getOctslrsettlement() != null) {
			criteria.add(Expression.eq("octslrsettlement", obj.getOctslrsettlement()));
			criteria.setFetchMode("octslrsettlement", FetchMode.DEFAULT);
		}
		
		if (obj.getOctslrtype() != null) {
			criteria.add(Expression.eq("octslrtype", obj.getOctslrtype()));
			criteria.setFetchMode("octslrtype", FetchMode.DEFAULT);
		}
		return criteria;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.anm.hibernate.SuperDAO#getPojoObj()
	 */

	public List findSellerByCondition(String sellerName,String sellerCode, String email,
			String isActive,String phoneNumber ,String fromDate, String toDate, int from, int max,String sellerType,String listType)
			throws DAOException {
		Integer count = null;
		Session hibSession = null;
		List retval = null;
		String strQuery = "select distinct slr.OCTSLRRFNUM as SELLERID,slr.OCTSLRNAME as SELLERNAME,slr.OCTSLRLNAME as SELLERLEGALNAME,slr.OCTSLRTAN as TAN,slr.OCTSLRPAN as PAN,slr.OCTSLRLOGO as LOGO,slr.OCTSLRISLISTING as ISLISTING, slr.SLRINCOMPLETE as INCOMPLETE, slr.OCTSLRLCODE as OCTSLRLCODE, slr.OCTSLRISACCEPTED as ISACCEPTED, slr.OCTSLRISAPPROVE as OCTSLRISAPPROVE, slr.OCTSLRISPROCESSED as OCTSLRISPROCESSED from oct_slr slr where slr.OCTSLRISACTIVE='Y' ";
		try {
			hibSession = HibernateConnection.getSession();

			if (sellerCode != null && !"".equals(sellerCode) && sellerName != null && !"".equals(sellerName)){
				if(sellerCode.equals(sellerName)){
				      strQuery += "and (slr.OCTSLRLCODE='" + sellerCode + "' or slr.OCTSLRNAME='"+sellerName +"')";
				}else{
					strQuery += "and (slr.OCTSLRLCODE='" + sellerCode + "' and slr.OCTSLRNAME='"+sellerName +"')";
				}
			}
			if(!"".equals(sellerType) && "SR".equals(sellerType)){
				strQuery += " and slr.OCTSLRISACCEPTED='N'";
			}
			if(!"".equals(sellerType) && "SA".equals(sellerType)){
				strQuery += " and slr.OCTSLRISACCEPTED='Y'";
			}
			if(!"".equals(sellerType) && "IS".equals(sellerType)){
				strQuery += " and slr.SLRINCOMPLETE='Y'";
			}
			if(!"".equals(sellerType) && "WA".equals(sellerType)){
				strQuery += " and slr.OCTSLRISACCEPTED='W'";
			}
			if(!"".equals(sellerType) && "AS".equals(sellerType)){
				strQuery += " and slr.OCTSLRISAPPROVE='Y'";
			}
			if(listType != null && !"".equals(listType)){
				strQuery += " and slr.OCTSLRISLISTING='"+listType+"'";
				if(listType.equals("4") && sellerType == null){
					strQuery += " and slr.OCTSLRISAPPROVE='Y'";
				}
			}
			if (fromDate != null && !"".equals(fromDate) && toDate != null
					&& !"".equals(toDate)) {
				if(fromDate.equals(toDate)){
					strQuery += " and(slr.CREATEDATE Between TO_DATE('" + fromDate
							+ " 00:00:00','yyyy-mm-dd HH24:MI:SS') and TO_DATE('" + toDate
							+ " 23:59:59','yyyy-mm-dd HH24:MI:SS')) ";
				}else{
					strQuery += " and(slr.CREATEDATE Between TO_DATE('" + fromDate
						+ "','yyyy-mm-dd') and TO_DATE('" + toDate
						+ "','yyyy-mm-dd')) ";
				}
			}
			strQuery += " order by slr.OCTSLRRFNUM desc";

			SQLQuery query = hibSession.createSQLQuery(strQuery);
			query.addScalar("SELLERID", StandardBasicTypes.STRING);
			query.addScalar("SELLERNAME", StandardBasicTypes.STRING);
			query.addScalar("SELLERLEGALNAME", StandardBasicTypes.STRING);
			query.addScalar("TAN", StandardBasicTypes.STRING);
			query.addScalar("PAN", StandardBasicTypes.STRING);
			query.addScalar("LOGO", StandardBasicTypes.STRING);
			query.addScalar("ISLISTING", StandardBasicTypes.STRING);
			query.addScalar("INCOMPLETE", StandardBasicTypes.STRING);
			query.addScalar("OCTSLRLCODE", StandardBasicTypes.STRING);
			query.addScalar("ISACCEPTED", StandardBasicTypes.STRING);
			query.addScalar("OCTSLRISAPPROVE", StandardBasicTypes.STRING);
			query.addScalar("OCTSLRISPROCESSED", StandardBasicTypes.STRING);
			query.setFirstResult(from);
			query.setMaxResults(max);

			retval = query.list();

		} catch (Exception e) {
			throw new DAOException(e);
		}
		return retval;
	}

	public int findSellerByConditionCount(String sellerName,String sellerCode, String email,
			String isActive,String phoneNumber ,String fromDate, String toDate, String sellerType,String listType){
		int count = 0;
		Session hibSession = null;
		List retval = null;
		String strQuery = "select distinct slr.OCTSLRRFNUM as SELLERID,slr.OCTSLRNAME as SELLERNAME,slr.OCTSLRLNAME as SELLERLEGALNAME,slr.OCTSLRTAN as TAN,slr.OCTSLRPAN as PAN,slr.OCTSLRLOGO as LOGO,slr.OCTSLRISLISTING as ISLISTING, slr.SLRINCOMPLETE as INCOMPLETE, slr.OCTSLRLCODE as OCTSLRLCODE, slr.OCTSLRISACCEPTED as ISACCEPTED, slr.OCTSLRISAPPROVE as OCTSLRISAPPROVE, slr.OCTSLRISPROCESSED as OCTSLRISPROCESSED from oct_slr slr where slr.OCTSLRISACTIVE='Y' ";
		try {
			hibSession = HibernateConnection.getSession();

			if (sellerCode != null && !"".equals(sellerCode) && sellerName != null && !"".equals(sellerName)){				
				if(sellerCode.equals(sellerName)){
				      strQuery += "and (slr.OCTSLRLCODE='" + sellerCode + "' or slr.OCTSLRNAME='"+sellerName +"')";
				}else{
					strQuery += "and (slr.OCTSLRLCODE='" + sellerCode + "' and slr.OCTSLRNAME='"+sellerName +"')";
				}
			}
			
			if(!"".equals(sellerType) && "SR".equals(sellerType)){
				strQuery += " and slr.OCTSLRISACCEPTED='N'";
			}
			if(!"".equals(sellerType) && "SA".equals(sellerType)){
				strQuery += " and slr.OCTSLRISACCEPTED='Y'";
			}
			if(!"".equals(sellerType) && "IS".equals(sellerType)){
				strQuery += " and slr.SLRINCOMPLETE='Y'";
			}
			if(!"".equals(sellerType) && "WA".equals(sellerType)){
				strQuery += " and slr.OCTSLRISACCEPTED='W'";
			}
			if(!"".equals(sellerType) && "AS".equals(sellerType)){
				strQuery += " and slr.OCTSLRISAPPROVE='Y'";
			}
			if(listType != null && !"".equals(listType)){
				strQuery += " and slr.OCTSLRISLISTING='"+listType+"'";
				if(listType.equals("4") && sellerType == null){
					strQuery += " and slr.OCTSLRISAPPROVE='Y'";
				}
			}
			if (fromDate != null && !"".equals(fromDate) && toDate != null
					&& !"".equals(toDate)) {
				if(fromDate.equals(toDate)){
					strQuery += " and(slr.CREATEDATE Between TO_DATE('" + fromDate
							+ " 00:00:00','yyyy-mm-dd HH24:MI:SS') and TO_DATE('" + toDate
							+ " 23:59:59','yyyy-mm-dd HH24:MI:SS')) ";
				}else{
					strQuery += " and(slr.CREATEDATE Between TO_DATE('" + fromDate
						+ "','yyyy-mm-dd') and TO_DATE('" + toDate
						+ "','yyyy-mm-dd')) ";
				}
			}
			strQuery += " order by slr.OCTSLRRFNUM desc";

			SQLQuery query = hibSession.createSQLQuery(strQuery);
			query.addScalar("SELLERID", StandardBasicTypes.STRING);
			query.addScalar("SELLERNAME", StandardBasicTypes.STRING);
			query.addScalar("SELLERLEGALNAME", StandardBasicTypes.STRING);
			query.addScalar("TAN", StandardBasicTypes.STRING);
			query.addScalar("PAN", StandardBasicTypes.STRING);
			query.addScalar("LOGO", StandardBasicTypes.STRING);
			query.addScalar("ISLISTING", StandardBasicTypes.STRING);
			query.addScalar("INCOMPLETE", StandardBasicTypes.STRING);
			query.addScalar("OCTSLRLCODE", StandardBasicTypes.STRING);
			query.addScalar("ISACCEPTED", StandardBasicTypes.STRING);
			query.addScalar("OCTSLRISAPPROVE", StandardBasicTypes.STRING);
			query.addScalar("OCTSLRISPROCESSED", StandardBasicTypes.STRING);

			retval = query.list();
			if (!retval.isEmpty()) {			
				count = retval.size();
			}

		} catch (Exception e) {
			throw new DAOException(e);
		}
		return count;
	}

	protected Object getPojoObj() {

		return new OctSlr();

	}
	
	  
	
	public List<OctSlr> getSellerList(){
		Session hibSession = null;
        List<OctSlr> result=null;
    	try{
    		String queryString="from OctSlr slr where slr.deleted='N' and octslrislisting.paramcode='L_N_O' and octslrislisting.paramgroup='LISTING_OREDER_PROCESS' order by LOWER(octslrname)";    		
    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		Query query = hibSession.createQuery(queryString); 
    		result= query.list();
            
    	}catch(Exception e){
    		throw new  DAOException(e);
		}
    	return result;
	}
	
	
	public  List<OctSlr> getApprovedSellerList(){
		Session hibSession = null;
        List<OctSlr> result=null;
    	try{
    		String queryString="from OctSlr slr where slr.deleted='N' and slr.octslrisapprove='Y'";    		
    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		Query query = hibSession.createQuery(queryString); 
    		result= query.list();
            
    	}catch(Exception e){
    		throw new  DAOException(e);
		}
    	return result;
	}


	public OctSlr findSellerExistance(String sellerName, String sellerCode) {


		OctSlr retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From OctSlr octslr where octslr.octslrname =:sellerName and octslr.octslrlcode =:sellerCode";
			Query query = hibSession.createQuery(queryString);
			if(sellerName!=null && !sellerName.isEmpty()){
				query.setString("sellerName", sellerName.trim());
			}
			if(sellerCode!=null && !sellerCode.isEmpty()){
				query.setString("sellerCode", sellerCode.trim());
			}
			retvalList = query.list();
			if (!retvalList.isEmpty()){
				retval = (OctSlr) retvalList.get(0);
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retval;
	}
	
	public OctSlr findByPanNumberAndSellerCode(String panNumber,String sellerCode) {
		OctSlr retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From OctSlr octslr where octslr.octslrpan =:panNumber and octslr.octslrlcode !=:sellerCode and octslr.deleted='N'";
			Query query = hibSession.createQuery(queryString);
			query.setString("panNumber", panNumber);	
			query.setString("sellerCode", sellerCode);
			retvalList = query.list();
			if (!retvalList.isEmpty())
				retval = (OctSlr) retvalList.get(0);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retval;
	}
	
	
	
	
	
public OctSlr findByPanNumber(String panNumber,Long sellerId) {
		OctSlr retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From OctSlr octslr where octslr.octslrpan =:panNumber and octslr.octslrrfnum !=:sellerId and octslr.deleted='N'";
			Query query = hibSession.createQuery(queryString);
			query.setString("panNumber", panNumber);	
			query.setLong("sellerId", sellerId);
			retvalList = query.list();
			if (!retvalList.isEmpty())
				retval = (OctSlr) retvalList.get(0);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retval;
	}
	
public OctSlr findSellerCode(String sellerCode) {
		OctSlr retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From OctSlr octslr where octslr.octslrlcode =:sellerCode";
			Query query = hibSession.createQuery(queryString);
			query.setString("sellerCode", sellerCode);
			retvalList = query.list();
			if (!retvalList.isEmpty())
				retval = (OctSlr) retvalList.get(0);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retval;
	}
	
public boolean doesSellerExists(String sellerCode) {
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From OctSlr octslr where octslr.octslrlcode =:sellerCode";
			Query query = hibSession.createQuery(queryString);
			query.setString("sellerCode", sellerCode);
			retvalList = query.list();
			if (retvalList!=null && !retvalList.isEmpty())
				return true;
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return false;
	}

	
	
	public int findSellerApprovalByConditionCount(String octslrname,String octslrlcode,String octslrisactive,Date startDate, Date endDate){
		int count = 0;
		Session hibSession = null;
		List retval = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select Count(slrLog) From OctSlrLog slrLog where slrLog.slrlogslrrfnum.octslrname =:octslrname or slrLog.slrlogslrrfnum.octslrlcode=:octslrlcode and "
					+ "slrLog.slrlogslrrfnum.createdate between :startDate and :endDate and slrLog.slrlogslrrfnum.octslrisactive=:octslrisactive";
					
			Query query = hibSession.createQuery(queryString);
			query.setString("octslrlcode", octslrlcode);
			query.setString("octslrname", octslrname);
			
			query.setTimestamp("startDate", startDate);
            query.setTimestamp("endDate", endDate);
            query.setString("octslrisactive", octslrisactive);
            
            retval = query.list();
			if (!retval.isEmpty()) {
				Object obj = retval.get(0);
				count = Integer.parseInt(obj.toString());
			}
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return count;
	}
	/*Return Seller Dashboards status*/
	@SuppressWarnings("unchecked")
	public List<Object> findSellerAndSalveList(){
		Session hibSession = null;
		List<Object> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "from OctSlr slr, OctSlv slv where slr.deleted='N'";
			Query query = hibSession.createQuery(queryString);
			retvalList = query.list();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}
	/*Return Seller Report List*/
	@SuppressWarnings("unchecked")
	public List<OctSlr> findSellerReportByCondition(String sellerName,String sellerCode,Date fromDate, Date toDate,String sellerStatus,String sellerType,String listedSeller, int from, int max){
		Session hibSession = null;
		List<OctSlr> retval = null;
		String strQuery="From OctSlr octSlr where octSlr.deleted='N'";
		try {
			hibSession = HibernateConnection.getSession();

			if (!"".equals(sellerName) && sellerName != null || !"".equals(sellerCode) && sellerCode != null) {
				strQuery += " and (octSlr.octslrname='" + sellerName + "' or octSlr.octslrlcode='" + sellerCode + "' )";
			}
			if(!"".equals(sellerStatus) && "SR".equals(sellerStatus)){
				strQuery += " and octSlr.octslrisaccepted='N'";
			}
			if(!"".equals(sellerStatus) && "SA".equals(sellerStatus)){
				strQuery += " and octSlr.octslrisaccepted='Y'";
			}
			if(!"".equals(sellerStatus) && "IS".equals(sellerStatus)){
				strQuery += " and octSlr.slrincomplete='Y'";
			}
			if(!"".equals(sellerStatus) && "WA".equals(sellerStatus)){
				strQuery += " and octSlr.octslrisaccepted='W'";
			}
			if(!"".equals(sellerStatus) && "AS".equals(sellerStatus)){
				strQuery += " and octSlr.octslrisapprove='Y'";
			}
			
			if(!"".equals(listedSeller) && listedSeller != null && "Y".equals(listedSeller)){
				strQuery += " and octSlr.octslrislisting='4'";
			}
			if(!"".equals(listedSeller) && listedSeller != null && "N".equals(listedSeller)){
				strQuery += " and octSlr.octslrislisting='5' or octSlr.octslrislisting='6'";
			}
			if (sellerType != null && !"".equals(sellerType) ) {
				strQuery += " and octSlr.octslrtype='" + sellerType + "' ";
			}
			
			if (fromDate != null && toDate != null) {
				strQuery += " and octSlr.createdate Between :fromDate and :toDate";
			}
			
			strQuery += " order by octSlr.octslrrfnum desc";
			Query query = hibSession.createQuery(strQuery);
			if (fromDate != null && toDate != null) {
				query.setTimestamp("fromDate", fromDate);
				query.setTimestamp("toDate", toDate);
			}
			if(from != 0 && max != 0){
				query.setFirstResult(from);
				query.setMaxResults(max);
			}
			retval = query.list();
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return retval;
	}
	/*Return Seller Report count*/
	@SuppressWarnings("unchecked")
	public List<Object> findSellerReportCount(String sellerName,String sellerCode,Date fromDate, Date toDate,String sellerStatus,String sellerType,String listedSeller){
		Session hibSession = null;
		List<Object> retval = null;
		String strQuery="select count(*) From OctSlr octSlr where octSlr.deleted='N'";
		try {
			hibSession = HibernateConnection.getSession();

			if (!"".equals(sellerName) && sellerName != null || !"".equals(sellerCode) && sellerCode != null) {
				strQuery += "  and (octSlr.octslrname='" + sellerName + "' or octSlr.octslrlcode='" + sellerCode + "' )";
			}
			if(!"".equals(sellerStatus) && "SR".equals(sellerStatus)){
				strQuery += " and octSlr.octslrisaccepted='N'";
			}
			if(!"".equals(sellerStatus) && "SA".equals(sellerStatus)){
				strQuery += " and octSlr.octslrisaccepted='Y'";
			}
			if(!"".equals(sellerStatus) && "IS".equals(sellerStatus)){
				strQuery += " and octSlr.slrincomplete='Y'";
			}
			if(!"".equals(sellerStatus) && "WA".equals(sellerStatus)){
				strQuery += " and octSlr.octslrisaccepted='W'";
			}
			if(!"".equals(sellerStatus) && "AS".equals(sellerStatus)){
				strQuery += " and octSlr.octslrisapprove='Y'";
			}
			
			if(!"".equals(listedSeller) && listedSeller != null && "Y".equals(listedSeller)){
				strQuery += " and octSlr.octslrislisting='4'";
			}
			if(!"".equals(listedSeller) && listedSeller != null && "N".equals(listedSeller)){
				strQuery += " and octSlr.octslrislisting='5' or octSlr.octslrislisting='6'";
			}
			if (sellerType != null && !"".equals(sellerType) ) {
				strQuery += " and octSlr.octslrtype='" + sellerType + "' ";
			}
			
			if (fromDate != null && toDate != null) {
				strQuery += " and octSlr.createdate Between :fromDate and :toDate";
			}

			Query query = hibSession.createQuery(strQuery);
			if (fromDate != null && toDate != null) {
				query.setTimestamp("fromDate", fromDate);
				query.setTimestamp("toDate", toDate);
			}
			retval = query.list();
			
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return retval;
	}
	

	public OctSlr finBySellerCode(String slrcode) {
		OctSlr octslr=null;
		@SuppressWarnings("rawtypes")
		List retVal=null;
		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
		Criteria criteria = hibSession.createCriteria(OctSlr.class);
		if (slrcode != null && !slrcode.equals("")) {
			criteria.add(Expression.eq("octslrlcode", slrcode.trim()));
		}
		criteria.add(Expression.eq("deleted", "N"));
		retVal=criteria.list();
		if(retVal != null && !retVal.isEmpty()){
			octslr=(OctSlr) retVal.get(0);
		}
		return octslr;
	}
	public OctSlr finBySellerId(Long slrcode) {
		OctSlr octslr=null;
		@SuppressWarnings("rawtypes")
		List retVal=null;
		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
		Criteria criteria = hibSession.createCriteria(OctSlr.class);
		if (slrcode != null) {
			criteria.add(Expression.eq("octslrrfnum", slrcode));
		}
		criteria.add(Expression.eq("deleted", "N"));
		retVal=criteria.list();
		if(retVal != null && !retVal.isEmpty()){
			octslr=(OctSlr) retVal.get(0);
		}
		return octslr;
	}

	/*Return Seller Dashboards status*/
    @SuppressWarnings("unchecked")
    public List<OctSlr> findSellerList(){
        Session hibSession = null;
        List<OctSlr> retvalList = null;
        try {
            hibSession = com.anm.hibernate.HibernateConnection.getSession();
            String queryString = "From OctSlr where octslrisapprove='Y'";
            Query query = hibSession.createQuery(queryString);
            retvalList = query.list();
        } catch (HibernateException e) {
            throw new DAOException(e);
        }
        return retvalList;
    }
    
    public OctSlr findBySellerCode(String sellerCode){
    	OctSlr obj=null;
    	Session hibSession = null;
        List<OctSlr> result=null;
    	try{
    		String queryString="From OctSlr slr where slr.octslrlcode=:sellerCode";
    		
    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		Query query = hibSession.createQuery(queryString); 
    		query.setString("sellerCode", sellerCode.trim());
    		result= query.list();
    		if(!result.isEmpty()){
    			obj = result.get(0);
    		}
    	
    }catch(Exception e){
    	throw new DAOException(e);
    }
    	return obj;
    }
    public OctSlr findBySellerRfNum(Long sellerRfnum){
    	OctSlr obj=null;
    	Session hibSession = null;
        List<OctSlr> result=null;
    	try{
    		String queryString="From OctSlr slr where slr.octslrrfnum=:sellerRfnum";
    		
    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		Query query = hibSession.createQuery(queryString); 
    		query.setLong("sellerRfnum", sellerRfnum);
    		result= query.list();
    		if(!result.isEmpty()){
    			obj = result.get(0);
    		}
    	
    	}catch(Exception e){
    		throw new DAOException(e);
    	}
    	return obj;
    }
    public List findSellerListCodeandRfnum(){
        Session hibSession = null;
        List retvalList = null;
        try {
            hibSession = com.anm.hibernate.HibernateConnection.getSession();
            String queryString = "select slr.octslrrfnum,slr.octslrlname,slr.octslrlcode From OctSlr slr where octslrisapprove='Y'";
            Query query = hibSession.createQuery(queryString);
            retvalList = query.list();
        } catch (HibernateException e) {
            throw new DAOException(e);
        }
        return retvalList;
    }
    
    public List<Object> findSellerRefByCode(String sellerCode){
    	Session hibSession = null;
        List<Object> result=null;
    	try{
    		
    		String queryString="select slr.octslrrfnum From OctSlr slr where slr.octslrlcode=:sellerCode";
    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		Query query = hibSession.createQuery(queryString); 
    		query.setString("sellerCode", sellerCode.trim());
    		result= query.list();
    		
         }catch(Exception e){
        	 throw new DAOException(e);
    	}
    	return result;
    } 
    
    public List<Object> findSellerDetailByCode(String sellerCode){
    	OctSlr obj=null;
    	Session hibSession = null;
        List<Object> result=null;
    	try{
    		
    		String queryString="select slr.octslrrfnum,slr.octslrlcode From OctSlr slr where slr.octslrlcode=:sellerCode";
    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		Query query = hibSession.createQuery(queryString); 
    		query.setString("sellerCode", sellerCode.trim());
    		result= query.list();
    		
         }catch(Exception e){
        	 throw new DAOException(e);
    	}
    	return result;
    } 
    //@R2.3 CR For Internally Seller Code Genrate 
    public Object findSlrCodeBySequence(){
    	Session hibsession = null;
    	Object obj = null;
    	try {
			String queryStr = "select AUTO_SELLER_CODE.nextval from dual";//select max(octslrlcode) from oct_slr where octslrlcode like '1%' 
			hibsession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibsession.createSQLQuery(queryStr);
			obj = query.uniqueResult();
		} catch (HibernateException e) {
			throw new  DAOException(e);
		}
    	return obj;
    }
  //@R2.3 CR For Internally Seller Code Genrate
    public String generateSlrCode(String seriesStartNo){
    	String slrcode = "";
    	Session hibsession = null;
    	List list=new ArrayList();
    	String queryString = "select max(slr.octslrlcode)+1 from OctSlr slr where slr.octslrlcode like '"+seriesStartNo+"%'";
    	try {
			hibsession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibsession.createQuery(queryString);
			query.setMaxResults(1);
			list = query.list();
			if(!list.isEmpty()){
				slrcode = list.get(0)+"";
			}
		}catch (HibernateException e) {
			throw new  DAOException(e);
		}
    	return slrcode;
    }
    
    public List<OctSlr> findBySellerRfNumList(String slrfnumList){
    	Session hibSession = null;
        List<OctSlr> result=null;
    	try{
    		String queryString="From OctSlr slr where slr.octslrrfnum IN("+slrfnumList+")";
    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		Query query = hibSession.createQuery(queryString);
    		result= query.list();
    	
    }catch(HibernateException e){
    	throw new  DAOException(e);
    	}
    	return result;
    }
    
    //@nikhil JWLSPCUAT-49
    
    public Object findBifurcationBySellerCode(String octslrlcode){
		Session hibSession = null;
		List<Object> retvalList = null;
		Object priceBifr = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select octslrPriceBifrReq from OctSlr where octslrlcode=:octslrlcode";
			Query query = hibSession.createQuery(queryString);
			query.setString("octslrlcode", octslrlcode);
			retvalList = query.list();
			if(retvalList!=null){
				priceBifr = retvalList.get(0);
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return priceBifr;
	}
    
    public List<Object[]> getSellerApproval(){
		Session hibSession = null;
		List<Object[]> retvalList = null;
		
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select slr.octslrrfnum,slr.octslrlname,slr.octslrlcode from OctSlr slr where slr.octslrisapprove='Y'";
			Query query = hibSession.createQuery(queryString);
			retvalList = query.list();
			
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}
    
  //@shreyas start:: TPR-7149
    public void updateUnicomlivedate(String octslrrfnum ){
			Session hibSession = null;
			try {
				hibSession = com.anm.hibernate.HibernateConnection.getSession();
				Query query = hibSession.createQuery("update OctSlr slr set slr.uniComLiveDate=:liveDate where slr.octslrrfnum=:slrrfnum and slr.uniComLiveDate is null");
				query.setLong("slrrfnum", new Long(octslrrfnum));
				//@shreyas Date Fix
				query.setTimestamp("liveDate", new Date());
				query.executeUpdate();
			} catch (HibernateException e) {
				throw new com.anm.hibernate.DAOException(e);
			}
		}
  //@shreyas end :: TPR-7149
    
  //@Rohit Start
    public String getSlrRfnum(String octslrcode ){
		Session hibSession = null;
		String slrRfnum = null;
		List<Long> retvalList = null;
		long obj ;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select octslrrfnum from OctSlr where octslrlcode=:octslrcode");
			query.setString("octslrcode", octslrcode);
			retvalList = query.list();
			if(!retvalList.isEmpty() && retvalList != null && retvalList.get(0) != null){
				obj = (long)retvalList.get(0);
				slrRfnum = Long.toString(obj);
			} 
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		return slrRfnum;
	}
  //@Rohit End
    
    //@Deepak Deshekar :: FIND  SellerExists Optimize Start
    public boolean doesSellerExistsNew(String sellerCode) {	
		Session hibSession = null;
		List retvalList = null;
		int count=0;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select count(octslrrfnum) From OctSlr octslr where octslr.octslrlcode =:sellerCode";
			Query query = hibSession.createQuery(queryString);
			query.setString("sellerCode", sellerCode);
			retvalList = query.list();
    		if ( retvalList !=null && !retvalList.isEmpty()){
				 count=(int)retvalList.get(0);
			  if (count>0){
				return true;
			  }
    		}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return false;
	}
    //@Deepak Deshekar :: FIND  SellerExists Optimize End
    
    public String findSllerNameByCode(String sellerCode){
    	Session hibSession = null;
		List<String> retvalList = null;
		String slrcode=null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select octslrname From OctSlr  where octslrlcode =:sellerCode";
			Query query = hibSession.createQuery(queryString);
			query.setString("sellerCode", sellerCode);
			retvalList = query.list();
			if ( retvalList !=null && !retvalList.isEmpty())
				slrcode=retvalList.get(0);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return slrcode;
    }
    
    public boolean updateMahindraSlrId(String lpMahindraSlrId,String octslrlcode ){
		Session hibSession = null;
		boolean flag=false;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("update OctSlr set lpMahindraSlrId=:lpMahindraSlrId where octslrlcode=:octslrlcode");
			query.setString("lpMahindraSlrId", lpMahindraSlrId);
			query.setString("octslrlcode", octslrlcode);
			int res = query.executeUpdate();
			if(res>0){
				HibernateConnection.commitTransaction();
				flag = true;
			}
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		return flag;
	}
    
    public boolean updateMahindraSlaveId(String lpMahindraSlvId,String octslvcode ){
  		Session hibSession = null;
  		boolean flag=false;
  		try {
  			hibSession = com.anm.hibernate.HibernateConnection.getSession();
  			Query query = hibSession.createQuery("update OctSlv set lpMahindraSlvId=:lpMahindraSlvId where octslvcode=:octslvcode");
  			query.setString("lpMahindraSlvId", lpMahindraSlvId);
  			query.setString("octslvcode", octslvcode);
  			int res = query.executeUpdate();
  			if(res>0){
  				HibernateConnection.commitTransaction();
  				flag = true;
  			}
  		} catch (HibernateException e) {
  			throw new com.anm.hibernate.DAOException(e);
  		}
  		return flag;
  	}
    
  //@Rohit start New Invoice API VARIANT 
    public OctSlr findSlrObjBySlrCode(String slrCode) {
		Session hibSession = null;
		List retvallist = null;
		OctSlr slrObj = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuilder buffer = new StringBuilder();
			buffer.append("From OctSlr where octslrlcode=:slrCode and octslrisactive='Y' ");
			Query query = hibSession.createQuery(buffer.toString());
			query.setString("slrCode", slrCode);
			retvallist = query.list();
			if (retvallist != null && !retvallist.isEmpty()) {
				slrObj = (OctSlr) retvallist.get(0);
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return slrObj;
	}
  //@Rohit End New Invoice API VARIANT 
  
  ///Start:hemant
    
	public ScrollableResults getSlrDetailsBySellercode() {
		Session hibSession = null;
		ScrollableResults rs = null;
		StringBuilder buffer = new StringBuilder();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			buffer.append("select octslrlcode,allowflush,allowsingleclickflush from OctSlr");
			Query query = hibSession.createQuery(buffer.toString());
			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;

	}
    
    //End:hemant
	//Nishant added TPR-9995
	public List<Object[]> getSellerNameList(){
		Session hibSession = null;
        List<Object[]> result=null;
    	try{
    		String queryString="select slr.octslrlcode,slr.octslrlname,slr.octslrrfnum from OctSlr slr where slr.deleted='N' order by LOWER(octslrname)";    		
    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		Query query = hibSession.createQuery(queryString); 
    		result= query.list();
            
    	}catch(Exception e){
    		throw new  DAOException(e);
		}
    	return result;
	}
	
	//@Suraj.Tiwari
	public List<OctSlr> getSellerListCommChecker(){
		Session hibSession = null;
        List<OctSlr> result=null;
    	try{
    		String queryString="from OctSlr slr where slr.deleted='N' and slr.octslrislisting.paramrfnum is null and  slr.octslrisaccepted = 'Y' order by LOWER(octslrname)";    		
    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		Query query = hibSession.createQuery(queryString); 
    		result= query.list();
            
    	}catch(Exception e){
    		throw new  DAOException(e);
		}
    	return result;
	}
	
	public int findSellerApprovedBySellerCode(String octslrlcode){
		int count = 0;
		Session hibSession = null;
		List retval = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select count(octslrrfnum) From OctSlr where octslrisapprove = 'Y' and octslrlcode=:octslrlcode";
			Query query = hibSession.createQuery(queryString);
			query.setString("octslrlcode", octslrlcode);
            retval = query.list();
			if (!retval.isEmpty()) {
				Object obj = retval.get(0);
				count = Integer.parseInt(obj.toString());
			}
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return count;
	}
	
		//@N Rohit ::: TPR-11028 Start Get All Brand Names
	public List<String> findAllBrandName() {
		Session hibSession = null;
		List<String> codeList = new ArrayList<String>();
		try{
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select distinct(alname) from AttrLov where algroupcode = 'brand' and alisactive = 'Y'");
			codeList = query.list();
		}catch(HibernateException e){
			throw new DAOException(e);
		}	
		return codeList;
	}
	//@N Rohit ::: TPR-11028 End Get All Brand Names
	
	 /*@siddhesh : Utility */
    @SuppressWarnings("unchecked")
    public List<OctSlr> findSellerListNew(){
        Session hibSession = null;
        List<OctSlr> retvalList = null;
        try {
            hibSession = com.anm.hibernate.HibernateConnection.getSession();
            String queryString = "From OctSlr where deleted='N'";
            Query query = hibSession.createQuery(queryString);
            retvalList = query.list();
        } catch (HibernateException e) {
            throw new DAOException(e);
        }
        return retvalList;
    }
    
    //@Nikhil.S SHD
    public String findSellerTypeBySlrcode(String octslrlcode){
        Session hibSession = null;
        String slrType = null;
        List retvalList=null;
        try {
            hibSession = com.anm.hibernate.HibernateConnection.getSession();
            String queryString = "select octslrtype.paramvalue From OctSlr where octslrlcode=:octslrlcode and octslrisactive='Y' and deleted='N'";
            Query query = hibSession.createQuery(queryString);
            query.setString("octslrlcode", octslrlcode);
            retvalList = query.list();
            if(retvalList!=null){
            	slrType = (String) retvalList.get(0);
            }
        } catch (HibernateException e) {
            throw new DAOException(e);
        }
        return slrType;
    }
    
    	/*Download Seller Report*/
	@SuppressWarnings("unchecked")
	public List<OctSlr> downloadReportByCondittion(String sellerName,String sellerCode,Date fromDate, Date toDate,String sellerStatus,String sellerType,String listedSeller)
			throws DAOException {
		Session hibSession = null;
		List<OctSlr> retval = null;
		//Long sellerTypes=new Long(sellerType);
		String strQuery="From OctSlr octSlr where octSlr.deleted='N'";
		try {
			hibSession = HibernateConnection.getSession();

			if (!"".equals(sellerName) && sellerName != null || !"".equals(sellerCode) && sellerCode != null) {
				strQuery += "and (octSlr.octslrname='" + sellerName + "' or octSlr.octslrlcode='" + sellerCode + "' )";
			}
			if(!"".equals(sellerStatus) && "SR".equals(sellerStatus)){
				strQuery += " and octSlr.octslrisaccepted='N'";
			}
			if(!"".equals(sellerStatus) && "SA".equals(sellerStatus)){
				strQuery += " and octSlr.octslrisaccepted='Y'";
			}
			if(!"".equals(sellerStatus) && "IS".equals(sellerStatus)){
				strQuery += " and octSlr.slrincomplete='Y'";
			}
			if(!"".equals(sellerStatus) && "WA".equals(sellerStatus)){
				strQuery += " and octSlr.octslrisaccepted='W'";
			}
			if(!"".equals(sellerStatus) && "AS".equals(sellerStatus)){
				strQuery += " and octSlr.octslrisapprove='Y'";
			}
			if(!"".equals(listedSeller) && listedSeller != null && "Y".equals(listedSeller)){
				strQuery += " and octSlr.octslrislisting='4'";
			}
			if(!"".equals(listedSeller) && listedSeller != null && "N".equals(listedSeller)){
				strQuery += " and octSlr.octslrislisting='5' or octSlr.octslrislisting='6'";
				//strQuery += " or octSlr.octslrislisting.paramvalue='Delist and order process'";
			}
			if (sellerType != null && !"".equals(sellerType) ) {
				strQuery += " and octSlr.octslrtype='" + sellerType + "' ";
			}
			
			if (fromDate != null && toDate != null) {
				strQuery += " and octSlr.createdate Between :fromDate and :toDate";
			}
			strQuery += " order by octSlr.octslrrfnum desc";
			Query query = hibSession.createQuery(strQuery);
			if (fromDate != null && toDate != null) {
				query.setTimestamp("fromDate", fromDate);
				query.setTimestamp("toDate", toDate);
			}
 			retval = query.list();

		} catch (Exception e) {
			throw new DAOException(e);
		}
		return retval;
	}
	//@Nishant added
	public Object[] findSlrDetail(String octslrlcode){
        Session hibSession = null;
        Object[] obj = null;
        List retvalList=null;
        try {
            hibSession = com.anm.hibernate.HibernateConnection.getSession();
            String queryString = "select octslrrfnum,octslrname from OctSlr where octslrlcode=:octslrlcode";
            Query query = hibSession.createQuery(queryString);
            query.setString("octslrlcode", octslrlcode);
            query.setMaxResults(1);
            retvalList = query.list();
            if(retvalList!=null){
            	obj = (Object[])retvalList.get(0);
            }
        } catch (HibernateException e) {
            throw new DAOException(e);
        }
        return obj;
    }
	
	//@Siddhesh : kafka Start
    public String getSlrcode(String slrrfnum ) throws DAOException {
		Session hibSession = null;
		String slrcode = null;
		List<Long> retvalList = null;
		long obj ;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select octslrlcode from OctSlr where octslrrfnum=:slrrfnum");
			query.setString("slrrfnum", slrrfnum);
			retvalList = query.list();
			if(retvalList.size() > 0 && retvalList != null){
				if(retvalList.get(0) != null){
					obj = (long)retvalList.get(0);
					slrcode = Long.toString(obj);
				}
			} 
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		return slrcode;
	}
    //@Siddhesh : kafka End
    
    //@Nikhil.S Get All SellerCodes seller Payout
    public List findAllSellerCodes(){
        Session hibSession = null;
        List retvalList = null;
        try {
            hibSession = com.anm.hibernate.HibernateConnection.getSession();
            String queryString = "select octslrlcode From OctSlr where deleted='N' and octslrisapprove='Y' and octslrisactive='Y' and deleted='N'";
            Query query = hibSession.createQuery(queryString);
            retvalList = query.list();
        } catch (HibernateException e) {
            throw new DAOException(e);
        }
        return retvalList;
    }
    
    //Aniket
    public boolean isSellerListed(String slrCode){
		Session hibSession = null;
        OctSlr result=null;
    	try{
    		String queryString="from OctSlr slr where slr.deleted='N' and slr.octslrislisting.paramcode = 'L_N_O' and slr.octslrislisting.paramgroup = 'LISTING_OREDER_PROCESS' and octslrlcode =:slrCode";    		
    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		Query query = hibSession.createQuery(queryString); 
    		query.setString("slrCode", slrCode);
    		//result= (OctSlr) query.list();
    		if(!query.list().isEmpty()) {
    			return true;
    		}
            
    	}catch(Exception e){
    		throw new  DAOException(e);
		}
    	return false;
	}
    
    public boolean isSellerListedAndApproved(String slrCode){
		Session hibSession = null;
        OctSlr result=null;
    	try{
    		String queryString="from OctSlr slr where slr.deleted='N' and slr.octslrislisting.paramcode = 'L_N_O' and slr.octslrislisting.paramgroup = 'LISTING_OREDER_PROCESS' and slr.octslrisapprove='Y' and octslrlcode =:slrCode";    		
    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		Query query = hibSession.createQuery(queryString); 
    		query.setString("slrCode", slrCode);
    		//result= (OctSlr) query.list();
    		if(!query.list().isEmpty()) {
    			return true;
    		}
            
    	}catch(Exception e){
    		throw new  DAOException(e);
		}
    	return false;
	}

	public String findAppleStoreIdBySellerCode(String sellerCode) {
		Session hibSession = null;
		String appleStoreId = null;
		List<String> retvalList = null;
		try {
			String queryString = "select appleStoreId from OctSlr slr where octslrlcode =:slrCode";
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery(queryString);
			query.setString("slrCode", sellerCode);
			retvalList = query.list();
			if (retvalList != null && !retvalList.isEmpty())
				appleStoreId = retvalList.get(0);

		} catch (Exception e) {
			throw new DAOException(e);
		}
		return appleStoreId;
	}
}
