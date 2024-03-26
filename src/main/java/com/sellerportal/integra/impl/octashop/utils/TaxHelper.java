package com.sellerportal.integra.impl.octashop.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sellerportal.model.OctSlr;
import com.sellerportal.model.OctSlv;
import com.sellerportal.dao.OctSlvDAO;
import com.sellerportal.model.OctSlvInfo;
import com.sellerportal.dao.OctSlvInfoDAO;
import com.sellerportal.model.OctSlvUsr;
import com.sellerportal.tisl.oms.forward.bean.TaxSlaveIntegrationBean;
import com.sellerportal.dao.OctSlvUsrDAO;
import com.sellerportal.ism.search.lucene.indexing.JdbcConnection;

public class TaxHelper {

	private static final Log LOGGER = LogFactory.getLog(TaxHelper.class);

	private static final String SQL_FIND_SKU_FOR_SELLER = "select "
			+ "SPLUSSID as ussid " + "from OCT_SLR_PRODUCT_LIST where "
			+ "SPLUSSID IS NOT NULL and SPLSLRRFNUM=";
	
	
	private static final String SQL_FIND_SKU_FOR_SELLER_WITH_STATUS = "select "
			+ "product.SPLUSSID as ussid " + "from OCT_SLR_PRODUCT_LIST product "
			+ "left OUTER JOIN  OCT_PARAM param on param.paramrfnum=product.SPLPARAMSTATUS"
			+ " where (param.PARAMCODE='PENDINGSENDFORAPPROVAL' or param.PARAMCODE='PENDINGTAXSTATUS') and "
			+ "SPLSLRRFNUM=";
	
	private static final String SQL_FIND_SLAVE_STATES_BY_SELLER ="select "
			+ "STATERFNUM as staterfnum from OCT_STATE_MASTER "
			+ "where "
			+ "STATERFNUM in (select uatstatemaster from ismuat where ISRETURNADD='N' and uatubirfnum in "
			+ "(select ismubi from OCT_SLV_USR where OCTSLV in (select octslvrfnum from OCT_SLV where OCTSLVSLR=";

	private static final String SQL_FIND_TAX_FOR_SKU = "select "
			+ "count(*) as count "
			+ "from OCT_SKU_STATE_TAX_SLR taxslr "
			+ "left OUTER JOIN OCT_SLR_PRODUCT_LIST slrProduct on slrProduct.SPLRFNUM=taxslr.OCTTAXMSTRPBIRFNUM "
			+ "left OUTER JOIN OCT_SLR slr on slr.OCTSLRRFNUM=taxslr.SPSLRRFNUM "
			+ "left OUTER JOIN OCT_STATE_MASTER state on state.STATERFNUM=taxslr.STATERFNUM "
			+ "where slrProduct.SPLUSSID=? and state.STATERFNUM=?";
	
	
	private static final String SQL_FIND_USSID_BY_SELLER_STATE ="select "
			+ "product.SPLUSSID as USSID "
			+ "from OCT_SKU_STATE_TAX_SLR tax left outer join OCT_SLR_PRODUCT_LIST product on tax.OCTTAXMSTRPBIRFNUM=product.SPLRFNUM "
			+ "where SPSLRRFNUM=? and STATERFNUM=? "
			+ "and product.SPLUSSID in (select SPLUSSID as ussid from OCT_SLR_PRODUCT_LIST where SPLUSSID=?)";
	
