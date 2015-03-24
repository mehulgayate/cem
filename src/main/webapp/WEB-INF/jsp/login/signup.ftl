<!DOCTYPE html>
<html>

<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
  <meta charset="UTF-8">

  <title>Sign in</title>

    <style>
@import url(http://fonts.googleapis.com/css?family=Exo:100,200,400);
@import url(http://fonts.googleapis.com/css?family=Source+Sans+Pro:700,400,300);

body{
	margin: 0;
	padding: 0;
	background: #fff;

	color: #fff;
	font-family: Arial;
	font-size: 12px;
}

.body{
	position: absolute;
	top: -20px;
	left: -20px;
	right: -40px;
	bottom: -40px;
	width: auto;
	height: auto;
	background-image: url(http://ginva.com/wp-content/uploads/2012/07/city-skyline-wallpapers-008.jpg);
	background-size: cover;
	-webkit-filter: blur(5px);
	z-index: 0;
}

.grad{
	position: absolute;
	top: -20px;
	left: -20px;
	right: -40px;
	bottom: -40px;
	width: auto;
	height: auto;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(0,0,0,0)), color-stop(100%,rgba(0,0,0,0.65))); /* Chrome,Safari4+ */
	z-index: 1;
	opacity: 0.7;
}

.header{
	position: absolute;
	top: calc(50% - 35px);
	left: calc(50% - 255px);
	z-index: 2;
}

.header div{
	float: left;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 35px;
	font-weight: 200;
}

.header div span{
	color: #5379fa !important;
}

.login{
	position: absolute;
	top: calc(50% - 75px);
	left: calc(50% - 50px);
	height: 150px;
	width: 350px;
	padding: 10px;
	z-index: 2;
}

.login input[type=text]{
	width: 250px;
	height: 30px;
	background: transparent;
	border: 1px solid rgba(255,255,255,0.6);
	border-radius: 2px;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 4px;
	margin-top: 10px;
}

.login input[type=password]{
	width: 250px;
	height: 30px;
	background: transparent;
	border: 1px solid rgba(255,255,255,0.6);
	border-radius: 2px;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 4px;
	margin-top: 10px;
}

#signUpButton{
	width: 260px;
	height: 35px;
	background: #fff;
	border: 1px solid #fff;
	cursor: pointer;
	border-radius: 2px;
	color: #a18d6c;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 6px;
	margin-top: 10px;
}

.login input[type=submit]:hover{
	opacity: 0.8;
}

.login input[type=submit]:active{
	opacity: 0.6;
}

.login input[type=text]:focus{
	outline: none;
	border: 1px solid rgba(255,255,255,0.9);
}

.login input[type=password]:focus{
	outline: none;
	border: 1px solid rgba(255,255,255,0.9);
}

.login input[type=submit]:focus{
	outline: none;
}

::-webkit-input-placeholder{
   color: rgba(255,255,255,0.6);
}

::-moz-input-placeholder{
   color: rgba(255,255,255,0.6);
}

.errorClass{
	display: none;
}
</style>

    <script src="/static/login/js/prefixfree.min.js"></script>

</head>
<script type="text/javascript">
$(function() {
$("#signUpButton").click(function(){
	$(".errorClass").hide();
	if($("#name").val()==""){
		$("#nameError").show();
	}else if($("#email").val()==""){
		$("#emailError").show();
	}else if($("#password").val()==""){
		$("#passwordError").show();
	}else{
		$("#signUpForm").submit();
	}
	
});
});

</script>

<body>

  <div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div>Secure<span>KNN</span></div>
		</div>
		<br>
		<form action="/add-user" method="post" id="signUpForm">
			<div class="login">
					<input type="text" placeholder="Name" name="name" id="name"><br><span class="errorClass" style="color: red" id="nameError">Name cannot be blank</span>
					<input type="text" placeholder="Email" name="email" id="email"><br><span class="errorClass" style="color: red" id="emailError">Email cannot be blank</span>
					<input type="password" placeholder="Password" name="password" id="password"><br><span class="errorClass" style="color: red" id="passwordError">Password cannot be blank</span>
					<input type="text" placeholder="Address" name="address" id="address"><br><span class="errorClass" style="color: red"></span>
					<input type="text" placeholder="Phone" name="phone" id="phone"><br><span class="errorClass" style="color: red"></span>
					<input type="button" value="SignUp" id="signUpButton"><br>
					
			</div>
		</form>

  <script src='http://codepen.io/assets/libs/fullpage/jquery.js'></script>

</body>

</html>