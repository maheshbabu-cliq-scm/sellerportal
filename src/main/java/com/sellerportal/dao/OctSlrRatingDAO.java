package com.sellerportal.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import com.anm.hibernate.DAOException;
import com.anm.hibernate.SuperDAO;
import com.sellerportal.model.OctSlrRating;
import com.sellerportal.model.OctSlrScore;

/**
 * @author:Tiwari Suraj
 * SELLER_RATING
 */

public class OctSlrRatingDAO extends SuperDAO{



	@Override
	protected Criteria createCriteria(Object arg0) {
		return null;
	}

	@Override
	protected Object getPojoObj() {
		return null;
	}

	public OctSlrRating findByPK(Serializable pk) throws com.anm.hibernate.DAOException{
		OctSlrRating retval = null;
		retval = (OctSlrRating)super.findByPk( pk );
		return retval;
	}
	
	public boolean findSellerExistense(String slrCode,String resultOfDays,Long octparam){
		boolean result = false;
		Session hibSession = null;
		List retvallist = null;
		int count = 0;
		try{
			String queryString = "select count(slrRfnum) from OctSlrRating where slrCode=:slrCode and resultOfDays=:resultOfDays and octparam=:octparam";
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery(queryString);
			query.setString("slrCode", slrCode);
			query.setString("resultOfDays", resultOfDays);
			query.setLong("octparam", octparam);
			retvallist= query.list();
			if(retvallist!=null && !retvallist.isEmpty()){
				count = (int) retvallist.get(0);
				if(count>0){
					result = true;
				}
			}
		}catch(Exception e){
			throw new  DAOException(e);
		}
		return result;
	}
	
	
	public OctSlrRating findSellerRatingObjWithDays(String slrCode,String resultOfDays,Long octparam){
		OctSlrRating obj = null;
		Session hibSession = null;
		List retvallist = null;
		try{
			String queryString = "from OctSlrRating where slrCode=:slrCode and resultOfDays=:resultOfDays and octparam=:octparam";
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery(queryString);
			query.setString("slrCode", slrCode);
			query.setString("resultOfDays", resultOfDays);
			query.setLong("octparam", octparam);
			retvallist= query.list();
			if(retvallist!=null && !retvallist.isEmpty()){
				obj = (OctSlrRating) retvallist.get(0);
			}
		}catch(Exception e){
			throw new  DAOException(e);
		}
		return obj;
	}
	
	public List<Object[]> findScoresWithDays(String slrCode,String resultOfDays){
		Session hibSession = null;
		List<Object[]> retvallist = null;
		try{
			String queryString = "select score,octparam.paramcode,criteriaRate from OctSlrRating where slrCode=:slrCode and resultOfDays=:resultOfDays order by score desc";
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery(queryString);
			query.setString("slrCode", slrCode);
			query.setString("resultOfDays", resultOfDays);
			retvallist= query.list();
			
		}catch(Exception e){
			throw new  DAOException(e);
		}
		return retvallist;
	}
	
	public boolean findSlrScoreExistense(String slrCode,String resultOfDays){
		boolean result = false;
		Session hibSession = null;
		List retvallist = null;
		int count = 0;
		try{
			String queryString = "select count(slrRfnum) from OctSlrScore where slrCode=:slrCode and resultOfDays=:resultOfDays";
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery(queryString);
			query.setString("slrCode", slrCode);
			query.setString("resultOfDays", resultOfDays);
			retvallist= query.list();
			if(retvallist!=null && !retvallist.isEmpty()){
				count = (int) retvallist.get(0);
				if(count>0){
					result = true;
				}
			}
		}catch(Exception e){
			throw new  DAOException(e);
		}
		return result;
	}
	
