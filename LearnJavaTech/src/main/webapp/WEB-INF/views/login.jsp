<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<link href="${css}/bootstrap-theme.min.css" rel="stylesheet">
<link href="${css}/login.css" rel="stylesheet">

<script src="${js}/jquery-3.2.1.js"></script>
<script src="${js}/bootstrap.min.js"></script>
<script src="${js}/login.js"></script>
</head>
<body>

<!--
    you can substitue the span of reauth email for a input with the email and
    include the remember me checkbox
    -->
    <div class="container">
        <div class="card card-container">
            <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" />
<!--             <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" /> -->
            <p id="profile-name" class="profile-name-card"></p>
            <form:form class="form-signin" method="post" action="${contextRoot}/loginValidate"  modelAttribute="user" >
<%-- 				<form:hidden path="id" /> --%>
				<form:input class="form-control" path="name" placeholder="Name" />
				<form:input class="form-control" path="password" placeholder="Password"  />
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Let me in.</button>
            </form:form><!-- /form -->
            <a href="#" class="forgot-password">
                Forgot the password?
            </a>
        </div><!-- /card-container -->
    </div><!-- /container -->

<%-- ${contextRoot } says -${greeting} --%>

</body>
</html>