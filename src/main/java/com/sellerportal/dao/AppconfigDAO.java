/* 
 * Auto Generated on Wed Feb 27 10:18:24 IST 2013
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
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import com.anm.hibernate.HibernateConnection;
import com.anm.hibernate.SuperDAO;
import com.sellerportal.model.Appconfig;

   
/**
 * 
 * Generated DAO Class for appconfig Table.
 *
 * All Queries related to this table should be here.
 * NOTE: 
 *	Do not put user defined queries in the generated DAO class. 
 *	USE hibernate-dao-appconfig-class-code.txt
 * */
public class AppconfigDAO extends SuperDAO
{

     /**
     * Find object by primary key.
     * @param pk the pk of the object to find.
     */
    public  Appconfig findByPK( Serializable pk ) throws com.anm.hibernate.DAOException
    {
        Appconfig retval = null;
        retval = (Appconfig)super.findByPk( pk );
        return retval;
    }

   
    /**
	 * @param obj
	 * @return
	 */
	protected Criteria createCriteria(Object object) {
		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
		Criteria criteria = hibSession.createCriteria(Appconfig.class);
		
		Appconfig obj = (Appconfig)object;
					
									
									
			//Pk getApprfnum
			if (obj.getApprfnum() != null) {
				criteria.add(Expression.eq("apprfnum", obj.getApprfnum()));
			}
									
			//Set the many2one and one2one relation objects
			
						return criteria;
	}
	
	
	 
	
	
	 /** (non-Javadoc)
     * @see com.anm.hibernate.SuperDAO#getPojoObj()
     */
     
     
   
   	protected Object getPojoObj() {  
   		      
        return new Appconfig();
        
    }
   	
   	
   	
   	public Appconfig findAppConfig(String paramName,String orgId)throws com.anm.hibernate.DAOException
    {
    	 Session hibSession = null;
    	 Appconfig retval = null;
         try
         {
             hibSession = HibernateConnection.getSession();
             Query query = hibSession.createQuery("from Appconfig config where config.appname=:paramName and config.orgid=:orgId");
             query.setParameter("paramName",paramName);
             query.setLong("orgId", new Long(orgId));
             List configList = query.list();
             if (configList!=null && configList.size() > 0)
             	retval = (Appconfig)configList.get(0);             
         }
 		catch( HibernateException e )
 		{
           e.printStackTrace();
            
         }
         finally
         {
         	
         }
         return retval;
    }
   	
   
}
