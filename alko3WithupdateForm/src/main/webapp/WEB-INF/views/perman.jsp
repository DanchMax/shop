<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Perman title</title>
</head>
<body>
<form action="/admin/perman" method="post">
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
			<th>Perman title</th>
		</tr>
		<c:forEach items="${permans}" var="perman">
			<tr>
				<td>${perman.title}</td>
				<td>
					<a href="/admin/perman/delete/${perman.id}">delete</a>
				</td>
				<td>
					<a href="/admin/perman/update/${perman.id}">update</a>
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