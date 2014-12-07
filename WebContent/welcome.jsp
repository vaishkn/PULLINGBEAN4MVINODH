<!DOCTYPE html>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<html lang="en">
  <head>
  	<title>BeanStalk Java Application - WelcomeS</title>
  </head>
  <body>


<h3>Welcome <%= ((String)session.getAttribute("currentSessionUser"))%></h3>
<h2>
<% 
	String userList = (String)request.getAttribute("userList");
 	if(userList!=null && userList.length() > 0){
 		
 		out.println(userList);} %>
 		<br/>
 		<br/>

<% 
    String endPoint = (String)request.getAttribute("rdsEndPoint");
	if(endPoint!=null && endPoint.length() > 0){
		
		out.println(endPoint);} %>
		
		<br/>
		<br/>
</h2>
<a href="loginOff">SignOff</a>
  
</body>
</html>
