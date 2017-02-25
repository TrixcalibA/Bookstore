<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<meta name="layout" content="main" />
	<title>Sell Books</title>
	<script type="text/javascript" src="/js/sell.js"></script>
</head>
<body>
	<g:if test="${isLoggedIn}">
		<div class="home" style="padding-top: 20px">
			<!-- Mangaed Table No Padding -->
			<div class="row">
				<div class="col-md-12">
					<div class="widget box">
						<div class="widget-header">
							<h4><i class="icon-reorder"></i> Your Books </h4>
							<div class="toolbar no-padding">
								<div class="btn-group">
									<span class="btn btn-xs widget-collapse"><i class="icon-angle-down"></i></span>
								</div>
							</div>
						</div>
						<div class="widget-content no-padding">
							<table class="table table-striped table-bordered table-hover table-checkable" id="sellbook_table">
								<thead>
									<tr>
										<th>Title<span class='sorting-icon'></span></th>
										<th>ISBN<span class='sorting-icon'></span></th>
										<th>Major<span class='sorting-icon'></span></th>
										<th>Course<span class='sorting-icon'></span></th>
										<th>Posted<span class='sorting-icon'></span></th>
										<th>Status<span class='sorting-icon'></span></th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<!-- /Mangaed Table No Padding -->
			
			<!-- Sell form -->
			<div class="row">
				<div class="col-md-12">
					<div class="widget box">
						<div class="widget-header">
							<h4><i class="icon-reorder"></i> Sell Your Book</h4>
							<div class="toolbar no-padding">
								<div class="btn-group">
									<span class="btn btn-xs widget-collapse"><i class="icon-angle-down"></i></span>
								</div>
							</div>
						</div>
						<div class="widget-content">
							<form id="sell-form" class="form-horizontal row-border">
								<div class="form-group">
									<label for="bookTitle" class="col-md-2 control-label">Book Title:</label>
									<div class="col-md-10"><input type="text" class="form-control" name="bookTitle" placeholder="Book Title" data-bind="value: title"></div>
								</div>
								<div class="form-group">
									<label for="isbn" class="col-md-2 control-label">ISBN:</label>
									<div class="col-md-10"><input type="text" class="form-control" name="isbn" placeholder="ISBN-13" data-bind="value: isbn"></div>
								</div>
								<div class="form-group">
									<label for="major" class="col-md-2 control-label">Major:</label>
									<div class="col-md-10"><input type="text" class="form-control" name="major" placeholder="Major" data-bind="value: major"></div>
								</div>
								<div class="form-group">
									<label for="course" class="col-md-2 control-label">Course:</label>
									<div class="col-md-10"><input type="text" class="form-control" name="course" placeholder="Course ID" data-bind="value: course"></div>
								</div>
								<div class="form-actions">
									<button class="btn btn-primary pull-right" data-bind="click: sellBook">Sell Book</button>
								</div>
							</form>						
						</div>
					</div>
				</div>
			</div>
			<!-- /Sell Form -->
		</div>		
	</g:if>
	<g:else>
		<div class="row">
			<div class="col-md-12" style="padding-top:20px; text-align:center;">
				<a class="btn btn-primary" href="/login">Please login to sell your book</a>
			</div>
		</div>
	</g:else>
</body>
</html>
