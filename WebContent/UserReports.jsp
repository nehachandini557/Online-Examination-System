<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.svecw.oes.dao.*"%>
<%@ page import="com.svecw.oes.dto.*"%>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<head>
<title>Online Examination:User Home Page</title>
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
		
		<div id="content">
			<div id="main3">
				<form action="TestController">
					<table class="table table-bordered">
						<tr class="info">
							<th>Test Name</th>
							<th>Score</th>
						</tr>
						<c:if test="${fn:length(sessionScope.results) eq 0}" >
							<c:out value="No Test Report for you" />
						</c:if>
						<c:forEach var="score" items="${sessionScope.results}">
							<tr class="danger">
								<td>${score.getKey()}</td>
								<td>${score.getValue()}</td>
							</tr>
						</c:forEach>
					</table>
				</form>
				<input type="hidden" name="action" value="view_reports">
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