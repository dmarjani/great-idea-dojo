<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Hello  ${pageContext.request.userPrincipal.name}</title>
</head>
<body>
  <jsp:include page="${contextPath}/headerinc.jsp" />
  
  <div class="container my-5">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
    </c:if>
	
	<!-- table -->
	<table id="ideasTable" class="table table-striped my-5">
		<thead>
		    <tr>
		      <th scope="col">Idea</th>
		      <th scope="col">Created By</th>
		      <th scope="col">Likes</th>
		      <th scope="col">Action</th>
		    </tr>
		</thead>
		<tbody>
		  	<c:forEach items="${ideas}" var="idea">
		  		<tr>
			  		<td><a href="${contextPath}/likes?ideaId=${idea.id}" class="link-primary">${idea.name}</a></td>
			  		<td>${idea.user.username}</td>
			  		<td>${idea.likeNumber}</td>
			  		<td><a class="like" href="${contextPath}/like?ideaId=${idea.id}" class="link-primary">${idea.userLikes}</a></td>
		  		</tr>
		  	</c:forEach>
		</tbody>
	</table>
		
	<div class="col-12">
		<a class="btn btn-success" href="${contextPath}/idea">Create Idea</a>
	</div>
	
  </div>
  <script src="${contextPath}/resources/js/welcome.js"></script>
</body>
</html>
