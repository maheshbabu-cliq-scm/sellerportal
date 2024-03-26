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
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;

import com.anm.hibernate.DAOException;
import com.anm.hibernate.HibernateConnection;
import com.anm.hibernate.SuperDAO;
import com.sellerportal.model.EwayBillDetails;
import com.sellerportal.model.Ismuat;
import com.sellerportal.model.OctSlr;
import com.sellerportal.model.OctSlv;
import com.sellerportal.model.SlaveReverseLocation;
import com.sellerportal.model.SlaveStateMapping;
import com.sellerportal.model.ZoneMaster;

/**
 * 
 * 
 * Generated DAO Class for oct_slv Table.
 * 
 * All Queries related to this table should be here. NOTE: Do not put user
 * defined queries in the generated DAO class. USE
 * hibernate-dao-oct_slv-class-code.txt
 * */
public class OctSlvDAO extends SuperDAO {

	/**
	 * Find object by primary key.
	 * 
	 * @param pk the pk of the object to find.
	 */
	public OctSlv findByPK(Serializable pk) throws com.anm.hibernate.DAOException {
		OctSlv retval = null;
		retval = (OctSlv) super.findByPk(pk);
		return retval;
	}

	/**
	 * @param obj
	 * @return
	 */
	protected Criteria createCriteria(Object object) {
		Session hibSession = com.anm.hibernate.HibernateConnection.getSession();
		Criteria criteria = hibSession.createCriteria(OctSlv.class);

		OctSlv obj = (OctSlv) object;

		// Pk getOctslvrfnum
		if (obj.getOctslvrfnum() != null) {
			criteria.add(Expression.eq("octslvrfnum", obj.getOctslvrfnum()));
		}

		// Set the many2one and one2one relation objects

		if (obj.getOctSlr() != null) {
			criteria.add(Expression.eq("octSlr", obj.getOctSlr()));
			criteria.setFetchMode("octSlr", FetchMode.DEFAULT);
		}

		if (obj.getOctslvRetAddress() != null) {
			criteria.add(Expression.eq("octslvRetAddress",obj.getOctslvRetAddress()));
			criteria.setFetchMode("octslvRetAddress", FetchMode.DEFAULT);
		}
		return criteria;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.anm.hibernate.SuperDAO#getPojoObj()
	 */

	public OctSlr findByslaveNameSlaveCode(String slaveNameSlaveCode){
		OctSlr retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From OctSlr slr where slr.octslrname=:slaveNameSlaveCode or slr.octslrlcode  =:slaveNameSlaveCode";
			Query query = hibSession.createQuery(queryString);
			query.setString("slaveNameSlaveCode", slaveNameSlaveCode);
			retvalList = query.list();
			if (retvalList!=null && !retvalList.isEmpty())
				retval = (OctSlr) retvalList.get(0);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retval;
	}

	/* slave list view */
	public int findSlvCount(String sellerName, String sellerCode,
			String slaveName, String emailId, String phoneNumber,
			Date startDate, Date endDate, String isActive){

		Session hibSession = null;
		List retval;
		int count = 0;
		String strQuery = "from OctSlv slv where slv.octslvisactive in('Y','N') "; // @ritesh change for slave inactive for tax
		try {
			hibSession = HibernateConnection.getSession();

			if (sellerCode != null) {
				strQuery += "and (slv.octSlr.octslrlcode= :sellerCode) ";
			}

			if (slaveName != null) {
				strQuery += "and slv.octslvname= :slaveName";
			}

			if (startDate != null && endDate != null) {
				strQuery += "and slv.createdate >= :startDate and slv.createdate >= :endDate";

			}
			strQuery += " order by slv.octslvrfnum desc";

			Query query = hibSession.createQuery(strQuery);
			if (sellerCode != null) {
				query.setString("sellerCode", sellerCode);
			}
			if (slaveName != null) {
				query.setString("slaveName", slaveName);
			}
			if (startDate != null && endDate != null) {
				query.setTimestamp("startDate", startDate);
				query.setTimestamp("endDate", endDate);
			}
			retval = query.list();
			if (retval != null) {
				count = retval.size();
			}

		} catch (Exception e) {
			throw new DAOException(e);
		}
		return count;

	}

	/* find data */
	public List findSlaveListByCondition(String sellerName, String sellerCode,
			String slaveName, String emailId, String phoneNumber,
			Date startDate, Date endDate, String isActive, int from, int max){

		Session hibSession = null;
		List retval = null;

		String strQuery = "from OctSlv slv where slv.octslvisactive in('Y','N') "; // @ritesh change for slave inactive for tax
		try {
			hibSession = HibernateConnection.getSession();

			if (sellerCode != null) {
				strQuery += "and (slv.octSlr.octslrlcode= :sellerCode) ";
			}

			if (slaveName != null) {
				strQuery += "and slv.octslvname= :slaveName";
			}

			if (startDate != null && endDate != null) {
				strQuery += "and slv.createdate >= :startDate and slv.createdate >= :endDate";// or slv.createdate =:startDate or slv.createdate=:endDate

			}
			strQuery += " order by slv.octslvrfnum desc";

			Query query = hibSession.createQuery(strQuery);
			if (sellerCode != null) {
				query.setString("sellerCode", sellerCode);
			}
			if (slaveName != null) {
				query.setString("slaveName", slaveName);
			}
			if (startDate != null && endDate != null) {
				query.setTimestamp("startDate", startDate);
				query.setTimestamp("endDate", endDate);
			}
			query.setFirstResult(from);
			query.setMaxResults(max);
			retval = query.list();

		} catch (Exception e) {
			throw new DAOException(e);
		}
		return retval;

	}

	protected Object getPojoObj() {

		return new OctSlv();

	}

	public static List<OctSlv> findBySeller(Long sellerRfNum) {
		Session hibSession = null;
		List<OctSlv> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From OctSlv slv where slv.octSlr.octslrrfnum =:sellerRfNum and deleted = 'N' and octslvisactive = 'Y' and octSlvIsListing = 'Y'";
			Query query = hibSession.createQuery(queryString);
			query.setLong("sellerRfNum", sellerRfNum);
			retvalList = query.list();

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;

	}

	public OctSlv findslaveCodeExistanceOrslvisactiveOrSlvIsListing(String slaveCode,String octslvisactive,String octSlvIsListing) {
		OctSlv retval = null;
		Session hibSession = null;
		List retvalList = null;
		String queryString ="From OctSlv octslv where octslv.octslvcode =:slaveCode";
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			if("Y".equalsIgnoreCase(octslvisactive) && "Y".equalsIgnoreCase(octSlvIsListing)){
				queryString += " and octslvisactive = 'Y' and octSlvIsListing ='Y' ";
			}else if("Y".equalsIgnoreCase(octslvisactive)){
				queryString += " and octslv.octslvisactive='Y'";
			}
			Query query = hibSession.createQuery(queryString);
			query.setString("slaveCode", slaveCode);
			retvalList = query.list();
			if (retvalList!=null && !retvalList.isEmpty())
				retval = (OctSlv) retvalList.get(0);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retval;
	}

	/* return slavelist */
	public List getTopSlaveBySellerName(String octslrcode) {
		Session hibSession = null;
		List retvallist = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuilder buffer = new StringBuilder();
			buffer.append("from OctSlv slv where  slv.octSlr.octslrlcode=:octslrcode"
					+ " and slv.deleted = 'N'");
			Query query = hibSession.createQuery(buffer.toString());
			query.setString("octslrcode", octslrcode);
			retvallist = query.list();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvallist;
	}

	public OctSlv findslaveByCodeAndSeller(String slaveCode, Long sellerID,boolean getIsActive) {
		OctSlv retval = null;
		Session hibSession = null;
		String queryString = "From OctSlv octslv where octslv.octslvcode =:slaveCode and octslv.octSlr.octslrrfnum=:sellerID";
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			if(getIsActive){
				queryString += " and octslv.octslvisactive='Y'";
			}
			Query query = hibSession.createQuery(queryString);
			query.setString("slaveCode", slaveCode);
			query.setLong("sellerID", sellerID);
			retvalList = query.list();
			if (!retvalList.isEmpty())
				retval = (OctSlv) retvalList.get(0);
		} catch (HibernateException e) {
			throw new DAOException(e);
		} finally {
		}

		return retval;
	}

