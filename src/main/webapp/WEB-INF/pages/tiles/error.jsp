<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	
	
 	
 	<div class="error-box" style="float: centre;">
 	
 	 Error page.
 	 <br>
 	 <c:out value="${requestScope.AuthentificationError}"></c:out>
 	 <br>
 	 <c:out value="${requestScope.errorE}"></c:out>
 	 <br>
 	 <a href="controller?command=go_to_base_page"> Go to base page</a>
 	 
	</div>
	
	
	
	 	
 	
</body>
</html>