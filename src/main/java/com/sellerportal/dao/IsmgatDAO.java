/* 
 * Auto Generated on Thu Jul 15 10:12:00 IST 2010
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
import com.sellerportal.model.Ismgat;

// Octashop specific imports END
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Expression;
import org.hibernate.Criteria;
import org.hibernate.Session;

   
/**
 * 
 *
 * Generated DAO Class for ismgat Table.
 *
 * All Queries related to this table should be here.
 * NOTE: 
 *	Do not put user defined queries in the generated DAO class. 
 *	USE hibernate-dao-ismgat-class-code.txt
 * */
public class IsmgatDAO extends SuperDAO
{

     /**
     * Find object by primary key.
     * @param pk the pk of the object to find.
     */
    public  Ismgat findByPK( Serializable pk ) throws com.anm.hibernate.DAOException
    {
        Ismgat retval = null;
        retval = (Ismgat)super.findByPk( pk );
        return retval;
    }

   
    /**
	 * @param obj
	 * @return
	 */
	protected Criteria createCriteria(Object object) {
		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
		Criteria criteria = hibSession.createCriteria(Ismgat.class);
		
		Ismgat obj = (Ismgat)object;
					
									
									
			//Pk getGatrfnum
			if (obj.getGatrfnum() != null) {
				criteria.add(Expression.eq("gatrfnum", obj.getGatrfnum()));
			}
									
			//Set the many2one and one2one relation objects
			
																																	return criteria;
	}
	
	
	 
	
	
	 /** (non-Javadoc)
     * @see com.anm.hibernate.SuperDAO#getPojoObj()
     */
     
     
   
   	protected Object getPojoObj() {  
   		      
        return new Ismgat();
        
    }
   	/**
	 * Function To find all data in one fatch
	 * @param ubiLogin
	 * @return
	 * @throws DAOException
	 */
	public Ismgat findByUserId(String gatLogin) throws DAOException{
		Ismgat retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From Ismgat gat where gat.loginid =:gatLogin";
			Query query = hibSession.createQuery(queryString);
			query.setParameter("gatLogin",gatLogin);
			retvalList = query.list();
			if (retvalList.size() > 0 )
				retval = (Ismgat) retvalList.get(0);			
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retval;
	}

	/**
	 * Function To find all data in one fatch
	 * @param ubiLogin
	 * @return
	 * @throws DAOException
	 */
	public Ismgat checkAdminValidLogin(String gatLogin,String password) throws DAOException{
		Ismgat retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From Ismgat gat where gat.loginid =:gatLogin and gat.password=:password";
			Query query = hibSession.createQuery(queryString);
			query.setParameter("gatLogin",gatLogin);
			query.setString("password", password);
			retvalList = query.list();
			if (retvalList.size() > 0 )
				retval = (Ismgat) retvalList.get(0);			
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retval;
	}
    
    
    
   
}
