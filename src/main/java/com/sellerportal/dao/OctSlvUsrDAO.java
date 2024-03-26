/* 
 * Auto Generated on Sat Mar 14 12:16:03 IST 2015
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
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import com.anm.hibernate.DAOException;
import com.anm.hibernate.SuperDAO;
import com.sellerportal.model.Ismuat;
import com.sellerportal.model.OctSlvUsr;


/**
 * 
 *
 * Generated DAO Class for oct_slv_usr Table.
 *
 * All Queries related to this table should be here.
 * NOTE: 
 *	Do not put user defined queries in the generated DAO class. 
 *	USE hibernate-dao-oct_slv_usr-class-code.txt
 * */
public class OctSlvUsrDAO extends SuperDAO
{

	/**
	 * Find object by primary key.
	 * @param pk the pk of the object to find.
	 */
	public  OctSlvUsr findByPK( Serializable pk ) throws com.anm.hibernate.DAOException
	{
		OctSlvUsr retval = null;
		retval = (OctSlvUsr)super.findByPk( pk );
		return retval;
	}


	/**
	 * @param obj
	 * @return
	 */
	protected Criteria createCriteria(Object object) {
		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
		Criteria criteria = hibSession.createCriteria(OctSlvUsr.class);

		OctSlvUsr obj = (OctSlvUsr)object;



		//Pk getOctslvusrrfnum
		if (obj.getOctslvusrrfnum() != null) {
			criteria.add(Expression.eq("octslvusrrfnum", obj.getOctslvusrrfnum()));
		}

		//Set the many2one and one2one relation objects


		if (obj.getIsmubi() != null) {
			criteria.add(Expression.eq("ismubi", obj.getIsmubi()));
			criteria.setFetchMode("ismubi", FetchMode.DEFAULT);
		}

		if (obj.getOctSlv() != null) {
			criteria.add(Expression.eq("octSlv", obj.getOctSlv()));
			criteria.setFetchMode("octSlv", FetchMode.DEFAULT);
		}
		return criteria;
	}



