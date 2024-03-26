package com.sellerportal.dao;



import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.StatelessSession;

import com.anm.hibernate.DAOException;
import com.anm.hibernate.HibernateConnection;


public class StatelessSessionDAO {

	private static final Log LOGGER = LogFactory.getLog(StatelessSessionDAO.class);

	private static final ThreadLocal<StatelessSession> threadLocalSession = new ThreadLocal<StatelessSession>();

	public static StatelessSession getStatelessSession() {
		StatelessSession s = (StatelessSession) threadLocalSession.get();
		if (s == null) {            	
			s = HibernateConnection.getSessionFactory().openStatelessSession();
			threadLocalSession.set(s);
		}
		return s;
	}

	public static void closeStatelessSession() {         	                
		try { 
			StatelessSession s = (StatelessSession) threadLocalSession.get();
			threadLocalSession.set(null);
			if (s != null){            	                
				s.close();
			}  
		}catch(Exception e) {

		}

	}



	public ScrollableResults getProductList(Long paramrfnum,int from, int max, String sellerName, String sellerCode){

		ScrollableResults rs = null;
		try {
			String strQuery="from SlrProductList spl where spl.deleted='N'"; 
			if (paramrfnum != null) {
				strQuery += " and spl.octParam.paramrfnum=:paramrfnum";
			}
			if (!"".equals(sellerCode) && sellerCode != null) {
				strQuery += " and spl.octSlr.octslrlcode=:sellerCode";
			}
			Query query = getStatelessSession().createQuery(strQuery); 
			if (!"".equals(sellerCode) && sellerCode != null) {
				query.setString("sellerCode", sellerCode);
			}
			if (paramrfnum != null) {
				query.setLong("paramrfnum", paramrfnum);
			}
			query.setReadOnly(true);
			query.setFirstResult(from);
			query.setMaxResults(max);
			query.setFetchSize(1);

			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch( HibernateException e){
			throw new  DAOException( e );
		}

		return rs;
	}


	public ScrollableResults findProductListVideoByslrProdlist(long slrProductList) {
		ScrollableResults rs = null;
		try {

			StringBuffer buffer = new StringBuffer();

			buffer.append("from SlrProductListVideo prodVid where  prodVid.slrProductList=:slrProductList");
			Query query = getStatelessSession().createQuery(buffer.toString()); 
			query.setLong("slrProductList", slrProductList);
			//query.setMaxResults(1);

			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return rs;
	}

	public ScrollableResults findBySlrProductListID(long slrProductList) {
		ScrollableResults rs = null;
		try {

			StringBuffer buffer = new StringBuffer();
			buffer.append("from SlrPbi pbi where  pbi.slrProductList=:slrProductList");
			Query query = getStatelessSession().createQuery(buffer.toString()); 
			query.setLong("slrProductList", slrProductList);
			query.setMaxResults(1);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch( HibernateException e){
			throw new  DAOException( e );
		}

		return rs;
	}

	public ScrollableResults findPbisBySlrProductListID(long slrProductList) {
		ScrollableResults rs = null;
		try {

			StringBuffer buffer = new StringBuffer();
			buffer.append("select pbi.slrpbiname,pbi.slrpbititle,pbi.slrpbiskucode,pbi.productidentvalue,pbi.productidentvalue2,pbi.productidentvalue3 from SlrPbi pbi where  pbi.slrProductList=:slrProductList");
			Query query = getStatelessSession().createQuery(buffer.toString()); 
			query.setLong("slrProductList", slrProductList);
			query.setMaxResults(1);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch( HibernateException e){
			throw new  DAOException( e );
		}

		return rs;
	}

	public ScrollableResults findProductListImagesByslrProdlist(long slrProductRef) {
		ScrollableResults rs = null;
		try {

			StringBuffer buffer = new StringBuffer();
			buffer.append("from SlrProductListImg prodimg where  prodimg.slrProductList=:slrProductRef");
			Query query = getStatelessSession().createQuery(buffer.toString()); 
			query.setLong("slrProductRef", slrProductRef);
			//query.setMaxResults(1);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return rs;
	}

	public ScrollableResults findProductListImagesByslrProdlist1(long slrProductRef) {
		ScrollableResults rs = null;
		try {

			StringBuffer buffer = new StringBuffer();
			buffer.append("select prodimg.spliimgfile from SlrProductListImg prodimg where  prodimg.slrProductList=:slrProductRef");
			Query query = getStatelessSession().createQuery(buffer.toString()); 
			query.setLong("slrProductRef", slrProductRef);
			//query.setMaxResults(1);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return rs;
	}

	public ScrollableResults getdownloadProductList(Long paramrfnum,String sellerName, String sellerCode){

		ScrollableResults rs = null;
		try {
			String strQuery="select spl.splrfnum,spl.approvalremark,spl.splisactive,spl.spllistingid,spl.isprocessed,spl.createdate,spl.ismcmt.cmtcode from SlrProductList spl where spl.deleted='N'"; 
			if (paramrfnum != null) {
				strQuery += " and spl.octParam.paramrfnum=:paramrfnum";
			}
			if (!"".equals(sellerCode) && sellerCode != null) {
				strQuery += " and spl.octSlr.octslrlcode=:sellerCode";
			}
			Query query = getStatelessSession().createQuery(strQuery); 
			if (!"".equals(sellerCode) && sellerCode != null) {
				query.setString("sellerCode", sellerCode);
			}
			if (paramrfnum != null) {
				query.setLong("paramrfnum", paramrfnum);
			}
			query.setReadOnly(true);
			//query.setFetchSize(Integer.MIN_VALUE);

			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch( HibernateException e){
			throw new  DAOException( e );
		}

		return rs;
	}


	public ScrollableResults downloadProductList(Long paramrfnum,String sellerName, String sellerCode){

		ScrollableResults rs = null;
		try {
			//String strQuery="select sp.slrproductsku,sp.ismpbi.pbiname,sp.ismpbi.pbititle,sp.ismpbi.isactive,sp.ismpbi.pbilistingid,sp.ismpbi.productVideos from SlrProduct sp where sp.deleted='N'";
			String strQuery="select sp.sprfnum,sp.slrproductsku,sp.ismpbi.pbirfnum,sp.ismpbi.pbiname,sp.ismpbi.pbititle,sp.ismpbi.isactive,sp.ismpbi.pbilistingid,sp.createdate from SlrProduct sp where sp.deleted='N'";

			if (paramrfnum != null) {
				strQuery += " and sp.prodListingStatus.paramrfnum =:paramrfnum";
			}
			if (!"".equals(sellerCode) && sellerCode != null) {
				strQuery += " and sp.octSlr.octslrlcode=:sellerCode";
			}
			Query query = getStatelessSession().createQuery(strQuery); 
			if (!"".equals(sellerCode) && sellerCode != null) {
				query.setString("sellerCode", sellerCode);
			}
			if (paramrfnum != null) {
				query.setLong("paramrfnum", paramrfnum);
			}
			query.setReadOnly(true);
			query.setFetchSize(1);

			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return rs;
	}


	public ScrollableResults findProductVideosDetail(long pbi) {
		ScrollableResults rs = null;
		try {
			StringBuffer buffer = new StringBuffer();
			buffer.append("from ProductVideo prodVid where prodVid.ismpbi=:pbi");
			Query query = getStatelessSession().createQuery(buffer.toString()); 
			query.setLong("pbi", pbi);
			//query.setMaxResults(1);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return rs;
	}

	public ScrollableResults findPitImagesDetail(long pbi) {
		ScrollableResults rs = null;
		try {

			StringBuffer buffer = new StringBuffer();

			buffer.append("select pit.pitimage from Ismpit pit where  pit.ismpbi=:pbi");
			Query query = getStatelessSession().createQuery(buffer.toString()); 
			query.setLong("pbi", pbi);
			//query.setMaxResults(1);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return rs;
	}

	public ScrollableResults findIsmpitDetail(long pbi) {
		ScrollableResults rs = null;
		try {

			StringBuffer buffer = new StringBuffer();

			buffer.append("from Ismpit pit where  pit.ismpbi=:pbi");
			Query query = getStatelessSession().createQuery(buffer.toString()); 
			query.setLong("pbi", pbi);
			//query.setMaxResults(1);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return rs;
	}

	public ScrollableResults getProductListListed(Long paramrfnum,int from, int max, String sellerName, String sellerCode){

		ScrollableResults rs = null;
		try {
			//String strQuery="select sp.slrproductsku,sp.ismpbi.pbiname,sp.ismpbi.pbititle,sp.ismpbi.isactive,sp.ismpbi.pbilistingid,sp.ismpbi.productVideos from SlrProduct sp where sp.deleted='N'";
			String strQuery="select sp.sprfnum,sp.slrproductsku,sp.ismpbi.pbirfnum,sp.ismpbi.pbiname,sp.ismpbi.pbititle,sp.ismpbi.isactive,sp.ismpbi.pbilistingid from SlrProduct sp where sp.deleted='N'";

			if (paramrfnum != null) {
				strQuery += " and sp.prodListingStatus.paramrfnum =:paramrfnum";
			}
			if (!"".equals(sellerCode) && sellerCode != null) {
				strQuery += " and sp.octSlr.octslrlcode=:sellerCode";
			}
			Query query = getStatelessSession().createQuery(strQuery); 
			if (!"".equals(sellerCode) && sellerCode != null) {
				query.setString("sellerCode", sellerCode);
			}
			if (paramrfnum != null) {
				query.setLong("paramrfnum", paramrfnum);
			}
			query.setReadOnly(true);
			query.setFirstResult(from);
			query.setMaxResults(max);
			query.setFetchSize(1);

			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch( HibernateException e){
			throw new  DAOException( e );
		}

		return rs;
	}

	@SuppressWarnings("unchecked")
	public ScrollableResults downloadInventryUpdate(String cmtrfnum,String sellername,String ussidAndListingId,String productname) {

		ScrollableResults rs = null;
		try {
			StringBuffer buffer = new StringBuffer();
			buffer.append("select sp.sprfnum,sp.ismpbi.pbirfnum,sp.ismpbi.pbiname,sp.slrproductsku,sp.slrussid,sp.octSlr.octslrlcode from SlrProduct sp,Ismppt ppt where sp.octSlr.octslrlcode=:sellername");

			if(ussidAndListingId != null && !"".equals(ussidAndListingId)){
				buffer.append(" and (sp.slrussid ='"+ussidAndListingId+"' or sp.ismpbi.pbilistingid='"+ussidAndListingId+"')");
			}
			if(productname != null && !"".equals(productname)){
				buffer.append(" and sp.ismpbi.pbiname ='"+productname+"'");
			}	
			if(cmtrfnum != null && !"".equals(cmtrfnum)){
				buffer.append(" and ppt.ismcmt.cmtrfnum in ("+cmtrfnum+")");
			}
			buffer.append(" and ppt.ismpbi.pbirfnum=sp.ismpbi.pbirfnum");
			Query query = getStatelessSession().createQuery(buffer.toString()); 		
			query.setString("sellername", sellername);
			query.setReadOnly(true);


			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return rs;
	}

	@SuppressWarnings("unchecked")
	public ScrollableResults countSellerInventorySize(String cmtrfnum,String sellername,String ussidAndListingId,String productname) {

		ScrollableResults rs = null;
		try {
			StringBuffer buffer = new StringBuffer();
			buffer.append("select count(sp.sprfnum) from SlrProduct sp,Ismppt ppt where sp.octSlr.octslrlcode=:sellername");

			if(ussidAndListingId != null && !"".equals(ussidAndListingId)){
				buffer.append(" and (sp.slrussid ='"+ussidAndListingId+"' or sp.ismpbi.pbilistingid='"+ussidAndListingId+"')");
			}
			if(productname != null && !"".equals(productname)){
				buffer.append(" and sp.ismpbi.pbiname ='"+productname+"'");
			}	
			if(cmtrfnum != null && !"".equals(cmtrfnum)){
				buffer.append(" and ppt.ismcmt.cmtrfnum in ("+cmtrfnum+")");
			}
			buffer.append(" and ppt.ismpbi.pbirfnum=sp.ismpbi.pbirfnum");
			Query query = getStatelessSession().createQuery(buffer.toString()); 		
			query.setString("sellername", sellername);
			query.setReadOnly(true);


			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return rs;
	}
	public ScrollableResults findProductPriceDetailBySlrProd(long slrProd) {
		ScrollableResults rs = null;
		try {		
			StringBuffer buffer = new StringBuffer();	
	buffer.append("select price.sppprice,price.spofferprice,price.spphdprice,price.sppedprice,price.sppcncprice,price.sppsddprice,price.modidate from SlrProductPrice price where  price.slrProduct=:slrProd");
			Query query = getStatelessSession().createQuery(buffer.toString()); 
			query.setLong("slrProd", slrProd);
			//query.setMaxResults(1);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return rs;
	}

	public ScrollableResults findByStatusSearchCount(String sellerCode,String startDate, String endDate,String fulfillmentType,String shipmentType) {
		ScrollableResults rs = null;
		try {
			String strQuery = "";
			if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
				if(startDate.equals(endDate)){
					startDate = startDate + " 00:00:00";
					endDate = endDate + " 23:59:59";
					strQuery += "select count(*) From Ismpst pst where pst.createdate between to_date(:startDate,'dd/MM/yyyy') and to_date(:endDate,'dd/MM/yyyy') and deleted='N'";
				}else{
					strQuery += "select count(*) From Ismpst pst where pst.createdate between to_date(:startDate,'dd/MM/yyyy') and to_date(:endDate,'dd/MM/yyyy') and deleted='N'";
				}	
			}
			if(shipmentType!=null && !"".equalsIgnoreCase(shipmentType)){
				strQuery +=" and pst.deliverymode.paramrfnum=:shipmentType";
			}
			if(fulfillmentType!=null && !"".equalsIgnoreCase(fulfillmentType)){
				strQuery +=" and pst.fulfillmenttype.paramrfnum=:fulfillmentType";
			}
			if(sellerCode!=null && !"".equalsIgnoreCase(sellerCode)){
				strQuery += " and pst.sellercode=:sellerCode";
			}
			Query query = getStatelessSession().createQuery(strQuery.toString()); 
			if(startDate != null && !"".equals(startDate)){
				query.setString("startDate", startDate);
			}if(endDate != null && !"".equals(endDate)){
				query.setString("endDate", endDate);
			}
			if(shipmentType!=null && !"".equalsIgnoreCase(shipmentType)){
				query.setLong("shipmentType", new Long(shipmentType));
			}
			if(fulfillmentType!=null && !"".equalsIgnoreCase(fulfillmentType)){
				query.setLong("fulfillmentType", new Long(fulfillmentType));
			}		
			if(sellerCode != null && !"".equals(sellerCode)){
				query.setString("sellerCode", sellerCode);	
			}	
			query.setReadOnly(true);


			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		} catch (HibernateException e) {
			throw new DAOException(e);
		}	
		return rs;
	}


	public ScrollableResults findByOrderSales(String startDate,String endDate,Long status,Long octslvrfnum, String orderId, String transactionId, int from, int to,String slrcode){

		ScrollableResults rs=null;
		String queryString=" ";
		if(startDate!=null && endDate!=null )
		{			
			startDate = startDate +" 00:00:00";
			endDate = endDate +" 23:59:59";


			if(startDate.equals(endDate) ){
				/*startDate.setHours(23);
			startDate.setMinutes(59);
			startDate.setSeconds(59);*/
				startDate = startDate+"23:59:59";
			}
		}
		try {
			if(startDate != null && endDate != null && !"".equals(startDate) && !"".equals(endDate)){
				queryString = "select pst.ismpot.orderid,pst.transactionid,pst.pstskuno,pst.pstproductname,pst.pstcolour,pst.pstsize,pst.price,pst.createdate,pst.ussid,pst.ismsmt.smtdesc,pst.ismpot.ordertype.paramvalue  From Ismpst pst LEFT JOIN pst.ismpot LEFT JOIN pst.ismsmt LEFT JOIN pst.ismpot.ordertype "
						+ "where pst.createdate between to_date(:startDate,'dd/MM/yyyy HH24:MI:SS') and to_date(:endDate,'dd/MM/yyyy HH24:MI:SS') and pst.deleted='N'";
			}

			if(orderId != null && !"".equals(orderId)){
				queryString = queryString+" and pst.ismpot.orderid=:orderId";
			}
			if(transactionId != null && !"".equals(transactionId))
				queryString = queryString+" and pst.transactionid=:transactionId";

			if(octslvrfnum != null){
				queryString = queryString+" and pst.octSlv.octslvrfnum=:octslvrfnum";
			}
			if(status != null)
				queryString = queryString+" and pst.ismsmt.smtrfnum=:status";

			if(slrcode != null && !"".equals(slrcode)){
				queryString = queryString+" and pst.sellercode=:slrcode";
			}

			Query query = getStatelessSession().createQuery(queryString.toString()); 

			if(octslvrfnum != null)
				query.setLong("octslvrfnum", new Long(octslvrfnum));
			if(orderId != null && !"".equals(orderId))
				query.setString("orderId", orderId);
			if(transactionId != null && !"".equals(transactionId))
				query.setString("transactionId", transactionId);

			if(status!= null)
				query.setLong("status", status);

			if(slrcode!= null && !"".equals(slrcode))
				query.setString("slrcode", slrcode);


			if(startDate != null && endDate != null && !"".equals(startDate) && !"".equals(endDate)){
				query.setParameter("startDate", startDate);
				query.setParameter("endDate", endDate);
			}

			query.setReadOnly(true);
			query.setFirstResult(from);
			query.setMaxResults(to);


			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	} 

	public ScrollableResults findByOrderSalesCount(String startDate,String endDate,Long status,Long octslvrfnum, String orderId, String transactionId, int from, int to,String slrcode){

		ScrollableResults rs=null;
		String queryString=" ";
		if(startDate!=null && endDate!=null )
		{			

			startDate = startDate +" 00:00:00";
			endDate = endDate +" 23:59:59";

			if(startDate.equals(endDate) ){
				startDate = startDate +" 23:59:59";
			}
		}
		try {
			if(startDate != null && endDate != null && !"".equals(startDate) && !"".equals(endDate)){
				queryString = "select count(pst.pstrfnum) From Ismpst pst "
						+ "where pst.createdate between to_date(:startDate,'dd/MM/yyyy HH24:MI:SS') and to_date(:endDate,'dd/MM/yyyy HH24:MI:SS')"
						+ " and  pst.deleted='N' ";
			}

			if(orderId != null && !"".equals(orderId)){
				queryString = queryString+" and pst.ismpot.orderid=:orderId";
			}
			if(transactionId != null && !"".equals(transactionId))
				queryString = queryString+" and pst.transactionid=:transactionId";

			if(octslvrfnum != null){
				queryString = queryString+" and pst.octSlv.octslvrfnum=:octslvrfnum";
			}
			if(status != null)
				queryString = queryString+" and pst.ismsmt.smtrfnum=:status";

			if(slrcode != null && !"".equals(slrcode)){
				queryString = queryString+" and pst.sellercode=:slrcode";
			}

			Query query = getStatelessSession().createQuery(queryString.toString()); 

			if(octslvrfnum != null)
				query.setLong("octslvrfnum", new Long(octslvrfnum));
			if(orderId != null && !"".equals(orderId))
				query.setString("orderId", orderId);
			if(transactionId != null && !"".equals(transactionId))
				query.setString("transactionId", transactionId);

			if(status!= null)
				query.setLong("status", status);

			if(slrcode!= null && !"".equals(slrcode))
				query.setString("slrcode", slrcode);

			if(startDate != null && endDate != null && !"".equals(startDate) && !"".equals(endDate)){
				query.setParameter("startDate", startDate);
				query.setParameter("endDate", endDate);
			}

			query.setReadOnly(true);    	

			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}


	public ScrollableResults downloadDeatilByOrderStatus(String sellerCode,String startDate,String endDate, String fulfillmentType ,String shipmentType){	

		ScrollableResults rs=null;
		try {		
			String strQuery = "";		
			if (startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
				if(startDate.equals(endDate)){
					startDate = startDate + " 00:00:00";
					endDate = endDate + " 23:59:59";
					strQuery += "select pst.ismpot.orderid,pst.ismpot.ordertype.paramdesc,pst.ismpot.customerid,pst.ismpot.orderrefno,pst.channel.paramdesc,pst.createdate,"
							+"pst.ismsmt.createdate,pst.transactionid,pst.sellercode,pst.p1slaveid,pst.ussid,pst.pstskuno,pst.pstproductname,pst.shippingcharge,"
							+ "pst.deliverymode.paramdesc,pst.iscod,pst.transportmode,pst.fulfillmenttype.paramdesc,pst.p1logisticname,pst.returnlogisticid,"
							+ "pst.ismpot.billfirstname,pst.ismpot.billlastname,pst.ismpot.billphoneno,pst.ismpot.billaddress1,pst.ismpot.billaddress2,"
							+ "pst.ismpot.billaddress3,pst.ismpot.billcountry,pst.ismpot.billcityordistrict,pst.ismpot.billstate,pst.ismpot.billpincode"
							+ " From Ismpst pst LEFT JOIN pst.ismpot"
							+ " LEFT JOIN pst.channel"
							+ " LEFT JOIN pst.ismpot.ordertype"
							+ " LEFT JOIN pst.deliverymode"
							+ " LEFT JOIN pst.fulfillmenttype"
							+ " LEFT JOIN pst.ismsmt"
							+ " where pst.createdate between to_date(:startDate,'dd/MM/yyyy') and to_date(:endDate,'dd/MM/yyyy') and pst.deleted='N'";
				}else{

					strQuery += "select pst.ismpot.orderid,pst.ismpot.ordertype.paramdesc,pst.ismpot.customerid,pst.ismpot.orderrefno,pst.channel.paramdesc,pst.createdate,"
							+"pst.ismsmt.createdate,pst.transactionid,pst.sellercode,pst.p1slaveid,pst.ussid,pst.pstskuno,pst.pstproductname,pst.shippingcharge,"
							+ "pst.deliverymode.paramdesc,pst.iscod,pst.transportmode,pst.fulfillmenttype.paramdesc,pst.p1logisticname,pst.returnlogisticid,"
							+ "pst.ismpot.billfirstname,pst.ismpot.billlastname,pst.ismpot.billphoneno,pst.ismpot.billaddress1,pst.ismpot.billaddress2,"
							+ "pst.ismpot.billaddress3,pst.ismpot.billcountry,pst.ismpot.billcityordistrict,pst.ismpot.billstate,pst.ismpot.billpincode"
							+ " From Ismpst pst LEFT JOIN pst.ismpot"
							+ " LEFT JOIN pst.channel"
							+ " LEFT JOIN pst.ismpot.ordertype"
							+ " LEFT JOIN pst.deliverymode"
							+ " LEFT JOIN pst.fulfillmenttype"
							+ " LEFT JOIN pst.ismsmt"
							+ " where pst.createdate between to_date(:startDate,'dd/MM/yyyy') and to_date(:endDate,'dd/MM/yyyy') and pst.deleted='N'";
				}

			}
			if(shipmentType!=null && !"".equalsIgnoreCase(shipmentType)){
				strQuery +=" and pst.deliverymode.paramrfnum=:shipmentType";
			}
			if(fulfillmentType!=null && !"".equalsIgnoreCase(fulfillmentType)){
				strQuery +=" and pst.fulfillmenttype.paramrfnum=:fulfillmentType";
			}	
			if(sellerCode != null && !"".equals(sellerCode)){
				strQuery += " and pst.sellercode=:sellerCode";
			}		
			Query query = getStatelessSession().createQuery(strQuery.toString()); 
			if(startDate != null && !"".equals(startDate)){
				query.setString("startDate", startDate);
			}if(endDate != null && !"".equals(endDate)){
				query.setString("endDate", endDate);
			}	
			if(shipmentType!=null && !"".equalsIgnoreCase(shipmentType)){
				query.setLong("shipmentType", new Long(shipmentType));
			}
			if(fulfillmentType!=null && !"".equalsIgnoreCase(fulfillmentType)){
				query.setLong("fulfillmentType", new Long(fulfillmentType));
			}		
			if(sellerCode != null && !"".equals(sellerCode)){
				query.setString("sellerCode", sellerCode);

			}


			rs = query.scroll(ScrollMode.FORWARD_ONLY);


		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}

	public ScrollableResults downloadOrderCount(String sellerCode,String startDate,String endDate, String fulfillmentType ,String shipmentType){	

		ScrollableResults rs=null;
		try {		
			String strQuery = "";		
			if (startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
				if(startDate.equals(endDate)){
					startDate = startDate + " 00:00:00";
					endDate = endDate + " 23:59:59";
					strQuery += "select count(*) from Ismpst pst where pst.createdate between to_date(:startDate,'dd/MM/yyyy') and to_date(:endDate,'dd/MM/yyyy') and deleted='N'";
				}else{
					strQuery += "select count(*) from Ismpst pst where pst.createdate between to_date(:startDate,'dd/MM/yyyy') and to_date(:endDate,'dd/MM/yyyy') and deleted='N'";
				}

			}
			if(shipmentType!=null && !"".equalsIgnoreCase(shipmentType)){
				strQuery +=" and pst.deliverymode.paramrfnum=:shipmentType";
			}
			if(fulfillmentType!=null && !"".equalsIgnoreCase(fulfillmentType)){
				strQuery +=" and pst.fulfillmenttype.paramrfnum=:fulfillmentType";
			}	
			if(sellerCode!=null && !"".equalsIgnoreCase(sellerCode)){
				strQuery += " and pst.sellercode=:sellerCode";
			}		
			Query query = getStatelessSession().createQuery(strQuery.toString()); 
			if(startDate != null && !"".equals(startDate)){
				query.setString("startDate", startDate);
			}if(endDate != null && !"".equals(endDate)){
				query.setString("endDate", endDate);
			}	
			if(shipmentType!=null && !"".equalsIgnoreCase(shipmentType)){
				query.setLong("shipmentType", new Long(shipmentType));
			}
			if(fulfillmentType!=null && !"".equalsIgnoreCase(fulfillmentType)){
				query.setLong("fulfillmentType", new Long(fulfillmentType));
			}		
			if(sellerCode!=null && !"".equalsIgnoreCase(sellerCode)){
				query.setString("sellerCode", sellerCode);

			}


			rs = query.scroll(ScrollMode.FORWARD_ONLY);


		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}


	public ScrollableResults downloadReportByCondition(String cmtrfnum,String slrlcode,String ussidAndListingId) {
		ScrollableResults rs=null;
		try {
			StringBuffer buffer = new StringBuffer();
			buffer.append("select sp.sprfnum,sp.ismpbi.pbilistingid,sp.ismpbi.pbiname,sp.slrproductsku,sp.ismpbi.startdate,sp.ismpbi.enddate,sp.slrussid from SlrProduct sp,Ismppt ppt where ");

			if (slrlcode != null && !"".equals(slrlcode)) {
				buffer.append(" sp.octSlr.octslrlcode=:slrlcode");
			}


			if(ussidAndListingId != null && !"".equals(ussidAndListingId) && slrlcode != null && !"".equals(slrlcode))
			{
				buffer.append(" and (sp.slrussid ='"+ussidAndListingId+"' or sp.ismpbi.pbilistingid='"+ussidAndListingId+"')");
			}else if(ussidAndListingId != null && !"".equals(ussidAndListingId)){
				buffer.append(" (sp.slrussid ='"+ussidAndListingId+"' or sp.ismpbi.pbilistingid='"+ussidAndListingId+"')");
			}

			if(cmtrfnum != null && !"".equals(cmtrfnum))
			{
				buffer.append(" and ppt.ismcmt.cmtrfnum in ("+cmtrfnum+")");
			}
			buffer.append(" and ppt.ismpbi.pbirfnum=sp.ismpbi.pbirfnum");
			Query query = getStatelessSession().createQuery(buffer.toString()); 	

			if (slrlcode != null && !"".equals(slrlcode)) {
				query.setString("slrlcode", slrlcode);
			}
			query.setReadOnly(true);


			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return rs;
	}

	public ScrollableResults downloadReportByConditionCount(String cmtrfnum,String slrlcode,String ussidAndListingId) {
		ScrollableResults rs=null;
		try {
			StringBuffer buffer = new StringBuffer();
			buffer.append("select count(*) from SlrProduct sp,Ismppt ppt where ");

			if (slrlcode != null && !"".equals(slrlcode)) {
				buffer.append(" sp.octSlr.octslrlcode=:slrlcode");
			}


			if(ussidAndListingId != null && !"".equals(ussidAndListingId) && slrlcode != null && !"".equals(slrlcode))
			{
				buffer.append(" and (sp.slrussid ='"+ussidAndListingId+"' or sp.ismpbi.pbilistingid='"+ussidAndListingId+"')");
			}else if(ussidAndListingId != null && !"".equals(ussidAndListingId)){
				buffer.append(" (sp.slrussid ='"+ussidAndListingId+"' or sp.ismpbi.pbilistingid='"+ussidAndListingId+"')");
			}

			if(cmtrfnum != null && !"".equals(cmtrfnum))
			{
				buffer.append(" and ppt.ismcmt.cmtrfnum in ("+cmtrfnum+")");
			}
			buffer.append(" and ppt.ismpbi.pbirfnum=sp.ismpbi.pbirfnum");
			Query query = getStatelessSession().createQuery(buffer.toString()); 	

			if (slrlcode != null && !"".equals(slrlcode)) {
				query.setString("slrlcode", slrlcode);
			}

			query.setReadOnly(true);


			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return rs;
	}

	public ScrollableResults downloadByOrderStatusReport(String startDate,String endDate,String sellerCode,Long octslvrfnum,String shipmentType, String fulfillmentType, String orderId, String orderStatus,String transactionId,String ordersstatus){
		ScrollableResults rs=null;
		try {
			String strQuery="";
			if (startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
				startDate = startDate + " 00:00:00";
				endDate = endDate + " 23:59:59";
				strQuery += "select pst.octSlv.octSlr.octslrlname,pst.ismpot.orderid,pst.transactionid,pst.ussid,pst.pstskuno,pst.pstproductname,pst.pstcolour,pst.pstsize,pst.ismpot.ordertype.paramdesc,pst.ismpot.customerid,pst.channel.paramdesc,pst.createdate,pst.p1slaveid,pst.price,"
						+"pst.shippingcharge,pst.isagift,pst.giftmessage,pst.giftprice,pst.isafreebie,pst.parenttransactionid,pst.pstproductname,pst.deliverymode.paramcode,pst.subordertype,"
						+"pst.iscod,pst.transportmode,pst.fulfillmenttype.paramdesc,pst.p1logisticsid,pst.p1logisticname,pst.returnlogisticid,pst.shipemailid,pst.shipfirstname,pst.shiplastname,pst.shipphoneno,pst.shipaddress1,pst.shipaddress2,pst.shipaddress3,pst.shipcountry,"
						+"pst.shipcityordistrict,pst.shipstate,pst.shippincode,pst.ismpot.billemailid,pst.ismpot.billfirstname,pst.ismpot.billlastname,pst.ismpot.billphoneno,pst.ismpot.billaddress1,pst.ismpot.billaddress2,pst.ismpot.billaddress3,pst.ismpot.billcountry,pst.ismpot.billcityordistrict,pst.ismpot.billstate,pst.ismpot.billpincode,"
						+"pst.ismsmt.smtname,pst.shipment.awbnum,pst.shipment.octinvoice.autoGenInvoice,pst.reverseshipment.awbnum,pst.octSlvFeeder.octslvname,pst.octSlvFeeder.octslvcode ,pst.pickerPersonName,pst.pickerPersonPhone,pst.ismpot.collectionExpiryDate,pst.shipment.collectionExpiryDate,pst.shipment.menifesto.menifestorfnum,pst.shipment.menifesto.createdate"
						+ " From Ismpst pst LEFT JOIN pst.ismpot"
						+ " LEFT JOIN pst.channel" 
						+ " LEFT JOIN pst.ismpot.ordertype"
						+ " LEFT JOIN pst.octSlv.octSlr" 
						+ " LEFT JOIN pst.deliverymode"
						+ " LEFT JOIN pst.fulfillmenttype"
						+ " LEFT JOIN pst.ismsmt"
						+ " LEFT JOIN pst.shipment"
						+ " LEFT JOIN pst.shipment.octinvoice"
						+ " LEFT JOIN pst.reverseshipment"
						+ " LEFT JOIN pst.octSlvFeeder" 
						+ " LEFT JOIN pst.shipment.menifesto"
						+ " where pst.createdate between to_date(:startDate,'dd/MM/yyyy HH24:MI:SS') and to_date(:endDate,'dd/MM/yyyy HH24:MI:SS') and pst.deleted='N' ";
			}
			if(octslvrfnum != null){
				strQuery += " and pst.octSlv.octslvrfnum=:octslvrfnum ";
			}
			if(sellerCode != null && !"".equals(sellerCode)){
				strQuery += " and pst.sellercode=:sellerCode";
			}
			if(orderId != null && !"".equals(orderId)){   
				strQuery+=" and pst.ismpot.orderid=:orderId";
			}
			if(transactionId != null && !"".equals(transactionId)){
				strQuery += " and pst.transactionid=:transactionId";
			}
			if(fulfillmentType != null && !"".equals(fulfillmentType)){
				strQuery += " and pst.fulfillmenttype.paramcode=:fulfillmentType";
			}
			if(shipmentType != null && !"".equals(shipmentType)){
				if(shipmentType.equalsIgnoreCase("CNC")){
					strQuery += " and pst.subordertype=:shipmentType";
				}else{
					strQuery += " and pst.deliverymode.paramcode=:shipmentType";  
				}
			}   
			if(orderStatus !=null && !"".equals(orderStatus) && !orderStatus.equals("null")){
				strQuery += " and pst.ismsmt.smtcode=:orderStatus";
			}
			if(ordersstatus !=null && !"".equals(ordersstatus) && !ordersstatus.equals("null")){
				strQuery += " and pst.ismsmt.smtrfnum in ("+ordersstatus+")";
			}
			Query query = getStatelessSession().createQuery(strQuery.toString());   
			if(startDate != null && !"".equals(startDate)){
				query.setString("startDate", startDate);
			}if(endDate != null && !"".equals(endDate)){
				query.setString("endDate", endDate);
			}
			if(sellerCode != null && !"".equals(sellerCode)){
				query.setString("sellerCode", sellerCode);
			}
			if(orderId != null && !"".equals(orderId)){
				query.setString("orderId", orderId);
			}
			if(transactionId != null && !"".equals(transactionId)){
				query.setString("transactionId", transactionId);
			}

			if(orderStatus != null && !"".equals(orderStatus) && !orderStatus.equals("null")){
				query.setString("orderStatus", orderStatus);
			}

			if(octslvrfnum != null){
				query.setLong("octslvrfnum", new Long(octslvrfnum));
			}

			if(shipmentType != null && !"".equals(shipmentType)){
				query.setString("shipmentType", shipmentType);
			}
			if(fulfillmentType != null && !"".equals(fulfillmentType)){
				query.setString("fulfillmentType", (fulfillmentType));
			}
			query.setReadOnly(true);


			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		} 
		catch (HibernateException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ScrollableResults findAllStateOptimize(String seller, String slave, Date startDate, Date endDate,String stlSmtTState,String fulfillmentType){

		ScrollableResults rs=null;
		if(startDate!=null && endDate!=null ){			
			if(startDate.equals(endDate) ){
				endDate.setHours(23);
				endDate.setMinutes(59);
				endDate.setSeconds(59);
			}
		}
		try{

			String queryString = "select distinct(stl.ismpst.octSlv.octSlr.octslrname1),stl.ismpst.octSlv.octSlr.octslrname2,stl.ismpst.octSlv.octslvname,"
					+"stl.ismpst.octpack.opendate,stl.ismpst.ismpot.orderid,stl.ismpst.shipment.awbnum,stl.ismpst.shipment.boxname,stl.ismpst.octSlv.octslvcode,stl.ismpst.pstskuno"		
					+ " from Ismstl stl"
					+" LEFT JOIN stl.ismpst"
					+" LEFT JOIN stl.ismpst.octSlv"
					+" LEFT JOIN stl.ismpst.octSlv.octSlr"
					+" LEFT JOIN stl.ismpst.octpack"
					+" LEFT JOIN stl.ismpst.ismpot"
					+" LEFT JOIN stl.ismpst.shipment"
					+ " where stl.stlsmttstate=:stlSmtTState";

			if(startDate != null && endDate != null){
				queryString = queryString+" and stl.createdate between :startDate and :endDate";
			}
			if(seller!=null && !"".equalsIgnoreCase(seller)){
				queryString +=" and stl.ismpst.octSlv.octSlr.octslrrfnum=:seller";
			}
			if(slave!=null && !"".equalsIgnoreCase(slave)){
				queryString +=" and stl.ismpst.octSlv.octslvrfnum=:slave";
			}
			if(fulfillmentType!=null && !fulfillmentType.equalsIgnoreCase("All")){
				queryString +=" and stl.ismpst.fulfillmenttype.paramcode=:fulfillmentType";
			}else if(fulfillmentType != null && fulfillmentType.equals("All")){
				queryString +=" and stl.ismpst.fulfillmenttype.paramcode in ('TSHIP','SSHIP')";  
			}
			if("2397".equalsIgnoreCase(stlSmtTState) || "2398".equalsIgnoreCase(stlSmtTState)){
				queryString +=" and stl.ismpst.subordertype='CNC'";
			}
			Query query = getStatelessSession().createQuery(queryString.toString()); 	

			if(slave!=null && !"".equalsIgnoreCase(slave)){
				query.setLong("slave", new Long(slave));
			}
			if(startDate!=null && endDate!=null){
				query.setParameter("startDate", startDate);
				query.setParameter("endDate", endDate);
			}
			if(seller!=null  && !"".equalsIgnoreCase(seller)){
				query.setLong("seller", new Long(seller));
			}
			if(fulfillmentType!=null && !fulfillmentType.equalsIgnoreCase("All")){
				query.setString("fulfillmentType", fulfillmentType);
			}
			query.setString("stlSmtTState", stlSmtTState);
			query.setReadOnly(true);


			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		} catch(HibernateException e){
			throw new  DAOException(e);
		}
		return rs;
	}
	public ScrollableResults findAllState(String seller, String slave, Date startDate, Date endDate,String stlSmtTState,String fulfillmentType){
		ScrollableResults rs=null;
		if(startDate!=null && endDate!=null )
		{			
			if(startDate.equals(endDate) ){
				endDate.setHours(23);
				endDate.setMinutes(59);
				endDate.setSeconds(59);
			}
		}
		try{
			String queryString = "select distinct(stl.ismpst.pstrfnum),stl.ismpst.octSlv.octSlr.octslrname,stl.ismpst.ismpot.orderrefno,stl.ismpst.ismpot.orderid,stl.ismpst.transactionid,stl.ismpst.ismpot.ordertype.paramdesc,"
					+ "stl.ismpst.ussid,stl.ismpst.pstskuno,stl.ismpst.pstproductname,stl.ismpst.octSlv.octSlr.octslrrfnum,stl.ismpst.pstqty,stl.ismpst.pststyleno,stl.ismpst.pstsize,"
					+ "stl.ismpst.pstcolour,stl.ismpst.p1logisticname,stl.ismpst.shipment.awbnum,stl.ismpst.shipment.shiprfnum,stl.ismpst.price,stl.ismpst.discount,stl.ismpst.netamount,"
					+ "stl.ismpst.taxtype,stl.ismpst.taxvalue,stl.ismpst.caltaxvalue,stl.ismpst.shipment.octinvoice.autoGenInvoice,stl.ismpst.shipment.octinvoice.invoiceNo,stl.ismpst.octSlv.octslvname,"
					+ "stl.ismpst.octSlv.octslvcode,stl.ismpst.fulfillmenttype.paramcode,stl.ismpst.retPickFirstName,stl.ismpst.retPickLastName,stl.ismpst.shipfirstname,stl.ismpst.shiplastname,stl.ismpst.retPickPhoneNo,stl.ismpst.shipphoneno,stl.ismpst.retPickAddress1," //33
					+ "stl.ismpst.shipaddress1,stl.ismpst.retPickAddress2,stl.ismpst.shipaddress2,stl.ismpst.retPickPinCode,stl.ismpst.shippincode,stl.ismpst.retPickCity,stl.ismpst.shipcityordistrict,stl.ismpst.retPickState,"   //40
					+ "stl.ismpst.shipstate,stl.ismpst.ackdate,stl.ismpst.returnlogisticprovidername,stl.ismpst.reverseshipment.awbnum,stl.ismpst.octSlv.octSlvReturnSlave.octslvname,"
					+ "stl.ismpst.octSlv.octSlvReturnSlave.octslvcode,stl.ismpst.qcreasoncode,stl.ismpst.qcfailcomment,stl.ismpst.ismsmt.smtdesc,stl.ismpst.refundedAmt"
					+ " from Ismstl stl"
					+" LEFT JOIN stl.ismpst"
					+" LEFT JOIN stl.ismpst.ismpot"
					+" LEFT JOIN stl.ismpst.ismpot.ordertype"
					+" LEFT JOIN stl.ismpst.octSlv.octSlr"
					+" LEFT JOIN stl.ismpst.shipment"
					+" LEFT JOIN stl.ismpst.shipment.octinvoice"
					+" LEFT JOIN stl.ismpst.octSlv"
					+" LEFT JOIN stl.ismpst.fulfillmenttype"
					+" LEFT JOIN stl.ismpst.reverseshipment"
					+" LEFT JOIN stl.ismpst.reverseshipment"
					+" LEFT JOIN stl.ismpst.octSlv.octSlvReturnSlave"
					+" LEFT JOIN stl.ismpst.ismsmt"
					+ " where stl.stlsmttstate=:stlSmtTState";
			if(startDate != null && endDate != null){
				queryString = queryString+" and stl.createdate between :startDate and :endDate";
			}
			if(seller!=null && !"".equalsIgnoreCase(seller)){
				queryString +=" and stl.ismpst.octSlv.octSlr.octslrrfnum=:seller";
			}
			if(slave!=null && !"".equalsIgnoreCase(slave)){
				queryString +=" and stl.ismpst.octSlv.octslvrfnum=:slave";
			}
			if(fulfillmentType!=null && !fulfillmentType.equalsIgnoreCase("All")){
				queryString +=" and stl.ismpst.fulfillmenttype.paramcode=:fulfillmentType";
			}else if(fulfillmentType != null && fulfillmentType.equals("All")){
				queryString +=" and stl.ismpst.fulfillmenttype.paramcode in ('TSHIP','SSHIP')";  
			}
			//changes Required 
			if("2397".equalsIgnoreCase(stlSmtTState) || "2398".equalsIgnoreCase(stlSmtTState)){
				queryString +=" and stl.ismpst.subordertype='CNC'";
			}
			Query query = getStatelessSession().createQuery(queryString.toString()); 	
			if(slave!=null && !"".equalsIgnoreCase(slave)){
				query.setLong("slave", new Long(slave));
			}
			if(startDate!=null && endDate!=null){
				query.setParameter("startDate", startDate);
				query.setParameter("endDate", endDate);
			}
			if(seller!=null  && !"".equalsIgnoreCase(seller)){
				query.setLong("seller", new Long(seller));
			}
			if(fulfillmentType!=null && !fulfillmentType.equalsIgnoreCase("All")){
				query.setString("fulfillmentType", fulfillmentType);
			}
			query.setString("stlSmtTState", stlSmtTState);
			query.setReadOnly(true);
			query.setFetchSize(1);


			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		} catch(HibernateException e){
			throw new  DAOException(e);
		}
		return rs;
	}

	public ScrollableResults findSlrProductDetail(String ussid) {
		ScrollableResults rs = null;
		try {

			StringBuffer buffer = new StringBuffer();
			buffer.append("select sp.sprfnum,sp.ismpbi.pbilistingid,sp.ismpbi.pbiname,sp.ismpbi.pbirfnum");
			buffer.append(" from SlrProduct sp");
			buffer.append(" LEFT JOIN sp.ismpbi");
			buffer.append(" where sp.slrussid=:ussid");
			Query query = getStatelessSession().createQuery(buffer.toString()); 
			query.setString("ussid", ussid.trim());


			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return rs;
	}

	public ScrollableResults findPPtDetailByPbi(String pbirfnum) {
		ScrollableResults rs = null;
		try {
			StringBuffer buffer = new StringBuffer();
			buffer.append("select ppt.ismcmt.cmtrfnum");
			buffer.append(" from Ismppt ppt");
			buffer.append(" LEFT JOIN ppt.ismcmt");
			buffer.append(" where ppt.ismpbi.pbirfnum=:pbirfnum");
			Query query = getStatelessSession().createQuery(buffer.toString()); 
			query.setLong("pbirfnum",new Long(pbirfnum));


			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return rs;
	}

	public ScrollableResults findCPTDetailByCmt(String cmtrfnum) {
		ScrollableResults rs = null;
		try {
			StringBuffer buffer = new StringBuffer();
			buffer.append("select cpt.ismcmtByCptcmtrfnum1.cmtname,cpt.ismcmtByCptcmtrfnum.cmtname");
			buffer.append(" from Ismcpt cpt");
			buffer.append(" LEFT JOIN cpt.ismcmtByCptcmtrfnum1");
			buffer.append(" LEFT JOIN cpt.ismcmtByCptcmtrfnum");
			buffer.append(" where cpt.ismcmtByCptcmtrfnum.cmtrfnum=:cmtrfnum and cpt.ismcmtByCptcmtrfnum1.cmtisactive = 'Y'");
			Query query = getStatelessSession().createQuery(buffer.toString()); 
			query.setLong("cmtrfnum",new Long(cmtrfnum));


			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return rs;
	}
	
	public ScrollableResults findSellerGstOrders(String startDate, String endDate, List<String> slrLst,
			List<Long> lstSlv, String shipmentType, String fulfillmentType, String orderId, String orderStatus,
			String transactionId, int from, int to, String ordersstaus) {
		String strQuery = null;
		ScrollableResults rs = null;
		try {
			strQuery = "from Ismpst pst where pst.shipGSTNumber is not null ";
			if (slrLst != null && slrLst.size() > 0) {
				strQuery += " and pst.sellercode in(:slrLst) ";
			}
			if (startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
				startDate = startDate + " 00:00:00";
				endDate = endDate + " 23:59:59";
				strQuery += " and pst.createdate between to_date(:startDate,'dd/MM/yyyy HH24:MI:SS') and to_date(:endDate,'dd/MM/yyyy HH24:MI:SS') and pst.deleted='N' ";
			}
			
			if (orderStatus != null && !"".equals(orderStatus) && !orderStatus.equals("null")
					&& !"All".equals(orderStatus))
			{
				strQuery += " and pst.ismsmt.smtcode=:orderStatus";
			}
			Query query = getStatelessSession().createQuery(strQuery.toString());
			if(slrLst != null && slrLst.size()>0){
				query.setParameterList("slrLst", slrLst);
			}
			if (startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
				query.setString("startDate", startDate);
				query.setString("endDate", endDate);
			}
			if (orderStatus != null && !"".equals(orderStatus) && !orderStatus.equals("null")
					&& !"All".equals(orderStatus))
			{
				query.setString("orderStatus", orderStatus);
			}
			
			
			query.setReadOnly(true);
			query.setFirstResult(from);
			query.setMaxResults(to);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ScrollableResults findByOrderStatus(String startDate,String endDate,List<String>slrLst,List<Long>lstSlv,String shipmentType, String fulfillmentType, String orderId, String orderStatus,String transactionId, int from, int to,String ordersstaus, String inScan, String dateType){	
		ScrollableResults rs = null;
		List retvalList = null;
		String deliveryStartDate = null;
		String deliveryEndDate = null;
		try {
			String strQuery="";	
			if (startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
				startDate = startDate + " 00:00:00";
				endDate = endDate + " 23:59:59";
				
				deliveryStartDate = Utils.formatDate(startDate, "dd-MM-yyyy HH:mm:ss", "yyyy-MM-dd HH:mm:ss");
				deliveryEndDate = Utils.formatDate(endDate, "dd-MM-yyyy HH:mm:ss", "yyyy-MM-dd HH:mm:ss");
				
				strQuery += "select distinct pst.ismpot.orderid,pst.transactionid,pst.pstskuno,pst.pstproductname,pst.pstcolour,pst.pstsize,pst.ismsmt.smtname,pst.price,pst.ismpot.createdate,pst.ussid,pst.ismpot.ordertype.paramvalue"
						+ " From Ismpst pst "
						+ " LEFT JOIN pst.ismstls stl"
						+ " LEFT JOIN pst.ismpot"
						+ " LEFT JOIN pst.ismsmt"
						+ " LEFT JOIN pst.ismpot.ordertype"
						+ " where pst.deleted='N' ";
			}
			if(lstSlv !=null && lstSlv.size()>0){
				strQuery += " and pst.octSlv.octslvrfnum in(:lstSlv) ";
			}
			if(slrLst != null && slrLst.size()>0){
				strQuery += " and pst.sellercode in(:slrLst)";
			}

			if(orderId != null && !"".equals(orderId))
			{	
				strQuery+=" and pst.ismpot.orderid=:orderId";
			}
			if(transactionId != null && !"".equals(transactionId)){
				strQuery += " and pst.transactionid=:transactionId";
			}

			if(fulfillmentType != null && !"".equals(fulfillmentType)){
				strQuery += " and pst.fulfillmenttype.paramcode=:fulfillmentType";}
			if(shipmentType != null && !"".equals(shipmentType)){
				if(shipmentType.equalsIgnoreCase("CNC")){
					strQuery += " and pst.subordertype=:shipmentType";
				}else{
					strQuery += " and pst.deliverymode.paramcode=:shipmentType";
				}
			}	
			if(orderStatus !=null && !"".equals(orderStatus) && !orderStatus.equals("null"))
			{
				strQuery += " and pst.ismsmt.smtcode=:orderStatus";
			}
			if(ordersstaus !=null && !"".equals(ordersstaus) && !ordersstaus.equals("null"))
			{
				strQuery += " and pst.ismsmt.smtrfnum in ("+ordersstaus+")";
			}
			if(inScan !=null && !"".equals(inScan) && !inScan.equals("null"))
			{
				strQuery += " and pst.inScan=:inScan";
			}
			
			if(dateType!= null) {
				if(dateType.equals("OrderDate")) {
					strQuery += " and pst.createdate between to_date(:startDate,'dd/MM/yyyy HH24:MI:SS') and to_date(:endDate,'dd/MM/yyyy HH24:MI:SS')";
				}
				if(dateType.equals("InscanDate")) {
					strQuery += " and pst.inScanDate between to_date(:startDate,'dd/MM/yyyy HH24:MI:SS') and to_date(:endDate,'dd/MM/yyyy HH24:MI:SS')";
					
				}else if(dateType.equals("DeliveryDate")) {
					strQuery += " and to_date(pst.deliverydate, 'YYYY-MM-DD HH24:MI:SS') >= to_date(:deliveryStartDate, 'YYYY-MM-DD HH24:MI:SS') and to_date(pst.deliverydate, 'YYYY-MM-DD HH24:MI:SS') <= to_date(:deliveryEndDate, 'YYYY-MM-DD HH24:MI:SS')";

				}else if(dateType.equals("RTOInitiatedDate")) {
					strQuery += " and pst.pstrfnum = stl.ismpst.pstrfnum and stl.createdate between to_date(:startDate,'dd/MM/yyyy HH24:MI:SS') and to_date(:endDate,'dd/MM/yyyy HH24:MI:SS') and stl.stlsmttstate = 2434";
				
				}else if(dateType.equals("CancellationDate")) {
					strQuery += " and pst.pstrfnum = stl.ismpst.pstrfnum and stl.createdate between to_date(:startDate,'dd/MM/yyyy HH24:MI:SS') and to_date(:endDate,'dd/MM/yyyy HH24:MI:SS') and stl.stlsmttstate in (2243, 2244, 2619)";

				}
			}	
			Query query = getStatelessSession().createQuery(strQuery.toString()); 
			
			if(dateType.equals("DeliveryDate")) {
				if(deliveryStartDate != null && !"".equals(deliveryStartDate)){
					query.setString("deliveryStartDate", deliveryStartDate);
				}if(deliveryEndDate != null && !"".equals(deliveryEndDate)){
					query.setString("deliveryEndDate", deliveryEndDate);
				}
			}else {
				if(startDate != null && !"".equals(startDate)){
					query.setString("startDate", startDate);
				}if(endDate != null && !"".equals(endDate)){
					query.setString("endDate", endDate);
				}
			}
			if(orderId != null && !"".equals(orderId)){
				query.setString("orderId", orderId);
			}
			if(transactionId != null && !"".equals(transactionId)){
				query.setString("transactionId", transactionId);
			}

			if(orderStatus != null && !"".equals(orderStatus) && !orderStatus.equals("null")){
				query.setString("orderStatus", orderStatus);
			}
			if(inScan != null && !"".equals(inScan) && !inScan.equals("null")){
				query.setString("inScan", inScan);
			}
			if(slrLst != null && !slrLst.isEmpty()){
				query.setParameterList("slrLst", slrLst);
			}
			if(lstSlv != null && !lstSlv.isEmpty()){
				query.setParameterList("lstSlv", lstSlv);
			}

			if(shipmentType != null && !"".equals(shipmentType)){
				query.setString("shipmentType", shipmentType);
			}
			if(fulfillmentType != null && !"".equals(fulfillmentType)){
				query.setString("fulfillmentType", (fulfillmentType));
			}

			query.setReadOnly(true);
			query.setFirstResult(from);
			query.setMaxResults(to);


			rs = query.scroll(ScrollMode.FORWARD_ONLY);


		} 
		catch (HibernateException | ParseException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public ScrollableResults findByOrderStatusCount(String startDate,String endDate,String sellerCode,Long octslvrfnum,String shipmentType, String fulfillmentType, String orderId, String orderStatus,String transactionId ,String ordersstaus){	
		ScrollableResults rs = null;

		try {
			String strQuery="";	
			if (startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
				startDate = startDate + " 00:00:00";
				endDate = endDate + " 23:59:59";
				strQuery += "select count(pst.pstrfnum)"
						+ " From Ismpst pst"
						+ " LEFT JOIN pst.ismpot"
						+ " LEFT JOIN pst.ismsmt"
						+ " LEFT JOIN pst.ismpot.ordertype"
						+ " LEFT JOIN pst.ismstl.stlpstrfnum "
						+ " where pst.createdate between to_date(:startDate,'dd/MM/yyyy HH24:MI:SS') and to_date(:endDate,'dd/MM/yyyy HH24:MI:SS') and pst.deleted='N' ";
			}
			if(octslvrfnum != null){
				strQuery += " and pst.octSlv.octslvrfnum=:octslvrfnum ";
			}
			if(sellerCode != null && !"".equals(sellerCode)){
				strQuery += " and pst.sellercode=:sellerCode";
			}
			if(orderId != null && !"".equals(orderId))
			{	
				strQuery+=" and pst.ismpot.orderid=:orderId";
			}
			if(transactionId != null && !"".equals(transactionId)){
				strQuery += " and pst.transactionid=:transactionId";
			}

			if(fulfillmentType != null && !"".equals(fulfillmentType)){
				strQuery += " and pst.fulfillmenttype.paramcode=:fulfillmentType";}
			if(shipmentType != null && !"".equals(shipmentType)){
				if(shipmentType.equalsIgnoreCase("CNC")){
					strQuery += " and pst.subordertype=:shipmentType";
				}else{
					strQuery += " and pst.deliverymode.paramcode=:shipmentType";
				}
			}	
			if(orderStatus !=null && !"".equals(orderStatus) && !orderStatus.equals("null"))
			{
				strQuery += " and pst.ismsmt.smtcode=:orderStatus";
			}
			if(ordersstaus !=null && !"".equals(ordersstaus) && !ordersstaus.equals("null"))
			{
				strQuery += " and pst.ismsmt.smtrfnum in ("+ordersstaus+")";
			}
			Query query = getStatelessSession().createQuery(strQuery.toString()); 
			if(startDate != null && !"".equals(startDate)){
				query.setString("startDate", startDate);
			}if(endDate != null && !"".equals(endDate)){
				query.setString("endDate", endDate);
			}
			if(sellerCode != null && !"".equals(sellerCode)){
				query.setString("sellerCode", sellerCode);
			}
			if(orderId != null && !"".equals(orderId)){
				query.setString("orderId", orderId);
			}
			if(transactionId != null && !"".equals(transactionId)){
				query.setString("transactionId", transactionId);
			}

			if(orderStatus != null && !"".equals(orderStatus) && !orderStatus.equals("null")){
				query.setString("orderStatus", orderStatus);
			}

			if(octslvrfnum != null){
				query.setLong("octslvrfnum", new Long(octslvrfnum));
			}

			if(shipmentType != null && !"".equals(shipmentType)){
				query.setString("shipmentType", shipmentType);
			}
			if(fulfillmentType != null && !"".equals(fulfillmentType)){
				query.setString("fulfillmentType", (fulfillmentType));
			}
			query.setReadOnly(true);


			rs = query.scroll(ScrollMode.FORWARD_ONLY);


		} 
		catch (HibernateException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public ScrollableResults findDeatilByOrder(String sellerCode,String startDate,String endDate, String fulfillmentType ,String shipmentType, int from, int max){	

		ScrollableResults rs=null;
		try {		
			String strQuery = "";		
			if (startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
				if(startDate.equals(endDate)){
					startDate = startDate + " 00:00:00";
					endDate = endDate + " 23:59:59";
					strQuery += "select pst.ismpot.orderrefno,pst.ismpot.orderid,pst.transactionid,pst.ussid,pst.pstskuno,pst.shippingcharge"
							+ " From Ismpst pst LEFT JOIN pst.ismpot"
							+ " where pst.createdate between to_date(:startDate,'dd/MM/yyyy') and to_date(:endDate,'dd/MM/yyyy') and pst.deleted='N'";
				}else{
					strQuery += "select pst.ismpot.orderrefno,pst.ismpot.orderid,pst.transactionid,pst.ussid,pst.pstskuno,pst.shippingcharge"
							+ " From Ismpst pst LEFT JOIN pst.ismpot"
							+ " where pst.createdate between to_date(:startDate,'dd/MM/yyyy') and to_date(:endDate,'dd/MM/yyyy') and pst.deleted='N'";
				}

			}
			if(shipmentType!=null && !"".equalsIgnoreCase(shipmentType)){
				strQuery +=" and pst.deliverymode.paramrfnum=:shipmentType";
			}
			if(fulfillmentType!=null && !"".equalsIgnoreCase(fulfillmentType)){
				strQuery +=" and pst.fulfillmenttype.paramrfnum=:fulfillmentType";
			}	
			if(sellerCode != null && !"".equals(sellerCode)){
				strQuery += " and pst.sellercode=:sellerCode";
			}		
			Query query = getStatelessSession().createQuery(strQuery.toString()); 
			if(startDate != null && !"".equals(startDate)){
				query.setString("startDate", startDate);
			}if(endDate != null && !"".equals(endDate)){
				query.setString("endDate", endDate);
			}	
			if(shipmentType!=null && !"".equalsIgnoreCase(shipmentType)){
				query.setLong("shipmentType", new Long(shipmentType));
			}
			if(fulfillmentType!=null && !"".equalsIgnoreCase(fulfillmentType)){
				query.setLong("fulfillmentType", new Long(fulfillmentType));
			}		
			if(sellerCode != null && !"".equals(sellerCode)){
				query.setString("sellerCode", sellerCode);

			}
			query.setReadOnly(true);
			query.setFirstResult(from);
			query.setMaxResults(max);


			rs = query.scroll(ScrollMode.FORWARD_ONLY);


		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}

	public ScrollableResults SshipPincodeMasterDetail(String slrRfNum) {
		ScrollableResults rs = null;
		try {
			StringBuffer buffer = new StringBuffer();
			buffer.append("select pm.formrequiredair,pm.pincode,pm.countryMaster.description,pm.countryMaster.countrycode,pm.stateMaster.statecode,");
			buffer.append("pm.cityMaster.description,pm.codavailable,pm.transportmode,pm.prepaidlimitair,pm.codlimitair,");
			buffer.append("pm.formrequiredair,pm.returnflagair,pm.formrequiredsur,pm.prepaidlimitsur,pm.codlimitsur,");
			buffer.append("pm.returnflagsur,pm.deliveryTatAir,pm.deliveryTatSur,pm.deliveryTat,pm.slaveCode");
			buffer.append(" from SshipPincodeMaster pm");
			buffer.append(" LEFT JOIN pm.countryMaster");
			buffer.append(" LEFT JOIN pm.stateMaster");
			buffer.append(" where pm.octSlr.octslrrfnum=:slrrfnum");
			Query query = getStatelessSession().createQuery(buffer.toString()); 
			query.setLong("slrrfnum",new Long(slrRfNum));


			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return rs;
	}
	public ScrollableResults SshipPincodeMasterDetailCount(String slrRfNum) {
		ScrollableResults rs = null;
		try {
			StringBuffer buffer = new StringBuffer();
			buffer.append("select count(pm.spcrfnum)");
			buffer.append(" from SshipPincodeMaster pm");
			buffer.append(" LEFT JOIN pm.countryMaster");
			buffer.append(" LEFT JOIN pm.stateMaster");
			buffer.append(" where pm.octSlr.octslrrfnum=:slrrfnum");
			Query query = getStatelessSession().createQuery(buffer.toString()); 
			query.setLong("slrrfnum",new Long(slrRfNum));


			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return rs;
	}


	public ScrollableResults downloadReportItemSearch(String sellerCode, Date startDate, Date endDate) {

		ScrollableResults rs = null;
		if(startDate!=null && endDate!=null ){			
			if(startDate.equals(endDate) ){
				endDate.setHours(23);
				endDate.setMinutes(59);
				endDate.setSeconds(59);
			}
		}
		try {
			String strQuery="";
			if( startDate!= null && endDate!= null){
				strQuery += "select pst.pstrfnum,pst.octSlv.octSlr.octslrlname,pst.ismpot.orderid,pst.pstproductname,pst.pstcolour,pst.pstsize,"
						+ "pst.transactionid,pst.ussid,pst.pstskuno,pst.price,pst.shippingcharge,"
						+ "pst.netamount,pst.totalammount"
						+ " from Ismpst pst"
						+ " LEFT JOIN pst.octSlv.octSlr"
						+ " LEFT JOIN pst.ismpot"
						+ " where  pst.createdate between :startDate and :endDate";
			}
			if( sellerCode!= null && !"".equals(sellerCode)){
				strQuery += " and pst.sellercode=:sellerCode";
			}
			Query query = getStatelessSession().createQuery(strQuery.toString()); 
			if(sellerCode != null && !"".equals(sellerCode)){
				query.setString("sellerCode", sellerCode);
			}
			if(startDate != null || endDate != null){
				query.setTimestamp("startDate", startDate);
				query.setTimestamp("endDate", endDate);
			}
			if(sellerCode != null && !"".equals(sellerCode)){
				query.setString("sellerCode", sellerCode);
			}


			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}


	public ScrollableResults findOctTrxnCommisionByIsmpst(Long pstrfnum) {
		ScrollableResults rs = null;
		try {
			StringBuffer buffer = new StringBuffer();
			buffer.append("select otc.trxncalccommval from OctTrxnCommision otc where  otc.ismpst.pstrfnum=:pstrfnum ");
			Query query = getStatelessSession().createQuery(buffer.toString()); 
			query.setLong("pstrfnum",pstrfnum);


			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return rs;
	}

	public ScrollableResults findTrxnPromoByIsmpst(Long pstrfnum) {
		ScrollableResults rs = null;
		try {
			StringBuffer buffer = new StringBuffer();
			buffer.append("select promo.tatareimbursement from OctTrxnPromo promo where promo.ismpst.pstrfnum=:pstrfnum");
			Query query = getStatelessSession().createQuery(buffer.toString()); 
			query.setLong("pstrfnum",pstrfnum);


			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return rs;
	}

	public ScrollableResults downloadReportItemSearchCount(String sellerCode, Date startDate, Date endDate) {

		ScrollableResults rs = null;
		if(startDate!=null && endDate!=null ){			
			if(startDate.equals(endDate) ){
				endDate.setHours(23);
				endDate.setMinutes(59);
				endDate.setSeconds(59);
			}
		}
		try {
			String strQuery="";
			if( startDate!= null && endDate!= null){
				strQuery += "select count(pst.pstrfnum)"
						+ " from Ismpst pst where  pst.createdate between :startDate and :endDate"
						+ " LEFT JOIN pst.octSlv.octSlr"
						+ " LEFT JOIN pst.ismpot";
			}
			if( sellerCode!= null && !"".equals(sellerCode)){
				strQuery += " and pst.sellercode=:sellerCode";
			}
			Query query = getStatelessSession().createQuery(strQuery.toString()); 
			if(sellerCode != null && !"".equals(sellerCode)){
				query.setString("sellerCode", sellerCode);
			}
			if(startDate != null || endDate != null){
				query.setTimestamp("startDate", startDate);
				query.setTimestamp("endDate", endDate);
			}
			if(sellerCode != null && !"".equals(sellerCode)){
				query.setString("sellerCode", sellerCode);
			}


			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}

	public ScrollableResults getErrorMsgForRejected(long slrProductList) {
		ScrollableResults rs = null;
		try {

			StringBuffer buffer = new StringBuffer();
			buffer.append("select msg.msgdesc from SlrProductListdelistMsg msg where msg.slrProductList=:slrProductList order by msg.modidate desc ");
			Query query = getStatelessSession().createQuery(buffer.toString()); 
			query.setLong("slrProductList", slrProductList);
			query.setMaxResults(1);


			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch( HibernateException e){
			throw new  DAOException( e );
		}

		return rs;
	}

	@SuppressWarnings("unchecked")
	public ScrollableResults getLast15DaysPriceAndInventoryReport(String slrrfnum, List<String> bulTypes, String startDate, String endDate) {

		ScrollableResults rs = null;
		try {
			StringBuffer buffer = new StringBuffer();
			buffer.append("select bul.octslr.octslrlcode,bul.octslr.octslrlname,bul.bultype.paramcode,bul.createdate from BulkuploadLog bul "
					+ "where bul.deleted='N' and bul.bultype.paramcode in(:bulTypes)");
			buffer.append("  and bul.createdate between to_date(:startDate,'dd-MM-yyyy') and to_date(:endDate,'dd-MM-yyyy')");
			if(slrrfnum != null && !"".equals(slrrfnum)) {
				buffer.append(" and bul.octslr.octslrrfnum=:slrrfnum");
			}
			buffer.append(" order by bul.createdate desc");
			Query query = getStatelessSession().createQuery(buffer.toString());
			if(slrrfnum != null && !"".equals(slrrfnum))
				query.setLong("slrrfnum", new Long(slrrfnum));
			if(bulTypes != null && bulTypes.size() > 0)
				query.setParameterList("bulTypes", bulTypes);
			if(startDate != null && !"".equals(startDate)){
				query.setString("startDate", startDate);
			}if(endDate != null && !"".equals(endDate)){
				query.setString("endDate", endDate);
			}	
			query.setReadOnly(true);


			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return rs;
	}

	@SuppressWarnings("unchecked")
	public ScrollableResults getLast15DaysPriceAndInventoryReportCount(String slrrfnum, List<String> bulTypes, String startDate, String endDate) {
		ScrollableResults rs = null;
		try {

			StringBuffer buffer = new StringBuffer();
			buffer.append("select count(bul.bulrfnum) from BulkuploadLog bul where bul.deleted='N' and bul.bultype.paramcode in(:bulTypes)");
			buffer.append("  and bul.createdate between to_date(:startDate,'dd-MM-yyyy') and to_date(:endDate,'dd-MM-yyyy')");
			if(slrrfnum != null && !"".equals(slrrfnum)) {
				buffer.append(" and bul.octslr.octslrrfnum=:slrrfnum");
			}

			Query query = getStatelessSession().createQuery(buffer.toString());
			if(slrrfnum != null && !"".equals(slrrfnum))
				query.setLong("slrrfnum", new Long(slrrfnum));
			if(bulTypes != null && bulTypes.size() > 0)
				query.setParameterList("bulTypes", bulTypes);
			if(startDate != null && !"".equals(startDate)){
				query.setString("startDate", startDate);
			}if(endDate != null && !"".equals(endDate)){
				query.setString("endDate", endDate);
			}	
			query.setReadOnly(true);


			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return rs;
	}

	public ScrollableResults  findByUssid(String ussId) {
		ScrollableResults rs = null;

		try {
			String queryString = "select sp.ismpbi.pbilistingid from SlrProduct sp where sp.slrussid='"+ussId.trim()+"'";
			Query query = getStatelessSession().createQuery(queryString);
			//StringBuffer buffer = new StringBuffer();
			query.setReadOnly(true);

			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return rs;
	}	

	public ScrollableResults  findPackingDetails(String shipmentType,String deliveryMode,String slave,String sellerCode,String state,String pickId,List potList) {

		ScrollableResults rs = null;
		try {
			String queryString = "select pst.pstrfnum,pst.ismpot.potrfnum,pst.fulfillmenttype.paramcode,pst.deliverymode.paramcode,pst.subordertype," //5
					+ "pst.p1logisticsid,pst.packLimitAmt,pst.price,pst.discount,pst.shipaddress1," //10
					+ "pst.shipaddress2,pst.shipaddress3,pst.shipcityordistrict,pst.shippincode,pst.shipstate," //15
					+ "pst.ismpot.orderid,pst.p1logisticname,pst.iscod,pst.pstproductname,pst.productimageurl," //20
					+ "pst.pstskuno,pst.pststyleno,pst.pstsize,pst.pstcolour,pst.mrp," //25
					+ "pst.pstimei1,pst.pstimei2,pst.pstsrno,pst.transactionid,pst.isimeireq," //30
					+ "pst.transportmode,pst.p1logisticsid," //31
					+ "pst.octSlv.octSlr.isSealVisible,pst.l1catCode,pst.pstpancardpath,pst.ismpot.orderrefno,pst.PANCARDVerificationReq," //32,33,34,35,36
					+ "pst.shipfirstname,pst.shiplastname,pst.shippincode,pst.shipcityordistrict,pst.shipstate,pst.pstGstStateCode," //37-42
	   				    + "pst.sellerDiscount,pst.tataDiscount,pst.l4catCode,pst.isPlasticBan,pst.predictionHOTC,pst.sellercode,pst.ussid, "
	   				    + "pst.isFragile, pst.isPrecious, pst.storeFront, pst.isafreebie"//@Nishant 43-52 //@Deepak Deshekar ::45 //Shankar : TPR-9982 ::46  //Sumesh - SCF2-813
	   				    + " from Ismpst pst left join pst.ismpot left join pst.fulfillmenttype left join pst.deliverymode where pst.deleted='N'";	

			       if(deliveryMode !=null && !"All".equals(deliveryMode) && !"BRH".equals(deliveryMode)){

				if("CNC".equals(deliveryMode)) {
					queryString += "and pst.subordertype=:deliveryMode ";
				} else {
					queryString +=" and (pst.deliverymode.paramcode=:deliveryMode and pst.subordertype!='CNC')";
				}
			}
			if(state != null){
				queryString += "and pst.ismsmt.smtcode=:state ";
			}
			if(shipmentType != null){
				queryString +="and pst.fulfillmenttype.paramcode=:shipmentType ";
			}
			if(slave != null){
				queryString +=" and pst.octSlv.octslvrfnum=:slave ";
			}

			if(sellerCode != null){
				queryString +="and pst.sellercode=:sellerCode ";
			}

			if(pickId != null){
				if(!pickId.equals("0")){
					queryString += "and pst.octpick.pickrfnum=:pickId ";
				}else{
					queryString += "and pst.octpick.pickrfnum is null ";
				}
			}
		   			
		   			//TPR-12385
					if("BRH".equals(deliveryMode)){
						queryString += "and day(predictionHOTC-sysdate())<=0 and hour(predictionHOTC-sysdate())<=0";
					}
		   			
			if(potList!=null && !potList.isEmpty())/*pack load more*/
				queryString += " and pst.ismpot.potrfnum In(:potList) ";

			queryString += " order by pst.ismpot.potrfnum asc,pst.ismpot.modidate asc, pst.price asc";

			Query query = getStatelessSession().createQuery(queryString);

		   			if(deliveryMode !=null && !"All".equals(deliveryMode) && !"BRH".equals(deliveryMode)){
				query.setString("deliveryMode",deliveryMode);
			}
			if(state != null){
				query.setString("state",state);
			}
			if(shipmentType != null){
				query.setString("shipmentType",shipmentType);
			}
			if(slave != null){
				query.setString("slave",slave);
			}

			if(sellerCode != null){
				query.setString("sellerCode",sellerCode);
			}

			if(pickId != null  && !pickId.equals("0")){
				query.setString("pickId",pickId);
			}

			if(potList!=null && !potList.isEmpty())
				query.setParameterList("potList", potList);

			query.setReadOnly(true);

			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return rs;
	}

	public ScrollableResults findByTransactionId(String transactionid){
		ScrollableResults rs = null;
		try {
			String queryString = "select stl.createdate,stl.stlsmttstate ,stl.stlremark from Ismstl stl where stl.ismpst.transactionid=:transactionid order by  stl.createdate desc ";
			Query query = getStatelessSession().createQuery(queryString);
			query.setString("transactionid", transactionid);
			query.setReadOnly(true);

			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		}catch(HibernateException e) {
		}
		return rs;
	}

	public ScrollableResults findbyBrandValueByUssid(String usssid) {

		ScrollableResults rs = null;
		try {
			String queryString = "select alname from  AttrLov where alcode in(select spad.spadvalue from SlrProdAttrData spad where spad.spadsprfnum.slrussid=:usssid and spad.attrMstr.amcode='brand')";
			Query query = getStatelessSession().createQuery(queryString);
			query.setString("usssid", usssid);
			query.setReadOnly(true);

			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch( HibernateException e){
			throw new DAOException( e );
		}
		return rs;
	}	


	@SuppressWarnings("unchecked")
	public ScrollableResults downloadInventryReport(String cmtrfnum,String slvcode,String ussidAndListingId,String productname) {

		ScrollableResults rs = null;
		try {
			StringBuffer buffer = new StringBuffer();
			buffer.append("select vpm.slrProduct.ismpbi.pbiname,vpm.slrProduct.slrproductsku,vpm.slrProduct.slrussid,vpm.slrProduct.octSlr.octslrlcode,"
					+ "vpm.vpmpilstockqty,vpm.vpmsafetystock,vpm.vpmmodidate from Ismvpm vpm,Ismppt ppt where vpm.octslv.octslvcode=:slvcode");

			if(ussidAndListingId != null && !"".equals(ussidAndListingId)){
				buffer.append(" and (vpm.slrProduct.slrussid=:ussidAndListingId or vpm.slrProduct.ismpbi.pbilistingid=:ussidAndListingId)");
			}
			if(productname != null && !"".equals(productname)){
				buffer.append(" and vpm.slrProduct.ismpbi.pbiname=:productname");
			}	
			if(cmtrfnum != null && !"".equals(cmtrfnum)){
				buffer.append(" and ppt.ismcmt.cmtrfnum in ("+cmtrfnum+")");
			}
			buffer.append(" and ppt.ismpbi.pbirfnum=vpm.slrProduct.ismpbi.pbirfnum");
			Query query = getStatelessSession().createQuery(buffer.toString()); 		
			query.setString("slvcode", slvcode);
			if(ussidAndListingId != null && !"".equals(ussidAndListingId))
				query.setString("ussidAndListingId", ussidAndListingId);
			if(productname != null && !"".equals(productname))
				query.setString("productname", productname);
			query.setReadOnly(true);


			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return rs;
	}

	@SuppressWarnings("unchecked")
	public ScrollableResults countDownloadInventryReport(String cmtrfnum,String slvcode,String ussidAndListingId,String productname) {

		ScrollableResults rs = null;
		try {
			StringBuffer buffer = new StringBuffer();
			buffer.append("select count(*) from Ismvpm vpm,Ismppt ppt where vpm.octslv.octslvcode=:slvcode");

			if(ussidAndListingId != null && !"".equals(ussidAndListingId)){
				buffer.append(" and (vpm.slrProduct.slrussid=:ussidAndListingId or vpm.slrProduct.ismpbi.pbilistingid=:ussidAndListingId)");
			}
			if(productname != null && !"".equals(productname)){
				buffer.append(" and vpm.slrProduct.ismpbi.pbiname=:productname");
			}	
			if(cmtrfnum != null && !"".equals(cmtrfnum)){
				buffer.append(" and ppt.ismcmt.cmtrfnum in ("+cmtrfnum+")");
			}
			buffer.append(" and ppt.ismpbi.pbirfnum=vpm.slrProduct.ismpbi.pbirfnum");
			Query query = getStatelessSession().createQuery(buffer.toString()); 		
			query.setString("slvcode", slvcode);
			if(ussidAndListingId != null && !"".equals(ussidAndListingId))
				query.setString("ussidAndListingId", ussidAndListingId);
			if(productname != null && !"".equals(productname))
				query.setString("productname", productname);
			query.setReadOnly(true);


			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return rs;
	}

	public ScrollableResults findBySeller(Long sellerId){

		ScrollableResults rs = null;
		try {
			StringBuffer buffer = new StringBuffer();
			buffer.append("select spl.slrpbiname,spl.slrpbiskucode from SlrPbi spl");
			buffer.append(" LEFT JOIN spl.slrProductList.octSlr");
			buffer.append(" where spl.slrProductList.octSlr.octslrrfnum=:sellerId");
			Query query = getStatelessSession().createQuery(buffer.toString()); 	
			query.setLong("sellerId", sellerId);
			query.setReadOnly(true);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		}catch( HibernateException e){
			throw new  DAOException( e );
		}

		return rs;
	}



	//GST : slrp.slrHSNCode added in query
	public ScrollableResults  findBySlrProductListptimize(Long cmtrfnum,Long sellerrfnum) 
	{
		ScrollableResults rs = null;
		try{
			StringBuffer buffer = new StringBuffer();
			buffer.append("select slrp.sprfnum,slrp.slrproductsku,slrp.ismpbi.pbiidentitycode.paramcode,slrp.ismpbi.pbiidentityvalue,slrp.startdate,slrp.enddate,slrp.ismpbi.pbilistingid,slrp.slrHSNCode,slrp.slrLength,slrp.slrWidth,slrp.slrHeight,slrp.slrWeight");
			buffer.append(" from SlrProduct slrp,Ismppt ppt,Ismpbi pbi");
			buffer.append(" where slrp.ismpbi.pbirfnum = pbi.pbirfnum"); 
			buffer.append(" and ppt.ismpbi.pbirfnum = pbi.pbirfnum and"); 
			buffer.append(" ppt.ismcmt.cmtrfnum =:cmtrfnum and slrp.octSlr.octslrrfnum!= :sellerrfnum");		
			Query query = getStatelessSession().createQuery(buffer.toString()); 	
			query.setLong("cmtrfnum", cmtrfnum);
			query.setLong("sellerrfnum", sellerrfnum);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);	
		}catch(HibernateException e){
			throw new com.anm.hibernate.DAOException( e );
		}
		return rs;
	}


	public ScrollableResults findProductAttrData(Long slrProductRef,List<String> attrcode) {

		ScrollableResults rs = null;
		try {
			StringBuffer buffer = new StringBuffer();
			buffer.append("select spad.attrMstr.amcode,spad.spadvalue,spad.attrMstr.wsbeanproperty  from SlrProdAttrData spad  LEFT JOIN spad.attrMstr LEFT JOIN spad.spadsprfnum  where spad.spadsprfnum.sprfnum=:slrProductRef "
					+ " and (spad.attrMstr.wsbeanproperty in('color','size') or spad.attrMstr.amcode in (:attrcode))");
			Query query = getStatelessSession().createQuery(buffer.toString()); 	
			query.setLong("slrProductRef", slrProductRef);
			query.setParameterList("attrcode", attrcode);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);	
		}catch( HibernateException e){
			throw new DAOException( e );
		}
		return rs;
	}

	public ScrollableResults getCatNameAndCode(){
		ScrollableResults result =null;

		try {
			String Query ="select c1.CMTNAME  L4name, c1.CMTCODE L4code,c2.CMTNAME L3name, c2.CMTCODE L3code,c3.CMTNAME" 
					+" L2name, c3.CMTCODE L2code,c4.CMTNAME   L1name, c4.CMTCODE L1code"
					+" from ISMCPT  t1  LEFT OUTER JOIN ISMCPT  t2 ON (t2.CPTCMTRFNUM = t1.CPTCMTRFNUM1)"
					+" LEFT OUTER JOIN ISMCPT  t3 ON (t3.CPTCMTRFNUM = t2.CPTCMTRFNUM1)  LEFT OUTER JOIN ISMCPT  t4 ON (t4.CPTCMTRFNUM = t3.CPTCMTRFNUM1)"
					+" LEFT OUTER JOIN ISMCMT  c1 ON (c1.CMTRFNUM = t1.CPTCMTRFNUM)  LEFT OUTER JOIN ISMCMT  c2 ON (c2.CMTRFNUM = t2.CPTCMTRFNUM)"
					+" LEFT OUTER JOIN ISMCMT  c3 ON (c3.CMTRFNUM = t3.CPTCMTRFNUM)  LEFT OUTER JOIN ISMCMT  c4 ON (c4.CMTRFNUM = t4.CPTCMTRFNUM)"
					+" where c1.CMTLEVEL=4 order by c4.CMTNAME,c3.CMTNAME,c2.CMTNAME,c1.CMTNAME";


			Query query = getStatelessSession().createSQLQuery(Query);
			query.setReadOnly(true);
			result = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			throw new  DAOException( e );
		}
		return result;
	}

	//@Raju Mobile API :: Pagination start
	public ScrollableResults  getManageDeliveryDetailsPagination(String slaverfnum, List<Long> shiprfnumList) {
		Session hibSession = null;
		ScrollableResults rs = null;
		StringBuffer queryString = new StringBuffer();

		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			queryString.append(" select pst.shipment.shiprfnum,pst.transactionid,pst.pstskuno,pst.pstproductname,pst.deliverydate,"
					+ "pst.shipfirstname,pst.subordertype,pst.deliverymode.paramcode,pst.fulfillmenttype.paramcode,pst.p1slaveid,"
					+ "pst.p2slaveid,pst.ismpot.orderrefno,pst.ismpot.orderid,pst.shipment.awbnum,pst.shipment.couriercode,pst.iscod,"
					+ "pst.transportmode,pst.shipment.menifesto.menifestorfnum,pst.pstrfnum,pst.ismsmt.smtrfnum,pst.shiplastname,"
					+ "pst.shipment.octinvoice.autoGenInvoice,pst.modidate from Ismpst pst "
					+ "where pst.ismsmt.smtcode='HOTCOURI' and pst.deleted='N' and (pst.iscncparentdeliverd=null or pst.iscncparentdeliverd='N')");
			if(slaverfnum!=null && !"".equals(slaverfnum) ){
				queryString.append(" and pst.octSlv.octslvrfnum=:slaverfnum ");
			}
			if(shiprfnumList != null && shiprfnumList.size() > 0) {
				queryString.append(" and pst.shipment.shiprfnum IN(:shiprfnumList) ");
			}
			queryString.append(" order by pst.modidate desc");

			Query query = hibSession.createQuery(queryString.toString());

			if(slaverfnum!=null && !"".equals(slaverfnum) ){
				query.setString("slaverfnum", slaverfnum);
			}
			if(shiprfnumList != null && shiprfnumList.size() > 0) {
				query.setParameterList("shiprfnumList", shiprfnumList);
			}
			query.setReadOnly(true);

			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch(HibernateException e){
			throw  new DAOException(e);
		}

		return  rs;

	}

	public ScrollableResults getCourInBoundDetailsAPIPagination(String slvRfnum, String sellerRfNum, String slvCode){

		Session hibSession = null;
		ScrollableResults rs = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuffer sb = new StringBuffer();

			String m ="";
			sb.append("select ismpst.pstrfnum,ismpst.ismsmt.smtcode,ismpst.subordertype,ismpst.inlineStatusForInbound,ismpst.fulfillmenttype.paramcode,ismpst.isSShipAck," //5
					+ " ismpst.octSlv.octslvrfnum,ismpst.octSlv.octslvcode,ismpst.ismpot.orderid,ismpst.ismpot.checkBogoOrder,ismpst.transactionid," //10
					+ " ismpst.parenttransactionid,ismpst.isafreebie,ismpst.shipment.awbnum,ismpst.reverseshipment.awbnum,ismpst.pstproductname," //15
					+ " ismpst.returnlogisticid,ismpst.returnlogisticprovidername,ismpst.p1slaveid,ismpst.p2slaveid,ismpst.productimageurl,"
					+ " ismpst.p1logisticname,ismpst.shipment.octinvoice.autoGenInvoice,ismpst.returnfulfillmenttype.paramrfnum,"
					+ "ismpst.shipment.shiprfnum,ismpst.ismpot.billfirstname,ismpst.reverseshipment.shiprfnum"
					+ " from Ismpst ismpst " //20
					+ "left join  ismpst.ismpot "
					+ "left join  ismpst.shipment "
					+ "left join  ismpst.reverseshipment "
					+ "left join  ismpst.ismsmt "
					+ "left join  ismpst.shipment.octinvoice "
					+ " where (ismpst.pstrfnum IN ");
			String userTypePstR = "";
			String userTypePstT = "";
			String userTypePstC = "";
			String userTypeSlr = "";
			String userTypeSlrT = "";

			if(slvRfnum != null && !"".equals(slvRfnum)) {
				userTypePstR = " and pst.octSlv.octslvrfnum=:slvRfnum";
				userTypePstC = " and pst.p2slaveid=:slvCode";
				userTypePstT = " and tkt.ismpst.octSlv.octslvrfnum=:slvRfnum";
			}
			if(sellerRfNum != null && !"".equals(sellerRfNum)) {
				userTypeSlr = " and pst.octSlv.octSlr.octslrrfnum=:sellerRfNum";
				userTypeSlrT = " and tkt.ismpst.octSlv.octSlr.octslrrfnum=:sellerRfNum";
			}

			sb.append("(select pst.pstrfnum from Ismpst pst where pst.ismsmt.smtcode IN "
					+ "('RETTOORG','RETUIRTO','REVRSAWB') "
					+ "and pst.deleted='N' "+userTypePstR+userTypeSlr+")");

			sb.append(" or ismpst.pstrfnum IN (select pst.pstrfnum from Ismpst pst where "
					+ "pst.subordertype='CNC' and pst.ismsmt.smtcode='HOTCOURI' "
					+ " and pst.deleted='N' "+userTypePstC+userTypeSlr+")");

			sb.append(" or ismpst.pstrfnum IN (select pst.pstrfnum from Ismpst pst where "
					+ "pst.ismsmt.smtcode='RETUINIT' and "
					//+ "((pst.returnfulfillmenttype is not null and pst.returnfulfillmenttype.paramcode='TSHIP') or "
					+ "((pst.returnfulfillmenttype is not null and pst.returnfulfillmenttype.paramrfnum=383) or "
					+ "(pst.fulfillmenttype.paramcode='TSHIP' and pst.returnfulfillmenttype is null)) "
					+ "and pst.deleted='N' "+userTypePstR+userTypeSlr+")");

			//@R2_3 query changed due to ReturnFulfillmentType new column 
			sb.append(" or ismpst.pstrfnum IN (select pst.pstrfnum from Ismpst pst where "
					+ "pst.ismsmt.smtcode='RETUINIT' and "
					//+ "((pst.returnfulfillmenttype is not null and pst.returnfulfillmenttype.paramcode='SSHIP') or "
					+ "((pst.returnfulfillmenttype is not null and pst.returnfulfillmenttype.paramrfnum=384) or "
					+ "(pst.fulfillmenttype.paramcode='SSHIP' and pst.returnfulfillmenttype is null)) and pst.isSShipAck='Y' "
					+ "and pst.deleted='N' "+userTypePstR+userTypeSlr+")");

			sb.append(" or ismpst.pstrfnum IN (select tkt.ismpst.pstrfnum from OctTicket tkt where "
					+ " tkt.ismpst.ismsmt.smtcode='RETUINIT' and tkt.octParamSubTickType is not null "
					+ " and tkt.ismpst.deleted='N' "+userTypePstT+userTypeSlrT+")");

			sb.append(" and ismpst.ciStatus not in('3')) order by ismpst.modidate desc");

			Query query = hibSession.createQuery(sb.toString());

			if(slvRfnum != null && !"".equals(slvRfnum)) 
				query.setLong("slvRfnum", new Long(slvRfnum));
			if(sellerRfNum != null && !"".equals(sellerRfNum))
				query.setLong("sellerRfNum", new Long(sellerRfNum));
			if(slvCode != null && !"".equals(slvCode))
				query.setString("slvCode", slvCode);

			query.setReadOnly(true);

			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}

	public ScrollableResults getCourInBoundDetailsPagination(String slvRfnum, String sellerRfNum, String slvCode, 
			List<Long> potrfnumList){
		ScrollableResults rs = null;
		Session hibSession = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuffer sb = new StringBuffer();

			String m ="";
			sb.append("select ismpst.pstrfnum,ismpst.ismsmt.smtcode,ismpst.subordertype,ismpst.inlineStatusForInbound,ismpst.fulfillmenttype.paramcode,ismpst.isSShipAck," //5
					+ " ismpst.octSlv.octslvrfnum,ismpst.octSlv.octslvcode,ismpst.ismpot.orderid,ismpst.ismpot.checkBogoOrder,ismpst.transactionid," //10
					+ " ismpst.parenttransactionid,ismpst.isafreebie,ismpst.shipment.awbnum,ismpst.reverseshipment.awbnum,ismpst.pstproductname," //15
					+ " ismpst.returnlogisticid,ismpst.returnlogisticprovidername,ismpst.p1slaveid,ismpst.p2slaveid,ismpst.productimageurl,"
					+ " ismpst.p1logisticname,ismpst.shipment.octinvoice.autoGenInvoice,ismpst.returnfulfillmenttype.paramrfnum,"
					+ "ismpst.shipment.shiprfnum,ismpst.ismpot.billfirstname,ismpst.reverseshipment.shiprfnum"
					+ " from Ismpst ismpst " //20
					+ "left join  ismpst.ismpot "
					+ "left join  ismpst.shipment "
					+ "left join  ismpst.reverseshipment "
					+ "left join  ismpst.ismsmt "
					+ "left join  ismpst.shipment.octinvoice "
					+ " where (ismpst.pstrfnum IN ");
			String userTypePstR = "";
			String userTypePstT = "";
			String userTypePstC = "";
			String userTypeSlr = "";
			String userTypeSlrT = "";

			if(slvRfnum != null && !"".equals(slvRfnum)) {
				userTypePstR = " and pst.octSlv.octslvrfnum=:slvRfnum";
				userTypePstC = " and pst.p2slaveid=:slvCode";
				userTypePstT = " and tkt.ismpst.octSlv.octslvrfnum=:slvRfnum";
			}
			if(sellerRfNum != null && !"".equals(sellerRfNum)) {
				userTypeSlr = " and pst.octSlv.octSlr.octslrrfnum=:sellerRfNum";
				userTypeSlrT = " and tkt.ismpst.octSlv.octSlr.octslrrfnum=:sellerRfNum";
			}

			sb.append("(select pst.pstrfnum from Ismpst pst where pst.ismsmt.smtcode IN "
					+ "('RETTOORG','RETUIRTO','REVRSAWB') "
					+ "and pst.deleted='N' "+userTypePstR+userTypeSlr+")");

			sb.append(" or ismpst.pstrfnum IN (select pst.pstrfnum from Ismpst pst where "
					+ "pst.subordertype='CNC' and pst.ismsmt.smtcode='HOTCOURI' "
					+ " and pst.deleted='N' "+userTypePstC+userTypeSlr+")");

			sb.append(" or ismpst.pstrfnum IN (select pst.pstrfnum from Ismpst pst where "
					+ "pst.ismsmt.smtcode='RETUINIT' and "
					//+ "((pst.returnfulfillmenttype is not null and pst.returnfulfillmenttype.paramcode='TSHIP') or "
					+ "((pst.returnfulfillmenttype is not null and pst.returnfulfillmenttype.paramrfnum=383) or "
					+ "(pst.fulfillmenttype.paramcode='TSHIP' and pst.returnfulfillmenttype is null)) "
					+ "and pst.deleted='N' "+userTypePstR+userTypeSlr+")");

			sb.append(" or ismpst.pstrfnum IN (select pst.pstrfnum from Ismpst pst where "
					+ "pst.ismsmt.smtcode='RETUINIT' and "
					//+ "((pst.returnfulfillmenttype is not null and pst.returnfulfillmenttype.paramcode='SSHIP') or "
					+ "((pst.returnfulfillmenttype is not null and pst.returnfulfillmenttype.paramrfnum=384) or "
					+ "(pst.fulfillmenttype.paramcode='SSHIP' and pst.returnfulfillmenttype is null)) and pst.isSShipAck='Y' "
					+ "and pst.deleted='N' "+userTypePstR+userTypeSlr+")");

			sb.append(" or ismpst.pstrfnum IN (select tkt.ismpst.pstrfnum from OctTicket tkt where "
					+ " tkt.ismpst.ismsmt.smtcode='RETUINIT' and tkt.octParamSubTickType is not null "
					+ " and tkt.ismpst.deleted='N' "+userTypePstT+userTypeSlrT+")");

			if(potrfnumList != null && potrfnumList.size() > 0) {
				sb.append(" and ismpst.ismpot.potrfnum IN(:potrfnumList)");
			}
			sb.append(" and ismpst.ciStatus not in('3')) order by ismpst.modidate desc");

			Query query = hibSession.createQuery(sb.toString());

			if(slvRfnum != null && !"".equals(slvRfnum)) 
				query.setLong("slvRfnum", new Long(slvRfnum));
			if(sellerRfNum != null && !"".equals(sellerRfNum))
				query.setLong("sellerRfNum", new Long(sellerRfNum));
			if(slvCode != null && !"".equals(slvCode))
				query.setString("slvCode", slvCode);
			if(potrfnumList != null && potrfnumList.size() > 0) 
				query.setParameterList("potrfnumList", potrfnumList);

			query.setReadOnly(true);

			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}
	//@Raju Mobile API :: Pagination end

	public ScrollableResults  findPackingDetailsMobileAPI(String shipmentType,List<String> deliveryModeList,String slave,String sellerCode,String state,String pickId,List potList) {

		ScrollableResults rs = null;
		try {
			String queryString = "select pst.pstrfnum,pst.ismpot.potrfnum,pst.fulfillmenttype.paramcode,pst.deliverymode.paramcode,pst.subordertype," //5
					+ "pst.p1logisticsid,pst.packLimitAmt,pst.price,pst.discount,pst.shipaddress1," //10
					+ "pst.shipaddress2,pst.shipaddress3,pst.shipcityordistrict,pst.shippincode,pst.shipstate," //15
					+ "pst.ismpot.orderid,pst.p1logisticname,pst.iscod,pst.pstproductname,pst.productimageurl," //20
					+ "pst.pstskuno,pst.pststyleno,pst.pstsize,pst.pstcolour,pst.mrp," //25
					+ "pst.pstimei1,pst.pstimei2,pst.pstsrno,pst.transactionid,pst.isimeireq," //30
					+ "pst.transportmode,pst.p1logisticsid" //31
					+ " from Ismpst pst left join pst.ismpot left join pst.fulfillmenttype left join pst.deliverymode where pst.deleted='N'";	

			/* if(deliveryMode !=null && !"All".equals(deliveryMode)){

					   			if("CNC".equals(deliveryMode)) {
					   					queryString += "and pst.subordertype=:deliveryMode ";
					   				} else {
					   					queryString +=" and (pst.deliverymode.paramcode=:deliveryMode and pst.subordertype!='CNC')";
					   				}
					   			}*/

			if(deliveryModeList != null && deliveryModeList.size() > 0) {
				queryString += "and pst.subordertype IN(:deliveryModeList)";
			}

			if(state != null){
				queryString += "and pst.ismsmt.smtcode=:state ";
			}
			if(shipmentType != null){
				queryString +="and pst.fulfillmenttype.paramcode=:shipmentType ";
			}
			if(slave != null){
				queryString +=" and pst.octSlv.octslvrfnum=:slave ";
			}

			if(sellerCode != null){
				queryString +="and pst.sellercode=:sellerCode ";
			}

			if(pickId != null){
				if(!pickId.equals("0")){
					queryString += "and pst.octpick.pickrfnum=:pickId ";
				}else{
					queryString += "and pst.octpick.pickrfnum is null ";
				}
			}
			if(potList!=null && !potList.isEmpty())/*pack load more*/
				queryString += " and pst.ismpot.potrfnum In(:potList) ";

			queryString += " order by pst.ismpot.potrfnum desc,pst.ismpot.modidate desc ";

			Query query = getStatelessSession().createQuery(queryString);

			/*if(deliveryMode !=null && !"All".equals(deliveryMode)){
					   				query.setString("deliveryMode",deliveryMode);
						   			}*/

			if(deliveryModeList != null && deliveryModeList.size() > 0) {
				query.setParameterList("deliveryModeList",deliveryModeList);
			}
			if(state != null){
				query.setString("state",state);
			}
			if(shipmentType != null){
				query.setString("shipmentType",shipmentType);
			}
			if(slave != null){
				query.setString("slave",slave);
			}

			if(sellerCode != null){
				query.setString("sellerCode",sellerCode);
			}

			if(pickId != null  && !pickId.equals("0")){
				query.setString("pickId",pickId);
			}

			if(potList!=null && !potList.isEmpty())
				query.setParameterList("potList", potList);

			query.setReadOnly(true);

			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return rs;
	}

	//@Suyog, Download Menifest Report Start
	//public ScrollableResults getMenifestBySlrSlv(String startDate,String endDate,String sellerCode,Long octslvrfnum,int from, int to,String manifestid){	
	public ScrollableResults getMenifestBySlrSlv(String startDate,String endDate,List<String>slrLst,List<Long>lstSlv,int from, int to,List<Long> menifestidList,String selectDD){
		ScrollableResults rs = null;

		try {
			String strQuery="";	
			strQuery += "select octSlv.octSlr.octslrlname,octSlv.octslvcode,octSlv.octslvRetAddress.cityMaster.description,"//0-2
					+ "transactionid,ismpot.orderid,shipment.menifesto.menifestorfnum,shipment.menifesto.createdate,"//3-6
					+ "shipment.menifesto.scannedMenifestDate,p1logisticname,shipment.menifesto.uploadedMenifestDate,"//7-9
					+ "shipment.menifesto.menifestopath,shipment.menifesto.uploadedMenifestTime "//10-11
					+ "from Ismpst where ";
			if (startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate) && menifestidList !=null && menifestidList.size()>0) {
				startDate = startDate + " 00:00:00";
				endDate = endDate + " 23:59:59";
				strQuery += " shipment.menifesto.createdate between to_date(:startDate,'dd/MM/yyyy HH24:MI:SS') and to_date(:endDate,'dd/MM/yyyy HH24:MI:SS') and shipment.menifesto.menifestorfnum in(:menifestidList)";
			}else if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)){
				startDate = startDate + " 00:00:00";
				endDate = endDate + " 23:59:59";
				strQuery += " shipment.menifesto.createdate between to_date(:startDate,'dd/MM/yyyy HH24:MI:SS') and to_date(:endDate,'dd/MM/yyyy HH24:MI:SS') ";
			}else if(menifestidList !=null && menifestidList.size()>0){
				strQuery=strQuery+" shipment.menifesto.menifestorfnum in(:menifestidList)";
			}
			if(lstSlv !=null && lstSlv.size()>0){
				strQuery += " and octSlv.octslvrfnum in(:lstSlv) ";
			}
			if(slrLst != null && slrLst.size()>0){
				strQuery += " and sellercode in(:slrLst)";
			}
			//suraj manifestid added
			/*if(manifestid !=null && !"".equals(manifestid)){
								strQuery=strQuery+" and shipment.menifesto.menifestorfnum=:manifestid";
				 	 		}*/
			if("Uploaded".equalsIgnoreCase(selectDD)){
				strQuery=strQuery+" and shipment.menifesto.uploadedMenifestDate is not null";
			}else if("Not uploaded".equalsIgnoreCase(selectDD)){
				strQuery=strQuery+" and shipment.menifesto.uploadedMenifestDate is null";
			}
			Query query = getStatelessSession().createQuery(strQuery.toString()); 
			if(startDate != null && !"".equals(startDate)){
				query.setString("startDate", startDate);
			}if(endDate != null && !"".equals(endDate)){
				query.setString("endDate", endDate);
			}
			if(slrLst != null && slrLst.size()>0){
				query.setParameterList("slrLst", slrLst);
			}
			/*if(octslvrfnum != null && !"".equals(octslvrfnum)){
				 				query.setLong("octslvrfnum", new Long(octslvrfnum));
				 			}*/
			/*if(manifestid != null && !"".equals(manifestid)){
								query.setString("manifestid", manifestid);
							}*/
			if(lstSlv != null && lstSlv.size()>0){
				query.setParameterList("lstSlv", lstSlv);
			}
			if(menifestidList != null && menifestidList.size()>0){
				query.setParameterList("menifestidList", menifestidList);
			}

			query.setReadOnly(true);
			query.setFirstResult(from);
			query.setMaxResults(to);

			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		} 
		catch (HibernateException e) {
			e.printStackTrace();
		}
		return rs;
	}


	//public ScrollableResults downloadMenifestBySlrSlv(String startDate,String endDate,String sellerCode,Long octslvrfnum,String manifestid){	
	public ScrollableResults downloadMenifestBySlrSlv(String startDate,String endDate,List<String>slrLst,List<Long>lstSlv,List<Long> menifestidList,String selectDD){		
		ScrollableResults rs = null;

		try {
			String strQuery="";	
			strQuery += "select octSlv.octSlr.octslrlname,octSlv.octslvcode,octSlv.octslvRetAddress.cityMaster.description,"//0-2
					+ "transactionid,ismpot.orderid,shipment.menifesto.menifestorfnum,shipment.menifesto.createdate,"//3-6
					+ "shipment.menifesto.scannedMenifestDate,p1logisticname,shipment.menifesto.uploadedMenifestDate,"//7-9
					+ "shipment.menifesto.menifestopath,shipment.menifesto.uploadedMenifestTime,shipment.awbnum,"//10-12
					+ "shipment.menifesto.menifestopath,ismpot.createdate,shipment.menifesto.uploadedmenifestopath from Ismpst where ";

			if (startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate) && menifestidList !=null && menifestidList.size()>0) {
				startDate = startDate + " 00:00:00";
				endDate = endDate + " 23:59:59";
				strQuery += " shipment.menifesto.createdate between to_date(:startDate,'dd/MM/yyyy HH24:MI:SS') and to_date(:endDate,'dd/MM/yyyy HH24:MI:SS') and shipment.menifesto.menifestorfnum in(:menifestidList)";
			}else if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)){
				startDate = startDate + " 00:00:00";
				endDate = endDate + " 23:59:59";
				strQuery += " shipment.menifesto.createdate between to_date(:startDate,'dd/MM/yyyy HH24:MI:SS') and to_date(:endDate,'dd/MM/yyyy HH24:MI:SS') ";
			}else if(menifestidList !=null && menifestidList.size()>0){
				strQuery=strQuery+" shipment.menifesto.menifestorfnum in(:menifestidList)";
			}
			/*	if(octslvrfnum != null && !"".equals(octslvrfnum)){
									strQuery += " and octSlv.octslvrfnum=:octslvrfnum ";
								}*/
			if(lstSlv !=null && lstSlv.size()>0){
				strQuery += " and octSlv.octslvrfnum in(:lstSlv) ";
			}
			if(slrLst != null && slrLst.size()>0){
				strQuery += " and sellercode in(:slrLst)";
			}
			//@suraj added manifestid 
			/*if(manifestid !=null && !"".equals(manifestid)){
	  			 				strQuery=strQuery+" and shipment.menifesto.menifestorfnum=:manifestid";
				 	 		}*/
			/*if(menifestidList !=null && menifestidList.size()>0){
	  			 				strQuery=strQuery+" and shipment.menifesto.menifestorfnum in(:menifestidList)";
				 	 		}*/
			if("Uploaded".equalsIgnoreCase(selectDD)){
				strQuery=strQuery+" and shipment.menifesto.uploadedMenifestDate is not null";
			}else if("Not uploaded".equalsIgnoreCase(selectDD)){
				strQuery=strQuery+" and shipment.menifesto.uploadedMenifestDate is null";
			}
			Query query = getStatelessSession().createQuery(strQuery.toString()); 
			if(startDate != null && !"".equals(startDate)){
				query.setString("startDate", startDate);
			}if(endDate != null && !"".equals(endDate)){
				query.setString("endDate", endDate);
			}
			if(slrLst != null && slrLst.size()>0){
				query.setParameterList("slrLst", slrLst);
			}

			/*if(octslvrfnum != null && !"".equals(octslvrfnum)){
				 				query.setLong("octslvrfnum", new Long(octslvrfnum));
				 			}*/
			/*if(manifestid != null && !"".equals(manifestid)){
								query.setString("manifestid", manifestid);
							}*/
			if(lstSlv != null && lstSlv.size()>0){
				query.setParameterList("lstSlv", lstSlv);
			}
			if(menifestidList != null && menifestidList.size()>0){
				query.setParameterList("menifestidList", menifestidList);
			}

			query.setReadOnly(true);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		} 
		catch (HibernateException e) {
			e.printStackTrace();
		}
		return rs;
	}
	//@Suyog, Download Menifest Report End		

	public ScrollableResults getCourInBoundAllStatusUnionForReturnQc(String slvRfnum, String sellerRfNum){
		Long tshiprfnum = new Long("383");
		Long sshiprfnum = new Long("384");
		ScrollableResults rs = null;
		try {
			StringBuffer sb = new StringBuffer();

			String m ="";
			sb.append("select ismpst.pstrfnum,ismpst.transactionid,ismpst.shipment.awbnum,ismpst.reverseshipment.awbnum,"
					+ "ismpst.ismpot.orderid,ismpst.shipment.octinvoice.autoGenInvoice,ismpst.pstproductname from Ismpst ismpst " //20
					+ "left join  ismpst.ismpot "
					+ "left join  ismpst.shipment "
					+ "left join  ismpst.reverseshipment "
					+ "left join  ismpst.shipment.octinvoice "
					+ " where ismpst.pstrfnum IN ");
			String userTypePstR = "";
			String userTypePstT = "";
			String userTypePstC = "";
			String userTypeSlr = "";
			String userTypeSlrT = "";

			if(slvRfnum != null && !"".equals(slvRfnum)) {
				userTypePstR = " and pst.octSlv.octslvrfnum=:slvRfnum";
				userTypePstC = " and pst.p2slaveid=:slvCode";
				userTypePstT = " and tkt.ismpst.octSlv.octslvrfnum=:slvRfnum";
			}
			if(sellerRfNum != null && !"".equals(sellerRfNum)) {
				userTypeSlr = " and pst.octSlv.octSlr.octslrrfnum=:sellerRfNum";
				userTypeSlrT = " and tkt.ismpst.octSlv.octSlr.octslrrfnum=:sellerRfNum";
			}

			sb.append("(select pst.pstrfnum from Ismpst pst where pst.ismsmt.smtcode IN "
					+ "('RETTOORG','RETUIRTO','REVRSAWB') "
					+ "and pst.deleted='N' "+userTypePstR+userTypeSlr+" and pst.ciStatus in('1','2'))");

			sb.append(" or ismpst.pstrfnum IN (select pst.pstrfnum from Ismpst pst where "
					+ "pst.ismsmt.smtcode='RETUINIT' and "
					+ "((pst.returnfulfillmenttype is not null and pst.returnfulfillmenttype.paramrfnum=:tshiprfnum) or "
					+ "(pst.fulfillmenttype.paramrfnum=:tshiprfnum and pst.returnfulfillmenttype is null)) "
					+ "and pst.deleted='N' "+userTypePstR+userTypeSlr+"  and pst.ciStatus in('1','2'))");
			//@R2_3 query changed due to ReturnFulfillmentType new column 
			sb.append(" or ismpst.pstrfnum IN (select pst.pstrfnum from Ismpst pst where "
					+ "pst.ismsmt.smtcode='RETUINIT' and "
					+ "((pst.returnfulfillmenttype is not null and pst.returnfulfillmenttype.paramrfnum=:sshiprfnum) or "
					+ "(pst.fulfillmenttype.paramrfnum=:sshiprfnum and pst.returnfulfillmenttype is null)) and pst.isSShipAck='Y' "
					+ "and pst.deleted='N' "+userTypePstR+userTypeSlr+" and pst.ciStatus in('1','2'))");
			sb.append(" or ismpst.pstrfnum IN (select tkt.ismpst.pstrfnum from OctTicket tkt where "
					+ " tkt.ismpst.ismsmt.smtcode='RETUINIT' and tkt.octParamSubTickType is not null and "
					+ " tkt.octParamSubTickType.paramcode!='RTS' and tkt.ismpst.deleted='N' "+userTypePstT+userTypeSlrT+""
					+ " and tkt.ismpst.ciStatus in('1','2'))");

			sb.append(" order by ismpst.modidate desc");

			Query query = getStatelessSession().createQuery(sb.toString());

			if(slvRfnum != null && !"".equals(slvRfnum)) 
				query.setLong("slvRfnum", new Long(slvRfnum));
			if(sellerRfNum != null && !"".equals(sellerRfNum))
				query.setLong("sellerRfNum", new Long(sellerRfNum));
			if(tshiprfnum != null) {
				query.setLong("tshiprfnum", tshiprfnum);
			}
			if(sshiprfnum != null) {
				query.setLong("sshiprfnum", sshiprfnum);
			}

			query.setReadOnly(true);

			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}finally{		
		}
		return rs;
	}

	public ScrollableResults findPackOrderStatusDetails(String slvRfnum, List<String> smtCodeList) {
		ScrollableResults rs = null;
		try {
			String queryString = "select pst.octSlv.octSlr.octslrlcode,pst.ismpot.orderid,pst.transactionid,pst.ismsmt.smtcode,pst.l4catCode,pst.isPlasticBan,pst.pstproductname,pst.p1logisticsid,slp.slrWeight " //Shankar : TPR-9982 : Added coloumn Plastic ban //@Nikhil.s need product name column 
					+ "from Ismpst pst, "
					+ "SlrProduct slp where pst.ussid = slp.slrussid "
					+ "and pst.octSlv.octslvrfnum=:slvRfnum and pst.ismsmt.smtcode IN(:smtCodeList) "
					+ "and pst.fulfillmenttype.paramcode='TSHIP'";

			Query query = getStatelessSession().createQuery(queryString);
			query.setLong("slvRfnum", new Long(slvRfnum));
			query.setParameterList("smtCodeList", smtCodeList);
			query.setReadOnly(true);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}

	public ScrollableResults findPackOrderStatusByPickIdOrDirectPick(Long sellerRfNum, Long slvRfnum, String deliveryMode, Long pickId) throws DAOException{
		ScrollableResults rs = null;
		try {
			StringBuffer queryString = new StringBuffer();
			queryString.append("select pst.octSlv.octSlr.octslrlcode,pst.ismpot.orderid,pst.transactionid,pst.ismsmt.smtcode,pst.l4catCode,pst.isPlasticBan,pst.pstproductname,pst.p1logisticsid"
					+ " from Ismpst pst where pst.ismsmt.smtcode='PICKCONF' "
					+ " and pst.fulfillmenttype.paramcode='TSHIP' and deleted='N' ");
			if(sellerRfNum != null){
				queryString.append("and  pst.ismpot.octSlr.octslrrfnum=:sellerRfNum ");
			}
			if(slvRfnum != null){
				queryString.append("and  pst.octSlv.octslvrfnum=:slvRfnum ");
			}
			if(pickId != null) {
				queryString.append(" and pst.octpick.pickrfnum=:pickId ");
			} else {
				queryString.append(" and pst.octpick.pickrfnum is null");
			}
			if(!"All".equalsIgnoreCase(deliveryMode)){
				if("CNC".equals(deliveryMode)) {
					queryString.append(" and pst.subordertype=:deliveryMode ");
				} else {
					queryString.append(" and (pst.deliverymode.paramcode=:deliveryMode and pst.subordertype!='CNC')");
				}
			}
			queryString.append(" order by pst.createdate desc");
			Query query = getStatelessSession().createQuery(queryString+"");

			if(sellerRfNum != null){
				query.setLong("sellerRfNum",sellerRfNum);
			}
			if(slvRfnum != null){
				query.setLong("slvRfnum",slvRfnum);
			}
			if(pickId != null) {
				query.setLong("pickId", pickId);
			}
			if(!"All".equalsIgnoreCase(deliveryMode)){
				query.setString("deliveryMode",deliveryMode);
			}
			query.setReadOnly(true);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}

	public ScrollableResults getSellerSettlementReport(String slvcode, String startDate, String endDate) throws DAOException{
		ScrollableResults rs = null;
		try {
			if (startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {

				String sresult = startDate+ " 00:00:00";
				String eresult = endDate + " 23:59:59";

				if(sresult.equals(eresult)){
					sresult = sresult + " 00:00:00";
					eresult = eresult + " 23:59:59";
				}

				StringBuffer queryString = new StringBuffer();
				queryString.append("select pst.octSlv.octSlr.octslrlcode,pst.ismpot.orderid,pst.transactionid,pst.ussid,pst.pstproductname,"
						+ "pst.pstskuno,pst.mrp,pst.price,pst.subordertype,pst.octSlv.octslvcode,pst.apportionedprice,com.commvalue,com.trxncalccommval,"
						+ "case when pro.promotiontypecode='P' then 'P' else 'C' end,pro.promotioncode,pro.promotionvalue,"
						+ "pro.tatareimbursement,pst.ismsmt.smtcode,pay.paymentstatus,pay.paymentdate,pay.paymentinfo "
						+ "from Ismpst pst,OctTrxnPromo pro,OctTrxnPaymentInfo pay,OctTrxnCommision com where "
						+ "(pro.ismpst.pstrfnum=pst.pstrfnum and pay.potrefnum=pst.ismpot.potrfnum and com.ismpst.pstrfnum=pst.pstrfnum) "
						+ " and pst.octSlv.octslvcode=:slvcode "
						+ " and pst.createdate between to_date('"+sresult+"','dd/MM/yyyy HH24:MI:SS') "
						+ "and to_date('"+eresult+"','dd/MM/yyyy HH24:MI:SS') order by pst.createdate desc");

				Query query = getStatelessSession().createQuery(queryString+"");
				query.setString("slvcode",slvcode);
				query.setReadOnly(true);
				rs = query.scroll(ScrollMode.FORWARD_ONLY);

			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}

	//Nishant added for OctPackMatrix and CategoryListImeiSerialNumber  
	public ScrollableResults findCategory() {

		ScrollableResults rs = null;
		try {
			String queryString = "select cirfnum,ismcmt.cmtcode,categoryname,categorylevel,isimeirequired,isactive from OctCategoryImei";
			Query query = getStatelessSession().createQuery(queryString);
			query.setReadOnly(true);

			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch( HibernateException e){
			throw new DAOException( e );
		}
		return rs;
	}	

	public ScrollableResults findOctPackMatrix() {

		ScrollableResults rs = null;
		try {
			String queryString = "select pmrfnum,ismcmt.cmtcode,pmmaterialcode,pmlength,pmbreath,pmheight,pmweight from OctPackMatrix";
			Query query = getStatelessSession().createQuery(queryString);
			query.setReadOnly(true);

			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch( HibernateException e){
			throw new DAOException( e );
		}
		return rs;
	}	
	//Nishant end for OctPackMatrix and CategoryListImeiSerialNumber

	//@Raju SQL query
	public ScrollableResults getSellerSettlementReportSQL(String slvcode, String startDate, String endDate) throws DAOException{
		ScrollableResults rs = null;
		try {
			if (startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {

				String sresult = startDate+ " 00:00:00";
				String eresult = endDate + " 23:59:59";

				if(sresult.equals(eresult)){
					sresult = sresult + " 00:00:00";
					eresult = eresult + " 23:59:59";
				}

				StringBuffer queryString = new StringBuffer();
				//Shankar Start : TPR-6760
				/*queryString.append("SELECT slr.OCTSLRLCODE,pot.ORDERID,pst.TRANSACTIONID,pst.USSID,pst.PSTPRODUCTNAME,pst.PSTSKUNO,"
									+ "pst.MRP,pst.PRICE,pst.SUBORDERTYPE,slv.OCTSLVCODE,pst.APPORTIONEDPRICE,com.COMMVALUE,com.TRXNCALCCOMMVAL,"
									+ "pro.PROMOTIONTYPECODE,pro.PROMOTIONCODE,pro.PROMOTIONVALUE,pro.TATAREIMBURSEMENT,smt.SMTCODE,"
									+ "pay.PAYMENTSTATUS,pay.PAYMENTDATE,pay.PAYMENTINFO FROM ISMPST pst "
									+ "left join OCT_SLV slv ON slv.OCTSLVRFNUM=pst.PSTSLVRFNUM "
									+ "left join OCT_SLR slr ON slr.OCTSLRRFNUM=slv.OCTSLVSLR "
									+ "left join ISMPOT pot ON pot.POTRFNUM=pst.PSTPOTRFNUM "
									+ "left join ISMSMT smt ON smt.smtrfnum=pst.PSTSMTRFNUM "
									+ "left join OCT_TRXN_COMMISION com ON com.PSTRFNUM=pst.PSTRFNUM "
									+ "left join OCT_TRXN_PAYMENT_INFO pay ON pay.POTREFNUM=pot.POTRFNUM "
									+ "left join OCT_TRXN_PROMO pro ON pro.PSTRFNUM=pst.PSTRFNUM where slv.OCTSLVCODE=:slvcode and "
									+ "pst.CREATEDATE between to_date('"+sresult+"','dd/MM/yyyy HH24:MI:SS') and "
									+ "to_date('"+eresult+"','dd/MM/yyyy HH24:MI:SS') "
									+ "GROUP BY slr.OCTSLRLCODE,pot.ORDERID,pst.TRANSACTIONID,pst.USSID,pst.PSTPRODUCTNAME,pst.PSTSKUNO,"
									+ "pst.MRP,pst.PRICE,pst.SUBORDERTYPE,slv.OCTSLVCODE,pst.APPORTIONEDPRICE,com.COMMVALUE,"
									+ "com.TRXNCALCCOMMVAL,pro.PROMOTIONTYPECODE,pro.PROMOTIONCODE,pro.PROMOTIONVALUE,pro.TATAREIMBURSEMENT,"
									+ "smt.SMTCODE,pay.PAYMENTSTATUS,pay.PAYMENTDATE,pay.PAYMENTINFO "
									+ "order by slr.OCTSLRLCODE desc,pot.ORDERID desc,pst.TRANSACTIONID desc,pst.USSID desc,pst.PSTPRODUCTNAME desc,"
									+ "pst.PSTSKUNO desc,pst.MRP desc,pst.PRICE desc,pst.SUBORDERTYPE desc,slv.OCTSLVCODE desc,"
									+ "pst.APPORTIONEDPRICE desc,com.COMMVALUE desc,com.TRXNCALCCOMMVAL desc,pro.PROMOTIONTYPECODE desc,"
									+ "pro.PROMOTIONCODE desc,pro.PROMOTIONVALUE desc,pro.TATAREIMBURSEMENT desc,smt.SMTCODE desc,"
									+ "pay.PAYMENTSTATUS desc,pay.PAYMENTDATE desc,pay.PAYMENTINFO");*/

				queryString.append("SELECT pst.CREATEDATE,pst.ISCOD,smt.SMTCODE,p4.PARAMDESC,pot.ORDERREFNO,pot.ORDERID,"
						+ "pst.TRANSACTIONID,slr.OCTSLRLCODE,slr.OCTSLRLNAME,ship.AWBNUM,pbi.PBILISTINGID,pst.USSID,"
						+ "pst.DELIVERYDATE,men.CREATEDATE,smt.SMTCODE,pst.MODIDATE,pst.L1CATEGORY,slv.OCTSLVCODE,pst.STATECODE,pst.MRP,"
						+ "pst.SELLERDISCOUNT,pst.SCHEDULEDDELIVERYCHARGE,pst.TATADISCOUNT,tf.FEE_TYPE_CODE,tf.FEEVALUE,"
						+ "gst.GSTCGST,gst.GSTIGST,gst.GSTSGST,img.QCFAILIMGNAME1,pst.CLAIMREGDATE,pst.DISPUTECOMMENT,pst.QCFAILCOMMENT,pst.ISERQCAPPROVED,pst.ISERQCREJECT FROM ISMPST pst "
						+ "left join OCT_SLV slv ON slv.OCTSLVRFNUM=pst.PSTSLVRFNUM "
						+ "left join OCT_SLR slr ON slr.OCTSLRRFNUM=slv.OCTSLVSLR "
						+ "left join ISMPOT pot ON pot.POTRFNUM=pst.PSTPOTRFNUM "
						+ "left join ISMSMT smt ON smt.smtrfnum=pst.PSTSMTRFNUM "
						+ "left join ISMSSTL sstl ON sstl.SSTLSLVRFNUM=pst.PSTSLVRFNUM AND sstl.SSTLPSTRFNUM=pst.PSTRFNUM "
						+ "left join OCT_INBOUND_QCFAIL_IMAGES img ON img.QCFAILIMGPSTRFNUM=pst.PSTRFNUM "
						+ "left join OCT_TRXN_COMMISION com ON com.PSTRFNUM=pst.PSTRFNUM "
						+ "left join OCT_TRXN_PAYMENT_INFO pay ON pay.POTREFNUM=pot.POTRFNUM "
						+ "left join OCT_TRXN_PROMO pro ON pro.PSTRFNUM=pst.PSTRFNUM "
						+ "left join OCT_SHIPMENT ship ON ship.SHIPRFNUM=pst.PSTSHIPRFNUM "
						+ "left join OCT_SLR_PRODUCT sp on sp.SLRUSSID = pst.USSID "
						+ "left join ISMPBI pbi on pbi.PBIRFNUM = sp.SPPBIRFNUM "
						+ "left join OCT_MENIFESTO men on men.MENIFESTORFNUM=ship.MENIFESTO "
						+ "left join OCT_GSTSTATECODE_CONFIG gstsc on gstsc.GSTHSNSACCODE = pst.PSTHSNCODE "
						+ "left join OCT_PARAM p4 on p4.paramrfnum=pst.FULFILLMENTTYPE "
						+ "left join OCT_TRXN_FEE tf on tf.PSTRFNUM=pst.PSTRFNUM "
						+ "left join OCT_GSTSTATECODE_CONFIG gst on gst.GSTSLRRFNUM=slr.OCTSLRRFNUM "
						+ "where slv.OCTSLVCODE=:slvcode "
						+ "and pst.CREATEDATE between to_date('"+sresult+"','dd/MM/yyyy HH24:MI:SS') "
						+ "and to_date('"+eresult+"','dd/MM/yyyy HH24:MI:SS') "
						+ "GROUP BY pst.CREATEDATE,pst.ISCOD,pst.FULFILLMENTTYPE,pot.ORDERREFNO,pot.ORDERID,pst.TRANSACTIONID,slr.OCTSLRLCODE,"
						+ "slr.OCTSLRLNAME,ship.AWBNUM,pbi.PBILISTINGID,pst.USSID,pst.DELIVERYDATE,men.CREATEDATE,smt.SMTCODE,pst.L1CATEGORY,"
						+ "slv.OCTSLVCODE,pst.STATECODE,pst.MRP,pst.SELLERDISCOUNT,pst.SCHEDULEDDELIVERYCHARGE,pst.TATADISCOUNT,p4.PARAMDESC,"
						+ "tf.FEE_TYPE_CODE,tf.FEEVALUE,gst.GSTCGST,gst.GSTIGST,gst.GSTSGST,pst.MODIDATE,img.QCFAILIMGNAME1,pst.CLAIMREGDATE,pst.DISPUTECOMMENT,pst.QCFAILCOMMENT,pst.ISERQCAPPROVED,pst.ISERQCREJECT "
						+ "order by slr.OCTSLRLCODE desc,pot.ORDERID desc,pst.TRANSACTIONID desc,pst.USSID desc,smt.SMTCODE desc");
				//Shankar Start : TPR-6760
				Query query = getStatelessSession().createSQLQuery(queryString+"");
				query.setString("slvcode",slvcode);
				query.setReadOnly(true);
				rs = query.scroll(ScrollMode.FORWARD_ONLY);
			}
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}

	//@Shankar :: For TPR-7371 : Product level weight to be at seller & LP report START
	public ScrollableResults getListedProduct(String sellerCode){
		ScrollableResults rs = null;
		try {
			String strQuery="select sp.ismpbi.pbilistingid,sp.slrussid,sp.slrLength,sp.slrWidth,sp.slrHeight,sp.slrWeight from SlrProduct sp  where sp.octSlr.octslrlcode=:slrCode and sp.prodListingStatus.paramrfnum =136";
			Query query = getStatelessSession().createQuery(strQuery); 
			if (!"".equals(sellerCode) && sellerCode != null) {
				query.setString("slrCode", sellerCode);
			}
			query.setReadOnly(true);
			query.setFetchSize(1);

			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		}catch( HibernateException e){
			throw new  DAOException( e );
		}
		return rs;
	}
	//@Shankar :: For TPR-7371 : Product level weight to be at seller & LP report END

	//@Deepak Deshekar ::TPR -7488 Strt
	public ScrollableResults getErPendingQc(String startDate, String endDate,String slvCode,Long toState){//Shankar : TPR-12527
		ScrollableResults rs = null;
		try {
			StringBuffer sb = new StringBuffer();

			sb.append("select distinct sstl1.ismpst.pstrfnum,sstl1.ismpst.octSlv.octslvlname,"
					+ " sstl1.ismpst.ismpot.orderid,sstl1.ismpst.transactionid,sstl1.ismpst.octSlv.octSlr.octslrlname, "
					+ " sstl1.ismpst.returnfulfillmenttype.paramrfnum,sstl1.ismpst.returnlogisticprovidername,sstl1.ismpst.pstrfnum,"
					+ " sstl1.ismpst.pstrfnum,sstl1.ismpst.pstrfnum,sstl1.ismpst.sellercode,sstl1.ismpst.fulfillmenttype.paramrfnum,sstl1.createdate, "
					+ " sstl1.ismpst.octSlv.octslvcode,sstl1.ismpst.isretuirto,"
					+ " sstl1.ismpst.pstproductname,sstl1.ismpst.returnDeliveredDate from Ismsstl sstl1"
					+ " where sstl1.ismpst.p1slaveid=:slvCode and sstl1.sstlsmttstate=:toState and sstl1.ismpst.iserdeliver='Y' and (sstl1.ismpst.iserqcpass='N' and  sstl1.ismpst.iserqcfail='N') "
					+ " and (to_char(sstl1.createdate,'yyyy-MM-dd') >=:startDate and to_char(sstl1.createdate,'yyyy-MM-dd') <=:endDate) "
					+ " and sstl1.ismpst.deleted='N' ");

			Query query = getStatelessSession().createQuery(sb.toString()); 
			query.setLong("toState",toState);
			query.setString("slvCode", slvCode);
			query.setString("startDate", startDate);
			query.setString("endDate", endDate);
			query.setReadOnly(true);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}

	public ScrollableResults getErRejectTransaction(String startDate, String endDate,List toState,String slrcode){
		ScrollableResults rs = null;
		try {
			StringBuffer sb = new StringBuffer();

			sb.append("select sstl1.ismpst.pstrfnum,sstl1.ismpst.octSlv.octslvlname,sstl1.ismpst.ismpot.orderid,sstl1.ismpst.transactionid,sstl1.ismpst.octSlv.octSlr.octslrlname,"
					+" sstl1.ismpst.returnfulfillmenttype.paramdesc,sstl1.ismpst.returnlogisticprovidername,sstl1.ismpst.pstrfnum,sstl1.ismpst.pstrfnum,sstl1.ismpst.pstrfnum,"
					+" sstl1.sstlslrcode from Ismsstl sstl1 where sstl1.sstlsmttstate in (:toState) and  (to_char(sstl1.createdate,'dd/MM/yyyy HH24:mm:ss')>=:startDate and to_char(sstl1.createdate,'dd/MM/yyyy HH24:mm:ss')<=:endDate)"
					+" and  sstl1.ismpst.deleted='N' and sstl.sstlslrcode=:slrcode");
			sb.append(" order by sstl1.ismpst.modidate");
			Query query = getStatelessSession().createQuery(sb.toString()); 
			query.setParameterList("toState", toState);
			query.setString("slrcode", slrcode);
			query.setString("startDate", startDate);
			query.setString("endDate", endDate);
			query.setReadOnly(true);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}finally{		
		}
		return rs;
	}



	public ScrollableResults getErDisputeTransaction(List instatusLst,List notinstatusLst,String srlcode){
		ScrollableResults rs = null;
		try {
			StringBuffer sb = new StringBuffer();



			/*
							sb.append("select sstl1.ismpst.pstrfnum,sstl1.ismpst.octSlv.octslvlname,sstl1.ismpst.ismpot.orderid,sstl1.ismpst.transactionid,sstl1.ismpst.octSlv.octSlr.octslrlname,"
									+" sstl1.ismpst.returnfulfillmenttype,sstl1.ismpst.returnlogisticprovidername,sstl1.ismpst.pstrfnum,sstl1.ismpst.pstrfnum,sstl1.ismpst.pstrfnum,"
									+" sstl1.ismpst.octSlv.octSlr.octslrlcode from Ismsstl sstl1 where sstl1.ismpst.sellercode=:slrcode and sstl1.sstlsmttstate in (:instatusLst) "
									+ " and sstl1.ismpst.pstrfnum not in"
									+ " (select sstl2.ismpst.pstrfnum from Ismsstl sstl2 where sstl2.ismpst.sellercode=:slrcode"
									+ " and sstl2.sstlsmttstate in(:notinstatusLst) and sstl2.ismpst.deleted='N'"
									+ " and sstl2.ismpst.octSlv.octSlr.octslrlcode=:slrcode)"
									+ " and sstl1.ismpst.deleted='N'");*/


			sb.append("select sstl1.ismpst.pstrfnum,sstl1.ismpst.octSlv.octslvlname,sstl1.ismpst.ismpot.orderid,sstl1.ismpst.transactionid,sstl1.ismpst.octSlv.octSlr.octslrlname,"
					+" sstl1.ismpst.returnfulfillmenttype,sstl1.ismpst.returnlogisticprovidername,sstl1.ismpst.pstrfnum,sstl1.ismpst.pstrfnum,sstl1.ismpst.pstrfnum,"
					+" sstl1.ismpst.octSlv.octSlr.octslrlcode from Ismsstl sstl1 where sstl1.ismpst.sellercode=:slrcode and sstl1.sstlsmttstate in (:instatusLst) "
					+ " and (sstl1.ismpst.iserqcapproved='N' or sstl1.ismpst.iserqcapproved=null) and (sstl1.ismpst.iserqcreject='N' or sstl1.ismpst.iserqcreject=null) "
					+ " and sstl1.ismpst.deleted='N'");

			Query query = getStatelessSession().createQuery(sb.toString()); 
			query.setParameterList("instatusLst", instatusLst);
			//query.setParameterList("notinstatusLst", notinstatusLst);
			query.setString("slrcode", srlcode);
			query.setReadOnly(true);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}finally{		
		}
		return rs;
	}

	//@Deepak Deshekar ::TPR -7488 End

	//Shankar-Start 			
	public ScrollableResults getInventoryRecord(String sellerCode,String intType,String omniType) {
		ScrollableResults rs = null;
		try {
			StringBuffer sb = new StringBuffer();

			sb.append("select distinct acm.SLRCODE,TO_CHAR(acm.LASTUPDATE, 'dd/MM/yyyy-HH24:mm:ss'),acm.INTEGRATIONTYPE,acm.THRESHOLD,"
					+ "acm.SYNCFREQ,acm.STARTTIME,acm.ENDTIME,acm.MISSTORECOUNT,acm.FILEFREQ,acm.LOGRFNUM,acm.INVSOURCE,acm.INVSOURCE_KEY,"
					+ "acm.INTEGRATIONTYPE_KEY,acm.FILEFREQ_KEY,acm.OMNITYPE from OCT_ANY_CONFIG_MSTR acm where ");

			if(!"".equals(sellerCode) && sellerCode != null){
				sb.append(" acm.SLRCODE=:sellerCode ");
			}

			if(!"".equals(intType) && intType != null){
				sb.append(" acm.INTEGRATIONTYPE=:intType ");
			}

			if(!"".equals(omniType) && omniType != null){
				sb.append(" acm.OMNITYPE=:omniType ");
			}

			Query query = getStatelessSession().createSQLQuery(sb + "");
			if(!"".equals(sellerCode) && sellerCode != null){
				query.setString("sellerCode", sellerCode);
			}
			if(!"".equals(intType) && intType != null){
				query.setString("intType", intType);
			}
			if(!"".equals(omniType) && omniType != null){
				query.setString("omniType", omniType);
			}
			query.setReadOnly(true);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			throw new DAOException(e);
		} finally {
		}
		return rs;
	}

	
	public ScrollableResults getInventoryRecordByDefault(int start, int end) {
		ScrollableResults rs = null;
		try {
			StringBuffer sb = new StringBuffer();

			sb.append("select distinct acm.SLRCODE,TO_CHAR(acm.LASTUPDATE, 'dd/MM/yyyy-HH24:mi:ss'),acm.INTEGRATIONTYPE,acm.THRESHOLD,"
					+ "acm.SYNCFREQ,acm.STARTTIME,acm.ENDTIME,acm.MISSTORECOUNT,acm.FILEFREQ,acm.LOGRFNUM,acm.INVSOURCE,acm.INVSOURCE_KEY,"
					+ "acm.INTEGRATIONTYPE_KEY,acm.FILEFREQ_KEY,acm.OMNITYPE from OCT_ANY_CONFIG_MSTR acm where acm.ISACTIVE='Y' and acm.ISDELETED='N'");

			// Query query = getStatelessSession().createQuery(sb.toString());
			Query query = getStatelessSession().createSQLQuery(sb + "");
			if (start != 0 && end != 0) {
				query.setFirstResult(start);
				query.setMaxResults(end);
			}
			query.setReadOnly(true);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			throw new DAOException(e);
		} finally {
		}
		return rs;
	}
	//Shankar-End

	/*public ScrollableResults getSlrCodeMissStoreCount(int start, int end) {
		ScrollableResults rs = null;
		try {
			StringBuffer sb = new StringBuffer();

			sb.append("select distinct acm.SLRCODE,TO_CHAR(acm.LASTUPDATE, 'dd/MM/yyyy-HH24:mm:ss'),acm.INTEGRATIONTYPE,acm.THRESHOLD,acm.SYNCFREQ,acm.STARTTIME,acm.ENDTIME from OCT_ANY_CONFIG_MSTR acm where acm.ISACTIVE='Y' and acm.ISDELETED='N'");

			Query query = getStatelessSession().createSQLQuery(sb + "");
			if (start != 0 && end != 0) {
				query.setFirstResult(start);
				query.setMaxResults(end);
			}
			query.setReadOnly(true);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			throw new DAOException(e);
		} finally {
		}
		return rs;
	}*/

	//Shankar-Start
	public ScrollableResults getSellerWisePopUpCounts(String sqlQuery){
		ScrollableResults rs = null;
		try {
			String sQuery = sqlQuery;

			Query query = getStatelessSession().createSQLQuery(sQuery);
			query.setReadOnly(true);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}finally{		
		}
		return rs;
	}

	public ScrollableResults getSlaveWisePopUpCounts(String sqlQuery){
		ScrollableResults rs = null;
		try {
			String sQuery = sqlQuery;

			Query query = getStatelessSession().createSQLQuery(sQuery);
			query.setReadOnly(true);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}finally{		
		}
		return rs;
	}
	//Shanakar-End
	public ScrollableResults findPickListGenerated(Long pickId,Long slvRfNum) throws DAOException{
		ScrollableResults rs = null;
		String status = "PILIGENE";
		try {
			StringBuffer queryString = new StringBuffer();
			queryString.append("select pststyleno,pstcolour,pstsize,pstskuno,pstqty,octpick.pickid,octSlv.octslvcode,ismpot.orderrefno,ismpot.orderid,transactionid,ismpot.createdate,mrp,price,discount,pstproductname,shipstate,productcreatedate,l4category,productimageurl,pbiIdentityCodes from Ismpst where octSlv.octslvrfnum=:slvRfNum and ismsmt.smtcode=:status and octpick.pickid=:pickId");


			Query query = getStatelessSession().createQuery(queryString+"");

			if(pickId != null){
				query.setLong("pickId",pickId);
			}
			if(slvRfNum != null){
				query.setLong("slvRfNum",slvRfNum);
			}

			if(status!=null){
				query.setString("status",status);
			}
			query.setReadOnly(true);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}


	//@Deepak Deshekar :: FIND SELLER CATCODE AND CATNAME
	public ScrollableResults getSellerWiseCat(String slrcode){
		ScrollableResults rs = null;
		try {
			StringBuffer queryString = new StringBuffer();
			queryString.append("select ismcmt.cmtcode,ismcmt.cmtname from SlrCategoryAssociation slr where octSlr.octslrlcode=:slrcode and slr.deleted = 'N' order by ismcmt.cmtlevel");  //MDD 1.8 SD 

			Query query = getStatelessSession().createQuery(queryString+"");

			if(slrcode != null && !"".equals(slrcode)){
				query.setString("slrcode",slrcode);
			}
			query.setReadOnly(true);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}

	//@Deepak Deshekar :: FIND SELLER CATCODE AND CATNAME


	//@Deepak Deshekar :: FIND SELLER SKU 
	public ScrollableResults getSellerWiseSku(String slrcode){
		ScrollableResults rs = null;
		try {
			StringBuffer queryString = new StringBuffer();
			queryString.append("select slrprod.slrproductsku from SlrProduct slrprod where slrprod.octSlr.octslrlcode=:slrcode");
			Query query = getStatelessSession().createQuery(queryString+"");

			if(slrcode != null && !"".equals(slrcode)){
				query.setString("slrcode",slrcode);
			}
			query.setReadOnly(true);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}

	//@Deepak Deshekar :: FIND SELLER SKU 


	//@Deepak Deshekar :: FIND SELLER USSID
	public ScrollableResults getSellerWiseUSSID(String slrcode){
		ScrollableResults rs = null;
		try {
			StringBuffer queryString = new StringBuffer();
			queryString.append("select slrprod.slrussid from SlrProduct slrprod where slrprod.octSlr.octslrlcode=:slrcode");
			Query query = getStatelessSession().createQuery(queryString+"");

			if(slrcode != null && !"".equals(slrcode)){
				query.setString("slrcode",slrcode);
			}
			query.setReadOnly(true);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}

	//@Deepak Deshekar :: FIND SELLER USSID


	//@siddhesh :: sell now bulk download
	public ScrollableResults  findBySlrProductListptimizeNew(Long cmtrfnum,Long sellerrfnum) 
	{
		ScrollableResults rs = null;
		try{
			StringBuffer buffer = new StringBuffer();
			buffer.append("select slrp.sprfnum,slrp.slrproductsku,slrp.ismpbi.pbiidentityvalue,slrp.startdate,slrp.enddate,slrp.ismpbi.pbilistingid,slrp.slrHSNCode,slrp.slrLength,slrp.slrWidth,slrp.slrHeight,slrp.slrWeight,");
			buffer.append(" slrp.ismpbi.pbiidentityvalue2,slrp.ismpbi.pbiidentityvalue3");
			buffer.append(" from SlrProduct slrp,Ismppt ppt,Ismpbi pbi");
			buffer.append(" where slrp.ismpbi.pbirfnum = pbi.pbirfnum"); 
			buffer.append(" and ppt.ismpbi.pbirfnum = pbi.pbirfnum and"); 
			buffer.append(" ppt.ismcmt.cmtrfnum =:cmtrfnum and slrp.octSlr.octslrrfnum!= :sellerrfnum");		
			Query query = getStatelessSession().createQuery(buffer.toString()); 	
			query.setLong("cmtrfnum", cmtrfnum);
			query.setLong("sellerrfnum", sellerrfnum);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);	
		}catch(HibernateException e){
			throw new com.anm.hibernate.DAOException( e );
		}
		return rs;
	}

	/**
	 * Query for PDF data in Initiate Pack Screen
	 * @author  shankar.sadaye
	 * @version Sprint141 TPR-9732 
	 * @since   2018-09-03
	 */			
	public ScrollableResults findPackOrderStatusByPickIdOrDirectPickPDF(Long sellerRfNum, Long slvRfnum, String deliveryMode, Long pickId) throws DAOException{
		ScrollableResults rs = null;
		try {
			StringBuffer queryString = new StringBuffer();
			queryString.append("select pst.pstskuno,pst.mrp,pst.l4category,pst.pstproductname,pst.pststyleno,pst.pstsize,pst.pstcolour,"
					+ "pst.productimageurl,pst.pstqty,pst.pbiIdentityCodes from Ismpst pst "
					+ " where pst.ismsmt.smtcode='PICKCONF' "
					+ " and pst.fulfillmenttype.paramcode='TSHIP' and deleted='N' ");
			if(sellerRfNum != null){
				queryString.append("and  pst.ismpot.octSlr.octslrrfnum=:sellerRfNum ");
			}
			if(slvRfnum != null){
				queryString.append("and  pst.octSlv.octslvrfnum=:slvRfnum ");
			}
			if(pickId != null) {
				queryString.append(" and pst.octpick.pickrfnum=:pickId ");
			} else {
				queryString.append(" and pst.octpick.pickrfnum is null");
			}
			if(!"All".equalsIgnoreCase(deliveryMode)){
				if("CNC".equals(deliveryMode)) {
					queryString.append(" and pst.subordertype=:deliveryMode ");
				} else {
					queryString.append(" and (pst.deliverymode.paramcode=:deliveryMode and pst.subordertype!='CNC')");
				}
			}
			queryString.append(" order by pst.createdate desc");
			Query query = getStatelessSession().createQuery(queryString+"");

			if(sellerRfNum != null){
				query.setLong("sellerRfNum",sellerRfNum);
			}
			if(slvRfnum != null){
				query.setLong("slvRfnum",slvRfnum);
			}
			if(pickId != null) {
				query.setLong("pickId", pickId);
			}
			if(!"All".equalsIgnoreCase(deliveryMode)){
				query.setString("deliveryMode",deliveryMode);
			}
			query.setReadOnly(true);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}

	/**
	 * Query for PDF data in Pick Confirm Screen
	 * @author  shankar.sadaye
	 * @version Sprint141 TPR-9732 
	 * @since   2018-09-03
	 */		
	public ScrollableResults findPickListGeneratedPDF(Long pickId,Long slvRfNum) throws DAOException{
		ScrollableResults rs = null;
		String status = "PILIGENE";
		try {
			StringBuffer queryString = new StringBuffer();
			queryString.append("select pst.pstskuno,pst.mrp,pst.l4category,pst.pstproductname,pst.pststyleno,pst.pstsize,pst.pstcolour,"
					+ "pst.productimageurl,pst.pstqty,pst.pbiIdentityCodes from Ismpst pst where "
					+ "octSlv.octslvrfnum=:slvRfNum and ismsmt.smtcode=:status and octpick.pickid=:pickId");

			Query query = getStatelessSession().createQuery(queryString+"");

			if(pickId != null){
				query.setLong("pickId",pickId);
			}
			if(slvRfNum != null){
				query.setLong("slvRfNum",slvRfNum);
			}

			if(status!=null){
				query.setString("status",status);
			}
			query.setReadOnly(true);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}

	//@Nishant added for TPR-7410 Start
	public ScrollableResults findByProdReport(String startDate,String endDate, int from, int to,String slrcode){

		ScrollableResults rs=null;
		String queryString=" ";
		if(startDate!=null && endDate!=null )
		{			
			startDate = startDate +" 00:00:00";
			endDate = endDate +" 23:59:59";


			if(startDate.equals(endDate) ){
				/*startDate.setHours(23);
							startDate.setMinutes(59);
							startDate.setSeconds(59);*/
				startDate = startDate+"23:59:59";
			}
		}
		try {
			if(startDate != null && endDate != null && !"".equals(startDate) && !"".equals(endDate)){
				queryString = "SELECT TO_CHAR(pot.CREATEDATE, 'DD-MM-YYYY'),TO_CHAR(pot.CREATEDATE, 'HH24:MI:SS'),pot.ORDERID,pst.TRANSACTIONID,smt.SMTCODE,"//0-4
						+ "slr.OCTSLRLCODE,pbi.PBILISTINGID,pst.MRP,pst.PRICE,pst.NETAMOUNT,"//5-9
						+ "(select listagg(PROMOTIONVALUE, ',') within group (order by PSTRFNUM) from OCT_TRXN_PROMO prom where prom.PSTRFNUM=pst.PSTRFNUM),"
						+ "(select listagg(PROMOTIONCODE, ',') within group (order by PSTRFNUM) from OCT_TRXN_PROMO prom where prom.PSTRFNUM=pst.PSTRFNUM),"
						+ "(select listagg(PROMOTIONVALUE, ',') within group (order by PSTRFNUM) from OCT_TRXN_PROMO prom where prom.PSTRFNUM=pst.PSTRFNUM AND prom.PROMOTIONTYPECODE='C'),"
						+ "(select listagg(PROMOTIONCODE, ',') within group (order by PSTRFNUM) from OCT_TRXN_PROMO prom where prom.PSTRFNUM=pst.PSTRFNUM AND prom.PROMOTIONTYPECODE='C'),"
						+ "CASE WHEN pst.ISCOD = 'Y' THEN 'COD' ELSE 'PREPAID' END,"
						+ "pot.CUSTOMERID,pot.ORDERREFNO,slr.OCTSLRNAME,p1.PARAMVALUE,"
						+ "(SELECT ALNAME FROM OCT_ATTR_LOV WHERE ALCODE IN( SELECT SPADVALUE FROM OCT_SLR_PROD_ATTR_DATA spad where spad.SPADSPRFNUM = sp.SPRFNUM AND spad.SPADAMRFNUM IN(SELECT AMRFNUM FROM OCT_ATTR_MSTR WHERE AMCODE='brand') and ROWNUM = 1) AND ALGROUPCODE='brand'),"
						+ "pst.L4CATEGEGORY,pst.L3CATEGORY,pst.L2CATEGORY,pst.L1CATEGORY"
						+ " from ISMPST pst  left join OCT_SLV slv on slv.OCTSLVRFNUM=pst.PSTSLVRFNUM"
						+ " left join OCT_SLR slr on slr.OCTSLRRFNUM=slv.OCTSLVSLR"
						+ " left join ISMPOT pot on pot.POTRFNUM=pst.PSTPOTRFNUM "
						+ "left join OCT_PARAM p1 on p1.paramrfnum=pot.ORDERTYPE"
						+ " left join ISMSMT smt on smt.smtrfnum=pst.pstsmtrfnum "
						+ "left join OCT_SLR_PRODUCT sp on pst.USSID=sp.SLRUSSID "
						+ "left join ISMPBI pbi on pbi.pbirfnum=sp.SPPBIRFNUM "
						+ "where pst.createdate between to_date(:startDate,'dd/MM/yyyy HH24:MI:SS') and to_date(:endDate,'dd/MM/yyyy HH24:MI:SS') and pst.deleted='N'";
			}

			if(slrcode != null && !"".equals(slrcode)){
				queryString = queryString+" and pst.sellercode=:slrcode";
			}

			Query query = getStatelessSession().createSQLQuery(queryString.toString()); 
			if(slrcode!= null && !"".equals(slrcode))
				query.setString("slrcode", slrcode);


			if(startDate != null && endDate != null && !"".equals(startDate) && !"".equals(endDate)){
				query.setParameter("startDate", startDate);
				query.setParameter("endDate", endDate);
			}

			query.setReadOnly(true);
			query.setFirstResult(from);
			query.setMaxResults(to);


			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	} 

	public ScrollableResults findByCommReconciliationReport(String startDate,String endDate, int from, int to,String slrcode){

		ScrollableResults rs=null;
		String queryString=" ";
		if(startDate!=null && endDate!=null )
		{			
			startDate = startDate +" 00:00:00";
			endDate = endDate +" 23:59:59";


			if(startDate.equals(endDate) ){
				/*startDate.setHours(23);
							startDate.setMinutes(59);
							startDate.setSeconds(59);*/
				startDate = startDate+"23:59:59";
			}
		}
		try {
			if(startDate != null && endDate != null && !"".equals(startDate) && !"".equals(endDate)){
				queryString = "select slr.OCTSLRLCODE,pot.ORDERID,pst.TRANSACTIONID,pst.PSTSKUNO,smt.SMTCODE,pst.PRICE,pst.SELLERDISCOUNT,pst.APPORTIONEDPRICE,comm.TRXNCALCCOMMVAL,comm.COMMVALUE,comm.COMMVALUETYPE"
						+" from OCT_TRXN_COMMISION comm "
						+ "left join ISMPST pst on pst.pstrfnum = comm.PSTRFNUM "
						+ "left join ISMPOT pot on pst.PSTPOTRFNUM=pot.POTRFNUM "
						+ "left join OCT_SLR slr on pot.SELLERREF=slr.OCTSLRRFNUM "
						+ "left join  ISMSMT smt on pst.PSTSMTRFNUM=smt.SMTRFNUM "
						//+ "left join OCT_SLR_PRODUCT sp on pst.USSID=sp.SLRUSSID "
						//+ "left join OCT_SHIPMENT ship on pst.PSTSHIPRFNUM=ship.SHIPRFNUM "
						//+ "left join OCT_MENIFESTO meni on ship.MENIFESTO= meni.MENIFESTORFNUM "
						+ "left join ismstl stl on stl.STLPSTRFNUM=pst.pstrfnum and stl.stlsmttstate in (2247,2393) "
						//+ "where meni.createdate between to_date(:startDate,'dd/MM/yyyy HH24:MI:SS') and to_date(:endDate,'dd/MM/yyyy HH24:MI:SS') and pst.deleted='N'";
						+ "where stl.CREATEDATE between to_date(:startDate,'dd/MM/yyyy HH24:MI:SS') and to_date(:endDate,'dd/MM/yyyy HH24:MI:SS') and pst.deleted='N'";
			}

			if(slrcode != null && !"".equals(slrcode)){
				queryString = queryString+" and pst.sellercode=:slrcode";
			}

			Query query = getStatelessSession().createSQLQuery(queryString.toString()); 

			if(slrcode!= null && !"".equals(slrcode))
				query.setString("slrcode", slrcode);


			if(startDate != null && endDate != null && !"".equals(startDate) && !"".equals(endDate)){
				query.setParameter("startDate", startDate);
				query.setParameter("endDate", endDate);
			}

			query.setReadOnly(true);
			query.setFirstResult(from);
			query.setMaxResults(to);


			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}

	public ScrollableResults findBycommReconciliationCount(String startDate,String endDate,int from, int to,String slrcode){

		ScrollableResults rs=null;
		String queryString=" ";
		if(startDate!=null && endDate!=null )
		{			

			startDate = startDate +" 00:00:00";
			endDate = endDate +" 23:59:59";

			if(startDate.equals(endDate) ){
				startDate = startDate +" 23:59:59";
			}
		}
		try {
			if(startDate != null && endDate != null && !"".equals(startDate) && !"".equals(endDate)){
				queryString ="select count(*) "
						+" from OCT_TRXN_COMMISION comm "
						+ "left join ISMPST pst on pst.pstrfnum = comm.PSTRFNUM "
						//+ " left join ISMPOT pot on pst.PSTPOTRFNUM=pot.POTRFNUM "
						//+ "left join OCT_SLR slr on pot.SELLERREF=slr.OCTSLRRFNUM"
						//	+ " left join  ISMSMT smt on pst.PSTSMTRFNUM=smt.SMTRFNUM "
						//+ "left join OCT_SLR_PRODUCT sp on pst.USSID=sp.SLRUSSID "
						//+ "left join OCT_SHIPMENT ship on pst.PSTSHIPRFNUM=ship.SHIPRFNUM "
						+ "left join ismstl stl on stl.STLPSTRFNUM=pst.pstrfnum and stl.stlsmttstate in (2247,2393)"
						//	+ "left join OCT_MENIFESTO meni on ship.MENIFESTO= meni.MENIFESTORFNUM  "
						//	+ "where meni.createdate between to_date(:startDate,'dd/MM/yyyy HH24:MI:SS') and to_date(:endDate,'dd/MM/yyyy HH24:MI:SS') and pst.deleted='N'";
						+ "where stl.CREATEDATE between to_date(:startDate,'dd/MM/yyyy HH24:MI:SS') and to_date(:endDate,'dd/MM/yyyy HH24:MI:SS') and pst.deleted='N'";
			}


			if(slrcode != null && !"".equals(slrcode)){
				queryString = queryString+" and pst.sellercode=:slrcode";
			}

			Query query = getStatelessSession().createSQLQuery(queryString.toString()); 

			if(slrcode!= null && !"".equals(slrcode))
				query.setString("slrcode", slrcode);

			if(startDate != null && endDate != null && !"".equals(startDate) && !"".equals(endDate)){
				query.setParameter("startDate", startDate);
				query.setParameter("endDate", endDate);
			}

			query.setReadOnly(true);    	

			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}
	//@Nishant added for TPR-7410 End

	//@Suraj Tiwari for TPR :::: 10981 -Seller Wise Sku Price Downlod Report,Search and Count Start 

	public ScrollableResults findProductInfoFromCatAndSellers(List<String> octslrlcode,int from, int max,List<Long> cmtrfnum){
		ScrollableResults rs=null;
		String queryString=" ";
		try{

			queryString="select sp.sprfnum,pbi.PBINAME,slr.OCTSLRNAME,sp.SLRPRODUCTSKU,pbi.PBILISTINGID,sp.SLRUSSID,spp.SPPPRICE,spp.SPOFFERPRICE from OCT_SLR_PRODUCT_PRICE spp "
					+"right join OCT_SLR_PRODUCT sp on sp.SPRFNUM=spp.SPPSPRFNUM "
					+"left join oct_slr slr on slr.octslrrfnum=sp.SPSLRRFNUM "
					+"left join ISMPBI pbi on pbi.pbirfnum=sp.SPPBIRFNUM "
					+"left join OCT_PARAM param on param.paramrfnum=sp.PRODLISTINGSTATUS "
					+"LEFt JOIN ISMPPT ppt ON ppt.PPTPBIRFNUM = pbi.PBIRFNUM "
					+"LEFT JOIN ISMCPT t1 ON t1.CPTCMTRFNUM = ppt.PPTCMTRFNUM "
					+"LEFT JOIN ISMCPT t2 ON (t2.CPTCMTRFNUM = t1.CPTCMTRFNUM1) "
					+"LEFT JOIN ISMCPT t3 ON (t3.CPTCMTRFNUM = t2.CPTCMTRFNUM1) "
					+"LEFT JOIN ISMCPT t4 ON (t4.CPTCMTRFNUM = t3.CPTCMTRFNUM1) "
					+"LEFT JOIN ISMCMT c1 ON (c1.CMTRFNUM = t1.CPTCMTRFNUM) "
					+"LEFT JOIN ISMCMT c2 ON (c2.CMTRFNUM = t2.CPTCMTRFNUM) "
					+"LEFT JOIN ISMCMT c3 ON (c3.CMTRFNUM = t3.CPTCMTRFNUM) "
					+"LEFT JOIN ISMCMT c4 ON (c4.CMTRFNUM = t4.CPTCMTRFNUM) "
					+"where param.PARAMCODE='LISTED' and sp.DELETED='N' ";
			if(cmtrfnum!=null && cmtrfnum.size()>0){
				queryString=queryString+" and  c1.cmtrfnum in (:cmtrfnum)";
			}
			if(octslrlcode!=null && octslrlcode.size()>0){
				queryString=queryString+" and slr.octslrlcode in (:octslrlcode)";
			}
			Query query = getStatelessSession().createSQLQuery(queryString.toString()); 
			if(cmtrfnum!=null && cmtrfnum.size()>0){
				query.setParameterList("cmtrfnum", cmtrfnum);
			}
			if(octslrlcode!=null && octslrlcode.size()>0){
				query.setParameterList("octslrlcode", octslrlcode);
			}
			query.setReadOnly(true); 
			query.setFirstResult(from);
			query.setMaxResults(max);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		}catch (HibernateException e) {
			throw new DAOException(e);
		} 
		return rs;
	}

	public ScrollableResults findProductInfoFromProductAndSellersDownload(List<String> octslrlcode,List<Long> cmtrfnum){
		ScrollableResults rs=null;
		String queryString=" ";
		try{

			queryString="select sp.sprfnum,pbi.PBINAME,slr.OCTSLRNAME,sp.SLRPRODUCTSKU,pbi.PBILISTINGID,sp.SLRUSSID,spp.SPPPRICE,spp.SPOFFERPRICE from OCT_SLR_PRODUCT_PRICE spp "
					+"right join OCT_SLR_PRODUCT sp on sp.SPRFNUM=spp.SPPSPRFNUM "
					+"left join oct_slr slr on slr.octslrrfnum=sp.SPSLRRFNUM "
					+"left join ISMPBI pbi on pbi.pbirfnum=sp.SPPBIRFNUM "
					+"left join OCT_PARAM param on param.paramrfnum=sp.PRODLISTINGSTATUS "
					+"LEFt JOIN ISMPPT ppt ON ppt.PPTPBIRFNUM = pbi.PBIRFNUM "
					+"LEFT JOIN ISMCPT t1 ON t1.CPTCMTRFNUM = ppt.PPTCMTRFNUM "
					+"LEFT JOIN ISMCPT t2 ON (t2.CPTCMTRFNUM = t1.CPTCMTRFNUM1) "
					+"LEFT JOIN ISMCPT t3 ON (t3.CPTCMTRFNUM = t2.CPTCMTRFNUM1) "
					+"LEFT JOIN ISMCPT t4 ON (t4.CPTCMTRFNUM = t3.CPTCMTRFNUM1) "
					+"LEFT JOIN ISMCMT c1 ON (c1.CMTRFNUM = t1.CPTCMTRFNUM) "
					+"LEFT JOIN ISMCMT c2 ON (c2.CMTRFNUM = t2.CPTCMTRFNUM) "
					+"LEFT JOIN ISMCMT c3 ON (c3.CMTRFNUM = t3.CPTCMTRFNUM) "
					+"LEFT JOIN ISMCMT c4 ON (c4.CMTRFNUM = t4.CPTCMTRFNUM) "
					+"where param.PARAMCODE='LISTED' and sp.DELETED='N' ";
			if(cmtrfnum!=null){
				queryString=queryString+" and  c1.cmtrfnum in (:cmtrfnum)";
			}
			if(octslrlcode!=null && octslrlcode.size()>0){
				queryString=queryString+" and slr.octslrlcode in (:octslrlcode)";
			}
			Query query = getStatelessSession().createSQLQuery(queryString.toString()); 
			if(cmtrfnum!=null && cmtrfnum.size()>0){
				query.setParameterList("cmtrfnum", cmtrfnum);
			}
			if(octslrlcode!=null && octslrlcode.size()>0){
				query.setParameterList("octslrlcode", octslrlcode);
			}
			query.setReadOnly(true); 
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		}catch (HibernateException e) {
			throw new DAOException(e);
		} 
		return rs;
	}

	public ScrollableResults findProductInfoFromProductAndSellersCount(List<String> octslrlcode,List<Long> cmtrfnum){
		ScrollableResults rs=null;
		String queryString=" ";
		try{

			queryString="select count(sp.SPRFNUM) from OCT_SLR_PRODUCT_PRICE spp "
					+"right join OCT_SLR_PRODUCT sp on sp.SPRFNUM=spp.SPPSPRFNUM "
					+"left join oct_slr slr on slr.octslrrfnum=sp.SPSLRRFNUM "
					+"left join ISMPBI pbi on pbi.pbirfnum=sp.SPPBIRFNUM "
					+"left join OCT_PARAM param on param.paramrfnum=sp.PRODLISTINGSTATUS "
					+"LEFt JOIN ISMPPT ppt ON ppt.PPTPBIRFNUM = pbi.PBIRFNUM "
					+"LEFT JOIN ISMCPT t1 ON t1.CPTCMTRFNUM = ppt.PPTCMTRFNUM "
					+"LEFT JOIN ISMCPT t2 ON (t2.CPTCMTRFNUM = t1.CPTCMTRFNUM1) "
					+"LEFT JOIN ISMCPT t3 ON (t3.CPTCMTRFNUM = t2.CPTCMTRFNUM1) "
					+"LEFT JOIN ISMCPT t4 ON (t4.CPTCMTRFNUM = t3.CPTCMTRFNUM1) "
					+"LEFT JOIN ISMCMT c1 ON (c1.CMTRFNUM = t1.CPTCMTRFNUM) "
					+"LEFT JOIN ISMCMT c2 ON (c2.CMTRFNUM = t2.CPTCMTRFNUM) "
					+"LEFT JOIN ISMCMT c3 ON (c3.CMTRFNUM = t3.CPTCMTRFNUM) "
					+"LEFT JOIN ISMCMT c4 ON (c4.CMTRFNUM = t4.CPTCMTRFNUM) "
					+"where param.PARAMCODE='LISTED' and sp.DELETED='N' ";
			if(cmtrfnum!=null){
				queryString=queryString+" and  c1.cmtrfnum in (:cmtrfnum)";
			}
			if(octslrlcode!=null && octslrlcode.size()>0){
				queryString=queryString+" and slr.octslrlcode in (:octslrlcode)";
			}
			Query query = getStatelessSession().createSQLQuery(queryString.toString()); 
			if(cmtrfnum!=null && cmtrfnum.size()>0){
				query.setParameterList("cmtrfnum", cmtrfnum);
			}
			if(octslrlcode!=null && octslrlcode.size()>0){
				query.setParameterList("octslrlcode", octslrlcode);
			}
			query.setReadOnly(true); 
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		}catch (HibernateException e) {
			throw new DAOException(e);
		} 
		return rs;
	}


	//@Suraj Tiwari for TPR :::: 10981 -Seller Wise Sku Price Downlod Report,Search and Count End

	//@Nikhil.S TPR-10473
	public ScrollableResults findSalesInvoiceStatus(String startDate,String endDate,String transactionid,String ficoInvoiceRemark, int from, int to){	
		ScrollableResults rs = null;
		try {
			StringBuffer buffer = new StringBuffer();
			if (startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
				startDate = startDate + " 00:00:00";
				endDate = endDate + " 23:59:59";
				buffer.append("select pst.transactionid,pst.createdate,pst.ficoInvoiceRemark,pst.ficoNORStatus,pst.ficoRRFStatus From Ismpst pst");

				buffer.append(" where pst.createdate between to_date(:startDate,'dd/MM/yyyy HH24:MI:SS') and to_date(:endDate,'dd/MM/yyyy HH24:MI:SS') and pst.deleted='N' ");
			}
			if(transactionid != null && !"".equals(transactionid)){	
				buffer.append(" and pst.transactionid=:transactionid ");
			}
			buffer.append(" and (pst.isinvoicesent is not null OR pst.isrevinvoicesent is not null)");
			if(ficoInvoiceRemark != null && !"".equals(ficoInvoiceRemark)){
				buffer.append(" and (pst.ficoNORStatus=:ficoInvoiceRemark OR pst.ficoRRFStatus=:ficoInvoiceRemark) ");
			}
			buffer.append(" order by pst.createdate");

			Query query = getStatelessSession().createQuery(buffer.toString()); 
			if(transactionid != null && !"".equals(transactionid)){
				query.setString("transactionid", transactionid);
			}
			if(ficoInvoiceRemark != null && !"".equals(ficoInvoiceRemark)){
				query.setString("ficoInvoiceRemark", ficoInvoiceRemark);
			}
			/*if(ficoInvoiceRemark != null && !"".equals(ficoInvoiceRemark)){
		 				query.setString("ficoInvoiceRemark", ficoInvoiceRemark);
		 			}*/
			if(startDate != null && !"".equals(startDate)){
				query.setString("startDate", startDate);
			}if(endDate != null && !"".equals(endDate)){
				query.setString("endDate", endDate);
			}

			query.setFirstResult(from);
			query.setMaxResults(to);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} 
		catch (HibernateException e) {
			e.printStackTrace();
		}
		return rs;
	}


	//@Nikhil.S TPR-10473
	public int findSalesInvoiceStatusCount(String startDate,String endDate,String transactionid, String ficoInvoiceRemark){	
		List retvallist = null;
		Session hibSession = null;
		int Count=0;
		try {
			StringBuffer buffer = new StringBuffer();
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			if (startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
				startDate = startDate + " 00:00:00";
				endDate = endDate + " 23:59:59";
				buffer.append("select Count(pst.pstrfnum) From Ismpst pst where pst.createdate between to_date(:startDate,'dd/MM/yyyy HH24:MI:SS') and to_date(:endDate,'dd/MM/yyyy HH24:MI:SS') and pst.deleted='N' ");
			}
			if(transactionid != null && !"".equals(transactionid)){	
				buffer.append(" and pst.transactionid=:transactionid");
			}
			buffer.append(" and (pst.isinvoicesent is not null OR pst.isrevinvoicesent is not null)");
			if(ficoInvoiceRemark != null && !"".equals(ficoInvoiceRemark)){
				buffer.append(" and (pst.ficoNORStatus=:ficoInvoiceRemark OR pst.ficoRRFStatus=:ficoInvoiceRemark) ");
			}

			Query query = hibSession.createQuery(buffer.toString());
			if(transactionid != null && !"".equals(transactionid)){
				query.setString("transactionid", transactionid);
			}
			if(ficoInvoiceRemark != null && !"".equals(ficoInvoiceRemark)){
				query.setString("ficoInvoiceRemark", ficoInvoiceRemark);
			}
			if(startDate != null && !"".equals(startDate)){
				query.setString("startDate", startDate);
			}
			if(endDate != null && !"".equals(endDate)){
				query.setString("endDate", endDate);
			}

			retvallist=query.list();
			if(retvallist!=null && retvallist.size()>0){
				Count = (int) retvallist.get(0);
			}
		} 
		catch (HibernateException e) {
			e.printStackTrace();
		}
		return Count;
	}


	//@Nikhil.S TPR-10473 For Download
	public ScrollableResults findSalesInvoiceStatusForDownload(String startDate,String endDate,String transactionid,String ficoInvoiceRemark){	
		ScrollableResults rs = null;
		try {
			StringBuffer buffer = new StringBuffer();
			if (startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
				startDate = startDate + " 00:00:00";
				endDate = endDate + " 23:59:59";
				buffer.append("select pst.transactionid,pst.createdate,pst.ficoInvoiceRemark,pst.ficoNORStatus,pst.ficoRRFStatus From Ismpst pst");

				buffer.append(" where pst.createdate between to_date(:startDate,'dd/MM/yyyy HH24:MI:SS') and to_date(:endDate,'dd/MM/yyyy HH24:MI:SS') and pst.deleted='N' ");
			}
			if(transactionid != null && !"".equals(transactionid)){	
				buffer.append(" and pst.transactionid=:transactionid");
			}
			buffer.append(" and (pst.isinvoicesent is not null OR pst.isrevinvoicesent is not null)");
			if(ficoInvoiceRemark != null && !"".equals(ficoInvoiceRemark)){
				buffer.append(" and (pst.ficoNORStatus=:ficoInvoiceRemark OR pst.ficoRRFStatus=:ficoInvoiceRemark) ");
			}
			buffer.append(" order by pst.createdate");
			Query query = getStatelessSession().createQuery(buffer.toString()); 
			if(transactionid != null && !"".equals(transactionid)){
				query.setString("transactionid", transactionid);
			}
			if(ficoInvoiceRemark != null && !"".equals(ficoInvoiceRemark)){
				query.setString("ficoInvoiceRemark", ficoInvoiceRemark);
			}
			if(startDate != null && !"".equals(startDate)){
				query.setString("startDate", startDate);
			}
			if(endDate != null && !"".equals(endDate)){
				query.setString("endDate", endDate);
			}

			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} 
		catch (HibernateException e) {
			e.printStackTrace();
		}
		return rs;
	}

	//Shankar Start : TPR-11602 : Seller Notifications
	public ScrollableResults getErPickUpAndDeliverdBySlrCode(String slaveCode,List<Long> pstRfNumList){//Shankar : TPR-12527
		ScrollableResults rs = null;
		try {
			StringBuffer sb = new StringBuffer();

			sb.append("select distinct sstl1.ismpst.pstrfnum,sstl1.ismpst.octSlv.octslvcode,sstl1.ismpst.ismpot.orderid,"
					+ "sstl1.ismpst.transactionid,sstl1.ismpst.octSlv.octSlr.octslrlname,sstl1.ismpst.isretuirto,"
					+ "sstl1.ismpst.iserpickup,sstl1.ismpst.iserdeliver,sstl1.ismpst.returnlogisticprovidername,"
					+ "sstl1.ismpst.shipment.awbnum,sstl1.ismpst.cirRtoDate,sstl1.ismpst.returnDeliveredDate,"
					+ "sstl1.ismpst.pstproductname,sstl1.ismpst.shipment.octinvoice.autoGenInvoice,"
					+ "sstl1.ismpst.p1logisticname,sstl1.ismpst.reverseshipment.awbnum"
					+ " from Ismsstl sstl1 left join sstl1.ismpst.reverseshipment where sstl1.ismpst.p1slaveid=:slaveCode and sstl1.ismpst.pstrfnum IN (:pstRfNumList)"
					+ " and sstl1.ismpst.deleted='N' ");

			Query query = getStatelessSession().createQuery(sb.toString()); 
			query.setParameterList("pstRfNumList", pstRfNumList);
			query.setString("slaveCode", slaveCode);
			query.setReadOnly(true);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}

	public ScrollableResults getDisputeClosed(Long pstrfnum){
		ScrollableResults rs = null;
		try {
			StringBuffer sb = new StringBuffer();

			sb.append("select distinct sstl1.ismpst.pstrfnum,sstl1.ismpst.octSlv.octslvcode,sstl1.ismpst.ismpot.orderid,sstl1.ismpst.transactionid,"
					+ " sstl1.ismpst.octSlv.octSlr.octslrlname,sstl1.ismpst.isretuirto,sstl1.ismpst.pstproductname,"
					+ " sstl1.ismpst.qcreasoncode,sstl1.ismpst.erCompensationrate,sstl1.ismpst.disputecomment,"
					+ " sstl1.ismpst.octDisputeTicket.octticketid,sstl1.ismpst.iserqcapproved,sstl1.ismpst.iserqcreject,sstl1.ismpst.sellercode "
					+ " from Ismsstl sstl1 where sstl1.ismpst.pstrfnum=:pstrfnum ");

			Query query = getStatelessSession().createQuery(sb.toString()); 
			query.setLong("pstrfnum",pstrfnum);
			query.setReadOnly(true);
			query.setMaxResults(1);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}

	public ScrollableResults getDisputeRaised(Long pstrfnum){
		ScrollableResults rs = null;
		try {
			StringBuffer sb = new StringBuffer();

			sb.append("select distinct sstl1.ismpst.pstrfnum,sstl1.ismpst.octSlv.octslvcode,sstl1.ismpst.ismpot.orderid,sstl1.ismpst.transactionid,"
					+ " sstl1.ismpst.octSlv.octSlr.octslrlname,sstl1.ismpst.isretuirto,sstl1.ismpst.pstproductname,"
					+ " sstl1.ismpst.qcreasoncode,sstl1.ismpst.sellercode,sstl1.ismpst.octDisputeTicket.octticketid "
					+ " from Ismsstl sstl1 where sstl1.ismpst.pstrfnum=:pstrfnum ");

			Query query = getStatelessSession().createQuery(sb.toString()); 
			query.setLong("pstrfnum",pstrfnum);
			query.setReadOnly(true);
			query.setMaxResults(1);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}
	//Shankar End: TPR-11602 : Seller Notifications

	public ScrollableResults getDisputeCreate(Long pstrfnum){
		ScrollableResults rs = null;
		try {
			String  sb ="select tick.OCTTICKETID,'('||slr.OCTSLRLCODE||') '||slr.OCTSLRNAME as Seller_ID_and_Seller_Name,"
					+ " '('||slv.OCTSLVCODE||') '||slv.OCTSLVNAME as Slave_ID_and_Slave_Name,stl.createdate,disprsn.paramdesc AS DISPUTEREASON,"
					+ " case pst.erDisputeType when 'Admin' then 'Dispute Admin' else 'Dispute Handler' end as Role_Pending_with,pst.PSTPRODUCTNAME as PRODUCT_DETAILS,rship.AWBNUM as REVERSEAWBNUMBER,"
					+ " pst.transactionid,pst.pstskuno as PRODUCTID1,case pst.erDisputeType when 'Admin' then 'TUL Raised' else 'Seller Raised' end as TICKETSTATUS "
					+ " from Ismsstl stl "
					+ " left join Ismpst pst on stl.SSTLPSTRFNUM = pst.pstrfnum "
					+ " left join OCT_DISPUTETICKET tick on tick.OCTTICKETPST = pst.PSTRFNUM "
					+ " left join oct_slr slr on slr.octslrlcode = pst.sellercode "
					+ " left join oct_slv slv on slv.OCTSLVCODE = pst.p1slaveid "
					+ " left join oct_param disprsn on disprsn.paramcode = pst.qcreasoncode "
					+ " left join OCT_SHIPMENT rship on rship.SHIPRFNUM=pst.PSTREVERSESHIPRFNUM "
					+ " where pst.pstrfnum = :pstrfnum and disprsn.paramgroup= 'REJECTION_REASON_SHD' and (stl.SSTLSMTTSTATE = 2426 or stl.SSTLSMTTSTATE = 2238)  and disprsn.deleted='N'";

			Query query = getStatelessSession().createSQLQuery(sb);
			query.setLong("pstrfnum", pstrfnum);
			query.setMaxResults(1);
			rs = query.scroll();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}


	public ScrollableResults getDisputeApprovedReject(Long pstrfnum){
		Session hibSession = null;
		ScrollableResults rs = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			String  sb ="select tick.OCTTICKETID,'('||slr.OCTSLRLCODE||') '||slr.OCTSLRNAME as Seller_ID_and_Seller_Name,"
					+ " '('||slv.OCTSLVCODE||') '||slv.OCTSLVNAME as Slave_ID_and_Slave_Name,stl.createdate,disprsn.paramdesc AS DISPUTEREASON,"
					+ " case pst.erDisputeType when 'Admin' then 'Dispute Admin' else 'Dispute Handler' end as Role_Pending_with,pst.PSTPRODUCTNAME as PRODUCT_DETAILS,rship.AWBNUM as REVERSEAWBNUMBER,"
					+ " pst.transactionid,pst.pstskuno as PRODUCTID1,case pst.erDisputeType when 'Admin' then 'TUL Raised' else 'Seller Raised' end as TICKETSTATUS,pst.actualcompvalue as FINALPAYOUT,pst.PRICE as MOP,pst.disputecomment as APPROVECOMMENT,"
					+ " case pst.erDisputeType when 'Y' then 'Dispute Admin' else 'Dispute Handler' end as Approve_Role,pst.actualcomppercent as SETTLEMENTPERCENTAGE "
					+ " from Ismsstl stl "
					+ " left join Ismpst pst on stl.SSTLPSTRFNUM = pst.pstrfnum "
					+ " left join OCT_DISPUTETICKET tick on tick.OCTTICKETPST = pst.PSTRFNUM "
					+ " left join oct_slr slr on slr.octslrlcode = pst.sellercode "
					+ " left join oct_slv slv on slv.OCTSLVCODE = pst.p1slaveid "
					+ " left join oct_param disprsn on disprsn.paramcode = pst.qcreasoncode "
					+ " left join OCT_SHIPMENT rship on rship.SHIPRFNUM=pst.PSTREVERSESHIPRFNUM "
					+ " where pst.pstrfnum=:pstrfnum and disprsn.paramgroup= 'REJECTION_REASON_SHD' and stl.SSTLSMTTSTATE = 2426  and disprsn.deleted='N'";

			Query query = hibSession.createSQLQuery(sb);
			query.setLong("pstrfnum", pstrfnum);
			query.setMaxResults(1);
			rs = query.scroll();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}

	public ScrollableResults getErDisputeCreate(Long pstrfnum){
		ScrollableResults rs = null;
		try {
			String  sb ="select tick.OCTTICKETID,'('||slr.OCTSLRLCODE||') '||slr.OCTSLRNAME as Seller_ID_and_Seller_Name,"
					+ " '('||slv.OCTSLVCODE||') '||slv.OCTSLVNAME as Slave_ID_and_Slave_Name,stl.createdate,disprsn.paramdesc AS DISPUTEREASON,"
					+ " case pst.erDisputeType when 'Admin' then 'Dispute Admin' else 'Dispute Handler' end as Role_Pending_with,pst.PSTPRODUCTNAME as PRODUCT_DETAILS,rship.AWBNUM as REVERSEAWBNUMBER,"
					+ " pst.transactionid,pst.pstskuno as PRODUCTID1"
					/*+ ",case pst.erDisputeType when 'Admin' then 'TUL Raised' else 'Seller Raised' end as TICKETSTATUS "*/
					+ " from Ismsstl stl "
					+ " left join Ismpst pst on stl.SSTLPSTRFNUM = pst.pstrfnum "
					+ " left join OCT_DISPUTETICKET tick on tick.OCTTICKETPST = pst.PSTRFNUM "
					+ " left join oct_slr slr on slr.octslrlcode = pst.sellercode "
					+ " left join oct_slv slv on slv.OCTSLVCODE = pst.p1slaveid "
					+ " left join oct_param disprsn on disprsn.paramcode = pst.qcreasoncode "
					+ " left join OCT_SHIPMENT rship on rship.SHIPRFNUM=pst.PSTREVERSESHIPRFNUM "
					+ " where pst.pstrfnum = :pstrfnum and disprsn.paramgroup= 'REJECTION_REASON_SHD' and (stl.SSTLSMTFSTATE = 2236 or stl.SSTLSMTTSTATE = 2238) and disprsn.deleted='N'";

			Query query = getStatelessSession().createSQLQuery(sb);
			query.setLong("pstrfnum", pstrfnum);
			query.setMaxResults(1);
			rs = query.scroll();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}
	public ScrollableResults findReportBySeller(String Type, String slrcode,String lastDate, String nextDate) {
		lastDate = lastDate +" 00:00:00";
		nextDate = nextDate +" 23:59:59";
		ScrollableResults rs = null;
		try {

			String queryString = "";
			if (("NB").equalsIgnoreCase(Type)) {
				queryString = "select pst.SELLERCODE as SELLERCODE,pst.p1slaveid as SLAVECODE,pot.orderrefno as ORDERREFNO,pot.orderid as ORDER_ID,pst.transactionid as TRANSACTION_ID, "
						+ "case when pst.FULFILLMENTTYPE=383 then 'TSHIP' when pst.FULFILLMENTTYPE=384 then 'SSHIP' ELSE '' END  AS FULFILLMENTTYPE,case when pst.iscod='Y' then 'POSTPAID' || '' else 'PREPAID' end as ORDER_TYPE, "// 6
						+ "case when pst.isinvoicesent='Y' then 'NOR' || '' else '' end as Order_Tag, "// 7
						+ " '' as SETTLEMENT_DATE,'' as ACC_DOC_ZA, "
						+ "EXTRACT(year FROM pst.createdate) as FISCAL_YEAR, "// 10
						+ "case when pst.tatadiscount is not null and pst.sellerdiscount is not null then pst.PRICE - pst.tatadiscount - pst.sellerdiscount when pst.tatadiscount is null and pst.sellerdiscount is not null then pst.PRICE -pst.sellerdiscount when pst.tatadiscount is not null and pst.sellerdiscount is null then pst.PRICE -pst.tatadiscount else pst.PRICE end as PRODUCT_VALUE, "// 11
						+ "pst.tatadiscount as TUL_DISCOUNT, "// 12
						+ "case when pst.sellercode not in ('100001') then (select TRXNCALCFEEVAL from OCT_TRXN_FEE where FEE_TYPE_CODE='OF' and PSTRFNUM=pst.pstrfnum and rownum=1) else 0 end as TUL_OTHER_FEES, "// 13
						+ "case when pst.sellerdiscount is not null then pst.PRICE -pst.sellerdiscount else pst.PRICE end as TOTAL_SELLER_PAYABLE, "// 14
						+ "case when pst.sellercode not in ('100001') then (select TRXNCALCCOMMVAL from OCT_TRXN_COMMISION where PSTRFNUM=pst.pstrfnum and rownum=1) else 0 end as REFERRAL_FEES, "// 15
						+ "case when pst.sellercode not in ('100001') then (select TRXNCALCCOMMVAL from OCT_TRXN_COMMISION where PSTRFNUM=pst.pstrfnum and rownum=1)*18/100 else 0 end as REFERRAL_TAX, "// 16
						+ "case when pst.sellercode not in ('100001') then (select TRXNCALCFEEVAL from OCT_TRXN_FEE where FEE_TYPE_CODE='PF' and PSTRFNUM=pst.pstrfnum and rownum=1) else 0 end as PG_FEES, "// 17
						+ "case when pst.sellercode not in ('100001') then (select TRXNCALCFEEVAL from OCT_TRXN_FEE where FEE_TYPE_CODE='CF' and PSTRFNUM=pst.pstrfnum and rownum=1) else 0 end as COD_FEES, "// 18
						+ "case when pst.sellercode not in ('100001') then (select TRXNCALCFEEVAL from OCT_TRXN_FEE where FEE_TYPE_CODE='SF' and PSTRFNUM=pst.pstrfnum and rownum=1) else 0 end as SHIPPING_FEES, "// 19
						/*+ "case when pst.sellercode not in ('100001') and pst.TAXTYPE='CGST' then pst.TAXVALUE else 0 end as CGST,"
										+ "case when pst.sellercode not in ('100001') and pst.TAXTYPE='CGST' AND pst.TAXTYPE2='SGST' then pst.TAXVALUE2 else 0 end as SGST,"
										+ "case when pst.sellercode not in ('100001') and pst.TAXTYPE='IGST' then pst.TAXVALUE else 0 end as IGST,"*/
						+ "case when pst.sellercode not in ('100001') "
						+ "then ((select comm.TRXNCALCCOMMVAL from OCT_TRXN_COMMISION comm where comm.PSTRFNUM=pst.pstrfnum and rownum=1)*(9/100)) "
						+ "else 0 end as CGST,"
						+ "case when pst.sellercode not in ('100001') "
						+ "then ((select comm.TRXNCALCCOMMVAL from OCT_TRXN_COMMISION comm where comm.PSTRFNUM=pst.pstrfnum and rownum=1)*(9/100)) "
						+ "else 0 end as SGST,"
						+ "case when pst.sellercode not in ('100001') "
						+ "then ((select comm.TRXNCALCCOMMVAL from OCT_TRXN_COMMISION comm where comm.PSTRFNUM=pst.pstrfnum and rownum=1)*(18/100)) "
						+ "else 0 end as IGST,"
						+ "'' as CLEARING_DOC, "
						+ "pst.ISREVINVOICESENT, "// 24
						+ "pst.PSTGSTSTATECODE as STATECODE, "//25
						+ "pst.SELLERDISCOUNT as SELLERDISCOUNT "//26
						+ "from ISMPST pst "
						+ "left join ISMPOT pot on pot.potrfnum=pst.pstpotrfnum "
						+ "where  pst.isinvoicesent='Y' and pst.SELLERCODE =:slrcode and "
						+ "pst.pstrfnum in(select ps.pstrfnum from ISMPST ps where ps.hotcDate is not null and ps.SELLERCODE =:slrcode "
						+ "and ps.hotcDate between to_date(:lastDate,'yyyy-MM-dd HH24:MI:SS') and to_date(:nextDate,'yyyy-MM-dd HH24:MI:SS')"
						+ "and (pst.ISRETUIRTO='N' or pst.ISRETUIRTO is null)) ";
			} else {

				queryString = "select pst.SPTSLRCODE as SELLERCODE,pst.SPTSLVCODE as SLAVECODE,pst.SPTORDERREFNO as ORDERREFNO,pst.SPTORDERID as ORDER_ID,pst.SPTTRANSACTIONID as TRANSACTION_ID, "
						+ "pst.SPTFULFILMENTTYPE, "
						+ "pst.sptordertype as ORDER_TYPE, "
						+ "pst.SPTORDERTAG as Order_Tag, "
						+ "TO_CHAR(pst.Sptsettlementdate, 'yyyy-MM-dd') as SETTLEMENT_DATE,pst.Sptdocza as ACC_DOC_ZA, "
						+ "EXTRACT(year FROM pst.sptsettlementdate) as FISCAL_YEAR, "
						+ "pst.sptprodvalue as PRODUCT_VALUE,pst.spttuldiscount as TUL_DISCOUNT, "
						+ "case when pst.SPTSLRCODE not in('100001') then pst.spttulfee else 0 end as TUL_OTHER_FEES, "
						+ "pst.Sptslrpayable as TOTAL_SELLER_PAYABLE, "
						+ "case when pst.SPTSLRCODE not in('100001') then pst.SPTREFRRALFEE else 0 end as REFERRAL_FEES, "
						+ "'0' as REFERRAL_TAX, "
						+ "case when pst.SPTSLRCODE not in('100001') then pst.SPTPGFEE else 0 end as PG_FEES, "
						+ "case when pst.SPTSLRCODE not in('100001') then pst.SPTCODFEE else 0 end as COD_FEES, "
						+ "case when pst.SPTSLRCODE not in('100001') then pst.SPTSHIPPINGFEE else 0 end as SHIPPING_FEES, "
						+ "case when pst.SPTCGST is not null and pst.SPTSLRCODE not in('100001') then pst.SPTCGST else 0 end as CGST, "
						+ "case when pst.SPTSGSTUGST is not null and pst.SPTSLRCODE not in('100001') then pst.SPTSGSTUGST  else 0 end as SGST, "
						+ "case when pst.SPTIGST is not null and pst.SPTSLRCODE not in('100001') then pst.SPTIGST else 0 end as IGST, "
						+ "pst.Sptclearingdoc as CLEARING_DOC,pst.Sptnetpayable as NET_PAYBLE, "
						+ " pst.PRICIPALADD1 as PRINCIPLE_ADDRESS1,pst.PRICIPALADD2 as PRINCIPLE_ADDRESS2,pst.PRICIPALADD3 as PRINCIPLE_ADDRESS3,"
						+ " pst.STATENAME as STATENAME,pst.STATECODE as STATECODE,pst.SLRGSTIN as SELLER_GSTIN,pst.INVOICENO as INVOICE_NO,pst.PAYDOCNO as PAYMENT_DOC_NO,"
						+ " pst.CURRENCY as CURRENCY,pst.PRODCATEGORY as PRODUCT_CATEGORY,pst.HSNCODE as HSNCODE,pst.HSNDESC as HSN_DESCRIPTION,pst.CGSTRATE as CGST_RATE,"
						+ " pst.SGSTUGSTRATE as SGSTUTGST_Rate,pst.IGSTRATE as IGST_Rate,pst.TOTALREFFEE as TOTAL_REFERRAL_PRICE,pst.dispDocNo as Dispute_Doc_No,"
						+ " TO_CHAR(pst.dispDocDate, 'yyyy-MM-dd') as Dispute_Doc_Date,TO_CHAR(pst.zpDocDate, 'yyyy-MM-dd') as ZP_Doc_Date,pst.utrNo as UTR_No, "
						+ "pst.SpttdsAmount as SpttdsAmount, "
						
						+ " case when pst.SPTSLRCODE not in('100001') then pst.SPTLOGFEEFORWARD else 0 end as LOGFEEFORWARD ,"
						+ " case when pst.SPTSLRCODE not in('100001') then pst.SPTLOGFEEREVERSE else 0 end as LOGFEEREVERSE ,"
						+ " case when pst.SPTSLRCODE not in('100001') then pst.SPTWAREHOUSEFEE else 0 end as WAREHOUSEFEE ,"
						+ " case when pst.SPTSLRCODE not in('100001') then pst.SPTREPLACEMENTFEE else 0 end as REPLACEMENTFEE ,"
						+ " case when pst.SPTSLRCODE not in('100001') then pst.SPTCLOSINGFEE else 0 end as CLOSINGFEE ,"
						+ " case when pst.SPTSLRCODE not in('100001') then pst.SPTPACKAGINGFEE else 0 end as PACKAGINGFEE ,"
						+ " case when pst.SPTSLRCODE not in('100001') then pst.SPTPRODUCTCONTENTFEE else 0 end as PRODUCTCONTENTFEE ,"
						+ " case when pst.SPTSLRCODE not in('100001') then pst.SPTRTOFEE else 0 end as RTOFEE ,"
						+ " case when pst.SPTSLRCODE not in('100001') then pst.SPTMARKETINGFEE else 0 end as MARKETINGFEE ,"
						+ " case when pst.SPTSLRCODE not in('100001') then pst.SPTNOCOSTEMIFEE else 0 end as NOCOSTEMIFEE ,"
						+ " case when pst.SPTSLRCODE not in('100001') then pst.SPTOPDPEN else 0 end as OPDPEN ,"
						+ " case when pst.SPTSLRCODE not in('100001') then pst.SPTORDERREJECTIONPEN else 0 end as ORDERREJECTIONPEN ,"
						+ " case when pst.SPTSLRCODE not in('100001') then pst.SPTUSEDPRODUCTPEN else 0 end as USEDPRODUCTPEN ,"
						+ " case when pst.SPTSLRCODE not in('100001') then pst.SPTINSCANGAPPEN else 0 end as INSCANGAPPEN, "
						+ " case when pst.SPTSLRCODE not in('100001') then pst.SPTCODCOLLECTIONFEES else 0 end as CODCOLLECTIONFEES, "
						+ " case when pst.SPTSLRCODE not in('100001') then pst.SPTPAYMENTGATEWAYFEES else 0 end as PAYMENTGATEWAYFEES, "
						+ " case when pst.SPTSLRCODE not in('100001') then pst.SPTCGSTNOFEES else 0 end as CGSTNOFEES, "
						+ " case when pst.SPTSLRCODE not in('100001') then pst.SPTSGSTORUGSTONFEES else 0 end as SGSTORUGSTONFEES, "
						+ " case when pst.SPTSLRCODE not in('100001') then pst.SPTIGSTONFEES else 0 end as IGSTONFEES "
						
						+ " from OCT_SLR_PAYOUT_TXN pst "
						+ "where pst.SPTSLRCODE = :slrcode and pst.sptsettlementdate between to_date(:lastDate,'yyyy-MM-dd HH24:MI:SS') and to_date(:nextDate,'yyyy-MM-dd HH24:MI:SS') ";

			}
			Query query = getStatelessSession().createSQLQuery(queryString);
			query.setParameter("slrcode", slrcode);
			query.setParameter("lastDate", lastDate);
			query.setParameter("nextDate", nextDate);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}

	//Shankar Start : TPR-11937
	public ScrollableResults getSellerSettlementPayoutAdvice(String lastDate,String sellercode) throws DAOException{
		//String lastDate1 = lastDate +" 00:00:00";
		//String lastDate2 = lastDate +" 23:59:59";
		ScrollableResults rs = null;
		try {
			StringBuffer queryString = new StringBuffer();
			queryString.append("select A.ORDER_TAG,A.SLV_CODE,sum(A.PRODUCT_VALUE) as TOT_PRODUCT_VALUE,SUM(A.TUL_DISCOUNT)"
					+ "AS TOT_TUL_DISCOUNT,SUM(A.TUL_OTHER_FEES) AS TOT_TUL_OTHER_FEES,"
					+ "SUM(A.TOTAL_SELLER_PAYABLE) AS TOT_TOTAL_SELLER_PAYABLE,SUM(A.REFERRAL_FEES) AS TOT_REFERRAL_FEES,"
					+ "SUM(A.REFERRAL_FEES_TAX) AS TOT_REFERRAL_FEES_TAX,SUM(A.SHIPPING_FEES) AS TOT_SHIPPING_FEES,"
					+ "SUM(A.TCS_VALUE) AS TCS_VALUE,SUM(A.CGST) CGST,SUM(A.SGST) AS SGST,SUM(A.IGST) AS IGST,"
					+ "A.INVOICENO,A.SPTCLEARINGDOC AS CLEARINGDOCNUM,A.STATECODE, A.IRN, A.QRCODEDATA"
					+ " FROM (select pst.sptordertype as ORDER_TYPE,"
					+ "pst.sptprodvalue as PRODUCT_VALUE,"
					+ "pst.spttuldiscount as TUL_DISCOUNT,"
					+ "pst.spttulfee as TUL_OTHER_FEES,"
					+ "case when pst.spttuldiscount is not null then pst.sptprodvalue + pst.spttuldiscount else 0 end as TOTAL_SELLER_PAYABLE,"
					+ "pst.SPTREFRRALFEE as REFERRAL_FEES,"
					+ "pst.SPTREFRRALFEE*(18/100) as REFERRAL_FEES_TAX,"
					+ "pst.SPTSHIPPINGFEE as SHIPPING_FEES,"
					+ "pst.SPTORDERTAG as ORDER_TAG,"
					+ "pst.sptprodvalue*(1/100) as TCS_VALUE,"
					+ "Pst.Sptslvcode as SLV_CODE,"
					+ "case when pst.SPTCGST is not null and pst.SPTCGST>0 then pst.SPTCGST else 0 end as CGST,"
					+ "case when pst.SPTSGSTUGST is not null and pst.SPTSGSTUGST>0 then pst.SPTSGSTUGST else 0 end as SGST,"
					+ "case when pst.SPTIGST is not null and pst.SPTIGST>0 then pst.SPTIGST else 0 end as IGST,"
					+ "pst.INVOICENO,pst.SPTCLEARINGDOC,pst.STATECODE,"
					+ "pst.IRN, pst.QRCODEDATA"
					+ " from OCT_SLR_PAYOUT_TXN pst "
					+ "where pst.SPTSLRCODE =:slrcode and pst.sptsettlementdate=TO_DATE (:lastDate, 'yyyy-mm-dd')) A "
					+ "GROUP BY A.ORDER_TAG,A.SLV_CODE,A.INVOICENO,A.SPTCLEARINGDOC,A.STATECODE,A.IRN, A.QRCODEDATA "
					+ "ORDER BY A.SLV_CODE");

			Query query = getStatelessSession().createSQLQuery(queryString+"");
			query.setParameter("slrcode", sellercode);
			query.setParameter("lastDate", lastDate);
			//query.setParameter("lastDate2", lastDate2);

			query.setReadOnly(true);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}

	public ScrollableResults getSellerSettlementPayoutTransactionDetails(String invoiceNo,String sellerCode) throws DAOException{
		ScrollableResults rs = null;
		try {
			StringBuffer queryString = new StringBuffer();
			queryString.append("select pst.SPTORDERREFNO as ORDERREFNO,pst.SPTORDERID as ORDER_ID,pst.SPTTRANSACTIONID as TRANSACTION_ID,"
					+ "pst.sptfulfilmenttype as FULFILLMENTTYPE,pst.SPTORDERTAG as Order_Tag,pst.PRODCATEGORY as PRODUCT_CATEGORY,"
					+ "pst.SPTREFRRALFEE as REFERRAL_FEES,"
					+ "case when pst.SPTCGST is not null then pst.SPTCGST else 0 end as CGST,"
					+ "case when pst.SPTSGSTUGST is not null then pst.SPTSGSTUGST  else 0 end as SGST,"
					+ "case when pst.SPTIGST is not null then pst.SPTIGST  else 0 end as IGST"
					+ " from OCT_SLR_PAYOUT_TXN pst"
					+ " where pst.INVOICENO =:invoiceNo and pst.SPTSLRCODE =:sellerCode");

			Query query = getStatelessSession().createSQLQuery(queryString+"");
			query.setParameter("invoiceNo", invoiceNo);
			query.setParameter("sellerCode", sellerCode);
			query.setReadOnly(true);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}
	//Shankar End : TPR-11937

	public ScrollableResults findNorRrfDetails() {
		ScrollableResults rs = null;
		try {
			String queryString = "select comm.ismpst.transactionid,comm.ismpst.createdate,comm.ismpst.sellercode,comm.trxncalccommval,"
					+ "comm.ismpst.l1catecory,comm.ismpst.l1catCode,comm.ismpst.ficoNORStatus,comm.ismpst.ficoRRFStatus,comm.ismpst.ficoInvoiceRemark "
					+ "from OctTrxnCommision comm where comm.ismpst.ficoInvoiceRemark='Commission is not available' and (comm.trxncalccommval is null or comm.trxncalccommval='0')";
			Query query = getStatelessSession().createQuery(queryString);
			query.setReadOnly(true);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}

	//Shankar Start : TPR-12173
	public ScrollableResults getPenaltyAdvice(String invoiceNo,String otherIncomeNature) throws DAOException{
		ScrollableResults rs = null;
		try {
			StringBuilder queryString = new StringBuilder();
			queryString.append("select SELLERNAME,SELLERCODE,INVOICEDATE,CURRENCY,sum(BASEAMOUNT),sum(CGSTRATE),sum(CGSTAMOUNT),sum(SGSTUTGSTRATE),"
					+ "sum(SGSTUTGSTAMOUNT),sum(IGSTRATE),sum(IGSTAMOUNT),sum(TOTALINVOICEVALUE),OTHERINCOMENATURE,SLRGSTIN, "//13
					+ " TRANSACTIONPERIODSTART,TRANSACTIONPERIODEND,PAYMENTTERMS,SACCODE,DUEDATE,IRN,QRCODEDATA from OCT_SLR_PAYOUT_PENALTIES ");

			if (invoiceNo != null && !"".equals(invoiceNo)) {
				queryString.append("where INVOICENO =:invoiceNo ");
			}

			if (otherIncomeNature != null && !"".equals(otherIncomeNature)) {
				queryString.append("and OTHERINCOMENATURE =:otherIncomeNature ");
			}

			queryString.append("group by INVOICENO,INVOICEDATE,CURRENCY,OTHERINCOMENATURE,SELLERNAME,SELLERCODE,SLRGSTIN,TRANSACTIONPERIODSTART,TRANSACTIONPERIODEND,PAYMENTTERMS,SACCODE,DUEDATE,IRN,QRCODEDATA ");

			Query query = getStatelessSession().createSQLQuery(queryString.toString());
			if (invoiceNo != null && !"".equals(invoiceNo)) {
				query.setParameter("invoiceNo", invoiceNo);
			}

			if (otherIncomeNature != null && !"".equals(otherIncomeNature)) {
				query.setParameter("otherIncomeNature", otherIncomeNature);
			}

			query.setReadOnly(true);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}
	//Shankar End : TPR-12173

	//Hemant:start
	public ScrollableResults findReportByTcsSeller(String slrcode,String lastDate) {
		String lastDate1 = lastDate +" 00:00:00";
		String lastDate2 = lastDate +" 23:59:59";
		ScrollableResults rs = null;
		try {

			String queryString = "";

			queryString = "select SPTSLRCODE as SELLERCODE,SLRNAME  as SLRNAME,SPTORDERREFNO as ORDERREFRENCENO,SPTORDERID ORDERID,SPTTRANSACTIONID as TRANSACTIONID,HSNCODETCS as HSNCODE,SPTFULFILMENTTYPE as FULFILLMENTTYPE,SPTORDERTYPE as ORDERTYPE,SPTORDERTAG as ORDERTAG,sptslvcode as SLAVEID,SLAVEGSTINTCS as SLAVEGSTIN,SLAVESTATECODETCS as SLAVESTATE,DESTINATIONCODETCS as DESTINATIONCODE,SLRINVOICETCS as SELLERINVOICE,ORDERDATETCS as  ORDERDATE,TRANSACTIONDATETCS as TRANSACTIONDATE,FINALSTATUSTCS as FINALSTATUS,SPTPRODVALUE as PRODUCTVALUE,SPTIGST as PRODUCTIGST,SPTCGST as PRODUCTCGST,SPTSGSTUGST as PRODUCTSGST, SPTSLRPAYABLE as TOTALSELLERPAYABLE ,TCSCGST as TCSCGST,TCSSGST as TCSSGST,TCSIGST as TCSIGST,TOTALTCS as TOTALTCS,sptclearingdoc as CLEARINGDOCUMENT,DOCDATETCS as DOCUMENTDATE,TULGSTINTCS as TULGSTIN from  OCT_SLR_PAYOUT_TXN  "
					+ "where SPTSLRCODE =:slrcode and "
					+ "sptsettlementdate between to_date(:lastDate1,'yyyy-MM-dd HH24:MI:SS') and to_date(:lastDate2,'yyyy-MM-dd HH24:MI:SS') ";

			Query query = getStatelessSession().createSQLQuery(queryString);
			query.setParameter("slrcode", slrcode);
			query.setParameter("lastDate1", lastDate1);
			query.setParameter("lastDate2", lastDate2);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}			      
	//Hemant:End

	//Shankar Start
	public ScrollableResults downloadGstTcsData(String reportStartDate,String reportEndDate,String slrCode,String reportType) {
		ScrollableResults rs = null;
		StringBuilder sb = new StringBuilder();
		try {
			sb.append("select pst.SELLERCODE as SELLERCODE,pst.p1slaveid as SLAVECODE,SUBSTR(slv.GSTREGISTRATIONNO,1,2) as SLAVE_SATE,"
					+ "pst.transactionid as TRANSACTION_ID,"
					+ "case when pst.isinvoicesent='Y' then 'NOR'|| '' else '' end as Order_Tag,slv.GSTREGISTRATIONNO,slr.OCTSLRLNAME,"
					+ " 'Invoice' as DOC_TYPE,inv.AUTOGENINVOICENO,to_char( inv.createdate, 'MONTH DD YYYY' ) as INVOICE_DATE,"
					+ "Extract(month from inv.createdate) AS INVOICE_MONTH,pst.PSTGSTSTATECODE,pst.PSTHSNCODE,pst.PSTPRODUCTNAME,"
					+ "case when pst.TAXTYPE='IGST' then pst.TAXABLEAMT+pst.CALTAXVALUE"
					+ " when pst.TAXTYPE='CGST' then pst.TAXABLEAMT+pst.CALTAXVALUE+pst.CALCTAXVALUE2 end as DOC_VALUE,pst.TAXABLEAMT,");
			if("GST".equals(reportType)){
				sb.append("case when pst.TAXTYPE='IGST' then pst.taxvalue  else 0 end as IGST_RATE,"
						+ "case when pst.TAXTYPE='IGST' then pst.CALTAXVALUE  else 0 end as IGST_VAL,"
						+ "case when pst.TAXTYPE='CGST' then pst.TAXVALUE  else 0 end as CGST_RATE,"
						+ "case when pst.TAXTYPE='CGST' then pst.CALTAXVALUE  else 0 end as CGST_VAL,"
						+ "case when pst.TAXTYPE='CGST' AND pst.TAXTYPE2='SGST' then pst.TAXVALUE2  else 0 end as SGST_RATE,"
						+ "case when pst.TAXTYPE='CGST' AND pst.TAXTYPE2='SGST' then pst.CALCTAXVALUE2  else 0 end as SGST_VALUE,");
			}else{
				sb.append("case when pst.TAXTYPE='IGST' then 1  else 0 end as IGST_RATE,"
						+ "case when pst.TAXTYPE='IGST' then pst.TAXABLEAMT*(1/100)  else 0 end as IGST_VAL,"
						+ "case when pst.TAXTYPE='CGST' then 0.5  else 0 end as CGST_RATE,"
						+ "case when pst.TAXTYPE='CGST' then pst.TAXABLEAMT*(0.5/100)  else 0 end as CGST_VAL,"
						+ "case when pst.TAXTYPE='CGST' AND pst.TAXTYPE2='SGST' then 0.5 else 0 end as SGST_RATE,"
						+ "case when pst.TAXTYPE='CGST' AND pst.TAXTYPE2='SGST' then pst.TAXABLEAMT*(0.5/100)  else 0 end as SGST_VALUE,");
			}

			sb.append("pst.CESSVALUE,pst.ISREVINVOICESENT"
					+ " from ISMPST pst"
					+ " left join ISMPOT pot on pot.potrfnum=pst.pstpotrfnum"
					+ " left join oct_slv slv on slv.octslvrfnum=pst.PSTSLVRFNUM"
					+ " left join OCT_SLR slr on slr.octslrlcode=pst.SELLERCODE"
					+ " left join OCT_SHIPMENT ship on ship.shiprfnum=pst.PSTSHIPRFNUM"
					+ " left join OCT_INVOICE inv on inv.INVOICERFNUM=ship.OCTINVOICE"
					+ " where pst.SELLERCODE =:slrCode and pst.createdate between to_date(:reportStartDate,'dd-MM-yyyy') "
					+ " and to_date(:reportEndDate,'dd-MM-yyyy') and pst.isinvoicesent='Y' ");

			Query query = getStatelessSession().createSQLQuery(sb.toString());
			query.setParameter("slrCode", slrCode);
			query.setParameter("reportStartDate", reportStartDate);
			query.setParameter("reportEndDate", reportEndDate);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}	

	public ScrollableResults downloadGstTcsSummaryData(String reportStartDate,String reportEndDate,String slrCode,String reportType) {
		ScrollableResults rs = null;
		StringBuilder sb = new StringBuilder();
		try {
			sb.append("SELECT A.GSTREGISTRATIONNO,A.OCTSLRLNAME,A.PSTGSTSTATECODE,SUM(A.DOC_VALUE) AS TOT_DOC_VALUE,"
					+ "SUM(A.TAXABLEAMT) AS TOT_TAXABLEAMT,A.IGST_RATE,SUM(A.IGST_VAL) AS TOT_IGST,A.CGST_RATE,SUM(A.CGST_VAL) AS TOT_CGST,"
					+ "A.SGST_VALUE,SUM(A.SGST_VALUE) AS TOT_SGST,SUM(CESSVALUE)"
					+ " FROM (select slv.GSTREGISTRATIONNO,slr.OCTSLRLNAME,pst.SELLERCODE as SELLERCODE,pst.PSTGSTSTATECODE,"
					+ "case when pst.TAXTYPE='IGST' then pst.TAXABLEAMT+pst.CALTAXVALUE"
					+ " when pst.TAXTYPE='CGST' then pst.TAXABLEAMT+pst.CALTAXVALUE+pst.CALCTAXVALUE2 end as DOC_VALUE,pst.TAXABLEAMT,");

			if("GST".equals(reportType)){
				sb.append("case when pst.TAXTYPE='IGST' then pst.taxvalue  else 0 end as IGST_RATE,"
						+ "case when pst.TAXTYPE='IGST' then pst.CALTAXVALUE  else 0 end as IGST_VAL,"
						+ "case when pst.TAXTYPE='CGST' then pst.TAXVALUE  else 0 end as CGST_RATE,"
						+ "case when pst.TAXTYPE='CGST' then pst.CALTAXVALUE  else 0 end as CGST_VAL,"
						+ "case when pst.TAXTYPE='CGST' AND pst.TAXTYPE2='SGST' then pst.TAXVALUE2  else 0 end as SGST_RATE,"
						+ "case when pst.TAXTYPE='CGST' AND pst.TAXTYPE2='SGST' then pst.CALCTAXVALUE2  else 0 end as SGST_VALUE,");
			}else{
				sb.append("case when pst.TAXTYPE='IGST' then 1  else 0 end as IGST_RATE,"
						+ "case when pst.TAXTYPE='IGST' then pst.TAXABLEAMT*(1/100)  else 0 end as IGST_VAL,"
						+ "case when pst.TAXTYPE='CGST' then 0.5  else 0 end as CGST_RATE,"
						+ "case when pst.TAXTYPE='CGST' then pst.TAXABLEAMT*(0.5/100)  else 0 end as CGST_VAL,"
						+ "case when pst.TAXTYPE='CGST' AND pst.TAXTYPE2='SGST' then 0.5 else 0 end as SGST_RATE,"
						+ "case when pst.TAXTYPE='CGST' AND pst.TAXTYPE2='SGST' then pst.TAXABLEAMT*(0.5/100)  else 0 end as SGST_VALUE,");
			}

			sb.append("pst.CESSVALUE,pst.ISREVINVOICESENT"
					+ " from ISMPST pst"
					+ " left join ISMPOT pot on pot.potrfnum=pst.pstpotrfnum"
					+ " left join oct_slv slv on slv.octslvrfnum=pst.PSTSLVRFNUM"
					+ " left join OCT_SLR slr on slr.octslrlcode=pst.SELLERCODE"
					+ " where pst.SELLERCODE =:slrCode and pst.createdate between to_date(:reportStartDate,'dd-MM-yyyy')"
					+ " and to_date(:reportEndDate,'dd-MM-yyyy') and pst.isinvoicesent='Y' and (pst.ISREVINVOICESENT is null)) A"
					+ " GROUP BY A.PSTGSTSTATECODE,A.SELLERCODE,A.GSTREGISTRATIONNO,A.OCTSLRLNAME,A.IGST_RATE,A.CGST_RATE,A.SGST_VALUE ");

			Query query = getStatelessSession().createSQLQuery(sb.toString());
			query.setParameter("slrCode", slrCode);
			query.setParameter("reportStartDate", reportStartDate);
			query.setParameter("reportEndDate", reportEndDate);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}
	//Shankar End

	public ScrollableResults fetchDataZeroComm() { //Nishant added for Zero Inventory TPR-12860
		ScrollableResults rs = null;
		try {
			String buffer = "SELECT * FROM ZERO_COMM";
			Query query = getStatelessSession().createSQLQuery(buffer); 	
			rs = query.scroll();
		}catch( HibernateException e){
			throw new DAOException( e );
		}
		return rs;
	}
	
	public ScrollableResults fetchExpiringProducts() {
		ScrollableResults rs = null;
		try {
			String buffer = "select * from OCT_SLR_PRODUCT_COMMISION spc,OCT_SLR_PRODUCT sp "
					+ "where spc.COMMISION_ENDDATE > sysdate and spc.COMMISION_ENDDATE <= sysdate +2 "
					+ "and spc.SPCSPRFNUM = sp.SPRFNUM";
			Query query = getStatelessSession().createSQLQuery(buffer); 	
			rs = query.scroll();
		}catch( HibernateException e){
			throw new DAOException( e );
		}
		return rs;
	}
	
	public ScrollableResults fetchExpiringSlrCategoryComms() {
		ScrollableResults rs = null;
		try {
			String buffer = "select * from OCT_SLR_CATEGORY_COMMISION "
					+ "where COMMISSION_ENDDATE > sysdate and COMMISSION_ENDDATE <= sysdate +2";
			Query query = getStatelessSession().createSQLQuery(buffer); 	
			rs = query.scroll();
		}catch( HibernateException e){
			throw new DAOException( e );
		}
		return rs;
	}
	public ScrollableResults fetchDataZeroComm2() { //Nishant added for Zero Inventory TPR-12860
		ScrollableResults rs = null;
		try {
			String buffer = "SELECT * FROM ZERO_COMM_2";
			Query query = getStatelessSession().createSQLQuery(buffer); 	
			rs = query.scroll();
		}catch( HibernateException e){
			throw new DAOException( e );
		}
		return rs;
	}

	
	
	
	public ScrollableResults getAllDisputeTransactionbulk(String slvRfnum,String slvCode,String submodel){
		Session hibSession = null;
		ScrollableResults rs = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuilder sb = new StringBuilder();
			sb.append("select pst.claimRegDate,pst.transactionid,pst.reverseshipment.awbnum ,pst.pstproductname,pst.l1catecory,pst.l2category,pst.l3category,pst.l4category,"
					+"pst.returnReason,pst.disputecomment,pst.price,pst.qcreasoncode,pst.discount,pst.apportionedshippingcharge,pst.apportionedcodprice,"
					+"pst.scheduledDeliveryCharge,pst.sellercode,pst.p1slaveid,pst.l1catCode,pst.parenttransactionid,pst.isafreebie,"
					+"pst.cirRtoDate,pst.actualcomppercent from Ismpst pst left join pst.reverseshipment where ");
			if("ADMIN".equalsIgnoreCase(submodel)){//@Nishant ::TPR-11782
				sb.append("(pst.iserlit='Y' or pst.iserqcfail='Y')"
						+ "  and (pst.iserqcapproved='N' or pst.iserqcapproved=null) and (pst.iserqcreject='N' or pst.iserqcreject=null)"
						+ " and pst.deleted='N' and pst.isErXDispute='Y'");
			}else{
				sb.append("(pst.iserlit='Y' or pst.iserqcfail='Y')"
						+ "  and (pst.iserqcapproved='N' or pst.iserqcapproved=null) and (pst.iserqcreject='N' or pst.iserqcreject=null)"
						+ " and pst.deleted='N' and pst.isErXDispute is null");
			}

			if(slvRfnum!=null && !"".equals(slvRfnum)){
				sb.append(" and pst.octSlv.octslvrfnum=:slvRfnum");
			}

			sb.append(" order by pst.modidate ");
			Query query = hibSession.createQuery(sb.toString());
			if(slvRfnum!=null && !"".equals(slvRfnum)){
				query.setLong("slvRfnum",new Long(slvRfnum));
			}

			//retvalList = query.list();
			query.setReadOnly(true);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	} //sanket.e
	
	//Reverese Serviceability
	public ScrollableResults manualLPAllocationCount(){

		ScrollableResults rs=null;
		String queryString=" ";
		try {
			queryString ="select count(pst.TRANSACTIONID) from ISMPST pst left join ISMPOT pot on pot.POTRFNUM=pst.PSTPOTRFNUM "
					+ "left join OCT_SHIPMENT ship on ship.SHIPRFNUM=pst.PSTSHIPRFNUM "
					+ "left join OCT_SHIPMENT revship on revship.SHIPRFNUM=pst.PSTREVERSESHIPRFNUM "
					+ "join OCT_SLV slv on slv.OCTSLVRFNUM=pst.PSTSLVRFNUM "
					+ "join OCT_SLV_USR usr on usr.OCTSLV=slv.OCTSLVRFNUM "
					+ " AND usr.OCTSLVUSRRFNUM = (SELECT OCTSLVUSRRFNUM FROM OCT_SLV_USR usr1 WHERE"
					+ "                            slv.OCTSLVRFNUM=usr1.OCTSLV  AND   rownum <=1)"
					+ "join ismubi ubi on ubi.UBIRFNUM=usr.ISMUBI "
					+ "join ismuat uat on uat.UATUBIRFNUM=ubi.UBIRFNUM "
					+ "left join OCT_COUNTRY_MASTER con on con.COUNTRYRFNUM=uat.UATCOUNTRYMASTER "
					+ "left join OCT_STATE_MASTER stat on stat.STATERFNUM=uat.UATSTATEMASTER "
					+ "left join OCT_CITY_MASTER city on city.CITYRFNUM=uat.UATCITYMASTER "
					+ "left join  ISMSMT smt on smt.SMTRFNUM=pst.PSTSMTRFNUM "
					+ "left join  OCT_TICKET tick on tick.OCTTICKETPST=pst.PSTRFNUM "
					+ "left join  OCT_PARAM  revtype on revtype.PARAMRFNUM=pst.REVREFUNDTYPE "
					+ "left join  OCT_PARAM subtick on subtick.PARAMRFNUM=tick.OCTSUBTICKETTYPE "
					+ "where smt.SMTRFNUM in('2241','2240','2614') "
					+ "and (pst.RETURNFULFILLMENTTYPE is null OR (pst.RETURNFULFILLMENTTYPE=383)) "
					+ "and revtype.PARAMVALUE in ('REFDONQC','REFONRVP','REFTHPCK','REPONRVP','REPONQC') and (pst.RETURNLOGISTICID='N/A' OR pst.RETURNLOGISTICID is not null) "
					+ "and (revship.ISMENIFESTSENT is null OR (revship.ISMENIFESTSENT='N'))";

			Query query = getStatelessSession().createSQLQuery(queryString.toString()); 
			query.setReadOnly(true);    	
			//query.setFirstResult(from);
			//query.setMaxResults(max);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}
	
	public ScrollableResults manualLPAllocation(int from, int max){
		ScrollableResults rs=null;
		String queryString=" ";
		try {
			queryString ="select pst.TRANSACTIONID,pot.ORDERID,pst.CIRRTODATE,pst.PSTPRODUCTNAME,pst.L3CATEGORY,pst.L4CATEGEGORY,"//0-5
					+ "pst.shipaddress1 || ',' ||pst.shipaddress2 || ',' || pst.shipaddress3 || ',' || pst.shipcityordistrict || ',' || pst.shipstate || ',' || pst.shippincode,"//6
					+ "pst.shipphoneno,uat.UATADDR1 || ',' || uat.UATADDR2 || ',' ||uat.UATZIP || ',' || city.DESCRIPTION || ',' || stat.DESCRIPTION ||',' || con.DESCRIPTION ,"
					+ " (select stlLpFailReason FROM ISMSTL where STLRFNUM=(select max(STLRFNUM) from ismstl where STLPSTRFNUM=pst.pstrfnum and STLSMTTSTATE in('2241','2240'))) "//7-9
					+ " from ISMPST pst left join ISMPOT pot on pot.POTRFNUM=pst.PSTPOTRFNUM "
					+ "left join OCT_SHIPMENT ship on ship.SHIPRFNUM=pst.PSTSHIPRFNUM "
					+ "left join OCT_SHIPMENT revship on revship.SHIPRFNUM=pst.PSTREVERSESHIPRFNUM "
					+ "join OCT_SLV slv on slv.OCTSLVRFNUM=pst.PSTSLVRFNUM "
					+ "join OCT_SLV_USR usr on usr.OCTSLV=slv.OCTSLVRFNUM "
					+ " AND usr.OCTSLVUSRRFNUM = (SELECT OCTSLVUSRRFNUM FROM OCT_SLV_USR usr1 WHERE"
					+ "                            slv.OCTSLVRFNUM=usr1.OCTSLV  AND   rownum <=1)"
					+ "join ismubi ubi on ubi.UBIRFNUM=usr.ISMUBI "
					+ "join ismuat uat on uat.UATUBIRFNUM=ubi.UBIRFNUM "
					+ "left join OCT_COUNTRY_MASTER con on con.COUNTRYRFNUM=uat.UATCOUNTRYMASTER "
					+ "left join OCT_STATE_MASTER stat on stat.STATERFNUM=uat.UATSTATEMASTER "
					+ "left join OCT_CITY_MASTER city on city.CITYRFNUM=uat.UATCITYMASTER "
					+ "left join  ISMSMT smt on smt.SMTRFNUM=pst.PSTSMTRFNUM "
					+ "left join  OCT_TICKET tick on tick.OCTTICKETPST=pst.PSTRFNUM "
					+ "left join  OCT_PARAM  revtype on revtype.PARAMRFNUM=pst.REVREFUNDTYPE "
					+ "left join  OCT_PARAM subtick on subtick.PARAMRFNUM=tick.OCTSUBTICKETTYPE "
					+ "where smt.SMTRFNUM in('2241','2240','2614') "
					+ "and (pst.RETURNFULFILLMENTTYPE is null OR (pst.RETURNFULFILLMENTTYPE=383)) "
					+ "and revtype.PARAMVALUE in ('REFDONQC','REFONRVP','REFTHPCK','REPONRVP','REPONQC') "
					+ "and (revship.ISMENIFESTSENT is null OR (revship.ISMENIFESTSENT='N')) and (pst.RETURNLOGISTICID='N/A' OR pst.RETURNLOGISTICID is not null) order by pst.createdate desc ";

			Query query = getStatelessSession().createSQLQuery(queryString.toString()); 
			query.setReadOnly(true);
			if(from!=0 || max!=0) {
			query.setFirstResult(from);
			query.setMaxResults(max);
			}
			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}

	public ScrollableResults pinRevCount(String srcPin,String destPin,String city,String lpId) {
		ScrollableResults rs=null;
		String queryString=" ";
		try {
			queryString ="select count(*) From OctRevServPin pin where pin.courier.ocrrfnum='"+lpId+"'";
            if(srcPin!=null) {
            	queryString +=" and pin.sourcePincode.pincode="+srcPin+"";
            }
            if(destPin!=null) {
            	queryString +=" and pin.destPincode.pincode="+destPin+"";
            }
            if(city!=null) {
            	queryString +=" and (pin.sourcePincode.city='"+city+"' or pin.destPincode.city='"+city+"') ";
            }
			Query query = getStatelessSession().createQuery(queryString.toString()); 
			query.setReadOnly(true);    	
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}
	
	public ScrollableResults fillAllDataForLP(String lp) {
		ScrollableResults rs=null;
		String queryString=" ";
		try {
			queryString ="select opc.categoryLevelFour.cmtcode ,opc.categoryLevelOne.cmtname,opc.categoryLevelTwo.cmtname,"
							+ "opc.categoryLevelThree.cmtname,opc.categoryLevelFour.cmtname,opc.octCourierMaster.globalcouriercode,opc.doorstepQC,opc.status from OctProductCategory  opc where  "
							+ "opc.octCourierMaster.ocrrfnum='"+ lp +"' and opc.deleted='N'";
			Query query = getStatelessSession().createQuery(queryString.toString()); 
			query.setReadOnly(true);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}

		return rs;

	}
	
	public ScrollableResults fillAllDataForLPPin(String lp) {
		ScrollableResults rs=null;
		String queryString=" ";
		try {
			queryString ="select pin.sourcePincode.pincode ,pin.destPincode.pincode,pin.courier.globalcouriercode,"
							+ "pin.pickupTat,pin.deliTat,pin.surface,pin.air,pin.surfaceCost,pin.airCost,pin.pinCodeType,pin.lostDamagePer,pin.revServiceable from OctRevServPin pin where  "
							+ "pin.courier.ocrrfnum='"+ lp +"' and pin.deleted='N'";
			Query query = getStatelessSession().createQuery(queryString.toString()); 
			query.setReadOnly(true);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);

		} catch (HibernateException e) {
			throw new com.anm.hibernate.DAOException(e);
		}

		return rs;

	}
	
	//Aniket.s
	public ScrollableResults getPenaltyTransactionid(){
		Session hibSession = null;
		ScrollableResults rs = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuilder sb = new StringBuilder();
			sb.append("select transactionid from Ismpst where ismsmt.smtrfnum in ('2255','2240') and brandName is not null and brandCode is not null and l1catCode is not null  and l2catCode is not null  and l3catCode is not null  and l4catCode is not null order by createdate desc");

			Query query = hibSession.createQuery(sb.toString());
			//retvalList = query.list();
			query.setReadOnly(true);
			//query.setMaxResults(count);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}
	
	public ScrollableResults getPenaltyByTransactionid(String Transactionid){
		Session hibSession = null;
		ScrollableResults rs = null;
		try {
			hibSession = com.anm.hibernate.HibernateConnection.getSession();
			StringBuilder sb = new StringBuilder();
			sb.append("select trxncalcpenaltyval from OctTrxnPenalty where ismpst.ismsmt.smtrfnum in ('2255','2240') ");
			sb.append(" and ismpst.transactionid=:Transactionid order by penaltytypecode");

			Query query = hibSession.createQuery(sb.toString());
			if(Transactionid!=null && !"".equals(Transactionid)){
				query.setLong("Transactionid",new Long(Transactionid));
			}
			//retvalList = query.list();
			query.setReadOnly(true);
			rs = query.scroll(ScrollMode.FORWARD_ONLY);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
		return rs;
	}
	//Aniket.e
	//@SanketP Apple Report
		public ScrollableResults getAppleReport(String slvcode,String startDate,String endDate,int from, int to,String searchText,String selectDD){
			ScrollableResults rs = null;

			try {
				String strQuery="";	
				strQuery += "select ismpst.transactionid,ismpst.ussid,apiName,failureReason.paramdesc,isSentflag,errorCode from OctTrxnAppleAPI ";
				if(slvcode != null && !"".equals(slvcode)){
					strQuery += "where ismpst.octSlv.octslvcode=:slvcode ";
				}
				
				
				if (startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
					startDate = startDate + " 00:00:00";
					endDate = endDate + " 23:59:59";
					strQuery += "and createdate between to_date(:startDate,'dd/MM/yyyy HH24:MI:SS') and to_date(:endDate,'dd/MM/yyyy HH24:MI:SS')";
				}
				//suraj manifestid added
				/*if(manifestid !=null && !"".equals(manifestid)){
									strQuery=strQuery+" and shipment.menifesto.menifestorfnum=:manifestid";
					 	 		}*/
				if("orderID".equalsIgnoreCase(selectDD) && searchText != null && !"".equals(searchText)){
					strQuery=strQuery+" and ismpst.ismpot.orderid=:searchText";
				}else if("Transaction ID".equalsIgnoreCase(selectDD) && searchText != null && !"".equals(searchText)){
					strQuery=strQuery+" and ismpst.transactionid=:searchText";
				}
				Query query = getStatelessSession().createQuery(strQuery.toString()); 
				if(searchText != null && !"".equals(searchText)){
					query.setString("searchText", searchText);
				}
				if(startDate != null && !"".equals(startDate)){
					query.setString("startDate", startDate);
				}if(endDate != null && !"".equals(endDate)){
					query.setString("endDate", endDate);
				}
				if(slvcode != null && !"".equals(slvcode)){
					query.setString("slvcode", slvcode);
				}

				query.setReadOnly(true);
				query.setFirstResult(from);
				query.setMaxResults(to);

				rs = query.scroll(ScrollMode.FORWARD_ONLY);

			} 
			catch (HibernateException e) {
				e.printStackTrace();
			}
			return rs;
		}
		public ScrollableResults getStlListLastDay(){
			Session hibSession = null;
			ScrollableResults rs = null;
			try {
				hibSession = com.anm.hibernate.HibernateConnection.getSession();
				String Query ="select pst.TRANSACTIONID,slv.OCTSLVCODE,ubi.UBILOGIN," + 
						"(SELECT cont.SLVCONTFIELDNAME from OCT_SLV_CONT cont where cont.OCTSLVRFNUM=slv.OCTSLVRFNUM and slvContFieldType='email' and ROWNUM = 1) " + 
						"from Ismstl stl " + 
						"left OUTER JOIN Ismpst pst on pst.PSTRFNUM=stl.STLPSTRFNUM " + 
						"left OUTER JOIN OCT_SLV slv on slv.OCTSLVRFNUM=pst.PSTSLVRFNUM " + 
						"left OUTER JOIN OCT_SLV_USR usr on usr.OCTSLV=slv.OCTSLVRFNUM " + 
						"left OUTER JOIN ISMUBI ubi on ubi.UBIRFNUM=usr.ISMUBI " + 
						"where stl.STLSMTTSTATE=2600 and (stl.STLSMTFSTATE in (2262,2256,2257,2255,2244) or (stl.STLSMTFSTATE=2247 and pst.INSCAN='N')) " + 
						"and stl.CREATEDATE >=sysdate-1";

				Query query = getStatelessSession().createSQLQuery(Query);
				query.setReadOnly(true);
				rs = query.scroll(ScrollMode.FORWARD_ONLY);
			} catch (HibernateException e) {
				throw new DAOException(e);
			}
			return rs;
		}
		
		public ScrollableResults getCommissionUnbunldingFees(String sellerCode){
			Session hibSession = null;
			ScrollableResults rs = null;
			try {
				hibSession = com.anm.hibernate.HibernateConnection.getSession();
				String Query ="select sellerCode,sellerName,otherIncomeNature,invoiceNo,baseAmount,cgstAmount,sgstUtgstAmount,igstAmount,totalInvoiceValue,ospprfnum, IRN, QRCODEDATA,SLRGSTIN"
						+ " from OCT_SLR_PAYOUT_PENALTIES where sellerCode = :sellerCode and CREATEDATE >= trunc(sysdate,'mm')";
				
				Query query = getStatelessSession().createSQLQuery(Query);
				query.setParameter("sellerCode", sellerCode);
				query.setReadOnly(true);
				rs = query.scroll(ScrollMode.FORWARD_ONLY);
			} catch (HibernateException e) {
				throw new DAOException(e);
			}
			return rs;
		}

		public ScrollableResults getTransactionDetailsForPendingQC(String startDate, String endDate, String slvCode, List<String> toState) {
			ScrollableResults rs = null;
			try {
				StringBuffer sb = new StringBuffer();

				sb.append("select stl.ismpst.transactionid, stl.ismpst.ismpot.orderid, stl.ismpst.pstproductname, stl.ismpst.returnDeliveredDate, "
						+ "stl.createdate ,stl.ismpst.octSlv.octslvlname, stl.ismpst.revRefundType.paramrfnum from Ismstl stl where (stl.ismpst.iserdeliver='Y' or stl.ismpst.iserdeliver='O') and "
						+ "stl.ismpst.p1slaveid=:slvCode and "
						+ "stl.stlsmttstate in (:toState) and "
						+ "stl.ismpst.isQcFailed is null and "
						+ "stl.ismpst.iserqcpass='N' and "
						+ "stl.ismpst.iserqcfail='N' and "
						+ "(stl.ismpst.isAutoQcPass is null or stl.ismpst.isAutoQcPass='Y') and "
						+ "stl.createdate >= to_date(:startDate, 'yyyy-MM-dd') and "
						+ "stl.createdate <= to_date(:endDate, 'yyyy-MM-dd') and "
						+ "stl.ismpst.deleted='N'");

				Query query = getStatelessSession().createQuery(sb.toString()); 
				query.setParameterList("toState",toState);
				query.setString("slvCode", slvCode);
				query.setString("startDate", startDate);
				query.setString("endDate", endDate);
				query.setReadOnly(true);
				rs = query.scroll(ScrollMode.FORWARD_ONLY);
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			return rs;
		}
}