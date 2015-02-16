<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="suff" value="/pages/css/" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Welcome to the World Manager</title>
  <title>Welcome to the World Manager</title>
  <link rel="stylesheet" type="text/css" href="../../css/menubar.css"> 
  <link rel="stylesheet" type="text/css" href="../../css/sitestyle.css"> 
</head>
<body>
	<c:import url="header.jsp" />
	<div class="container">
		<c:import url="navbar.jsp" />
		<div class="content">
			<form id="login" method="post" action="${pageContext.request.contextPath}/loginUser4.do?suff=${suff}">
				<table style="width:450px;">
					<tr>
						<td>
							<span>UserName:</span>
						</td>
						<td>
							<input name="uid" type="text" style="width:250px;" value="${cookie.credentials_uid.value}" />
						</td>
					</tr>
					<tr>
						<td>
							<span>Password:</span>
						</td>
						<td>
							<input name="pwd" type="password" style="width:250px;" value="${cookie.credentials_pwd.value}"/>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="right">
							<input name="rememberMe" type="checkbox">&nbsp;Remember Me
						</td>
					</tr>
					<tr>
						<td colspan="2" align="right">
							<input type="submit" value="Sign In" 
							    style="width:250px;" />
						</td>
					</tr>
				</table>
				<input type="hidden" name="dest" value="${param.dest}" />
			</form>
		</div>
	</div>			
	<c:import url="footer.jsp">
		<c:param name="copyrightYear" value="${initParam.copyright}" />
		<c:param name="websiteLink" value="${initParam.weblink}" />
	</c:import>
</body>

</html>