	public List findBySellerCode(String sellerCode) {
		OctSlv retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select octslvrfnum,octslvname From OctSlv octslv where octslv.octSlr.octslrlcode =:sellerCode ";
			Query query = hibSession.createQuery(queryString);
			query.setString("sellerCode", sellerCode);
			retvalList = query.list();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}

	/* Return Slave Dashboards status */
	@SuppressWarnings("unchecked")
	public List<OctSlv> getSlaveList(Long slrrfnum) {
		Session hibSession = null;
		List<OctSlv> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "from OctSlv slv where slv.deleted='N'";

			if (slrrfnum != null && slrrfnum != 0) {
				queryString += " and slv.octSlr.octslrrfnum='" + slrrfnum + "'";
			}

			Query query = hibSession.createQuery(queryString);
			retvalList = query.list();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}

	/* Slave Report Html Formet */
	public List findSlaveReportListByCondition(String sellercode,
			Date startDate, Date endDate, String listeslave, Long slrrfnum,
			int from, int max){
		Session hibSession = null;
		List retval = null;
		String strQuery = "from OctSlv slv where slv.deleted='N' ";
		try {
			hibSession = HibernateConnection.getSession();

			if (!"".equals(sellercode) && sellercode != null) {
				strQuery += " and slv.octSlr.octslrlcode='" + sellercode + "'";
			}
			if (startDate != null && endDate != null) {
				strQuery += " and slv.createdate Between :startDate and :endDate";
			}
			if (slrrfnum != null && slrrfnum != 0) {
				strQuery += " and slv.octSlr.octslrrfnum='" + slrrfnum + "'";
			}

			if (!"".equals(listeslave) && listeslave != null && "Y".equals(listeslave)) {
				strQuery += " and (slv.octSlvIsListing='Y') ";
			}
			if (!"".equals(listeslave) && listeslave != null && "N".equals(listeslave)) {
				strQuery += " and slv.octSlvIsListing='N'";
			}
			strQuery += " order by slv.octslvrfnum desc";

			Query query = hibSession.createQuery(strQuery);
			if (startDate != null && endDate != null) {
				query.setTimestamp("startDate", startDate);
				query.setTimestamp("endDate", endDate);
			}
			query.setFirstResult(from);
			query.setMaxResults(max);
			retval = query.list();

		} catch (Exception e) {
			throw new DAOException(e);
		}
		return retval;

	}

