<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
	
	<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
			<p>incorrect password check the passwords!!!!
				<form class="login100-form  p-l-55 p-r-55 p-t-178" action="ForgetPassword" method="post">
					

					

                    <div class="wrap-input100 m-b-16">
						<input class="input100" type="password" placeholder="New Password" name="password">
						<span class="focus-input100"></span>
                    </div>
                    <div class="wrap-input100 m-b-16">
						<input class="input100" type="password" placeholder="Confirm Password" name="cpassword">
						<span class="focus-input100"></span>
					</div>
					

					<center>
                        <div class="container-login100-form-btn p-b-40" style="width: 40%;">
                        <input class="login100-form-btn" name="submit" type="submit" value="verify">         
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