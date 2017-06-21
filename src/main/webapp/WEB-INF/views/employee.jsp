<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CRUD TEST</title>
</head>
<body>
<!-- <view> -->
	<h1>Add Employee</h1>
		<c:url var="addAction" value="/add"></c:url> 
		<form:form action="${addAction}" commandName="employee">
			<table>
				<c:if test="${!empty employee.name }">
					<tr> 
					 	<td>
					 	<form:label path="id">
					 	 	<spring:message  text="ID"/>
					 	</form:label>
					 	</td>
					 	<td>
					 		<form:input path="id" readonly="true" size="8" disabled="true"/>
					 		<form:hidden path="id"/>
					 	</td>
					</tr>
				</c:if>
					<tr> 
					 	<td>
					 	<form:label path="name">
					 	 	<spring:message  text="Name"/>
					 	</form:label>
					 	</td>
					 	<td>
					 		<form:input path="name" />
					 	</td>
					</tr>
					<tr> 
					 	<td>
					 	<form:label path="designation">
					 	 	<spring:message  text="Designation"/>
					 	</form:label>
					 	</td>
					 	<td>
					 		<form:input path="designation" />
					 	</td>
					</tr>
					<tr> 
					 	<td>
					 	<form:label path="salary">
					 	 	<spring:message  text="Salary"/>
					 	</form:label>
					 	</td>
					 	<td>
					 		<form:input path="salary" />
					 	</td>
					</tr>
					<tr>
						<td colspan="2">
							<c:if test="${!empty employee.name}">
								<input type="submit"  value="<spring:message text="Edit employee"/>"/>
							</c:if>
							<c:if test="${empty employee.name}">
								<input type="submit" value="<spring:message text="Add Employee"/>" />
							</c:if>
						</td>
					</tr>
			</table>
		</form:form>
		<br>
		<h3>Employees List</h3>
		<c:if test="${!empty listEmployees}">
			<table class="tg">
				<tr>
					<th>Name</th>
					<th>Designation</th>
					<th>Salary</th>
					<td>Edit</td>
					<td>Delete</td>
				</tr>	
				<c:forEach items="${listEmployees}" var="employee">
					<tr>
						<td>${employee.name}</td>
						<td>${employee.designation}</td>
						<td>${employee.salary}</td>
						<td><a href="<c:url value='/edit/${employee.id}' />">Edit</a></td>
						<td><a href="<c:url value='/delete/${employee.id}' />">Delete</a></td>
					</tr>				
				</c:forEach>
			</table>
		</c:if>


</body>
</html>