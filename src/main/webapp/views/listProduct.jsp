<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
	</div>
	<table border="1" style="width: 100px">
		<tr>
			<td>ID</td>
			<td>Product Name</td>
			<td>Description</td>
			<td>Price</td>
			<td>Image Link</td>
			<td>Category ID</td>
			<td>Seller ID</td>
			<td>Amount</td>
			<td>Stoke</td>
		</tr>
		<c:forEach var="i" items="${list}">
			<tr>
				<td>${i.productID}</td>
				<td>${i.productName}</td>
				<td>${i.description }</td>
				<td>${i.price}</td>
				<td>${i.imageLink}</td>
				<td>${i.categoryID }</td>
				<td>${i.sellerID}</td>
				<td>${i.amount}</td>
				<td>${i.stoke }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>