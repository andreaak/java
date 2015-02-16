<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:choose>
	<c:when test="${pageContext.request.contextPath eq initParam.defaultWebBase}">
		<!-- context is good -->
		<ul style="list-style-type:none; padding:0px; margin:0px 0px 0px 0px;">
			<li><a href="${pageContext.request.contextPath}/pages/auth/base/index.jsp">Home</a></li>
			<li><a href="${pageContext.request.contextPath}/pages/auth/base/login.jsp">Login</a></li>
			<li><a href="${pageContext.request.contextPath}/pages/auth/base/protected/listCities.jsp">View Cities</a></li>
			<li><a href="${pageContext.request.contextPath}/pages/auth/base/protected/listCountries.jsp">View Countries</a></li>
			<li><a href="${pageContext.request.contextPath}/signout.do?suff=/pages/auth/base/">Sign Out</a></li>
			<li><a href="${pageContext.request.contextPath}/invalidatesessionandremovecookies.do?suff=/pages/auth/base/">Clear All User Data</a></li>
			<li><a href="${pageContext.request.contextPath}/">Main Page</a></li>
		</ul>
	</c:when>
	<c:otherwise>
		<!-- use base links -->
		<ul style="list-style-type:none; padding:0px; margin:0px 0px 0px 0px;">
			<li><a href="${initParam.baseURL}/pages/auth/base/index.jsp">Home</a></li>
			<li><a href="${initParam.baseURL}/pages/auth/base/login.jsp">Login</a></li>
			<li><a href="${initParam.baseURL}/pages/auth/base/protected/listCities.jsp">View Cities</a></li>
			<li><a href="${initParam.baseURL}/pages/auth/base/protected/listCountries.jsp">View Countries</a></li>
			<li><a href="${initParam.baseURL}/signout.do?suff=/pages/auth/base/">Sign Out</a></li>
			<li><a href="${initParam.baseURL}/invalidatesessionandremovecookies.do?suff=/pages/auth/base/">Clear All User Data</a></li>
			<li><a href="${initParam.baseURL}/">Main Page</a></li>
		</ul>
	</c:otherwise>
</c:choose>
