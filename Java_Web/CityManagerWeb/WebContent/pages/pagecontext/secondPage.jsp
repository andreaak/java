<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to the World Manager</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<table style="width:100%;">
		<tr>
			<td style="width:25%;height:80%;" valign="top">
				<%@ include file="navbar.jsp" %>
			</td>
			<td style="width:75%;height:80%;">
				<% 
					//application/servlet context from page context
					String dbUIDFail = (pageContext.getAttribute("dbuserid", PageContext.APPLICATION_SCOPE) == null ? "bad" :
						 				(String)pageContext.getAttribute("dbuserid", PageContext.APPLICATION_SCOPE));
					
					String dbUIDSuccess = (application.getInitParameter("dbuserid") == null ? "bad" :
											application.getInitParameter("dbuserid")); 
				
					//session object from page context
					String uid = (pageContext.getAttribute("uid", PageContext.SESSION_SCOPE) == null ? "bad" :
			 						(String)pageContext.getAttribute("uid", PageContext.SESSION_SCOPE));
				
					String sessionCode = (pageContext.getAttribute("SessionCode", PageContext.SESSION_SCOPE) == null ? "bad" :
 											(String)pageContext.getAttribute("SessionCode", PageContext.SESSION_SCOPE));
					
					//try to get secret code from page context
					String appCode = (pageContext.getAttribute("AppCode", PageContext.APPLICATION_SCOPE) == null ? "bad" :
			 						(String)pageContext.getAttribute("AppCode", PageContext.APPLICATION_SCOPE));
							
					//request param from page context
					String reqCode = (pageContext.getAttribute("ReqCode", PageContext.REQUEST_SCOPE) == null ? "bad" :
								 	(String)pageContext.getAttribute("ReqCode", PageContext.REQUEST_SCOPE));
							
					//query string param from page context
					String pcode = (pageContext.getAttribute("key", PageContext.REQUEST_SCOPE) == null ? "bad" :
					 				(String)pageContext.getAttribute("key", PageContext.REQUEST_SCOPE));
				
					String pcode2 = request.getParameter("key");
							
					//try to get previously set page attribute
					String lcode = (pageContext.getAttribute("LostCode") == null ? "bad" :
		 							(String)pageContext.getAttribute("LostCode"));
							
				%>
				<table style="width:100%;" border="1">
					<tr>
						<td style="width:35%;">pageContext DB User ID</td>
						<%
							if (dbUIDFail.equalsIgnoreCase("BAD"))
							{
						%>
								<td style="width:65%;background-color:#e5b75b;"><%= dbUIDFail %></td>
						<%
							}
							else
							{
					    %>
								<td style="width:65%;background-color:#6599ff;"><%= dbUIDFail %></td>
						<%
							}
						%>
					</tr>
					<tr>
						<td style="width:35%;">application DB User ID</td>
						<%
							if (dbUIDSuccess.equalsIgnoreCase("BAD"))
							{
						%>
								<td style="width:65%;background-color:#e5b75b;"><%= dbUIDSuccess %></td>
						<%
							}
							else
							{
					    %>
								<td style="width:65%;background-color:#6599ff;"><%= dbUIDSuccess %></td>
						<%
							}
						%>
					</tr>
					<tr>
						<td style="width:35%;">User ID</td>
						<%
							if (uid.equalsIgnoreCase("BAD"))
							{
						%>
								<td style="width:65%;background-color:#e5b75b;"><%= uid %></td>
						<%
							}
							else
							{
					    %>
								<td style="width:65%;background-color:#6599ff;"><%= uid %></td>
						<%
							}
						%>
					</tr>
					<tr>
						<td style="width:35%;">App Code</td>
						<%
							if (appCode.equalsIgnoreCase("BAD"))
							{
						%>
								<td style="width:65%;background-color:#e5b75b;"><%= appCode %></td>
						<%
							}
							else
							{
					    %>
								<td style="width:65%;background-color:#6599ff;"><%= appCode %></td>
						<%
							}
						%>
					</tr>
					<tr>
						<td style="width:35%;">Request Attribute Code</td>
						<%
							if (reqCode.equalsIgnoreCase("BAD"))
							{
						%>
								<td style="width:65%;background-color:#e5b75b;"><%= reqCode %></td>
						<%
							}
							else
							{
					    %>
								<td style="width:65%;background-color:#6599ff;"><%= reqCode %></td>
						<%
							}
						%>
					</tr>
					<tr>
						<td style="width:35%;">Key Attribute</td>
						<%
							if (pcode.equalsIgnoreCase("BAD"))
							{
						%>
								<td style="width:65%;background-color:#e5b75b;"><%= pcode %></td>
						<%
							}
							else
							{
					    %>
								<td style="width:65%;background-color:#6599ff;"><%= pcode %></td>
						<%
							}
						%>
					</tr>
					<tr>
						<td style="width:35%;">Key Param</td>
						<%
							if (pcode2.equalsIgnoreCase("BAD"))
							{
						%>
								<td style="width:65%;background-color:#e5b75b;"><%= pcode2 %></td>
						<%
							}
							else
							{
					    %>
								<td style="width:65%;background-color:#6599ff;"><%= pcode2 %></td>
						<%
							}
						%>
					</tr>
					<tr>
						<td style="width:35%;">Lost Code</td>
						<%
							if (lcode.equalsIgnoreCase("BAD"))
							{
						%>
								<td style="width:65%;background-color:#e5b75b;"><%= lcode %></td>
						<%
							}
							else
							{
					    %>
								<td style="width:65%;background-color:#6599ff;"><%= lcode %></td>
						<%
							}
						%>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<jsp:include page="footer.jsp" />
</body>
</html>