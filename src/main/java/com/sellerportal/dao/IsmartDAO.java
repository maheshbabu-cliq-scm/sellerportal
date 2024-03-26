/* 
 * Auto Generated on Mon Jun 28 17:09:52 IST 2010
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
import com.sellerportal.model.Ismart;

// Octashop specific imports END
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Expression;
import org.hibernate.Criteria;
import org.hibernate.Session;

   
/**
 * 
 *
 * Generated DAO Class for ismart Table.
 *
 * All Queries related to this table should be here.
 * NOTE: 
 *	Do not put user defined queries in the generated DAO class. 
 *	USE hibernate-dao-ismart-class-code.txt
 * */
public class IsmartDAO extends SuperDAO
{

     /**
     * Find object by primary key.
     * @param pk the pk of the object to find.
     */
    public  Ismart findByPK( Serializable pk ) throws com.anm.hibernate.DAOException
    {
        Ismart retval = null;
        retval = (Ismart)super.findByPk( pk );
        return retval;
    }

   
    /**
	 * @param obj
	 * @return
	 */
	protected Criteria createCriteria(Object object) {
		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
		Criteria criteria = hibSession.createCriteria(Ismart.class);
		
		Ismart obj = (Ismart)object;
					
									
									
			//Pk getArtrfnum
			if (obj.getArtrfnum() != null) {
				criteria.add(Expression.eq("artrfnum", obj.getArtrfnum()));
			}
									
			//Set the many2one and one2one relation objects
			
																					
			if (obj.getIsmgat() != null) {
				criteria.add(Expression.eq("ismgat", obj.getIsmgat()));
				criteria.setFetchMode("ismgat", FetchMode.DEFAULT);
			}
																																				
			if (obj.getIsmgot() != null) {
				criteria.add(Expression.eq("ismgot", obj.getIsmgot()));
				criteria.setFetchMode("ismgot", FetchMode.DEFAULT);
			}
																					return criteria;
	}
	
	
	 
	
	
	 /** (non-Javadoc)
     * @see com.anm.hibernate.SuperDAO#getPojoObj()
     */
     
     
   
   	protected Object getPojoObj() {  
   		      
        return new Ismart();
        
    }
   	/**
	 * Function To find all data in one fatch
	 * @param gotrfnum
	 * @return
	 * @throws DAOException
	 */
	
	public Ismart findByOrgIdAndGatrfnum(Long gotrfnum, Long gatrfnum) throws DAOException{
		Ismart retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From Ismart art where art.ismgot.gotrfnum =:gotrfnum and art.ismgot.gatrfnum =:gatrfnum";
			Query query = hibSession.createQuery(queryString);
			query.setParameter("gotrfnum",gotrfnum);
			query.setParameter("gatrfnum",gatrfnum);
			retvalList = query.list();
			if (!retvalList.isEmpty())
				retval = (Ismart) retvalList.get(0);			
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retval;
	}
}
