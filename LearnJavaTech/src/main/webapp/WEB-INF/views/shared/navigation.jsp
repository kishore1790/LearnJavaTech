<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>

<link href="${css}/bootstrap.min.css" rel="stylesheet">
<link href="${css}/bootstrap-theme.min.css" rel="stylesheet">

<script src="${js}/jquery-3.2.1.js"></script>
<script src="${js}/bootstrap.min.js"></script>
<!-- Bootstrap core JavaScript -->
<%-- 	<script src="${js}/jquery.min.js"></script> --%>
<script src="${js}/popper.min.js"></script>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<title >Employee Management</title>

 <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Java Tech</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">DashBoard</a></li>
      <li><a href="#">Employee</a></li>
      <li><a href="#">XXXXX</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span>My Account(${user.name})</a></li>
      
      <li><a href="${contextRoot }/login" onclick=""><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</nav> 
</html>