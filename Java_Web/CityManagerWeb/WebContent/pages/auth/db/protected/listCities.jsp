<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@page import="com.expressionlanguage.models.WebUser"%>
  <%@page import="com.servlets.contextListener.DBManagerSetup"%> 
  <%@page import="com.servlets.models.DBManager"%>   
  <%@page import="com.servlets.db.helpers.DBWorldQueries"%>    
  <%@page import="java.sql.ResultSet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="suff" value="/pages/auth/db/" />	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to the World Manager</title>
</head>
<body>
	<c:import url="../header.jsp" />
	<c:choose>
		<c:when test="${sessionScope.cityData eq null}">
			<jsp:forward page="/getcitydata2.do?suff=${suff}&suff2=protected/" />
		</c:when>
		<c:otherwise>
			<h1><c:out value="Welcome Back ${sessionScope.authorized_user.userId}" /></h1>
		</c:otherwise>
	</c:choose> 
	
	
	<!-- otherwise, move forward for data display -->
	<table style="width:100%;">
		<tr>
			<td style="width:25%;height:80%;" valign="top">
				<c:import url="../navbar.jsp" />
			</td>
			<td style="width:75%;height:80%;">
				<table border=1> 
					<tr>
						<td>ID</td>
						<td>NAME</td>
						<td>COUNTRY_CODE</td>
						<td>DISTRICT</td>
						<td>POPULATION</td>
					</tr>
					<c:forEach var="city" items="${sessionScope.cityData}">
						<tr>
							<td>${city.id}</td>
							<td>${city.name}</td>
							<td>${city.countryCode}</td>
							<td>${city.district}</td>
							<td>${city.population}</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
	<c:import url="../footer.jsp">
		<c:param name="copyrightYear" value="${initParam.copyright}" />
		<c:param name="websiteLink" value="${initParam.weblink}" />
	</c:import>
</body>
</html>