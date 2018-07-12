<%@ page language="java" contentType="text/html"%>
<!DOCTYPE html>
<html lang="en">
<head>
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
			</div>
			<h3 align="center" style="color: white">Online Examination
				System</h3>
		</div>
		<h3>${successMessage}${errorMessage}</h3>
		<div id="content">
			<div id="main1">
				<form action="HomeController" enctype="multipart/form-data" method="post">
					 	<br><h3>User ID : </h3> <input type="text" id="userId" name = "userId"
						placeholder=" Enter UserID" required> <br>
					<br> <h3>User Name : </h3><input type="text" id="name" name = "name"
						placeholder=" Enter UserName" required><br> <br>
					<h3>Password : </h3><input type="password" id="password"  name = "password" placeholder=" Enter Password"
						required><br> <br> <h3>Email : </h3> <input type="email"
						id="email"  name = "emailId" placeholder=" @gmail.com" required><br> <br>
					<h3>Contact No. : </h3><input type="text" id="mobileno" name = "mobileNo"
						placeholder=" Enter Contact Number" required><br> <br>
					<!-- <input type="file" name="file" align="middle" required />--> <input
						type="submit" value="Add" class="btn btn-info" /><input
						type="hidden" name="action" value="user" /> 
				</form>

			</div>
			<div id="navigation">
				<a href="HomeController?action=faculty"
					class="btn btn-info btn-block" role="button" value="faculty">Create
					Faculty</a><br> <br> <a href="HomeController?action=user"
					class="btn btn-info btn-block" role="button" value="CreateUsers">Create
					Users</a><br> <br>
			</div>
		</div>
		<div id="footer">
			<br> <br>
			<P>Copyright &copy; Online Examination System</P>
			<br> <br>
		</div>
	</div>
</body>
</html>