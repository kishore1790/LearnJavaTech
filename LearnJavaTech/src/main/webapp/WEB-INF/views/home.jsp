<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<head>
<jsp:include page="/WEB-INF/views/shared/navigation.jsp" />
</head>
<body>
<strong>Welcome ${user.name} !!!</strong>
	<div class="container-fluid">
<!-- 	  <div class="alert alert-success"> -->
	    <jsp:include page="/WEB-INF/views/view.jsp" />
	  </div>
	</div>
</body>
</html>