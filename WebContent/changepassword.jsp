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
		var x = document.forms["myForm"]["newpass"].value;
		var y = document.forms["myForm"]["confirm"].value;
		if (x == null || x == "") {
			alert("Input new password");
			return false;
		} else {
			if (x != y) {
				alert("Confirm password is wrong");
				return false;
			}
		}

	}
</script>
</head>
<body>
	<div class="middle-div">
		<div class="my-div">

			<form name="myForm" action="changePassword"
				onsubmit="return validateForm()" method="post">
				<table>
					<tr>
						<td>Change Password</td>
					</tr>
					<tr>
						<td>New password:</td>
						<td><input type="text" name="newpass"></td>
					</tr>
					<tr>
						<td>Confirm:</td>
						<td><input type="text" name="confirm"></td>
					</tr>
					<tr>
						<td><input type="submit" value="submit"></td>
						<td><a href="student.jsp"><button type = "button">back</button></a></td>
				</table>
			</form>
			<%
				String changeinfo = (String) request.getAttribute("changeinfo");
				if (changeinfo != null) {
			%>
			<h3><%=changeinfo%></h3>
			<%
				}
			%>

		</div>
	</div>
</body>
</html>