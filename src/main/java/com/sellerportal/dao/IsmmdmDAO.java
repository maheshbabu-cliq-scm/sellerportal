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
import java.util.List;

import com.anm.hibernate.DAOException;
import com.anm.hibernate.SuperDAO;
import com.sellerportal.model.Ismmdm;

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
 * Generated DAO Class for ismmdm Table.
 *
 * All Queries related to this table should be here.
 * NOTE: 
 *	Do not put user defined queries in the generated DAO class. 
 *	USE hibernate-dao-ismmdm-class-code.txt
 * */
public class IsmmdmDAO extends SuperDAO
{

     /**
     * Find object by primary key.
     * @param pk the pk of the object to find.
     */
    public  Ismmdm findByPK( Serializable pk ) throws com.anm.hibernate.DAOException
    {
        Ismmdm retval = null;
        retval = (Ismmdm)super.findByPk( pk );
        return retval;
    }

   
    /**
	 * @param obj
	 * @return
	 */
	protected Criteria createCriteria(Object object) {
		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
		Criteria criteria = hibSession.createCriteria(Ismmdm.class);
		
		Ismmdm obj = (Ismmdm)object;
					
									
									
			//Pk getMdmrfnum
			if (obj.getMdmrfnum() != null) {
				criteria.add(Expression.eq("mdmrfnum", obj.getMdmrfnum()));
			}
									
			//Set the many2one and one2one relation objects
			
																																																																																																																																																																																																																																																																																																																																																																																				
			if (obj.getIsmqdmByToqdmrfnum() != null) {
				criteria.add(Expression.eq("ismqdmByToqdmrfnum", obj.getIsmqdmByToqdmrfnum()));
				criteria.setFetchMode("ismqdmByToqdmrfnum", FetchMode.DEFAULT);
			}
																																				
			if (obj.getIsmqdmByCcqdmrfnum() != null) {
				criteria.add(Expression.eq("ismqdmByCcqdmrfnum", obj.getIsmqdmByCcqdmrfnum()));
				criteria.setFetchMode("ismqdmByCcqdmrfnum", FetchMode.DEFAULT);
			}
																																				
			if (obj.getIsmqdmByBccqdmrfnum() != null) {
				criteria.add(Expression.eq("ismqdmByBccqdmrfnum", obj.getIsmqdmByBccqdmrfnum()));
				criteria.setFetchMode("ismqdmByBccqdmrfnum", FetchMode.DEFAULT);
			}
																																				
			if (obj.getIsmtdm() != null) {
				criteria.add(Expression.eq("ismtdm", obj.getIsmtdm()));
				criteria.setFetchMode("ismtdm", FetchMode.DEFAULT);
			}
																					return criteria;
	}
	
	
	 
	
	
	 /** (non-Javadoc)
     * @see com.anm.hibernate.SuperDAO#getPojoObj()
     */
     
     
   
   	protected Object getPojoObj() {  
   		      
        return new Ismmdm();
        
    }
    
    
   // User Code - STARTS
			
	
public List findMdmByTdm(Long tdmrfnum) throws DAOException {
	Session hibSession = null;
	try {
		hibSession = com.anm.hibernate.HibernateConnection.getSession();
		Query query = hibSession.createQuery("select mdm.mdmrfnum from Ismmdm mdm where mdm.ismtdm.tdmrfnum ="+tdmrfnum);
		return query.list();
	}
	 catch (HibernateException e) {
		throw new com.anm.hibernate.DAOException(e);
	}
}  // User Code - ENDS



public Ismmdm findMdmByMdmname(String mdmname) throws DAOException {
    Session hibSession = null;
    List<Ismmdm> resultlst=null;
    Ismmdm mdm= null;
    try {
        hibSession = com.anm.hibernate.HibernateConnection.getSession();
        Query query = hibSession.createQuery("from Ismmdm mdm where mdm.ismtdm.templatetype='M' and mdm.name=:name ");
        query.setString("name", mdmname);
        resultlst = query.list();
        if(resultlst !=null && !resultlst.isEmpty()){
        	mdm =(Ismmdm)resultlst.get(0);
        }
    }catch (HibernateException e) {
        throw new com.anm.hibernate.DAOException(e);
    }
    return mdm;
}

public Ismmdm findMdmByName(String mdmname) throws DAOException {
    Session hibSession = null;
    List<Ismmdm> resultlst=null;
    Ismmdm mdm= null;
    try {
        hibSession = com.anm.hibernate.HibernateConnection.getSession();
        Query query = hibSession.createQuery("from Ismmdm mdm where mdm.name=:name ");
        query.setString("name", mdmname);
        resultlst = query.list();
        if(resultlst !=null && !resultlst.isEmpty()){
        	mdm =(Ismmdm)resultlst.get(0);
        }
    }catch (HibernateException e) {
        throw new com.anm.hibernate.DAOException(e);
    }
    return mdm;
}


}
