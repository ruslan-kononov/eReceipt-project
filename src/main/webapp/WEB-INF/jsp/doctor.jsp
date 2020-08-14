<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Doctor</title>
</head>
<body>
<h2>Doctor's page</h2>
<h3>${doctor.firstName} ${doctor.lastName}</h3>
<h3>${doctor.email}</h3>
<form:form action="${pageContext.request.contextPath}/logout" method="POST">
    <input type="submit" value="Log out" />
</form:form>
</body>
</html>
