/* 
 * Auto Generated on Wed Mar 04 12:18:13 IST 2015
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
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import com.anm.hibernate.DAOException;
import com.anm.hibernate.SuperDAO;
import com.sellerportal.model.OctSlvInfo;

   
/**
 * 
 *
 * Generated DAO Class for oct_slv_info Table.
 *
 * All Queries related to this table should be here.
 * NOTE: 
 *	Do not put user defined queries in the generated DAO class. 
 *	USE hibernate-dao-oct_slv_info-class-code.txt
 * */
public class OctSlvInfoDAO extends SuperDAO
{

     /**
     * Find object by primary key.
     * @param pk the pk of the object to find.
     */
    public  OctSlvInfo findByPK( Serializable pk ) throws com.anm.hibernate.DAOException
    {
        OctSlvInfo retval = null;
        retval = (OctSlvInfo)super.findByPk( pk );
        return retval;
    }

   
    /**
	 * @param obj
	 * @return
	 */
	protected Criteria createCriteria(Object object) {
		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
		Criteria criteria = hibSession.createCriteria(OctSlvInfo.class);
		
		OctSlvInfo obj = (OctSlvInfo)object;
					
									
									
			//Pk getSlvinforfnum
			if (obj.getSlvinforfnum() != null) {
				criteria.add(Expression.eq("slvinforfnum", obj.getSlvinforfnum()));
			}
									
			//Set the many2one and one2one relation objects
			
																					
			if (obj.getOctSlv() != null) {
				criteria.add(Expression.eq("octSlv", obj.getOctSlv()));
				criteria.setFetchMode("octSlv", FetchMode.DEFAULT);
			}
			return criteria;
	}
	
	
	 public OctSlvInfo findSlvInfoRfNumByOctSlvRfNum(String slvRfNum) {
			Session hibSession = null;
	    	List retval = null;
	    	OctSlvInfo octSlvInfo = null;
	    	try
			{
	    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
	    		Query query = hibSession.createQuery("from OctSlvInfo slvinfo where slvinfo.octSlv.octslvrfnum =:slvRfNum ");    	   
	    		query.setLong("slvRfNum" , new Long(slvRfNum).longValue());
	    		query.setMaxResults(1);
	    		retval = query.list();            
	    		if(retval!=null && retval.size()>0){
	    			octSlvInfo = (OctSlvInfo) retval.get(0);
	 			}             
			}catch( HibernateException e)
			{
				throw new  DAOException( e );
			}
			return octSlvInfo;
		}
     
   
   	protected Object getPojoObj() {  
   		      
        return new OctSlvInfo();
        
    }


	public OctSlvInfo findBySlvRfNum(long slvRfNum) {

		OctSlvInfo retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "from OctSlvInfo slvinfo where slvinfo.octSlv.octslvrfnum =:slvRfNum";
			Query query = hibSession.createQuery(queryString);
			query.setLong("slvRfNum", slvRfNum);
			query.setMaxResults(1);
			retvalList = query.list();
			if (retvalList!=null && retvalList.size() > 0 )
				retval = (OctSlvInfo) retvalList.get(0);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}finally{		
		}
		return retval;
		
	
	}
    
    
   
}
