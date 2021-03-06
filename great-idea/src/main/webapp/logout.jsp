<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
	<link href="${contextPath}/resources/css/logout.css" rel="stylesheet">
</head>
<body>
	<div class="logoutContent">
		<c:if test="${pageContext.request.userPrincipal.name != null}">
	        <form id="logoutForm" method="POST" action="${contextPath}/logout">
	            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        </form>
		</c:if>
	</div>
</body>
</html>