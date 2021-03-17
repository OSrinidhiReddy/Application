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
<body>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form  p-l-55 p-r-55 p-t-178"
					action="Registration"
					enctype="multipart/form-data" method="post">
					<span class="login100-form-title"> Registration </span>

					<div class="container wrap-input100 m-b-16">
						<div class="row">
							<div class="col-lg-6 ">
								<input class="input100" type="text" placeholder="First Name"
									name="firstname" id="firstname">
							</div>
							<div class="col-lg-6">
								<input class="input100" type="text" placeholder="Last Name"
									name="lastname" id="lastname">
							</div>
						</div>
						<div class="row p-t-15">
							<div class="col-lg-6 ">
								<input class="input100" type="email" placeholder="Email Id"
									name="emailid" id="emailid">
							</div>
							<div class="col-lg-6">
								<input class="input100" type="text" placeholder="Mobile number"
									name="mobilenumber">
							</div>
						</div>
						<div class="row p-t-15">
							<div class="col-lg-6 ">
								<input class="input100" type="password" placeholder="Password"
									name="password" id="password"><br><br>
							</div>
						<div class="row p-t-15">
							<div class="col-lg-6 ">
								<input class="input100 p-t-15" type="file" name="imageupload"
								accept="image/*">
							</div>

						</div>
					</div>

					<center>
						<div class="container-login100-form-btn">
							<button class="login100-form-btn" type="submit" value="register"
								name="submit">Register</button>
						</div>
					</center>
					<div class="flex-col-c p-t-50 p-b-40">
						<span class="txt1 p-b-9"> Do you have an account? </span> 
						<a href="Login.jsp" class="txt3"> Log In </a>
					</div>
				</form>
			</div>
		</div>
	</div>



	<script src="vendor/animsition/js/animsition.min.js"></script>
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>

	

</body>
</html>