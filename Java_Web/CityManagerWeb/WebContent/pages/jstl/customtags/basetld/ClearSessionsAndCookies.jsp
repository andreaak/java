<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="siteTags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to the World Manager</title>
</head>
<body>
	<siteTags:header />
	<table style="width:100%;">
		<tr>
			<td style="width:25%;height:80%;" valign="top">
				<c:import url="navbar.jsp" />
			</td>
			<td style="width:75%;height:80%;">
				<h1>Sessions and Cookies Cleared</h1>
			</td>
		</tr>
	</table>
	<siteTags:footer copyrightYear="${initParam.copyright}"
		websiteLink="${initParam.weblink}" />
</body>
</html>