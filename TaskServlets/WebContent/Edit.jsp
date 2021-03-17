<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">

<link rel="stylesheet" type="text/css" href="css/regis.css">
</head>
<style>
.error {
	color: red;
	margin-left: 50px;
	font-weight: bold;
	font-size: 12px;
}
</style>
<body>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form  p-l-55 p-r-55 p-t-178" id="reg_form"
					action="Edit" method="post" enctype="multipart/form-data">
					
					<span class="login100-form-title"> Edit & Update </span>

					<div class="container wrap-input100 m-b-16">
						<div class="row">
							<div class="col-lg-6 ">
								<input class="input100" id="first_name" type="text"
									placeholder="First Name" name="firstname">
							</div>
							<div class="col-lg-6">
								<input class="input100" id="last_name" type="text"
									placeholder="Last Name" name="lastname">
							</div>
						</div>
						
							<div class="col-lg-6">
								<input class="input100" id="phone_number" type="text"
									placeholder="Mobile number" name="mobilenumber">
							</div>
						</div><br>

						<div class="row p-t-15">
							<div class="col-lg-6 ">
								<input class="input100 p-t-15" type="file" name="photo">
							</div>

						</div>
					</div>

					<center>
						<div class="container-login100-form-btn mb-3">
							<input class="login100-form-btn" name="submit" type="submit"
								value="update">
						</div>
					</center>

				</form> 
			</div>
		</div>
	</div>



	<script src="vendor/animsition/js/animsition.min.js"></script>
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>


</body>
</html>
