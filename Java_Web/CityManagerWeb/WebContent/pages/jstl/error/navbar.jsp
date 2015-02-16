<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- method one: in the anchor -->
<c:url value="errorHandlingInTags.jsp" var="errorHandlingTagsURL" />
<c:url value="errorHandlingInTags2.jsp" var="errorHandlingTagsURL2" />
<a href="${errorHandlingTagsURL}">Error </a><br>
<a href="${errorHandlingTagsURL2}">Error 2</a><br>
<a href=${pageContext.request.contextPath}/index_servlets.html>Main Page </a>