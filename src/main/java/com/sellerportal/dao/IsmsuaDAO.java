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

// Octashop specific imports START

import java.io.Serializable;
import java.util.List;

import com.anm.hibernate.DAOException;
import com.anm.hibernate.SuperDAO;
import com.sellerportal.model.Ismsua;

// Octashop specific imports END
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Expression;
import org.hibernate.Criteria;
import org.hibernate.Session;

   
/**
 * 
 *
 * Generated DAO Class for ismsua Table.
 *
 * All Queries related to this table should be here.
 * NOTE: 
 *	Do not put user defined queries in the generated DAO class. 
 *	USE hibernate-dao-ismsua-class-code.txt
 * */
public class IsmsuaDAO extends SuperDAO
{

     /**
     * Find object by primary key.
     * @param pk the pk of the object to find.
     */
    public  Ismsua findByPK( Serializable pk ) throws com.anm.hibernate.DAOException
    {
        Ismsua retval = null;
        retval = (Ismsua)super.findByPk( pk );
        return retval;
    }

   
    /**
	 * @param obj
	 * @return
	 */
	protected Criteria createCriteria(Object object) {
		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
		Criteria criteria = hibSession.createCriteria(Ismsua.class);
		
		Ismsua obj = (Ismsua)object;
					
									
									
			//Pk getComp_id().getSuassirfnum
			if (obj.getComp_id() != null && obj.getComp_id().getSuassirfnum() != null) {
				criteria.add(Expression.eq("comp_id.suassirfnum", obj.getComp_id().getSuassirfnum()));
			}
												
			//Pk getComp_id().getSuaubirfnum
			if (obj.getComp_id() != null && obj.getComp_id().getSuaubirfnum() != null) {
				criteria.add(Expression.eq("comp_id.suaubirfnum", obj.getComp_id().getSuaubirfnum()));
			}
									
			//Set the many2one and one2one relation objects
			
						return criteria;
	}
	
	
	 
	
	
	 /** (non-Javadoc)
     * @see com.anm.hibernate.SuperDAO#getPojoObj()
     */
     
     
   
   	protected Object getPojoObj() {  
   		      
        return new Ismsua();
        
    }
    
    
   // User Code - STARTS
public Ismsua chekUserExistanceAndData(String ubiLogin) throws DAOException{
		Ismsua retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select sua From Ismsua sua " +
					" left join fetch sua.ismubi "+
					" left join fetch sua.ismssi "+
					" where sua.ismubi.ubilogin =:ubiLogin";
			Query query = hibSession.createQuery(queryString);
			query.setParameter("ubiLogin", ubiLogin);
			retvalList = query.list();
			if (retvalList.size() > 0 )
				retval = (Ismsua) retvalList.get(0);			
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		finally
		{
		}
		return retval;
	}
		public Ismsua findByIsmssirfnum(String ssiRfnum){
		Ismsua retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select sua From Ismsua sua where sua.ismssi.ssirfnbr =:ssiRfnum";
			Query query = hibSession.createQuery(queryString);
			query.setParameter("ssiRfnum", new Long(ssiRfnum));
			
			retvalList = query.list();
			if (retvalList.size() > 0 )
				retval = (Ismsua) retvalList.get(0);			
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		finally
		{
		}
		return retval;
	}  // User Code - ENDS

}
