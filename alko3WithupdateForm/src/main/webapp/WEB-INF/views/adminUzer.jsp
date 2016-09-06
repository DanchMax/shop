<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UZer</title>
</head>
<h2>Uzer menu</h2>
<body>
	<form action="/admin/uzer" method="post">
		<table>
			<tr>
				<td><select name="role">
						<c:forEach items="${roles}" var="role">
							<option value="${role.title}">${role.title}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><select name="sex">
						<c:forEach items="${sexs}" var="sex">
							<option value="${sex.title}">${sex.title}</option>
						</c:forEach>

				</select></td>

			</tr>
			
			<tr>
				<td><input name="name" placeholder="username"></td>
			</tr>
			<tr>
				<td><input name="login" placeholder="login"></td>
			</tr>
			<tr>
				<td><input name="pass" placeholder="password"></td>
			</tr>
			<tr>
				<td><input name="mail" placeholder="email"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit new uzer"></td>
			</tr>
		</table>
	</form>
	<table>

		<c:forEach items="${uzers}" var="uzer">
			<tr>
				<td>${uzer.name}</td>
				<td>${uzer.login}</td>
				<td>${uzer.pass}</td>
				<td>${uzer.sex}</td>
				<td>${uzer.role}</td>
				<td>${uzer.mail}</td>
				<td><a href="/admin/uzer/delete/${uzer.id}">delete</a></td>
				<td><a href="/admin/uzer/update/${uzer.id}">update</a></td>
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