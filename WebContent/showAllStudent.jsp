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
			<%
				ArrayList<String> info = (ArrayList<String>) request.getAttribute("info");
				if (info != null) {
			%>
			<table>
				<tr>
					<td>---ID---</td>
					<td>NAME---</td>
					<td>HOMEWORK---</td>
					<td>MIDTERM---</td>
					<td>FINAL---</td>
				</tr>
				<%
					Iterator<String> iter = info.iterator();
						while (iter.hasNext()) {
				%>
				<%=iter.next()%>
				<%
					}
					}
				%>
			</table>
			<a href="teacher.jsp"><input type="button" value="back"></input></a>
		</div>
	</div>
</body>
</html>