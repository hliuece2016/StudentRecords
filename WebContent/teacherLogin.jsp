<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/mystyle.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
	function validateForm() {
		var x = document.forms["myForm"]["username"].value;
		var y = document.forms["myForm"]["password"].value;
		if (x == null || x == "") {
			alert("Input username");
			return false;
		} else {
			if (y == null || y == "") {
				alert("Input password");
				return false;
			}
		}
	}
</script>
</head>
<body>
	<div class="middle-div">
		<div class="my-div">
			<p>For now, there is only one account:teacher(password:teacher).</p>
			<form name="myForm" action="teacherLogin"
				onsubmit="return validateForm()" method="post">
				<table>
					<tr>
						<td>Username:</td>
						<td><input type="text" name="username" /></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="text" name="password" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="login" /></td>
						<td><a href="job.html"><input type="button" value="back"></input></a></td>
					</tr>
				</table>
			</form>
			<%String error = (String) request.getAttribute("error");
			if (error != null) {%>
			<h3><%=error%></h3>
			<%}%>
		</div>
	</div>
</body>
</html>