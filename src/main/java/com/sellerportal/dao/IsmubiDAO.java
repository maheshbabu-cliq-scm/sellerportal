package com.sellerportal.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.jdbc.Work;

import com.anm.hibernate.DAOException;
import com.anm.hibernate.SuperDAO;
import com.sellerportal.model.Ismubi;


   
/**
 * 
 *
 * Generated DAO Class for ismubi Table.
 *
 * All Queries related to this table should be here.
 * NOTE: 
 *	Do not put user defined queries in the generated DAO class. 
 *	USE hibernate-dao-ismubi-class-code.txt
 * */
public class IsmubiDAO extends SuperDAO
{

     /**
     * Find object by primary key.
     * @param pk the pk of the object to find.
     */
    public  Ismubi findByPK( Serializable pk ) throws com.anm.hibernate.DAOException
    {
        Ismubi retval = null;
        retval = (Ismubi)super.findByPk( pk );
        return retval;
    }

   
    /**
	 * @param obj
	 * @return
	 */
	protected Criteria createCriteria(Object object) {
		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
		Criteria criteria = hibSession.createCriteria(Ismubi.class);
		
		Ismubi obj = (Ismubi)object;
					
									
									
			//Pk getUbirfnum
			if (obj.getUbirfnum() != null) {
				criteria.add(Expression.eq("ubirfnum", obj.getUbirfnum()));
			}
									
			//Set the many2one and one2one relation objects
			
																					
			if (obj.getIsmcnd() != null) {
				criteria.add(Expression.eq("ismcnd", obj.getIsmcnd()));
				criteria.setFetchMode("ismcnd", FetchMode.DEFAULT);
			}
																																																																																																																																																																																																																																																																																																											
																														
			if (obj.getIsmcct() != null) {
				criteria.add(Expression.eq("ismcct", obj.getIsmcct()));
				criteria.setFetchMode("ismcct", FetchMode.DEFAULT);
			}
																																				
			/*if (obj.getIsmafm() != null) {
				criteria.add(Expression.eq("ismafm", obj.getIsmafm()));
				criteria.setFetchMode("ismafm", FetchMode.DEFAULT);
			}
			if (obj.getIsmccd() != null) {
				criteria.add(Expression.eq("ismccd", obj.getIsmccd()));
				criteria.setFetchMode("ismccd", FetchMode.DEFAULT);
			}*/
			
			return criteria;
	}
	
	
	 
	
	
	 /** (non-Javadoc)
     * @see com.anm.hibernate.SuperDAO#getPojoObj()
     */
     
     
   
