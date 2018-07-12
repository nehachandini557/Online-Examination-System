<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
<head>
<title>Online Examination Portal</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<style>
@import url(layout.css);
</style>
<script>
	function checkInput(adminId) {
		var invalidChars = /[^0-9]/gi;
		if (invalidChars.test(adminId.value)) {
			alert("please give only numbers");
		}
	}
</script>
</head>
<body>
	<div id="container">
		<div id="header">
			<div align="right">
				<div class="btn-group btn-group-lg">
					<button type="button" class="btn btn-danger dropdown-toggle"
						data-toggle="dropdown">
						Login<span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li>
							<button type="button" class="btn btn-basic" data-toggle="modal"
								data-target="#myModal1">Admin</button>
						</li>
						<li>
							<button type="button" class="btn btn-basic" data-toggle="modal"
								data-target="#myModal3">Faculty</button>
						</li>
						<li>
							<button type="button" class="btn btn-basic" data-toggle="modal"
								data-target="#myModal2">User</button>
						</li>
					</ul>
				</div>
				<!-- Modal 1-->
				<form action="HomeController" onsubmit="return validation()">
					<div class="modal fade" id="myModal1" role="dialog">
						<div class="modal-dialog modal-sm">

							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">Admin LogIn</h4>
								</div>
								<div class="modal-body">
									<input type="text" id="adminId" name="adminId"
										onkeyup="checkInput(this)" placeholder=" Enter AdminID"
										required><br> <br> <input type="password"
										id="password" name="password" placeholder=" Enter Password"
										required>
								</div>
								<div class="modal-footer">
									<input type="submit" class="btn btn-primary" id="adminLogin"
										value="submit" /> <input type="hidden" name="action"
										value="admin_login">
								</div>
							</div>
						</div>
					</div>
				</form>
				<!-- Modal 2-->
				<form action="HomeController" onsubmit="return validation()">
					<div class="modal fade" id="myModal2" role="dialog">
						<div class="modal-dialog modal-sm">

							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">User LogIn</h4>
								</div>
								<div class="modal-body">
									<input type="text" id="userId" name="userId"
										placeholder=" Enter UserID" onkeyup="checkInput(this)"
										required><br> <br> <input type="password"
										id="password" name="password" placeholder=" Enter Password"
										required>
								</div>
								<div class="modal-footer">
									<input type="submit" class="btn btn-primary" id="user_login"
										value="submit" /> <input type="hidden" name="action"
										value="user_login">
								</div>
							</div>
						</div>
					</div>
				</form>
				<!-- Modal 3 -->
				<form action="HomeController" onsubmit="return validation()">
					<div class="modal fade" id="myModal3" role="dialog">
						<div class="modal-dialog modal-sm">

							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">Faculty LogIn</h4>
								</div>
								<div class="modal-body">
									<input type="text" id="facultyId" name="facultyId"
										placeholder=" Enter UserID" onkeyup="checkInput(this)"
										required><br> <br> <input type="password"
										id="password" name="password" placeholder=" Enter Password"
										required>
								</div>
								<div class="modal-footer">
									<input type="submit" class="btn btn-primary" id="faculty_login"
										value="submit" /> <input type="hidden" name="action"
										value="faculty_login">
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
			
		</div>
		<h3>${successMessage}${errorMessage}</h3>
		<div id="main">
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner">
					<div class="item active">
						<img src="ims2(1).jpg" alt="New york" width="auto" height="auto">
					</div>
					<div class="item">
						<img src="sl.jpg" alt="New york" width="auto" height="auto">
					</div>
				</div>

				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</div>
		<div id="footer">
			<br> <br>
			<p>Copyright &copy; Online Examination System</p>
			<br> <br>
		</div>
	</div>

</body>
</html>