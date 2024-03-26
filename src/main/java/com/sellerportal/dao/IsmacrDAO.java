/* 
 * Auto Generated on Mon May 17 10:23:29 IST 2010
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

// Octashop specific imports START

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
// Octashop specific imports END
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import com.anm.hibernate.DAOException;
import com.anm.hibernate.SuperDAO;
import com.sellerportal.model.Ismacr;

   
/**
 * 
 *
 * Generated DAO Class for ismacr Table.
 *
 * All Queries related to this table should be here.
 * NOTE: 
 *	Do not put user defined queries in the generated DAO class. 
 *	USE hibernate-dao-ismacr-class-code.txt
 * */
public class IsmacrDAO extends SuperDAO
{

     /**
     * Find object by primary key.
     * @param pk the pk of the object to find.
     */
    public  Ismacr findByPK( Serializable pk ) throws com.anm.hibernate.DAOException
    {
        Ismacr retval = null;
        retval = (Ismacr)super.findByPk( pk );
        return retval;
    }

   
    /**
	 * @param obj
	 * @return
	 */
	protected Criteria createCriteria(Object object) {
		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
		Criteria criteria = hibSession.createCriteria(Ismacr.class);
		
		Ismacr obj = (Ismacr)object;
					
									
									
			//Pk getComp_id().getAcracmrfnum
			if (obj.getComp_id() != null && obj.getComp_id().getAcracmrfnum() != null) {
				criteria.add(Expression.eq("comp_id.acracmrfnum", obj.getComp_id().getAcracmrfnum()));
			}
												
			//Pk getComp_id().getAcrarmrfnum
			if (obj.getComp_id() != null && obj.getComp_id().getAcrarmrfnum() != null) {
				criteria.add(Expression.eq("comp_id.acrarmrfnum", obj.getComp_id().getAcrarmrfnum()));
			}
									
			//Set the many2one and one2one relation objects
			
						return criteria;
	}
	
	
	 
	
	
	 /** (non-Javadoc)
     * @see com.anm.hibernate.SuperDAO#getPojoObj()
     */
     
     
   
   	protected Object getPojoObj() {  
   		      
        return new Ismacr();
        
    }
    
    
   // User Code - STARTS
   /**
     * Fetch Records matching the userId, command, and Page name
     *
     * @param obj The object to base the search on.
     *
     * @return A list of objects that match the object passed in.
     */
    public  List findByUserIdCommandPageName(Long userId,String pageName,String command ) throws com.anm.hibernate.DAOException
    {
        List retval = new ArrayList();
        Session hibSession = null;
        try
        {
            hibSession = com.anm.hibernate.HibernateConnection.getSession();
            String queryString  = "from Ismacr acr " +
            		" WHERE acr.ismarm in " +
            		" (select aur.ismarm from Ismaur aur where aur.ismubi.ubirfnum=:userId and aur.deleted='N' and aur.active='Y') " +
            		" AND acr.ismacm in " +
            		" ( from Ismacm acm where acm.command=:commandName AND acm.ismapm.apmpagename=:pageName) and acr.deleted='N'";
            Query query = hibSession.createQuery(queryString);
			query.setLong("userId",userId.longValue());
			query.setString("commandName",command);
			query.setString("pageName",pageName);
			retval = query.list();
        }
		catch( HibernateException e )
		{
            throw new com.anm.hibernate.DAOException( e );
        }
        finally
        {
        	
        }
        return retval;
    }
    
    public  List findByUserIdOrCommandOrPageName(Long userId,String pageName,String command ) throws com.anm.hibernate.DAOException
    {
    	List retval = new ArrayList();
		Session hibSession = null;
		StringBuffer sb = new StringBuffer();
		try
		{
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "";
			boolean check = true;
			sb.append("select ismacm.ismapm.apmpagetitle || '-' || ismacm.ismapm.apmpagename,ismacm.command from Ismacr acr WHERE acr.ismarm in (select aur.ismarm from Ismaur aur where aur.ismubi.ubirfnum=:userId and aur.deleted='N' and aur.active='Y') and acr.deleted = 'N' and ismacm.ismapm.active = 'Y'"); 

			if(command!=null && !command.equals("") && pageName!=null && !pageName.equals("")){
				sb.append("AND acr.ismacm in (from Ismacm acm where acm.command=:command AND acm.ismapm.apmpagename=:pageName)");
				check = false;
			}

			if(check && command!=null && !command.equals("")){
				sb.append("AND acr.ismacm in (from Ismacm acm where acm.command=:command");
			}
			if(check && pageName!=null && !pageName.equals("")){
				sb.append("AND acr.ismacm in (from Ismacm acm where acm.ismapm.apmpagename=:pageName");
			}

			queryString = sb.toString();
			Query query = hibSession.createQuery(queryString);
			query.setLong("userId",userId.longValue());
			if(command!=null && !command.equals("")){
				query.setString("command",command);
			}
			if(pageName!=null && !pageName.equals("")){
				query.setString("pageName",pageName);
			}
			
			retval = query.list();
		}
		catch( HibernateException e )
		{
			throw new com.anm.hibernate.DAOException( e );
		}
		finally
		{

		}
		return retval;
    }
    
    
   
