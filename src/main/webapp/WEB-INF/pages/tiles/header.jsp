<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="wrapper">
	<div class="newstitle">Only good news</div>
	
   <fmt:setLocale value="${sessionScope.local}" />
   <fmt:setBundle basename="localization.local" var="loc" />
   
   <fmt:message bundle="${loc}" key="local.locbutton.name.ru" var="ru_button" />
   <fmt:message bundle="${loc}" key="local.locbutton.name.en" var="en_button" />
   <fmt:message bundle="${loc}" key="local.locbutton.registration" var="registr_button" />
   <fmt:message bundle="${loc}" key="local.locbutton.sign_in" var="signIn_button" />
   <fmt:message bundle="${loc}" key="local.header.login" var="login_field" />
   <fmt:message bundle="${loc}" key="local.header.password" var="password_field" />
   
        	
	<div class="local-link">

		<div align="right">					
		<a href="controller?local=en&command=change_locale&link=${sessionScope.link}"> <c:out value="${en_button}"> </c:out>  </a>
		<br />		
		<a href="controller?local=ru&command=change_locale&link=${sessionScope.link}"> <c:out value="${ru_button}"></c:out></a>
		
	

			
		</div>

		<c:if test="${not (sessionScope.user eq 'active')}">

			<div align="right">
				<form action="controller" method="post">
					<input type="hidden" name="command" value="do_sign_in" /> 
					<c:out value="${login_field}"></c:out> <input type="text" name="login" value="" /><br /> 
					<c:out value="${password_field}"></c:out><input type="password" name="password" value="" /><br />
					
					<c:if test="${not (requestScope.AuthentificationError eq null)}">
					                                
						<font color="red"> 
						   <c:out value="${requestScope.AuthentificationError}" />
						   
						</font> 
					</c:if>
					
					<a href="controller?command=go_to_registration_page"><c:out value="${registr_button}"></c:out></a> 
					<input type="submit" value="${signIn_button}" /><br />
				</form>
			</div>

		</c:if>
		
		<c:if test="${sessionScope.user eq 'active'}">
				                             

			<div align="right">
				<form action="controller" method="post">
					<input type="hidden" name="command" value="do_sign_out" /> 
					<input type="submit" value="Sign Out" /><br />
				</form>
			</div>

		</c:if>
	</div>

</div>
