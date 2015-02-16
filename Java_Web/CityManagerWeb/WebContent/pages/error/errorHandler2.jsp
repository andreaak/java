<%@page import="java.util.Enumeration"%>
<%@ page language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" 
	content="text/html; charset=ISO-8859-1">
<title>Our bad!</title>
</head>
<body>
	<table style="width:100%;">
		<tr>
			<td style="width:25%;height:80%;" valign="top">
				<a href=${pageContext.request.contextPath}/index_servlets.html>Main Page </a>
			</td>
			<td style="width:75%;height:80%;">
				<h1>An Error has occurred!</h1><br>
				<h2>Error Uri: ${pageContext.errorData.requestURI}</h2><br>
				<p>${pageContext.exception.message}</p><br>
				<%
				
				//Enumeration<String> en = request.getAttributeNames();
				//while(en.hasMoreElements())
				//{%>
				<!--  	<p><%//out.println(en.nextElement());%><p>	-->
				<%//}
				//out.println(request.getAttribute("javax.servlet.error.message"));
				//out.println(exception.getMessage());
				%>
			</td>
		</tr>
	</table>
</body>
</html>