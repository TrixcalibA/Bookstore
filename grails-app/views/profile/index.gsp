<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="main" />
<title>Profile</title>
<g:javascript src="profile.js" />
<style>
#profile-table{
	display:table; 
	width:100%
}

</style>
<script>
	var userId = ${userId};
</script>
</head>
<body>
	<div class="home" style="padding-top: 15px">
		<div class="loading" data-bind="visible: isProfileLoading()">loading...</div>
		<div class="widget box" data-bind="visible: !isProfileLoading()">
			 <div class="widget-header">
			 	<h4><i class="icon-reorder"></i>User Profile</h4>
			 	<div class="toolbar no-padding"> <div class="btn-group"> <span class="btn btn-xs widget-collapse"><i class="icon-angle-down"></i></span> </div> </div>
			 </div>
			 <div class="widget-content">
				<div id="profile-table" data-bind="visible: mode()=='view'">
		    		<div class="col-md-12" style="border-bottom: solid 1px #ddd; margin-bottom: 10px;">
						<label class="col-md-2 control-label">Name</label>
						<div class="col-md-10"><span data-bind="text: firstName()+' '+lastName()"></span></div>
					</div>
					<div class="col-md-12" style="border-bottom: solid 1px #ddd; margin-bottom: 10px;">
						<label class="col-md-2 control-label">Email</label>
						<div class="col-md-10"><span data-bind="text: username()"></span></div>
					</div>
					<div class="col-md-12" style="border-bottom: solid 1px #ddd; margin-bottom: 10px;">
						<label class="col-md-2 control-label">Major</label>
						<div class="col-md-10"><span data-bind="text: major()"></span></div>
					</div>
					<div class="col-md-12" style="border-bottom: solid 1px #ddd; margin-bottom: 10px;">
						<label class="col-md-2 control-label">Degree</label>
						<div class="col-md-10"><span data-bind="text: degree()"></span></div>
					</div>
					<div class="col-md-12" style="margin-bottom:10px;">
						<label class="col-md-2 control-label">Year of Graduation</label>
						<div class="col-md-10"><span data-bind="text: yearOfGraduation()"></span></div>
					</div>
					<g:if test="${loginId==userId}">
						<div class="col-md-12" style="text-align:center">
				 			<button class="btn btn-sm btn-primary" data-bind="click:edit">Edit</button>
						</div>
					</g:if>
				</div>
				<form id="edit-profile-form" data-bind="visible: mode()=='edit'" class="row">
		    		<div class="form-group col-md-12">
						<label class="col-md-2 control-label">First Name</label>
						<div class="col-md-10"><input type="text" class="form-control" name="firstName" data-bind="value: _firstName"></div>
					</div>
					<div class="form-group col-md-12">
						<label class="col-md-2 control-label">Last Name</label>
						<div class="col-md-10"><input type="text" class="form-control" name="lastName" data-bind="value: _lastName"></div>
					</div>
					<div class="form-group col-md-12">
						<label class="col-md-2 control-label">Major</label>
						<div class="col-md-10"><input type="text" class="form-control" name="major" data-bind="value: _major"></div>
					</div>
					<div class="form-group col-md-12">
						<label class="col-md-2 control-label">Degree</label>
						<div class="col-md-10"><input type="text" class="form-control" name="degree" data-bind="value: _degree"></div>
					</div>
					<div class="form-group col-md-12">
						<label class="col-md-2 control-label">Year of Graduation</label>
						<div class="col-md-10"><input type="text" class="form-control" name="yearOfGraduation" data-bind="value: _yearOfGraduation"></div>
					</div>
					<div class="col-md-12" style="text-align:center">
			 			<button class="btn btn-sm" data-bind="click:cancel">Cancel</button>
			 			<button class="btn btn-sm btn-primary" data-bind="click:save">Save Changes</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>