	/* Slave Report Count */
	public List<Object> findSlaveReportCountByCondition(String sellercode,
			Date startDate, Date endDate, String listeslave, Long slrrfnum){

		Session hibSession = null;
		List<Object> retval = null;
		String strQuery = "select count(*) from OctSlv slv where slv.deleted='N' ";
		try {
			hibSession = HibernateConnection.getSession();

			if (!"".equals(sellercode) && sellercode != null) {
				strQuery += " and slv.octSlr.octslrlcode='" + sellercode + "'";
			}
			if (startDate != null && endDate != null) {
				strQuery += " and slv.createdate Between :startDate and :endDate";
			}
			if (slrrfnum != null && slrrfnum != 0) {
				strQuery += " and slv.octSlr.octslrrfnum='" + slrrfnum + "'";
			}
			if (!"".equals(listeslave) && listeslave != null
					&& "Y".equals(listeslave)) {
				strQuery += " and (slv.octSlvIsListing='Y') ";
			}
			if (!"".equals(listeslave) && listeslave != null
					&& "N".equals(listeslave)) {
				strQuery += " and slv.octSlvIsListing='N'";
			}
			strQuery += " order by slv.octslvrfnum desc";

			Query query = hibSession.createQuery(strQuery);
			if (startDate != null && endDate != null) {
				query.setTimestamp("startDate", startDate);
				query.setTimestamp("endDate", endDate);
			}
			retval = query.list();
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return retval;

	}

	/* download Slave Report */
	public List downSlaveReportByCondition(String sellercode, Date startDate,
			Date endDate, String listeslave, Long slrrfnum){
		Session hibSession = null;
		List retval = null;
		String strQuery = "from OctSlv slv where slv.deleted='N' ";
		try {
			hibSession = HibernateConnection.getSession();

			if (!"".equals(sellercode) && sellercode != null) {
				strQuery += " and slv.octSlr.octslrlcode='" + sellercode + "'";
			}
			if (startDate != null && endDate != null) {
				strQuery += " and slv.createdate Between :startDate and :endDate";
			}
			if (slrrfnum != null && slrrfnum != 0) {
				strQuery += " and slv.octSlr.octslrrfnum='" + slrrfnum + "'";
			}

			if (!"".equals(listeslave) && listeslave != null
					&& "Y".equals(listeslave)) {
				strQuery += " and slv.octSlvIsListing='Y'";
			}
			if (!"".equals(listeslave) && listeslave != null
					&& "N".equals(listeslave)) {
				strQuery += " and slv.octSlvIsListing='N'";
			}
			strQuery += " order by slv.octslvrfnum desc";

			Query query = hibSession.createQuery(strQuery);
			if (startDate != null && endDate != null) {
				query.setTimestamp("startDate", startDate);
				query.setTimestamp("endDate", endDate);
			}
			retval = query.list();

		} catch (Exception e) {
			throw new DAOException(e);
		}
		return retval;

	}

	public List getReportCountDetail() {

		Session hibSession = null;
		List retvallist = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();

			String strQuery = "select 'TotalSeller'  About ,count(*)  Count from oct_slr slr where slr.DELETED='N' union select 'ListedSeller'  About ,count(*)  Count from oct_slr slr1 where  slr1.OCTSLRISLISTING=4 and slr1.DELETED='N' ";
			strQuery += "union select 'DeListedSeller'  About ,count(*)  Count from oct_slr slr2 where  slr2.OCTSLRISLISTING in (5,6) and slr2.DELETED='N' union ";
			strQuery += "select 'TotalSlave'  About ,count(*)  Count from oct_slv slv where slv.DELETED='N' union select 'ListedSlave'  About ,count(*)  Count from oct_slv slv1 where  slv1.OCTSLVISLISTING='Y' and slv1.DELETED='N' ";
			strQuery += "union select 'DeListedSlave'  About ,count(*)  Count from oct_slv slv2 where  slv2.OCTSLVISLISTING='N'and slv2.DELETED='N' union select 'TotalProduct'  About ,count(*)  Count from oct_slr_product prod where prod.DELETED='N' ";
			strQuery += "union select 'ListedProduct'  About ,count(*)  Count from oct_slr_product prod1 where  prod1.PRODLISTINGSTATUS=136 and prod1.DELETED='N' union select 'DeListedProduct'  About ,count(*)  Count from oct_slr_product prod2 where  prod2.PRODLISTINGSTATUS=137 and prod2.DELETED='N'";
			strQuery += "union select 'SAVEASDRAFT'  About ,count(*)  Count from oct_slr_product_list where splparamstatus=115 union select 'SENDFORAPPROVAL'  About ,count(*)  Count from oct_slr_product_list where splparamstatus=116 union ";
			strQuery += "select 'REJECTED'  About ,count(*)  Count from oct_slr_product_list where splparamstatus=117 union select 'NONLISTLISTED'  About ,count(*)  Count from oct_slr_product_list where splparamstatus=118 ";
			strQuery += "union select 'PRODUCTSEARCHCOUNT'  About ,count(*)  Count from OCT_PRODUCT_SEARCH_LOG";

			SQLQuery query = hibSession.createSQLQuery(strQuery);
			query.addScalar("About", StandardBasicTypes.STRING);
			query.addScalar("Count", StandardBasicTypes.INTEGER);
			retvallist = query.list();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvallist;
	}

	public List getReportCountDetailSellerWise(Long sellerRefNo) {
		Session hibSession = null;
		List retvallist = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();

			String strQuery = "select 'TotalSeller'  About ,count(*)  Count from oct_slr slr where slr.DELETED='N' and slr.octslrrfnum=:sellerRefNo union select 'ListedSeller'  About ,count(*)  Count from oct_slr slr1 where  slr1.OCTSLRISLISTING=4 and slr1.DELETED='N' and slr1.octslrrfnum=:sellerRefNo ";
			strQuery += "union select 'DeListedSeller'  About ,count(*)  Count from oct_slr slr2 where  slr2.OCTSLRISLISTING in (5,6) and slr2.DELETED='N' and slr2.octslrrfnum=:sellerRefNo union ";
			strQuery += "select 'TotalSlave'  About ,count(*)  Count from oct_slv slv where slv.DELETED='N' and slv.OCTSLVSLR=:sellerRefNo union select 'ListedSlave'  About ,count(*)  Count from oct_slv slv1 where  (slv1.OCTSLVISLISTING='Y' OR slv1.OCTSLVISLISTING is null) and slv1.DELETED='N' and slv1.OCTSLVSLR=:sellerRefNo ";
			strQuery += "union select 'DeListedSlave'  About ,count(*)  Count from oct_slv slv2 where  slv2.OCTSLVISLISTING='N'and slv2.DELETED='N' and slv2.OCTSLVSLR=:sellerRefNo union select 'TotalProduct'  About ,count(*)  Count from oct_slr_product prod where prod.DELETED='N' and prod.SPSLRRFNUM=:sellerRefNo ";
			strQuery += "union select 'ListedProduct'  About ,count(*)  Count from oct_slr_product prod1 where  prod1.PRODLISTINGSTATUS=136 and prod1.DELETED='N' and prod1.SPSLRRFNUM=:sellerRefNo union select 'DeListedProduct'  About ,count(*)  Count from oct_slr_product prod2 where  prod2.PRODLISTINGSTATUS=137 and prod2.DELETED='N' and prod2.SPSLRRFNUM=:sellerRefNo ";
			strQuery += "union select 'SAVEASDRAFT'  About ,count(*)  Count from oct_slr_product_list list where list.splparamstatus=115 and list.SPLSLRRFNUM=:sellerRefNo union select 'SENDFORAPPROVAL'  About ,count(*)  Count from oct_slr_product_list list1 where list1.splparamstatus=116 and list1.SPLSLRRFNUM=:sellerRefNo union ";
			strQuery += "select 'REJECTED'  About ,count(*)  Count from oct_slr_product_list list2 where list2.splparamstatus=117 and list2.SPLSLRRFNUM=:sellerRefNo union select 'NONLISTLISTED'  About ,count(*)  Count from oct_slr_product_list list3 where list3.splparamstatus=118 and list3.SPLSLRRFNUM=:sellerRefNo ";

			SQLQuery query = hibSession.createSQLQuery(strQuery);
			query.addScalar("About", StandardBasicTypes.STRING);
			query.addScalar("Count", StandardBasicTypes.LONG);
			query.setLong("sellerRefNo", sellerRefNo);
			retvallist = query.list();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvallist;
	}

	public List findBySellerCodeOrName(String sellerCode) {
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select octslvrfnum,octslvname From OctSlv octslv where octslv.octSlr.octslrlcode =:sellerCode or octslv.octSlr.octslrlname =:sellerCode";
			Query query = hibSession.createQuery(queryString);
			query.setString("sellerCode", sellerCode);
			retvalList = query.list();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}

	public OctSlv findSlv(Long slvRefNo) {
		OctSlv retval = null;
		Session hibSession = null;
		List<OctSlv> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From OctSlv slv where slv.octslvrfnum=:slvRefNo";
			Query query = hibSession.createQuery(queryString);
			query.setLong("slvRefNo", slvRefNo);
			retvalList = query.list();
			if (!retvalList.isEmpty()) {
				retval = retvalList.get(0);
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retval;
	}

	public List<OctSlv> getSlave(Long slaveId) {
		Session hibSession = null;
		List<OctSlv> result = null;
		try {
			String queryString = "from OctSlv slv where slv.deleted='N' and slv.octSlr.octslrrfnum=:slaveId order by LOWER(octslvname)";
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery(queryString);
			query.setLong("slaveId", slaveId);
			result = query.list();

		} catch (Exception e) {
			throw new DAOException(e);
		}
		return result;
	}

	public List<String> findSellerSlaveCode(Long octslrrfnum) {
		Session hibSession = null;
		List<String> result = null;
		try {
			String queryString = "Select octslvcode From OctSlv slv where slv.octSlr.octslrrfnum=:sellerCode and slv.deleted='N' and slv.octslvisactive='Y'";

			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery(queryString);
			query.setLong("sellerCode", octslrrfnum);
			result = query.list();

		} catch (Exception e) {
			throw new DAOException(e);
		}
		return result;
	}

	// @Raju start R2 Merged
	public OctSlv findSlaveByCode(String slaveCode) {
		OctSlv retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From OctSlv octslv where octslv.octslvcode =:slaveCode ";
			Query query = hibSession.createQuery(queryString);
			query.setString("slaveCode", slaveCode);
			retvalList = query.list();

			if (retvalList!=null && !retvalList.isEmpty())
				retval = (OctSlv) retvalList.get(0);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retval;
	}

	// @Raju end

	// for click and collect enablement by Jitendra //@Raju R2 Merged
	public void updateSlaveIsCncById(List<Long> slaveList){
		Session hibSession = null;

		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession
					.createQuery("update OctSlv slv set slv.octslvCollectEnable='N' where slv.octslvrfnum in (:slaveList)");
			query.setParameterList("slaveList", slaveList);
			query.executeUpdate();
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
	}

	// for click and collect enablement by Jitendra @Raju R2 Merged
	public List<Long> findSlvBySlrId(Long octslrrfnum) {
		Session hibSession = null;
		List<Long> result = null;
		try {
			String queryString = "Select octslvrfnum From OctSlv slv where slv.octSlr.octslrrfnum=:octslrrfnum and slv.deleted='N' and slv.octslvCollectEnable='Y'";

			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery(queryString);
			query.setLong("octslrrfnum", octslrrfnum);
			result = query.list();

		} catch (Exception e) {
			throw new DAOException(e);
		}
		return result;
	}

	// Added Avinash for parent feeder R2
	public OctSlv findParentBySlavecode(String slaveCode, String sellerid) {
		OctSlv retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			sellerid = sellerid != null ? sellerid : "0";
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From OctSlv octslv where octslv.octslvcode =:slaveCode and octslv.octslvCollectEnable='Y' and  octslv.octslvisactive='Y' and octslv.octSlr.octslrrfnum=:sellerid";
			Query query = hibSession.createQuery(queryString);
			query.setString("slaveCode", slaveCode);
			query.setLong("sellerid", new Long(sellerid));
			retvalList = query.list();
			if (!retvalList.isEmpty())
				retval = (OctSlv) retvalList.get(0);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retval;
	}


	public List<Object[]> findRfnCodeBySellerCode(String sellerCode) {
		Session hibSession = null;
		List<Object[]> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select octslvrfnum,octslvcode From OctSlv octslv where octslv.octSlr.octslrlcode =:sellerCode and octslv.octslvisactive='Y'";
			Query query = hibSession.createQuery(queryString);
			query.setString("sellerCode", sellerCode);
			retvalList = query.list();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}

	public String[] findSellerDeatilBySlaveRef(String slaveRef) {
		Session hibSession = null;

		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuilder buffer = new StringBuilder();
			buffer.append("Select slv.octSlr.octslrrfnum,slv.octSlr.octslrlcode,slv.octSlr.octslrisinvoice From OctSlv slv where slv.octslvrfnum=:slaveRef");
			Query query = hibSession.createQuery(buffer.toString());
			query.setLong("slaveRef", new Long(slaveRef));
			query.setMaxResults(1);
			List list = query.list();
			String[] results = new String[3];
			Object[] row = (Object[]) list.get(0);
			results[0] = row[0] + "";
			results[1] = row[1] + "";
			results[2] = row[2] + "";
			return results;
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
	}

	public static List findBySellerCodeNameRfnum(Long sellerRfNum) {
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select slv.octslvrfnum,slv.octslvcode From OctSlv slv where slv.octSlr.octslrrfnum =:sellerRfNum and deleted = 'N' and octslvisactive = 'Y' and octSlvIsListing = 'Y'";
			Query query = hibSession.createQuery(queryString);
			query.setLong("sellerRfNum", sellerRfNum);
			retvalList = query.list();

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;

	}

	public List findByslaverfnum(Long slaverfnum) {
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select octslvcode From OctSlv octslv where octslv.octslvrfnum =:slaverfnum ";
			Query query = hibSession.createQuery(queryString);
			query.setLong("slaverfnum", slaverfnum);
			retvalList = query.list();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}

	// @R2.3 if slr IsReturn to store N then all slv IsReturntostore set N if usertype MP start
	public List<Long> findByslrRfnumisReturntostoreY(Long octslrrfnum) {
		Session hibSession = null;
		List<Long> retvalList = new ArrayList<Long>();

		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "Select octslvrfnum From OctSlv slv where slv.octSlr.octslrrfnum=:octslrrfnum and slv.deleted='N' and slv.octSlvIsReturnToStore='Y'";
			Query query = hibSession.createQuery(queryString);
			query.setLong("octslrrfnum", octslrrfnum);
			retvalList = query.list();
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return retvalList;
	}

	public void updateSlaveIsRTSById(List<Long> slaveList){
		Session hibSession = null;

		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("update OctSlv slv set slv.octSlvIsReturnToStore='N' where slv.octslvrfnum in (:slaveList)");
			query.setParameterList("slaveList", slaveList);
			query.executeUpdate();
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
	}

	// @R2.3 if slr IsReturn to store N then all slv IsReturntostore set N if
	// usertype MP start

	public List<OctSlv> getSlaveByCodeList(List<String> slrCode) {
		Session hibSession = null;
		List<OctSlv> result = null;
		try {
			String queryString = "from OctSlv slv where slv.deleted='N' and slv.octslvcode in (:slrCode)";
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery(queryString);
			query.setParameterList("slrCode", slrCode);
			result = query.list();

		} catch (Exception e) {
			throw new DAOException(e);
		}
		return result;
	}

	public List<String> getSlaveCodeByLpStatus() {
		Session hibSession = null;
		List<String> result = null;
		try {
			String queryString = "select slv.octslvcode from OctSlv slv where slv.deleted='N' and slv.isLpStoreActive is null";
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery(queryString);
			result = query.list();

		} catch (Exception e) {
			throw new DAOException(e);
		}
		return result;
	}

	// @Raju OPTIMIZE
	public Long getOctSlrRfnum(Long octslvrfnum) {
		Session hibSession = null;
		List list = null;
		Long octslrrfnum = null;
		try {
			String queryString = "select slv.octSlr.octslrrfnum from OctSlv slv where slv.deleted='N' and slv.octslvrfnum=:octslvrfnum";
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery(queryString);
			query.setLong("octslvrfnum", octslvrfnum);
			list = query.list();
			if (list != null && !list.isEmpty()) {
				octslrrfnum = new Long(list.get(0) + "");
			}
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return octslrrfnum;
	}

	// @Deepak Deshekar :: Unicomeerece Start
	public Long[] findSlvSlrRfnumByUniCommerceId(String octslvcode) {
		Session hibSession = null;
		Long[] results =null;
		Object[] row = null;
		List retvallist = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuilder buffer = new StringBuilder();
			buffer.append("select octSlv.octslvrfnum,octSlv.octSlr.octslrrfnum,ismubi.ubirfnum From OctSlvUsr  where octSlv.octslvcode=:octslvcode and octSlv.deleted = 'N' and octSlv.octslvisactive = 'Y' and octSlv.octSlvIsListing = 'Y'");
			Query query = hibSession.createQuery(buffer.toString());
			query.setString("octslvcode", octslvcode);
			retvallist = query.list();
			if (retvallist != null && !retvallist.isEmpty()) {
				row = (Object[]) retvallist.get(0);
				results= new Long[3];
				results[0] = (Long) row[0];
				results[1] = (Long) row[1];
				results[2] = (Long) row[2];
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return results;
	}

	// @Deepak Deshekar :: Unicomeerece End

	// @Deepak Deshekar :: Unicomeerece Start
	public Long findSlrRfnumByUniCommerceId(String octslvcode) {
		Session hibSession = null;
		Long results = null;
		List retvallist = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuilder buffer = new StringBuilder();
			buffer.append("select slv.octSlr.octslrrfnum From OctSlv slv where slv.octslvcode=:octslvcode and deleted = 'N' and octslvisactive = 'Y' and octSlvIsListing = 'Y'");
			Query query = hibSession.createQuery(buffer.toString());
			query.setString("octslvcode", octslvcode);
			retvallist = query.list();
			query.setMaxResults(1);
			if (!retvallist.isEmpty()) {
				results = (Long) retvallist.get(0);
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return results;
	}

	// @Hemant, slave list/delist start
	public ScrollableResults getSlvDetailsBySellercode(String sellercode) {
		Session hibSession = null;
		ScrollableResults rs = null;
		StringBuilder buffer = new StringBuilder();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			buffer.append("select octSlr.octslrlcode,octslvcode,octSlvIsListing,octslvCollectEnable,octSlvIsReturnToStore from OctSlv where octSlr.octslrlcode=:sellercode");
			Query query = hibSession.createQuery(buffer.toString());
			if (sellercode != null) {
				query.setString("sellercode", sellercode);
			}
			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;

	}

	public void updateSlaveFlags(Long slvrfnum, String cnc, String listDelist,String rts){
		Session hibSession = null;

		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("update OctSlv slv set slv.octslvCollectEnable=:cnc,slv.octSlvIsListing=:listDelist,slv.octSlvIsReturnToStore=:rts where slv.octslvrfnum=:slvrfnum");
			query.setLong("slvrfnum", slvrfnum);
			query.setString("cnc", cnc);
			query.setString("listDelist", listDelist);
			query.setString("rts", rts);
			query.executeUpdate();
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
	}

	// @Hemant, slave list/delist end

	// @Deepak Deshekar :: Thermalinvoice Start
	public String findThermalFlag(Long octslvrfnum) {
		Session hibSession = null;
		String results = null;
		List retvallist = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuilder buffer = new StringBuilder();
			buffer.append("select slv.isThermalprint From OctSlv slv where slv.octslvrfnum=:octslvrfnum ");
			Query query = hibSession.createQuery(buffer.toString());
			query.setLong("octslvrfnum", octslvrfnum);
			retvallist = query.list();
			query.setMaxResults(1);
			if (!retvallist.isEmpty()) {
				results = (String) retvallist.get(0);
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return results;
	}

	// @Deepak Deshekar :: Thermalinvoice Start

	// @Shankar start
	public String findslrcodeBySlvcode(String slaveCode) {
		String results = null;
		Session hibSession = null;
		List retvallist = null;

		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select octslv.octSlr.octslrlcode From OctSlv octslv where octslv.octslvcode =:slaveCode ";
			Query query = hibSession.createQuery(queryString);
			query.setString("slaveCode", slaveCode);
			retvallist = query.list();
			query.setMaxResults(1);
			if (!retvallist.isEmpty()) {
				results = (String) retvallist.get(0);
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return results;
	}

	// @Shankar end
	// Suraj TPR-7357 Discreet invoice Start
	public void slvupdate2(Long octslrrfnum, String flag){
		Session hibSession = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("update OctSlv slv set isThermalprint=:flag where slv.octSlr.octslrrfnum=:octslrrfnum and isThermalprint!='Y'");
			query.setParameter("flag", flag);
			query.setParameter("octslrrfnum", octslrrfnum);
			query.executeUpdate();
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
	}


	public List<Object[]> findActiveAndListedRfnCodeBySellerCode(String sellerCode) {
		Session hibSession = null;
		List<Object[]> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select octslvrfnum,octslvcode From OctSlv octslv where octslv.octSlr.octslrlcode =:sellerCode and octslv.octslvisactive='Y' and octslv.octSlvIsListing = 'Y' ";
			Query query = hibSession.createQuery(queryString);
			query.setString("sellerCode", sellerCode);
			retvalList = query.list();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}

	// @Rohit Start
	public List<Object[]> getSlaveApproval() {
		Session hibSession = null;
		List<Object[]> retvalList = null;

		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select slv.octslvrfnum,slv.octslvlname,slv.octslvcode from OctSlv slv where slv.octslvisactive='Y'";
			Query query = hibSession.createQuery(queryString);
			retvalList = query.list();

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}
	// @Rohit End

	public int findListSlv (Long slrrfnum) {
		Session hibSession = null;
		List<Integer> retvalList = null;
		int totalSlv = 0;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select count(*) From OctSlv octslv where octslv.octSlr.octslrrfnum =:slrrfnum and octslv.octslvisactive='Y' and octslv.octSlvIsListing = 'Y' ";
			Query query = hibSession.createQuery(queryString);
			query.setLong("slrrfnum", slrrfnum);
			retvalList = query.list();
			if (!retvalList.isEmpty())
				totalSlv = retvalList.get(0);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}finally{		
		}
		return totalSlv;
	}

	//@Rohit Start of TPR-8280
	public ScrollableResults getCatDetailsBySlrCode(String slrCode,String level) {
		Session hibSession = null;
		ScrollableResults rs = null;
		StringBuilder buffer = new StringBuilder();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			buffer.append("select ismcmt.cmtname,ismcmt.cmtcode from SlrCategoryAssociation where octSlr.octslrlcode=:slrCode and ismcmt.cmtlevel=:level order by ismcmt.cmtrfnum");
			Query query = hibSession.createQuery(buffer.toString());
			query.setString("slrCode", slrCode);
			query.setString("level", level);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}

	public SlaveReverseLocation isSlaveAndCatExist(String catCode,String slvCode){
		Session hibSession = null;
		List<SlaveReverseLocation> lstRslt;
		SlaveReverseLocation rslt = null;
		try{
			String queryString="from SlaveReverseLocation where catCode=:catCode and slvCode=:slvCode";
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery(queryString);
			query.setString("catCode", catCode);
			query.setString("slvCode", slvCode);
			query.setMaxResults(1);
			lstRslt = query.list();
			if(lstRslt !=null && !lstRslt.isEmpty()){
				rslt = lstRslt.get(0);
			}			
		}catch(Exception e){
			throw new  DAOException(e);
		}
		return rslt;
	}

	public SlaveReverseLocation doesCatExistForSlr(String catCode,String slrCode){
		Session hibSession = null;
		List<SlaveReverseLocation> lstRslt;
		SlaveReverseLocation rslt = null;
		try{
			String queryString="from SlaveReverseLocation where catCode=:catCode and slrCode=:slrCode";
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery(queryString);
			query.setString("catCode", catCode);
			query.setString("slrCode", slrCode);
			query.setMaxResults(1);
			lstRslt = query.list();
			if(lstRslt !=null && !lstRslt.isEmpty()){
				rslt = lstRslt.get(0);
			}			
		}catch(Exception e){
			throw new  DAOException(e);
		}
		return rslt;
	}
	//@Rohit Start of TPR-8280
	//@Nishant TPR-6575
	public boolean isAllowErPanel(String octslvcode){
		Session hibSession = null;
		String isAllowErPanel = "";
		List<String> result;
		boolean erPanelFlag = false;
		try{
			String queryString="select isAllowErPanel from OctSlv where octslvcode=:octslvcode";
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery(queryString);
			query.setString("octslvcode", octslvcode);
			query.setMaxResults(1);
			result = query.list();
			if(result !=null && !result.isEmpty()){
				isAllowErPanel = String.valueOf(result.get(0));
				if("Y".equalsIgnoreCase(isAllowErPanel)){
					erPanelFlag = true;
				}
			}			
		}catch(Exception e){
			throw new  DAOException(e);
		}
		return erPanelFlag;
	}	
	//Shankar Start
	//If slr IsERPanelEligible N then all slv IsERPanelEligible set N if usertype MP start
	public List<Long> findByslrRfnumIsERPanelEligibleY(Long octslrrfnum) {
		Session hibSession = null;
		List<Long> retvalList = new ArrayList<Long>();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "Select octslvrfnum From OctSlv slv where slv.octSlr.octslrrfnum=:octslrrfnum and slv.deleted='N' and slv.isAllowErPanel='Y'";
			Query query = hibSession.createQuery(queryString);
			query.setLong("octslrrfnum", octslrrfnum);
			retvalList = query.list();
		} catch (HibernateException e) {
			throw new  DAOException(e);
		}
		return retvalList;
	}

	public void updateSlaveIsERPanelEligible(List<Long> slaveList){
		Session hibSession = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("update OctSlv slv set slv.isAllowErPanel='N' where slv.octslvrfnum in (:slaveList)");
			query.setParameterList("slaveList", slaveList);
			query.executeUpdate();
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
	}
	//Shankar End

	//Shanakr Start
	public String isSlaveListed(String slvCode){
		Session hibSession = null;
		List<String> retvalList = null;
		String isSlaveListed="";
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select octSlvIsListing from OctSlv where octslvcode=:slvCode";
			Query query = hibSession.createQuery(queryString);
			query.setString("slvCode", slvCode);
			retvalList= query.list();
			query.setMaxResults(1);
			if(retvalList!=null && !retvalList.isEmpty()){
				isSlaveListed=retvalList.get(0);
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return isSlaveListed;
	}
	//Shankar End

	//@Rohit Start TPR-8570 Price and Inventory Module
	public int findSlvLstCnt(String slrCode) {
		Session hibSession = null;
		List<Integer> retvalList = null;
		int totalSlv = 0;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select count(*) From OctSlv octslv where octslv.octSlr.octslrlcode =:slrCode and octslv.octslvisactive='Y' and octslv.octSlvIsListing = 'Y' ";
			Query query = hibSession.createQuery(queryString);
			query.setString("slrCode", slrCode);
			retvalList = query.list();
			if (!retvalList.isEmpty())
				totalSlv = retvalList.get(0);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}	
		return totalSlv;
	}

	public List<Object[]> getSlvCodeNameRfnum(Long slrRfnum,String slvCode) {
		Session hibSession = null;
		List<Object[]> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select slv.octslvcode,slv.octslvname,slv.octslvrfnum,slv.isStockBlock from OctSlv slv where slv.deleted='N'"
					+ " and slv.octslvisactive = 'Y' and slv.octSlvIsListing = 'Y'";

			if (slrRfnum != null && slrRfnum != 0) {
				queryString += " and slv.octSlr.octslrrfnum=:slrRfnum";
			}

			if (!"".equals(slvCode) && slvCode != null ) {
				queryString += " and slv.octslvcode=:slvCode";
			}

			queryString += " order by octslvrfnum ";
			Query query = hibSession.createQuery(queryString);
			if (slrRfnum != null && slrRfnum != 0) {
				query.setLong("slrRfnum", slrRfnum);
			}
			if (!"".equals(slvCode) && slvCode != null ) {
				query.setString("slvCode", slvCode);
			}
			retvalList = query.list();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}

	public List<Object[]> getSlvCodeNameRfnumBySlvRfnum(List<Long> slvRfNum) {
		Session hibSession = null;
		List<Object[]> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select slv.octslvcode,slv.octslvname,slv.octslvrfnum from OctSlv slv where slv.deleted='N'"
					+ " and slv.octslvisactive = 'Y' and slv.octSlvIsListing = 'Y'";

			if (slvRfNum != null && !slvRfNum.isEmpty()) {
				queryString += " and slv.octslvrfnum in (:slvRfNum)";
			}
			queryString += " order by octslvrfnum asc";
			Query query = hibSession.createQuery(queryString);
			query.setParameterList("slvRfNum", slvRfNum);
			retvalList = query.list();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}

	public List<Object[]> getSlvCodeNameRfnumBySlvCode(List<String> slvCode) {
		Session hibSession = null;
		List<Object[]> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select slv.octslvcode,slv.octslvname,slv.octslvrfnum from OctSlv slv where slv.deleted='N'"
					+ " and slv.octslvisactive = 'Y' and slv.octSlvIsListing = 'Y'";

			if (slvCode != null && !slvCode.isEmpty()) {
				queryString += " and slv.octslvcode in (:slvCode)";
			}
			queryString += " order by octslvrfnum asc";
			Query query = hibSession.createQuery(queryString);
			query.setParameterList("slvCode", slvCode);
			retvalList = query.list();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}
	//@Rohit End TPR-8570 Price and Inventory Module

	//Suraj T. Start
	public boolean findslaveBySlaveCodeAndSeller(String slaveCode, Long sellerID) {
		OctSlv retval = null;
		Session hibSession = null;
		List retvalList = null;
		boolean validSlave = false;

		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From OctSlv octslv where octslv.octslvcode =:slaveCode and octslv.octSlr.octslrrfnum=:sellerID";
			Query query = hibSession.createQuery(queryString);
			query.setString("slaveCode", slaveCode);
			query.setLong("sellerID", sellerID);
			retvalList = query.list();
			if (retvalList!=null && !retvalList.isEmpty()){
				retval = (OctSlv) retvalList.get(0);
				if(retval!=null){
					validSlave = true;
				}
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return validSlave;
	}
	//Suraj T. End

	//Suraj T. Start
	public List<Object[]> findBySellerRfNum(String sellerrfnum){
		List<Object[]> list = new ArrayList<Object[]>();
		Session hibsession =  null;
		try {
			String queryStr = "select octslvcode,allowRejectReason "
					+ "from OctSlv where octSlr.octslrrfnum=:sellerrfnum";
			hibsession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibsession.createQuery(queryStr);
			query.setString("sellerrfnum", sellerrfnum);
			list  = query.list();
		} catch (HibernateException e) {
			throw new  DAOException(e);
		}
		return list;
	}
	//Suraj T. End

	//@nikhil.Shinge TPR-9732_Reject reason start
	public String isSlaveRejectReasonEnable(String octslvrfnum){
		Session hibSession = null;
		List<String> retvalList = null;
		String isSlaveListed="";
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select allowRejectReason from OctSlv where octslvrfnum=:octslvrfnum";
			Query query = hibSession.createQuery(queryString);
			query.setString("octslvrfnum", octslvrfnum);
			retvalList= query.list();
			if(retvalList!=null && !retvalList.isEmpty()){
				isSlaveListed=retvalList.get(0);
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return isSlaveListed;
	}

	public String findIsSlaveRejectReasonBySlvcode(String octslvcode){
		Session hibSession = null;
		List<String> retvalList = null;
		String isSlaveListed="";
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select allowRejectReason from OctSlv where octslvcode=:octslvcode";
			Query query = hibSession.createQuery(queryString);
			query.setString("octslvcode", octslvcode);
			retvalList= query.list();
			if(retvalList!=null && !retvalList.isEmpty()){
				isSlaveListed=retvalList.get(0);
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return isSlaveListed;
	}
	//@nikhil.Shinge TPR-9732_Reject reason end

	//For JIO POS get OctSlv By only SlvCOde
	public OctSlv findBySlvCode(String slaveCode) {
		OctSlv retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From OctSlv octslv where octslv.octslvcode like '%-"+slaveCode+"' and octslv.octslvisactive='Y' and octslv.octSlvIsListing = 'Y' ";
			Query query = hibSession.createQuery(queryString);
			retvalList = query.list();
			if (!retvalList.isEmpty())
				retval = (OctSlv) retvalList.get(0);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retval;
	}
	//For JIO POS get OctSlv By only SlvCOde

	//sidhu

	public List findByslrrfnum(Long slrrfnum) {
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select octslv.octslvcode,octslv.octslvlname,octslv.octslvrfnum From OctSlv octslv where octslv.octSlr.octslrrfnum =:slrrfnum ";
			Query query = hibSession.createQuery(queryString);
			query.setLong("slrrfnum", slrrfnum);
			retvalList = query.list();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}

	public List<Long> findByslrrfnumInv(Long slrrfnum) {
		Session hibSession = null;
		List<Long> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select octslv.octslvrfnum From OctSlv octslv where octslv.octSlr.octslrrfnum =:slrrfnum and octslv.octSlvIsListing = 'Y'";
			Query query = hibSession.createQuery(queryString);
			query.setLong("slrrfnum", slrrfnum);
			retvalList = query.list();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}


	public List<Long> findbyType(String type,Long slrrfnum) {
		Session hibSession = null;
		List<Long> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select octslv.octslvrfnum From OctSlv octslv where octslv.octSlr.octslrrfnum =:slrrfnum and octslv.octslvtype.paramcode =:type and octslv.octslvtype.paramgroup = 'SLV_TYPE' and octslv.octSlvIsListing = 'Y'";
			Query query = hibSession.createQuery(queryString);
			query.setString("type", type);
			query.setLong("slrrfnum", slrrfnum);
			retvalList = query.list();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}

	public List<String> findSlvCodebyrfnum(String slvlist) {
		Session hibSession = null;
		List<String> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select octslv.octslvcode From OctSlv octslv where octslv.octslvrfnum in ("+slvlist+") ";
			Query query = hibSession.createQuery(queryString);
			retvalList = query.list();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}

	//siddhesh :: TPR-9730
	public  List<String> findSlvByrfnum(List<Long> slaveList){
		Session hibSession = null;
		List<String> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select octslv.octslvcode From OctSlv octslv where octslv.octslvrfnum in (:slaveList)");
			query.setParameterList("slaveList", slaveList);
			retvalList = query.list();
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		return retvalList;
	}

	public List<Object[]> findGeoBySellerRfNum(String sellerrfnum){
		List<Object[]> list = new ArrayList<Object[]>();
		Session hibsession =  null;
		try {
			String queryStr = "select octslvcode,isGeoFencing "
					+ "from OctSlv where octSlr.octslrrfnum=:sellerrfnum";
			hibsession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibsession.createQuery(queryStr);
			query.setString("sellerrfnum", sellerrfnum);
			list  = query.list();
		} catch (HibernateException e) {
			throw new  DAOException(e);
		}
		return list;
	}

	//NIshant
	public List<Object[]> getSlvsBySlrCode(String slrCode) {
		Session hibSession = null;
		List<Object[]> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select slv.octslvcode,slv.octslvname,slv.octslvrfnum from OctSlv slv where slv.deleted='N'";

			if (!"".equals(slrCode) && slrCode != null ) {
				queryString += " and slv.octSlr.octslrlcode=:slrCode";
			}

			queryString += " order by octslvrfnum ";
			Query query = hibSession.createQuery(queryString);
			if (!"".equals(slrCode) && slrCode != null ) {
				query.setString("slrCode", slrCode);
			}
			retvalList = query.list();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}
	//Nishant End

	//Shankar Start : TPR-10538
	public List<Ismuat> findRtoSlaveAddressBySlave(String octslvrfnum){
		Session hibSession = null;
		List<Ismuat> retval = null;
		try{
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select octSlvRtoAddress from OctSlv where octslvrfnum=:octslvrfnum");
			query.setLong("octslvrfnum" , new Long(octslvrfnum));
			retval = query.list();
		}catch( HibernateException e){
			throw new  DAOException(e);
		}
		return retval;
	}
	//Shankar End : TPR-10538

	//@Nikhil.S Digital Seller Changes
	public String isSlaveBelongToSeller(String slvCode,String octslrlcode){
		Session hibSession = null;
		List<String> retvalList = null;
		String isSlaveListed="";
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select octSlvIsListing from OctSlv where octslvcode=:slvCode and octSlr.octslrlcode=:octslrlcode";
			Query query = hibSession.createQuery(queryString);
			query.setString("slvCode", slvCode);
			query.setString("octslrlcode", octslrlcode);
			retvalList= query.list();
			query.setMaxResults(1);
			if(retvalList!=null && !retvalList.isEmpty()){
				isSlaveListed=retvalList.get(0);
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return isSlaveListed;
	}

	//@siddhesh : utility
	public List<Long> getAllSlv() {
		Session hibSession = null;
		List<Long> retvalList = new ArrayList<Long>();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "Select slv.octslvrfnum From OctSlv slv where slv.deleted='N'";
			Query query = hibSession.createQuery(queryString);
			retvalList = query.list();
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return retvalList;
	}
	//@siddhesh : utility

	//@Nikhil.S SHD
	public String findIsSlvAPOBbyslvcode(String octslvcode){
		Session hibSession = null;
		String isApob = null;
		List retvalList=null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select isAPOB from OctSlv where octslvcode=:octslvcode and octslvisactive='Y' and deleted='N'";
			Query query = hibSession.createQuery(queryString);
			query.setString("octslvcode", octslvcode);
			retvalList = query.list();
			if(!retvalList.isEmpty()){
				isApob = (String) retvalList.get(0);
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return isApob;
	}
	public OctSlv findslaveCodeExistance(String slaveCode) {//@nishant added for narvar
		OctSlv retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From OctSlv octslv where octslv.octslvcode =:slaveCode ";
			Query query = hibSession.createQuery(queryString);
			query.setString("slaveCode", slaveCode);
			retvalList = query.list();
			if (retvalList.size() > 0)
				retval = (OctSlv) retvalList.get(0);
		} catch (HibernateException e) {
			throw new DAOException(e);
		} finally {
		}
		return retval;
	}

	//@Rohit ::: Start of Getting order Processing time-frame of slave by from slvcode/slvrfnum
	public Object[] getOrdProcessTime(Long slvRfNum,String slvCode){
		Object[] slvObj = null;
		Session hibSession = null;
		List<Object[]> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuilder buffer = new StringBuilder();
			buffer.append("select octslvorderprocessingtat,octslvorderprocessingtatedair,octslvorderprocessingtathdsurf,octslvorderprocessingtatedsurf from OctSlv");
			if(!Objects.isNull(slvRfNum)){
				buffer.append(" where octslvrfnum =:slvRfNum");
			}
			if(slvCode !=null && !slvCode.isEmpty()){
				buffer.append(" where octslvcode =:slvCode");
			}

			Query query = hibSession.createQuery(buffer.toString());
			if(!Objects.isNull(slvRfNum)){
				query.setLong("slvRfNum", slvRfNum);
			}

			if(slvCode !=null && !slvCode.isEmpty()){
				query.setString("slvCode", slvCode);
			}
			query.setMaxResults(1);
			retvalList = query.list();
			if (retvalList!=null && !retvalList.isEmpty()) {
				slvObj = retvalList.get(0);
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return slvObj;
	}
	//@Rohit ::: End of Getting order Processing time-frame of slave by from slvcode/slvrfnum

	//Nishant Start
	//If slr IsRevEligible N then all slv IsRevEligible set N if usertype MP start
	public List<Long> findByslrRfnumIsRevlEligibleY(Long octslrrfnum) {
		Session hibSession = null;
		List<Long> retvalList = new ArrayList<Long>();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "Select octslvrfnum From OctSlv slv where slv.octSlr.octslrrfnum=:octslrrfnum and slv.deleted='N' and slv.isRevEligible='Y'";
			Query query = hibSession.createQuery(queryString);
			query.setLong("octslrrfnum", octslrrfnum);
			retvalList = query.list();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return retvalList;
	}

	public void updateSlaveIsRevEligible(List<Long> slaveList) throws DAOException {
		Session hibSession = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("update OctSlv slv set slv.isRevEligible='N' where slv.octslvrfnum in (:slaveList)");
			query.setParameterList("slaveList", slaveList);
			query.executeUpdate();
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
	}
	//Nishant End
public String getSlvFromUbi(Long ubirfnum){
		Session hibSession = null;
		String slvLstName = null;
		List<String> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuilder buffer = new StringBuilder();
			buffer.append("select slv.octslvlname from OctSlvUsr usr left join usr.ismubi ubi left join usr.octSlv slv where ubi.ubirfnum=:ubirfnum");
			Query query = hibSession.createQuery(buffer.toString());
			query.setLong("ubirfnum",ubirfnum);
			query.setMaxResults(1);
			retvalList = query.list();
			if (retvalList!=null && !retvalList.isEmpty()) {
				slvLstName = retvalList.get(0);
			}
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return slvLstName;
	}
	
	//Shankar Start : TPR-11937
	@SuppressWarnings("unchecked")
	public List<Object[]> getSlaveDetailsBySlaveRfNum(long octslvrfnum) {
		Session hibSession = null;
		List<Object[]> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select gstregistrationNo,octslvpan from OctSlv where octslvrfnum=:octslvrfnum";
			Query query = hibSession.createQuery(queryString);
			query.setLong("octslvrfnum", octslvrfnum);
			query.setMaxResults(1);
			retvalList = query.list();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}

	@SuppressWarnings("unchecked")
	public Long getSlaveRfNumBySlaveCode(String slaveCode){
		Long slaveRfNum = null;
		Session hibSession = null;
		List<Long> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select octslvrfnum from OctSlv where octslvcode =:octslvcode";
			Query query = hibSession.createQuery(queryString);
			query.setString("octslvcode", slaveCode);
			query.setMaxResults(1);
			retvalList = query.list();
			if (retvalList!=null && !retvalList.isEmpty()) {
				slaveRfNum = new Long(retvalList.get(0).toString());
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return slaveRfNum;
	}
	//Shankar End : TPR-11937
	
	
	public OctSlv findBySlvCodeListedAndActive(String slaveCode) {
		OctSlv retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From OctSlv octslv where octslv.octslvcode = '"+slaveCode+"' and octslv.octslvisactive='Y' and octslv.octSlvIsListing = 'Y' ";
			Query query = hibSession.createQuery(queryString);
			retvalList = query.list();
			if (!retvalList.isEmpty())
				retval = (OctSlv) retvalList.get(0);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retval;
	}
	public EwayBillDetails findEwayBillBySlaveId(Long octslvrfnum) {
		Session hibSession = null;
		List ewaybillist=null;
		EwayBillDetails ewaybill=null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From EwayBillDetails eb where eb.octslv.octslvrfnum = '"+octslvrfnum+"'";
			Query query = hibSession.createQuery(queryString);
			 ewaybillist = query.list();
			if (!ewaybillist.isEmpty()) {
				ewaybill = (EwayBillDetails)ewaybillist.get(0);
			}
			
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return ewaybill;
		
		
	}

	public String findByTransactionID(String transactionId) {
		Session hibSession = null;
		List results = null;
		String gstin = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select pst.octSlv.gstregistrationNo From Ismpst pst where pst.transactionid='"
					+ transactionId + "'";
			Query query = hibSession.createQuery(queryString);
			results = query.list();
			if (!results.isEmpty()) {
				gstin = (String) results.get(0);
			}

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return gstin;
	}


	public void updateIsGatiActive(Long venderCode, String isgatiactive) {
		// TODO Auto-generated method stub
		Session hibSession = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "update OctSlv octslv set octslv.isGatiActive=:isgatiactive where octslv.octslvrfnum=:slvrfnum";
			Query query = hibSession.createQuery(queryString);
			query.setString("isgatiactive", isgatiactive);
			query.setLong("slvrfnum", venderCode);
			query.executeUpdate();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
	}

	public static List<OctSlv> findByLpActivationStatus() {
		Session hibSession = null;
		List<OctSlv> retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "From OctSlv slv where slv.lpActivationStatus =:lpActivationStatus and deleted = 'N' and octslvisactive = 'Y' and octSlvIsListing = 'Y'  order by slv.modidate  desc";
			Query query = hibSession.createQuery(queryString);
			query.setString("lpActivationStatus", "PENDING_FOR_ACTIVATION");
			retvalList = query.list();

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvalList;
	}

	public void updateStoreRequest(String slaveCode,String lpActivationStatus,String rejectReason) {
		Session hibSession = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession
					.createQuery("update OctSlv slv set slv.lpActivationStatus=:lpActivationStatus ,slv.rejectReason =:rejectReason ,slv.octslvisactive='N',slv.octSlvIsListing='N' where slv.octslvcode = :slaveCode");
			query.setString("slaveCode", slaveCode);
			query.setString("lpActivationStatus", lpActivationStatus);
			query.setString("rejectReason", rejectReason);
			
			query.executeUpdate();
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		
	}
	
	
	public OctSlv findBySlaveCode(String slaveCode) {
		OctSlv retval = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "select octslv From OctSlv octslv where octslv.octslvcode =:slaveCode and  octslv.octSlvIsListing ='Y' and octslv.octslvisactive='Y' ";
			Query query = hibSession.createQuery(queryString);
			query.setString("slaveCode", slaveCode);
			retvalList = query.list();
			
			if (!retvalList.isEmpty())
				retval = (OctSlv) retvalList.get(0);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retval;
	}
	
	
	public void updateStoreRequest(String slaveCode,String lpActivationStatus) {
		Session hibSession = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession
					.createQuery("update OctSlv slv set slv.lpActivationStatus=:lpActivationStatus  where slv.octslvcode = :slaveCode");
			query.setString("slaveCode", slaveCode);
			query.setString("lpActivationStatus", lpActivationStatus);
			
			query.executeUpdate();
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		
	}
	

	
	//Commenting_out_mothercare_code_changes_28June2021
/*	public Long getSlvrfnumByCode(String octslvcode){
		Session hibSession = null;
		Long slvrfnum =null;
		List<Long> result;
		try{
			String queryString="select octslvrfnum from OctSlv where octslvcode=:octslvcode";
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery(queryString);
			query.setString("octslvcode", octslvcode);
			query.setMaxResults(1);
			result = query.list();
			if(result !=null && !result.isEmpty()){
				slvrfnum=result.get(0);
			}			
		}catch(Exception e){
			throw new  DAOException(e);
		}
		return slvrfnum;
	}*/
	
	public String getSlvOperationTimings(String slvcode){
		Session hibSession = null;
		String slvTime = null;
		List<String> result;
		try{
			String queryString="select octslvclosetime from OctSlv where octslvcode=:slavecode";
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery(queryString);
			query.setString("slavecode", slvcode);
			query.setMaxResults(1);
			result = query.list();
			if(result !=null && !result.isEmpty()){
				slvTime=result.get(0);
			}			
		}catch(Exception e){
			throw new  DAOException(e);
		}
		return slvTime;
	}
	
	
	
	
	public List getAllZonal(){
		Session hibSession = null;
		List retvallist = new ArrayList();        
		try
		{	
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			Query query=null;
				query=hibSession.createQuery("select zonerfnum,description from ZoneMaster zm");
				retvallist=query.list();
		
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return retvallist;
	}

	public List getstateListByZone(String zoneId) {
		Session hibSession = null;
		List retvallist = new ArrayList();   
		Query query=null;
		try
		{	if(StringUtils.isNotBlank(zoneId)) {
			hibSession=com.anm.hibernate.HibernateConnection.getSession();
			
				query=hibSession.createQuery("select sm from StateMaster sm where sm.zonerfnum=:zonerfnum");
				query.setLong("zonerfnum", Long.valueOf(zoneId));
				retvallist=query.list();
				
		}
		
		}catch( HibernateException e)
		{
			throw new  DAOException( e );
		}
		return retvallist;
	}

	public List getAllstateList() {
		Session hibSession = null;
		List retvallist = new ArrayList();
		Query query = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();

			query = hibSession.createQuery("select sm from StateMaster sm");
			retvallist = query.list();

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvallist;
	}
	
	
	public void deleteExistingStates(Long octslvrfnum) {
			Session hibSession = null;   		
			try {
				hibSession = com.anm.hibernate.HibernateConnection.getSession();
	            org.hibernate.Transaction tx = hibSession.beginTransaction();
				String queryString = "update  SlaveStateMapping  set deleted='Y'  where octslaverfnum=:octslaverfnum and deleted != 'Y'";
				Query query = hibSession.createQuery(queryString);
				query.setLong("octslaverfnum", octslvrfnum);
				query.executeUpdate();
		        tx.commit(); 
			} catch (HibernateException e) {
				throw new DAOException(e);
			}
		
		
	}

	public List findSlatesByslaverfNum(Long octslvrfnum) {
		Session hibSession = null;
		List retvallist = new ArrayList();
		Query query = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();

			query = hibSession.createQuery(
					"select sm from SlaveStateMapping sm where sm.octslaverfnum=:octslaverfnum and sm.deleted != 'Y'");
			query.setLong("octslaverfnum", octslvrfnum);
			retvallist = query.list();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvallist;

	}

	
	
	public List findSelectedStatesByZoneId(Long zoneId,Long slvrfnum) {
		Session hibSession = null;
		List retvallist = new ArrayList();
		Query query = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();

			query = hibSession.createQuery(
					"select sm from SlaveStateMapping sm where sm.zonerfnum=:zonerfnum and sm.octslaverfnum =:octslaverfnum and sm.deleted != 'Y'");
			query.setLong("zonerfnum", zoneId);
			query.setLong("octslaverfnum", slvrfnum);
			retvallist = query.list();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return retvallist;
		
	} 
	
	
	
	public SlaveStateMapping findSlaveStateMappingByslaveIdAndstateId(Long octstaterfnum,Long octslaverfnum) {
		Session hibSession = null;
		List retvallist = new ArrayList();
		SlaveStateMapping slaveStateMapping=null;
		Query query = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			query = hibSession.createQuery(
					"select sm from SlaveStateMapping sm where sm.octslaverfnum=:octslaverfnum and sm.octstaterfnum=:octstaterfnum ");
			query.setLong("octslaverfnum", octslaverfnum);
			query.setLong("octstaterfnum", octstaterfnum);
			retvallist = query.list();
			if(!retvallist.isEmpty()) {
				 slaveStateMapping =(SlaveStateMapping)retvallist.get(0);
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return slaveStateMapping;
		
	} 
	public SlaveStateMapping findSlaveStateMappingByslaveIdAndserviceablity(Long octslaverfnum) {
		Session hibSession = null;
		List retvallist = new ArrayList();
		SlaveStateMapping slaveStateMapping=null;
		Query query = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();

			query = hibSession.createQuery(
					"select sm from SlaveStateMapping sm where sm.octslaverfnum=:octslaverfnum and sm.serviceability='P'");
			query.setLong("octslaverfnum", octslaverfnum);
			retvallist = query.list();
			if(!retvallist.isEmpty()) {
				 slaveStateMapping =(SlaveStateMapping)retvallist.get(0);
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return slaveStateMapping;
		
	}

	public ZoneMaster findZoneById(Long zonerfnum) {
		// TODO Auto-generated method stub
				Session hibSession = null;
				List retvallist = new ArrayList();
				ZoneMaster zoneMaster=null;
				Query query = null;
				try {
					hibSession = com.anm.hibernate.HibernateConnection.getSession();
					query = hibSession.createQuery(
							"select sm from ZoneMaster sm where sm.zonerfnum=:zonerfnum");
					query.setLong("zonerfnum", zonerfnum);
					retvallist = query.list();
					if(!retvallist.isEmpty()) {
						zoneMaster =(ZoneMaster)retvallist.get(0);
					}
				} catch (HibernateException e) {
					throw new DAOException(e);
				}
				return zoneMaster;
				
		
	} 

	public List<OctSlv> getAllActiveSlv() {
		Session hibSession = null;
		List<OctSlv> retvalList = new ArrayList<>();
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String queryString = "Select slv From OctSlv slv where octslvisactive='Y' and slv.deleted='N'";
			Query query = hibSession.createQuery(queryString);
			
			retvalList = query.list();
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return retvalList;
	}
	
	
	
    public List<OctSlv> getslvrfnumSlaveList(List<Long> slvrfnumList) {
	Session hibSession = null;
	List<OctSlv> retvalList = new ArrayList<>();
	try {
	    hibSession = com.anm.hibernate.HibernateConnection.getSession();
	    String HQL_QUERY = "select slv from OctSlv slv where slv.octslvrfnum in"
		    + "(:slvrfnum)";
	    Query query = hibSession.createQuery(HQL_QUERY);
	    query.setParameterList("slvrfnum", slvrfnumList);
	    retvalList = query.list();

	} catch (Exception e) {
	    throw new DAOException(e);
	}
	return retvalList;

    }
	
	
	
     
	public List<OctSlv> fetchnRecordsInChunkOctSlv(int n) {
		Session hibSession = null;
		Criteria criteria = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			criteria = hibSession.createCriteria(OctSlv.class);
			criteria.add(Restrictions.isNull("isSentToOms"));
			
			criteria.setMaxResults(n);
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return criteria.list();

	}

	public void updateisSentToOms(String slaveCode, Character issent) 
	{
		Session hibSession = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("update OctSlv slv set slv.isSentToOms=:isSentToOms where slv.octslvcode = :slaveCode");
			query.setString("slaveCode", slaveCode);
			query.setCharacter("isSentToOms", issent);
			query.executeUpdate();
		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}
		
	}
	
	public Object fetchSlaveContactDetails(String slaveCode) {
		Object contactDetails = null;
		Session hibSession = null;
		List retvalList = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			Query query = hibSession.createQuery("select osi.slvinfofname, slv.octslvRetAddress.uatphone from OctSlv slv, OctSlvInfo osi "
					+ "where slv.octslvrfnum = osi.octSlv.octslvrfnum and slv.octslvcode=:slaveCode");
			query.setString("slaveCode", slaveCode);
			retvalList = query.list();
			if (retvalList!=null && !retvalList.isEmpty())
			{
				contactDetails = (Object) retvalList.get(0);
			}
		} catch (HibernateException exception) {
			throw new com.anm.hibernate.DAOException(exception);
		}
		return contactDetails;
	}
	
}
