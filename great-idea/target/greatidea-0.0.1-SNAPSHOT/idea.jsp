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
		<form:form method="POST" modelAttribute="ideaForm" action="${contextPath}/idea/create" class="form-signin">
		  
		  <h2 class="form-heading my-5 mx-5">Create a new Idea</h2>
		  
		  <spring:bind path="name">
          	<div class="row my-5 form-group ${status.error ? 'has-error' : ''}">
          		<label for="ideaName" class="col-sm-2 col-form-label">Content</label>
            	<div class="col-sm-10">
            		<form:input id="ideaName" type="text" path="name" class="col-sm-10 col-form-label" autofocus="true"></form:input>
                </div>
                <form:errors path="name"></form:errors>
            </div>
          </spring:bind>
          
		  <button type="submit" class="btn btn-success mt-3 mb-2">Create</button>
		 
		 </form:form>
	</div>

</body>
</html>