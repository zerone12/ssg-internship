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
	
	<title>Users</title>
</head>
<body>
	<div class="container">
	<h2>User Details</h2>
	<form method="POST" action="/users/${user.id}" modelAttribute="user">
		<div class="form-group">
			<label for="id">user ID</label>
			<input type="text" class="form-control" id="id" name="id" value="${user.id}" readonly>
		</div>
		<div class="form-group">
			<label for="firstName">First Name</label>
			<input type="text" class="form-control" id="firstName" name="firstName" value="${user.firstName}">
		</div>
		<div class="form-group">
			<label for="lastName">Last Name</label>
			<input type="text" class="form-control" id="lastName" name="lastName" value="${user.lastName}">
		</div>
		<div class="form-group">
			<label for="email">Email</label>
			<input type="text" class="form-control" id="email" name="email" value="${user.email}">
		</div>
		<div class="form-group">
			<label for="city">City</label>
			<input type="text" class="form-control" id="city" name="city" value="${user.city}">
		</div>
		<div class="form-group">
			<label for="street">Street</label>
			<input type="text" class="form-control" id="street" name="street" value="${user.street}">
		</div>
		<div class="form-group">
			<label for="zipCode">Zip Code</label>
			<input type="text" class="form-control" id="zipCode" name="zipCode" value="${user.zipCode}">
		</div>
		<div class="form-group">
			<input type="submit" class="btn btn-primary" value="Update">
			<button type="button" class="btn btn-secondary" onclick="window.location.href = '/users';">Go Back</button>
		</div>
	</form>
	</div>
	<br>
	<div class="container">
		<button type="button" class="btn btn-info" onclick="window.location.href = '/orders/new/${user.id}';">Make Orders</button>
		<button type="button" class="btn btn-danger" onclick="window.location.href = '/orders/byuser/${user.id}';">Modify Orders</button>
	</div>
	<!-- Bootstrap JavaScript -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>