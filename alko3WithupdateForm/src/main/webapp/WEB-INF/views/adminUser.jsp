<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User</title>
</head>
<h2>User menu</h2>
<body>
	<form action="/admin/adminUser" method="post">
		<table>
			<tr>
				<td><select name="role">
						<c:forEach items="${roles}" var="role">
							<option value="${role.role}">${role.role}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><select name="sex">
						<c:forEach items="${sexs}" var="sex">
							<option value="${sex.sex}">${sex.sex}</option>
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
				<td><input name="password" placeholder="password"></td>
			</tr>
			<tr>
				<td><input name="mail" placeholder="email"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit new user"></td>
			</tr>
		</table>
	</form>
	<table>

		<c:forEach items="${users}" var="user">
			<tr>
				
				<td>${user.login}</td>
				<td>${user.password}</td>
				<td>${user.sex}</td>
				<td>${user.role}</td>
				<td>${user.mail}</td>
				<td><a href="/admin/adminUser/delete/${user.id}">delete</a></td>
				<td><a href="/admin/adminUser/update/${user.id}">update</a></td>
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