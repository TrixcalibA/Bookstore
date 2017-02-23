<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" />
	<title>Bookstore Login</title>

	<!--=== CSS ===-->
	<link rel="shortcut icon" href="/images/favicon.png" sizes="16x16">

	<!-- Bootstrap -->
	<link href="/template/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

	<!-- Theme -->
	<link href="/template/assets/css/main.css" rel="stylesheet" type="text/css" />
	<link href="/template/assets/css/plugins.css" rel="stylesheet" type="text/css" />
	<link href="/template/assets/css/responsive.css" rel="stylesheet" type="text/css" />
	<link href="/template/assets/css/icons.css" rel="stylesheet" type="text/css" />

	<!-- Login -->
	<link href="/template/assets/css/login.css" rel="stylesheet" type="text/css" />

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

	<script type="text/javascript" src="/template/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/template/assets/js/libs/lodash.compat.min.js"></script>

	<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
		<script src="/template/assets/js/libs/html5shiv.js"></script>
	<![endif]-->

	<!-- Beautiful Checkboxes -->
	<script type="text/javascript" src="/template/plugins/uniform/jquery.uniform.min.js"></script>

	<!-- Form Validation -->
	<script type="text/javascript" src="/template/plugins/validation/jquery.validate.min.js"></script>

	<!-- Slim Progress Bars -->
	<script type="text/javascript" src="/template/plugins/nprogress/nprogress.js"></script>

	<!-- DataTables -->
	<script type="text/javascript" src="/template/plugins/datatables/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="/template/plugins/datatables/plugins/pagination/ellipses.js"></script>
	<script type="text/javascript" src="/template/plugins/datatables/plugins/api/fnReloadAjax.js"></script>
	
	<!-- Noty -->
	<script type="text/javascript" src="/template/plugins/noty/jquery.noty.js"></script>
	<script type="text/javascript" src="/template/plugins/noty/layouts/top.js"></script>
	<script type="text/javascript" src="/template/plugins/noty/themes/default.js"></script>

	<!-- App -->
	<script type="text/javascript" src="/template/assets/js/login.js"></script>
	
	<g:javascript src="application.js" />
	<script>
	$(document).ready(function(){
		"use strict";

		Login.init(); // Init login JavaScript
		
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
</head>

<body class="login">
	<!-- Logo -->
	<div class="logo">
		<img src="/template/assets/img/logo.png" alt="logo" />
		<strong>ME</strong>LON
	</div>
	<!-- /Logo -->

	<!-- Login Box -->
	<div class="box">
		<div class="content">
			<!-- Login Formular -->
			<form class="form-vertical login-form" action="/login/login" method="post">
				<!-- Title -->
				<h3 class="form-title">Sign In to your Account</h3>

				<!-- Error Message -->
				<div class="alert fade in alert-danger" style="display: none;">
					<i class="icon-remove close" data-dismiss="alert"></i>
					Enter any username and password.
				</div>

				<!-- Input Fields -->
				<div class="form-group">
					<!--<label for="username">Username:</label>-->
					<div class="input-icon">
						<i class="icon-user"></i>
						<input type="text" name="username" class="form-control" placeholder="Username" autofocus="autofocus" data-rule-required="true" data-rule-email="true" data-msg-required="Please enter your username." />
					</div>
				</div>
				<div class="form-group">
					<!--<label for="password">Password:</label>-->
					<div class="input-icon">
						<i class="icon-lock"></i>
						<input type="password" name="password" class="form-control" placeholder="Password" data-rule-required="true" data-msg-required="Please enter your password." />
					</div>
				</div>
				<!-- /Input Fields -->

				<!-- Form Actions -->
				<div class="form-actions">
					<label class="checkbox pull-left"><input type="checkbox" class="uniform" name="remember"> Remember me</label>
					<button type="submit" class="submit btn btn-primary pull-right">
						Sign In <i class="icon-angle-right"></i>
					</button>
				</div>
			</form>
			<!-- /Login Formular -->

			<!-- Register Formular (hidden by default) -->
			<form class="form-vertical register-form" action="/login/signup" method="post" style="display: none;">
				<!-- Title -->
				<h3 class="form-title">Sign Up for Free</h3>

				<!-- Input Fields -->
				<div class="form-group">
					<div class="input-icon">
						<i class="icon-user"></i>
						<input type="text" name="username" class="form-control" placeholder="Username" autofocus="autofocus" data-rule-required="true" data-rule-email="true"/>
					</div>
				</div>
				<div class="form-group">
					<div class="input-icon">
						<i class="icon-lock"></i>
						<input type="password" name="password" class="form-control" placeholder="Password" id="register_password" data-rule-required="true" />
					</div>
				</div>
				<div class="form-group">
					<div class="input-icon">
						<i class="icon-ok"></i>
						<input type="password" name="password_confirm" class="form-control" placeholder="Confirm Password" data-rule-required="true" data-rule-equalTo="#register_password" />
					</div>
				</div>
				<div class="form-group">
					<input type="text" name="firstName" class="form-control" placeholder="First Name" autofocus="autofocus" data-rule-required="true" />
				</div>
				<div class="form-group">
					<input type="text" name="lastName" class="form-control" placeholder="Last Name" autofocus="autofocus" data-rule-required="true" />
				</div>
				<div class="form-group">
					<select name="gender" class="form-control" autofocus="autofocus" data-rule-required="true">
						<option value="">-- Gender --</option>
						<option value="male">Male</option>
						<option value="female">Female</option>
					</select>
				</div>
				<div class="form-group">
					<div class="input-icon">
						<i class="glyphicon glyphicon-briefcase"></i>
		                <input class="form-control" type="text" name="major" placeholder="Major">
					</div>
				</div>
				<div class="form-group">
					<div class="input-icon">
						<i class="glyphicon glyphicon-briefcase"></i>
		                <input class="form-control" type="text" name="degree" placeholder="Degree">
					</div>
				</div>
				<div class="form-group">
					<div class="input-icon">
						<i class="glyphicon glyphicon-calendar"></i>
		                <input class="form-control" type="text" name="yearOfGraduation" data-rule-number="true" placeholder="Graduation Year">
					</div>
				</div>
				<div class="form-group spacing-top">
					<label class="checkbox"><input type="checkbox" class="uniform" name="tos" data-rule-required="true" data-msg-required="Please accept ToS first."> I agree to the <a href="javascript:void(0);">Terms of Service</a></label>
					<label for="tos" class="has-error help-block" generated="true" style="display:none;"></label>
				</div>
				<!-- /Input Fields -->

				<!-- Form Actions -->
				<div class="form-actions">
					<button type="button" class="back btn btn-default pull-left">
						<i class="icon-angle-left"></i> Back</i>
					</button>
					<button type="submit" class="submit btn btn-primary pull-right">
						Sign Up <i class="icon-angle-right"></i>
					</button>
				</div>
			</form>
			<!-- /Register Formular -->
		</div> <!-- /.content -->

		<!-- Forgot Password Form -->
		<div class="inner-box">
			<div class="content">
				<!-- Close Button -->
				<i class="icon-remove close hide-default"></i>

				<!-- Link as Toggle Button -->
				<a href="#" class="forgot-password-link">Forgot Password?</a>

				<!-- Forgot Password Formular -->
				<form class="form-vertical forgot-password-form hide-default" action="login.html" method="post">
					<!-- Input Fields -->
					<div class="form-group">
						<!--<label for="email">Email:</label>-->
						<div class="input-icon">
							<i class="icon-envelope"></i>
							<input type="text" name="email" class="form-control" placeholder="Enter email address" data-rule-required="true" data-rule-email="true" data-msg-required="Please enter your email." />
						</div>
					</div>
					<!-- /Input Fields -->

					<button type="submit" class="submit btn btn-default btn-block">
						Reset your Password
					</button>
				</form>
				<!-- /Forgot Password Formular -->

				<!-- Shows up if reset-button was clicked -->
				<div class="forgot-password-done hide-default">
					<i class="icon-ok success-icon"></i> <!-- Error-Alternative: <i class="icon-remove danger-icon"></i> -->
					<span>Great. We have sent you an email.</span>
				</div>
			</div> <!-- /.content -->
		</div>
		<!-- /Forgot Password Form -->
	</div>
	<!-- /Login Box -->
	<!-- Footer -->
	<div class="footer">
		<a href="#" class="sign-up">Don't have an account yet? <strong>Sign Up</strong></a>
	</div>
	<!-- /Footer -->
</body>
</html>