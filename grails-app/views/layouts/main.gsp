<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" />

	<!--=== CSS ===-->
	<link rel="shortcut icon" href="/images/favicon.png" sizes="16x16">
	<!-- Bootstrap -->
	<link href="/template/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

	<!-- jQuery UI -->
	<!--<link href="plugins/jquery-ui/jquery-ui-1.10.2.custom.css" rel="stylesheet" type="text/css" />-->
	<!--[if lt IE 9]>
		<link rel="stylesheet" type="text/css" href="plugins/jquery-ui/jquery.ui.1.10.2.ie.css"/>
	<![endif]-->

	<!-- Theme -->
	<link href="/template/assets/css/main.css" rel="stylesheet" type="text/css" />
	<link href="/template/assets/css/plugins.css" rel="stylesheet" type="text/css" />
	<link href="/template/assets/css/responsive.css" rel="stylesheet" type="text/css" />
	<link href="/template/assets/css/icons.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="/template/plugins/bootstrap-tagsinput/dist/bootstrap-tagsinput.css">
	<link rel="stylesheet" href="/template/assets/css/fontawesome/font-awesome.min.css">
	<!--[if IE 7]>
		<link rel="stylesheet" href="/template/assets/css/fontawesome/font-awesome-ie7.min.css">
	<![endif]-->

	<!--[if IE 8]>
		<link href="/template/assets/css/ie8.css" rel="stylesheet" type="text/css" />
	<![endif]-->
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600,700' rel='stylesheet' type='text/css'>
	<!--=== JavaScript ===-->

	<script type="text/javascript" src="/template/assets/js/libs/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="/template/plugins/jquery-ui/jquery-ui-1.10.2.custom.min.js"></script>

	<script type="text/javascript" src="/template/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/template/assets/js/libs/lodash.compat.min.js"></script>

	<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
		<script src="/template/assets/js/libs/html5shiv.js"></script>
	<![endif]-->

	<!-- Smartphone Touch Events -->
	<script type="text/javascript" src="/template/plugins/touchpunch/jquery.ui.touch-punch.min.js"></script>
	<script type="text/javascript" src="/template/plugins/event.swipe/jquery.event.move.js"></script>
	<script type="text/javascript" src="/template/plugins/event.swipe/jquery.event.swipe.js"></script>

	<!-- General -->
	<script type="text/javascript" src="/template/assets/js/libs/breakpoints.js"></script>
	<script type="text/javascript" src="/template/plugins/respond/respond.min.js"></script> <!-- Polyfill for min/max-width CSS3 Media Queries (only for IE8) -->
	<script type="text/javascript" src="/template/plugins/cookie/jquery.cookie.min.js"></script>
	<script type="text/javascript" src="/template/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script type="text/javascript" src="/template/plugins/slimscroll/jquery.slimscroll.horizontal.min.js"></script>

	<!-- Page specific plugins -->
	<!-- Charts -->
	<!--[if lt IE 9]>
		<script type="text/javascript" src="/template/plugins/flot/excanvas.min.js"></script>
	<![endif]-->
	<script type="text/javascript" src="/template/plugins/sparkline/jquery.sparkline.min.js"></script>
	<script type="text/javascript" src="/template/plugins/flot/jquery.flot.min.js"></script>
	<script type="text/javascript" src="/template/plugins/flot/jquery.flot.tooltip.min.js"></script>
	<script type="text/javascript" src="/template/plugins/flot/jquery.flot.resize.min.js"></script>
	<script type="text/javascript" src="/template/plugins/flot/jquery.flot.time.min.js"></script>
	<script type="text/javascript" src="/template/plugins/flot/jquery.flot.growraf.min.js"></script>
	<script type="text/javascript" src="/template/plugins/easy-pie-chart/jquery.easy-pie-chart.min.js"></script>

	<script type="text/javascript" src="/template/plugins/daterangepicker/moment.min.js"></script>
	<script type="text/javascript" src="/template/plugins/daterangepicker/daterangepicker.js"></script>
	<script type="text/javascript" src="/template/plugins/blockui/jquery.blockUI.min.js"></script>

	<script type="text/javascript" src="/template/plugins/fullcalendar/fullcalendar.min.js"></script>
	
	<!-- DataTables -->
	<script type="text/javascript" src="/template/plugins/datatables/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="/template/plugins/datatables/plugins/pagination/ellipses.js"></script>
	<script type="text/javascript" src="/template/plugins/datatables/plugins/api/fnReloadAjax.js"></script>
	
	<!-- Noty -->
	<script type="text/javascript" src="/template/plugins/noty/jquery.noty.js"></script>
	<script type="text/javascript" src="/template/plugins/noty/layouts/top.js"></script>
	<script type="text/javascript" src="/template/plugins/noty/themes/default.js"></script>

	<!-- Forms -->
	<script type="text/javascript" src="/template/plugins/uniform/jquery.uniform.min.js"></script>
	<script type="text/javascript" src="/template/plugins/select2/select2.min.js"></script>
	<script type="text/javascript" src="/template/plugins/fileinput/fileinput.js"></script>
	<g:javascript src="knockout-3.2.0.js" />

	<!-- Form Validation -->
	<script type="text/javascript" src="/template/plugins/validation/jquery.validate.min.js"></script>
	<script type="text/javascript" src="/template/plugins/validation/additional-methods.min.js"></script>

	<script type="text/javascript" src="/template/plugins/bootstrap-tagsinput/dist/bootstrap-tagsinput.js"></script>
	<script type="text/javascript" src="/template/plugins/bootstrap-tagsinput/examples/bower_components/typeahead.js/dist/typeahead.js"></script>
	<script type="text/javascript" src="/template/plugins/bootstrap-tagsinput/examples/bower_components/typeahead.js/test/vendor/hogan-2.0.0.js"></script>
	<!-- App -->
	<script type="text/javascript" src="/template/assets/js/app.js"></script>
	<script type="text/javascript" src="/template/assets/js/plugins.js"></script>
	<script type="text/javascript" src="/template/assets/js/plugins.form-components.js"></script>
	<script type="text/javascript">var _sf_startpt=(new Date()).getTime()</script>
	<g:javascript src="application.js" />

	<script>
	$(document).ready(function(){
		"use strict";

		App.init(); // Init layout and core plugins
		Plugins.init(); // Init all plugins
		FormComponents.init(); // Init all form-specific plugins

		<g:if test="${success}">
			notyMessage("${success}",'success')
		</g:if>
		<g:if test="${warning}">
			notyMessage("${warning}",'warning')
		</g:if>
		<g:if test="${error}">
			notyMessage("${error}",'error')
		</g:if>
	});
	</script>

	<!-- Demo JS -->
	<script type="text/javascript" src="/template/assets/js/custom.js"></script>
	<title><g:layoutTitle default="CPP Bookstore"/></title>
	<g:layoutHead/>
