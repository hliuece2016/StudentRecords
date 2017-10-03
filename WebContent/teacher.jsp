<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
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
</head>
<body>
	<jsp:include page="teacherTop.jsp" />
	<div class="middle-div">
		<div class="my-div">
			<div class = "small-div">
				<form action="teacherSearch" method="post">
					<table>
						<tr>
							<td>Student ID:</td>
							<td><input type="text" name="studentid"></td>
						</tr>

						<tr>
							<td><input type="submit" value="submit"></td>
							<td><a href="job.html"><button type="button">log
										out</button></a></td>
						</tr>
					</table>
				</form>
				<%
					String error = (String) request.getAttribute("error");
					if (error != null) {
				%>
				<h3><%=error%></h3>
				<%
					}
				%>
				<%
					ArrayList<String> info1 = (ArrayList<String>) request.getAttribute("info1");
					if (info1 != null) {
						Iterator<String> iter = info1.iterator();
				%>
				<table>
					<%
						while (iter.hasNext()) {
					%>
					<%=iter.next()%>
					<%
						}
						}
					%>
				</table>
			</div>
			<div class = "small-div">
				<form action="teacher" method="post">
					<table>
						<tr>
							<td>Update</td>
						</tr>
						<tr>
							<td>Student ID:</td>
							<td><input type="number" name="studentid2"></td>
						</tr>
						<tr>
							<td>NAME:</td>
							<td><input type="text" name="studentname"></td>
						</tr>
						<tr>
							<td>HOMEWORK:</td>
							<td><input type="number" name="homework"></td>
						</tr>
						<tr>
							<td>MIDTERM:</td>
							<td><input type="number" name="midterm"></td>
						</tr>
						<tr>
							<td>FINALEXAM:</td>
							<td><input type="number" name="finalexam"></td>
						</tr>

						<tr>
							<td><input type="submit" value="add"></td>
						</tr>
					</table>
				</form>
			</div>
			<form action="showAllStudent" method="post">
				<table>
					<tr>
						<td><input type="submit" value="Show All Students"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>