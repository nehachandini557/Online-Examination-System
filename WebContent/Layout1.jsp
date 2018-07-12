<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
@import url(layout.css);
</style>
<script>
	function call() {
		$("#main").load("HomeController/?action=adminLogin");
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
</html>
<div id="Container">
	<div id="header">
		<div class="btn-group">
			<button type="button" class="btn btn-success  dropdown-toggle"
				data-toggle="dropdown">
				login <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<button type="button" class="btn btn-default btn-xs"
					data-toggle="modal" data-target="#myModal1">Admin Login</button>
				<br>
				<button type="button" class="btn btn-default btn-xs"
					data-toggle="modal" data-target="#myModal2">User Login</button>
			</ul>
			<!-- Modal 1-->
			<div class="modal fade" id="myModal1" role="dialog">
				<div class="modal-dialog modal-sm">
					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Admin</h4>
						</div>
						<div class="modal-body">
							<p>
								<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
								<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
@import
url(my.css)
</style>
</head>
<body>
	<form action="HomeServlet">
		<br>
		<center>
			<input type="text" id="admin_id" placeholder="Enter admin ID"
				required></input><br> <br>
		</center>
		<center>
			<input type="password" name="password" id="password"
				placeholder="password" required></input>
		</center>
		<span id="msg"></span> <input type="submit" name="Login" id="submit"></input>
		<br>
	</form>
</body>
								</html>
							</p>
						</div>
					</div>
				</div>
			</div>
			<!-- Modal 2-->
			<div class="modal fade" id="myModal2" role="dialog">
				<div class="modal-dialog modal-sm">
					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">User</h4>
						</div>
						<div class="modal-body">
							<p>
								<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
								<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
@import
url(my.css)
</style>
</head>
<body>
	<form method="post" action="HomeServlet">
		<br>
		<center>
			<input type="text" name="user_id" id="user_id"
				placeholder="Enter User_id" required></input><br> <br>
		</center>
		<center>
			<input type="password" name="password" id="password"
				placeholder="password" required></input>
		</center>
		<span id="msg"></span> <input type="submit" value="userlogin"
			name="action" id="submit"></input> <br>
	</form>
</body>
								</html>
						</div>
					</div>
				</div>
			</div>
			<div id="footer">
				<h3>Copyright &copy; Online Examination System</h3>
			</div>
		</div>
		</body>
		</html>