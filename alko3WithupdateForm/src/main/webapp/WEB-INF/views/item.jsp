<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script>
$(function() {
	$('select[name=country]').chosen();
	$('select[name=brand]').chosen();
	$('select[name=perman]').chosen();
	$('select[name=size]').chosen();
	$('select[name=category]').chosen();
});
</script>
	<div class="row">
			<div class="col-md-12">
				<nav class="navbar navbar-default">
					<div class="container-fluid">
						<div class="collapse navbar-collapse" id="">
							<ul class="nav navbar-nav">
								<li><a href="/admin/brand">Brand</a></li>
							<li><a href="/admin/category">Category</a></li>
							<li><a href="/admin/country">Country</a></li>
								<li class="active"><a href="/admin/item">Item</a><span
										class="sr-only">(current)</span></li>
								<li><a href="/admin/perman">Perman</a></li>
								<li><a href="/admin/size">Size</a></li>
							</ul>
						</div>
					</div>
				</nav>
			</div>
		</div>
		
		<div class="col-md-3 col-xs-12">
			<form:form action="/admin/item" class="form-inline" method="get" modelAttribute="filter">
				<custom:hiddenInputs excludeParams="min, max, brandIds, countryIds,categoryIds, permanIds, sizeIds, _sizeIds, _permanIds, _categoryIds, _countryIds, _brandIds"/>
				<div class="form-group">
					<form:input path="min" placeholder="min" class="form-control"/>
					<form:input path="max" placeholder="max" class="form-control"/>
				</div>
				
				<div class="form-group">
					<h4 id="b">Brand</h4>
				</div>
					<div class="form-group">
					<form:checkboxes items="${brands}" path="brandIds" itemLabel="brand" itemValue="id" />
				</div>
				
				
				<div class="form-group">
					<h4 id="b">Country</h4>
				</div>
				<div class="form-group">
					<form:checkboxes items="${countrys}" path="countryIds" itemLabel="country" itemValue="id"/>
				</div>
				
				<div class="form-group">
					<h4 id="b">Category</h4>
				</div>
				<div class="form-group">
					<form:checkboxes items="${categorys}" path="categoryIds" itemLabel="category" itemValue="id" />
				</div>
				
				<div class="form-group">
					<h4 id="b">Perman</h4>
				</div>
				<div class="form-group">
					<form:checkboxes items="${permans}" path="permanIds" itemLabel="perman" itemValue="id" />
				</div>
				
				<div class="form-group">
					<h4 id="b">Size</h4>
				</div>
				<div class="form-group">
					<form:checkboxes items="${sizes}" path="sizeIds" itemLabel="size" itemValue="id" />
				</div>
				
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Ok</button>
				</div>
			</form:form>
		</div>
		
		<div class="col-md-7">
	<form:form action="/admin/item" method="post" modelAttribute="form" class="form-inline" enctype="multipart/form-data">
		<form:errors path="*"/>
		<form:hidden path="id" />
		<form:hidden path="path" />
		<form:hidden path="version" />
		<custom:hiddenInputs excludeParams="name, id, price, brand, country, category, perman, size,  path, version,"/>
		
			<div class="form-group">
			
			<label for="name"><form:errors path="name"/></label>
			<form:input path="name" id="name" class="form-control"  placeholder="Item name" />
			
			<label for="price"><form:errors path="price" /></label>
			<form:input path="price" id="price" class="form-control" placeholder="00" />
			
			
			<form:select path="brand" items="${brands}" itemLabel="brand" itemValue="id" >
				<option value="0">Brand</option>
			</form:select>
			
			<form:select path="country" items="${countrys}" itemLabel="country" itemValue="id">
				<option value="0">Country</option>
			</form:select>
			<form:select path="category" items="${categorys}" itemLabel="category" itemValue="id">
				<option value="0">Category</option>
			</form:select>
			<form:select path="perman" items="${permans}" itemLabel="perman" itemValue="id">
				<option value="0">Perman</option>
			</form:select>
			<form:select path="size" items="${sizes}" itemLabel="size" itemValue="id">
				<option value="0">Size</option>
			</form:select>
			<div class="form-group">
				<label class="btn btn-default btn-file"> Browse <input
					type="file" name="file" style="display: none;">
				</label>
			</div>
				<button type="submit" class="btn btn-primary">Create Item</button>
			</div>
			
	</form:form>
	<div class="row">
	<div class="col-md-3"><h4>Image</h4></div>
	<div class="col-md-3"><h4>Item name</h4></div>
	<div class="col-md-3"><h4>Delete</h4></div>
	<div class="col-md-3"><h4>Update</h4></div>
	</div>
		<c:forEach items="${page.content}" var="item">
		<div class="row">
		<div class="col-md-2"><img class="img-thumbnail" width="100" src="/images/item/${item.id}${item.path}?version=${item.version}" /></div>
		
			<div class="col-md-2"><h4>${item.name}</h4></div>
			<div class="col-md-2"><h4>${item.price}</h4></div>
			<div class="col-md-2"><h4>${item.brand.brand}</h4></div>
			<div class="col-md-2"><h4>${item.country.country}</h4></div>
			<div class="col-md-2"><h4>${item.category.category}</h4></div>
			<div class="col-md-2"><h4>${item.perman.perman}</h4></div>
			<div class="col-md-2"><h4>${item.size.size}</h4></div>
			<div class="col-md-2"><h4><a href="/admin/item/delete/${item.id}<custom:allParams/>">delete</a></h4></div>
			<div class="col-md-2"><h4><a href="/admin/item/update/${item.id}<custom:allParams/>">update</a></h4></div>
			</div>
		</c:forEach>
		<div class="col-md-12 text-center">
				<custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>" />
		</div>
		</div>
		<div class="col-md-2">
			<div class="col-md-6">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<custom:sort innerHtml="Name asc" paramValue="name"/>
						<custom:sort innerHtml="Name desc" paramValue="name,desc"/>
						<custom:sort innerHtml="Price asc" paramValue="price"/>
						<custom:sort innerHtml="Price desc" paramValue="price,desc"/>
						<custom:sort innerHtml="Brand  asc" paramValue="brand.brand"/>
						<custom:sort innerHtml="Brand  desc" paramValue="brand.brand,desc"/>
						<custom:sort innerHtml="Country  asc" paramValue="country.country"/>
						<custom:sort innerHtml="Country  desc" paramValue="country.country,desc"/>
						<custom:sort innerHtml="Category  asc" paramValue="category.category"/>
						<custom:sort innerHtml="Category  desc" paramValue="category.category,desc"/>
						<custom:sort innerHtml="Perman  asc" paramValue="perman.perman"/>
						<custom:sort innerHtml="Perman  desc" paramValue="perman.perman,desc"/>
						<custom:sort innerHtml="Size  asc" paramValue="size.size"/>
						<custom:sort innerHtml="Size  desc" paramValue="size.size,desc"/>
					</ul>
				</div>
			</div>
			<div class="col-md-6">
				<custom:size posibleSizes="1,2,5,10" size="${page.size}" title="Page size"/>
			</div>
		</div>
	</div>