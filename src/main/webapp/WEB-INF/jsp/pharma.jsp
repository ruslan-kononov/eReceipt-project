<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Pharma</title>
</head>
<body>
<h2>Pharmacist's page</h2>
<h3>${pharma.firstName} ${pharma.lastName}</h3>
<h3>${pharma.email}</h3>
<form:form action="${pageContext.request.contextPath}/logout" method="POST">
    <input type="submit" value="Log out" />
</form:form>
</body>
</html>
