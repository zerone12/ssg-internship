<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<!-- Bootstrap CSS & required meta tags -->
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
	<title>User's Orders</title>
</head>
<body>
	<div class="container">
	<h2>User's Orders</h2>
	<p>select orders you wish to cancel</p>
	<form method="POST" action="/orders/byuser/${user_id}">
		<div class="container">
		<table class="table table-hover">
		<thead>
			<tr>
				<th scope="col"> </th>
				<th scope="col">Product ID</th>
				<th scope="col">Product Name</th>
				<th scope="col">Qty</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${products}">
				<tr>
					<td>
						<input type="radio" id="${product.productId}" name="${product.productId}" value="${product.quantity}">
					</td>
					<td>${product.productId}</td>
					<td>${product.productName}</td>
					<td>${product.quantity}</td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
		<div class="form-group">
			<input type="submit" class="btn btn-primary" value="Delete Order">
			<button type="button" class="btn btn-secondary" onclick="window.location.href = '/users/${user_id}';">Cancel</button>
		</div>
	</form>
	</div>
	<!-- Bootstrap JavaScript -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>