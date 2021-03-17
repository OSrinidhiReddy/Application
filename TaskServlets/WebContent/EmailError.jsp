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

<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form  p-l-55 p-r-55 p-t-178" action="SendingEmail" method="Post">
				
				
				<p>Enter validate emailid...!!!!</p>
				
					<span class="login100-form-title"> Forgot Password </span>

					<div class="wrap-input100 m-b-16">
						<input class="input100" type="email"  placeholder="Enter Email Id" name="email">
						<span class="focus-input100"></span>
					</div>


					<center>
						<div class="container-login100-form-btn p-b-40"
							style="width: 40%;">
							<input class="login100-form-btn" name="submit" type="submit" value="getotp">
							
								<a href="" style="color: white;"> Get OTP</a>
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