	private static final String SQL_FIND_SKU_BY_PARAM = "select "
			+ "product.SPLRFNUM as splrfnum from OCT_SLR_PRODUCT_LIST product "
			+ "left outer join OCT_PARAM param on param.PARAMRFNUM=product.SPLPARAMSTATUS "
			+ "where param.PARAMCODE='PENDINGTAXSTATUS' and product.SPLSLRRFNUM=";
	
	
	private static final String SQL_FIND_INACTIVE_SLAVE_BY_SLR = "select "
			+ "slv.OCTSLVRFNUM as Slaverfnum,usr.OCTSLVUSRRFNUM as SlaveUsrRfnum,info.SLVINFORFNUM as InfoRfnum "
			+ "from OCT_SLV slv "
			+ "left outer join OCT_SLV_USR usr on usr.OCTSLV=slv.OCTSLVRFNUM "
			+ "left outer join ismubi ubi on ubi.ubirfnum=usr.ISMUBI "
			+ "left outer join OCT_SLV_INFO info on info.OCTSLVRFNUM=slv.OCTSLVRFNUM "
			+ "where "
			+ "slv.OCTSLVISACTIVE='N' and slv.OCTSLVISLISTING='N' and ubi.UBIACTIVE='Y' and "
			+ "slv.OCTSLVSLR=";
	
	private static final String SQL_FIND_SELLER_TAX= "select "
			+ "distinct tax.SPSLRRFNUM as sellerrfnum "
			+ "from OCT_SKU_STATE_TAX_SLR tax";

	public static final String SQL_FIND_TAX_FOR_SLR_SKU = "select slrPbi.SLRPBISKUCODE,state.DESCRIPTION,taxslr.OCTTAXMSTRCST,taxslr.OCTTAXMSTRVAT "
			+ "from OCT_SLRPBI slrPbi "
			+ "left OUTER JOIN OCT_SKU_STATE_TAX_SLR taxslr on slrPbi.SLRPBISPLRFNUM=taxslr.OCTTAXMSTRPBIRFNUM "
			+ "left OUTER JOIN OCT_STATE_MASTER state on state.STATERFNUM=taxslr.STATERFNUM "
			+ "left OUTER JOIN ISMCMT cmt on cmt.CMTRFNUM=slrPbi.SLRPBICMTRFNUM "
			+ "left OUTER JOIN OCT_SLR slr on slr.OCTSLRRFNUM=taxslr.SPSLRRFNUM ";
	
