<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.svecw.oes.dao.*"%>
<%@ page import="com.svecw.oes.dto.*"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Online Examination:Admin/View Tests</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
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
			<div id="main1">
				<form action="HomeController">
					<table class="table table-bordered">
						<tr class="info">
							<th>TestId</th>
							<th>TestName</th>
							<th>StartTime</th>
							<th>EndTime</th>
							<th>Duration</th>
							<th></th>
						</tr>
						<c:forEach var="test" items="${sessionScope.tests}">
							<tr class="danger">
								<td>${test.getTestId()}</td>
								<td>${test.getName()}</td>
								<td>${test.getStartDate()}</td>
								<td>${test.getEndDate()}</td>
								<td>${test.getDuration()}</td>
								<td><button type="submit" name="submit" id="report" class="btn btn-info"
										value="${test.getTestId()}">report</button></td>
							</tr>
						</c:forEach>
					</table>
					<input type="hidden" name="action" value="report">
				</form>
			</div>
			<div id="navigation">
				<a href="HomeController?action=create_test" class="btn btn-info btn-block"
					role="button" value="CreateTest">Create Test</a><br> <br>
				<a href="HomeController?action=view" class="btn btn-info btn-block"
					role="button" value="ViewTests">View Tests</a><br> <br> <a
					href="HomeController?action=enroll" class="btn btn-info btn-block"
					role="button" value="EnrollUsers">Enroll Users</a><br> <br>
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