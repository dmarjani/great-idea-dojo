<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
</head>
<body>

	<jsp:include page="${contextPath}/headerinc.jsp" />

	<div class="container">
	
		<h2 class="form-heading my-5">${idea.name}</h2>
	
		<div class="row mb-3">
			<label class="col-sm-2 col-form-label">Created by: </label>
		    <div class="col-sm-10">
		    	<label class="col-sm-2 col-form-label">${idea.user.username}</label>
		    </div>
		</div>
		
		<!-- table -->
		<table id="likesTable" class="table table-striped my-5">
			<thead>
			    <tr>
			      <th scope="col"><h3>Name</h3></th>
			    </tr>
			</thead>
			<tbody>
			  	<c:forEach items="${idea.likes}" var="like">
			  		<tr>
				  		<td>${like.user.username}</td>
			  		</tr>
			  	</c:forEach>
			</tbody>
		</table>
		
		<div class="col-12">
			<c:choose>
				<c:when test="${idea.edit}">
					<a class="btn btn-success" href="${contextPath}/edit?ideaId=${idea.id}">Edit</a>
				</c:when>
			    <c:otherwise>
			    	<a class="btn btn-success" href="${contextPath}/welcome">Edit</a>
			    </c:otherwise>
			</c:choose>
		</div>
	
	</div>
	
</body>
</html>