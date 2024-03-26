/* 
 * Auto Generated on Mon May 04 16:35:42 IST 2015
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
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import com.anm.hibernate.DAOException;
import com.anm.hibernate.SuperDAO;
import com.sellerportal.model.BulkuploadLog;
import com.sellerportal.model.OctSlr;

   
/**
 * Generated DAO Class for bulkupload_log Table.
 *
 * All Queries related to this table should be here.
 * NOTE: 
 *	Do not put user defined queries in the generated DAO class. 
 *	USE hibernate-dao-bulkupload_log-class-code.txt
 * */
public class BulkuploadLogDAO extends SuperDAO
{
     /**
     * Find object by primary key.
     * @param pk the pk of the object to find.
     */
    public  BulkuploadLog findByPK( Serializable pk ) throws com.anm.hibernate.DAOException
    {
        BulkuploadLog retval = null;
        retval = (BulkuploadLog)super.findByPk( pk );
        return retval;
    }
   
    /**
	 * @param obj
	 * @return
	 */
	protected Criteria createCriteria(Object object) {
		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
		Criteria criteria = hibSession.createCriteria(BulkuploadLog.class);
		BulkuploadLog obj = (BulkuploadLog)object;
			//Pk getBulrfnum
			if (obj.getBulrfnum() != null) {
				criteria.add(Expression.eq("bulrfnum", obj.getBulrfnum()));
			}
			if (obj.getBultype() != null) {
				criteria.add(Expression.eq("bultype", obj.getBultype()));
			}
			//Set the many2one and one2one relation objects
						return criteria;
	}
	
	 /** (non-Javadoc)
     * @see com.anm.hibernate.SuperDAO#getPojoObj()
     */
   	protected Object getPojoObj() {  
        return new BulkuploadLog();
    }

	@SuppressWarnings("rawtypes")
	public List findListByUserfilename(String userrefno, String filename,
			String summaryfilename) {
		List retVal=new ArrayList();
		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
		Criteria criteria = hibSession.createCriteria(BulkuploadLog.class);
		if(userrefno!=null && !userrefno.equals("")){
 			criteria.add(Expression.eq("ismubi", new Long(userrefno)));
 		}
 		if(filename!=null && !filename.equals("")){
 			criteria.add(Expression.eq("bulfilename", filename));
 		}
 		if(summaryfilename!=null && !summaryfilename.equals("")){
 			criteria.add(Expression.eq("bulsummaryfilename", summaryfilename));
 		}
 		criteria.add(Expression.eq("deleted", "N"));
 		retVal=criteria.list();
		return retVal;
	}
	
	public List findListBySeller(OctSlr seller, String paramrfnum, int from, int to) {
		List retVal=new ArrayList();
		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
		Criteria criteria = hibSession.createCriteria(BulkuploadLog.class,"bulk");
		if(seller != null){
 			criteria.add(Expression.eq("octslr", seller));
 		}
 		criteria.add(Expression.eq("deleted", "N"));
 		if(paramrfnum != null && !paramrfnum.trim().isEmpty())
 			criteria.add(Expression.eq("bultype.paramrfnum", new Long(paramrfnum)));
 		criteria.setFirstResult(from);
 		criteria.setMaxResults(to);
 		criteria.addOrder(Order.desc("bulrfnum"));
 		retVal=criteria.list();
		return retVal;
	}
	
	public int findListCountBySeller(OctSlr seller, String paramrfnum) {		
		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
		Criteria criteria = hibSession.createCriteria(BulkuploadLog.class);
		criteria.setProjection(Projections.rowCount());
		if(seller != null){
 			criteria.add(Expression.eq("octslr", seller));
 		}
 		criteria.add(Expression.eq("deleted", "N"));
 		if(paramrfnum != null && !paramrfnum.trim().isEmpty())
 			criteria.add(Expression.eq("bultype.paramrfnum", new Long(paramrfnum)));
 		
		 return (int) criteria.uniqueResult(); 
	}
	
	/******************** @Gulab Code For Price Inventory Update Report  Start Here ****************/
	public ScrollableResults findByValue(String Seller ,String Slave,Date startDate,Date endDate ,int From,int to){
		Session hibSession = null;
			ScrollableResults rs = null;
			if(startDate!=null && endDate!=null && startDate.equals(endDate)){			
 				startDate.setHours(23);
 				startDate.setMinutes(59);
 				startDate.setSeconds(59);
 			}
			try {
					hibSession = com.anm.hibernate.HibernateConnection.getSession();
					String queryString = "select bul.octslr.octslrlname,bul.octslr.octslrlcode,bul.bultype,bul.bultype.paramdesc,"
							+ "bul.modidate From BulkuploadLog bul where bul.deleted='N' "
							+ "and bul.bultype.paramdesc in ('INVENTORY','PRICE MANAGEMENT')";
					if(Seller!=null && !"".equals(Seller)){
						queryString+=" and bul.octslr.octslrrfnum=:Seller";
					}
					if(Slave!=null && !"".equals(Slave)){
						queryString+=" ";
					}
					if(startDate!=null && endDate!=null){
						queryString+=" and bul.createdate between :startDate and :endDate";
					}
					
					Query query = hibSession.createQuery(queryString);
					if(Seller!=null && !"".equals(Seller)){
						query.setString("Seller", Seller);
					}
					if(Slave!=null && !"".equals(Slave)){
						query.setString("Slave", Slave);
					}
			 		if(startDate != null && endDate != null){
			 			query.setParameter("startDate", startDate);
	 		            query.setParameter("endDate", endDate);
			 		}
			 		query.setFirstResult(From);
					query.setMaxResults(to);
					rs = query.scroll(ScrollMode.FORWARD_ONLY);
					
				} catch (HibernateException e) {
					throw new DAOException(e);
				}
				return rs;
		
	}
	
