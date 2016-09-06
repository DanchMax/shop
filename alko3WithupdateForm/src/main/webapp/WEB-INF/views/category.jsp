<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Category name</title>
</head>
<body>
	<form:form action="/admin/category" method="post" modelAttribute="category">
		<form:hidden path="id"/>
		<table>
 			<tr>
 				<td><form:errors path="category"/></td>
 			</tr>
			<tr>
				<td><form:input path="category"/></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form:form>
	<table>
		<tr>
			<th>Category name</th>
		</tr>
		<c:forEach items="${categorys}" var="category">
			<tr>
				<td>${category.category}</td>
				<td><a href="/admin/category/delete/${category.id}">delete</a>
				</td>
				<td><a href="/admin/category/update/${category.id}">update</a>
				</td>
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