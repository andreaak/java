<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    		
	<%@page import="com.expressionlanguage.models.WebUser"%>
  	<%@page import="com.servlets.contextListener.DBManagerSetup"%> 
  	<%@page import="com.servlets.models.DBManager"%>   
  	<%@page import="com.servlets.db.helpers.DBWorldQueries"%>    
  	<%@page import="java.sql.ResultSet"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to the World Manager</title>
</head>
<body>
	<c:import url="header.jsp" />
	<!-- Use a choose .. when .. otherwise for multiple condition checks -->
	<!-- if the user is not logged in, redirect to login controller -->
	<!-- if the data is not set, redirect to controller to get city data -->
	<c:choose>
		<c:when test="${sessionScope.authorized_user eq null}">
			<c:redirect url="login.jsp?dest=listCities" />
		</c:when>
		<c:when test="${sessionScope.authorized_user.authLevel ne 1}">
			<c:redirect url="login.jsp?dest=listCities" />
		</c:when>
		<c:when test="${sessionScope.authorized_user.userId eq null}">
			<c:redirect url="login.jsp?dest=listCities" />
		</c:when>
		<c:when test="${sessionScope.cityData eq null}">
			<c:redirect url="/getcitydata.do?suff=/pages/jstl/conditionsandlooping/" />
		</c:when>
		<c:otherwise>
			<h1><c:out value="Welcome Back ${sessionScope.authorized_user.userId}" /></h1>
		</c:otherwise>
	</c:choose> 
	
	
	<!-- otherwise, move forward for data display -->
	<table style="width:100%;">
		<tr>
			<td style="width:25%;height:80%;" valign="top">
				<c:import url="navbar.jsp" />
			</td>
			<td style="width:75%;height:80%;">
				<table border=1> 
					<tr>
						<td>POSITION</td>
						<td>ID</td>
						<td>NAME</td>
						<td>COUNTRY_CODE</td>
						<td>DISTRICT</td>
						<td>POPULATION</td>
					</tr>
					<c:forEach var="cityData" items="${sessionScope.cityData}" varStatus="iterationCount">
						<tr>
							<td>${iterationCount.count}</td>
							<td>${cityData.id}</td>
							<td>${cityData.name}</td>
							<td>${cityData.countryCode}</td>
							<td>${cityData.district}</td>
							<td>${cityData.population}</td>
						</tr>
					</c:forEach>
				
				</table>
			</td>
		</tr>
	</table>
	<c:import url="footer.jsp">
		<c:param name="copyrightYear" value="${initParam.copyright}" />
		<c:param name="websiteLink" value="${initParam.weblink}" />
	</c:import>
</body>
</html>