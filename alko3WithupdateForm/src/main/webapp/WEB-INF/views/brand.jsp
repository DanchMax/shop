<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Brand title</title>
</head>
<body>
<form action="/admin/brand" method="post">
		<table>
			<tr>
				<td><input name="title"></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
	<table>
		<tr>
			<th>Brand title</th>
		</tr>
		<c:forEach items="${brands}" var="brand">
			<tr>
				<td>${brand.title}</td>
				<td>
					<a href="/admin/brand/delete/${brand.id}">delete</a>
				</td>
				<td>
					<a href="/admin/brand/update/${brand.id}">update</a>
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