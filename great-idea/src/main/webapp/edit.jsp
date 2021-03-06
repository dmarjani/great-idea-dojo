<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
</head>
<body>

	<jsp:include page="${contextPath}/headerinc.jsp" />

 	<div class="container">
		  
		  <h2 class="form-heading my-5 mx-5">Edit ${idea.name}</h2>
		  
          <div class="row my-5">
          	<label for="ideaName" class="col-sm-2 col-form-label">Content</label>
           	<div class="col-sm-10">
          		<input id="ideaName" type="text" class="col-sm-10 col-form-label" value="${idea.name}"></input>
            </div>
          </div>
          
		<div class="col-12 my-5">
			<a class="btn btn-success" onclick="this.href='${contextPath}/update?ideaId=${idea.id}&name='+document.getElementById('ideaName').value" href=''>Update</a>
		</div>
		
		<div class="col-12 my-5">
			<a class="btn btn-success" href="${contextPath}/delete?ideaId=${idea.id}">Delete</a>
		</div>
		
	</div>

</body>
</html>