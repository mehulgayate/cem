<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by TEMPLATED
http://templated.co
Released for free under the Creative Commons Attribution License

Name       : RedMarket 
Description: A two-column, fixed-width design with dark color scheme.
Version    : 1.0
Released   : 20140101

-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link href="/static/user/default.css" rel="stylesheet" type="text/css" media="all" />
<link href="/static/user/fonts.css" rel="stylesheet" type="text/css" media="all" />

<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->

</head>
<body>
<div id="header-wrapper">
	<div id="header" class="container">
		<div id="logo">
			<h1><a href="#">FilteredWall</a></h1>
		</div>
		<div id="menu">
			<ul>
				<li><a href="/" accesskey="1" title="">Post Something</a></li>
				<li><a href="/posts" accesskey="1" title="">View Posts </a></li>
				<li><a href="/logout" accesskey="1" title="">Logout </a></li>
				<li class="active">Welcome <a href="/edit-user?id=${Session.user.id}"><b>${Session.user.name}</b></a></li>
				
			</ul>
		</div>
	</div>
	<div id="banner" class="container">
		<div>
			<form action="/save-user" method="post">
				<div style="display:block; width: 650px; background: white; margin: 0 auto; padding: 30px; opacity: 0.6;">
					<div style="display: block;">
						<div style="display: inline-block; width: 300px;">
							<strong>Name :</strong>
						</div>
						<div style="display: inline-block;">
							<input type="text" name="name" style="width: 300px;font-size: 16px; color: red;" value="${Session.user.name?if_exists}"/>
						</div>
					</div>
					<div style="padding-top: 10px;">
						<div style="display: inline-block; width: 300px;">
							<strong>Email :</strong>
						</div>
						<div style="display: inline-block;">
							${Session.user.email?if_exists}
							<input type="hidden" name="email" style="width: 300px;font-size: 16px; color: red;" value="${Session.user.email?if_exists}"/>
						</div>
					</div>
					<div style="padding-top: 10px;">
						<div style="display: inline-block; width: 300px;">
							<strong>Address :</strong>
						</div>
						<div style="display: inline-block;">
							<input type="text" name="address" style="width: 300px;font-size: 16px; color: red;" value="${Session.user.address?if_exists}"/>
						</div>
					</div>
					<div style="padding-top: 10px;">
						<div style="display: inline-block; width: 300px;">
							<strong>Phone :</strong>
						</div>
						<div style="display: inline-block;">
							<input type="text" name="phone" style="width: 300px;font-size: 16px; color: red;" value="${Session.user.phone?if_exists}"/>
						</div>
					</div>
					<div style="padding-top: 10px;">
						<div style="display: inline-block; width: 300px;">
							<strong>Non Filtered Posts Allowed? :</strong>
						</div>
						<div style="display: inline-block;">
							<select name="validationStatus">
								<option value="ALLOW">Yes</option>
								<option value="BAN" <#if Session.user.validationStatus?has_content && Session.user.validationStatus == "BAN">selected</#if>>No</option>
							</select>
						</div>
					</div>					
					<div style=" padding-top: 10px; ">
						<div style="display: inline-block; width: 300px;">
							<strong></strong>
						</div>
						<div style="display: inline-block;">
							<input type="submit" value="Save"/>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<div id="wrapper">
	
	<div id="welcome" class="container">
		<div class="title">
			<h2>Welcome to Filtered Wall</h2>
		</div>
		<p>This is <strong>FilteredWall</strong>. The content filtering expert for social networking</p>
	</div>
</div>
<div id="copyright" class="container">
	
</div>
</body>
</html>
