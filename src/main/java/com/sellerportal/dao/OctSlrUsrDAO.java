/* 
 * Auto Generated on Sat Mar 14 12:16:00 IST 2015
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
import com.sellerportal.model.OctSlrUsr;


/**
 * 
 *
 * Generated DAO Class for oct_slr_usr Table.
 *
 * All Queries related to this table should be here.
 * NOTE: 
 *	Do not put user defined queries in the generated DAO class. 
 *	USE hibernate-dao-oct_slr_usr-class-code.txt
 * */
public class OctSlrUsrDAO extends SuperDAO
{

	/**
	 * Find object by primary key.
	 * @param pk the pk of the object to find.
	 */
	public  OctSlrUsr findByPK( Serializable pk ) throws com.anm.hibernate.DAOException
	{
		OctSlrUsr retval = null;
		retval = (OctSlrUsr)super.findByPk( pk );
		return retval;
	}


	/**
	 * @param obj
	 * @return
	 */
	protected Criteria createCriteria(Object object) {
		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
		Criteria criteria = hibSession.createCriteria(OctSlrUsr.class);

		OctSlrUsr obj = (OctSlrUsr)object;



		//Pk getOctslrusrrfnum
		if (obj.getOctslrusrrfnum() != null) {
			criteria.add(Expression.eq("octslrusrrfnum", obj.getOctslrusrrfnum()));
		}

		//Set the many2one and one2one relation objects


		if (obj.getIsmubi() != null) {
			criteria.add(Expression.eq("ismubi", obj.getIsmubi()));
			criteria.setFetchMode("ismubi", FetchMode.DEFAULT);
		}

		if (obj.getOctSlr() != null) {
			criteria.add(Expression.eq("octSlr", obj.getOctSlr()));
			criteria.setFetchMode("octSlr", FetchMode.DEFAULT);
		}
		return criteria;
	}





	/** (non-Javadoc)
	 * @see com.anm.hibernate.SuperDAO#getPojoObj()
	 */



	protected Object getPojoObj() {  

		return new OctSlrUsr();

	}

	public OctSlrUsr findByUbirfnum(Long ubirfnum) {

		Session hibSession = null;
		List retvallist = null;
		OctSlrUsr octSlrusr=null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("from OctSlrUsr slr where slr.ismubi.ubirfnum=:ubirfnum order by slr.createdate desc");
			query.setLong("ubirfnum" ,ubirfnum);
			retvallist = query.list();
			if(!retvallist.isEmpty()){
				octSlrusr=(OctSlrUsr)retvallist.get(0);
			}
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return octSlrusr;
	}


	public List<OctSlrUsr> getUserBySlr(Long octslrrfnum){
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "from OctSlrUsr usr  where usr.octSlr.octslrrfnum =:octslrrfnum order by createdate";
			Query query = hibSession.createQuery(queryString);
			query.setLong("octslrrfnum", octslrrfnum);
			retvalList = query.list();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}

	public List getUserBySlrCode(String octslrrfnum){
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "from OctSlrUsr usr  where usr.octSlr.octslrlcode =:octslrrfnum";
			Query query = hibSession.createQuery(queryString);
			query.setString("octslrrfnum", octslrrfnum);
			retvalList = query.list();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}

