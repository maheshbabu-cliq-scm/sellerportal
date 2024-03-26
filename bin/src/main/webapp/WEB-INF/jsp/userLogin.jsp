<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Pragma" content="no-cache">
 <meta http-equiv="Cache-Control" content="no-cache">
 <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
<%@page import="com.sellerportal.ism.i18n.I18nFilter"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1" %>
<% request.setAttribute("staticPath" ,com.sellerportal.ism.Configuration.getStaticPath());%>

<%@page import="com.sellerportal.ism.SessionVariablesBean"%>
<%@ page import="java.util.Calendar"%>
<%	
	SessionVariablesBean svb = (com.sellerportal.ism.SessionVariablesBean) com.anm.jsf.utils.FacesUtils.getManagedBean("SessionVariablesBean");
	String contextPath = request.getContextPath();
	String urlToRedirect = "";
	if(svb != null && !"".equals(svb.getUserRefNo())){
		if("MP".equalsIgnoreCase(svb.getUserTypeCode())){
			urlToRedirect = "/faces/mp/marketPlace.jsp";
		}else if("SLR".equalsIgnoreCase(svb.getUserTypeCode())){
			urlToRedirect = "/faces/seller/seller.jsp";	
		}else if("SLV".equalsIgnoreCase(svb.getUserTypeCode())){
			urlToRedirect = "/faces/slave/slave.jsp";
		}
	}
	if(svb != null && !"".equals(urlToRedirect)){
		response.sendRedirect(contextPath+urlToRedirect);		
	}
	I18nFilter.userSessionMap.remove("1");
	
	//@saurabh captcha generation code
	
	final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
	int count=6;
	String captcha="";
	
	StringBuilder builder = new StringBuilder();
	while (count-- != 0) {
	int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
	builder.append(ALPHA_NUMERIC_STRING.charAt(character));
	}
	captcha = builder.toString();
	
	//@saurabh end

%>
<html>
<head>
<title>Welcome to Seller Zone</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<jsp:include page="./commonHeadComponent.jsp" />
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/flexslider/2.7.2/flexslider.css">
<link rel="stylesheet" type="text/css" href="${staticPath}/media/css/backend/common-style.css">
<link rel="stylesheet" type="text/css" href="${staticPath}/media/css/backend/ie8.css">
<%-- <script type="text/javascript" src="${staticPath}/media/js/frontend/jquery/jquery_version.js"></script> --%>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/flexslider/2.7.2/jquery.flexslider.js"></script>
<script type="text/javascript">
$( document ).ready( function(){
  $('.flexslider-covid').flexslider({
    animation: "slide",
	controlNav: false,
	startAt: 3
  });
});
</script>
<script type="text/javascript" src="${staticPath}/media/js/frontend/login.js"></script>
<script type="text/javascript" src="${staticPath}/media/js/frontend/forgotPasswordStepJQ.js"></script>
<script type="text/javascript" src="${staticPath}/media/js/frontend/headerJQ.js"></script>
<script type="text/javascript" src="${staticPath}/media/js/frontend/jquery/jQueryUtils.js"></script>
<script type="text/javascript" src="${staticPath}/media/js/frontend/custom_form.js"></script>
<script type="text/javascript" src="${staticPath}/media/js/frontend/jquery/jquery.validate.js"></script>
<script type="text/javascript" src="${staticPath}/media/js/frontend/formValidation.js"></script>
<jsp:include page="./clearBackHistory.jsp"></jsp:include>

