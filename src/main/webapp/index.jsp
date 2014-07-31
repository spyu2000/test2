<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
System.out.println(basePath);
String message1=request.getParameter("message");
System.out.println(message1);
%>
<html>
	<head>
		<meta charset="utf-8">
		<%@ include file="common.jsp" %>
		<title>Welcome</title>
	</head> 
	
	<script type="text/javascript">
		
		
		$(document).ready(function() {
			$("#postButton").click(function() {
				login();
			});
			$("#getButton").click(function() {
				profile();
			});			
		});
		function profile() {
			var url = 'http://localhost:9093/test2/home/hello5/';
			var query = $('#id').val() + '/' + $('#name').val() + '/'
					+ $('#status').val();
			url += query;
			alert(url);
			$.get(url, function(data) {
				alert("id: " + data.id + "\nname: " + data.name + "\nstatus: "
						+ data.status);
			});
		}
		function login() {
			var mydata = '{"roleName":"' + $('#roleName').val() + '","roleId":"'
					+ $('#roleId').val()+'"}';
			alert(mydata);
			$.ajax({
				type : 'POST',
				contentType : 'application/json',
				url : 'http://localhost:9093/test2/home/hello4',
				processData : false,
				dataType : 'json',
				data : mydata,
				success : function(data) {
					alert("id: " + data.success);
				},
				error : function() {
					alert('Err...');
				}
			});

		}
	</script>
	<body>
		<c:url value="/showMessage.html" var="messageUrl" />
		<a href="${messageUrl}">Click to enter</a>
		<form id="userForm" action="home/hello4" method="post">
			<input type="text" id="roleId" value=""></input>
			<input type="text" id="roleName" value=""></input>
			<input type="button" id="postButton" value="Json提交"></input>
		</form>
		
		<form id="userForm1" action="home/hello5" method="get">
			<input type="text" id="id" value=""></input>
			<input type="text" id="name" value=""></input>
			<input type="text" id="status" value=""></input>
			<input type="button" id="getButton" value="Restful提交"></input>
		</form>
		
		<form id="userForm2" action="home/hello6" method="post">
			<input type="text" name="roleId" value=""></input>
			<input type="text" name="roleName" value=""></input>
			<input type="submit" id="test" value="提交"></input>
		</form>
	</body>
</html>