   /**
     * @param armrfnum
     * @param cmrfnum
     * @return
     * @throws DAOException
     * Deleted Flag='N'
     */
    public List findBothRfNum(Long armrfnum,Long acmrfnum) throws DAOException {

       	Session hibSession = null;
       	List retval = null;
       	try {
       		hibSession = com.anm.hibernate.HibernateConnection.getSession();
       	
       		Query query = hibSession
       				.createQuery("select acr.ismacm.acmrfnum ,acr.ismarm.armrfnum from Ismacr acr where acr.ismarm.armrfnum=:armrfnum And acr.ismacm.acmrfnum=:acmrfnum and acr.deleted='N'");
       		query.setLong("armrfnum",armrfnum.longValue());
       		query.setLong("acmrfnum",acmrfnum.longValue()); 		   		
       		
       		
       		
       				
       		return query.list();
       	} catch (HibernateException e) {
       		throw new com.anm.hibernate.DAOException(e);
       	} finally {

       	}
       } 
    
    /**
     * @param armrfnum
     * @param cmrfnum
     * @return
     * @throws DAOException
     */
    
    public List findByBothRfNum(Long armrfnum,Long acmrfnum) throws DAOException {

       	Session hibSession = null;
       	List retval = null;
       	try {
       		hibSession = com.anm.hibernate.HibernateConnection.getSession();
       	
       		Query query = hibSession
       				.createQuery("from Ismacr acr where acr.ismarm.armrfnum=:armrfnum And acr.ismacm.acmrfnum=:acmrfnum");
       		query.setLong("armrfnum",armrfnum.longValue());
       		query.setLong("acmrfnum",acmrfnum.longValue()); 		   		
       		
       		
       		
       				
       		return query.list();
       	} catch (HibernateException e) {
       		throw new com.anm.hibernate.DAOException(e);
       	} finally {

       	}
       }
    
  /**
   * 
   * @param armrfnum
   * @param apmrfnum
   * @return
   * @throws DAOException
   */
    public List findByArmRfNumNApmRfnum(Long armrfnum,Long apmrfnum) throws DAOException {
       	Session hibSession = null;
       	List retval = null;
       	try {
       		hibSession = com.anm.hibernate.HibernateConnection.getSession();
       	
       		Query query = hibSession
       				.createQuery("from Ismacr acr where acr.ismarm.armrfnum=:armrfnum and acr.ismacm.ismapm.apmrfnum=:apmrfnum ");
       		query.setLong("armrfnum",armrfnum.longValue());
       		query.setLong("apmrfnum",apmrfnum.longValue());
       		
       		return query.list();
       	} catch (HibernateException e) {
       		throw new com.anm.hibernate.DAOException(e);
       	} finally {

       	}
       }  
   
    /**
     * 
     * @param armrfnum
     * @return
     * @throws DAOException
     */
    public List findByArmRfNum(Long armrfnum) throws DAOException {
       	Session hibSession = null;
       	List retval = null;
       	try {
       		hibSession = com.anm.hibernate.HibernateConnection.getSession();
       		Query query = hibSession
       				.createQuery("from Ismacr acr where acr.ismarm.armrfnum=:armrfnum ");
       		query.setLong("armrfnum",armrfnum.longValue());
       		return query.list();
       	} catch (HibernateException e) {
       		throw new com.anm.hibernate.DAOException(e);
       	} finally {

       	}
       }
    /**
     * 
     * @param armrfnum
     * @param cnrfnum
     * @return
     * @throws DAOException
     */
    public List findByArmRfNumcndRfNumList(Long armrfnum,Long cnrfnum) throws DAOException {
       	Session hibSession = null;
       	List retval = null;
       	try {
       		hibSession = com.anm.hibernate.HibernateConnection.getSession();
       		Query query = hibSession
       				.createQuery("select ismacm.acmrfnum from Ismacr acr where acr.ismacm.ismapm.ismcnd=:cndrfnum and acr.ismarm.armrfnum=:armrfnum ");
       		query.setLong("armrfnum",armrfnum.longValue());
       		query.setLong("cndrfnum",cnrfnum.longValue());
       		return query.list();
       	} catch (HibernateException e) {
       		throw new com.anm.hibernate.DAOException(e);
       	} finally {

       	}
       }
    
    /**
     * 
     * @param armrfnum
     * @param cnrfnum
     * @return acmrfnum list
     * @throws DAOException
     * Dleted falg='N'
     */
    public List findByArmDeletedList(Long armrfnum,Long cnrfnum) throws DAOException {
       	Session hibSession = null;
       	List retval = null;
       	try {
       		hibSession = com.anm.hibernate.HibernateConnection.getSession();
       		Query query = hibSession
       				.createQuery("select ismacm.acmrfnum from Ismacr acr where acr.ismacm.ismapm.ismcnd=:cndrfnum and acr.ismarm.armrfnum=:armrfnum and acr.deleted='N'");
       		query.setLong("armrfnum",armrfnum.longValue());
       		query.setLong("cndrfnum",cnrfnum.longValue());
       		return query.list();
       	} catch (HibernateException e) {
       		throw new com.anm.hibernate.DAOException(e);
       	} finally {

       	}
       }
    
    public List findRoleRfNum(Long acmRfnum){
    	Session hibSession = null;
       	List retval = null;
       	try {
       		hibSession = com.anm.hibernate.HibernateConnection.getSession();
       		Query query = hibSession.createQuery("select distinct ismarm.armrfnum from Ismacr where ismacm.ismapm.ismcnd.cndrfnum=:acmRfnum");
       		query.setLong("acmRfnum",acmRfnum);
       		retval=query.list();
       		
       	}catch(HibernateException e){
       		e.printStackTrace();
       	}
    	return retval;
    }
    
  // User Code - ENDS

}