	public static final String SQL_FIND_TAX_FOR_SLR_SKU_OPTIMIZE = "select slrPbi.SLRPBISKUCODE,state.DESCRIPTION,taxslr.OCTTAXMSTRCST,taxslr.OCTTAXMSTRVAT "
			+ "from OCT_SLRPBI slrPbi "
			+ "left OUTER JOIN OCT_SKU_STATE_TAX_SLR taxslr on slrPbi.SLRPBISPLRFNUM=taxslr.OCTTAXMSTRPBIRFNUM "
			+ "left OUTER JOIN OCT_STATE_MASTER state on state.STATERFNUM=taxslr.STATERFNUM "
			+ "left OUTER JOIN ISMCMT cmt on cmt.CMTRFNUM=slrPbi.SLRPBICMTRFNUM ";
	
	
	public static boolean findSlrSku(OctSlr slr, Long stateRfnum)
			throws Exception {
		long start = System.currentTimeMillis();
		LOGGER.info("***** seller -> sku .....");
		boolean isValid = true;
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		PreparedStatement statementObject = null;
		ResultSet resultSetObject = null;
		try {
			connection = JdbcConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL_FIND_SKU_FOR_SELLER
					+ slr.getOctslrrfnum().toString());
			statementObject = (PreparedStatement) JdbcConnection.getConnection().prepareStatement(SQL_FIND_TAX_FOR_SKU);
			if(!rs.isBeforeFirst()){
				isValid = false;
			}
			while (rs.next()) {
				String ussid = rs.getString("ussid");
				statementObject.setString(1, ussid);
				statementObject.setLong(2, stateRfnum);

				resultSetObject = statementObject.executeQuery();
				while (resultSetObject.next()) {
					if (resultSetObject.getLong("count") == 0) {
						isValid = false;
						break;
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error("something went wrong while getting validity for seller sku "
					+ e.getMessage());
		}finally{		
			if(statement != null) {
				try {
					statement.close();
				} catch(Exception e) {
					LOGGER.error("Message :: "+e.toString() +" Cause :: "+e.getCause());
				}
			}
			if(statementObject != null) {
				try {
					statementObject.close();
				} catch(Exception e) {
					LOGGER.error("Message :: "+e.toString() +" Cause :: "+e.getCause());
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch(Exception e) {
					LOGGER.error("Message :: "+e.toString() +" Cause :: "+e.getCause());
				}
			}
			if(resultSetObject != null) {
				try {
					resultSetObject.close();
				} catch(Exception e) {
					LOGGER.error("Message :: "+e.toString() +" Cause :: "+e.getCause());
				}
			}
		}
		LOGGER.info("***** seller -> sku validity ..... chekced in "
				+ (System.currentTimeMillis() - start) + " ms *****");
		return isValid;

	}
	
	public static boolean findSlrSlave(OctSlr slr, String ussid){
		long start = System.currentTimeMillis();
		LOGGER.info("***** seller -> sku .....");
		boolean isValid = true;
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		ResultSet resultSetObject = null;
		PreparedStatement statementObject = null;
		try {
			connection = JdbcConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL_FIND_SLAVE_STATES_BY_SELLER
					+ slr.getOctslrrfnum().toString()+")))");
			statementObject = (PreparedStatement) JdbcConnection.getConnection().prepareStatement(SQL_FIND_TAX_FOR_SKU);
			if(!rs.isBeforeFirst()){
				isValid = false;
			}
			while (rs.next()) {
				String staterfnum = rs.getString("staterfnum");
				statementObject.setString(1, ussid);
				statementObject.setLong(2, new Long(staterfnum));

				resultSetObject = statementObject.executeQuery();

				while (resultSetObject.next()) {
					if (resultSetObject.getLong("count") == 0) {
						isValid = false;
						break;
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error("something went wrong while getting validity for seller sku "
					+ e.getMessage());
		}finally{
			if(statement != null) {
				try {
					statement.close();
				} catch(Exception e) {
					LOGGER.error("Message :: "+e.toString() +" Cause :: "+e.getCause());
				}
			}
			if(statementObject != null) {
				try {
					statementObject.close();
				} catch(Exception e) {
					LOGGER.error("Message :: "+e.toString() +" Cause :: "+e.getCause());
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch(Exception e) {
					LOGGER.error("Message :: "+e.toString() +" Cause :: "+e.getCause());
				}
			}
			if(resultSetObject != null) {
				try {
					resultSetObject.close();
				} catch(Exception e) {
					LOGGER.error("Message :: "+e.toString() +" Cause :: "+e.getCause());
				}
			}
			//JdbcConnection.closeConnection();
		}
		LOGGER.info("***** seller -> sku validity ..... chekced in "
				+ (System.currentTimeMillis() - start) + " ms *****");
		return isValid;
	}
	
	
	private static List findUssid(Long slrrfnum){
		long start = System.currentTimeMillis();
		boolean isValid = true;
		List ussidList = new ArrayList();
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			connection = JdbcConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL_FIND_SKU_FOR_SELLER
					+ slrrfnum.toString());
			while (rs.next()) {
				String ussid = rs.getString("ussid");
				ussidList.add(ussid);
			}
		}catch (Exception e) {
			LOGGER.error("something went wrong while getting ussid "
					+ e.getMessage());
		}finally{
			try{
				if(statement != null) statement.close();
		        if(rs != null) rs.close();
		        //if(connection != null) connection.close();
			}catch(Exception e){
				LOGGER.error("TaxHelper Connection closed Ex :: ",e);
			}/*finally{
				JdbcConnection.closeConnection();
			}*/
		}
		return ussidList;
	}
	
	private static List findUssidStatus(Long slrrfnum){
		long start = System.currentTimeMillis();
		boolean isValid = true;
		List ussidList = new ArrayList();
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			connection = JdbcConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL_FIND_SKU_FOR_SELLER_WITH_STATUS
					+ slrrfnum.toString());
			while (rs.next()) {
				String ussid = rs.getString("ussid");
				ussidList.add(ussid);
			}
		}catch (Exception e) {
			LOGGER.error("something went wrong while getting ussid "
					+ e.getMessage());
		}finally{
			try{
				if(statement != null) statement.close();
		        if(rs != null) rs.close();
		        //if(connection != null) connection.close();
			}catch(Exception e){
				LOGGER.error("TaxHelper Connection closed Ex :: ",e);
			}/*finally{
				JdbcConnection.closeConnection();
			}*/
		}
		return ussidList;
	}
	
	public static List findUssidBySlrNState(Long slrrfnum){
		long start = System.currentTimeMillis();
		LOGGER.info("finding sku by seller and state ---> start time is "+start);
		//List<String> ussidList = findUssid(slrrfnum);
		List<String> sellerStateUssidList = new ArrayList<String>();
		List<String> notValidUssidList = new ArrayList<String>();
		Connection connection = null;
		Statement statement = null;
		Statement statementSku = null;
		ResultSet rs = null;	
		ResultSet rsSku = null;
		ResultSet resultSetObject = null;
		PreparedStatement statementObject = null;
		try {
			//for state
			connection = JdbcConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL_FIND_SLAVE_STATES_BY_SELLER
					+ slrrfnum.toString()+")))");
			//for ussid
			statementSku = JdbcConnection.getConnection().createStatement();
			rsSku = statementSku.executeQuery(SQL_FIND_SKU_FOR_SELLER_WITH_STATUS
					+ slrrfnum.toString());
			
			statementObject = (PreparedStatement) JdbcConnection.getConnection().prepareStatement(SQL_FIND_USSID_BY_SELLER_STATE);
			while (rs.next()) {
				String staterfnum = rs.getString("staterfnum");
				statementObject.setLong(1, slrrfnum);
				statementObject.setLong(2, new Long(staterfnum));
				while(rsSku.next()){
					
					String ussid = rsSku.getString("ussid");
					statementObject.setString(3, ussid);
					resultSetObject = statementObject.executeQuery();
	
					if (resultSetObject.next()) {
						String tmpUssid = resultSetObject.getString("USSID");
						if(!sellerStateUssidList.contains(tmpUssid))
							sellerStateUssidList.add(tmpUssid);
					}else{
						notValidUssidList.add(ussid);
					}
				
				}
			}
						
			//removing not valid ussids for which state wise tax is not defined
			if(notValidUssidList != null && notValidUssidList.size() > 0){
				for(int i=0;i<notValidUssidList.size();i++){
					if(notValidUssidList.get(i) != null)
					sellerStateUssidList.remove(notValidUssidList.get(i).toString());
				}
			}
			
			//checking whether ussid has entry or not
			/*List exclusiveUssiList= exclusiveUssid(ussidList, sellerStateUssidList);
		if(checkEmptyList(exclusiveUssiList))
				isUssidAbsent = true;
			else
				isUssidAbsent = false;*/
			long end = System.currentTimeMillis();
			end = start-end;
			LOGGER.info("total time taken for finding sku by seller and state ---> start time is "+end);
		} catch (Exception e) {
			LOGGER.error("something went wrong while getting validity for seller sku "
					+ e.getMessage());
		}finally{
			try{
				if(statement != null) {
					try {
						statement.close();
					} catch(Exception e) {
						LOGGER.error(e);
					}
				}
				if(rs != null) {
					try {
						rs.close();
					} catch(Exception e) {
						LOGGER.error(e);
					}
				}
				if(resultSetObject != null) {
					try {
						resultSetObject.close();
					} catch(Exception e) {
						LOGGER.error(e);
					}
				}
				if(rsSku != null) {
					try {
						rsSku.close();
					} catch(Exception e) {
						LOGGER.error(e);
					}
				}
				if(statementSku != null) {
					try {
						statementSku.close();
					} catch(Exception e) {
						LOGGER.error(e);
					}
				}
				if(statementObject != null) {
					try {
						statementObject.close();
					} catch(Exception e) {
						LOGGER.error(e);
					}
				}
				//if(connection != null) connection.close();				
			}catch(Exception e){
				LOGGER.error("TaxHelper Connection closed Ex :: ",e);
			}/*finally{
				JdbcConnection.closeConnection();
			}*/
		}
		return sellerStateUssidList;
	}
	
	private static List exclusiveUssid(List<String> ussidList,List<String> sellerStateUssidList){
		List<String> exclusion = new ArrayList<String>();
		for (String x : ussidList) {
            if (!sellerStateUssidList.contains(x)) {
                exclusion.add(x);
            }
        }
		return exclusion;
	}

	private static boolean checkEmptyList(List<String> ussidList){
		if(ussidList != null && ussidList.size() > 0){
			return false;
		}else{
			return true;
		}
	}
	
	
	public static List getUssidBySlrNStates(Long slrrfnum){
		List splrfnumList = new ArrayList();
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			connection = JdbcConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL_FIND_SKU_BY_PARAM
					+ slrrfnum.toString());
			while (rs.next()) {
				String splrfnum = rs.getString("splrfnum");
				splrfnumList.add(splrfnum);
			}
		}catch(Exception e){
			LOGGER.error("something went wrong while getting seller sku "
					+ e.getMessage());
		}finally{
			try{
				if(statement != null) statement.close();
				if(rs != null) rs.close();
				//if(connection != null) connection.close();
			}catch(Exception e){
				LOGGER.error("TaxHelper Connection closed Ex :: ",e);
			}/*finally{
				JdbcConnection.closeConnection();
			}*/
		}
		return splrfnumList;
	}
	
	public static List<TaxSlaveIntegrationBean> findInactiveSlaveBySeller(Long slrrfnum){
		List<TaxSlaveIntegrationBean> slaveList = new ArrayList<TaxSlaveIntegrationBean>();
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try{
			connection = JdbcConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL_FIND_INACTIVE_SLAVE_BY_SLR
					+ slrrfnum.toString());
			while (rs.next()) {
				String slaverfnum = rs.getString("Slaverfnum");
				String slaveusrrfnum = rs.getString("SlaveUsrRfnum");
				String inforfnum = rs.getString("InfoRfnum");
				if(slaverfnum != null && slaveusrrfnum != null && inforfnum != null){
					OctSlv slv = new OctSlvDAO().findByPK(new Long(slaverfnum));
					OctSlvUsr slvUsr = new OctSlvUsrDAO().findByPK(new Long(slaveusrrfnum));
					OctSlvInfo info = new OctSlvInfoDAO().findByPK(new Long(inforfnum));
					TaxSlaveIntegrationBean taxSlaveBean = new TaxSlaveIntegrationBean();
					taxSlaveBean.setOctSlv(slv);
					taxSlaveBean.setOctSlvInfo(info);
					taxSlaveBean.setOctSlvUsr(slvUsr);
					slaveList.add(taxSlaveBean);
				}
			}
		}catch(Exception e){
			LOGGER.error("something went wrong while getting slave "
					+ e.getMessage());
		}finally{
			try{
				if(statement != null) statement.close();
				if(rs != null) rs.close();
				//if(connection != null) connection.close();
			}catch(Exception e){
				LOGGER.error("TaxHelper Connection closed Ex :: ",e);
			}/*finally{
				JdbcConnection.closeConnection();
			}*/
		}
		return slaveList;
	}
	
	public static boolean isExclusivUSSIDAbsent(Long slrrfnum,List sellerStateUssidList){
		LOGGER.info("Checking for Is-slave to be Active Flage::::::::::::::::");
		boolean isUssidAbsent = false;
		try{
			List<String> ussidList = findUssidStatus(slrrfnum);
			//checking whether ussid has entry or not
			List exclusiveUssiList= exclusiveUssid(ussidList, sellerStateUssidList);
			if(checkEmptyList(exclusiveUssiList))
				isUssidAbsent = true;
			else
				isUssidAbsent = false;
		}catch(Exception e){
			LOGGER.error("there is some proble in getting exclusive ussid "+e.getMessage());
		}
		return isUssidAbsent;
	}
}
