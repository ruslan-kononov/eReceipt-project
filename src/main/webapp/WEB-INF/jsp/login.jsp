<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<nav class="site-header sticky-top py-1">
    <div class="container d-flex flex-column flex-md-row justify-content-between">
        <a class="py-2" href="#" aria-label="Product">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="d-block mx-auto" role="img" viewBox="0 0 24 24" focusable="false"><title>Product</title><circle cx="12" cy="12" r="10"/><path d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94"/></svg>
        </a>
        <a class="py-2 d-none d-md-inline-block" href="#">About</a>
        <a class="py-2 d-none d-md-inline-block" href="#">Report a problem</a>
    </div>
</nav>

<div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light banner">
    <div class="col-md-5 p-lg-5 mx-auto my-5">
        <h1 class="display-4 font-weight-normal">e-Prescription</h1>
        <p class="lead font-weight-normal">Centralized paperless system for issuing and handling medical prescriptions.</p>
        <a class="btn btn-outline-primary btn-form" href="#log-form">Log in</a>
    </div>
</div>

<div class="d-md-flex flex-md-equal w-100 my-md-3 pl-md-3" id="log-form">
    <div class="bg-dark mr-md-3 pt-1 px-3 pt-md-3 px-md-5 text-center text-white overflow-hidden">
        <div class="my-3 py-2">
            <h3 class="display-5">Log In</h3>
            <h5 class="display-5">Choose your role</h5>
            <form name="f" action="<c:url value='/login'/>" method="post">
                <div class="wrapper">
                    <div class="toggle_radio">
                        <input type="radio" checked class="toggle_option" id="first_toggle" name="toggle_option">
                        <input type="radio" class="toggle_option" id="second_toggle" name="toggle_option">
                        <input type="radio" class="toggle_option" id="third_toggle" name="toggle_option">
                        <label for="first_toggle">
                            <p>Doctor</p>
                        </label>
                        <label for="second_toggle">
                            <p>Pharmacist</p>
                        </label>
                        <label for="third_toggle">
                            <p>Support</p>
                        </label>
                        <div class="toggle_option_slider">
                        </div>
                    </div>
                </div>
                <div class="d-flex align-items-center flex-column">
                    <c:if test="${param.error ne null}">
                        <div class="alert alert-error">
                            Invalid username and password.
                        </div>
                    </c:if>
                    <div class="p-1 p-md-2 m-md-1 col-sm-4">
                        <input type="text" class="form-control inputs"  name="username" placeholder="Username">
                    </div>
                    <div class="p-1 p-md-2 m-md-1 col-sm-4">
                        <input type="password" class="form-control inputs" name="password" placeholder="Password">
                    </div>
                    <button type="submit" class="btn btn-outline-primary btn-form" style="padding-top: 5px">Log in</button>
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
</body>
</html>
