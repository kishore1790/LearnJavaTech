<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<div class="container">
		<div class="col-md-6">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Employee List</h3>
					<div class="pull-right">
						<span class="clickable filter" data-toggle="tooltip"
							title="Toggle table filter" data-container="body"> <i
							class="glyphicon glyphicon-filter"></i>
						</span>
					</div>
				</div>
				<div class="panel-body">
					<input type="text" class="form-control" id="dev-table-filter"
						data-action="filter" data-filters="#dev-table"
						placeholder="Employee Name" />
				</div>
				<table class="table table-hover" id="dev-table">
					<thead>
						<tr>
							<th>#</th>
							<th>Employee Name</th>
							<th>Designation</th>
							<th>Age</th>
							<th>Salary</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach  step="1"
							varStatus="loopCounter" items="${employeeList}" var="emp">
							<tr>
								<td><c:out value="${loopCounter.index+1}" /></td>
								<td><c:out value="${emp.name}" /></td>
								<td><c:out value="${emp.designation}" /></td>
								<td><c:out value="${emp.age}" /></td>
								<td><c:out value="${emp.salary}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>