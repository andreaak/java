<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="suff" value="/pages/css/" />

<div class="navbar">
<c:choose>
	<c:when test="${pageContext.request.contextPath eq initParam.defaultWebBase}">
		<!-- context is good -->
		<ul style="list-style-type:none; padding:0px; margin:0px 0px 0px 0px;">
			<li><a href="${pageContext.request.contextPath}${suff}index.jsp">Home</a></li>
			<li><a href="${pageContext.request.contextPath}${suff}login.jsp">Login</a></li>
			<li><a href="${pageContext.request.contextPath}${suff}protected/listCities.jsp">View Cities</a></li>
			<li><a href="${pageContext.request.contextPath}${suff}protected/listCountries.jsp">View Countries</a></li>
			<c:if test="${sessionScope.authorized_user.authLevel eq 2}" >
				<li><a href="${pageContext.request.contextPath}${suff}protected/addCity.jsp">Add a new City</a>
			</c:if>
			<li><a href="${pageContext.request.contextPath}/signout.do?suff=${suff}">Sign Out</a></li>
			<li><a href="${pageContext.request.contextPath}/invalidatesessionandremovecookies.do?suff=${suff}">Clear All User Data</a></li>
			<li><a href="${pageContext.request.contextPath}/">Main Page</a></li>
		</ul>
	</c:when>
	<c:otherwise>
		<!-- use base links -->
		<ul style="list-style-type:none; padding:0px; margin:0px 0px 0px 0px;">
			<li><a href="${initParam.baseURL}${suff}index.jsp">Home</a></li>
			<li><a href="${initParam.baseURL}${suff}login.jsp">Login</a></li>
			<li><a href="${initParam.baseURL}${suff}protected/listCities.jsp">View Cities</a></li>
			<li><a href="${initParam.baseURL}${suff}protected/listCountries.jsp">View Countries</a></li>
			<c:if test="${sessionScope.authorized_user.authLevel eq 2}" >
				<li><a href="${initParam.baseURL}${suff}protected/addCity.jsp">Add a new City</a>
			</c:if>
			<li><a href="${initParam.baseURL}/signout.do?suff=${suff}">Sign Out</a></li>
			<li><a href="${initParam.baseURL}/invalidatesessionandremovecookies.do?suff=${suff}">Clear All User Data</a></li>
			<li><a href="${initParam.baseURL}/">Main Page</a></li>
		</ul>
	</c:otherwise>
</c:choose>
</div>