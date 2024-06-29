<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>HELLO VSB</h1>

<%

int num1=Integer.parseInt(request.getParameter("username"));
int num2=Integer.parseInt(request.getParameter("f2"));
%>
<%!
public static int calculate(int num1,int num2){
	
	
	int result=num1+num2;
	return result;
}
%>
<h1> result is 
<%=calculate(num1,num2) %>

</h1>
</body>
</html>