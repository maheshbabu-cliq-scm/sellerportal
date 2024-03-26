/* 
 * Auto Generated on Thu Mar 05 13:40:13 IST 2015
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
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.type.StandardBasicTypes;

import com.anm.hibernate.DAOException;
import com.anm.hibernate.HibernateConnection;
import com.anm.hibernate.SuperDAO;
import com.sellerportal.model.Ismcmt;
import com.sellerportal.model.SlrCategoryAssociation;



/**
 * 
 *
 * Generated DAO Class for slr_category_association Table.
 *
 * All Queries related to this table should be here.
 * NOTE: 
 *	Do not put user defined queries in the generated DAO class. 
 *	USE hibernate-dao-slr_category_association-class-code.txt
 * */
public class SlrCategoryAssociationDAO extends SuperDAO
{

	/**
	 * Find object by primary key.
	 * @param pk the pk of the object to find.
	 */
	public  SlrCategoryAssociation findByPK( Serializable pk ) throws com.anm.hibernate.DAOException
	{
		SlrCategoryAssociation retval = null;
		retval = (SlrCategoryAssociation)super.findByPk( pk );
		return retval;
	}


	/**
	 * @param obj
	 * @return
	 */
	protected Criteria createCriteria(Object object) {
		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
		Criteria criteria = hibSession.createCriteria(SlrCategoryAssociation.class);

		SlrCategoryAssociation obj = (SlrCategoryAssociation)object;



		//Pk getScarfnum
		if (obj.getScarfnum() != null) {
			criteria.add(Expression.eq("scarfnum", obj.getScarfnum()));
		}

		//Set the many2one and one2one relation objects


		if (obj.getIsmcmt() != null) {
			criteria.add(Expression.eq("ismcmt", obj.getIsmcmt()));
			criteria.setFetchMode("ismcmt", FetchMode.DEFAULT);
		}

		if (obj.getOctSlr() != null) {
			criteria.add(Expression.eq("octSlr", obj.getOctSlr()));
			criteria.setFetchMode("octSlr", FetchMode.DEFAULT);
		}
		return criteria;
	}





	/** (non-Javadoc)
	 * @see com.anm.hibernate.SuperDAO#getPojoObj()
	 */



	protected Object getPojoObj() {  

		return new SlrCategoryAssociation();

	}


	public List findBySellerAndCategoryLevel(Integer level,Long sellerRfNum) {

		Session hibSession = null;
		List retvallist = null;
		SlrCategoryAssociation slrCatObj=null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("from SlrCategoryAssociation slr where slr.cmtlevel=:level and slr.octSlr.octslrrfnum=:slrrfnum and slr.deleted='N'");
			query.setInteger("level", level);
			query.setLong("slrrfnum", sellerRfNum);
			retvallist = query.list();
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return retvallist;
	}



	public List findCategoryLevelBySellerId(Long sellerRfNum) {

		Session hibSession = null;
		List retvallist = null;
		SlrCategoryAssociation slrCatObj=null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("from SlrCategoryAssociation slr where slr.octSlr.octslrrfnum=:slrrfnum and deleted='N'");
			//query.setInteger("level", level);
			query.setLong("slrrfnum", sellerRfNum);
			retvallist = query.list();
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return retvallist;
	}


	public List findCategoryLevelStructureBySellerId(Long sellerRfNum) {

		Session hibSession = null;
		List retvallist = null;
		SlrCategoryAssociation slrCatObj=null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String strQuery="select cpt3.cptcmtrfnum CATEGORY_REF,c4.cmtname CATEGORY,cpt2.cptcmtrfnum SUB_CATEGORY_REF,c3.cmtname SUB_CATEGORY,cpt1.cptcmtrfnum SUB_SUB_CATEGORY_REF, c2.cmtname SUB_SUB_CATEGORY,cpt0.cptcmtrfnum SUB_SUB_SUB_CATEGORY_REF,c1.cmtname SUB_SUB_SUB_CATEGORY  from ismcmt cmt ";
			strQuery +="join ismcpt cpt on cmt.cmtrfnum=cpt.cptcmtrfnum left join ismcpt cpt0 on cpt0.cptcmtrfnum=cmt.cmtrfnum left join ismcpt cpt1 on cpt0.cptcmtrfnum1=cpt1.cptcmtrfnum ";
			strQuery +=" left join ismcpt cpt2 on cpt1.cptcmtrfnum1=cpt2.cptcmtrfnum left join ismcpt cpt3 on cpt2.cptcmtrfnum1=cpt3.cptcmtrfnum left join ismcmt  c0 on c0.cmtrfnum=cpt0.cptcmtrfnum ";
			strQuery +=" left join ismcmt  c1 on c1.cmtrfnum=cpt0.cptcmtrfnum left join ismcmt  c2 on c2.cmtrfnum=cpt1.cptcmtrfnum left join ismcmt  c3 on c3.cmtrfnum=cpt2.cptcmtrfnum ";
			strQuery +="left join ismcmt  c4 on c4.cmtrfnum=cpt3.cptcmtrfnum where cpt0.cptcmtrfnum in (select scacmtrfnum as num  FROM  slr_Category_Association slrCat1 where  slrCat1.cmtlevel=4 and slrCat1.scaslrrfnum="+sellerRfNum+") ";
			strQuery +="AND cpt1.cptcmtrfnum in (select scacmtrfnum as num  FROM   slr_Category_Association slrCat1 where  slrCat1.cmtlevel=3 and slrCat1.scaslrrfnum="+sellerRfNum+") AND cpt2.cptcmtrfnum in (select scacmtrfnum as num  FROM   slr_Category_Association slrCat1 where  slrCat1.cmtlevel=2 and slrCat1.scaslrrfnum="+sellerRfNum+")";
			strQuery +="AND cpt3.cptcmtrfnum in (select scacmtrfnum as num  FROM   slr_Category_Association slrCat1 where  slrCat1.cmtlevel=1 and slrCat1.scaslrrfnum="+sellerRfNum+")";

			SQLQuery query=hibSession.createSQLQuery(strQuery);
			query.addScalar("CATEGORY_REF", StandardBasicTypes.BIG_INTEGER);
			query.addScalar("CATEGORY", StandardBasicTypes.STRING);    		
			query.addScalar("SUB_CATEGORY_REF", StandardBasicTypes.BIG_INTEGER);
			query.addScalar("SUB_CATEGORY", StandardBasicTypes.STRING);
			query.addScalar("SUB_SUB_CATEGORY_REF", StandardBasicTypes.BIG_INTEGER);
			query.addScalar("SUB_SUB_CATEGORY", StandardBasicTypes.STRING);
			query.addScalar("SUB_SUB_SUB_CATEGORY_REF", StandardBasicTypes.BIG_INTEGER);
			query.addScalar("SUB_SUB_SUB_CATEGORY", StandardBasicTypes.STRING);

			retvallist=query.list();		
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return retvallist;
	}



