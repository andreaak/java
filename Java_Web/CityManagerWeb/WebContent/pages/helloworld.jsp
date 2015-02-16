<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello World</title>
</head>
<body>
<h1>Hello World from JSP</h1>


<% %>
</body>
</html>
<%!
public ArrayList<Integer> Tst()
{
	ArrayList<Integer> lst = new ArrayList<Integer>();
	for(int i = 0; i < 10; i++)
	{
		lst.add(i);
	}	
	return lst;
}%>