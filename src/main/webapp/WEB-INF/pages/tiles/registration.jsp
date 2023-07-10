<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registration page</title>
</head>
<body>
	
	
 	<form action="controller" method="post">
 	 <input type="hidden" name="command" value="do_registration">
 	
 	<div class="list-menu-wrapper" style="float: centre;">
 	
 	<p> Name <input type="text" name="name" value=""> </p>
 	<p> Surname <input type="text" name="surname" value=""> </p>
 	<p> Login: <input type="text" name="login" value=""> </p>
 	<p> Password: <input type="text" name="password" value="" placeholder="min 8 marks"> </p>
 	<p> E-mail: <input type="text" name="email" value="" placeholder="mail@dot.com "> </p>
 	<p> Secret word: <input type="text" name="secret_word" value="" placeholder="mother surname"> </p>		
	
	<div> <h3> English level: </h3> 
	<input type="radio" id="language" name="level" value="beginner">
	<label for="language"> beginner</label> 
	<input type="radio" id="language" name="level" value="intermediate">
	<label for="language"">intermediate </label>
	<input type="radio" id="language" name="level" value="upper-intermediate">
	<label for="language"> upper-intermediate </label> 
	<input type="radio" id="language" name="level" value="advanced">
	<label for="language"> advanced </label>
	
	</div>
	
	<div>
	 <h3> How do you prefer to get to work:  </h3>
    <input type="checkbox" name="vehicle" value="public">By public transport<br>
    <input type="checkbox" name="vehicle" value="car">By car<br>
    <input type="checkbox" name="vehicle" value="foot">By foot<br>
    <input type="checkbox" name="vehicle" value="bike">By bike<br>
    <input type="checkbox" name="vehicle" value="moto">By moto<br>
  </div>
 		
 	<input type="submit" value="send for registration">
 	
 	</div>
 	</form>
 	
	 		
 		<c:if test="${sessionScope.welcome eq 'registered'}">

			<div align="left">
			
			 			 	
			 	 <h1>	<a href="controller?command=go_to_base_page">  Registration complete, go to base page and sign in</a></h1>
			 	
			</div> 	

		</c:if>
 	
 	
</body>
</html>