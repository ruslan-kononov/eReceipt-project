<%--
  Created by IntelliJ IDEA.
  User: ruslankononov
  Date: 23.08.2020
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Doctor: Settings</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Ruslan Kononov, Mark Otto, Jacob Thornton, Bootstrap contributors">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/product/">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/doctor.css" />">
</head>
<body>
<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
    <h5 class="my-0 mr-md-auto font-weight-normal">
        <img src="/resources/img/dark-logo.png" width="40" height="50">
        <spring:message code="name"/></h5>
    <c:choose>
        <c:when test="${userRole=='doctor'}">
            <nav class="my-2 my-md-0 mr-md-3">
                <a class="p-2 text-dark" href="${pageContext.request.contextPath}/doctor"><spring:message code="home"/></a>
                <a class="p-2 text-dark" href="${pageContext.request.contextPath}/doctor#add-prescription"><spring:message code="doc-make-precr"/></a>
                <a class="p-2 text-dark" href="${pageContext.request.contextPath}/doctor/settings/${doctor.username}"><spring:message code="doc-settngs"/></a>
                <input type="radio" name="languages" value="en">
                <label><spring:message code="lang.eng"/></label>
                <input type="radio" name="languages" value="uk">
                <label><spring:message code="lang.uk"/></label>
            </nav>
        </c:when>
        <c:otherwise>
            <nav class="my-2 my-md-0 mr-md-3">
                <a class="p-2 text-dark" href="${pageContext.request.contextPath}/pharma"><spring:message code="home"/></a>
                <a class="p-2 text-dark" href="${pageContext.request.contextPath}/pharma/settings/${pharma.username}"><spring:message code="doc-settngs"/></a>
                <input type="radio" name="languages" value="en">
                <label><spring:message code="lang.eng"/></label>
                <input type="radio" name="languages" value="uk">
                <label><spring:message code="lang.uk"/></label>
            </nav>
        </c:otherwise>
    </c:choose>
    <form:form class="form-inline" action="${pageContext.request.contextPath}/logout" method="post">
        <button class="btn btn-outline-primary my-2 my-sm-0 btn-form" type="submit"><spring:message code="logout"/></button>
    </form:form>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h3 id="add-prescription"><spring:message code="set-update"/></h3>
            <div class="no-gutters border rounded overflow-hidden flex-md-row mb-4 p-3 shadow-sm h-md-250 position-relative form-style">
                <c:choose>
                    <c:when test="${userRole=='doctor'}">
                        <c:set var = "link2" scope = "session" value = "${'/doctor/updatePhoto'}"/>
                    </c:when>
                    <c:otherwise>
                        <c:set var = "link2" scope = "session" value = "${'/pharma/updatePhoto'}"/>
                    </c:otherwise>
                </c:choose>
                <form class="new-photo-form" action="${link2}" method="post" enctype="multipart/form-data">
                    <div class="form-row">
                        <div class="col-md-8 mb-3">
                            <label><spring:message code="set-choose-img"/></label>
                            <div class="custom-file">
                                <input type="file" name="image-file" class="custom-file-input" required>
                                <label class="custom-file-label"><spring:message code="set-choose-file"/></label>
                                <div class="invalid-feedback"><spring:message code="set-choose-file-warn"/></div>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" name="username" value="${username}" />
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <button class="btn btn-outline-primary btn-form add-photo mt-3" type="Submit"><spring:message code="set-update-btn"/></button>
                </form>
                <div class="table-prescription">
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script src="<c:url value="/resources/js/settings.js" />"></script>
</body>
</html>
