/* 
 * Auto Generated on Mon May 17 10:23:20 IST 2010
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
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;

import com.anm.hibernate.DAOException;
import com.anm.hibernate.HibernateConnection;
import com.anm.hibernate.SuperDAO;
import com.sellerportal.model.Ismcmt;


/**
 * 
 *
 * Generated DAO Class for ismcmt Table.
 *
 * All Queries related to this table should be here.
 * NOTE: 
 *	Do not put user defined queries in the generated DAO class. 
 *	USE hibernate-dao-ismcmt-class-code.txt
 * */

public class IsmcmtDAO extends SuperDAO
{

	/**
	 * Find object by primary key.
	 * @param pk the pk of the object to find.
	 */
	public  Ismcmt findByPK( Serializable pk ) throws com.anm.hibernate.DAOException
	{
		Ismcmt retval = null;
		retval = (Ismcmt)super.findByPk( pk );
		return retval;
	}


	/**
	 * @param obj
	 * @return
	 */
	protected Criteria createCriteria(Object object) {
		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
		Criteria criteria = hibSession.createCriteria(Ismcmt.class);

		Ismcmt obj = (Ismcmt)object;

		if (obj.getCmtrfnum() != null) {
			criteria.add(Expression.eq("cmtrfnum", obj.getCmtrfnum()));
		}

		return criteria;
	}





	/** (non-Javadoc)
	 * @see com.anm.hibernate.SuperDAO#getPojoObj()
	 */



	protected Object getPojoObj() {  

		return new Ismcmt();

	}



	/**
	 * @param catalogueID it will take the categoryID will come from session.
	 * @param categoryId  it will take the categoryId will come from session
	 * @return 
	 * @throws DAOException
	 */

	/**
	 * @param categoryParent
	 * @return
	 * @throws DAOException
	 */
	public List findByNameByID(String categoryParent) throws DAOException {
		Session hibSession = null;
		List retval = null;
		try
		{
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("from Ismcmt where cmtrfnum =:categoryParent");
			query.setLong("categoryParent", Long.parseLong(categoryParent));
			retval = query.list();
		}
		catch( HibernateException e )
		{
			throw new com.anm.hibernate.DAOException( e );
		}
		return retval;
	}	


	public List findNameForCVSRfNum(String csvRfNums) {
		List namerfnum = null;
		Session hibSession = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuilder buff = new StringBuilder("select cmtrfnum , cmtname from Ismcmt cmt where cmt.cmtrfnum in (");
			buff.append(csvRfNums).append(") order by  cmt.cmtname ");
			Query query = hibSession.createQuery(buff.toString());
			namerfnum = query.list();
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		return namerfnum;

	} 



