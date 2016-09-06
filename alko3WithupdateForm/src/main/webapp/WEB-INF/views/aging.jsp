<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Aging</title>
</head>
<body>

	<form:errors path="*" />
	<form action="/admin/aging" method="post">
		<table>

			<tr>
				<td><form:errors path="name" /></td>
			</tr>
			<tr>
				<td><input name="name"></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
	<table>
		<tr>
			<th>Aging title</th>
		</tr>

		<c:forEach items="${agings}" var="aging">
			<tr>
				<td>${aging.aging}</td>
				<td><a href="/admin/aging/delete/${aging.id}">delete</a></td>
				<td><a href="/admin/aging/update/${aging.id}">update</a></td>
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