	public OctSlrUsr findUbiRfnumbySlrRfNum(Long slrRfNum) {
		Session hibSession = null;
		List retvallist = null;
		OctSlrUsr octSlrusr=null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("from OctSlrUsr usr where usr.octSlr.octslrrfnum=:slrRfNum order by usr.createdate desc");
			query.setLong("slrRfNum" ,slrRfNum);
			retvallist = query.list();
			if(!retvallist.isEmpty()){
				octSlrusr=(OctSlrUsr)retvallist.get(0);
			}
		}catch( HibernateException e){
			throw new DAOException(e);
		}
		return octSlrusr;
	}




	public OctSlrUsr findByEmailID(String ubilogin) {

		Session hibSession = null;
		List retvallist = null;
		OctSlrUsr octSlrusr=null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("from OctSlrUsr slr where slr.ismubi.ubilogin=:ubilogin");
			query.setString("ubilogin" ,ubilogin);
			retvallist = query.list();
			if(!retvallist.isEmpty()){
				octSlrusr=(OctSlrUsr)retvallist.get(0);
			}
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return octSlrusr;
	}

	public String findByubirfnum(Long ubirfnum){
		Session hibSession = null;
		List retvallist = null;
		String slrInComplete=null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			/*select  slr.SLRINCOMPLETE as SLRINCOMPLETE from oct_slr slr left outer join oct_slr_usr usr on slr.octslrrfnum=usr.octslr left outer join ismubi ubi on usr.ismubi=ubi.ubirfnum  where ubi.ubirfnum='920'*/
			Query query = hibSession.createQuery("select usr.octSlr.octslrisaccepted from OctSlrUsr usr where usr.ismubi.ubirfnum=:ubirfnum");
			query.setLong("ubirfnum" ,ubirfnum);
			retvallist = query.list();
			if(!retvallist.isEmpty()){
				slrInComplete=(String) retvallist.get(0);
			}
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return slrInComplete;
	}

	public List findBySlrUbi(Long octslrrfnum){
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("from OctSlrUsr slr,Ismuat uat where slr.octSlr.octslrrfnum=:octslrrfnum and uat.ismubi.ubirfnum=slr.ismubi.ubirfnum");
			query.setLong("octslrrfnum" ,octslrrfnum);
			retvalList = query.list();
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return retvalList;
	}

	//@Suyog TPR-5261, to get seller UBIemailID Start
	public String findSlrEmailIDBySlrrfnum(Long octslrrfnum) {

		Session hibSession = null;
		List retvallist = null;
		String slrEmailId = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select usr.ismubi.ubilogin from OctSlrUsr usr where usr.octSlr.octslrrfnum=:octslrrfnum");
			query.setLong("octslrrfnum" ,octslrrfnum);
			retvallist = query.list();
			if(!retvallist.isEmpty()) {
				slrEmailId = retvallist.get(0)+"";
			}
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return slrEmailId;
	}

	//@Suyog TPR-5261, to get seller UBIemailID End	

	//@Suyog TPR-5261, to get seller UATemailID Start
	public List<String> findSlrEmailIDByUbilogin(String ubilogin) {
		Session hibSession = null;
		List<String> retvallist = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select uat.uatemail from Ismuat uat where uat.ismubi.ubilogin=:ubilogin");
			query.setString("ubilogin" ,ubilogin);
			retvallist = query.list();
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return retvallist;
	}

	//@Suyog TPR-5261, to get seller UATemailID End


	//@Deepak Deshekar :: Find seller Email By seller code Start
	public String findSlrEmailIDBySlrCode(String octslrCode) {

		Session hibSession = null;
		List retvallist = null;
		String slrEmailId = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select usr.ismubi.ubilogin from OctSlrUsr usr where usr.octSlr.octslrlcode=:octslrlcode order by createdate");
			query.setString("octslrlcode" ,octslrCode);
			query.setMaxResults(1);
			retvallist = query.list();
			if(!retvallist.isEmpty()) {
				slrEmailId = retvallist.get(0)+"";
			}
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return slrEmailId;
	}
	//@Deepak Deshekar :: Find seller Email By seller code End
	// @Nishant added to show 1st record in seller view list
	public OctSlrUsr findUbiRfnumbySlrRfNumAsc(Long slrRfNum) {
		Session hibSession = null;
		List retvallist = null;
		OctSlrUsr octSlrusr = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("from OctSlrUsr usr where usr.octSlr.octslrrfnum=:slrRfNum order by usr.createdate");
			query.setLong("slrRfNum", slrRfNum);
			retvallist = query.list();
			if (!retvallist.isEmpty())
				octSlrusr = (OctSlrUsr) retvallist.get(0);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return octSlrusr;
	}
	//@Nishant:: TPR-7598
	public String  findSlrPhnByUbilogin(String ubilogin) {
		Session hibSession = null;
		List<String> retvallist = null;
		String slrEmailId="";
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select uat.uatphone from Ismuat uat where uat.ismubi.ubilogin=:ubilogin order by createdate desc");
			query.setString("ubilogin" ,ubilogin);
			retvallist = query.list();
			if(!retvallist.isEmpty()) {
				slrEmailId = retvallist.get(0)+"";
			}
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return slrEmailId;
	}
	//@Nishant ::TPR-7598
	public String findEmailByUbirfnum(String octslrrfnum) {

		Session hibSession = null;
		List retvallist = null;
		String octSlvusr="";
		try
		{
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select ismubi.ubilogin from OctSlrUsr slr where slr.octSlr.octslrrfnum=:octslrrfnum order by createdate");
			query.setString("octslrrfnum", octslrrfnum);
			query.setMaxResults(1);
			retvallist = query.list();
			if(!retvallist.isEmpty())
				octSlvusr=(String)retvallist.get(0);
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return octSlvusr;
	}

	public Object[] findSlrInfoIDBySlrCode(String octslrCode) {

		Session hibSession = null;
		List<Object[]> retvallist = null;
		Object[] slrEmailId = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select usr.ismubi.ubilogin,usr.ismubi.ubifname from OctSlrUsr usr where usr.octSlr.octslrlcode=:octslrlcode order by createdate");
			query.setString("octslrlcode" ,octslrCode);
			query.setMaxResults(1);
			retvallist = query.list();
			if(!retvallist.isEmpty()) {
				slrEmailId = retvallist.get(0);
			}
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return slrEmailId;
	}

	public String findSlrEmailSlrCode(String octslrCode) {

		Session hibSession = null;
		List retvallist = null;
		String slrEmailId = "";
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select usr.ismubi.ubilogin from OctSlrUsr usr where usr.octSlr.octslrlcode=:octslrlcode and usr.ismubi.ubiactive='Y' order by createdate");
			query.setString("octslrlcode" ,octslrCode);
			query.setMaxResults(1);
			retvallist = query.list();
			if(!retvallist.isEmpty()) {
				slrEmailId = (String) retvallist.get(0);
			}
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return slrEmailId;
	}

	//Aniket.s
	public OctSlrUsr findBySlrCode(String octslrCode) {

		Session hibSession = null;
		List retvallist = null;
		OctSlrUsr slrEmailId = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("from OctSlrUsr usr where usr.octSlr.octslrlcode=:octslrlcode and usr.ismubi.ubiactive='Y' order by createdate");
			query.setString("octslrlcode" ,octslrCode);
			query.setMaxResults(1);
			retvallist = query.list();
			if(!retvallist.isEmpty()) {
				slrEmailId = (OctSlrUsr) retvallist.get(0);
			}
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return slrEmailId;
	}
	//Aniket.e

}
