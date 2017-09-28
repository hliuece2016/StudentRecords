<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="student" method="post">
    <table>
        <tr>
            <td>
                <input type="submit" value="myRecord">
            </td>
            <td>
                <% // <input type="reset" value="back"> %>
				<a href="welcome.html"><input type="button" value = "back"></input></a>
            </td>
        </tr>
    </table>
</form>
<%
	ArrayList<String> info = (ArrayList<String>) request.getAttribute("info");
	if(info != null){
		Iterator<String> iter = info.iterator();
		while(iter.hasNext()){
%>
			<h2><%= iter.next() %></h2>
<%
		}
	}
%>
</body>
</html>