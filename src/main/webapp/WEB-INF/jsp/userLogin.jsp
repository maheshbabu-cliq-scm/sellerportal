<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Pragma" content="no-cache">
 <meta http-equiv="Cache-Control" content="no-cache">
 <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1" %>

<%
final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
int count=6;
String captcha="";

StringBuilder builder = new StringBuilder();
while (count-- != 0) {
int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
builder.append(ALPHA_NUMERIC_STRING.charAt(character));
}
captcha = builder.toString();
%>

<html>
<head>
<title>Welcome to Seller Zone</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

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
<form id="myform" name="myform" method="post" autocomplete="off" action="/submitForm">
   <div  class="tatalogo">
  		<img src="${staticPath}/media/css/backend/imagess/tata-logo-141pxX112px.png" alt="tatalogo"> 
  </div>
  <div class="login-frm">
  <ul>
  <li class="red-msg">
  <div id="errorDiv" class="red-msg"></div>
  </li>
    <li>
    <label id="loginLbl">Login Id</label>
    <div class="loginidicon"></div>
    <input type="text" id="loginId" name="loginId" required="required" placeholder="Enter your Login Id" />
    </li>
    <li>
    <label id="passwordLbl">Password</label>
    <div class="loginpasswordicon"></div>
    <input type="password" id="password" name="password" required="required" placeholder="Enter your Password" />
    </li>
 
    <li>
    <label id="passwordLbl">Complete Captcha Verification</label>
	<label style="font-size:40px;text-align:center;user-select:none;"><%=captcha%></label>
    <input type="hidden" id="captchaG" name="captchaG" value="<%=captcha%>" readonly/>
    <div class="loginpasswordicon"></div>
    <input type="text" id="captchaR" name="captchaR" required="required" placeholder="Enter above Captcha" />
    </li>
   <li class="remindmecheckcon">
    <input type="checkbox" id="remindmecheck"/>
    <label class="remindmecheck" for="remindmecheck"></label>
    <label class="remind">Remember me</label>
    </li>
    <li>
    <input type="submit" id="loginbutton"  class="login" value="LOGIN">
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
   <br>  Terms of Use - Privacy Policy - Contact Us  </p>
  </div>
</footer> 
</body>

</html>