   	protected Object getPojoObj() {  
   		      
        return new Ismubi();
        
    }
    
    
   // User Code - STARTS
/**
	 * @param userRefNo
	 * @throws DAOException
	 */
	public String findUbiLoginByRfnum(Long ubiRfnum)throws DAOException{
		List retval = null;
		String ubiLogin=null;
		try {
			Session hibSession = null;
			
				hibSession = com.anm.hibernate.HibernateConnection.getSession();
				Query query = hibSession.createQuery("Select ubi.ubilogin from Ismubi ubi where ubi.ubirfnum=:ubiRfnum");
				query.setLong("ubiRfnum" ,ubiRfnum.longValue());
			    retval = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		if(retval!=null && retval.size()>0){
			ubiLogin = (String)retval.get(0);
		}
		return ubiLogin;
	}
	 
	 
         
   
	public List findByUserName(String userRefNo) throws DAOException {
		Session hibSession = null;
    	List retval = null;
    	try
		{
    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		Query query = hibSession.createQuery("from Ismubi where ubirfnum=:usrRfNum");
    	    query.setLong("usrRfNum" , new Long(userRefNo).longValue());
            retval = query.list();
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		finally
		{
			
		}
		return retval;
	}
   
	public int getUbiRecordsCount() {
		int count = 0;
		Session hibSession = null;
		List retval = new ArrayList(0);
		hibSession = com.anm.hibernate.HibernateConnection.getSession();
		Query query = hibSession.createQuery("select count(*)FROM Ismubi ubi");
		
	    retval = query.list();
	    if(!retval.isEmpty())
	    {
	    	Object obj = retval.get(0);
	    	 count = Integer.parseInt(obj.toString());
	    }
	    return count;
	}

/**
	 * @param userRefNo
	 * @throws DAOException
	 */
	public List findByUserNameAndRfnum(String ubilogin) throws DAOException {
		Session hibSession = null;
    	List retval = null;
    	try
		{
    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		Query query = hibSession.createQuery("select ubi.ubirfnum,ubi.ubilogin from Ismubi ubi where ubi.ubilogin=:ubilogin");
    	    query.setString("ubilogin" ,ubilogin);
            retval = query.list();
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		finally
		{
			
		}
		return retval;
	}
	
	/**
	 * Function To find all data in one fatch
	 * @param ubiLogin
	 * @return
	 * @throws DAOException
	 */
	public Ismubi findByUserRefNum(String ubiLogin) throws DAOException{
		Ismubi retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "FROM Ismubi ubi "
                + " left join fetch ubi.ismbsi"
				+ " left join fetch ubi.ismcct"
                + " where ubi.ubirfnum =:ubirfnum";
			Query query = hibSession.createQuery(queryString);
			query.setLong("ubirfnum", Long.parseLong(ubiLogin));
			retvalList = query.list();
			if(retvalList!= null && !retvalList.isEmpty())
				retval = (Ismubi) retvalList.get(0);			
			
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		finally
		{
			
		}
		return retval;
	}
	/**
	 * Function To find all bco objects in with ubirefnum
	 * @param ubiLogin
	 * @return
	 * @throws DAOException
	 */
	public List findBcoByUserRefNum(String ubiLogin) throws DAOException{
		
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select ubi.ismbcos FROM Ismubi ubi "
                + " where ubi.ubirfnum =:ubirfnum";
			Query query = hibSession.createQuery(queryString);
			query.setLong("ubirfnum", Long.parseLong(ubiLogin));
			retvalList = query.list();
			
				return retvalList;			
			
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		
		
	}
	
	/**
	 * Function To find all data in one fatch
	 * @param ubiLogin
	 * @return
	 * @throws DAOException
	 */
	public Ismubi findByUserId(String ubiLogin) throws DAOException{
		Ismubi retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From Ismubi ubi where lower(ubi.ubilogin) =:ubiLogin";
			Query query = hibSession.createQuery(queryString);
			query.setParameter("ubiLogin", ubiLogin.trim().toLowerCase());
			retvalList = query.list();
			if (retvalList.size() > 0 )
				retval = (Ismubi) retvalList.get(0);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		finally
		{
			
		}
		return retval;
	}
	
	
	/**
	 * @param ubifname
	 * @return
	 * @throws DAOException
	 */
	public Ismubi findByUserFirstName(String ubifname) throws DAOException{
		Ismubi retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From Ismubi ubi where ubi.ubifname =:ubifname";
			Query query = hibSession.createQuery(queryString);
			query.setParameter("ubifname", ubifname);
			retvalList = query.list();
			if (retvalList.size() > 0 )
				retval = (Ismubi) retvalList.get(0);			
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		finally
		{
			
		}
		return retval;
	}
	
	public List findRfByUserName(String ubilogin) throws DAOException {
        Session hibSession = null;
        List retval = null;
        try
        {
            hibSession = com.anm.hibernate.HibernateConnection.getSession();
            Query query = hibSession.createQuery("select ubi.ubirfnum from Ismubi ubi where ubi.ubilogin=:ubilogin");
            query.setString("ubilogin" ,ubilogin);
            retval = query.list();
        }catch( HibernateException e)
        {
            throw new  DAOException( e );
        }
        finally
        {
            
        }
        return retval;
    }
    
    
    	public boolean isUserExists(String ubiLogin) throws DAOException{
		boolean retval = false;
		Session hibSession = null;
		List retvalList = null;
		
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			
			String queryString = "From Ismubi ubi where ubi.ubilogin =:ubiLogin and ubi.ubipmrfnum is null";
			Query query = hibSession.createQuery(queryString);
			query.setParameter("ubiLogin", ubiLogin);
			retvalList = query.list();
			if (retvalList.size() > 0 )
				retval = true;			
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		finally
		{
			
		}
		return retval;
	}
    	
    	public boolean isUserSecondEmail(String loginId) {
    		boolean retval = false;
    		Session hibSession = null;
    		List retvalList = null;
    		
    		try {
    			hibSession = com.anm.hibernate.HibernateConnection.getSession();
    			
    			String queryString = "select ubi.ismuat.uatemail2,ubi.ismuat.uatmobile from Ismubi ubi where ubi.ubilogin =:ubiLogin ";
    			Query query = hibSession.createQuery(queryString);
				query.setParameter("ubiLogin",loginId);
    			retvalList = query.list();
    			System.out.println("Iam in ismdui");
    			if (retvalList.size() > 0 )
    				retval = true;			
    		} catch (HibernateException e) {
    			throw new DAOException(e);
    		}
    		finally
    		{
    			
    		}
    		return retval;
    	}
	
	/**
    	 * To check whether user login is valid
    	 */
    	public boolean checkValidLogin(String userid, String password) {
    		
    		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		Query query = hibSession
    				.createQuery("select ubi.ubilogin from Ismubi ubi where ubi.ubilogin =:userid and ubi.ubipass=:password and (ubi.ubipmrfnum is null or ubi.ubipmrfnum=94)");
    		query.setString("userid", userid);
    		query.setString("password", password);

    		List list = query.list();
    		if (list.size() > 0)
    		{
    			return true;
    		}
    		else
    		{
    			return false;		
    		}
    	
    	} 
    	
    	/**
    	 * To check whether user id already exist
    	 */
    	public boolean checkUserIdExist(String ubiLogin) {
    		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		Query query = hibSession.createQuery("select ubi.ubilogin from Ismubi ubi where ubi.ubilogin =:ubiLogin");
    		query.setString("ubiLogin", ubiLogin);
    		List list = query.list();
    		if (list.size() > 0)
    		return true;

    		return false;
    	}	
    	
      
        public Ismubi findPasswordByUserName(String ubilogin,String passwordQue, String passwordAns) throws DAOException {
            Session hibSession = null;
            Ismubi retval = null;
            List retvalList = null;
            try
            {
                hibSession = com.anm.hibernate.HibernateConnection.getSession();
                Query query = hibSession.createQuery("From Ismubi ubi where ubi.ubilogin=:ubilogin and ubi.ubiques=:passwordQue and ubi.ubians=:passwordAns");
                query.setString("ubilogin" ,ubilogin);
                query.setString("passwordQue" ,passwordQue);
                query.setString("passwordAns" ,passwordAns);
                retvalList = query.list();
                if ( retvalList.size() > 0 )
    				retval = (Ismubi) retvalList.get(0);	
            }catch( HibernateException e)
            {
                throw new  DAOException( e );
            }
            finally
            {
                
            }
            return retval;
        }
        
        	public List findByUbiIsNewsLetterY() throws DAOException {
		Session hibSession = null;
    	List retval = null;
    	try
		{
    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		Query query = hibSession.createQuery("select distinct uat.uatemail1  from Ismuat uat, Ismubi ubi where uat.ismubi=ubi.ubirfnum and ubi.ubiisnewsletter='Y' and uat.uatemail1<>null");
            retval = query.list();
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		finally
		{
					    
		}
		return retval;
	}
	public List findAfmByUbi(String ubiRfNum) throws DAOException {
    	 Session hibSession = null;
    	 List retval = null;
    	 try
    	 {
    		 hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		 Query query = hibSession.createQuery("select ubi.ismafm.afmrfnum  from Ismubi ubi where ubi.ubirfnum=:ubiRfNum");
    		 query.setLong("ubiRfNum" , new Long(ubiRfNum).longValue());
    		 retval = query.list();
    	 }catch( HibernateException e)
    	 {
    		 throw new  DAOException( e );
    	 }
    	 return retval;
     }

	public List findUsers(){
		Session hibSession = null;
   	 	List retval = null;
   	 	StringBuffer queryBuffer = new StringBuffer();
   	 	try{
   	 		hibSession = com.anm.hibernate.HibernateConnection.getSession();
   	 		queryBuffer.append("select ubi, uat , bsi from Ismubi ubi, Ismuat uat , Ismbsi bsi where ubi.ubirfnum = uat.ismubi.ubirfnum and uat.uatisbilling = 'Y' and ( uat.uatisshipping = 'Y' or uat.uatisshipping = 'N' ) and ubi.ubirfnum = bsi.ismubi.ubirfnum and ubi.ubiusertype = 'W'");
   	 		Query query = hibSession.createQuery(queryBuffer.toString());
   	 		retval = query.list();
   	 	}catch( HibernateException e){
   	 		throw new  DAOException( e );
   	 	}
   	 	return retval;
	}
	
	public int unsubscribeUser(String emailid){
		Session hibSession = null;
   		try
		{
    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		Query query = hibSession.createQuery("update Ismubi ubi set ubi.ubiisnewsletter ='N' where ubi.ubilogin=:email");
    	    query.setString("email" , emailid);
    		int result = query.executeUpdate();
    		
    	    return result;
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
	}
	
	
	
	 /**
     * Method to get certain details of Invite Contacts based on a comma seperated
     * list of email Ids. 
     * @param commaSeperatedEmailIds
     * @return
     */
    public List getUsersByEmailIds(String commaSeperatedEmailIds)
    {
        Session session = getSession ();
        List returnList = null;
        String qry = "select ui.ubirfnum,ui.ubilogin,ui.isInvited " +
                "from Ismubi ui " +
                "where ui.ubiactive='Y' and ui.deleted='N' and ui.ubilogin in ("+commaSeperatedEmailIds+")";
        Query query = session.createQuery (qry);
        returnList = query.list ();
        return returnList;
    }
  // User Code - ENDS
    public int resetPassword(String userrefnum,String password,String emailauthcode, String isResetPassword){
		Session hibSession = null;
		String modidate="";
		Date today = new Date(System.currentTimeMillis());	
		Timestamp toTimestamp = new java.sql.Timestamp(today.getTime());
		modidate = toTimestamp.toString();
   		try
		{
    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		Query query = hibSession.createQuery("update Ismubi ubi set ubi.ubipass =:password, ubi.modidate=:modidate, ubi.emailauthcode=:emailauthcode, ubi.resetpassword=:isResetPassword, ubi.passwordresetdate=:passwordresetdate , ubi.ubiactive='Y' where ubi.ubirfnum=:userrefnum");
    		query.setString("password", password);
    		query.setString("modidate", modidate);
    		query.setLong("userrefnum" , new Long(userrefnum).longValue());
    		query.setString("emailauthcode", emailauthcode);
    		query.setString("isResetPassword", isResetPassword);    		
    		query.setString("passwordresetdate", modidate);    		
    		int result = query.executeUpdate();
    		
    	    return result;
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
	}
    
    public Ismubi findUserLogin(String ubilogin) throws DAOException {
        Session hibSession = null;
        List retvallist = null;
        Ismubi retval=null;
        try
        {
            hibSession = com.anm.hibernate.HibernateConnection.getSession();
            Query query = hibSession.createQuery("From Ismubi ubi where ubi.ubilogin=:ubilogin");
            query.setString("ubilogin" ,ubilogin);
            retvallist = query.list();
            if(retvallist.size()>0)
            retval = (Ismubi) retvallist.get(0);
        }catch( HibernateException e)
        {
            throw new  DAOException( e );
        }
        finally
        {
            
        }
        return retval;
    }
    	
    public Ismubi findbyCommunicateEmaiID(String ubilogin) throws DAOException {
    	
    	if(ubilogin != null) {
    		String emailId = ubilogin.trim().toLowerCase();
    		return findByUserId(emailId);
    	}
    	else 
    		return null;
    	
    	
    }
    
    public Ismubi findbyUserMobile(String mobile) throws DAOException {
        Session hibSession = null;
        Ismubi retval = null;
        List retvalList = null;
        try
        {
            hibSession = com.anm.hibernate.HibernateConnection.getSession();
            Query query = hibSession.createQuery("From Ismubi ubi where ubi.mobile=:mobile");
            query.setString("mobile",mobile);
            retvalList = query.list();
            if (retvalList.size() > 0 )
    			retval = (Ismubi) retvalList.get(0);
    	}catch( HibernateException e)
        {
            throw new  DAOException( e );
        }
        finally
        {
            
        }
        return retval;
    }
    
    public Ismubi findByUserRef(String userRefNo) throws DAOException {
		Session hibSession = null;
    	List retvallist = null;
    	Ismubi retval=null;
    	try
		{
    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		Query query = hibSession.createQuery("from Ismubi where ubirfnum=:usrRfNum");
    	    query.setLong("usrRfNum" , new Long(userRefNo).longValue());
    	    retvallist = query.list();
    	    if(retvallist.size()>0)
    	    	retval=(Ismubi)retvallist.get(0);
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		finally
		{
			
		}
		return retval;
	}
    

    public int findByCreatedDate(String yesterday) throws DAOException 
    {
    	System.out.println("date: "+yesterday);
    	yesterday=yesterday+" 00:00:00";
    	
    	Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String today = dateFormat.format(cal.getTime());
		today=today+" 23:59:59";
		Session hibSession = null;
    	List retval = null;
    	int count= 0; 
    	try
		{
    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		Query query = hibSession.createQuery("select count(ubirfnum) from Ismubi where createdate between :yesterday and :today and ubiusertype=:ubiusertype");
    	    query.setString("yesterday",yesterday);
    	    query.setString("today",today);
    	    query.setString("ubiusertype","W");
            retval = query.list();
            
            if(retval!=null && retval.size()>0)
            	count = Integer.parseInt(retval.get(0)+"");
		}
    	catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
    	    	
		return count;
    }
    
    public String findUserCity(String userRefNo){
    	List retval = null;
		String usercity=null;
		try {
			Session hibSession = null;
			
				hibSession = com.anm.hibernate.HibernateConnection.getSession();
				Query query = hibSession.createQuery("select uat.cityMaster.description from Ismuat uat where uat.ismubi.ubirfnum= :userRefNo");
				query.setLong("userRefNo", new Long(userRefNo).longValue());
				retval = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		if(retval!=null && retval.size()>0){
			usercity = (String)retval.get(0);
		}
		return usercity;
    		}
    
    public List getAllUsers()
    {
    	 Session hibSession = null;
    	 List retval = null;
    	 try
    	 {
    		 hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		 Query query = hibSession.createQuery("select ui.ubirfnum,ui.ubilogin from Ismubi ui where ui.ubiactive='Y' and ui.deleted='N'");
    		 retval = query.list();
    	 }catch( HibernateException e)
    	 {
    		 throw new  DAOException( e );
    	 }
    	 return retval;	
    }
    
    public int userDeActivate(String userrefnum){
		Session hibSession = null;
   		try
		{
    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		Query query = hibSession.createQuery("update Ismubi ubi set ubiactive='N' where ubi.ubirfnum=:userrefnum");
    		query.setLong("userrefnum" , new Long(userrefnum).longValue());
    		int result = query.executeUpdate();
    		
    	    return result;
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
	}
    public int resetPassword(String userrefnum,String password,Date passwordresetdate,Date lastlogin,Date emailauthcodeexpiry,Character resetpassword,String emailauthcode){
		Session hibSession = null;
   		try
		{
    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		Query query = hibSession.createQuery("update Ismubi ubi set ubi.ubipass =:password,ubi.passwordresetdate=:passwordresetdate,ubi.lastlogin=:lastlogin,ubi.emailauthcodeexpiry=:emailauthcodeexpiry,ubi.resetpassword=:resetpassword," +
    				"ubi.emailauthcode=:emailauthcode where ubi.ubirfnum=:userrefnum");
    		query.setString("password", password);
    		query.setLong("userrefnum" , new Long(userrefnum).longValue());
    		query.setCharacter("resetpassword", resetpassword);
    		query.setTimestamp("passwordresetdate",passwordresetdate);
    		query.setTimestamp("lastlogin",lastlogin);
    		query.setTimestamp("emailauthcodeexpiry", emailauthcodeexpiry);
    		query.setString("emailauthcode", emailauthcode);
    		int result = query.executeUpdate();
    		
    	    return result;
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
	}
	/**
	 * @param startdate
	 * @param enddate
	 * @param state
	 * @param city
	 * @param ubiisactive
	 * @return 
	 * @This function used to export user record.
	 */
	public List exportAllUsers(Date startdate, Date enddate, String state,
			String city, String ubiisactive) {
		Session hibSession = null;
		List retval = null;

		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();

			StringBuilder builder = new StringBuilder();

			builder.append(" select ubi.ubirfnum, ubi.ubilogin,ubi.ubipass,ubi.ubifname,ubi.ubimname,ubi.ubilname,ubi.ubiactive,ubi.mobile,ubi.communicationEmail from Ismubi ubi left join ubi.ismuats uat left join uat.cityMaster cMaster left join uat.stateMaster sMaster");
			
			builder.append(" where");
			
			if (startdate != null && enddate != null) {
				builder.append(" ubi.createdate between :startDate and :endDate");
			}

			if (state != null && !"".equalsIgnoreCase(state)) {
				builder.append(" and sMaster.staterfnum=:stateRfnum");
			}

			if (city != null && !"".equalsIgnoreCase(city)) {
				builder.append(" and cMaster.cityrfnum=:cityRfnum");
			}

			if (ubiisactive != null && !"".equalsIgnoreCase(ubiisactive)) {
				builder.append(" and ubi.ubiactive=:ubiactive");
			}
			builder.append(" group by ubi.ubirfnum");
			
			String q = builder.toString();
			
			Query query = hibSession.createQuery(q);
			if (startdate != null && enddate != null) {
			query.setDate("startDate", startdate);
			query.setDate("endDate", enddate);
			}
			if (state != null)
				query.setString("stateRfnum", state);
			if (city != null)
				query.setString("cityRfnum", city);

			if (ubiisactive != null)
				query.setString("ubiactive", ubiisactive);

			retval = query.list();
			System.out.print(q);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retval;
	}
	public List exportIsPreffUsersCityState(String state, String city) {
		Session hibSession = null;
		List retval = null;

		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();

			StringBuilder builder = new StringBuilder();

			builder.append(" select uat.uatrfnum,uat.ismubi.ubirfnum, uat.uatispreffered,uat.cityMaster.description,uat.stateMaster.description from Ismuat uat");
			
			builder.append(" where uat.uatispreffered='Y'");

			if (state != null && !"".equalsIgnoreCase(state)) {
				builder.append(" and uat.stateMaster.staterfnum=:stateRfnum");
			}

			if (city != null && !"".equalsIgnoreCase(city)) {
				builder.append(" and uat.cityMaster.cityrfnum=:cityRfnum");
			}

			builder.append(" group by uat.ismubi.ubirfnum");
			
			String q = builder.toString();
			
			Query query = hibSession.createQuery(q);
			
			if (state != null)
				query.setString("stateRfnum", state);
			if (city != null)
				query.setString("cityRfnum", city);

			retval = query.list();
			System.out.print(q);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retval;
	}

	
	/**
	 * @param userName
	 * @param userPassword
	 * @param partnerid
	 * @return
	 */
	public String checkValidLoginForPartnerApiUser(String userName,String userPassword){
		String status="false";
		List list=null;
		Map map=new HashMap();
		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
		Query query = hibSession
				.createQuery("select ubi.ubilogin from Ismubi ubi where ubi.ubilogin =:userid " +
						"and ubi.ubipass=:password");
		query.setString("userid", userName);
		query.setString("password", userPassword);
		
		list = query.list();
		if (list.size() > 0){
			status="true";			
		}
		return status;
	}
	
	/**
	 * @param userName
	 * @param partnerid
	 * @return
	 */
	public String checkValidLoginByUserForPartnerApiUser (String userName,String partnerid){
		String responseMessage="false";
		List list=null;
		Map map=new HashMap();
		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
		Query query = hibSession
				.createQuery("select ubi.ubilogin from Ismubi ubi where ubi.ubilogin =:userid " +
						"and(ubi.ubipmrfnum is null or ubi.ubipmrfnum=:partnerid)");
		query.setString("userid", userName);
		query.setString("partnerid", partnerid);
		
		list = query.list();
		if (list.size() > 0){
			responseMessage="true";			
		}
		return responseMessage;
	}
	
	/**
	 * @param userName
	 * @param partnerid
	 * @return
	 */
	public Ismubi populateApiUserDetail(String userName,String partnerid){
		Ismubi retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From Ismubi ubi where ubi.ubilogin =:userid";
			Query query = hibSession.createQuery(queryString);
			query.setString("userid", userName);
			retvalList = query.list();
			if (retvalList.size() > 0 )
				retval = (Ismubi) retvalList.get(0);
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
	public Ismubi findByUbiInvitaionName(String ubiInvitationName) throws DAOException{
		Ismubi retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From Ismubi ubi where ubi.ubiinvitationname =:ubiInvitationName";
			Query query = hibSession.createQuery(queryString);
			query.setParameter("ubiInvitationName", ubiInvitationName.trim());
			retvalList = query.list();
			if (retvalList.size() > 0 )
				retval = (Ismubi) retvalList.get(0);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		finally
		{
			
		}
		return retval;
	}
	public int updateUbiInvitationName(String setInvitationNameVal,String ubiLogin,String ubiRfnum){
		Session hibSession = null;
   		try
		{
    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		Query query = hibSession.createQuery("update Ismubi ubi set ubi.ubiinvitationname =:setInvitationNameVal where ubi.ubilogin=:ubiLogin and ubi.ubirfnum=:ubiRfnum");
    	    query.setString("ubiLogin" , ubiLogin);
    	    query.setString("ubiRfnum" , ubiRfnum);
    	    query.setString("setInvitationNameVal" , setInvitationNameVal);
    		int result = query.executeUpdate();
    		
    	    return result;
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
	}
	public List findUserData(String variable, Date startDate,Date endDate,int from,int to,Integer[] total,Long location,String userType)
    		throws com.anm.hibernate.DAOException, NullPointerException,
    		SQLException {
    	List nameList = null;
    	Session hibSession = null;
    	Date today=new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		calendar.add(Calendar.MONTH, -6);
		Date lastLoginDate = calendar.getTime();
		SimpleDateFormat active=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String lLDate=active.format(lastLoginDate);
		String sDate=active.format(startDate);
		String eDate=active.format(endDate);
    	try {
    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		StringBuffer sb = new StringBuffer();
    		StringBuffer whereClause = new StringBuffer();
    		StringBuffer groupBy = new StringBuffer();
    		sb.append("select ubi.lastlogin,ubi.ubifname,ubi.ubilname,uat.cityMaster.description," +
    				"bsi.bsigender,uat.uatmobile,uat.uatphone,ubi.ubirfnum");    		
    		whereClause.append(" from Ismubi ubi,Ismuat uat,Ismbsi bsi" +
    				" where ubi.ubirfnum=bsi.ismubi.ubirfnum and ubi.ubirfnum=uat.ismubi.ubirfnum" +
    				" and bsi.bsidob between :sDate and :eDate and (ubi.ubicallcenterflag !='N' or ubi.ubicallcenterflag is null) and uat.uatisbilling='Y' ");
    		if(variable!=null && !variable.equalsIgnoreCase("null"))
    		{
        		if ((variable.equals("Female"))) {
        			whereClause.append(" and bsi.bsigender= 'F'");    			
        		}
        		if ((variable.equals("Male"))) {
            		whereClause.append(" and bsi.bsigender= 'M'");            			
        		}
    		}
    		if (location !=null && ! location.equals(0)) {
    			whereClause.append(" and uat.cityMaster.cityrfnum= :location");   
    		}
    		if(userType!=null && !userType.equalsIgnoreCase("null"))
    		{
        		if(userType.equalsIgnoreCase("Active User"))
        		{
        			whereClause.append(" and ubi.lastlogin >= :lLDate ");
        		}
        		if(userType.equalsIgnoreCase("InActive User"))
        		{
        			whereClause.append(" and ubi.lastlogin < :lLDate ");
        		}
    		}
    	    sb.append(whereClause);
    		groupBy.append(" group by ubi.ubirfnum order by ubi.ubifname asc");
    		sb.append(groupBy);
    		Query query = hibSession.createQuery(sb.toString());
    		query.setTimestamp("sDate",startDate);
    		query.setTimestamp("eDate",endDate);
    		if (location !=null && ! location.equals(0)) {
    			query.setLong("location",location.longValue() );
    		}
    		if(userType!=null && !userType.equalsIgnoreCase("null"))
    		{
        		if(userType.equalsIgnoreCase("Active User"))
        		{
        			query.setString("lLDate" , lLDate);
        		}
    		if(userType.equalsIgnoreCase("InActive User"))
    		{
    			query.setString("lLDate" , lLDate);
    		}
    		}
            if (total != null && total.length > 0) {
        	     Object obj = query.list().size();
        	     total[0] = (Integer) obj;
        	     if (total[0].intValue() == 0)
        	         return nameList; 
        	 }            
        	 int max = (to-from); 		 
        	 query.setFirstResult(from);
        	 query.setMaxResults(max);
        	 hibSession.doWork( new Work() {
				@Override
				public void execute(Connection connection) throws SQLException {
					connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
				}
			});
        	 
        	 nameList = query.list();
    	} catch (HibernateException e) {
    		throw new com.anm.hibernate.DAOException(e);
    	} catch (NullPointerException ne) {
    		throw ne;
    	} finally {
    	
    	}
    	return nameList;
    	}
	public List findCountForUserBasedSaleQueue(Long callcenter) throws DAOException {        
        Object retval = null;
        Session hibSession = null;
        List nameList = null;
        try {
            hibSession = com.anm.hibernate.HibernateConnection.getSession();
            Query query = hibSession.createQuery("select count(ubi.ubirfnum) From Ismubi ubi where ubi.ubicallcenterflag='N' and ubi.ismccd.ccdrfnum= :callcenter group by ubi.ismccd.ccdname ");
            query.setLong("callcenter" , new Long(callcenter).longValue());
            nameList = query.list();
        
        } catch (HibernateException e) {
            throw new com.anm.hibernate.DAOException(e);
        }
        return nameList;
    }
	public List findCountForUserBasedSale(Long callcenter) throws DAOException {        
        Object retval = null;
        Session hibSession = null;
        List nameList = null;
        try {
            hibSession = com.anm.hibernate.HibernateConnection.getSession();
            Query query = hibSession.createQuery("select ubi.ubirfnum From Ismubi ubi where ubi.ubicallcenterflag='N' and ubi.ismccd.ccdrfnum= :callcenter");
            query.setLong("callcenter" , callcenter.longValue());
            nameList = query.list();
        
        } catch (HibernateException e) {
            throw new com.anm.hibernate.DAOException(e);
        }
        return nameList;
    }
	public List findUserDataByCRM(Long variable, int from,int to,Integer[] total)
    		throws com.anm.hibernate.DAOException, NullPointerException,
    		SQLException {
    	List nameList = null;
    	Session hibSession = null;
    	try {
    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		StringBuffer sb = new StringBuffer();
    		StringBuffer whereClause = new StringBuffer();
    		StringBuffer has=new StringBuffer();
    		sb.append("select ubi.lastlogin,ubi.ubifname,ubi.ubilname,uat.cityMaster.description," +
    				"bsi.bsigender,uat.uatmobile,uat.uatphone,ubi.ubirfnum");
    		
    		whereClause.append(" from Ismubi ubi,Ismuat uat,Ismbsi bsi" +
    				" where ubi.ubicallcenterflag='N' and ubi.ismccd.ccdrfnum= :variable and bsi.bsiubirfnum=ubi.ubirfnum and uat.ismubi.ubirfnum=ubi.ubirfnum group by ubi.ubirfnum order by ubi.ubifname ");
    	    sb.append(whereClause);
    		System.out.println(sb);
    		Query query = hibSession.createQuery(sb.toString());
    		query.setLong("variable" , new Long(variable).longValue());
             if (total != null && total.length > 0) {
        	     Object obj = query.list().size();
        	     total[0] = (Integer) obj;
        	     if (total[0].intValue() == 0)
        	         return nameList; 
        	 }
             if (total != null) {
            	 System.err.println("++++ Total records using count  ["+total[0].intValue()+"]");		 
             }
        	 
        	 int max = (to-from); 		 
        	 query.setFirstResult(from);
        	 query.setMaxResults(max);
    		hibSession.doWork(new Work() {
				
				@Override
				public void execute(Connection connection) throws SQLException {
					connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
				}
			});
    		nameList = query.list();
    	} catch (HibernateException e) {
    		throw new com.anm.hibernate.DAOException(e);
    	} catch (NullPointerException ne) {
    		throw ne;
    	} finally {
    	
    	}
    	return nameList;
    	}
	
	public Ismubi findByUserMobile(String userMobile) throws DAOException{
		Ismubi retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From Ismubi ubi where (ubi.ubilogin =:ubiLogin or ubi.mobile=:mobile)";
			Query query = hibSession.createQuery(queryString);
			query.setParameter("ubiLogin", userMobile.trim()+"@bagittoday.com");
			query.setParameter("mobile", userMobile.trim());
			retvalList = query.list();
			if (retvalList.size() > 0 )
				retval = (Ismubi) retvalList.get(0);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		finally
		{
			
		}
		return retval;
	}	
	
	/*Used for My Account Credit for referrer*/
	public List findAcceptedUser(String ubilogin) throws DAOException {
   	 Session hibSession = null;
   	 List retval = null;
   	 try
   	 {
   		 hibSession = com.anm.hibernate.HibernateConnection.getSession();
   		 Query query = hibSession.createQuery("from Ismubi ubi where ubi.refererLoginId=:ubilogin");
   		 query.setString("ubilogin" , ubilogin);
   		 retval = query.list();
   	 }catch( HibernateException e)
   	 {
   		 throw new  DAOException( e );
   	 }
   	 return retval;
    }

	
	public List findByCreatedDateBeforeTenDays() throws DAOException 
    {
        Session hibSession = null;
        List retval = null;
        try
        {
            hibSession = com.anm.hibernate.HibernateConnection.getSession();
            SQLQuery query = hibSession.createSQLQuery("SELECT ubi.* FROM (SELECT ubi.* FROM ismubi ubi, ismic ic " +
            		"WHERE ubi.ubirfnum=ic.INVITE_USER_ID AND (ubi.createdate BETWEEN CONCAT(SUBDATE(CURDATE(),INTERVAL 10 DAY),' 00:00:00') AND " +
            		"CONCAT(SUBDATE(CURDATE(),INTERVAL 10 DAY),' 23:59:59'))) ubi LEFT JOIN ismpot pot ON ubi.ubirfnum=pot.potubirfnum AND " +
            		"(pot.potordate BETWEEN SUBDATE(CURDATE(),INTERVAL 10 DAY) AND SUBDATE(CURDATE(),INTERVAL 1 DAY)) WHERE pot.potubirfnum IS NULL");
           
            query.addEntity(Ismubi.class);
            retval = query.list();
            
        }
        catch( HibernateException e)
        {
            throw new  DAOException( e );
        }
                
        return retval;
    }
	
	 public int resetPasswordMobile(String userrefnum,String password,String mobileauthcode, String isResetPassword){
			Session hibSession = null;
			String modidate="";
			Date today = new Date(System.currentTimeMillis());	
			Timestamp toTimestamp = new java.sql.Timestamp(today.getTime());
			modidate = toTimestamp.toString();
	   		try
			{
	    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
	    		Query query = hibSession.createQuery("update Ismubi ubi set ubi.ubipass =:password, ubi.modidate=:modidate, ubi.authcode=:authcode, ubi.resetpassword=:isResetPassword, ubi.passwordresetdate=:passwordresetdate , ubi.ubiactive='Y' where ubi.ubirfnum=:userrefnum");
	    		query.setString("password", password);
	    		query.setString("modidate", modidate);
	    		query.setLong("userrefnum" , new Long(userrefnum).longValue());
	    		query.setString("authcode", mobileauthcode);
	    		query.setString("isResetPassword", isResetPassword);    		
	    		query.setString("passwordresetdate", modidate);    		
	    		int result = query.executeUpdate();
	    		
	    	    return result;
			}catch( HibernateException e)
			{
				throw new  DAOException( e );
			}
		}
	
	 public Long getLoginDetail(String userid, String password){
		 Long ubirfnum=0l;
		 Ismubi ismubi=null;
		 Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
		 Query query = hibSession.createQuery("from Ismubi ubi where ubi.ubilogin =:userid and ubi.ubipass=:password");
		 query.setString("userid", userid);
		 query.setString("password", password);
		 List list = query.list();
		 if(list.size() > 0)
			 ismubi=(Ismubi) list.get(0);
		 if(ismubi!=null)
			 ubirfnum=ismubi.getUbirfnum();
			
		 return ubirfnum;			
	}
	 
	 public Long getLoginDetail(String userid){
		 Long ubirfnum=0l;
		 Ismubi ismubi=null;
		 Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
		 Query query = hibSession.createQuery("from Ismubi ubi where ubi.ubilogin =:userid ");
		 query.setString("userid", userid);
			
		 List list = query.list();
		 if(list.size() > 0)
			 ismubi=(Ismubi) list.get(0);
		 if(ismubi!=null)
			 ubirfnum=ismubi.getUbirfnum();
		 return ubirfnum;			
		}
	 
	 public Ismubi getIsmbuiByUserLoginId(String userid){
		 Ismubi ismubi=null;
		 Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
		 Query query = hibSession.createQuery("from Ismubi ubi where ubi.ubilogin =:userid ");
		 query.setString("userid", userid);			
		 List list = query.list();
		 if(list!=null && list.size() > 0)
			 ismubi=(Ismubi) list.get(0);
		 
		 return ismubi;			
		}
	 
	 public List getCommunicationEmail(Long ubirfnum){
			Session hibSession = null;
			List aList=null;
			try{
				hibSession = com.anm.hibernate.HibernateConnection.getSession();
				String queryString="select ubi.communicationEmail,ubi.ubilogin, ubi.ubifname from Ismubi ubi where ubi.ubirfnum=:ubirfnum";
				Query query = hibSession.createQuery(queryString);
				query.setLong("ubirfnum", ubirfnum);
				aList=query.list();
			}
			catch(Exception er){
				throw new DAOException(er);
			}
			
			return aList;
		}
	 
	 public Ismubi findbyUserMobile(String mobile, Long afmrfnum) throws DAOException {
	        Session hibSession = null;
	        Ismubi retval = null;
	        List retvalList = null;         
	        try
	        {        	
	            hibSession = com.anm.hibernate.HibernateConnection.getSession();
	            Query query = null;            
	            if(afmrfnum != null){
	       			query = hibSession.createQuery("From Ismubi ubi where ubi.ubilogin=:mobile and ubi.ismafm.afmrfnum=:afmrfnum");
	       		}else{
	       			query = hibSession.createQuery("From Ismubi ubi where ubi.ubilogin=:mobile and ubi.ismafm.afmrfnum is null");
	       		}
	            
	            if(afmrfnum != null){
	       			query.setLong("afmrfnum" , afmrfnum);	 
	       		}            
	            query.setLong("ubilogin",new Long(mobile));
	            retvalList = query.list();
	            if (retvalList.size() > 0 )
	    			retval = (Ismubi) retvalList.get(0);
	    	}catch( HibernateException e)
	        {
	            throw new  DAOException( e );
	        }
	        finally
	        {
	            
	        }
	        return retval;
	    }


	    public Ismubi findUserLogin(String ubilogin, Long afmrfnum) throws DAOException {
	        Session hibSession = null;
	        List retvallist = null;
	        Ismubi retval=null;        
	        try
	        {	
	            hibSession = com.anm.hibernate.HibernateConnection.getSession();
	            Query query = null;
	            if(afmrfnum != null){
	            	query = hibSession.createQuery("From Ismubi ubi where ubi.ubilogin=:ubilogin and ubi.ismafm.afmrfnum=:afmrfnum");	
	            }else{
	            	query = hibSession.createQuery("From Ismubi ubi where ubi.ubilogin=:ubilogin and ubi.ismafm.afmrfnum is null");
	            }
	            if(afmrfnum != null){
	       			query.setLong("afmrfnum" , afmrfnum);	 
	       		}             
	            query.setString("ubilogin" ,ubilogin);
	            retvallist = query.list();
	            if(retvallist.size()>0)
	            retval = (Ismubi) retvallist.get(0);
	        }catch( HibernateException e)
	        {
	            throw new  DAOException( e );
	        }
	        finally
	        {
	            
	        }
	        return retval;
	    }

	    public Ismubi getUser(String ubiLogin) throws DAOException{
			Ismubi ismubi=null;
			Session hibSession = null;
			List retvalList = null;
			
			try {
				hibSession = com.anm.hibernate.HibernateConnection.getSession();
				
				String queryString = "From Ismubi ubi where ubi.ubilogin =:ubiLogin and ubi.ubipmrfnum is null";
				Query query = hibSession.createQuery(queryString);
				query.setParameter("ubiLogin", ubiLogin);
				retvalList = query.list();
				if (retvalList.size() > 0 )
					ismubi=(Ismubi) retvalList.get(0);
			} catch (HibernateException e) {
				throw new DAOException(e);
			}
			finally
			{
				
			}
			return ismubi;
		}
		public Ismubi findBySsi(Long ubiRfnum)throws DAOException{
			List retval = null;
			Ismubi ubiLogin=null;
			try {
				Session hibSession = null;				
				hibSession = com.anm.hibernate.HibernateConnection.getSession();
				Query query = hibSession.createQuery("Select ubi from Ismubi ubi,Ismout out,Ismssi ssi where ubi.ubilogin=out.outlogin and out.ismssi.ssirfnbr=:ubiRfnum");
				query.setLong("ubiRfnum" ,ubiRfnum.longValue());
				retval = query.list();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			if(retval!=null && retval.size()>0){
				ubiLogin = (Ismubi)retval.get(0);
			}
			return ubiLogin;
		}
		
		public Ismubi findByUserLoginId(String ubiLogin) throws DAOException{
			Ismubi retval = null;
			Session hibSession = null;
			List retvalList = null;
			try {
				hibSession = com.anm.hibernate.HibernateConnection.getSession();
				String queryString = "FROM Ismubi ubi "
	                + " left join fetch ubi.ismbsi"
					+ " left join fetch ubi.ismcct"
	                + " where ubi.ubilogin =:ubiLogin";
				Query query = hibSession.createQuery(queryString);
				query.setParameter("ubiLogin", ubiLogin);
				retvalList = query.list();
				if(retvalList!= null && !retvalList.isEmpty())
					retval = (Ismubi) retvalList.get(0);			
				
			} catch (HibernateException e) {
				throw new DAOException(e);
			}
			finally
			{
				
			}
			return retval;
		}
		
    	
    	public boolean checkValidLoginForBackend(String userid, String password) {
    		
    		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		Query query = null;
    	    query = hibSession.createQuery("select ubi.ubilogin from Ismubi ubi where ubi.ubilogin =:userid and ubi.ubipass=:password and (ubi.ubipmrfnum is null or ubi.ubipmrfnum=94) and ubi.ismafm.afmrfnum is null");
    		query.setString("userid", userid);
    		query.setString("password", password);
    		List list = query.list();
    		if (list.size() > 0)
    		{
    			return true;
    		}
    		else
    		{
    			return false;		
    		}
    	} 
   	 public List findByUserMobileCzCaller(String userMobile, String domainName) throws DAOException{
			Ismubi retval = null;
			Session hibSession = null;
			List retvalList = null;
			try {
				hibSession = com.anm.hibernate.HibernateConnection.getSession();
				String queryString = "From Ismubi ubi where (ubi.ubilogin =:ubiLogin or ubi.mobile=:mobile)";
				Query query = hibSession.createQuery(queryString);
				
				/* Starts: SHOPTODAY PROJECT - Code changes for making domain specific values dynamic */
				query.setParameter("ubiLogin", userMobile.trim()+"@"+domainName);
				query.setParameter("mobile", new Long(userMobile.trim()));
				retvalList = query.list();
			} catch (HibernateException e) {
				throw new DAOException(e);
			}
			finally
			{
				
			}
			return retvalList;
	}
	    public List findbyUserMobileReturnList(String mobile, Long afmrfnum) throws DAOException {
	        Session hibSession = null;        
	        List retvalList = new ArrayList();         
	        try
	        {        	
	            hibSession = com.anm.hibernate.HibernateConnection.getSession();
	            Query query = null;            
	            if(afmrfnum != null){
	       			query = hibSession.createQuery("From Ismubi ubi where ubi.mobile=:mobile and ubi.ismafm.afmrfnum=:afmrfnum");
	       		}else{
	       			query = hibSession.createQuery("From Ismubi ubi where ubi.mobile=:mobile and ubi.ismafm.afmrfnum is null");
	       		}
	            
	            if(afmrfnum != null){
	       			query.setLong("afmrfnum" , afmrfnum);	 
	       		}            
	            query.setLong("mobile",new Long(mobile));
	            retvalList = query.list();
	    	}catch( HibernateException e)
	        {
	            throw new  DAOException( e );
	        }
	        finally
	        {
	            
	        }
	        return retvalList;
	    }
	    public List findUserLoginReturnList(String ubilogin, Long afmrfnum) throws DAOException {
	        Session hibSession = null;
	        List retvallist = new ArrayList();        
	        try
	        {	
	            hibSession = com.anm.hibernate.HibernateConnection.getSession();
	            Query query = null;
	            if(afmrfnum != null){
	            	query = hibSession.createQuery("From Ismubi ubi where ubi.ubilogin=:ubilogin and ubi.ismafm.afmrfnum=:afmrfnum");	
	            }else{
	            	query = hibSession.createQuery("From Ismubi ubi where ubi.ubilogin=:ubilogin and ubi.ismafm.afmrfnum is null");
	            }
	            if(afmrfnum != null){
	       			query.setLong("afmrfnum" , afmrfnum);	 
	       		}             
	            query.setString("ubilogin" ,ubilogin);
	            retvallist = query.list();
	        }catch( HibernateException e)
	        {
	            throw new  DAOException( e );
	        }
	        finally
	        {
	            
	        }
	        return retvallist;
	    }
	    /**
    	 * To check whether user login is valid
    	 */
    	public boolean checkValidLoginCall(String userid, String password) {
    		StringBuffer buffer = new StringBuffer();
    		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		buffer.append("select ubi.ubilogin from Ismubi ubi where ubi.ubilogin =:userid and ubi.ubipass=:password ");
    		if(userid!=null && !"superadmin".equalsIgnoreCase(userid)){
    			buffer.append(" and ubi.ubiactive='Y' and ubi.deleted='N'");
    		}
    		Query query = hibSession
    				.createQuery(buffer.toString());
    		query.setString("userid", userid);
    		query.setString("password", password);
    		List list = query.list();
    		if (list.size() > 0)
    		{
    			return true;
    		}
    		else
    		{
    			return false;		
    		}
    	
    	} 
    	
    	public boolean checkValidLoginUser(String userid) {
    		StringBuffer buffer = new StringBuffer();
    		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
    		buffer.append("select ubi.ubilogin from Ismubi ubi where ubi.ubilogin =:userid");
    		if(userid!=null && !"superadmin".equalsIgnoreCase(userid)){
    			buffer.append(" and ubi.ubiactive='Y' and ubi.deleted='N'");
    		}
    		Query query = hibSession
    				.createQuery(buffer.toString());
    		query.setString("userid", userid);
    		List list = query.list();
    		if (list.size() > 0)
    		{
    			return true;
    		}
    		else
    		{
    			return false;		
    		}
    	
    	} 
    	
    	public Ismubi findByUserMobile(String userMobile, String domainName) throws DAOException{
    		Ismubi retval = null;
    		Session hibSession = null;
    		List retvalList = null;
    		try {
    			hibSession = com.anm.hibernate.HibernateConnection.getSession();
    			String queryString = "From Ismubi ubi where (ubi.ubilogin =:ubiLogin or ubi.mobile=:mobile)";
    			Query query = hibSession.createQuery(queryString);
    			query.setParameter("ubiLogin", userMobile.trim()+"@"+domainName);
    			query.setParameter("mobile", userMobile.trim());
    			retvalList = query.list();
    			if (retvalList.size() > 0 )
    				retval = (Ismubi) retvalList.get(0);
    		} catch (HibernateException e) {
    			throw new DAOException(e);
    		}
    		finally
    		{
    			
    		}
    		return retval;
    	}


		public Ismubi findUserExistance(String corporateEmailID) {
		    Ismubi retval = null;
			Session hibSession = null;
			List retvalList = null;
			try {
				hibSession = com.anm.hibernate.HibernateConnection.getSession();
				String queryString = "From Ismubi ubi where lower(ubi.ubilogin) =:corporateEmailID";
				Query query = hibSession.createQuery(queryString);
				query.setString("corporateEmailID", corporateEmailID.toLowerCase());
				retvalList = query.list();
				if (retvalList.size() > 0 )
					retval = (Ismubi) retvalList.get(0);
			} catch (HibernateException e) {
				throw new DAOException(e);
			}finally{		
			}
			return retval;
		}	
    	
    	
    	public List findUserList(int from,int MAX,Map params,Integer[] totalRecords) throws com.anm.hibernate.DAOException,NullPointerException, SQLException{
    		Session hibSession = null;
    	   	List retval = null;
    	   	try{
    	   		boolean flag=false;
    	   		hibSession = com.anm.hibernate.HibernateConnection.getSession();
    			StringBuffer sb = new StringBuffer();
    			StringBuffer sbcount = new StringBuffer();
    			
    			sb.append("from Ismubi ");
    			sbcount.append("select count(ubirfnum) from Ismubi ");
    			
    			if (params.get("ubirfnum") != null) {
    				sb.append(" where ubirfnum=:ubirfnum ");
    				sbcount.append(" where ubirfnum=:ubirfnum ");
    				flag=true;
    			}
    			if (params.get("ubifname") != null) {
    				if(!flag){
    					sb.append(" where ubifname=:ubifname ");
    					sbcount.append(" where ubifname=:ubifname ");
    					flag=true;
    				}else{
    					sb.append(" and ubifname=:ubifname ");
    					sbcount.append(" and ubifname=:ubifname ");
    				}
    			}
    			if (params.get("ubilname") != null) {
    				if(!flag){
    					sb.append(" where ubilname=:ubilname ");
    					sbcount.append(" where ubilname=:ubilname ");
    					flag=true;
    				}else{
    					sb.append(" and ubilname=:ubilname ");
    					sbcount.append(" and ubilname=:ubilname ");
    				}
    			}
    			if (params.get("ubilogin") != null) {
    				if(!flag){
    					sb.append(" where ubilogin=:ubilogin ");
    					sbcount.append(" where ubilogin=:ubilogin ");
    					flag=true;
    				}else{
    					sb.append(" and ubilogin=:ubilogin ");
    					sbcount.append(" and ubilogin=:ubilogin ");
    				}
    			}
    			if (params.get("ubiisnewsletter") != null) {
    				if(!flag){
    					sb.append(" where ubiisnewsletter=:ubiisnewsletter ");
    					sbcount.append(" where ubiisnewsletter=:ubiisnewsletter ");
    					flag=true;
    				}else{
    					sb.append(" and ubiisnewsletter=:ubiisnewsletter ");
    					sbcount.append(" and ubiisnewsletter=:ubiisnewsletter ");
    				}
    			}
    			if (params.get("ubiactive") != null) {
    				if(!flag){
    					sb.append(" where ubiactive=:ubiactive ");
    					sbcount.append(" where ubiactive=:ubiactive ");
    					flag=true;
    				}else{
    					sb.append(" and ubiactive=:ubiactive ");
    					sbcount.append(" and ubiactive=:ubiactive ");
    				}
    			}
    			if (params.get("ubiusertype") != null) {
    				if(!flag){
    					if(params.get("ubiusertype").toString().equalsIgnoreCase("W")){
    						sb.append(" where (ubiusertype!='A' or  ubiusertype is null) ");
    						sbcount.append(" where (ubiusertype!='A' or  ubiusertype is null) ");
    					}else{
    						sb.append(" where ubiusertype=:ubiusertype");
    						sbcount.append(" where ubiusertype=:ubiusertype");
    					}
    					flag=true;
    				}else{
    					if(params.get("ubiusertype").toString().equalsIgnoreCase("W")){
    						sb.append(" and (ubiusertype!='A' or  ubiusertype is null) ");
    						sbcount.append(" and (ubiusertype!='A' or  ubiusertype is null) ");
    					}else{
    						sb.append(" and ubiusertype=:ubiusertype");
    						sbcount.append(" and ubiusertype=:ubiusertype");
    					}
    				}
    			}
    			System.out.println("[Details Query] :::::::::: "+sb);
    			Query query = hibSession.createQuery(sb.toString());
    			
    			if (totalRecords != null && totalRecords.length > 0) {
    				System.out.println("[Suborder Count Query] :::::::: "+sbcount);
    				Query countQuery = hibSession.createQuery(sbcount.toString());
    				
    				if (params.get("ubirfnum") != null) {
    					query.setLong("ubirfnum" , new Long(params.get("ubirfnum").toString()));
    					countQuery.setLong("ubirfnum" , new Long(params.get("ubirfnum").toString()));
    				}
    				if (params.get("ubifname") != null) {
    					query.setString("ubifname" , params.get("ubifname").toString());
    					countQuery.setString("ubifname" , params.get("ubifname").toString());
    				}
    				if (params.get("ubilname") != null) {
    					query.setString("ubilname" , params.get("ubilname").toString());
    					countQuery.setString("ubilname" , params.get("ubilname").toString());
    				}
    				if (params.get("ubilogin") != null) {
    					query.setString("ubilogin" , params.get("ubilogin").toString());
    					countQuery.setString("ubilogin" , params.get("ubilogin").toString());
    				}
    				if (params.get("ubiisnewsletter") != null) {
    					query.setString("ubiisnewsletter" , params.get("ubiisnewsletter").toString());
    					countQuery.setString("ubiisnewsletter" , params.get("ubiisnewsletter").toString());
    				}
    				if (params.get("ubiactive") != null) {
    					query.setString("ubiactive" , params.get("ubiactive").toString());
    					countQuery.setString("ubiactive" , params.get("ubiactive").toString());
    				}
    				if (params.get("ubiusertype") != null) {
    					if(params.get("ubiusertype").toString().equalsIgnoreCase("A")){
    						query.setString("ubiusertype" , params.get("ubiusertype").toString());
    						countQuery.setString("ubiusertype" , params.get("ubiusertype").toString());
    					}
    				}
    				
    				Object obj = countQuery.list().get(0);
    				totalRecords[0] = (Integer) obj;
    				System.out.println("++++++++++++++++++++++++++++ Total records --- "+totalRecords[0].intValue());
    				if (totalRecords[0].intValue() == 0)
    					return retval; 
    			}		
    			
    		 	query.setFirstResult(from);
    		 	query.setMaxResults(MAX);
    		 	
    		 	hibSession.doWork(new Work() {
    				@Override
    				public void execute(Connection connection) throws SQLException {
    					connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
    				}
    			});
    			retval = query.list();		
    			System.out.println("++++++++++++++++++++++++++++ Total records Display For Edit --- "+retval.size());
    	   	}catch (HibernateException e) {
    	    		throw new com.anm.hibernate.DAOException(e);
    	    } catch (NullPointerException ne) {
    	    		throw ne;
    	    } finally {
    	    	
    	    }
    	    return retval;
    	}
		public Ismubi findUserExists(String corporateEmailID) {
			if(corporateEmailID != null) {
	    		String emailId = corporateEmailID.trim().toLowerCase();
	    		return findByUserId(emailId);
	    	}
	    	else 
	    		return null;
		}
		
		public Ismubi findDuplicateEmail(String corporateEmailID, Long ubirfnum) {
		    Ismubi retval = null;
			Session hibSession = null;
			List<Ismubi> retvalList = null;
			try {
				hibSession = com.anm.hibernate.HibernateConnection.getSession();
				String queryString = "From Ismubi ubi where ubi.ubilogin =:corporateEmailID and ubi.ubirfnum=:ubirfnum";
				Query query = hibSession.createQuery(queryString);
				query.setString("corporateEmailID", corporateEmailID);
				query.setLong("ubirfnum", ubirfnum);
				retvalList = query.list();
				if (retvalList.size() > 0 )
					retval = (Ismubi) retvalList.get(0);
			} catch (HibernateException e) {
				throw new DAOException(e);
			}finally{		
			}
			return retval;
		}
    	
		public List<Ismubi> findByCondition(String rfnum, String fName,String lName, String ubiactive,String email, int start, int end,String ubiusertype, Long userRefNo) 
		{
			List<Ismubi> searchResultList = new ArrayList<Ismubi>();
			Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Criteria criteria = hibSession.createCriteria(Ismubi.class);
			criteria.createAlias("octParam", "param");
			
			if(rfnum!=null && !rfnum.equals("")){
				criteria.add(Expression.eq("ubirfnum", new Long(rfnum)));
			}
			if(fName!=null && !fName.equals("")){
				criteria.add(Expression.eq("ubifname", fName).ignoreCase());
			}
			if(lName!=null && !lName.equals("")){
				criteria.add(Expression.eq("ubilname", lName).ignoreCase());
			}
			if(ubiactive!=null && !ubiactive.equals("")){
				criteria.add(Expression.eq("ubiactive", ubiactive).ignoreCase());
			}if(ubiusertype!=null && !ubiusertype.equals("")){
				criteria.add(Expression.eq("param.paramrfnum", new Long(ubiusertype)));
			}if(email!=null && !email.equals("")){
				criteria.add(Expression.eq("ubilogin", email).ignoreCase());
			}if(userRefNo!=null){
				criteria.add(Expression.eq("createdby",userRefNo));
			}
			
			if(end!=0)
			{
				criteria.setFirstResult(start);
				criteria.setMaxResults(end);
				criteria.addOrder(Order.asc("ubilogin"));
		    }
			searchResultList=criteria.list();
	    	return searchResultList;
		}
		
		public int findByConditionCount(String rfnum, String fName,String lName,String email, String ubiactive, String ubiusertype, Long userRefNo) {
			List searchResultList = new ArrayList();
		    int recordCount=0;
			Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Criteria criteria = hibSession.createCriteria(Ismubi.class);
			criteria.createAlias("octParam", "param");
			if(rfnum!=null && !rfnum.equals("")){
				criteria.add(Expression.eq("ubirfnum", new Long(rfnum)));
			}if(fName!=null && ! fName.equals("")){
				criteria.add(Expression.eq("ubifname", fName).ignoreCase());
			}if(lName!=null && ! lName.equals("")){
				criteria.add(Expression.eq("ubilname", lName).ignoreCase());
			}if(ubiactive!=null && !ubiactive.equals("")){
				criteria.add(Expression.eq("ubiactive", ubiactive).ignoreCase());
			}if(ubiusertype!=null && !ubiusertype.equals("")){
				criteria.add(Expression.eq("param.paramrfnum", new Long(ubiusertype)));
			}if(email!=null){
				criteria.add(Expression.eq("ubilogin", email).ignoreCase());
			}if(userRefNo!=null){
				criteria.add(Expression.eq("createdby", userRefNo));
			}
			searchResultList=criteria.list();
			recordCount=searchResultList.size();
	    	return recordCount;
		}
		
		public List<Ismubi>findCreators(Long createdByRefNo){
			List<Ismubi>retVal=new ArrayList<Ismubi>();
			Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
			try{
				query=hibSession.createQuery("from Ismubi where ubirfnum=:createdByRefNo");
				query.setLong("createdByRefNo", createdByRefNo);
				retVal=query.list();
			}catch(HibernateException e){
				e.printStackTrace();
			}
			return retVal;
		}
		
		//@Deepak Deshekar ::Start Get User Emil Start 
		  public String findUserRegisterMail(String userRefNo){
		    	List retval = null;
				String email=null;
				try {
					Session hibSession = null;
					
						hibSession = com.anm.hibernate.HibernateConnection.getSession();
						Query query = hibSession.createQuery("select ubi.ubilogin from Ismubi ubi where ubi.ubirfnum=:userRefNo");
						query.setLong("userRefNo", new Long(userRefNo).longValue());
						retval = query.list();
				} catch (HibernateException e) {
					e.printStackTrace();
				}
				if(retval!=null && retval.size()>0){
					email = (String)retval.get(0);
				}
				return email;
		    }
			//@Deepak Deshekar ::Start Get User Emil End

		  
		  //@Deepak Deshekar :: Find communication email start
		  public String findUserCommunicationEmaill(String userRefNo){
		    	List retval = null;
				String email=null;
				try {
					Session hibSession = null;
					
						hibSession = com.anm.hibernate.HibernateConnection.getSession();
						Query query = hibSession.createQuery("select ubi.communicationEmail from Ismubi ubi where ubi.ubirfnum=:userRefNo");
						query.setLong("userRefNo", new Long(userRefNo).longValue());
						retval = query.list();
				} catch (HibernateException e) {
					e.printStackTrace();
				}
				if(retval!=null && retval.size()>0){
					email = (String)retval.get(0);
				}
				return email;
		    }
		//@Deepak Deshekar :: Find communication email end
		  
		  
		  public int userDeActivateByLoginIdAndUserType(String ubilogin, String ubiusertype){
				Session hibSession = null;
		   		try
				{
		    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
		    		Query query = hibSession.createQuery("update Ismubi ubi set ubiactive='N' where ubi.ubilogin=:ubilogin and ubiusertype=:ubiusertype");
		    		query.setString("ubilogin" , ubilogin);
		    		query.setString("ubiusertype", ubiusertype);
		    		int result = query.executeUpdate();
		    		
		    	    return result;
				}catch( HibernateException e)
				{
					throw new  DAOException( e );
				}
			}
		  
		  public int deleteUserByLoginIdAndUserType(String ubilogin, String ubiusertype){
				Session hibSession = null;
		   		try
				{
		    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
		    		Query query = hibSession.createQuery("update Ismubi ubi set ubi.deleted='Y' where ubi.ubilogin=:ubilogin and ubiusertype=:ubiusertype");
		    	    query.setString("ubilogin" , ubilogin);
		    	    query.setString("ubiusertype", ubiusertype);
		    		int result = query.executeUpdate();
		    		
		    	    return result;
				}catch( HibernateException e)
				{
					throw new  DAOException( e );
				}
			}
		  
		  public int userActivateByLoginIdAndUserType(String ubilogin, String ubiusertype){
				Session hibSession = null;
		   		try
				{
		    		hibSession = com.anm.hibernate.HibernateConnection.getSession();
		    		Query query = hibSession.createQuery("update Ismubi ubi set ubiactive='Y' where ubi.ubilogin=:ubilogin and ubiusertype=:ubiusertype and ubi.deleted='N'");
		    		query.setString("ubilogin" , ubilogin);
		    		query.setString("ubiusertype", ubiusertype);
		    		int result = query.executeUpdate();
		    		
		    	    return result;
				}catch( HibernateException e)
				{
					throw new  DAOException( e );
				}
			}
		  
		  public String findUserActivationStatus(String ubilogin, String ubiusertype, String deleted){
		    	List retval = null;
				String activeFlag=null;
				try {
					Session hibSession = null;
					
						hibSession = com.anm.hibernate.HibernateConnection.getSession();
						Query query = hibSession.createQuery("select ubi.ubiactive from Ismubi ubi where ubi.ubilogin=:ubilogin and ubiusertype=:ubiusertype and ubi.deleted=:deleted");
			    		query.setString("ubilogin" , ubilogin);
			    		query.setString("ubiusertype" , ubiusertype);
			    		query.setString("deleted" , deleted);
						retval = query.list();
				} catch (HibernateException e) {
					e.printStackTrace();
				}
				if(retval!=null && retval.size()>0){
					activeFlag = (String)retval.get(0);
				}
				return activeFlag;
		    }
		  
}