<script type="text/javascript">
$(document).ready(function(){
	$('#loginId').text('');
	$('#password').text('');
	document.cookie = 'JSESSIONID' +'=; Path=/; Expires=Thu, 01 Jan 1970 00:00:01 GMT;';
});
$(function(){
	var wheight = $( window ).height()- 43;
	$('.sellerloginbody').css("min-height", wheight + "px");
});
</script>	
</head>
<body class="sellerloginbody " onload="history.go(1);">
<div class="row-flex  justify-content-center flex-wrap">
<div class="flex-12 flex-md-6 flex-lg-4 px-5 mt-20" >
<form id="myform" name="myform" method="post" autocomplete="off">
   <div  class="tatalogo">
  		<img src="${staticPath}/media/css/backend/imagess/tata-logo-141pxX112px.png" alt="tatalogo"> 
  </div>
  <div class="login-frm">
  <ul>
  <li class="red-msg"><span>${UserLoginBean.message}</span>
  <div id="errorDiv" class="red-msg"></div>
  </li>
    <li>
    <label id="loginLbl">Login Id</label>
    <div class="loginidicon"></div>
    <input type="text" id="loginId" name="loginId" required="required" placeholder="Enter your Login Id" onkeypress="clearDiv();"/>
    </li>
    <li>
    <label id="passwordLbl">Password</label>
    <div class="loginpasswordicon"></div>
    <input type="password" id="password" name="password" required="required" placeholder="Enter your Password" onkeypress="clearDiv();"/>
    </li>
    <c:if test="${UserLoginBean.attemptCount >= 2}">
    <li>
    <label id="passwordLbl">Complete Captcha Verification</label>
    <label style="font-size:40px;text-align:center;user-select:none;"><%=captcha%></label>
    <input type="hidden" id="captchaG" name="captchaG" value="<%=captcha%>" readonly/>
    <div class="loginpasswordicon"></div>
    <input type="text" id="captchaR" name="captchaR" required="required" placeholder="Enter above Captcha" onkeypress="clearDiv();"/>
    </li>
    </c:if>
   <li class="remindmecheckcon">
    <input type="checkbox" id="remindmecheck"/>
    <label class="remindmecheck" for="remindmecheck"></label>
    <label class="remind">Remember me</label>
    </li>
    <li>
    <input type="submit" id="loginbutton"  class="login" value="LOGIN">
    <input type="hidden" id="invoke:action" name="invoke:action" value="UserLoginActionBean.userLogin_submitAction"/>
    </li>
    <li>
    	<a class="expZone" href="/experiencezone/">Seller Experience Zone</a>
    	<a id="forgotPassword" class="forgotPassword">Forgot Password?</a>
    </li>
    <li><a id="sellerAgree" class="forgotPassword" onclick="agreeFunction()">Seller Pre-requisition Form</a></li>
    </ul>

  </div>
  </form>
  </div>
  
  <div  class="flex-12 flex-md-6 flex-lg-3 px-5 mt-20 covid-slider">
<!-- <div class="h2"><strong>COVID-19 Safety guide</strong></div> -->
<div class="flexslider flexslider-covid">
  <ul class="slides">
    <li>
      <img  src="${staticPath}/media/css/backend/imagess/TRIL-Back-to-Work_Page_01.jpg">
    </li>
    <li>
      <img  src="${staticPath}/media/css/backend/imagess/TRIL-Back-to-Work_Page_02.jpg">
    </li>
	<li>
      <img  src="${staticPath}/media/css/backend/imagess/TRIL-Back-to-Work_Page_03.jpg">
    </li>
	<li>
      <img  src="${staticPath}/media/css/backend/imagess/TRIL-Back-to-Work_Page_04.jpg">
    </li>
	<li>
      <img  src="${staticPath}/media/css/backend/imagess/TRIL-Back-to-Work_Page_05.jpg">
    </li>
	<li>
      <img  src="${staticPath}/media/css/backend/imagess/TRIL-Back-to-Work_Page_06.jpg">
    </li>
	<li>
      <img  src="${staticPath}/media/css/backend/imagess/TRIL-Back-to-Work_Page_07.jpg">
    </li>
	<li>
      <img  src="${staticPath}/media/css/backend/imagess/TRIL-Back-to-Work_Page_08.jpg">
    </li>
	<li>
      <img  src="${staticPath}/media/css/backend/imagess/TRIL-Back-to-Work_Page_09.jpg">
    </li>
	<li>
      <img  src="${staticPath}/media/css/backend/imagess/TRIL-Back-to-Work_Page_10.jpg">
    </li>
	<li>
      <img  src="${staticPath}/media/css/backend/imagess/TRIL-Back-to-Work_Page_11.jpg">
    </li>
	<li>
      <img  src="${staticPath}/media/css/backend/imagess/TRIL-Back-to-Work_Page_12.jpg">
    </li>
	<li>
      <img  src="${staticPath}/media/css/backend/imagess/TRIL-Back-to-Work_Page_13.jpg">
    </li>
  </ul>
</div>
<div class="custom-navigation">
  <a href="#" class="flex-prev"></a>
  <a href="#" class="flex-next"></a>
</div>
  </div>
  </div>
  
  <div id="forgotpass222" class="custompopup"></div>
<footer class="mainfooter seller-login-footer" role="main footer">
  <div class="bgimg footer-shadowtop"></div>
  <div class="containtwrapper">
  <p > &copy; 
	<%
	int year = Calendar.getInstance().get(Calendar.YEAR);
	out.println("Copyright "+year+"-"+(year+1)+" Tata UniStore All rights reserved.");
	%>  
   <br>  Terms of Use - Privacy Policy - Contact Us  </p>
  </div>
</footer> 
</body>

</html>