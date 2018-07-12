<%@ page language="java" contentType="text/html"%>
<%@ page import="com.svecw.oes.dao.*"%>
<%@ page import="com.svecw.oes.dto.*"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Online Examination:Admin/Enroll Users</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href=bootstrap-3.3.7-dist/css/bootstrap.min.css>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script>
	$(".dropdown-menu li a").click(
			function() {
				var selText = $(this).text();
				$(this).parents('.btn-group').find('.dropdown-toggle').html(
						selText + ' <span class="caret"></span>');
			});
	$(function() {
		//button select all or cancel
		$("#select-all").click(function() {
			var all = $("input.select-all")[0];
			all.checked = !all.checked
			var checked = all.checked;
			$("input.select-item").each(function(index, item) {
				item.checked = checked;
			});
		});
		//button select invert
		$("#select-invert").click(function() {
			$("input.select-item").each(function(index, item) {
				item.checked = !item.checked;
			});
			checkSelected();
		});
		//button get selected info
		$("#selected").click(function() {
			var items = [];
			$("input.select-item:checked:checked").each(function(index, item) {
				items[index] = item.value;
			});
			if (items.length < 1) {
				alert("no selected items!!!");
			} else {
				var values = items.join(',');
				console.log(values);
				var html = $("<div></div>");
				html.html("selected:" + values);
				html.appendTo("body");
			}
		});
		//column checkbox select all or cancel
		$("input.select-all").click(function() {
			var checked = this.checked;
			$("input.select-item").each(function(index, item) {
				item.checked = checked;
			});
		});
		//check selected items
		$("input.select-item").click(function() {
			var checked = this.checked;
			console.log(checked);
			checkSelected();
		});
		//check is all selected
		function checkSelected() {
			var all = $("input.select-all")[0];
			var total = $("input.select-item").length;
			var len = $("input.select-item:checked:checked").length;
			console.log("total:" + total);
			console.log("len:" + len);
			all.checked = len === total;
		}
	});
</script>


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
			<h3 align="center" style="color:white">Online Examination System</h3>
		</div>
		<h3>${successMessage}${errorMessage}</h3>
		<div id="content">
		
			<div id="main1">
				<p style="color: red" align="left"></p>
				<form action="HomeController">
					
					<div class="dropdown">
						<select id="tests" name="tests" class="btn btn-info">
							<option value="">Test</option>
							<c:forEach var="test" items="${sessionScope.tests}">
								<option value="${test.getTestId()}">${test.getName()}</option>
							</c:forEach>
						</select> <br> <br>
					</div>
					<div>
						<table class="table table-bordered">
							<thead>
								<tr class="info">
									<th></th>
									<th>UserID</th>
									<th>User Name</th>
									<th>Phone Number</th>
									<th>Email ID</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="user" items="${sessionScope.users}">
									<tr class="danger">
										<td><input type="checkbox" name="users" id="users"
											value="${user.getUserId()}" /></td>
										<td>${user.getUserId()}</td>
										<td>${user.getName()}</td>
										<td>${user.getPhoneNumber()}</td>
										<td>${user.getEmailId()}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<input type="submit" name="submit" id="submit" value="enroll"
						class="btn btn-info" /><br> <input type="hidden"
						name="action" value="showenroll">
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
			<P>Copyright &copy; Online Examination System</P>
			<br> <br>
		</div>
	</div>
</body>
</html>