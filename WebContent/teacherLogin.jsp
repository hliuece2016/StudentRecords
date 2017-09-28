<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "teacherLogin" method = "post">
	<table>
		<tr>
			<td>Username:</td>
			<td><input type = "text" name = "username" /></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type = "text" name = "password" /></td>
		</tr>
		<tr>
			<td><input type = "submit" value = "login" /></td>
			<td><a href="welcome.html"><input type="button" value = "back"></input></a></td>
		</tr>
	</table>
</form>
<%
	String error = (String)request.getAttribute("error");
	if(error != null){
%>
		<h3><%= error %></h3>
<%
	}
%>
</body>
</html>