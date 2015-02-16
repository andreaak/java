<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="index.jsp" var="indexURL" />
<c:url value="login.jsp" var="loginURL" />
<c:url value="listCities.jsp" var="cityViewURL" />
<c:url value="listCountries.jsp" var="countryViewURL" />
<c:url value="/signout.do?suff=/pages/jstl/customtags/base/" var="signoutController" />
<c:url value="/invalidatesessionandremovecookies.do?suff=/pages/jstl/customtags/base/" var = "invalidateSessionRemoveCookiesURL" />
<a href="${indexURL}">Home</a><br>
<a href="${loginURL}">Login</a><br>
<a href="${cityViewURL}">View Cities</a><br>
<a href="${countryViewURL}">View Countries</a><br>
<a href="${signoutController}">Sign Out Controller</a><br>
<a href="${invalidateSessionRemoveCookiesURL}">Clear All User Data</a><br>
<a href=${pageContext.request.contextPath}/index_servlets.html>Main Page </a>
