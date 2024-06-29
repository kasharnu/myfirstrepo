<%@page import="modelpro.palindrome"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  

<%
String s;
int num=Integer.parseInt(request.getParameter("f1"));
boolean h=palindrome.checkpali(num);
if(h){
	 s="palindrome";
}
else{
	 s="not palindrome";
	
}
%>
<h3>
<%=s %>
</h3>
<h1>

</h1>
</body>
</html>