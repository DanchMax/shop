<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Item</title>
</head>
<body>
	<h2>Item menu</h2>
	
	<form:form action="/admin/item" method="post" modelAttribute="form">
		<form:hidden path="id" />
		<table>
			<tr>
				<td><form:select path="country">
						<c:forEach items="${countries}" var="country">
							<c:choose>
								<c:when test="${country.id eq form.country.id}">
									<option value="${country.id}" selected="selected">${country.title}</option>
								</c:when>
								<c:otherwise>
									<option value="${country.id}">${country.title}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><form:select path="aging">
						<c:forEach items="${agings}" var="aging">
							<c:choose>
								<c:when test="${aging.id eq form.aging.id}">
									<option value="${aging.id}" selected="selected">${aging.title}</option>
								</c:when>
								<c:otherwise>
									<option value="${aging.id}">${aging.title}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><form:select path="brand">
						<c:forEach items="${brands}" var="brand">
							<c:choose>
								<c:when test="${brand.id eq form.brand.id}">
									<option value="${brand.id}" selected="selected">${brand.title}</option>
								</c:when>
								<c:otherwise>
									<option value="${brand.id}">${brand.title}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><form:select path="category">
						<c:forEach items="${categorys}" var="category">
							<c:choose>
								<c:when test="${category.id eq form.category.id}">
									<option value="${category.id}" selected="selected">${category.title}</option>
								</c:when>
								<c:otherwise>
									<option value="${category.id}">${category.title}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><form:select path="perman">
						<c:forEach items="${permans}" var="perman">
							<c:choose>
								<c:when test="${perman.id eq form.perman.id}">
									<option value="${perman.id}" selected="selected">${perman.title}</option>
								</c:when>
								<c:otherwise>
									<option value="${perman.id}">${perman.title}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><form:select path="size">
						<c:forEach items="${sizes}" var="size">
							<c:choose>
								<c:when test="${size.id eq form.size.id}">
									<option value="${size.id}" selected="selected">${size.title}</option>
								</c:when>
								<c:otherwise>
									<option value="${size.id}">${size.title}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><form:select path="star">
						<c:forEach items="${stars}" var="star">
							<c:choose>
								<c:when test="${star.id eq form.star.id}">
									<option value="${star.id}" selected="selected">${star.title}</option>
								</c:when>
								<c:otherwise>
									<option value="${star.id}">${star.title}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><form:input path="title" placeholder="Item title" /></td>
			</tr>
			<tr>
				<td><form:input path="price" placeholder="Item title" /></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form:form>
	
	
	
	<table>

		<c:forEach items="${items}" var="item">
			<tr>
				
				
				<td>${item.title}</td>
				<td>${item.price}</td>
				<td>${item.aging.title}</td>
				<td>${item.brand.title}</td>
				<td>${item.category.title}</td>
				<td>${item.country.title}</td>
				<td>${item.perman.title}</td>
				<td>${item.size.title}</td>
				<td>${item.star.title}</td>
				<td><a href="/admin/item/delete/${item.id}">delete</a></td>
				<td><a href="/admin/item/update/${item.id}">update</a></td>
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