	public OctSlvUsr findUbiRfNumByOctSlvRfNum(String octSlvRfNum) {
		OctSlvUsr retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From OctSlvUsr slvusr where slvusr.octSlv.octslvrfnum =:octSlvRfNum";
			Query query = hibSession.createQuery(queryString);
			query.setString("octSlvRfNum", octSlvRfNum);
			query.setMaxResults(1);
			retvalList = query.list();
			if (retvalList !=null && retvalList.size() > 0 )
				retval = (OctSlvUsr) retvalList.get(0);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}finally{		
		}
		return retval;
	}    	

	protected Object getPojoObj() {  

		return new OctSlvUsr();

	}


	public OctSlvUsr findByUbirfnum(Long ubirfnum) {

		Session hibSession = null;
		List retvallist = null;
		OctSlvUsr octSlvusr=null;
		try
		{
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("from OctSlvUsr slv where slv.ismubi.ubirfnum=:ubirfnum");
			query.setLong("ubirfnum" ,ubirfnum);
			retvallist = query.list();
			if(retvallist.size()>0)
				octSlvusr=(OctSlvUsr)retvallist.get(0);
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return octSlvusr;
	}


	public List findUbiRfNumListByOctSlvRfNum(String octSlvRfNum) {
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From OctSlvUsr slvusr where slvusr.octSlv.octslvrfnum =:octSlvRfNum";
			Query query = hibSession.createQuery(queryString);
			query.setString("octSlvRfNum", octSlvRfNum);
			retvalList = query.list();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}finally{		
		}
		return retvalList;
	}



	public List findUbiRfNumListByoctslrrfnum(String octslrrfnum) {
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From OctSlvUsr slvusr where slvusr.octSlv.octSlr.octslrrfnum =:octslrrfnum";
			Query query = hibSession.createQuery(queryString);
			query.setString("octslrrfnum", octslrrfnum);
			retvalList = query.list();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}finally{		
		}
		return retvalList;
	}

	public OctSlvUsr getSlaveByUat(Ismuat uat){
		Session hibSession = null;
		List retval = null;
		OctSlvUsr usr = null;
		try
		{
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("from OctSlvUsr usr where usr.ismubi.ubirfnum in (select uat.ismubi.ubirfnum from Ismuat uat where uat.uatrfnum=:uatrfnum)");
			query.setLong("uatrfnum" , uat.getUatrfnum());
			retval = query.list();
			if(retval != null && retval.size() > 0)
				usr = (OctSlvUsr)retval.get(0);
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return usr;
	}
	//Unicommerce ::@Raju sir
	//@shreyas start:: TPR-7149
	public Object[] getUniCommerceAuthToken(String loginId, String password){
		Session hibSession = null;
		List retval = null;
		Object obj[]=null;
		//String authToken = null;
		try
		{
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select octSlv.octslvcode,octSlv.octSlr.octslrrfnum from OctSlvUsr where ismubi.ubilogin=:loginId and ubipass=:password and ismubi.ubiactive='Y' "
					+ " and ismubi.deleted='N'");
			query.setString("loginId" , loginId);
			query.setString("password" , password);
			query.setMaxResults(1);
			retval = query.list();
			if(retval != null && retval.size() > 0)
				obj=(Object[]) retval.get(0);
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return obj;
	} 
	//@shreyas end :: TPR-7149
	//Unicommerce :@Raju sir

	public String findByUbirfnumThermal(Long ubirfnum) {

		Session hibSession = null;
		List retvallist = null;
		String octSlvusr="";
		try
		{
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select octSlv.isThermalprint from OctSlvUsr slv where slv.ismubi.ubirfnum=:ubirfnum");
			query.setLong("ubirfnum" ,ubirfnum);
			retvallist = query.list();
			if(retvallist.size()>0)
				octSlvusr=(String)retvallist.get(0);
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return octSlvusr;
	}

	//@Nishant::TPR-7598
	public String findEmailByUbirfnum(long octslvrfnum) {

		Session hibSession = null;
		List retvallist = null;
		String octSlvusr="";
		try
		{
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select ismubi.ubilogin from OctSlvUsr slv where slv.octSlv.octslvrfnum=:octslvrfnum order by createdate");
			query.setLong("octslvrfnum", octslvrfnum);
			retvallist = query.list();
			if(retvallist.size()>0)
				octSlvusr=(String)retvallist.get(0);
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return octSlvusr;
	}

	//@rohit changes for CNC for Integration
	public OctSlvUsr findUbiRfNumByOctSlvCode(String slvCode) {
		OctSlvUsr retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From OctSlvUsr slvusr where slvusr.octSlv.octslvcode =:slvCode";
			Query query = hibSession.createQuery(queryString);
			query.setString("slvCode", slvCode);
			retvalList = query.list();
			if (retvalList.size() > 0 )
				retval = (OctSlvUsr) retvalList.get(0);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}finally{		
		}
		return retval;
	}  
	//@Rohit Changes for Cnc Integration end
	public long findSlvrfnumByUbirfnum(Long ubirfnum) {

		Session hibSession = null;
		List retvallist = null;
		long octslvrfnum=0;
		//OctSlvUsr octSlvusr=null;
		try
		{
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select slv.octSlv.octslvrfnum from OctSlvUsr slv where slv.ismubi.ubirfnum=:ubirfnum");
			query.setLong("ubirfnum" ,ubirfnum);
			retvallist = query.list();
			if(retvallist.size()>0)
				octslvrfnum=(long) retvallist.get(0);
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return octslvrfnum;
	}

	//Shankar Start : TPR-12527
	public String findSlvEmailBySlvCode(String slvCode) {
		Session hibSession = null;
		List retvallist = null;
		String slvEmailId = "";
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select usr.ismubi.ubilogin from OctSlvUsr usr where usr.octSlv.octslvcode=:octslvcode and usr.ismubi.ubiactive='Y' order by createdate");
			query.setString("octslvcode" ,slvCode);
			query.setMaxResults(1);
			retvallist = query.list();
			if(!retvallist.isEmpty()) {
				slvEmailId = (String) retvallist.get(0);
			}
		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return slvEmailId;
	}
	
	public List<String> findAllSlvEmailBySlvCode(String slvCode) {
		Session hibSession = null;
		List retvallist = null;
		List<String> slvEmailId = new ArrayList<>();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select usr.ismubi.ubilogin from OctSlvUsr usr where usr.octSlv.octslvcode=:octslvcode and usr.ismubi.ubiactive='Y' order by createdate");
			query.setString("octslvcode" ,slvCode);
			retvallist = query.list();
			if(!retvallist.isEmpty()) {
				slvEmailId = retvallist;
			}
		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return slvEmailId;
	}
	//Shankar End : TPR-12527
}