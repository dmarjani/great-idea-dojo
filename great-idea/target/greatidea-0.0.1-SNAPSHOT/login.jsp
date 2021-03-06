<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!-- pageContext is an implicit object in JSP ex. path_to_workspace/project_name/src/main -->
<!-- it is useful for importing JS,CSS files on JSP files -->
<!-- in our case is equal to /home/carlos/working/eclipse-auth-jsp/springboot-registration-login/src/main -->

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Log in with your account</title>

      <link href="${contextPath}/resources/bootstrap-5-dist/css/bootstrap.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">
      <form method="POST" action="${contextPath}/login" class="form-signin">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span >${message}</span>
            
            <div class="form-floating mb-3">
			  <input name="username" type="text" class="form-control" id="floatingUsername" placeholder="Username">
			  <label for="floatingUsername">Username</label>
			</div>
			<div class="form-floating">
			  <input name="password" type="password" class="form-control" id="floatingPassword" placeholder="Password">
			  <label for="floatingPassword">Password</label>
			</div>
            
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			
			<button type="submit" class="btn btn-success mt-3 mb-2">Log In</button>
			
			<div class="dropdown-divider"></div>
  			<a class="link-success" href="${contextPath}/registration">Create an account</a>
        </div>
      </form>
    </div>

    <script src="${contextPath}/resources/js/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/bootstrap-5-dist/js/bootstrap.js"></script>
  </body>
</html>
