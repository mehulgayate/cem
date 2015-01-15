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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<script type="text/javascript"">
	$(function() {
		$('#fileAttachment').bind('change', function() {

			  //this.files[0].size gets the size of your file.
			  if(this.files[0].size > 5000000){
				  alert("File size is more than % MB, please select another file")
			  }

			});
		
		$("#postButton").click(function(){
			if(document.getElementById('fileAttachment').files[0].size > 5000000){
				  alert("File size is more than % MB, please select another file")
			  }else{
				  $("#postForm").submit();
			  }
		})
		});

</script>
</head>
<body>
<div id="header-wrapper">
	<div id="header" class="container">		
		<div id="logo">
			<h1><a href="#">C Q Analyzer</a></h1>
		</div>		
		<div id="menu">
			<ul>
				<li class="active"><a href="#" accesskey="1" title="">Post Question</a></li>
				<li><a href="/questions" accesskey="1" title="">View Questions </a></li>
				<li><a href="/search" accesskey="1" title="">Search Product </a></li>
				<li><a href="/logout" accesskey="1" title="">Logout </a></li>				
				
			</ul>
		</div>
	</div>
	<div id="banner" class="container">
		<div style="color: white;">Welcome ${Session.user.name}</div>
		<div>
			<form action="/new-question" method="post" enctype="multipart/form-data" id="postForm">
				<div style="display:block; width: 500px; background: white; margin: 0 auto; padding: 30px; opacity: 0.6;">
					<div style="display: block;">
						<div style="display: inline-block; width: 120px;">
							<strong>Write Question :</strong>
						</div>
						<div style="display: inline-block;">
							<textarea rows="10" cols="35" name="question" style="color: red; font-size: 16px;"></textarea>
						</div>
					</div>
					
					<div style=" padding-top: 10px; ">
						<div style="display: inline-block; width: 120px;">
							<strong></strong>
						</div>
						<div style="display: inline-block;">
							<input type="submit" value="Post"/>
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
			<h2>Welcome to Comparative Questions Analyzer</h2>
		</div>
		<p>This is <strong>Comparative Questions Analyzer</strong>. The Comparative Questions Analyzer expert for all networking</p>
	</div>
</div>
<div id="copyright" class="container">
	
</div>
</body>
</html>
