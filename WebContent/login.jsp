<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/mystyle.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="aa">
		<div class="aaa">
			<form action="studentLogin" method="post">
				<table>
					<tr>
						<td>User Name:</td>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="number" name="password"></td>
					</tr>
					<tr>
						<td><input type="submit" value="login"></td>
						<td><a href="register.html"><input type="button"
								value="register"></input></a></td>
						<td><a href="welcome.html"><input type="button"
								value="back"></input></a></td>
						<td><input type='hidden' id='btnType' name='btnType' /></td>
					</tr>

				</table>
			</form>
			
			<%
				String info = (String) request.getAttribute("info");
				if (info != null) {
			%>
			<h3><%=info%></h3>
			<%
				}
			%>
			<%
				String error = (String) request.getAttribute("error");
				if (error != null) {
			%>
			<h3><%=error%></h3>
			<%
				}
			%>
		</div>
	</div>
</body>
</html>