	public List<Object> findCountByValue(String Seller ,String Slave,Date startDate,Date endDate){
		Session hibSession = null;
		List<Object> retvalList = null;
			
			if(startDate!=null && endDate!=null && startDate.equals(endDate))
 			{			
 				startDate.setHours(23);
 				startDate.setMinutes(59);
 				startDate.setSeconds(59);
 			}
			try {
					hibSession = com.anm.hibernate.HibernateConnection.getSession();
					String queryString = "select count(*) From BulkuploadLog bul where bul.deleted='N' and bul.bultype.paramdesc in ('INVENTORY','PRICE MANAGEMENT')";
					if(Seller!=null && !"".equals(Seller)){
						queryString+=" and bul.octslr.octslrrfnum=:Seller";
					}
					if(Slave!=null && !"".equals(Slave)){
						queryString+=" ";
					}
					if(startDate!=null && endDate!=null){
						queryString+=" and bul.createdate between :startDate and :endDate";
					}
					Query query = hibSession.createQuery(queryString);
					if(Seller!=null && !"".equals(Seller)){
						query.setString("Seller", Seller);
					}
					if(Slave!=null && !"".equals(Slave)){
						query.setString("Slave", Slave);
					}
			 		if(startDate != null && endDate != null){
			 			query.setParameter("startDate", startDate);
	 		            query.setParameter("endDate", endDate);
			 		}
					retvalList = query.list();
				} catch (HibernateException e) {
					throw new DAOException(e);
				}
				return retvalList;
		
	}
	
	public ScrollableResults downloadReport(String Seller ,String Slave,Date startDate,Date endDate){
		Session hibSession = null;
			ScrollableResults rs = null;
			if(startDate!=null && endDate!=null && startDate.equals(endDate)){			
 				startDate.setHours(23);
 				startDate.setMinutes(59);
 				startDate.setSeconds(59);
 			}
			try {
					hibSession = com.anm.hibernate.HibernateConnection.getSession();
					//String queryString = "From BulkuploadLog bul where bul.deleted='N' and bul.createdate between :startDate and :endDate and bul.bultype.paramdesc in ('INVENTORY','PRICE MANAGEMENT')";
					String queryString = "select bul.octslr.octslrlname,bul.octslr.octslrlcode,bul.bultype,bul.bultype.paramdesc,bul.modidate "
							+ "From BulkuploadLog bul where bul.deleted='N'  and bul.bultype.paramdesc in ('INVENTORY','PRICE MANAGEMENT')";//@suraj
					if(Seller!=null && !"".equals(Seller)){
						queryString+=" and bul.octslr.octslrrfnum=:Seller";
					}
					if(Slave!=null && !"".equals(Slave)){
						queryString+=" ";
					}
			 		if(startDate!=null && endDate!=null){ //@suraj
			 			queryString+=" and bul.createdate between :startDate and :endDate";
			 		}
			 			
					Query query = hibSession.createQuery(queryString);
					if(Seller!=null && !"".equals(Seller)){
						query.setString("Seller", Seller);
					}
					if(Slave!=null && !"".equals(Slave)){
						query.setString("Slave", Slave);
					}
			 		if(startDate != null && endDate != null){
			 			query.setParameter("startDate", startDate);
	 		            query.setParameter("endDate", endDate);
			 		}
			 		rs = query.scroll(ScrollMode.FORWARD_ONLY);
					
				} catch (HibernateException e) {
					throw new DAOException(e);
				}
				return rs;
		
	}
	/******************** @Gulab Code For Price Inventory Update Report  End Here ****************/
	
	//@Gulab progressBar Start
		public Object[] findByBulkUploadUniqueID(String BulkUniqueID){
			Session hibSession = null;
			List<Object[]> retlist =null;
			Object[] obj =null;
			try {
				hibSession = com.anm.hibernate.HibernateConnection.getSession();
				String queryString = "select bul.totalFileRecord,bul.CurrentFileRecord,bul.status From BulkuploadLog bul where bul.deleted='N' and bul.bulkUniqueId='"+BulkUniqueID+"'";
				Query query = hibSession.createQuery(queryString);
				retlist = query.list();
				if(retlist !=null && !retlist.isEmpty()){
					obj = 	retlist.get(0);
				}
			} catch (Exception e) {
				throw new DAOException(e);
			}
			return obj;
		}
		
		public void updateBulkPercentage(String bulkUniqueId,String percentage){
			Session hibSession = null;
				
				try {
					hibSession = com.anm.hibernate.HibernateConnection.getSession();
					Query query = hibSession.createQuery("update BulkuploadLog bul set bul.uploadPercentage ='"+percentage+"' where bul.bulkUniqueId ='"+bulkUniqueId+"'");
					query.executeUpdate();
				} catch (HibernateException e) {
					throw new com.anm.hibernate.DAOException(e);
				
			}
		}
		
		//@Gulab progressBar End
		
		public List<String> getDownloadRecord(Long ubirfnum,int from,int to){
			Session hibSession = null;
			List<String> rcrdLst = new ArrayList<String>();
		
			try{
				hibSession = com.anm.hibernate.HibernateConnection.getSession();
				Query query = hibSession.createQuery("select bulfilename from BulkuploadLog where ismubi=:ismubi order by bulrfnum desc ");
				query.setLong("ismubi", ubirfnum);
				if(from <=0){
					query.setMaxResults(5);
				}else{
					query.setFirstResult(from);
					query.setMaxResults(to);
				}
				rcrdLst=query.list();
				}catch(HibernateException e){
					throw new com.anm.hibernate.DAOException(e);
				}
			return rcrdLst;
		}
	
}
