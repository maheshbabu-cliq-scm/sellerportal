/* 
 * Auto Generated on Mon May 17 10:23:26 IST 2010
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

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import com.anm.hibernate.DAOException;
import com.anm.hibernate.SuperDAO;
import com.sellerportal.model.Ismaur;

   
/**
 * 
 *
 * Generated DAO Class for ismaur Table.
 *
 * All Queries related to this table should be here.
 * NOTE: 
 *	Do not put user defined queries in the generated DAO class. 
 *	USE hibernate-dao-ismaur-class-code.txt
 * */
public class IsmaurDAO extends SuperDAO
{

     /**
     * Find object by primary key.
     * @param pk the pk of the object to find.
     */
    public  Ismaur findByPK( Serializable pk ) throws com.anm.hibernate.DAOException
    {
        Ismaur retval = null;
        retval = (Ismaur)super.findByPk( pk );
        return retval;
    }

   
    /**
	 * @param obj
	 * @return
	 */
	protected Criteria createCriteria(Object object) {
		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
		Criteria criteria = hibSession.createCriteria(Ismaur.class);
		
		Ismaur obj = (Ismaur)object;
					
									
									
			//Pk getComp_id().getAurarmrfnum
			if (obj.getComp_id() != null && obj.getComp_id().getAurarmrfnum() != null) {
				criteria.add(Expression.eq("comp_id.aurarmrfnum", obj.getComp_id().getAurarmrfnum()));
			}
												
			//Pk getComp_id().getAurubirfnum
			if (obj.getComp_id() != null && obj.getComp_id().getAurubirfnum() != null) {
				criteria.add(Expression.eq("comp_id.aurubirfnum", obj.getComp_id().getAurubirfnum()));
			}
									
			//Set the many2one and one2one relation objects
			
						return criteria;
	}
	
	
	 
	
	
	 /** (non-Javadoc)
     * @see com.anm.hibernate.SuperDAO#getPojoObj()
     */
     
     
   
   	protected Object getPojoObj() {  
   		      
        return new Ismaur();
        
    }
    
    
   // User Code - STARTS
/**
     * @param ubirfnum
     * @param armrfnum
     * @return
     * @throws DAOException
     */
    public List<Ismaur> findBothRfNum(Long ubirfnum,Long armrfnum) throws DAOException {

       	Session hibSession = null;
       	List<Ismaur> retval = null;
       	try {
       		hibSession = com.anm.hibernate.HibernateConnection.getSession();
       	
       		Query query = hibSession.createQuery("from Ismaur aur where aur.ismubi.ubirfnum=:ubirfnum and aur.ismarm.armrfnum=:armrfnum");
       		query.setLong("ubirfnum",ubirfnum.longValue());
       		query.setLong("armrfnum",armrfnum.longValue()); 		   		
       		retval=query.list();
       		return retval;
       	}catch (HibernateException e){
       		throw new com.anm.hibernate.DAOException(e);
       	} 
       }
    	
    public void deleteAurByIsmubiRfNum(Long ubirfnum) {
		Session hibSession = null;
        try {
            hibSession = com.anm.hibernate.HibernateConnection.getSession();
            org.hibernate.Transaction tx = hibSession.beginTransaction();
            Query query = hibSession.createQuery("delete Ismaur aur where aur.ismubi.ubirfnum="+ubirfnum);
            query.executeUpdate();
            tx.commit(); 
        } catch (HibernateException e) {
            throw new com.anm.hibernate.DAOException(e);
        } 
	}
    
    public List findAurByUbi(Long ubirfnum) {
		Session hibSession = null;
		List retVal=null;
        try {
            hibSession = com.anm.hibernate.HibernateConnection.getSession();
            Query query = hibSession.createQuery("select aur.ismarm from Ismaur aur where aur.ismubi.ubirfnum =:ubirfnum order by aur.modidate desc");
            query.setParameter("ubirfnum", ubirfnum);
            retVal= query.list();
        } catch (Exception e) {
            throw new com.anm.hibernate.DAOException(e);
        } 
        return retVal;
	}
    
    public static List<Ismaur> findRoleNum(Long rfNum){
    	List retVal=null;
		Session hibSession = null;
        try {
            hibSession = com.anm.hibernate.HibernateConnection.getSession();
            Query query = hibSession.createQuery("select aur.ismarm.armrfnum from Ismaur aur where aur.ismubi.ubirfnum="+rfNum+" and aur.active='Y'" );
            retVal= query.list();
            return retVal;
        } catch (Exception e) {
            throw new com.anm.hibernate.DAOException(e);
        } 
    }