	public List findBySellerAndCategoryLevel(Integer level,Long sellerRfNum,Long parentCmtrfnum) {

		Session hibSession = null;
		List retvallist = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuffer buffer = new StringBuffer();
			buffer.append("select cpt.ismcmtByCptcmtrfnum from Ismcpt cpt where ");
			if(parentCmtrfnum != null){
				buffer.append("cpt.ismcmtByCptcmtrfnum1=:parentCmtrfnum  ");

			}

			if(sellerRfNum !=null){
				if(parentCmtrfnum !=null){
					buffer.append(" and ");
				}
				buffer.append(" cpt.ismcmtByCptcmtrfnum in(select slr.ismcmt from SlrCategoryAssociation slr where  slr.octSlr.octslrrfnum=:slrrfnum ");
				if(level !=null)
				{
					buffer.append(" and slr.cmtlevel=:level ");
				}
				buffer.append("and slr.deleted = 'N' )");



				/*if(parentCmtrfnum != null){
  			  buffer.append("cpt.ismcmtByCptcmtrfnum in(select slr.ismcmt from SlrCategoryAssociation slr where  slr.deleted = 'N'");
  			  buffer.append(")");
  			 } 	*/		  


			}

			buffer.append("and cpt.deleted = 'N' order by cpt.ismcmtByCptcmtrfnum.cmtrfnum");		//MDD 1.8 SD
			Query query = hibSession.createQuery(buffer.toString());
			if(parentCmtrfnum != null){
				query.setLong("parentCmtrfnum", parentCmtrfnum);
			}
			if(level !=null && sellerRfNum !=null)
			{
				query.setInteger("level", level);
			}
			if(sellerRfNum !=null)
			{
				query.setLong("slrrfnum", sellerRfNum);
			}
			retvallist = query.list();
		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return retvallist;
	}

	@SuppressWarnings("rawtypes")
	public List findAllTopCategory(){

		Session hibSession = null;
		List retvallist = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuffer buffer = new StringBuffer();
			buffer.append("select cpt.ismcmtByCptcmtrfnum from Ismcpt cpt where cpt.ismcmtByCptcmtrfnum1=null and cpt.deleted='N' order by cpt.ismcmtByCptcmtrfnum.cmtrfnum");

			Query query = hibSession.createQuery(buffer.toString());    	   
			retvallist = query.list();
		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return retvallist;
	}

	public List findAllCategoryBySeller(Long sellerRfNum) {

		Session hibSession = null;
		List retvallist = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuffer buffer = new StringBuffer();
			buffer.append("select cpt.ismcmtByCptcmtrfnum from Ismcpt cpt where  cpt.ismcmtByCptcmtrfnum in(select slr.ismcmt from SlrCategoryAssociation slr where   slr.octSlr.octslrrfnum=:slrrfnum and slr.deleted = 'N') and cpt.deleted = 'N'");		//MDD 1.8 SD

			Query query = hibSession.createQuery(buffer.toString()); 
			query.setLong("slrrfnum", sellerRfNum);
			retvallist = query.list();
		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return retvallist;
	}


	public List findAllRemovedCategoryBySeller(Long sellerRfNum) {

		Session hibSession = null;
		List retvallist = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuffer buffer = new StringBuffer();
			buffer.append("select cpt.ismcmtByCptcmtrfnum from Ismcpt cpt where  cpt.ismcmtByCptcmtrfnum in(select slr.ismcmt from SlrCategoryAssociation slr where   slr.octSlr.octslrrfnum=:slrrfnum and slr.deleted = 'Y')");

			Query query = hibSession.createQuery(buffer.toString()); 
			query.setLong("slrrfnum", sellerRfNum);
			retvallist = query.list();
		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return retvallist;
	}

