<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="controller" method="post">
    <input type="hidden" name="command" value="do_registration"/>

    <label for="login">Enter login:</label><br>
    <input type="text" name="login" id="login"><br>

    <label for="email">Enter email:</label><br>
    <input type="text" name="email" id="email"><br>

    <label for="password">Enter password:</label><br>
    <input type="text" name="password" id="password"><br>

    <c:if test="${not (sessionScope.RegistrationError == null)}">
        <div style="color:red"><c:out value="${sessionScope.RegistrationError}"/></div>
    </c:if>

    <input type="submit" value="Submit">
</form>
</body>
</html> 