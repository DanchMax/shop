<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="/resources/css/item.css">
<form action="/user/userItem" method="post">
		<table>
			<tr>
				<th>Product name</th>
				<th>Product cost</th>
				<th>Product manufacturer</th>
				<th>Product country</th>
				<th>Product subcategory</th>
			</tr>
			<c:forEach items="${items}" var="item">
				<tr>
					<td>${item.name}</td>
					<td>${item.cost}</td>
					<td>${item.manufacturer.name}</td>
					<td>${item.country.name}</td>
					<td>${item.subcategory.name}</td>
					<td><a href="">Bay</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td><a href="/user">Back to user panel</a></td>
			</tr>
		</table>
	</form>