	public OctSlrScore findSlrScoreObjWithDays(String slrCode,String resultOfDays){
		OctSlrScore obj = null;
		Session hibSession = null;
		List retvallist = null;
		try{
			String queryString = "from OctSlrScore where slrCode=:slrCode and resultOfDays=:resultOfDays";
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery(queryString);
			query.setString("slrCode", slrCode);
			query.setString("resultOfDays", resultOfDays);
			retvallist= query.list();
			if(retvallist!=null && !retvallist.isEmpty()){
				obj = (OctSlrScore) retvallist.get(0);
			}
		}catch(Exception e){
			throw new  DAOException(e);
		}
		return obj;
	}
	
	
	public String findTotalScoreByDaysAndSeller(String slrCode,String resultOfDays){
		String result = "";
		Session hibSession = null;
		List retvalList = null;
		try{
			String queryString = "select totalScore from OctSlrScore where slrCode=:slrCode and resultOfDays=:resultOfDays";
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery(queryString);
			query.setString("slrCode", slrCode);
			query.setString("resultOfDays", resultOfDays);
			retvalList = query.list();
			if(retvalList!=null && !retvalList.isEmpty()){
				result = (String) retvalList.get(0);
			}
			
		}catch(Exception e){
			throw new  DAOException(e);
		}
		return result;
		
	}
	
	public List<Object[]> findSlrRatByDaysAndParamcode(String slrCode,String resultOfDays){
		Session hibSession = null;
		List retvallist = null;
		try{
			String queryString = "select rate,octparam.paramcode,octparam.paramdesc,case when raised > 0 and prevRaised > 0 and raised > prevRaised then 'green'when raised > 0 and prevRaised > 0 and raised < prevRaised then 'red' when raised = prevRaised then '#017dc7' else '#017dc7' end from OctSlrRating rate where rate.slrCode=:slrCode and rate.resultOfDays=:resultOfDays order by octparam.paramseq";
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery(queryString);
			query.setString("slrCode", slrCode);
			query.setString("resultOfDays", resultOfDays);
			retvallist= query.list();
		}catch(Exception e){
			throw new  DAOException(e);
		}
		return retvallist;
	}
	
	public Object[] findScoreData(String slrCode,String resultOfDays){
		Session hibSession = null;
		Object[] obj = null;
		List retvallist = null;
		try{
			String queryString = "select imgUrl,salesValue,salesCount,countImprove,valueImprove from OctSlrScore where slrCode=:slrCode and resultOfDays=:resultOfDays";
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery(queryString);
			query.setString("slrCode", slrCode);
			query.setString("resultOfDays", resultOfDays);
			query.setMaxResults(1);
			retvallist= query.list();
			if(retvallist!=null && !retvallist.isEmpty()){
				obj = (Object[]) retvallist.get(0);
			}
		}catch(Exception e){
			throw new DAOException(e);
		}
		return obj;
	}
	
	public Object[] findImgUrl(String slrCode,String resultOfDays){
		Session hibSession = null;
		Object[] obj = null;
		List retvalList = null;
		try{
			String queryString = "select imgUrl,rating,sellerRatingPdfUrl,totalScore from OctSlrScore where slrCode=:slrCode order by modidate desc";
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery(queryString);
			query.setString("slrCode", slrCode);
			//query.setString("resultOfDays", resultOfDays);
			query.setMaxResults(1);
			retvalList = query.list();
			if(retvalList!=null && !retvalList.isEmpty()){
				obj = (Object[]) retvalList.get(0);
			}
			
		}catch(Exception e){
			throw new  DAOException(e);
		}
		return obj;
		
	}
	
	public OctSlrScore findSlrLatestScore(String slrCode){
		OctSlrScore obj = null;
		Session hibSession = null;
		List retvallist = null;
		try{
			String queryString = "from OctSlrScore where slrCode=:slrCode order by createdate desc";
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery(queryString);
			query.setString("slrCode", slrCode);
			retvallist= query.list();
			if(retvallist!=null && !retvallist.isEmpty()){
				obj = (OctSlrScore) retvallist.get(0);
			}
		}catch(Exception e){
			throw new  DAOException(e);
		}
		return obj;
	}
	
}