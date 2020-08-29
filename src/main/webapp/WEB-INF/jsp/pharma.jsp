<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Pharma</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Ruslan Kononov, Mark Otto, Jacob Thornton, Bootstrap contributors">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/product/">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/doctor.css" />">
</head>
<body>
<header>
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
        <h5 class="my-0 mr-md-auto font-weight-normal">
            <img src="/resources/img/dark-logo.png" width="40" height="50">
            <spring:message code="name"/></h5>
        <nav class="my-2 my-md-0 mr-md-3">
            <a class="p-2 text-dark" href="#add-prescription"><spring:message code="pharma-check"/></a>
            <a class="p-2 text-dark" href="pharma/settings/${pharma.username}"><spring:message code="doc-settngs"/></a>
            <input type="radio" name="languages" value="en" id="lang-en">
            <label for="lang-en"><spring:message code="lang.eng"/></label>
            <input type="radio" name="languages" value="uk" id="lang-uk">
            <label for="lang-uk"><spring:message code="lang.uk"/></label>
        </nav>
        <form:form class="form-inline" action="${pageContext.request.contextPath}/logout" method="post">
            <button class="btn btn-outline-primary my-2 my-sm-0 btn-form" type="submit"><spring:message code="logout"/></button>
        </form:form>
    </div>
</header>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                <div class="col-auto d-none d-md-block">
                    <img src="<c:url value="pharma/getPhoto/${pharma.photoId}" />" alt="" class="img-fluid"
                         style="max-height: 450px">
                </div>
                <div class="col p-4 d-flex flex-column position-static">
                    <strong class="d-inline-block mb-2 text-primary">
                        <h4><spring:message code="pharma-name"/></h4>
                    </strong>
                    <h3 class="mb-0">${pharma.firstName} ${pharma.lastName}</h3>
                    <div class="mb-3 text-muted">${pharma.email}</div>
                </div>
            </div>

            <h3 id="add-prescription"><spring:message code="pharma-check"/></h3>
            <div class="no-gutters border rounded overflow-hidden flex-md-row mb-4 p-3 shadow-sm h-md-250 position-relative form-style">
                <form class="prescription-form">
                    <div class="form-row">
                        <div class="col-6 mb-3">
                            <label><spring:message code="pharma-enter-code"/></label>
                            <input type="text" class="form-control prescrCode" value="" placeholder="<spring:message code="pharma-enter-code"/>">
                            <div class="invalid-feedback"><spring:message code="pharma-code-warn1"/></div>
                            <div class="invalid-feedback"><spring:message code="pharma-code-warn2"/></div>
                        </div>
                    </div>
                    <button class="btn btn-outline-primary btn-form btn-check-prescription" type="button"><spring:message code="pharma-btn-check"/></button>
                </form>
                <div class="table-prescription">
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"/>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script src="<c:url value="/resources/js/pharma.js" />"></script>
<script src="<c:url value="/resources/js/lang-change.js" />"></script>
</body>
</html>
