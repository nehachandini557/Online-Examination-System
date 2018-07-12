<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" contentType="text/html"%>
<head>
<title>Online Examination:Admin/Home Page</title>
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
					<a href="HomeController?action=logout" class="btn btn-danger"
						role="button"> Logout</a>
				</div>
			</div>
			<h3 align="center" style="color:white">Online Examination System</h3>
		</div>
		<h3>${successMessage}${errorMessage}</h3>
		<div id="content">
			<div id="main1"></div>
			<div id="navigation">
				<br>
				<br>
				<br>
				<br> <a href="HomeController?action=faculty"
					class="btn btn-info btn-block" role="button" value="faculty">Create
					Faculty</a><br>
				<br> <a href="HomeController?action=user"
					class="btn btn-info btn-block" role="button" value="CreateUsers">Create
					Users</a><br>
				<br>
			</div>
		</div>
		<div id="footer">
			<br>
			<p>Copyright &copy; Online Examination System</p>
			<br> <br>
		</div>
	</div>
</body>
</html>