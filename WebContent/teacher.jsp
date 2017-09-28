<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="teacherSearch" method="post">
		<table>
			<tr>
				<td>Student ID:</td>
				<td><input type="number" name="studentid"></td>
			</tr>

			<tr>
				<td><input type="submit" value="submit"></td>
				<td><a href="welcome.html"><input type="button"
						value="back"></input></a></td>
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
<%
	ArrayList<String> info1 = (ArrayList<String>) request.getAttribute("info1");
	if(info1 != null){
		Iterator<String> iter = info1.iterator();
		while(iter.hasNext()){
%>
			<h2><%= iter.next() %></h2>
<%
		}
	}
%>

	<form action="teacher" method="post">
		<table>
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

				<td><a href="welcome.html"><input type="button"
						value="back"></input></a></td>

			</tr>
		</table>
	</form>
	
	<form action="showAllStudent" method="post">
		<table>
			<tr>
				<td><input type="submit" value="Show All Students"></td>
			</tr>
		</table>
	</form>
	<%
		ArrayList<String> info2 = (ArrayList<String>) request.getAttribute("info2");
		if (info2 != null) {
	%>
	<h3><%="" + '\t' + "ID" + '\t' + "Name" + '\t' + "homework" + '\t' + "midterm" + '\t' + "finalExam"%></h3>
	<%
		Iterator<String> iter = info2.iterator();
			while (iter.hasNext()) {
	%>
	<h3><%=iter.next()%></h3>
	<%
		}
		}
	%>

</body>
</html>