/*
 * Created on Sep 29, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.sellerportal.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

/**
 * @author Chandra Singh Meena
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class HibernateConnection {
    // the LOGGER for this class
    private static final Log LOGGER = LogFactory.getLog(HibernateConnection.class);
    private static final ThreadLocal<Session> threadSession = new ThreadLocal<Session>();
  
    private HibernateConnection() {
		
	}

    //Wrapper to get the session factory using the HibernateUtil
    public static SessionFactory getSessionFactory() {
        return HibernateUtil.getSessionFactory();
    }

    //Shutdown the hibernate Session factory.
    public static void releaseSessionFactory() {
        HibernateUtil.shutdown();
    }

    /*
     * Start a new Hibernate session if not already active 
     *  - Start new transaction
     */
    public static Session getSession() {
    	if(LOGGER.isDebugEnabled()) LOGGER.debug("getSession()");
        Session s = (Session) threadSession.get();
        boolean createNewSession = false;
        if (s == null) {            	
            createNewSession = true;
        }else {
        	//This was commented for some reason
            if (!s.isConnected()) {
            	//cleanup();
            	//createNewSession = true;            	
            	throw new HibernateException(" Application Error - Illegal session closing in application using session.close() ");                                                
            }
            
            if (s.getTransaction().getStatus()== TransactionStatus.ROLLED_BACK) {
            	//cleanup();
            	//createNewSession = true;
                throw new HibernateException("Application Error - Hibernate session is not useable anymore due to rollback. Call closeSession() and getSession() to suppress the errors ");
             }                                   
           
        }
        
        if(createNewSession)
        {
        	s = getSessionFactory().openSession();                
            setIsolationLevel(s); // Set the isolation from the configuration
            threadSession.set(s);                
                        
        }
       
        if(s != null)
        	s.beginTransaction();
        
        return s;
    }
    
    /*
     * get Hibernate StatelessSession(Without caching object) for Batch Processing
     * ByPass Interceptors/No Cascading of composed objects/Ignore Collection/No Object Persistence
     */
    public static StatelessSession getStatelessSession() {
    	if(LOGGER.isDebugEnabled()) LOGGER.debug("getStatelessSession()");
    	StatelessSession s = getSessionFactory().openStatelessSession();
        return s;
    }
    
    private static int setIsolationLevel(Session s) {
    	/*String isolationLevel = HibernateUtil.getConfiguration().getProperty("hibernate.connection.isolation");
        int il = 1; //default is dirty read. can be changed if required.
        try {
        	il = Integer.parseInt(isolationLevel);
        }catch(Exception e) {
        	
        }
        try {
			s.connection().setTransactionIsolation(il); // Dirty read to avoid db locks
		} catch (Exception e1) {
			LOGGER.warn("EXCEPTION: Could not set the isolation level ["+e1.getMessage()+"]");
		} 
        return il;*/
    	
    	return -1;
    }

    public static void closeSession() {
    	if(LOGGER.isDebugEnabled()) LOGGER.debug("closeSession() - closing session with  commit/rollback transaction");
        //flush the session, if any error, then rollback else commit
    	commitOrRollbackTransaction();        
    	//close the session and remove from the thread local.
        cleanup();
    }

    public static void beginTransaction() {
    	       
    	Session s = getSessionInternal();
    	if(s != null) {
			Transaction txn = s.beginTransaction();
			if(LOGGER.isDebugEnabled()) LOGGER.debug("beginTransaction() txn = "+txn);
		}else {
			if(LOGGER.isWarnEnabled()) LOGGER.warn("beginTransaction() - session is null  ");
		}
    }

    private static void commitOrRollbackTransaction() {
    	try {
    		Session s = getSessionInternal();
        	if(s == null) {
        		if(LOGGER.isDebugEnabled()) LOGGER.debug("commitOrRollbackTransaction() - session is null  ");
        		return;
        	}
        	  
        	boolean isRollback = false;
        	boolean closeSession = false;
        	
        	try {
        		s.flush();
        	}catch(Exception e) {
        		LOGGER.error("commitOrRollbackTransaction - Marking transaction for rollback [SQL Error] :: ["+e.getClass()+"] Error = "+ e.getMessage());
        		isRollback = true;
        		closeSession = true;
        	}
        	
        	Transaction tx = s.getTransaction();
    		if(isRollback && tx != null && !(tx.getStatus()==(TransactionStatus.COMMITTED)) && !(tx.getStatus()==TransactionStatus.ROLLED_BACK)) {
    			tx.rollback();
    			//cleanup();
    			return ;
    		}
    		if (!isRollback && tx != null && !(tx.getStatus()==(TransactionStatus.COMMITTED)) && !(tx.getStatus()==TransactionStatus.ROLLED_BACK)) {			 
    			tx.commit();
    			if(LOGGER.isDebugEnabled()) LOGGER.debug("commitTransaction() - successful commit ");
    			return ;
    		}
    	}catch(Exception e) {
    		if(LOGGER.isDebugEnabled()) LOGGER.debug("commitOrRollbackTransaction - ::"+e.getMessage());
    	}
    	
    }

    public static void rollbackTransaction() {
    	
    	Session s = getSessionInternal();
    	if(s != null && s.getTransaction() != null)
    	{
    		Transaction tx = s.getTransaction();
    		if(tx != null && !(tx.getStatus()==(TransactionStatus.COMMITTED)) && !(tx.getStatus()==TransactionStatus.ROLLED_BACK)) {
    			tx.rollback();	
    			if(LOGGER.isDebugEnabled()) LOGGER.debug("rollbackTransaction() - successfully rolled back ");
    			return ;
    		}
    	}else {
    		if(LOGGER.isWarnEnabled()) LOGGER.warn("rollbackTransaction() - ! session is closed ");
    	}
    	
    }
    
    public static void commitTransaction() {
    	commitOrRollbackTransaction();
    }
    
    private static void cleanup()
    {
    	try {
    		if(LOGGER.isDebugEnabled()) LOGGER.debug("cleanup()  - closing session ");
            Session s = (Session) threadSession.get();
            threadSession.set(null);
            if (s != null && s.isOpen())
            {            	                
                s.clear();
                s.close();
            }            
    	}catch(Exception e) {
    		LOGGER.warn("cleanup :: Exception :: ",e);
    	}
    }
    
    private static Session getSessionInternal()
    {
    	Session s = (Session) threadSession.get();
    	return s;    	
    }
        
    public static Session unbind() {    	
    	 Session s = (Session) threadSession.get();
    	 if(LOGGER.isInfoEnabled()) LOGGER.info("unbind() "+s);
    	 threadSession.set(null);
    	 return s;
    }
    
}