	public List<SlrCategoryAssociation> findBySellerCategoryList(String cmtrfnum,String sellerId) {

		Session hibSession = null;
		List<SlrCategoryAssociation> retvallist = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuffer buffer = new StringBuffer();
			buffer.append("from SlrCategoryAssociation slr where slr.deleted = 'N'");
			if(cmtrfnum !=null && !"".equals(cmtrfnum))
				buffer.append(" and slr.ismcmt.cmtrfnum in ("+cmtrfnum+")");
			if(sellerId != null && !"".equals(sellerId))
				buffer.append(" and slr.octSlr.octslrrfnum = "+sellerId+"");
			Query query = hibSession.createQuery(buffer.toString());    	
			retvallist = query.list();
		}catch( HibernateException e){
			throw new  DAOException(e);
		}
		return retvallist;
	}

	//@Rohit Start Extra parameter added for Pagination
	public List<SlrCategoryAssociation> findBySellerAndCategoryList(String cmtrfnum,String categoryName,String sellercode,int from, int max) {

		Session hibSession = null;
		List<SlrCategoryAssociation> retvallist = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuffer buffer = new StringBuffer();
			buffer.append("from SlrCategoryAssociation slr where slr.deleted = 'N'");
			if(cmtrfnum !=null && !"".equals(cmtrfnum))
				buffer.append(" and slr.ismcmt.cmtrfnum in ("+cmtrfnum+")");
			if(categoryName != null && !"".equals(categoryName))
				buffer.append(" and slr.ismcmt.cmtname LIKE '%"+categoryName+"%'");
			if(sellercode != null && !"".equals(sellercode))
				buffer.append(" and slr.octSlr.octslrlcode=:sellercode");
			Query query = hibSession.createQuery(buffer.toString());    		
			query.setString("sellercode", sellercode);
			query.setFirstResult(from);
			query.setMaxResults(max);
			retvallist = query.list();
		}catch( HibernateException e){
			throw new  DAOException(e);
		}
		return retvallist;
	}
	//@Rohit End Extra parameter added for Pagination
	
	//@Rohit start Below Method Added to get total count
	public int findCountBySellerAndCategoryList(String cmtrfnum,String categoryName,String sellercode) {

		Session hibSession = null;
		int count=0;
		List retvallist = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuffer buffer = new StringBuffer();
			buffer.append("select count(scarfnum) from SlrCategoryAssociation slr where slr.deleted = 'N'");
			if(cmtrfnum !=null && !"".equals(cmtrfnum))
				buffer.append(" and slr.ismcmt.cmtrfnum in ("+cmtrfnum+")");
			if(categoryName != null && !"".equals(categoryName))
				buffer.append(" and slr.ismcmt.cmtname LIKE '%"+categoryName+"%'");
			if(sellercode != null && !"".equals(sellercode))
				buffer.append(" and slr.octSlr.octslrlcode=:sellercode ");
			Query query = hibSession.createQuery(buffer.toString());    		
			query.setString("sellercode", sellercode);
			retvallist = query.list();
			if(retvallist!=null && retvallist.size()>0){
				count= Integer.parseInt(retvallist.get(0)+"");
			}
		}catch( HibernateException e){
			throw new  DAOException(e);
		}
		return count;
	}
	//@Rohit End Below Method Added to get total count

	public List<SlrCategoryAssociation> findCategoryAssociationBySellerId(String cmtrfnum,String SellerId,String deleteMark) {


		Session hibSession = null;
		List<SlrCategoryAssociation> retvallist = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuffer buffer = new StringBuffer();
			buffer.append("from SlrCategoryAssociation slr where slr.deleted = '"+deleteMark+"'");
			if(cmtrfnum !=null && !"".equals(cmtrfnum))
				buffer.append(" and slr.ismcmt.cmtrfnum in ("+cmtrfnum+")");
			if(SellerId != null && !"".equals(SellerId))
				buffer.append(" and slr.octSlr.octslrrfnum = "+SellerId+"");
			Query query = hibSession.createQuery(buffer.toString());
			//query.setString("cmtrfnum", cmtrfnum);
			retvallist = query.list();
		}catch( HibernateException e){
			throw new  DAOException(e);
		}
		return retvallist;
	}


	public String getSellerrefByCode(String octslrcode){
		Session hibSession = null;
		List retvallist = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuffer buffer = new StringBuffer();
			buffer.append("select distinct slr.octSlr.octslrrfnum from SlrCategoryAssociation  slr where slr.octSlr.octslrlcode=:octslrcode");
			Query query = hibSession.createQuery(buffer.toString());
			query.setString("octslrcode", octslrcode);
			retvallist = query.list();
		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return String.valueOf(retvallist.get(0));
	}
	public List getTopCategoryBySellerName(String octslrcode){
		Session hibSession = null;
		List retvallist = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuffer buffer = new StringBuffer();
			buffer.append("from SlrCategoryAssociation slr where slr.cmtlevel=1 and slr.octSlr.octslrlcode=:octslrcode"
					+ " and slr.deleted = 'N'");
			Query query = hibSession.createQuery(buffer.toString());
			query.setString("octslrcode", octslrcode);
			retvallist = query.list();
		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return retvallist;
	}
	
	public List getL4CategoryBySellerName(String octslrcode){
		Session hibSession = null;
		List retvallist = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuffer buffer = new StringBuffer();
			buffer.append("from SlrCategoryAssociation slr where slr.cmtlevel=4 and slr.octSlr.octslrlcode=:octslrcode"
					+ " and slr.deleted = 'N'");
			Query query = hibSession.createQuery(buffer.toString());
			query.setString("octslrcode", octslrcode);
			retvallist = query.list();
		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return retvallist;
	}
	
	

	public List findAllCategoryAssociatedName()
	{
		//List<Ismcmt> lstCat=new ArrayList<Ismcmt>();
		List retval = null;
		try
		{

			String strQuery = "select cmtname as CMTNAME,cmtrfnum as CMTID from ismcmt where cmtrfnum in(Select distinct  scacmtrfnum from oct_slr_category_association where isActive='Y')";			

			Session hibSession = null;	  
			hibSession = HibernateConnection.getSession();
			SQLQuery query = hibSession.createSQLQuery(strQuery);
			query.addScalar("CMTNAME", StandardBasicTypes.STRING);
			query.addScalar("CMTID", StandardBasicTypes.LONG);
			retval = query.list();


		}catch(Exception ex)
		{
			String errmsg=ex.getMessage();
		}
		return retval;
	}
	/*seller commission Report HTML Format*/
	public List<SlrCategoryAssociation> findBySellerAndCategoryListReport(String cmtrfnum, String sellercode, String startDate, String endDate, int from, int max) {

		Session hibSession = null;
		List<SlrCategoryAssociation> retvallist = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuffer buffer = new StringBuffer();
			buffer.append("from SlrCategoryAssociation slr where slr.deleted = 'N'");
			if (cmtrfnum != null && !"".equals(cmtrfnum))
				buffer.append(" and slr.ismcmt.cmtrfnum in (" + cmtrfnum + ")");
			if ((startDate != null && !"".equals(startDate)) && (endDate != null && !"".equals(endDate)))
				buffer.append(" and (slr.createdate Between('" + startDate+ "') and ('" + endDate + "'))");

			if (sellercode != null && !"".equals(sellercode))
				buffer.append(" and slr.octSlr.octslrlcode= '" + sellercode	+ "'");
			Query query = hibSession.createQuery(buffer.toString());
			query.setFirstResult(from);
			query.setMaxResults(max);
			retvallist = query.list();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvallist;
	}
	/*seller commission Report Count*/
	//TODO: Meena - Performance Fix
	public int findBySellerAndCategoryListReportCount(String cmtrfnum, String sellercode, String startDate, String endDate) {
		Session hibSession = null;
		int count=0;
		List<SlrCategoryAssociation> retvallist = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuffer buffer = new StringBuffer();
			buffer.append("from SlrCategoryAssociation slr where slr.deleted = 'N'");
			if (cmtrfnum != null && !"".equals(cmtrfnum))
				buffer.append(" and slr.ismcmt.cmtrfnum in (" + cmtrfnum + ")");
			if ((startDate != null && !"".equals(startDate)) && (endDate != null && !"".equals(endDate)))
				buffer.append(" and (slr.createdate Between('" + startDate+ "') and ('" + endDate + "'))");
			if (sellercode != null && !"".equals(sellercode))
				buffer.append(" and slr.octSlr.octslrlcode= '" + sellercode	+ "'");
			Query query = hibSession.createQuery(buffer.toString());
			retvallist = query.list();
			if (!retvallist.isEmpty()) {
				count = retvallist.size();
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return count;
	}
	/*seller commission Report Excel Format*/
	public List<SlrCategoryAssociation> downloadReportByCondition(String cmtrfnum, String sellercode, String startDate, String endDate) {
		Session hibSession = null;
		List<SlrCategoryAssociation> retvallist = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuffer buffer = new StringBuffer();
			buffer.append("from SlrCategoryAssociation slr where slr.deleted = 'N'");
			if (cmtrfnum != null && !"".equals(cmtrfnum))
				buffer.append(" and slr.ismcmt.cmtrfnum in (" + cmtrfnum + ")");
			if ((startDate != null && !"".equals(startDate)) && (endDate != null && !"".equals(endDate)))
				buffer.append(" and (slr.createdate Between('" + startDate+ "') and ('" + endDate + "'))");
			if (sellercode != null && !"".equals(sellercode))
				buffer.append(" and slr.octSlr.octslrlcode= '" + sellercode	+ "'");
			Query query = hibSession.createQuery(buffer.toString());
			retvallist = query.list();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvallist;
	}


	public SlrCategoryAssociation findByCatgoryName(String primaryCategory) {
		Session hibSession = null;
		List retvallist=new ArrayList();
		SlrCategoryAssociation sca=null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuffer buffer = new StringBuffer();
			buffer.append("from SlrCategoryAssociation slr where slr.deleted = 'N' and slr.ismcmt.cmtname=:cmtName");

			Query query = hibSession.createQuery(buffer.toString());
			query.setParameter("cmtName", primaryCategory);
			retvallist = query.list();
			if(retvallist!=null && retvallist.size()>0){
				sca=(SlrCategoryAssociation) retvallist.get(0);
			}
		}catch( HibernateException e){
			throw new  DAOException(e);
		}
		return sca;
	}	
	public SlrCategoryAssociation findBySellerAndCmt(Long cmtRfNum, Long slr){
		SlrCategoryAssociation retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From SlrCategoryAssociation cat where cat.ismcmt.cmtrfnum =:cmtRfNum and cat.octSlr.octslrrfnum =:slr";
			Query query = hibSession.createQuery(queryString);
			query.setLong("cmtRfNum", cmtRfNum);
			query.setLong("slr", slr);
			retvalList = query.list();
			if (retvalList.size() > 0 )
				retval = (SlrCategoryAssociation) retvalList.get(0);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}finally{		
		}
		return retval;
	}


	public SlrCategoryAssociation findBySellerCatgory(String sellerCode,
			String primaryCategory) {
		SlrCategoryAssociation retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From SlrCategoryAssociation cat where cat.ismcmt.cmtcode =:primaryCategory and cat.octSlr.octslrlcode =:sellerCode and cat.deleted = 'N'";  //MDD 1.8 SD
			Query query = hibSession.createQuery(queryString);
			query.setParameter("primaryCategory", primaryCategory);
			query.setParameter("sellerCode", sellerCode);
			retvalList = query.list();
			if (retvalList.size() > 0 )
				retval = (SlrCategoryAssociation) retvalList.get(0);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}finally{		
		}
		return retval;
	}

	public SlrCategoryAssociation findBySellerIdCatgoryCode(String sellerCode,
			String primaryCategory) {
		SlrCategoryAssociation retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From SlrCategoryAssociation cat where cat.ismcmt.cmtcode =:primaryCategory and cat.octSlr.octslrrfnum =:sellerCode and cat.deleted = 'N'";  //MDD 1.8 SD
			Query query = hibSession.createQuery(queryString);
			query.setParameter("primaryCategory", primaryCategory);
			query.setParameter("sellerCode", new Long(sellerCode));
			retvalList = query.list();
			if (retvalList.size() > 0 )
				retval = (SlrCategoryAssociation) retvalList.get(0);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}finally{		
		}
		return retval;
	}

	public List findSellerCatseList(StringBuffer strSellecCat,Long sellerid){
		Session hibSession = null;
		int count = 0;
		List<SlrCategoryAssociation> retvallist = null;
		List<SlrCategoryAssociation> list = new ArrayList<SlrCategoryAssociation>();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuffer buffer = new StringBuffer();
			buffer.append("from SlrCategoryAssociation slr where slr.ismcmt.cmtrfnum in ("+strSellecCat+") and slr.octSlr.octslrrfnum=:sellerCode and slr.deleted = 'N'");
			Query query = hibSession.createQuery(buffer.toString());
			query.setLong("sellerCode", sellerid);
			list=query.list();
		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return list;
	}

	public SlrCategoryAssociation findbyslr(String slrRfNum){
		SlrCategoryAssociation pojo = null;
		Session hibSession = null;
		List<SlrCategoryAssociation> retvallist = null;
		List<SlrCategoryAssociation> list = new ArrayList<SlrCategoryAssociation>();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("from SlrCategoryAssociation slr where slr.octSlr=:slrRfNum and slr.deleted='N'");
			query.setString("slrRfNum", slrRfNum.trim());
			retvallist=query.list();
			if(retvallist.size()>0){
				pojo=(SlrCategoryAssociation)retvallist.get(0);
			}
		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return pojo;
	}

	public SlrCategoryAssociation findBySellerANDCatgoryName(String sellerCode,
			String category) {
		SlrCategoryAssociation retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From SlrCategoryAssociation cat where cat.ismcmt.cmtname =:category and cat.octSlr.octslrlcode =:sellerCode";
			Query query = hibSession.createQuery(queryString);
			query.setString("category", category);
			query.setString("sellerCode", sellerCode);
			retvalList = query.list();
			if (retvalList.size() > 0 )
				retval = (SlrCategoryAssociation) retvalList.get(0);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}finally{		
		}
		return retval;
	}
	
	//@Deepak Deshekar :: As Discuss with manoj sir Start for optimization
		public SlrCategoryAssociation findBySellerANDCatcode(String sellerCode,
				String cmtcode) {
			SlrCategoryAssociation retval = null;
			Session hibSession = null;
			List retvalList = null;
			try {
				hibSession = com.anm.hibernate.HibernateConnection.getSession();
				String queryString = "From SlrCategoryAssociation cat where cat.ismcmt.cmtcode =:cmtcode and cat.octSlr.octslrlcode =:sellerCode and cat.deleted='N'";
				Query query = hibSession.createQuery(queryString);
				query.setParameter("cmtcode", cmtcode);
				query.setParameter("sellerCode", sellerCode);
				retvalList = query.list();
				if (retvalList.size() > 0 )
					retval = (SlrCategoryAssociation) retvalList.get(0);
			} catch (HibernateException e) {
				throw new DAOException(e);
			}finally{		
			}
			return retval;
		}
		//@Deepak Deshekar :: As Discuss with manoj sir Start for optimization
	
	//@Raju TPR-763 26/09/16 start
	public List findBySellerAndCategoryLevelSelectAllOld(String parentCmtrfnumList) {

		Session hibSession = null;
		List retvallist = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String strQuery = "select t1.CPTCMTRFNUM as CMTRFNUM,CASE WHEN t4.CPTCMTRFNUM IS NOT NULL THEN t4.CPTCMTRFNUM || '_'  ELSE '' END || "
					+ "CASE WHEN t3.CPTCMTRFNUM IS NOT NULL THEN '' || t3.CPTCMTRFNUM || '_' ELSE '' END || CASE WHEN t2.CPTCMTRFNUM IS NOT NULL "
					+ "THEN '' || t2.CPTCMTRFNUM || '_' ELSE '' END || CASE WHEN t1.CPTCMTRFNUM IS NOT NULL THEN '' || t1.CPTCMTRFNUM || '' ELSE '' "
					+ "END as ID,c1.CMTNAME as CMTNAME, CASE WHEN c1.CMTLEVEL=4 THEN '' || t4.CPTCMTRFNUM || '_'  || t3.CPTCMTRFNUM || '_'  || "
					+ "t2.CPTCMTRFNUM "
					+ "WHEN c1.CMTLEVEL=3 THEN t3.CPTCMTRFNUM || '_'  || t2.CPTCMTRFNUM WHEN c1.CMTLEVEL=2 THEN '' || t2.CPTCMTRFNUM "
					+ "ELSE '' END as CHAINID"
					+ " from ISMCPT  t1  LEFT OUTER JOIN ISMCPT  t2 ON (t2.CPTCMTRFNUM = t1.CPTCMTRFNUM1)  LEFT OUTER JOIN "
					+ "ISMCPT  t3 ON (t3.CPTCMTRFNUM = t2.CPTCMTRFNUM1)  LEFT OUTER JOIN ISMCPT  t4 ON (t4.CPTCMTRFNUM = t3.CPTCMTRFNUM1)  "
					+ "LEFT OUTER JOIN ISMCPT  t5 ON (t5.CPTCMTRFNUM = t4.CPTCMTRFNUM1)  LEFT OUTER JOIN ISMCPT  t6 ON "
					+ "(t6.CPTCMTRFNUM = t5.CPTCMTRFNUM1)  LEFT OUTER JOIN ISMCPT  t7 ON (t7.CPTCMTRFNUM = t6.CPTCMTRFNUM1)  "
					+ "LEFT OUTER JOIN ISMCPT  t8 ON (t8.CPTCMTRFNUM = t7.CPTCMTRFNUM1)  LEFT OUTER JOIN ISMCPT  t9 ON "
					+ "(t9.CPTCMTRFNUM = t8.CPTCMTRFNUM1)  LEFT OUTER JOIN ISMCPT  t10 ON (t10.CPTCMTRFNUM = t9.CPTCMTRFNUM1)  "
					+ "LEFT OUTER JOIN ISMCMT  c1 ON (c1.CMTRFNUM = t1.CPTCMTRFNUM)  LEFT OUTER JOIN ISMCMT  c2 ON (c2.CMTRFNUM = t2.CPTCMTRFNUM) "
					+ " LEFT OUTER JOIN ISMCMT  c3 ON (c3.CMTRFNUM = t3.CPTCMTRFNUM)  LEFT OUTER JOIN ISMCMT  c4 ON (c4.CMTRFNUM = t4.CPTCMTRFNUM) "
					+ " LEFT OUTER JOIN ISMCMT  c5 ON (c5.CMTRFNUM = t5.CPTCMTRFNUM)  LEFT OUTER JOIN ISMCMT  c6 ON (c6.CMTRFNUM = t6.CPTCMTRFNUM) "
					+ " LEFT OUTER JOIN ISMCMT  c7 ON (c7.CMTRFNUM = t7.CPTCMTRFNUM)  LEFT OUTER JOIN ISMCMT  c8 ON (c8.CMTRFNUM = t8.CPTCMTRFNUM) "
					+ " LEFT OUTER JOIN ISMCMT  c9 ON (c9.CMTRFNUM = t9.CPTCMTRFNUM)  LEFT OUTER JOIN ISMCMT  c10 ON (c10.CMTRFNUM = t10.CPTCMTRFNUM)"
					+ " WHERE t1.CPTCMTRFNUM1 in("+parentCmtrfnumList+") or t1.CPTCMTRFNUM in("+parentCmtrfnumList+") order by t1.CPTCMTRFNUM";


			SQLQuery query=hibSession.createSQLQuery(strQuery);
			query.addScalar("CMTRFNUM", StandardBasicTypes.LONG);
			query.addScalar("ID", StandardBasicTypes.STRING);    		
			query.addScalar("CMTNAME", StandardBasicTypes.STRING);
			query.addScalar("CHAINID", StandardBasicTypes.STRING);

			retvallist = query.list();
		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return retvallist;
	}
	//@Raju TPR-763 26/09/16 end

	//R3.1
	public SlrCategoryAssociation findBySellercodeCatgoryCode(String sellerCode,String categorycode) {
		SlrCategoryAssociation retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "from SlrCategoryAssociation where ismcmt.cmtcode=:categorycode and octSlr.octslrlcode=:sellerCode";
			Query query = hibSession.createQuery(queryString);
			query.setParameter("categorycode", categorycode);
			query.setParameter("sellerCode", sellerCode);
			retvalList = query.list();
			if (retvalList.size() > 0 )
				retval = (SlrCategoryAssociation) retvalList.get(0);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}finally{		
		}
		return retval;
	}
	//R3.1
	//@Parag start method for check seller is Jwl or not
	public int findBySellercodeCatgoryCodeForIntegration(Long slrrfnum,String categorycode) {
		SlrCategoryAssociation retval = null;
		Session hibSession = null;
		List retvalList = null;
		int retCount=0;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select count(*) from SlrCategoryAssociation where ismcmt.cmtcode=:categorycode and octSlr.octslrrfnum=:slrrfnum";
			Query query = hibSession.createQuery(queryString);
			query.setParameter("categorycode", categorycode);
			query.setLong("slrrfnum", slrrfnum);
			retvalList = query.list();
			if (retvalList.size() > 0 && retvalList!=null)
				retCount=(int) retvalList.get(0);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}finally{		
		}
		return retCount;
	}
	//@Parag end method for check seller is Jwl or not
	public List findBySellerAndCategoryLevelSelectAll(List parentCmtrfnumList) {

		Session hibSession = null;
		List retvallist = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String strQuery = "select t1.CPTCMTRFNUM as CMTRFNUM,CASE WHEN t4.CPTCMTRFNUM IS NOT NULL THEN t4.CPTCMTRFNUM || '_'  ELSE '' END || "
					+ "CASE WHEN t3.CPTCMTRFNUM IS NOT NULL THEN '' || t3.CPTCMTRFNUM || '_' ELSE '' END || CASE WHEN t2.CPTCMTRFNUM IS NOT NULL "
					+ "THEN '' || t2.CPTCMTRFNUM || '_' ELSE '' END || CASE WHEN t1.CPTCMTRFNUM IS NOT NULL THEN '' || t1.CPTCMTRFNUM || '' ELSE '' "
					+ "END as ID,c1.CMTNAME as CMTNAME, CASE WHEN c1.CMTLEVEL=4 THEN '' || t4.CPTCMTRFNUM || '_'  || t3.CPTCMTRFNUM || '_'  || "
					+ "t2.CPTCMTRFNUM "
					+ "WHEN c1.CMTLEVEL=3 THEN t3.CPTCMTRFNUM || '_'  || t2.CPTCMTRFNUM WHEN c1.CMTLEVEL=2 THEN '' || t2.CPTCMTRFNUM "
					+ "ELSE '' END as CHAINID"
					+ " from ISMCPT  t1  LEFT OUTER JOIN ISMCPT  t2 ON (t2.CPTCMTRFNUM = t1.CPTCMTRFNUM1 and t2.DELETED = 'N')  LEFT OUTER JOIN "
					+ "ISMCPT  t3 ON (t3.CPTCMTRFNUM = t2.CPTCMTRFNUM1 and t3.DELETED = 'N')  LEFT OUTER JOIN ISMCPT  t4 ON (t4.CPTCMTRFNUM = t3.CPTCMTRFNUM1 and t4.DELETED = 'N')  "
					+ "LEFT OUTER JOIN ISMCPT  t5 ON (t5.CPTCMTRFNUM = t4.CPTCMTRFNUM1 and t5.DELETED = 'N')  LEFT OUTER JOIN ISMCPT  t6 ON "
					+ "(t6.CPTCMTRFNUM = t5.CPTCMTRFNUM1 and t6.DELETED = 'N')  LEFT OUTER JOIN ISMCPT  t7 ON (t7.CPTCMTRFNUM = t6.CPTCMTRFNUM1 and t7.DELETED = 'N')  "
					+ "LEFT OUTER JOIN ISMCPT  t8 ON (t8.CPTCMTRFNUM = t7.CPTCMTRFNUM1 and t8.DELETED = 'N')  LEFT OUTER JOIN ISMCPT t9 ON "
					+ "(t9.CPTCMTRFNUM = t8.CPTCMTRFNUM1 and t9.DELETED = 'N')  LEFT OUTER JOIN ISMCPT  t10 ON (t10.CPTCMTRFNUM = t9.CPTCMTRFNUM1 and t10.DELETED = 'N')  "
					+ "LEFT OUTER JOIN ISMCMT  c1 ON (c1.CMTRFNUM = t1.CPTCMTRFNUM  and c1.CMTISACTIVE = 'Y' and c1.DELETED = 'N')  LEFT OUTER JOIN ISMCMT  c2 ON (c2.CMTRFNUM = t2.CPTCMTRFNUM and c2.CMTISACTIVE = 'Y' and c2.DELETED = 'N') "
					+ " LEFT OUTER JOIN ISMCMT  c3 ON (c3.CMTRFNUM = t3.CPTCMTRFNUM and c3.CMTISACTIVE = 'Y' and c3.DELETED = 'N')  LEFT OUTER JOIN ISMCMT  c4 ON (c4.CMTRFNUM = t4.CPTCMTRFNUM and c4.CMTISACTIVE = 'Y' and c4.DELETED = 'N') "
					+ " LEFT OUTER JOIN ISMCMT  c5 ON (c5.CMTRFNUM = t5.CPTCMTRFNUM and c5.CMTISACTIVE = 'Y' and c5.DELETED = 'N')  LEFT OUTER JOIN ISMCMT  c6 ON (c6.CMTRFNUM = t6.CPTCMTRFNUM and c6.CMTISACTIVE = 'Y' and c6.DELETED = 'N') "
					+ " LEFT OUTER JOIN ISMCMT  c7 ON (c7.CMTRFNUM = t7.CPTCMTRFNUM and c7.CMTISACTIVE = 'Y' and c7.DELETED = 'N')  LEFT OUTER JOIN ISMCMT  c8 ON (c8.CMTRFNUM = t8.CPTCMTRFNUM and c8.CMTISACTIVE = 'Y' and c8.DELETED = 'N') "
					+ " LEFT OUTER JOIN ISMCMT  c9 ON (c9.CMTRFNUM = t9.CPTCMTRFNUM and c9.CMTISACTIVE = 'Y' and c9.DELETED = 'N')  LEFT OUTER JOIN ISMCMT  c10 ON (c10.CMTRFNUM = t10.CPTCMTRFNUM and c10.CMTISACTIVE = 'Y' and c10.DELETED = 'N')"
					+ " WHERE t1.CPTCMTRFNUM1 in (:parentCmtrfnumList) or t1.CPTCMTRFNUM in (:parentCmtrfnumList) and t1.DELETED = 'N' order by t1.CPTCMTRFNUM";


			SQLQuery query=hibSession.createSQLQuery(strQuery);
			if(parentCmtrfnumList!=null && parentCmtrfnumList.size()>0){
				query.setParameterList("parentCmtrfnumList", parentCmtrfnumList);
			}

			query.addScalar("CMTRFNUM", StandardBasicTypes.LONG);
			query.addScalar("ID", StandardBasicTypes.STRING);    		
			query.addScalar("CMTNAME", StandardBasicTypes.STRING);
			query.addScalar("CHAINID", StandardBasicTypes.STRING);

			retvallist = query.list();
		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return retvallist;
	}
	
	//shankar start
	public SlrCategoryAssociation findByCatgoryCode(String primaryCategoryCode) {
		Session hibSession = null;
		List retvallist=new ArrayList();
		SlrCategoryAssociation sca=null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuffer buffer = new StringBuffer();
			buffer.append("from SlrCategoryAssociation slr where slr.deleted = 'N' and slr.ismcmt.cmtcode=:cmtcode");

			Query query = hibSession.createQuery(buffer.toString());
			query.setParameter("cmtcode", primaryCategoryCode);
			retvallist = query.list();
			if(retvallist!=null && retvallist.size()>0){
				sca=(SlrCategoryAssociation) retvallist.get(0);
			}
		}catch( HibernateException e){
			throw new  DAOException(e);
		}
		return sca;
	}
	//shankar end
	
	//hemant start
	public SlrCategoryAssociation findByCatgoryCode(String primaryCategoryCode,String sellerCode) {
		Session hibSession = null;
		List retvallist=new ArrayList();
    	SlrCategoryAssociation sca=null;
    	try {
    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		StringBuffer buffer = new StringBuffer();
    		buffer.append("from SlrCategoryAssociation slr where slr.deleted = 'N' and "
    				+ "slr.ismcmt.cmtcode=:cmtCode and "
    				+ "octSlr.octslrlcode=:sellerCode and slr.deleted='N'");
    		Query query = hibSession.createQuery(buffer.toString());
    		query.setParameter("cmtCode", primaryCategoryCode);
    		query.setParameter("sellerCode", sellerCode);
    	    retvallist = query.list();
    	    if(retvallist!=null && retvallist.size()>0){
    	    	sca=(SlrCategoryAssociation) retvallist.get(0);
    	    }
		}catch( HibernateException e){
			throw new  DAOException(e);
		}
		return sca;
	}
	//hemant end
	
	//@Nikhil.S
	public List<Ismcmt> findBySellerAndCategoryLevelDigital(Integer level) {

		Session hibSession = null;
		List retvallist = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("from Ismcmt where cmtlevel=:level and deleted='N' order by createdate");
			query.setInteger("level", level);
			//query.setMaxResults(1);
			retvallist = query.list();
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return retvallist;
	}
	
	//@Nikhil.S
	
	public List<SlrCategoryAssociation> findBySellerCategoryListDigital(String cmtrfnum) {

		Session hibSession = null;
		List<SlrCategoryAssociation> retvallist = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuffer buffer = new StringBuffer();
			buffer.append("from Ismcmt cmt where cmt.deleted = 'N'");
			if(cmtrfnum !=null && !"".equals(cmtrfnum))
				buffer.append(" and cmt.cmtrfnum in ("+cmtrfnum+")");
			
			Query query = hibSession.createQuery(buffer.toString());    	
			retvallist = query.list();
		}catch( HibernateException e){
			throw new  DAOException(e);
		}
		return retvallist;
	}
	
	public SlrCategoryAssociation findBySellerANDCatgory(String sellerCode,
			String category) {
		SlrCategoryAssociation retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From SlrCategoryAssociation cat where cat.ismcmt.cmtrfnum =:category and cat.octSlr.octslrlcode =:sellerCode";
			Query query = hibSession.createQuery(queryString);
			query.setString("category", category);
			query.setString("sellerCode", sellerCode);
			retvalList = query.list();
			if (retvalList.size() > 0 )
				retval = (SlrCategoryAssociation) retvalList.get(0);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}finally{		
		}
		return retval;
	}
}