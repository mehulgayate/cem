<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>AdminLTE | Morris.js Charts</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- bootstrap 3.0.2 -->
        <link href="/static/admin/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="/static/admin/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="/static/admin/css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <!-- Morris charts -->
        <link href="/static/admin/css/morris/morris.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="/static/admin/css/AdminLTE.css" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="skin-blue">
        <!-- header logo: style can be found in header.less -->
        <header class="header">
            <a href="/admin" class="logo">
                <!-- Add the class icon to your logo image or logo icon to add the margining -->
                Admin Home
            </a>
            <!-- Header Navbar: style can be found in header.less -->
            <nav class="navbar navbar-static-top" role="navigation">
                <!-- Sidebar toggle button-->
                <a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <div class="navbar-right">
                    <ul class="nav navbar-nav">
                        <!-- Messages: style can be found in dropdown.less-->
                        <li class="dropdown messages-menu">                            
                            <ul class="dropdown-menu">                                
                                <li>
                                    <!-- inner menu: contains the actual data -->
                                    <ul class="menu">
                                        <li><!-- start message -->
                                            <a href="#">
                                                <div class="pull-left">
                                                    <img src="/static/admin/img/avatar3.png" class="img-circle" alt="User Image"/>
                                                </div>
                                                <h4>
                                                    Support Team
                                                    <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                                </h4>
                                                <p>Why not buy a new awesome theme?</p>
                                            </a>
                                        </li><!-- end message -->
                                        <li>
                                            <a href="#">
                                                <div class="pull-left">
                                                    <img src="/static/admin/img/avatar2.png" class="img-circle" alt="user image"/>
                                                </div>
                                                <h4>
                                                    AdminLTE Design Team
                                                    <small><i class="fa fa-clock-o"></i> 2 hours</small>
                                                </h4>
                                                <p>Why not buy a new awesome theme?</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <div class="pull-left">
                                                    <img src="/static/admin/img/avatar.png" class="img-circle" alt="user image"/>
                                                </div>
                                                <h4>
                                                    Developers
                                                    <small><i class="fa fa-clock-o"></i> Today</small>
                                                </h4>
                                                <p>Why not buy a new awesome theme?</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <div class="pull-left">
                                                    <img src="/static/admin/img/avatar2.png" class="img-circle" alt="user image"/>
                                                </div>
                                                <h4>
                                                    Sales Department
                                                    <small><i class="fa fa-clock-o"></i> Yesterday</small>
                                                </h4>
                                                <p>Why not buy a new awesome theme?</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <div class="pull-left">
                                                    <img src="/static/admin/img/avatar.png" class="img-circle" alt="user image"/>
                                                </div>
                                                <h4>
                                                    Reviewers
                                                    <small><i class="fa fa-clock-o"></i> 2 days</small>
                                                </h4>
                                                <p>Why not buy a new awesome theme?</p>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="footer"><a href="#">See All Messages</a></li>
                            </ul>
                        </li>
                       
                        <!-- User Account: style can be found in dropdown.less -->
                        <li class="dropdown user user-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="glyphicon glyphicon-user"></i>
                                <span>Admin <i class="caret"></i></span>
                            </a>
                            <ul class="dropdown-menu">
                                <!-- User image -->
                                <li class="user-header bg-light-blue">
                                    <img src="/static/admin/img/avatar3.png" class="img-circle" alt="User Image" />
                                    <p>
                                        Admin- Admin User                                        
                                    </p>
                                </li>
                                <!-- Menu Body -->
                                <li class="user-body">
                                    
                                </li>
                                <!-- Menu Footer-->
                                <li class="user-footer">                                   
                                    <div class="pull-right">
                                        <a href="/admin/logout" class="btn btn-default btn-flat">Sign out</a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="left-side sidebar-offcanvas">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="/static/admin/img/avatar3.png" class="img-circle" alt="User Image" />
                        </div>
                        <div class="pull-left info">
                            <p>Hello, Admin</p>

                            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                        </div>
                    </div>
                    
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu">
                        <li class="active">
                            <a href="/admin">
                                <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                            </a>
                        </li>                       
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-bar-chart-o"></i>
                                <span>Charts</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="/admin/grapth-data-words"><i class="fa fa-angle-double-right"></i>Filter Words</a></li>
                                <li><a href="/admin/grapth-data-black-list"><i class="fa fa-angle-double-right"></i>Blacklist</a></li>                                
                            </ul>
                        </li>                                               
                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>

            <!-- Right side column. Contains the navbar and content of the page -->
            <aside class="right-side">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Day vs Posts Blocked
                        <small>Preview</small>
                    </h1>                   
                </section>

                <!-- Main content -->
                <section class="content">

                    <div class="row">
                        <div class="col-md-6" style="width: 1000px;">
                        	
                            <!-- LINE CHART -->
                            <div class="box box-info">
                                <div class="box-header">
                                    <h3 class="box-title">Line Chart</h3>
                                </div>
                                <div class="box-body chart-responsive">
                                    <div class="chart" id="chart_div"></div>
                                </div><!-- /.box-body -->
                            </div><!-- /.box -->                         
                            
                        </div><!-- /.col (LEFT) -->                        
                    </div><!-- /.row -->

                </section><!-- /.content -->
            </aside><!-- /.right-side -->
        </div><!-- ./wrapper -->


        <!-- jQuery 2.0.2 -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="/static/admin/js/bootstrap.min.js" type="text/javascript"></script>

        <!-- Morris.js charts -->
        <script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
        <script src="/static/admin/js/plugins/morris/morris.min.js" type="text/javascript"></script>

        <!-- AdminLTE App -->
        <script src="/static/admin/js/AdminLTE/app.js" type="text/javascript"></script>
        <script type="text/javascript" src="https://www.google.com/jsapi"></script>

        <!-- page script -->
        <script type="text/javascript">
        google.load("visualization", "1", {packages:["corechart"]});
        
        var dataArray=[];
        
        $(function() {
        	
        	var dataArray=[];
     		var headerArray=[];
     		headerArray.push("Day");
     		headerArray.push("Posts Blocked");     		
     		dataArray.push(headerArray);	
        	
        	
        	
        	$.ajax({		
     			type : "GET",
     			url : "/admin/grapth-data-black-list.json",         			
     			dataType:"json",
     			success : function(data) {    				 
    				
     				
     				$.each(data,function(key,value){
     					var innerArray=[];    	
     					innerArray.push(value.time);    					
     					innerArray.push(parseInt(value.count));
     					
     					dataArray.push(innerArray);
     				});     				
     				var data = google.visualization.arrayToDataTable(dataArray);
     	        	
     	        	var options = {
     			    			'width':900,'height':500,'vAxis': {'title': 'Posts Blocked'},hAxis: {
     			    		        slantedText:true,
     			    		        slantedTextAngle:90,// here you can even use 180
     			    		        'title': 'Day'
     			    		    },title: "Posts Blocked Analysis"
     			    	};
     	        	
     	        	var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
     			        chart.draw(data, options);
     				
     			}
        	
        	
        	
        	});
        });       
            
        </script>

    </body>
</html>