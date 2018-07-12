<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Online Examination:Admin/Create Users</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<style>
@import url(layout.css);
</style>
</head>
<body>
	<div id="container">
		<div id="header">
			<div class="pull-right">
				<div class="btn">
					<form action="HomeController">
						<a href="HomeController?action=logout" class="btn btn-danger"
							role="button"> Logout</a>
					</form>
				</div>
				<h3 align="center" style="color:white">Online Examination System</h3>
			</div>
		</div>
		<p>${successMessage}${errorMessage}</p>
		<div id="content">
			<div id="main1">
				<form action="TestController" enctype="multipart/form-data"
					method="post">
					<b><p>Name :</p></b><input type="text" name="name"
						placeholder="Enter Name" required /><br> <br> <b><p>Start
							Date :</p></b> <input type="date" name="startDate"
						placeholder="Enter Start Date" required /><br> <br> <b><p>End
							Date :</p></b> <input type="date" name="endDate"
						placeholder="Enter End Date" required /> <b><p>Duration :</p></b>
					<input type="number" name="duration" placeholder="Enter Duration"
						required /><br> <br> <input type="file" name="file"
						align="middle" required />
					<button type="submit" class="btn btn-primary" value="UserSubmit"
						data-dismiss="modal">Submit</button>
				</form>
			</div>
			<div id="navigation">
				<a href="HomeController?action=create_test" class="btn btn-info btn-block"
					role="button" value="CreateTest">Create Test</a><br> <br>
				<a href="HomeController?action=view" class="btn btn-info btn-block"
					role="button" value="ViewTests">View Tests</a><br> <br> <a
					href="HomeController?action=enroll" class="btn btn-info btn-block"
					role="button" value="EnrollUsers">Enroll Users</a><br> <br>
				</div></div>
		<div id="footer">
			<br> <br>
			<P>Copyright &copy; Online Examination System</P>
			<br> <br>
		</div>
	</div>
</body>
</html>