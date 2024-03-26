package com.sellerportal.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import com.anm.hibernate.DAOException;
import com.anm.hibernate.SuperDAO;
import com.sellerportal.model.Ismipt;

   
/**
 * 
 *
 * Generated DAO Class for ismipt Table.
 *
 * All Queries related to this table should be here.
 * NOTE: 
 *	Do not put user defined queries in the generated DAO class. 
 *	USE hibernate-dao-ismipt-class-code.txt
 * */
public class IsmiptDAO extends SuperDAO
{

     /**
     * Find object by primary key.
     * @param pk the pk of the object to find.
     */
    public  Ismipt findByPK( Serializable pk ) throws com.anm.hibernate.DAOException
    {
        Ismipt retval = null;
        retval = (Ismipt)super.findByPk( pk );
        return retval;
    }

   
    /**
	 * @param obj
	 * @return
	 */
	protected Criteria createCriteria(Object object) {
		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
		Criteria criteria = hibSession.createCriteria(Ismipt.class);
		
		Ismipt obj = (Ismipt)object;
					
									
									
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
   		      
        return new Ismipt();
        
    }
    
    
/**
    * Find Object of ismipt where value is max
    * @author Binod
    *
    */
    public Ismipt findObjectForName(String paramName)throws com.anm.hibernate.DAOException
    {
    	 Session hibSession = null;
    	 Ismipt retval = null;
         try
         {
             hibSession = com.anm.hibernate.HibernateConnection.getSession();
             org.hibernate.Query ismiptQuery = hibSession.createQuery("from Ismipt ip where ip.iptname=:paramName");
             ismiptQuery.setParameter("paramName",paramName);
             java.util.List iptList = ismiptQuery.list();
             if (iptList.size() > 0)
             	retval = (Ismipt)iptList.get(0);             
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
	 * @return
	 * @throws DAOException
	 */
	public List findValuesByName() throws DAOException {
		
    	Session hibSession=null;
    	try{
    		hibSession=com.anm.hibernate.HibernateConnection.getSession();
    		Query query = hibSession.createQuery("select iptvalue,iptname from Ismipt ipt where " +
    				"ipt.iptname in('pbilogo','pbilimage1','pbiimage1','pbiimage2','pbiimage3','pitimage','pitthumbnailimage')") ;
    		return query.list();		
    	}catch(HibernateException e){
		throw new com.anm.hibernate.DAOException( e );
    	}
    	finally
		{
    	
		}	
  } 
  
  /**
	 * 
	 * @return
	 * 		-minimum number defined for search did you mean functionality
	 * @throws DAOException
	 */
	public int  getMinimumHits() throws DAOException{
		int  min =0;
		Session hibSession=null;
    	try{
    		hibSession=com.anm.hibernate.HibernateConnection.getSession();
    		Query query = hibSession.createQuery("select iptvalue from Ismipt ipt where  ipt.iptname='minimumHits'") ;
    		List list= query.list();
    		if(!list.isEmpty()){
    			min = Integer.parseInt(list.get(0).toString().trim());
    		}
    	}catch(HibernateException e){
    		throw new com.anm.hibernate.DAOException( e );
    	}
		return min;
	}
	/**
	 * 
	 * @return
	 * 		-maximum number defined for search did you mean functionality
	 * @throws DAOException
	 */
	public int  getMaximumHits() throws DAOException{
		int  max =0;
		Session hibSession=null;
    	try{
    		hibSession=com.anm.hibernate.HibernateConnection.getSession();
    		Query query = hibSession.createQuery("select iptvalue from Ismipt ipt where  ipt.iptname='maxHits'") ;
    		List list= query.list();
    		if(!list.isEmpty()){
    			max = Integer.parseInt(list.get(0).toString().trim());
    		}
    	}catch(HibernateException e){
    		throw new com.anm.hibernate.DAOException( e );
    	}
		return max;
	}
	
	/**
	 * 
	 * @return pilCheck value.
	 * @throws DAOException
	 */

	public List getPilCheck(String iptName) throws DAOException {
		Session hibSession = null;
		List retval = null;
		try {

			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select ipt.iptvalue from Ismipt ipt where ipt.iptname=:iptName");
			query.setParameter("iptName",iptName);
			retval = query.list();

		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		} finally {
			hibSession = null;
		}
		return retval;
	}  
	public List getVpmpilQTY(String vpmpilqty) throws DAOException {
		Session hibSession = null;
		List retval = null;
		try {

			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select ipt.iptvalue from Ismipt ipt where ipt.iptname=:vpmpilqty");
			query.setParameter("vpmpilqty",vpmpilqty);
			retval = query.list();

		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		} finally {
			hibSession = null;
		}
		return retval;
	}	
	
	public List findMaxReviewsRows(String maxReviews) throws DAOException {
		Session hibSession = null;
		List retval = null;
		try {

			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select ipt.iptvalue from Ismipt ipt where ipt.iptname=:maxReviews");
			query.setParameter("maxReviews",maxReviews);
			retval = query.list();

		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		} finally {
			hibSession = null;
		}
		return retval;
	}
	/**
	 * FOR OMS PURPOSE
	 * @param param1
	 * @param param2
	 * @param param3
	 * @return
	 * @throws com.anm.hibernate.DAOException
	 */
	public List findObjectForNames(String param1,String param2,String param3)throws com.anm.hibernate.DAOException
    {
    	 Session hibSession = null;
    	 List iptList = null;
         try
         {
             hibSession = com.anm.hibernate.HibernateConnection.getSession();
             org.hibernate.Query ismiptQuery = hibSession.createQuery("from Ismipt ip where ip.iptname In('"+param1+"','"+param2+"','"+param3+"')");
             iptList = ismiptQuery.list();
                         
         }
 		catch( HibernateException e )
 		{
             throw new com.anm.hibernate.DAOException( e );
         }
         return iptList;
    }
	
	public String getIptValueByName(String iptName) throws DAOException {
		Session hibSession = null;
		List retval = null;
		String ismiptValue = "";
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select ipt.iptvalue from Ismipt ipt where ipt.iptname=:iptName");
			query.setParameter("iptName",iptName);
			retval = query.list();
			if(retval != null && retval.size() > 0){
				ismiptValue = retval.get(0).toString();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new com.anm.hibernate.DAOException(e);
		}
		return ismiptValue;
	}

}
