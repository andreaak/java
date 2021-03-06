<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
     <%@page import="com.expressionlanguage.models.WebUser"%>
  <%@page import="com.servlets.contextListener.DBManagerSetup"%> 
  <%@page import="com.servlets.models.DBManager"%>   
  <%@page import="com.servlets.db.helpers.DBWorldQueries"%>    
  <%@page import="java.sql.ResultSet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="suff" value="/pages/css/" />	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<title>Welcome to the World Manager</title>
  <title>Welcome to the World Manager</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/menubar.css"> 
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sitestyle.css"> 
</head>
<body>
	<c:import url="../header.jsp" />
	<div class="container">
		<c:import url="../navbar.jsp" />
		<div class="content">
			<c:choose>
				<c:when test="${sessionScope.countryCodes eq null}">
					<jsp:forward page="/getcountrycodes2.do?suff=${suff}&suff2=protected/" />
				</c:when>
				<c:otherwise>
					<h1><c:out value="Welcome Back ${sessionScope.authorized_user.userId}. Now adding a city." /></h1>
				</c:otherwise>
			</c:choose> 
			<form action="${pageContext.request.contextPath}/addnewcity2.do?suff=${suff}&suff2=protected/" method="post">
				<table border=1> 
					<tr>
						<td>ID</td>
						<td>
							<span>Assigned when added</span>
						</td>
					</tr>
					<tr>
						<td>NAME</td>
						<td>
							<input type="text" name="cityName" style="width:100%;" />
						</td>
					</tr>
					<tr>
						<td>COUNTRY_CODE</td>
						<td>	
							<select name="cityCountryCode" style="width:100%;">
								<option selected>--- Choose One ---</option>
								<c:forEach var="cCode" items="${sessionScope.countryCodes}">
									<option>${cCode}</option>
								</c:forEach>
							</select>
						</td>	
					</tr>
					<tr>
						<td>DISTRICT</td>
						<td><input name="cityDistrict" type="text" style="width:100%;"/>
					</tr>
					<tr>
						<td>POPULATION</td>
						<td><input name="cityPopulation" type="text" style="width:100%;" /></td>
					</tr>
					<tr>
						<td colspan="2" align="right">
							<input type="submit" name="addcity" value="Add City" style="width:200px;"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>			
	<c:import url="../footer.jsp">
		<c:param name="copyrightYear" value="${initParam.copyright}" />
		<c:param name="websiteLink" value="${initParam.weblink}" />
	</c:import>
</body>
</html>