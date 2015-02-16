<%@page import="com.servlets.db.helpers.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test Connection</title>
    </head>
    <body>
        <% request.setCharacterEncoding("UTF-8");%>
        <%
      
        String desc = Database.check() ? "Соединение установлено!!" : "Соединение отсутствует" ;
		%>
		<h2><%=desc%></h2>
		<a href=${pageContext.request.contextPath}/index_servlets.html>Main Page </a>
    </body>
</html>
