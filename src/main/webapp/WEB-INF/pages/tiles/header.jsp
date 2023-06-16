<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

	<fmt:setLocale value="${sessionScope.locale}"/>
	<fmt:setBundle basename="localization.local" var="local"/>

	<fmt:message bundle="${local}" key="local.locbutton.name.ru" var="ru_button"/>
	<fmt:message bundle="${local}" key="local.locbutton.name.en" var="en_button"/>
	<fmt:message bundle="${local}" key="local.locbutton.header.login" var="login"/>
	<fmt:message bundle="${local}" key="local.locbutton.header.password" var="password"/>
	<fmt:message bundle="${local}" key="local.locbutton.header.registration" var="registartion_button"/>
	<fmt:message bundle="${local}" key="local.locbutton.header.sign_in" var="sign_in_button"/>
	<fmt:message bundle="${local}" key="local.locbutton.header.sign_out" var="sign_out_button"/>



<div class="wrapper">

	<div class="newstitle">News management</div>

	<div class="local-link">
		<div align="right">
			<form action="controller" method="post" style="display: inline-block">
				<input type="hidden" name="command" value="change_locale">
				<input type="hidden" name="locale" value="ru"/>
				<input type="submit" value="${ru_button}"/>
			</form>

			<form action="controller" method="post" style="display: inline-block">
				<input type="hidden" name="command" value="change_locale">
				<input type="hidden" name="locale" value="en"/>
				<input type="submit" value="${en_button}"/> <br>
			</form>
		</div>

		<c:if test="${not (sessionScope.user eq 'active')}">
			<div align="right">
				<form action="controller" method="post">
					<input type="hidden" name="command" value="do_sign_in" />

					<label for="login">${login}</label>
					<input type="text" name="login" id="login"/><br />

					<label for="password">${password}</label>
					<input type="password" name="password" id="password"/><br />

					<c:if test="${not (requestScope.AuthenticationError eq null)}">
						<font color="red"> 
						   <c:out value="${requestScope.AuthenticationError}" />
						</font> <br>
					</c:if>
					
					<a href="controller?command=go_to_registration_page">${registartion_button}</a>
					<input type="submit" value="${sign_in_button}" /><br />
				</form>
			</div>
		</c:if>

		<c:if test="${sessionScope.user eq 'active'}">
			<div align="right">
				<form action="controller" method="post">
					<input type="hidden" name="command" value="do_sign_out" /> 
					<input type="submit" value="${sign_out_button}" /><br />
				</form>
			</div>
		</c:if>
	</div>
</div>
