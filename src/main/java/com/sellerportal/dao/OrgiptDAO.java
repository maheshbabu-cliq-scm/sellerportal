/* 
 * Auto Generated on Mon May 17 10:23:21 IST 2010
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
import java.util.List;

import com.anm.hibernate.DAOException;
import com.anm.hibernate.SuperDAO;
import com.sellerportal.model.Orgipt;

// Octashop specific imports END
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Expression;
import org.hibernate.Criteria;
import org.hibernate.Session;

   
/**
 * 
 *
 * Generated DAO Class for orgipt Table.
 *
 * All Queries related to this table should be here.
 * NOTE: 
 *	Do not put user defined queries in the generated DAO class. 
 *	USE hibernate-dao-orgipt-class-code.txt
 * */
public class OrgiptDAO extends SuperDAO
{

     /**
     * Find object by primary key.
     * @param pk the pk of the object to find.
     */
    public  Orgipt findByPK( Serializable pk ) throws com.anm.hibernate.DAOException
    {
        Orgipt retval = null;
        retval = (Orgipt)super.findByPk( pk );
        return retval;
    }

   
    /**
	 * @param obj
	 * @return
	 */
	protected Criteria createCriteria(Object object) {
		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
		Criteria criteria = hibSession.createCriteria(Orgipt.class);
		
		Orgipt obj = (Orgipt)object;
					
									
									
			//Pk getIptname
			if (obj.getIptname() != null) {
				criteria.add(Expression.eq("iptname", obj.getIptname()));
			}
									
			//Set the many2one and one2one relation objects
			
						return criteria;
	}
	
	
	 
	
	
	 /** (non-Javadoc)
     * @see com.anm.hibernate.SuperDAO#getPojoObj()
     */
     
     
   
   	protected Object getPojoObj() {  
   		      
        return new Orgipt();
        
    }
    
    
   // User Code - STARTS

   	public String getOrgIptValueByName(String iptName) throws DAOException {
		Session hibSession = null;
		List retval = null;
		String ismiptValue = "";
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select ipt.iptvalue from Orgipt ipt where ipt.iptname='"+iptName+"'");
			retval = query.list();
			if(retval != null && retval.size() > 0){
				ismiptValue = retval.get(0).toString();
			}
		} catch (HibernateException e) {
			//throw new com.anm.hibernate.DAOException(e);
			System.out.println("The TimeZone is not Configured at Databse");
			
		}
		return ismiptValue;
	}
   	
   	public String getIptValueByName(String iptName) throws DAOException {
		Session hibSession = null;
		List retval = null;
		String ismiptValue = "";
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select ipt.iptvalue from Orgipt ipt where ipt.iptname like '%"+iptName+"%'");
			retval = query.list();
			if(retval != null && retval.size() > 0){
				ismiptValue = retval.get(0).toString();
			}
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		return ismiptValue;
	}
   	
   	
   	/**
     * Find Object of ismipt where value is max
     * @author Sandesh
     *
     */
     public Orgipt findObjectForName(String paramName)throws com.anm.hibernate.DAOException
     {
     	 Session hibSession = null;
     	 Orgipt retval = null;
          try
          {
              hibSession = com.anm.hibernate.HibernateConnection.getSession();
              org.hibernate.Query orgiptQuery = hibSession.createQuery("from Orgipt ip where ip.iptname=:paramName");
              orgiptQuery.setParameter("paramName",paramName);
              java.util.List iptList = orgiptQuery.list();
              if (iptList.size() > 0)
              	retval = (Orgipt)iptList.get(0);             
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
   	
	// User Code - ENDS

     /**
 	 * 
 	 * @return
 	 * 		pilCheck value.
 	 * @throws DAOException
 	 */

 	public List getPilCheck(String iptName) throws DAOException {
 		Session hibSession = null;
 		List retval = null;
 		try {

 			hibSession = com.anm.hibernate.HibernateConnection.getSession();
 			Query query = hibSession.createQuery("select ipt.iptvalue from Orgipt ipt where ipt.iptname=" +"'"+ iptName+"'");
 			retval = query.list();

 		} catch (HibernateException e) {
 			throw new com.anm.hibernate.DAOException(e);
 		} finally {
 			hibSession = null;
 		}
 		return retval;
 	}  
     
	
	public List findIptNameByValue(String iptValue) throws DAOException {
		Session hibSession = null;
		List retval = null;
		try {

			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			//Query query = hibSession.createQuery("select ipt.iptvalue from Ismipt ipt where ipt.iptname=" +"'"+ maxReviews+"'");
			Query query = hibSession.createQuery("select ipt.iptname from Orgipt ipt where ipt.iptvalue=:iptValue");
			query.setParameter("iptValue",iptValue);
			retval = query.list();

		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		} finally {
			hibSession = null;
		}
		return retval;
	}
 	
}
