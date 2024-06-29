<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>simple calculator</h1>
<%
int i=Integer.parseInt(request.getParameter("num1"));
int j=Integer.parseInt(request.getParameter("num2"));
%>


<%
int c=i+j;
out.print(c);
%>


<%=c
%>



<%!
public boolean say(){
	return true;
}
%>
<br>
<a herf="http://www.google.com">click me</a>




</body>
</html>