</head>
<body>
	<!-- Header -->
	<header class="header navbar navbar-fixed-top" role="banner">
		<!-- Top Navigation Bar -->
		<div class="container">
	
			<!-- Only visible on smartphones, menu toggle -->
			<ul class="nav navbar-nav">
				<li class="nav-toggle"><a href="javascript:void(0);" title=""><i class="icon-reorder"></i></a></li>
			</ul>
	
			<!-- Logo -->
			<a class="navbar-brand" href="/">
				<img src="/images/logo.png" style="max-height:27px; max-width:144px; width:auto;" alt="logo">
			</a>
			<!-- /logo -->
	
			<!-- Sidebar Toggler -->
			<a href="#" class="toggle-sidebar bs-tooltip" data-placement="bottom" data-original-title="Toggle navigation">
				<i class="icon-reorder"></i>
			</a>
			<!-- /Sidebar Toggler -->
	
			<!-- Top Right Menu -->
			<ul class="nav navbar-nav navbar-right">
				<!-- User Login Dropdown -->
				<li class="dropdown user">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<i class="icon-male"></i>
						<span class="username">John Doe</span>
						<i class="icon-caret-down small"></i>
					</a>
					<ul class="dropdown-menu">
						<li><a href="/accountSettings"><i class="icon-user"></i> My Profile</a></li>
						<li class="divider"></li>
						<li><a href="/logout"><i class="icon-key"></i> Log Out</a></li>
					</ul>
				</li>
				<!-- /user login dropdown -->
			</ul>
			<!-- /Top Right Menu -->
		</div>
		<!-- /top navigation bar -->
	</header> <!-- /.header -->
	<div id="container">
		<div id="sidebar" class="sidebar-fixed">
			<div id="sidebar-content">
				<!--=== Navigation ===-->
				<ul id="nav">
					<li <g:if test="${page == 'our-books'}">class="current"</g:if>>
						<a href="/">
							<i class="icon-bar-chart"></i>
							Our Books
						</a>
					</li>
					<li <g:if test="${page == 'sell-books'}">class="current"</g:if>>
						<a href="/sellBooks/index">
							<i class="icon-bar-chart"></i>
							Selling Books
						</a>
					</li>
					<li <g:if test="${page == 'about'}">class="current"</g:if>>
						<a href="/about/index">
							<i class="icon-bar-chart"></i>
							About
						</a>
					</li>
				</ul>
			</div>
			<div id="divider" class="resizeable"></div>
		</div>
		<!-- /Sidebar -->
	
		<div id="content">
			<div class="container">
				<g:layoutBody />
			</div>
			<!-- /.container -->
		</div>
	</div>
	<div id="footer">
	</div>
	<div id="spinner" style="display: none;"></div>
</body>
</html>
