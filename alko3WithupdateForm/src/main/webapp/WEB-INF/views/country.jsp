<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Country name</title>
</head>
<body>
	<form:form action="/admin/country" method="post" modelAttribute="country">
		<form:hidden path="id" />
		<table>
			<tr>
				<td><form:errors path="country" /></td>
			</tr>
			<tr>
				<td><form:input path="country"/></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
		</form:form>
		<table>
			<tr>
				<th>Country name</th>
			</tr>
			<c:forEach items="${page.content}" var="country">
				<tr>
					<td>${country.country}</td>
					<td><a href="/admin/country/delete/${country.id}?page=${page.number+1}&size=${page.size}&sort=${param['sort']}">delete</a></td>
					<td><a href="/admin/country/update/${country.id}">update</a></td>
				</tr>
			</c:forEach>
		</table>
		<table>
		<tr>
			<c:if test="${page.hasPrevious()}">
				<td><a
					href="?page=${page.number}&size=${page.size}&sort=${param['sort']}">Previous</a></td>
			</c:if>
			<c:if test="${page.hasNext()}">
				<td><a
					href="?page=${page.number+2}&size=${page.size}&sort=${param['sort']}">Next</a></td>
			</c:if>
		</tr>
		<tr>
			<td><a href="?page=1&size=1&sort=${param['sort']}">1</a></td>
			<td><a href="?page=1&size=5&sort=${param['sort']}">5</a></td>
			<td><a href="?page=1&size=10&sort=${param['sort']}">10</a></td>
			<td><a href="?page=1&size=20&sort=${param['sort']}">20</a></td>
		</tr>
		<tr>
			<td><a href="?page=1&size=${page.size}&sort=country">Name asc</a></td>
			<td><a href="?page=1&size=${page.size}&sort=country,desc">Name
					desc</a></td>
		</tr>
	</table>
		<hr>
		<a href="/admin">Back to admin panel</a>
		<hr>
		<p>
			<a href="/">Back to the index</a>
		</p>
</body>
</html>