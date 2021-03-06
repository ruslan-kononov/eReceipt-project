<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">
<head>
    <title>e-Prescription</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Ruslan Kononov, Mark Otto, Jacob Thornton, Bootstrap contributors">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
          crossorigin="anonymous">
    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/product/">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login.css" />">
</head>
<body>
<header>
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-dark border-bottom box-shadow text-light">
        <h5 class="my-0 mr-md-auto font-weight-normal"><spring:message code="name"/></h5>
        <nav class="my-2 my-md-0 mr-md-3">
            <input type="radio" name="languages" value="en" id="lang-en">
            <label for="lang-en"><spring:message code="lang.eng"/></label>
            <input type="radio" name="languages" value="uk" id="lang-uk">
            <label for="lang-uk"><spring:message code="lang.uk"/></label>
            <a class="p-2 text-light" href="#log-form"><spring:message code="login.log"/></a>
        </nav>
    </div>
</header>
<div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light banner">
    <div class="col-md-5 p-lg-5 mx-auto my-5">
        <h1 class="display-4 font-weight-normal"><spring:message code="name"/></h1>
        <p class="lead font-weight-normal"><spring:message code="login.text"/></p>
        <a class="btn btn-outline-primary btn-form" href="#log-form"><spring:message code="login.log"/></a>
    </div>
</div>

<div class="d-md-flex flex-md-equal w-100 my-md-3 pl-md-3" id="log-form">
    <div class="bg-dark mr-md-3 pt-1 px-3 pt-md-3 px-md-5 text-center text-white overflow-hidden">
        <div class="my-3 py-2">
            <h3 class="display-5"><spring:message code="login.log-phrase"/></h3>
            <form name="f" action="<c:url value='/login'/>" method="post">
                <div class="d-flex align-items-center flex-column">
                    <c:if test="${param.error ne null}">
                        <div class="alert alert-error">
                            <spring:message code="login.invalid"/>
                        </div>
                    </c:if>
                    <div class="p-1 p-md-2 m-md-1 col-sm-4">
                        <input type="text" class="form-control inputs"  name="username" placeholder="<spring:message code="login.username"/>">
                    </div>
                    <div class="p-1 p-md-2 m-md-1 col-sm-4">
                        <input type="password" class="form-control inputs" name="password" placeholder="<spring:message code="login.pass"/>">
                    </div>
                    <button type="submit" class="btn btn-outline-primary btn-form" style="padding-top: 5px"><spring:message code="login.log"/></button>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
        </div>
    </div>
</div>

<footer class="container py-5">
    <div class="row">
        <div class="col-12 col-md">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="d-block mb-2" role="img" viewBox="0 0 24 24" focusable="false">
                <title>Product</title>
                <circle cx="12" cy="12" r="10" />
                <path d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94" />
            </svg>
            <small class="d-block mb-3 text-muted">&copy; 2017-2020</small>
        </div>
        <div class="col-6 col-md">
            <h5>Features</h5>
            <ul class="list-unstyled text-small">
                <li><a class="text-muted" href="#">Cool stuff</a></li>
                <li><a class="text-muted" href="#">Random feature</a></li>
                <li><a class="text-muted" href="#">Team feature</a></li>
                <li><a class="text-muted" href="#">Stuff for developers</a></li>
                <li><a class="text-muted" href="#">Another one</a></li>
                <li><a class="text-muted" href="#">Last time</a></li>
            </ul>
        </div>
        <div class="col-6 col-md">
            <h5>Resources</h5>
            <ul class="list-unstyled text-small">
                <li><a class="text-muted" href="#">Resource</a></li>
                <li><a class="text-muted" href="#">Resource name</a></li>
                <li><a class="text-muted" href="#">Another resource</a></li>
                <li><a class="text-muted" href="#">Final resource</a></li>
            </ul>
        </div>
        <div class="col-6 col-md">
            <h5>Resources</h5>
            <ul class="list-unstyled text-small">
                <li><a class="text-muted" href="#">Business</a></li>
                <li><a class="text-muted" href="#">Education</a></li>
                <li><a class="text-muted" href="#">Government</a></li>
                <li><a class="text-muted" href="#">Gaming</a></li>
            </ul>
        </div>
        <div class="col-6 col-md">
            <h5>About</h5>
            <ul class="list-unstyled text-small">
                <li><a class="text-muted" href="#">Team</a></li>
                <li><a class="text-muted" href="#">Locations</a></li>
                <li><a class="text-muted" href="#">Privacy</a></li>
                <li><a class="text-muted" href="#">Terms</a></li>
            </ul>
        </div>
    </div>
</footer>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
<script src="<c:url value="/resources/js/lang-change.js" />"></script>
</body>
</html>