	public Ismcmt findByCmtCode(String cmtcode ,boolean isCmtObjReq) throws DAOException {
		Session hibSession = null;
		Ismcmt ismcmt = new Ismcmt();
		List list = new ArrayList();
		String queryStr= "from Ismcmt cmt where cmt.cmtisactive = 'Y' and cmt.cmtcode =:cmtcode and cmt.deleted = 'N'"; //MDD 1.8
		if(isCmtObjReq){
			queryStr +=" and cmt.cmtlevel ='4'";
		}
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery(queryStr);
			query.setString("cmtcode" , cmtcode.trim());
			list =  query.list();
			if(list != null && !list.isEmpty()){
				ismcmt = (Ismcmt) list.get(0);
			}
			else{
				ismcmt = null;
			}

		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		} finally {
			HibernateConnection.commitTransaction();
		}
		return ismcmt;
	}   



	public List<Ismcmt> findByCmtCodeList (String cmtcode) throws DAOException {
		Session hibSession = null;
		List<Ismcmt> list = new ArrayList<Ismcmt>();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("from Ismcmt cmt where cmt.cmtisactive = 'Y' and cmt.cmtcode in ("+cmtcode+")");
			list =  query.list();

		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		return list;
	}   

	/*	Created By Binod Kumar
	 * 	This method returns the list of ISMCMT objects whose ISPARENT value is Y.
	 */
	public List getTopCategoryList()
	{
		Session hibSession = null;
		List listIsmcmt = null;
		try 
		{
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("from Ismcmt cmt where cmt.cmtisparent = 'Y'");

			listIsmcmt =  query.list();

		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		return listIsmcmt;
	}

	/**
	 * @param mctrfnum
	 * @return
	 * @throws DAOException
	 */
	public Ismcmt findmctrfNumBymctname(String cmtname) throws DAOException {
		Ismcmt retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("from Ismcmt cmt where cmt.cmtname like :cmtname");
			query.setString("cmtname", "%"+cmtname+"%");
			retvalList = query.list();
			if (!retvalList.isEmpty())
				retval = (Ismcmt) retvalList.get(0);       
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		return retval;
	}
	public Ismcmt getCtrfNumBymCtname(String cmtname, int catLevel) throws DAOException {
		Ismcmt retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("from Ismcmt cmt where cmt.cmtname like :cmtname and cmt.cmtlevel=:cmtlevel and cmt.cmtisactive = 'Y' and cmt.deleted = 'N' ");
			query.setString("cmtname", cmtname);
			query.setInteger("cmtlevel", catLevel);
			retvalList = query.list();
			if (!retvalList.isEmpty())
				retval = (Ismcmt) retvalList.get(0);       
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		return retval;
	}
	public List getAllSubParentCategories() throws DAOException {
		Session hibSession=null;
		try{
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select cmt.cmtrfnum,cmt.cmtname from Ismcmt cmt where cmt.cmtissubparent='Y'");
			return query.list();		
		}catch(HibernateException e){
			throw new com.anm.hibernate.DAOException( e );
		}
	}


	public List getParentCategoryList() throws DAOException{
		Session hibSession=null;
		try{
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select cmt.cmtrfnum,cmt.cmtname from Ismcmt cmt where cmt.cmtisparent = 'Y' and cmt.cmtisactive = 'Y'");
			return query.list();		
		}catch(HibernateException e){
			throw new com.anm.hibernate.DAOException( e );
		}

	}

	public List getCmtMaxCreateModiDates() {
		Session hibSession=null;
		try{
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select max(createdate),max(modidate) from Ismcmt");
			return query.list();		
		}catch(HibernateException e){
			throw new com.anm.hibernate.DAOException( e );
		}
	} 

	public List<Ismcmt> findCategoriesByCategoryList(List categoryList){
		Session hibSession=null;
		Criteria criteria = null;
		List returnList = null;
		try{
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			criteria = hibSession.createCriteria(Ismcmt.class)
					.add(Restrictions.in("cmtrfnum",categoryList ));

			returnList = criteria.list();

			return returnList;		
		}catch(HibernateException e){
			throw new com.anm.hibernate.DAOException( e );
		}

	}

	public List getCallcenterCategory(String catalogueId)
	{
		Session hibSession = null;
		List listIsmcmt = null;
		try 
		{
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select cmtrfnum,cmtname from Ismcmt cmt where cmt.cmtisccuse = 'Y' and cmt.cmtisactive='Y'");

			listIsmcmt =  query.list();

		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		return listIsmcmt;
	}

	/**
	 * author=Binod
	 * @return
	 * @throws DAOException
	 */
	public List findByAllCategory() throws DAOException {
		Session hibSession = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession
					.createQuery("from Ismcmt cmt where cmt.cmtisactive='Y'");
			return query.list();
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
	}
	public List findIsmcmtByCmtcode(String cmtcode) throws DAOException {
		Session hibSession = null;
		List list = new ArrayList();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select cmt.cmtrfnum from Ismcmt cmt where cmt.cmtcode = :cmtcode");
			query.setString("cmtcode" , cmtcode);
			list =  query.list();
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		return list;
	}

	/**
	 *@author Binod
	 * @param cmtName
	 * @return
	 * @throws DAOException
	 */
	public List findIsmcmtByCmtName(String cmtName) throws DAOException {
		Session hibSession = null;
		List list = new ArrayList();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select cmt.cmtrfnum from Ismcmt cmt where cmt.cmtname = :cmtname");
			query.setString("cmtname" , cmtName);
			list =  query.list();
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		return list;
	}


	public boolean isCategoryExpired(String categoryId) {

		Session session = getSession();
		try {
			StringBuilder queryBuffer = new StringBuilder();
			queryBuffer.append(" select count(cmt.cmtrfnum) from Ismcmt cmt ");
			queryBuffer.append(" WHERE cmt.cmtrfnum = " + categoryId);
			queryBuffer.append(" AND cmt.cmtisactive = 'Y' and cmt.deleted = 'N'");		//MDD 1.8 SD		

			Query query = session.createQuery(queryBuffer.toString());				
			int count  = Integer.parseInt(query.list().get(0).toString());
			if(count != 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	public String isPrimary(String categoryId) {

		Session session = getSession();
		try {
			StringBuilder queryBuffer = new StringBuilder();
			queryBuffer.append(" select count(cmt.cmtrfnum) from Ismcmt cmt ");
			queryBuffer.append(" WHERE cmt.cmtrfnum = " + categoryId);
			queryBuffer.append(" AND cmt.cmtisprimary = 'Y' ");			

			Query query = session.createQuery(queryBuffer.toString());				
			int count  = Integer.parseInt(query.list().get(0).toString());
			if(count != 0)
				return "true";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	public List findIslistingEnableAndIsprimaryCategory() throws DAOException {
		Session hibSession = null;
		List list = new ArrayList();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("from Ismcmt cmt where cmt.cmtisprimary ='Y' and cmt.cmtislistingenable='Y' ");
			list =  query.list();
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		return list;
	}
	public List topToBottomCategoryKmtNmtList(String topcat) throws DAOException {
		Session hibSession = null;
		List list = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			SQLQuery query = hibSession.createSQLQuery("SELECT DISTINCT c1.cmtname AS CATEGORY,c2.cmtname AS SUBCATEGORY,IF(c3.cmtname IS NULL,'',c3.cmtname) AS SUBCATIFANY" +
					",IF(k.ismand IS NULL,'N',k.ismand) AS MANDATORY ,IF(k.kmtname IS NULL,'',k.kmtname) AS ATTRIBUTE,IF(pt.val IS NULL,'',pt.val) AS ATTRVALUE " +
					"FROM ismcpt p JOIN ismcmt c1 ON c1.cmtrfnum=p.cptcmtrfnum LEFT JOIN ismcpt s ON s.cptcmtrfnum1=p.cptcmtrfnum  LEFT JOIN ismcmt c2 ON c2.cmtrfnum=s.cptcmtrfnum " +
					"LEFT JOIN ismcpt s1 ON s1.cptcmtrfnum1=s.cptcmtrfnum LEFT JOIN ismcmt c3 ON c3.cmtrfnum=s1.cptcmtrfnum LEFT JOIN ismkmt k ON k.kmtkgtrfnum=c3.cmtkgtrfnum " +
					"LEFT JOIN (SELECT pkt.pktkmtrfnum,GROUP_CONCAT(nmt.nmtname) AS val FROM ismpkt pkt LEFT JOIN ismnmt nmt ON nmt.nmtrfnum=pkt.pktnmtrfnum) pt ON pt.pktkmtrfnum=k.kmtrfnum  " +
					"WHERE p.cptcmtrfnum IN ("+topcat+") AND IF(c3.cmtname IS NULL,c2.cmtisactive='Y' AND c2.cmtisprimary='Y',c3.cmtisactive='Y' AND c3.cmtisprimary='Y')");

			query.addScalar("CATEGORY",StandardBasicTypes.STRING);
			query.addScalar("SUBCATEGORY",StandardBasicTypes.STRING);
			query.addScalar("SUBCATIFANY",StandardBasicTypes.STRING);
			query.addScalar("MANDATORY",StandardBasicTypes.STRING);
			query.addScalar("ATTRIBUTE",StandardBasicTypes.STRING);
			query.addScalar("ATTRVALUE",StandardBasicTypes.STRING);


			list =  query.list();
			if(list !=null && !list.isEmpty()){
				return list;
			}
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		return list;
	}

	public List findIsBooksCategoryOrNot(Long cmtrfnum) throws DAOException {
		Session hibSession = null;
		List list = new ArrayList();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select cmt.cmtisbooks from Ismcmt cmt where cmt.cmtrfnum=:cmtrfnum and cmt.cmtisbooks='Y'");
			query.setLong("cmtrfnum", cmtrfnum);
			list =  query.list();
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		return list;
	}

	//Get Top Categories
	public List findCategory(Long cmtrfnum) throws DAOException {
		Session hibSession = null;
		List list = new ArrayList();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuilder queryBuffer = new StringBuilder();
			queryBuffer.append("select cpt.ismcmtByCptcmtrfnum.cmtname,cpt.ismcmtByCptcmtrfnum.cmtrfnum,cpt.ismcmtByCptcmtrfnum.costCenter,cpt.ismcmtByCptcmtrfnum.profitCenter from Ismcpt cpt where ");	            
			if(cmtrfnum !=null){
				queryBuffer.append(" cpt.ismcmtByCptcmtrfnum1.cmtrfnum=:cmtrfnum");

			}else{
				queryBuffer.append(" cpt.ismcmtByCptcmtrfnum1 is null");
			}
			Query query = hibSession.createQuery(queryBuffer.toString());
			if(cmtrfnum !=null){
				query.setLong("cmtrfnum", cmtrfnum);
			}	           
			list =  query.list();
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		return list;
	}

	//Get Top Categories
	public List findCategory1(Long cmtrfnum) throws DAOException {
		Session hibSession = null;
		List list = new ArrayList();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuilder queryBuffer = new StringBuilder();
			queryBuffer.append("from Ismcpt cpt where ");	            
			if(cmtrfnum !=null){
				queryBuffer.append(" cpt.ismcmtByCptcmtrfnum1.cmtrfnum=:cmtrfnum");

			}else{
				queryBuffer.append(" cpt.ismcmtByCptcmtrfnum1 is null");
			}
			Query query = hibSession.createQuery(queryBuffer.toString());
			if(cmtrfnum !=null){
				query.setLong("cmtrfnum", cmtrfnum);
			}	           
			list =  query.list();
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		return list;
	}




	public Ismcmt findcmtPojoByCmtName(String cmtName) throws DAOException {
		Ismcmt cmt =null;
		Session hibSession = null;
		List list = new ArrayList();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("from Ismcmt cmt where cmt.cmtname = :cmtname");
			query.setString("cmtname" , cmtName);
			list =  query.list();
			if(list != null && !list.isEmpty()){
				cmt = (Ismcmt)list.get(0);
			}
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		return cmt;
	}


	public List getAllCateogries()
	{
		Session hibSession = null;
		List listIsmcmt = null;
		try 
		{
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select cmtrfnum,cmtname,cmtcode from Ismcmt cmt");

			listIsmcmt =  query.list();

		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		return listIsmcmt;
	}

	public Ismcmt findcmtPojoByCmtCode(String cmtcode){
		Ismcmt cmt =null;
		Session hibSession = null;
		List list = new ArrayList();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("from Ismcmt cmt where cmt.cmtcode = :cmtcode and deleted='N' and cmtisactive='Y'");
			query.setString("cmtcode" , cmtcode.toString().trim());
			list =  query.list();
			if(list != null && !list.isEmpty()){
				cmt = (Ismcmt)list.get(0);
			}
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		return cmt;
	}

	/********	gulab  R 2  Start *************/

	public Ismcmt findBycmtcode(String cmtcode) throws DAOException {
		Session hibSession = null;
		Ismcmt ismcmt = new Ismcmt();
		List list = new ArrayList();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String querystring="from Ismcmt where cmtrfnum in(select ismcmtByCptcmtrfnum.cmtrfnum from Ismcpt"
					+ " where ismcmtByCptcmtrfnum1.cmtrfnum in(select ismcmtByCptcmtrfnum.cmtrfnum"
					+ " from Ismcpt where ismcmtByCptcmtrfnum1.cmtrfnum in(select ismcmtByCptcmtrfnum.cmtrfnum from Ismcpt"
					+ " where ismcmtByCptcmtrfnum1.cmtrfnum in(select ismcmtByCptcmtrfnum.cmtrfnum from"
					+ " Ismcpt where ismcmtByCptcmtrfnum1.cmtrfnum is null)))) and cmtcode=:cmtcode";

			Query query = hibSession.createQuery(querystring);
			query.setString("cmtcode" , cmtcode.trim());
			list =  query.list();
			if(list != null && !list.isEmpty()){
				ismcmt = (Ismcmt) list.get(0);
			}
			else{
				ismcmt = null;
			}

		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		return ismcmt;
	}  
	/********	gulab  R 2  End *************/
	//@suraj
	public List<Object[]> findCategoryByCmt(String  cmtcode){
		Ismcmt cmt =null;
		Session hibSession = null;
		List<Object[]> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select cmt.cmtrfnum,cmt.cmtrequireimg,cmt.prodimgprefix from Ismcmt cmt where cmt.cmtisactive = 'Y' and cmt.cmtcode =:cmtcode");
			query.setString("cmtcode" , cmtcode);
			query.setMaxResults(1);
			retvalList =  query.list();      
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		return retvalList;
	}

	//TPR-4671 : new deduplication logic for APPARELCATEGORY & FOOTWEARCATEGORY

	public List<Object> getL4CatCode(Long cmtrfnum) throws DAOException {  

		Session session = HibernateConnection.getSession();
		List<Object> retval=null;
		Query query = session
				.createQuery("select cmt.cmtcode , cmt.cmtname from Ismcmt cmt where cmt.cmtrfnum = :cmtrfnum "
						+" and cmt.cmtisactive = 'Y'");
		query.setLong("cmtrfnum", cmtrfnum.longValue());
		retval=query.list();
		return retval;
	}

	//TPR-4671 : new deduplication logic for APPARELCATEGORY & FOOTWEARCATEGORY 

	//Nikhil Added for Fashion & Fine-Classification Attribute Sequencing
	public String getCmtCodeByCatId(List<Long> catList) throws DAOException {  
		List<String> retval=null;
		String code = "";
		Session session = HibernateConnection.getSession();
		Query query = session.createQuery("select acc.acacmtrfnum.cmtcode from AttrCategoryAssoc acc where acc.acacmtrfnum.cmtrfnum in(:cmtrfnum)");
		query.setParameterList("cmtrfnum", catList);
		query.setMaxResults(1);
		retval=query.list();
		if(retval!=null){
			code = retval.get(0);
		}

		return code;
	}

	//@nikhil get cmtcode by listingId
	public String getCmtCodeByListingId(String pbilistingid) throws DAOException {  
		List<String> retval=null;
		String code = "";
		Session session = HibernateConnection.getSession();
		Query query = session.createQuery("select ppt.ismcmt.cmtcode from Ismppt ppt where ppt.ismpbi.pbilistingid=:pbilistingid");
		query.setString("pbilistingid", pbilistingid);
		query.setMaxResults(1);
		retval=query.list();
		if(retval!=null){
			code = retval.get(0).substring(0, 5);
		}

		return code;
	}

	//@Deepak Deshekar ::Start 
	public String getCmtCodeBycmtrfnum(Long cmtrfnum) throws DAOException {  
		List<String> retval=null;
		String code = "";
		Session session = HibernateConnection.getSession();
		Query query = session.createQuery("select cmt.cmtcode from Ismcmt cmt where cmt.cmtrfnum = :cmtrfnum");
		query.setLong("cmtrfnum", cmtrfnum);
		query.setMaxResults(1);
		retval=query.list();
		if(retval!=null){
			code = retval.get(0);
		}

		return code;
	}

	//@Deepak Deshekar ::End

	//@Deepak Deshekar :: FINF CATEGORY EXIST OR NOT
	public int findcmtcountCmtCode(String cmtcode){
		int cmtcount =0;
		Session hibSession = null;
		List list = new ArrayList();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select count (cmt.cmtrfnum) from Ismcmt cmt where cmt.cmtcode = :cmtcode and cmt.deleted = 'N' and cmt.cmtisactive = 'Y'");  //MDD 1.8 SD
			query.setString("cmtcode" , cmtcode.toString().trim());
			list =  query.list();
			if(list != null && !list.isEmpty()){
				cmtcount = (int)list.get(0);
			}
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		return cmtcount;
	}
	//@Deepak Deshekar :: FINF CATEGORY EXIST OR NOT

	//@Rohit TPR-8560 :: Digitizing Seller Agreement Start
	public Object[] findLowerCmtRfNum(Long l4CmtRfnum,Long l3CmtRfnum,Long l2CmtRfnum) throws DAOException {
		Session hibSession = null;
		Ismcmt ismcmt = new Ismcmt();
		List<Object[]> retvalList = null;
		Object[] obj = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuilder buffer = new StringBuilder();
			buffer.append("select t1.CPTCMTRFNUM L4rf,t2.CPTCMTRFNUM L3rf,t3.CPTCMTRFNUM L2rf,t4.CPTCMTRFNUM L1rf "
					+ "from ISMCPT  t1 "
					+ "LEFT OUTER JOIN ISMCPT t2 ON (t2.CPTCMTRFNUM = t1.CPTCMTRFNUM1) "
					+ "LEFT OUTER JOIN ISMCPT  t3 ON (t3.CPTCMTRFNUM = t2.CPTCMTRFNUM1) "
					+ "LEFT OUTER JOIN ISMCPT  t4 ON (t4.CPTCMTRFNUM = t3.CPTCMTRFNUM1) "
					+ "LEFT OUTER JOIN ISMCPT  t5 ON (t5.CPTCMTRFNUM = t4.CPTCMTRFNUM1) "
					+ "LEFT OUTER JOIN ISMCPT  t6 ON (t6.CPTCMTRFNUM = t5.CPTCMTRFNUM1) "
					+ "LEFT OUTER JOIN ISMCPT  t7 ON (t7.CPTCMTRFNUM = t6.CPTCMTRFNUM1) "
					+ "LEFT OUTER JOIN ISMCPT  t8 ON (t8.CPTCMTRFNUM = t7.CPTCMTRFNUM1) "
					+ "LEFT OUTER JOIN ISMCPT  t9 ON (t9.CPTCMTRFNUM = t8.CPTCMTRFNUM1) "
					+ "LEFT OUTER JOIN ISMCPT  t10 ON (t10.CPTCMTRFNUM = t9.CPTCMTRFNUM1) "
					+ "LEFT OUTER JOIN ISMCMT  c1 ON (c1.CMTRFNUM = t1.CPTCMTRFNUM) "
					+ "LEFT OUTER JOIN ISMCMT  c2 ON (c2.CMTRFNUM = t2.CPTCMTRFNUM) "
					+ "LEFT OUTER JOIN ISMCMT  c3 ON (c3.CMTRFNUM = t3.CPTCMTRFNUM) "
					+ "LEFT OUTER JOIN ISMCMT  c4 ON (c4.CMTRFNUM = t4.CPTCMTRFNUM) "
					+ "LEFT OUTER JOIN ISMCMT  c5 ON (c5.CMTRFNUM = t5.CPTCMTRFNUM) "
					+ "LEFT OUTER JOIN ISMCMT  c6 ON (c6.CMTRFNUM = t6.CPTCMTRFNUM) "
					+ "LEFT OUTER JOIN ISMCMT  c7 ON (c7.CMTRFNUM = t7.CPTCMTRFNUM) "
					+ "LEFT OUTER JOIN ISMCMT  c8 ON (c8.CMTRFNUM = t8.CPTCMTRFNUM) "
					+ "LEFT OUTER JOIN ISMCMT  c9 ON (c9.CMTRFNUM = t9.CPTCMTRFNUM) "
					+ "LEFT OUTER JOIN ISMCMT  c10 ON (c10.CMTRFNUM = t10.CPTCMTRFNUM) WHERE ");

			if(l4CmtRfnum != null ){
				buffer.append(" t1.CPTCMTRFNUM=:l4CmtRfnum "); 
			}

			if(l3CmtRfnum != null ){
				buffer.append(" t2.CPTCMTRFNUM=:l3CmtRfnum "); 
			}

			if(l2CmtRfnum != null ){
				buffer.append(" t3.CPTCMTRFNUM=:l2CmtRfnum "); 
			}

			SQLQuery query = hibSession.createSQLQuery(buffer.toString());

			if(l4CmtRfnum != null ){
				query.setLong("l4CmtRfnum" , l4CmtRfnum);
			}
			if(l3CmtRfnum != null ){
				query.setLong("l3CmtRfnum" , l3CmtRfnum);
			}
			if(l2CmtRfnum != null ){
				query.setLong("l2CmtRfnum" , l2CmtRfnum);
			}

			query.setMaxResults(1);
			retvalList =  query.list();
			if(!retvalList.isEmpty()){
				obj = retvalList.get(0);
			}
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		return obj;
	}
	
	public long findL1RfnumByCmtName(String cmtName) throws DAOException {
		Session hibSession = null;
		List cmtList = new ArrayList();
		long cmtrfnum = 0;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select cmt.cmtrfnum from Ismcmt cmt where cmt.cmtname =:cmtName and cmt.cmtisactive = 'Y' and cmt.cmtlevel ='1'");
			query.setString("cmtName" , cmtName.trim());
			cmtList =  query.list();
			if(cmtList != null && !cmtList.isEmpty()){
				if(cmtList.get(0) != null)
					cmtrfnum = (Long) cmtList.get(0);
			}
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		return cmtrfnum;
	}
	
	public Object[] findCmtRfNumByCmtName(String l4CatName,String l3CatName,String l2CatName,String l1CatName) throws DAOException {
		Session hibSession = null;
		Ismcmt ismcmt = new Ismcmt();
		List<Object[]> retvalList = null;
		Object[] obj = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuilder buffer = new StringBuilder();
			buffer.append("select t1.CPTCMTRFNUM L4rf,t2.CPTCMTRFNUM L3rf,t3.CPTCMTRFNUM L2rf,t4.CPTCMTRFNUM L1rf "
					+ "from ISMCPT  t1 "
					+ "LEFT OUTER JOIN ISMCPT t2 ON (t2.CPTCMTRFNUM = t1.CPTCMTRFNUM1) "
					+ "LEFT OUTER JOIN ISMCPT  t3 ON (t3.CPTCMTRFNUM = t2.CPTCMTRFNUM1) "
					+ "LEFT OUTER JOIN ISMCPT  t4 ON (t4.CPTCMTRFNUM = t3.CPTCMTRFNUM1) "
					+ "LEFT OUTER JOIN ISMCPT  t5 ON (t5.CPTCMTRFNUM = t4.CPTCMTRFNUM1) "
					+ "LEFT OUTER JOIN ISMCPT  t6 ON (t6.CPTCMTRFNUM = t5.CPTCMTRFNUM1) "
					+ "LEFT OUTER JOIN ISMCPT  t7 ON (t7.CPTCMTRFNUM = t6.CPTCMTRFNUM1) "
					+ "LEFT OUTER JOIN ISMCPT  t8 ON (t8.CPTCMTRFNUM = t7.CPTCMTRFNUM1) "
					+ "LEFT OUTER JOIN ISMCPT  t9 ON (t9.CPTCMTRFNUM = t8.CPTCMTRFNUM1) "
					+ "LEFT OUTER JOIN ISMCPT  t10 ON (t10.CPTCMTRFNUM = t9.CPTCMTRFNUM1) "
					+ "LEFT OUTER JOIN ISMCMT  c1 ON (c1.CMTRFNUM = t1.CPTCMTRFNUM) "
					+ "LEFT OUTER JOIN ISMCMT  c2 ON (c2.CMTRFNUM = t2.CPTCMTRFNUM) "
					+ "LEFT OUTER JOIN ISMCMT  c3 ON (c3.CMTRFNUM = t3.CPTCMTRFNUM) "
					+ "LEFT OUTER JOIN ISMCMT  c4 ON (c4.CMTRFNUM = t4.CPTCMTRFNUM) "
					+ "LEFT OUTER JOIN ISMCMT  c5 ON (c5.CMTRFNUM = t5.CPTCMTRFNUM) "
					+ "LEFT OUTER JOIN ISMCMT  c6 ON (c6.CMTRFNUM = t6.CPTCMTRFNUM) "
					+ "LEFT OUTER JOIN ISMCMT  c7 ON (c7.CMTRFNUM = t7.CPTCMTRFNUM) "
					+ "LEFT OUTER JOIN ISMCMT  c8 ON (c8.CMTRFNUM = t8.CPTCMTRFNUM) "
					+ "LEFT OUTER JOIN ISMCMT  c9 ON (c9.CMTRFNUM = t9.CPTCMTRFNUM) "
					+ "LEFT OUTER JOIN ISMCMT  c10 ON (c10.CMTRFNUM = t10.CPTCMTRFNUM) WHERE ");

			if(l4CatName != null ){
				buffer.append(" c1.CMTNAME=:l4CatName and "); 
			}

			if(l3CatName != null ){
				buffer.append(" c2.CMTNAME=:l3CatName and "); 
			}

			if(l2CatName != null ){
				buffer.append(" c3.CMTNAME=:l2CatName and "); 
			}
			
			if(l1CatName != null ){
				buffer.append(" c4.CMTNAME=:l1CatName "); 
			}

			SQLQuery query = hibSession.createSQLQuery(buffer.toString());

			if(l4CatName != null ){
				query.setString("l4CatName" , l4CatName);
			}
			if(l3CatName != null ){
				query.setString("l3CatName" , l3CatName);
			}
			if(l2CatName != null ){
				query.setString("l2CatName" , l2CatName);
			}
			if(l1CatName != null ){
				query.setString("l1CatName" , l1CatName);
			}

			query.setMaxResults(1);
			retvalList =  query.list();
			if(!retvalList.isEmpty()){
				obj = retvalList.get(0);
			}
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		return obj;
	}
	//@Rohit TPR-8560 :: Digitizing Seller Agreement End
	
	//@Suraj T TPR - 11028 :: Validating CMTCODE

	//@Rohit :: TPR - 11028 : Digital seller agreement changes
	public List<Object[]> findL1RfnumByDigiRfnum(Long digiRfnum) throws DAOException {
		Session hibSession = null;
		List<Object[]> cmtList = new ArrayList<Object[]>();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select cmtrfnum,cmtname from Ismcmt where cmtcode in (select distinct SUBSTR(ismcmt.cmtcode,1,5) from SlrCategoryDigiFee where slrDigiRfnum=:digiRfnum)");
			query.setLong("digiRfnum" , digiRfnum);
			cmtList =  query.list();
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		return cmtList;
	}
	//@Rohit :: TPR - 11028 : Digital seller agreement changes
	
		public String findCmtCodeByCmtname(String cmtname) throws DAOException {
			Session hibSession = null;
			String cmtcode="";
			List list = new ArrayList();
			try {
				hibSession = com.anm.hibernate.HibernateConnection.getSession();
				Query query = hibSession.createQuery("select SUBSTR(cmt.cmtcode,1,5) from Ismcmt cmt where cmt.cmtname = :cmtname");
				query.setString("cmtname" , cmtname);
				list =  query.list();
				if(list!=null && !list.isEmpty()){
					cmtcode = (String) list.get(0);
				}
			} catch (HibernateException e) {
				throw new com.anm.hibernate.DAOException(e);
			}
			return cmtcode;
		}
		
		public List<String> findl1ByCmtname() throws DAOException {
			Session hibSession = null;
			Ismcmt ismcmt = new Ismcmt();
			List list = new ArrayList();
			try {
				hibSession = com.anm.hibernate.HibernateConnection.getSession();
				Query query = hibSession.createQuery("select cmtname from Ismcmt cmt where cmt.cmtisactive = 'Y' and cmt.cmtlevel ='1'");
				list =  query.list();
				
			} catch (HibernateException e) {
				throw new com.anm.hibernate.DAOException(e);
			}
			return list;
		}
		
		public boolean isCatCodeandNameExist(String catcode, String catname) {

			Session session = getSession();
			try {
				StringBuffer queryBuffer = new StringBuffer();
				queryBuffer.append(" select count(cmt.cmtrfnum) from Ismcmt cmt ");
				queryBuffer.append(" WHERE cmt.cmtcode = :catcode and cmt.cmtname = :catname ");
				queryBuffer.append(" AND cmt.cmtisactive = 'Y' ");			
				Query query = session.createQuery(queryBuffer.toString());
				query.setString("catcode" , catcode);
				query.setString("catname" , catname);
				int count  = Integer.parseInt(query.list().get(0).toString());
				if(count != 0)
					return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;

		}
		
				//@siddhes MDD 1.8 SD
		public int findl1catCode(String cmtcode){
			int cmtcount =0;
			Session hibSession = null;
			List list = new ArrayList();
			try {
				hibSession = com.anm.hibernate.HibernateConnection.getSession();
				Query query = hibSession.createQuery("select count (cmt.cmtrfnum) from Ismcmt cmt where cmt.cmtcode = :cmtcode and cmt.cmtlevel ='1' and cmt.deleted = 'N' and cmt.cmtisactive = 'Y'");  //MDD 1.8 SD
				query.setString("cmtcode" , cmtcode.toString().trim());
				list =  query.list();
				if(list != null && list.size() > 0){
					cmtcount = (int)list.get(0);
				}
			} catch (HibernateException e) {
				throw new com.anm.hibernate.DAOException(e);
			}
			return cmtcount;
		}
		
		public String findCmtNameByCmtCode(String cmtcode) throws DAOException {
			Session hibSession = null;
			String cmtname = "";
			List list = new ArrayList();
			try {
				hibSession = com.anm.hibernate.HibernateConnection.getSession();
				Query query = hibSession.createQuery("select cmt.cmtname from Ismcmt cmt where cmt.cmtcode = :cmtcode");
				query.setString("cmtcode" , cmtcode);
				list =  query.list();
				if(list!=null && !list.isEmpty()){
					cmtname = (String) list.get(0);
				}
			} catch (HibernateException e) {
				throw new com.anm.hibernate.DAOException(e);
			}
			return cmtname;
		}
		
		public List<String> findCmtNameListByCmtCode(String cmtcode) throws DAOException {
			Session hibSession = null;
			String cmtname = "";
			List<String> list = new ArrayList();
			try {
				hibSession = com.anm.hibernate.HibernateConnection.getSession();
				Query query = hibSession.createQuery("select cmt.cmtname from Ismcmt cmt where cmt.cmtisactive = 'Y' and cmt.cmtcode in ("+cmtcode+")");
				list =  query.list();
			} catch (HibernateException e) {
				throw new com.anm.hibernate.DAOException(e);
			}
			return list;
		}
		
		//Aniket.s
		public Object[] getParentCategoryNameByCmtrfnum(Long cmtrfnum) throws DAOException {
			Session hibSession = null;
			//List list = new ArrayList();
			List<Object[]> retvalList = null;
			Object[] obj = null;
			try {
				hibSession = com.anm.hibernate.HibernateConnection.getSession();
				SQLQuery query = hibSession.createSQLQuery("select t1.CPTCMTRFNUM p0, c1.CMTNAME  p0n, c1.CMTCODE p0c," + 
						" t2.CPTCMTRFNUM p1,c2.CMTNAME   p1n, c2.CMTCODE p1c,t3.CPTCMTRFNUM p2," + 
						" c3.CMTNAME  p2n, c3.CMTCODE p2c,t4.CPTCMTRFNUM p3,c4.CMTNAME p3n, c4.CMTCODE p3c" + 
						" from ISMCPT  t1" + 
						" LEFT OUTER JOIN ISMCPT  t2 ON (t2.CPTCMTRFNUM = t1.CPTCMTRFNUM1 and t2.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCPT  t3 ON (t3.CPTCMTRFNUM = t2.CPTCMTRFNUM1 and t3.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCPT  t4 ON (t4.CPTCMTRFNUM = t3.CPTCMTRFNUM1 and t4.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCMT  c1 ON (c1.CMTRFNUM = t1.CPTCMTRFNUM and c1.CMTISACTIVE = 'Y' and c1.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCMT  c2 ON (c2.CMTRFNUM = t2.CPTCMTRFNUM and c2.CMTISACTIVE = 'Y' and c2.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCMT  c3 ON (c3.CMTRFNUM = t3.CPTCMTRFNUM and c3.CMTISACTIVE = 'Y' and c3.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCMT  c4 ON (c4.CMTRFNUM = t4.CPTCMTRFNUM and c4.CMTISACTIVE = 'Y' and c4.DELETED = 'N')" + 
						" where t1.DELETED = 'N' and c1.cmtrfnum =:cmtrfnum");
				query.setLong("cmtrfnum", cmtrfnum);
				//list =  query.list();
				retvalList =  query.list();
				if(!retvalList.isEmpty()){
					obj = retvalList.get(0);
				}

			} catch (HibernateException e) {
				throw new com.anm.hibernate.DAOException(e);
			}
			return obj;
		}
		
		public Ismcmt findByCmtrfnum(Long cmtrfnum) {

			Session session = getSession();
			Ismcmt cmt = null;
			List result=null;
			try {
				StringBuilder queryBuffer = new StringBuilder();
				queryBuffer.append("from Ismcmt cmt WHERE cmt.cmtrfnum =:cmtrfnum and cmt.deleted = 'N'");
				Query query = session.createQuery(queryBuffer.toString());
				query.setLong("cmtrfnum", cmtrfnum);
				result = query.list();
				if(result !=null && !result.isEmpty()){
					cmt=(Ismcmt)result.get(0);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return cmt;
		}
		
		public Object[] isSellerAndCategoryExist(List<String> catname,String sellercode) throws DAOException {
			Session hibSession = null;
			//List list = new ArrayList();
			List<Object[]> retvalList = null;
			Object[] obj = null;
			StringBuilder querstring = new StringBuilder();
			try {
				hibSession = com.anm.hibernate.HibernateConnection.getSession();
				querstring.append("select t1.CPTCMTRFNUM p0, t2.CPTCMTRFNUM p1,t3.CPTCMTRFNUM p2,t4.CPTCMTRFNUM p3" + 
						" from ISMCPT  t1" + 
						" LEFT OUTER JOIN ISMCPT  t2 ON (t2.CPTCMTRFNUM = t1.CPTCMTRFNUM1 and t2.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCPT  t3 ON (t3.CPTCMTRFNUM = t2.CPTCMTRFNUM1 and t3.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCPT  t4 ON (t4.CPTCMTRFNUM = t3.CPTCMTRFNUM1 and t4.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCMT  c1 ON (c1.CMTRFNUM = t1.CPTCMTRFNUM and c1.CMTISACTIVE = 'Y' and c1.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCMT  c2 ON (c2.CMTRFNUM = t2.CPTCMTRFNUM and c2.CMTISACTIVE = 'Y' and c2.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCMT  c3 ON (c3.CMTRFNUM = t3.CPTCMTRFNUM and c3.CMTISACTIVE = 'Y' and c3.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCMT  c4 ON (c4.CMTRFNUM = t4.CPTCMTRFNUM and c4.CMTISACTIVE = 'Y' and c4.DELETED = 'N')" +
						" LEFT JOIN oct_slr_category_association CASS ON (CASS.SCACMTRFNUM = c1.CMTRFNUM and c1.CMTISACTIVE = 'Y' and c1.DELETED = 'N') " + 
						" LEFT JOIN OCT_SLR SLR ON (SLR.OCTSLRRFNUM = CASS.SCASLRRFNUM) "+
						" where t1.DELETED = 'N' and c1.cmtname =:l1catname");
				
				/*SQLQuery query = hibSession.createSQLQuery("select c1.cmtrfnum,c2.cmtrfnum,c3.cmtrfnum,c4.cmtrfnum" + 
						" LEFT OUTER JOIN ISMCPT  t2 ON (t2.CPTCMTRFNUM = t1.CPTCMTRFNUM1 and t2.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCPT  t3 ON (t3.CPTCMTRFNUM = t2.CPTCMTRFNUM1 and t3.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCPT  t4 ON (t4.CPTCMTRFNUM = t3.CPTCMTRFNUM1 and t4.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCMT  c1 ON (c1.CMTRFNUM = t1.CPTCMTRFNUM and c1.CMTISACTIVE = 'Y' and c1.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCMT  c2 ON (c2.CMTRFNUM = t2.CPTCMTRFNUM and c2.CMTISACTIVE = 'Y' and c2.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCMT  c3 ON (c3.CMTRFNUM = t3.CPTCMTRFNUM and c3.CMTISACTIVE = 'Y' and c3.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCMT  c4 ON (c4.CMTRFNUM = t4.CPTCMTRFNUM and c4.CMTISACTIVE = 'Y' and c4.DELETED = 'N')" +
						" LEFT JOIN oct_slr_category_association CASS ON (CASS.SCACMTRFNUM = c1.CMTRFNUM and c1.CMTISACTIVE = 'Y' and c1.DELETED = 'N') " + 
						" LEFT JOIN OCT_SLR SLR ON (SLR.OCTSLRRFNUM = CASS.SCASLRRFNUM) "+
						" where t1.DELETED = 'N'  and c1.cmtname =:l1catname");*/
				if(catname.size()  == 2) {
					if(catname.size() >= 1 && !catname.get(1).isEmpty()){
						querstring.append(" and c2.cmtname =:l2catname ");
					}
				}
				
				if(catname.size()  == 3) {
					if(catname.size() >= 1 && !catname.get(2).isEmpty()){
						querstring.append(" and c2.cmtname =:l2catname ");
					}
					if(catname.size() >= 2 && !catname.get(1).isEmpty()){
						querstring.append(" and c3.cmtname =:l3catname ");
					}
				}
				
				if(catname.size()  == 4) {
					if(catname.size() >= 1 && !catname.get(2).isEmpty()){
						querstring.append(" and c2.cmtname =:l2catname ");
					}
					if(catname.size() >= 2 && !catname.get(1).isEmpty()){
						querstring.append(" and c3.cmtname =:l3catname ");
					}
					if(catname.size() >= 3 && !catname.get(0).isEmpty()){
						querstring.append(" and c4.cmtname =:l4catname ");
					}
				}
				
				querstring.append(" AND SLR.OCTSLRLCODE =:sellercode ");
				
				SQLQuery query = hibSession.createSQLQuery(querstring.toString());
				if(catname.size() == 1 && !catname.get(0).isEmpty()){
					query.setString("l1catname", catname.get(0));
				}
				if(catname.size() == 2){
					query.setString("l1catname", catname.get(1));
					query.setString("l2catname", catname.get(0));
				}
				if(catname.size() == 3){
					query.setString("l1catname", catname.get(2));
					query.setString("l2catname", catname.get(1));
					query.setString("l3catname", catname.get(0));
				}
				if(catname.size() == 4){
					query.setString("l1catname", catname.get(3));
					query.setString("l2catname", catname.get(2));
					query.setString("l3catname", catname.get(1));
					query.setString("l4catname", catname.get(0));
				}
				//query.setString("l1catname", catname.get(3));
				/*if(catname.size() >= 1 && !catname.get(2).isEmpty()){
					query.setString("l2catname", catname.get(2));
				}
				if(catname.size() >= 2 && !catname.get(1).isEmpty()){
					query.setString("l3catname", catname.get(1));
				}
				if(catname.size() >= 3 && !catname.get(0).isEmpty()){
					query.setString("l4catname", catname.get(0));
				}*/
				query.setString("sellercode", sellercode);
				//list =  query.list();
				retvalList =  query.list();
				if(!retvalList.isEmpty()){
					obj = retvalList.get(0);
				}

			} catch (HibernateException e) {
				throw new com.anm.hibernate.DAOException(e);
			}
			return obj;
		}
		
		public Object[] getParentCategoryNameByCmtcode(String cmtcode) throws DAOException {
			Session hibSession = null;
			//List list = new ArrayList();
			List<Object[]> retvalList = null;
			Object[] obj = null;
			try {
				hibSession = com.anm.hibernate.HibernateConnection.getSession();
				SQLQuery query = hibSession.createSQLQuery("select t1.CPTCMTRFNUM p0, c1.CMTNAME  p0n, c1.CMTCODE p0c," + 
						" t2.CPTCMTRFNUM p1,c2.CMTNAME   p1n, c2.CMTCODE p1c,t3.CPTCMTRFNUM p2," + 
						" c3.CMTNAME  p2n, c3.CMTCODE p2c,t4.CPTCMTRFNUM p3,c4.CMTNAME p3n, c4.CMTCODE p3c" + 
						" from ISMCPT  t1" + 
						" LEFT OUTER JOIN ISMCPT  t2 ON (t2.CPTCMTRFNUM = t1.CPTCMTRFNUM1 and t2.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCPT  t3 ON (t3.CPTCMTRFNUM = t2.CPTCMTRFNUM1 and t3.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCPT  t4 ON (t4.CPTCMTRFNUM = t3.CPTCMTRFNUM1 and t4.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCMT  c1 ON (c1.CMTRFNUM = t1.CPTCMTRFNUM and c1.CMTISACTIVE = 'Y' and c1.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCMT  c2 ON (c2.CMTRFNUM = t2.CPTCMTRFNUM and c2.CMTISACTIVE = 'Y' and c2.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCMT  c3 ON (c3.CMTRFNUM = t3.CPTCMTRFNUM and c3.CMTISACTIVE = 'Y' and c3.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCMT  c4 ON (c4.CMTRFNUM = t4.CPTCMTRFNUM and c4.CMTISACTIVE = 'Y' and c4.DELETED = 'N')" + 
						" where t1.DELETED = 'N' and c1.cmtcode =:cmtcode");
				query.setString("cmtcode", cmtcode);
				//list =  query.list();
				retvalList =  query.list();
				if(!retvalList.isEmpty()){
					obj = retvalList.get(0);
				}

			} catch (HibernateException e) {
				throw new com.anm.hibernate.DAOException(e);
			}
			return obj;
		}
		
		
		public Object[] getCategoryRelation(List<String> catname) throws DAOException {
			Session hibSession = null;
			//List list = new ArrayList();
			List<Object[]> retvalList = null;
			Object[] obj = null;
			StringBuilder querstring = new StringBuilder();
			try {
				hibSession = com.anm.hibernate.HibernateConnection.getSession();
				querstring.append("select t1.CPTCMTRFNUM p0, t2.CPTCMTRFNUM p1,t3.CPTCMTRFNUM p2,t4.CPTCMTRFNUM p3" + 
						" from ISMCPT  t1" + 
						" LEFT OUTER JOIN ISMCPT  t2 ON (t2.CPTCMTRFNUM = t1.CPTCMTRFNUM1 and t2.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCPT  t3 ON (t3.CPTCMTRFNUM = t2.CPTCMTRFNUM1 and t3.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCPT  t4 ON (t4.CPTCMTRFNUM = t3.CPTCMTRFNUM1 and t4.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCMT  c1 ON (c1.CMTRFNUM = t1.CPTCMTRFNUM and c1.CMTISACTIVE = 'Y' and c1.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCMT  c2 ON (c2.CMTRFNUM = t2.CPTCMTRFNUM and c2.CMTISACTIVE = 'Y' and c2.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCMT  c3 ON (c3.CMTRFNUM = t3.CPTCMTRFNUM and c3.CMTISACTIVE = 'Y' and c3.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCMT  c4 ON (c4.CMTRFNUM = t4.CPTCMTRFNUM and c4.CMTISACTIVE = 'Y' and c4.DELETED = 'N')" +
						" LEFT JOIN oct_slr_category_association CASS ON (CASS.SCACMTRFNUM = c1.CMTRFNUM and c1.CMTISACTIVE = 'Y' and c1.DELETED = 'N') " + 
						" LEFT JOIN OCT_SLR SLR ON (SLR.OCTSLRRFNUM = CASS.SCASLRRFNUM) "+
						" where t1.DELETED = 'N' and c1.cmtname =:l1catname");
				
				if(catname.size()  == 2) {
					if(catname.size() >= 1 && !catname.get(1).isEmpty()){
						querstring.append(" and c2.cmtname =:l2catname ");
					}
				}
				
				if(catname.size()  == 3) {
					if(catname.size() >= 1 && !catname.get(2).isEmpty()){
						querstring.append(" and c2.cmtname =:l2catname ");
					}
					if(catname.size() >= 2 && !catname.get(1).isEmpty()){
						querstring.append(" and c3.cmtname =:l3catname ");
					}
				}
				
				if(catname.size()  == 4) {
					if(catname.size() >= 1 && !catname.get(2).isEmpty()){
						querstring.append(" and c2.cmtname =:l2catname ");
					}
					if(catname.size() >= 2 && !catname.get(1).isEmpty()){
						querstring.append(" and c3.cmtname =:l3catname ");
					}
					if(catname.size() >= 3 && !catname.get(0).isEmpty()){
						querstring.append(" and c4.cmtname =:l4catname ");
					}
				}
				
				
				SQLQuery query = hibSession.createSQLQuery(querstring.toString());
				if(catname.size() == 1 && !catname.get(0).isEmpty()){
					query.setString("l1catname", catname.get(0));
				}
				if(catname.size() == 2){
					query.setString("l1catname", catname.get(1));
					query.setString("l2catname", catname.get(0));
				}
				if(catname.size() == 3){
					query.setString("l1catname", catname.get(2));
					query.setString("l2catname", catname.get(1));
					query.setString("l3catname", catname.get(0));
				}
				if(catname.size() == 4){
					query.setString("l1catname", catname.get(3));
					query.setString("l2catname", catname.get(2));
					query.setString("l3catname", catname.get(1));
					query.setString("l4catname", catname.get(0));
				}
				
				//list =  query.list();
				retvalList =  query.list();
				if(!retvalList.isEmpty()){
					obj = retvalList.get(0);
				}

			} catch (HibernateException e) {
				throw new com.anm.hibernate.DAOException(e);
			}
			return obj;
		}
		
		public boolean isCategoryRelationExist(List<String> catname) throws DAOException {
			Session hibSession = null;
			//List list = new ArrayList();
			List<Object[]> retvalList = null;
			boolean isExist = false;
			StringBuilder querstring = new StringBuilder();
			try {
				hibSession = com.anm.hibernate.HibernateConnection.getSession();
				querstring.append("select distinct t1.CPTCMTRFNUM p0, t2.CPTCMTRFNUM p1,t3.CPTCMTRFNUM p2,t4.CPTCMTRFNUM p3" + 
						" from ISMCPT  t1" + 
						" LEFT OUTER JOIN ISMCPT  t2 ON (t2.CPTCMTRFNUM = t1.CPTCMTRFNUM1 and t2.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCPT  t3 ON (t3.CPTCMTRFNUM = t2.CPTCMTRFNUM1 and t3.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCPT  t4 ON (t4.CPTCMTRFNUM = t3.CPTCMTRFNUM1 and t4.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCMT  c1 ON (c1.CMTRFNUM = t1.CPTCMTRFNUM and c1.CMTISACTIVE = 'Y' and c1.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCMT  c2 ON (c2.CMTRFNUM = t2.CPTCMTRFNUM and c2.CMTISACTIVE = 'Y' and c2.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCMT  c3 ON (c3.CMTRFNUM = t3.CPTCMTRFNUM and c3.CMTISACTIVE = 'Y' and c3.DELETED = 'N')" + 
						" LEFT OUTER JOIN ISMCMT  c4 ON (c4.CMTRFNUM = t4.CPTCMTRFNUM and c4.CMTISACTIVE = 'Y' and c4.DELETED = 'N')" +
						" LEFT JOIN oct_slr_category_association CASS ON (CASS.SCACMTRFNUM = c1.CMTRFNUM and c1.CMTISACTIVE = 'Y' and c1.DELETED = 'N') " + 
						" LEFT JOIN OCT_SLR SLR ON (SLR.OCTSLRRFNUM = CASS.SCASLRRFNUM) "+
						" where t1.DELETED = 'N' and c1.cmtname =:l1catname");
				
				if(catname.size()  == 2) {
					if(catname.size() >= 1 && !catname.get(1).isEmpty()){
						querstring.append(" and c2.cmtname =:l2catname ");
					}
				}
				
				if(catname.size()  == 3) {
					if(catname.size() >= 1 && !catname.get(2).isEmpty()){
						querstring.append(" and c2.cmtname =:l2catname ");
					}
					if(catname.size() >= 2 && !catname.get(1).isEmpty()){
						querstring.append(" and c3.cmtname =:l3catname ");
					}
				}
				
				if(catname.size()  == 4) {
					if(catname.size() >= 1 && !catname.get(2).isEmpty()){
						querstring.append(" and c2.cmtname =:l2catname ");
					}
					if(catname.size() >= 2 && !catname.get(1).isEmpty()){
						querstring.append(" and c3.cmtname =:l3catname ");
					}
					if(catname.size() >= 3 && !catname.get(0).isEmpty()){
						querstring.append(" and c4.cmtname =:l4catname ");
					}
				}
				
				SQLQuery query = hibSession.createSQLQuery(querstring.toString());
				if(catname.size() == 1 && !catname.get(0).isEmpty()){
					query.setString("l1catname", catname.get(0));
				}
				if(catname.size() == 2){
					query.setString("l1catname", catname.get(1));
					query.setString("l2catname", catname.get(0));
				}
				if(catname.size() == 3){
					query.setString("l1catname", catname.get(2));
					query.setString("l2catname", catname.get(1));
					query.setString("l3catname", catname.get(0));
				}
				if(catname.size() == 4){
					query.setString("l1catname", catname.get(3));
					query.setString("l2catname", catname.get(2));
					query.setString("l3catname", catname.get(1));
					query.setString("l4catname", catname.get(0));
				}
				
				//list =  query.list();
				retvalList =  query.list();
				if(!retvalList.isEmpty()){
					isExist = true;
				}

			} catch (HibernateException e) {
				throw new com.anm.hibernate.DAOException(e);
			}
			return isExist;
		}
		
		
		public Ismcmt getCategoryBymCtname(String cmtname, int catLevel) throws DAOException {
			Ismcmt retval = null;
			Session hibSession = null;
			List retvalList = null;
			try {
				hibSession = com.anm.hibernate.HibernateConnection.getSession();
				Query query = hibSession.createQuery("from Ismcmt cmt where cmt.cmtname =:cmtname and cmt.cmtlevel=:cmtlevel and cmt.cmtisactive = 'Y' and cmt.deleted = 'N' ");
				query.setParameter("cmtname", cmtname);
				query.setInteger("cmtlevel", catLevel);
				retvalList = query.list();
				if (!retvalList.isEmpty())
					retval = (Ismcmt) retvalList.get(0);       
			} catch (HibernateException e) {
				throw new com.anm.hibernate.DAOException(e);
			}
			return retval;
		}
		//Aniket.e
		
		public List<Ismcmt> getCategoryBymCmtLevel(int cmtlevel) throws DAOException {
            Session hibSession = null;
            List retvalList = null;
            try {
                hibSession = com.anm.hibernate.HibernateConnection.getSession();
                Query query = hibSession.createQuery("from Ismcmt cmt where cmt.cmtlevel=:cmtlevel and cmt.cmtisactive = 'Y' and cmt.deleted = 'N' ");
                query.setInteger("cmtlevel", cmtlevel);
                retvalList = query.list();   
            } catch (HibernateException e) {
                throw new com.anm.hibernate.DAOException(e);
            }
            return retvalList;
        }
}