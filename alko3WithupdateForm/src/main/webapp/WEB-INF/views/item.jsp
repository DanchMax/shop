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
				<td>
					<p>Brand</p> <form:select path="brand">
						<c:forEach items="${brands}" var="brand">
							<c:choose>
								<c:when test="${brand.id eq form.brand.id}">
									<option value="${brand.id}" selected="selected">${brand.brand}</option>
								</c:when>
								<c:otherwise>
									<option value="${brand.id}">${brand.brand}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select>
				</td>
			</tr>
			<tr>

				<td><p>Country</p>
					<form:select path="country">
						<c:forEach items="${countrys}" var="country">
							<c:choose>
								<c:when test="${country.id eq form.country.id}">
									<option value="${country.id}" selected="selected">${country.country}</option>
								</c:when>
								<c:otherwise>
									<option value="${country.id}">${country.country}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td>
					<p>Category</p> <form:select path="category">
						<c:forEach items="${categorys}" var="category">
							<c:choose>
								<c:when test="${category.id eq form.category.id}">
									<option value="${category.id}" selected="selected">${category.category}</option>
								</c:when>
								<c:otherwise>
									<option value="${category.id}">${category.category}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>
					<p>Perman</p> <form:select path="perman">
						<c:forEach items="${permans}" var="perman">
							<c:choose>
								<c:when test="${perman.id eq form.perman.id}">
									<option value="${perman.id}" selected="selected">${perman.perman}</option>
								</c:when>
								<c:otherwise>
									<option value="${perman.id}">${perman.perman}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>
					<p>Size</p> <form:select path="size">
						<c:forEach items="${sizes}" var="size">
							<c:choose>
								<c:when test="${size.id eq form.size.id}">
									<option value="${size.id}" selected="selected">${size.size}</option>
								</c:when>
								<c:otherwise>
									<option value="${size.id}">${size.size}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select>
				</td>
			</tr>
			<tr>
				<td><form:errors path="name" /></td>
			</tr>
			<tr>
				<td><form:input path="name" placeholder="Item name" /></td>
			</tr>
			<tr>
				<td><form:errors path="price" /></td>
			</tr>
			<tr>
				<td><form:input path="price" placeholder="Item price" /></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form:form>



	<table>

		<c:forEach items="${page.content}" var="item">
			<tr>


				<td>${item.name}</td>
				<td>${item.price}</td>
				<td>${item.brand.brand}</td>
				<td>${item.category.category}</td>
				<td>${item.country.country}</td>
				<td>${item.perman.perman}</td>
				<td>${item.size.size}</td>

				<td><a
					href="/admin/item/delete/${item.id}?page=${page.number+1}&size=${page.size}&sort=${param['sort']}">delete</a></td>
				<td><a href="/admin/item/update/${item.id}">update</a></td>
			</tr>
		</c:forEach>

		<tr>
			<c:if test="${!page.isFirst()}">
				<td><a
					href="?page=${page.number}&size=${page.size}&sort=${param['sort']}">Previous</a></td>
			</c:if>
			<c:if test="${!page.isLast()}">
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
			<td><a href="?page=1&size=${page.size}&sort=name">name asc</a></td>
			<td><a href="?page=1&size=${page.size}&sort=name,desc">name
					desc</a></td>
			<td><a href="?page=1&size=${page.size}&sort=price">price asc</a></td>
			<td><a href="?page=1&size=${page.size}&sort=price,desc">price
					desc</a></td>
			<td><a href="?page=1&size=${page.size}&sort=brand.brand">brand
					asc</a></td>
			<td><a href="?page=1&size=${page.size}&sort=brand.brand,desc">brand
					desc</a></td>
			<td><a href="?page=1&size=${page.size}&sort=category.category">category
					asc</a></td>
			<td><a
				href="?page=1&size=${page.size}&sort=category.category,desc">category
					desc</a></td>
			<td><a href="?page=1&size=${page.size}&sort=country.country">country
					asc</a></td>
			<td><a
				href="?page=1&size=${page.size}&sort=country.country,desc">country
					desc</a></td>
			<td><a href="?page=1&size=${page.size}&sort=perman.perman">perman
					asc</a></td>
			<td><a href="?page=1&size=${page.size}&sort=perman.perman,desc">perman
					desc</a></td>

			<td><a href="?page=1&size=${page.size}&sort=size.size">size
					asc</a></td>
			<td><a href="?page=1&size=${page.size}&sort=size.size,desc">size
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