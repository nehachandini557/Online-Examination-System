<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" contentType="text/html"%>
<head>
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
			<h3 align="center" style="color: white">Online ExaminationSystem</h3>
		</div>
		<h3>${successMessage}${errorMessage}</h3>
		<div id="content">
			<div id="main3">
				<form action="TestController">
					<input type="hidden" name="action" value="take_test">
					<table class="table table-bordered">
						<tr class="info">
							<th>Test Name</th>
							<th>Take Test</th>
						</tr>
						<c:forEach var="tet" items="${sessionScope.tes}">
							<tr class="danger">
								<td>${tet.getName()}</td>
								<td>
									<button type="submit" name="testId" id="report"
										value="${tet.getTestId()}" class="btn btn-info">Take
										Test</button>
								</td>
							</tr>
						</c:forEach>
					</table>
				</form>
			</div>
			<div id="navigation">
				<a href="TestController?action=view_tests"
					class="btn btn-info btn-block" role="button" value="view_tests">View
					Tests</a><br> <br> <a
					href="TestController?action=view_reports"
					class="btn btn-info btn-block" role="button" value="view_reports">View
					Reports</a><br> <br>
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