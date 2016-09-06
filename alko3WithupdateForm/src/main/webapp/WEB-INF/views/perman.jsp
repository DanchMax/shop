<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Perman name</title>
</head>
<body>
	<form:form action="/admin/perman" method="post" modelAttribute="perman">
		<form:hidden path="id" />
		<table>
			<tr>
				<td><form:errors path="perman" /></td>
			</tr>
			<tr>
				<td><form:input path="perman" /></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form:form>
	<table>
		<tr>
			<th>Perman name</th>
		</tr>
		<c:forEach items="${permans}" var="perman">
			<tr>
				<td>${perman.perman}</td>
				<td><a href="/admin/perman/delete/${perman.id}">delete</a></td>
				<td><a href="/admin/perman/update/${perman.id}">update</a></td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<a href="/admin">Back to admin panel</a>
	<hr>
	<p>
		<a href="/">Back to the index</a>
	</p>
</body>

</html>