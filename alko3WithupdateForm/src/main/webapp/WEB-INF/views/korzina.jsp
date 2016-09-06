<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Korzina</title>
</head>
<body>
	<h2>korzina menu</h2>
	<form action="/admin/korzina" method="post">
		<table>
			<tr>
				<td><select name="name">
						<c:forEach items="${uzers}" var="uzer">
							<option value="${uzer.name}">${uzer.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><select name="name">
						<c:forEach items="${items}" var="item">
							<option value="${item.title}">${item.title}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit new korzina"></td>
			</tr>
		</table>

	</form>
	<table>
		<tr>
			<th>korzina</th>
		</tr>
		<c:forEach items="${korzinas}" var="korzina">
			<tr>
				<td>${korzina.id}</td>
				<td>${korzina.uzer.name}</td>
				<td>${korzina.item.title}</td>

				<td><a href="/admin/korzina/delete/${korzina.id}">delete</a></td>
				<td><a href="/admin/korzina/update/${korzina.id}">update</a></td>
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