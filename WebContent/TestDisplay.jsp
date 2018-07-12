<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Online Examination:User Home Page</title>
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
</div>
</div>
</div>
<div id="content">
<form action="TestController" method="post">
<div id="main2">
<br><br>
<i><b>${current_qno})
<c:if test="${questionsList[current_qno-1].getDescription().isImage()}">
<img alt=""	src="${questionsList[current_qno-1].getDescription().getText()}">
</c:if>
<c:if test="${ ! questionsList[current_qno-1].getDescription().isImage()}">
${questionsList[current_qno-1].getDescription().getText()}</b></i><br>
<b2>
</c:if>
<c:if test="${questionsList[current_qno-1].isMultiAnswered()}">
<c:set var="i" value="${0}" />
<c:set var="str" value="${map.get(current_qno.toString())}"></c:set>
<c:set var="optarr" value="${str.toCharArray()}" />
<c:forEach items="${questionsList[current_qno-1].getOptions()}" var="option" begin="0"><br>
<c:if test="${ questionsList[current_qno-1].getSelectedAnswer() != 0 }">
<c:if test="${optarr[i].toString() eq '1'}">
<input type="checkbox" name="c${current_qno}" value="${i}" checked="checked">
</c:if>
<c:if test="${optarr[i].toString() eq '0'}">
<input type="checkbox" name="c${current_qno}" value="${i}">
</c:if>
</c:if>
<c:if test="${ questionsList[current_qno-1].getSelectedAnswer() == 0 }">
<input type="checkbox" name="c${current_qno}" value="${i}">
</c:if>
<c:if test="${option.isImage()}">
<img alt="" src="${option.getText()}">
</c:if>
<c:if test="${ ! option.isImage()}">
<b1>${option.getText()}</b1>
</c:if>
<c:set var="i" value="${i+1}" />
</c:forEach>
</c:if>
<c:if test="${!questionsList[current_qno-1].isMultiAnswered()}">
<c:set var="i" value="${0}" />
<c:set var="str" value="${map.get(current_qno.toString())}"></c:set>
<c:set var="optarr" value="${str.toCharArray()}" />
<c:forEach items="${questionsList[current_qno-1].getOptions()}" var="option" begin="0"><br>
<c:if test="${ questionsList[current_qno-1].getSelectedAnswer() != 0 }">
<c:if test="${optarr[i].toString() eq '1'}">
<input type="radio" name="r${current_qno}" value="${i}" checked>
</c:if>
<c:if test="${optarr[i].toString() eq '0'}">
<input type="radio" name="r${current_qno}" value="${i}">
</c:if>
</c:if>
<c:if test="${ questionsList[current_qno-1].getSelectedAnswer() == 0 }">
<input type="radio" name="r${current_qno}" value="${i}">
</c:if>
<c:if test="${option.isImage()}">
<img alt="" src="${option.getText()}">
</c:if>
<c:if test="${ ! option.isImage()}">
<b1>${option.getText()}</b1>
</c:if>
<c:set var="i" value="${i+1}" />
</c:forEach>
</b2>
</c:if><br><br>
<c:if test="${current_qno == 1}"> <br>
<input type="submit" name="link" style="background-color:#00cccc;" value="next->"><br><br>
</c:if>
<c:if test="${current_qno != 1 && current_qno != questionsList.size()}"> <br>
<input type="submit" name="link" style="background-color:#00cccc;"  value="<-prev"><br><br>
<input type="submit" name="link" style="background-color:#00cccc;" value="next->"><br><br>
</c:if>
<c:if test="${current_qno == questionsList.size()}"><br>
<input type="submit" name="link" style="background-color:#00cccc;" value="<-prev"><br><br>
<input type="submit" name="link" style="background-color:#00cccc;" value="Finish"><br><br>
</c:if>
</div>
<div id="navigation1"><br><br>
<c:forEach var="i" begin="1" end="${questionsList.size()}">
<input type="submit" style="background-color:#00cccc;" name="link" value="${i}">
</c:forEach><br><br>
</div>
</form>
</div>
<div id="footer">
<br> <br>
<p>Copyright &copy; Online Examination System</p>
<br> <br>
</div>
</div>	
</body>
</html>