    public static List findRole(Long rfNum)
    {
    	List retVal=null;
    	Long roleVal=null;
		Session hibSession = null;
        try {
            hibSession = com.anm.hibernate.HibernateConnection.getSession();
            Query query = hibSession.createQuery("from Ismaur aur where aur.ismubi.ubirfnum= "+rfNum );
            retVal= query.list();
        } catch (Exception e) {
            throw new com.anm.hibernate.DAOException(e);
        } 
       return retVal;
    }
  
    public static List findbyaur(Long aurRfnum){
    	List retVal=null;
    	Session hibSession = null;
        try {
            hibSession = com.anm.hibernate.HibernateConnection.getSession();
            Query query = hibSession.createQuery("from Ismaur aur where aur.ismubi.ubirfnum= "+aurRfnum );
            retVal= query.list();
        } catch (Exception e) {
            throw new com.anm.hibernate.DAOException(e);
        } 
    	return retVal;
    }
    
    public List findbyUbirfnum(Long ubirfnum){
    	List retVal=null;
    	Session hibSession = null;
        try {
            hibSession = com.anm.hibernate.HibernateConnection.getSession();
            Query query = hibSession.createQuery("from Ismaur aur where aur.ismubi.ubirfnum=:ubirfnum");
            query.setLong("ubirfnum",ubirfnum);
            retVal= query.list();
        } catch (Exception e) {
            throw new com.anm.hibernate.DAOException(e);
        } 
    	return retVal;
    }
    
    public void deleteAurByUbiNArm(Long ubirfnum,Long armrfnum) {
		Session hibSession = null;
        try {
            hibSession = com.anm.hibernate.HibernateConnection.getSession();
            org.hibernate.Transaction tx = hibSession.beginTransaction();
            Query query = hibSession.createQuery("delete Ismaur aur where aur.ismubi.ubirfnum=:ubirfnum and aur.ismarm.armrfnum=:armrfnum");
            query.setLong("ubirfnum",ubirfnum.longValue());
       		query.setLong("armrfnum",armrfnum.longValue()); 	
            query.executeUpdate();
            tx.commit(); 
        } catch (HibernateException e) {
            throw new com.anm.hibernate.DAOException(e);
        } 
	}

    public Ismaur findAurByBothRfNum(Long ubirfnum,Long armrfnum) throws DAOException {
       	Session hibSession = null;
       	List retval = null;
       	Ismaur aur = null;
       	try {
       		hibSession = com.anm.hibernate.HibernateConnection.getSession();
       		Query query = hibSession.createQuery("from Ismaur aur where aur.ismubi.ubirfnum=:ubirfnum and aur.ismarm.armrfnum=:armrfnum");
       		query.setLong("ubirfnum",ubirfnum.longValue());
       		query.setLong("armrfnum",armrfnum.longValue()); 		   		
       		retval=query.list();
       		if(retval != null && retval.size() > 0){
       			aur = (Ismaur)retval.get(0);
       		}
       	} catch (HibernateException e) {
       		throw new com.anm.hibernate.DAOException(e);
       	}
       	return aur;
     }
   
    
    public boolean findRestrictedUbiByLogin(String ubilogin) {
  		Session hibSession = null;
  		List retVal=null;
  		int count=0;
  		boolean allowFlag=true;
          try {
              hibSession = com.anm.hibernate.HibernateConnection.getSession();
              Query query = hibSession.createQuery("select count(*) from Ismaur where ismubi.ubilogin=:ubilogin and ismarm.armrolecode in ('FIN_DSA','LEG_DSA') ");
              query.setString("ubilogin", ubilogin);
              retVal= query.list();
              if(retVal!=null && !retVal.isEmpty()){
            	  count = (int) retVal.get(0);
            	  if(count>0){
            		  allowFlag = false;
            	  }
              }
          } catch (Exception e) {
              throw new com.anm.hibernate.DAOException(e);
          } 
          return allowFlag;
  	}
    
    
    public static List<String> findRoleCodeByUbiRfNum(Long rfNum){
    	List retVal=null;
		Session hibSession = null;
        try {
            hibSession = com.anm.hibernate.HibernateConnection.getSession();
            Query query = hibSession.createQuery("select aur.ismarm.armrolecode from Ismaur aur where aur.ismubi.ubirfnum="+rfNum+" and aur.active='Y'" );
            retVal= query.list();
            return retVal;
        } catch (Exception e) {
            throw new com.anm.hibernate.DAOException(e);
        } 
    }
    
    
    
    
}