
<!DOCTYPE html>
<html>
<head>
<title>ChangePassword</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
href="vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">

<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<%

response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
response.setHeader("Progma", "no-cache");
response.setHeader("Expires", "0");


%>

<div class="limiter">
<div class="container-login100">
<div class="wrap-login100">
<form action="ChangePassword"
method="post">
<%

response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
response.setHeader("Progma", "no-cache");
response.setHeader("Expires", "0");


%>

<tr>
<td>
<center>
<h5>${message}</h5>
<h5>${successsmessage}</h5>
</center>
</td>
<td></td>
</tr>
<span class="login100-form-title"> Change Password </span>

<div class="wrap-input100 m-b-16">
<input class="input100" type="text" placeholder="Old Password" name="pass" >
<span class="focus-input100"></span>
</div>

<div class="wrap-input100 m-b-16">
<input class="input100" type="password" name="npass"
placeholder=" New Password"> <span class="focus-input100"></span>
</div>
<div class="wrap-input100 m-b-16">
<input class="input100" type="password" name="pass"
placeholder=" Confirm Password"> <span
class="focus-input100"></span>
</div>
<div class="text-right p-t-13 p-b-23"></div>

<div class="container-login100-form-btn">
<input class="login100-form-btn" type="submit" name="submit"
value="SavePassword">
</div>
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