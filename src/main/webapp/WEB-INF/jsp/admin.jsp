<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <title>Doctor</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Ruslan Kononov, Mark Otto, Jacob Thornton, Bootstrap contributors">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/product/">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/admin.css" />">
</head>

<body>
<header>
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
        <h5 class="my-0 mr-md-auto font-weight-normal">
            <img src="/resources/img/dark-logo.png" width="40" height="50">
            e-Prescription</h5>
        <nav class="my-2 my-md-0 mr-md-3">
            <a class="p-2 text-dark" href="#add_doctor">Add doctor</a>
            <a class="p-2 text-dark" href="#add_pharma">Add pharmacist</a>
            <a class="p-2 text-dark" href="#add_hospital">Add hospital</a>
            <a class="p-2 text-dark" href="#add_patient">Add patient</a>
        </nav>
        <form:form class="form-inline" action="${pageContext.request.contextPath}/logout" method="post">
            <button class="btn btn-outline-primary my-2 my-sm-0 btn-form" type="submit">Logout</button>
        </form:form>
    </div>
</header>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h3 id="add_doctor">Add doctor</h3>
            <div class="no-gutters border rounded overflow-hidden flex-md-row mb-4 p-3 shadow-sm h-md-250 position-relative form-style">
                <form:form class="needs-validation doc-form" action="/admin/addDoctor" modelAttribute="doctor" method="post" enctype="multipart/form-data">
                    <div class="form-row">
                        <div class="col-md-4 mb-3">
                            <label for="doc-first-name">First name</label>
                            <form:input type="text" class="form-control" id="doc-first-name" placeholder="First name" path="firstName"/>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="doc-last-name">Last name</label>
                            <form:input  type="text" class="form-control" id="doc-last-name" placeholder="Last name"  path="lastName"/>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="doc-username">Username</label>
                            <form:input type="text" class="form-control" id="doc-username" placeholder="Username" path="username"/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-4 mb-3">
                            <label for="doc-email">Email</label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">@</span>
                                </div>
                                <form:input type="text" class="form-control" id="doc-email" placeholder="Email" path="email"/>
                                <div class="invalid-feedback">Please provide a valid email</div>
                            </div>
                        </div>
                        <div class="form-group col-md-8 mb-3">
                            <label>Hospital</label>
                            <form:select path="hospital" class="custom-select hospital">
                                <option value="">Choose hospital</option>
                                <c:forEach items="${hospitals}" var="hospital">
                                        <form:option value="${hospital.hospitalId}">${hospital.name}</form:option>
                                </c:forEach>
                            </form:select>
                            <div class="invalid-feedback">Choose a hospital</div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-4 mb-3">
                            <label for="doc-pass-1">Password</label>
                            <input type="password" class="form-control doc-pass" id="doc-pass-1" placeholder="Password">
                            <div class="invalid-feedback">Password should be at least 8 characters long</div>
                            <div class="invalid-feedback">Passwords do not match</div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="doc-pass-2">Repeat password</label>
                            <form:input path="password" type="password" class="form-control doc-pass" id="doc-pass-2" placeholder="Password"/>
                            <div class="invalid-feedback">Password should be at least 8 characters long</div>
                            <div class="invalid-feedback">Passwords do not match</div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label>Choose image</label>
                            <div class="custom-file">
                                <input type="file" name="image-file" class="custom-file-input" id="doc-img">
                                <label class="custom-file-label">Choose file...</label>
                            </div>
                        </div>
                        <form:input type="hidden" path="role" value="DOCTOR"/>
                    </div>
                    <button class="btn btn-outline-primary btn-form btn-add-doctor" type="submit">Add doctor</button>
                </form:form>
            </div>


            <h3 id="add_pharma">Add pharmacist</h3>
            <div class="no-gutters border rounded overflow-hidden flex-md-row mb-4 p-3 shadow-sm h-md-250 position-relative form-style">
                <form:form class="needs-validation pharma-form" action="/admin/addPharma" modelAttribute="pharma" method="post" enctype="multipart/form-data">
                    <div class="form-row">
                        <div class="col-md-4 mb-3">
                            <label for="doc-first-name">First name</label>
                            <form:input type="text" class="form-control" id="pharma-first-name" placeholder="First name" path="firstName"/>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="doc-last-name">Last name</label>
                            <form:input  type="text" class="form-control" id="pharma-last-name" placeholder="Last name"  path="lastName"/>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="doc-username">Username</label>
                            <form:input type="text" class="form-control" id="pharma-username" placeholder="Username" path="username"/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-4 mb-3">
                            <label for="doc-email">Email</label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">@</span>
                                </div>
                                <form:input type="text" class="form-control" id="pharma-email" placeholder="Email" path="email"/>
                                <div class="invalid-feedback">Please provide a valid email</div>
                            </div>
                        </div>
                        <div class="col-md-8 mb-3">
                            <label>Choose image</label>
                            <div class="custom-file">
                                <input type="file" name="image-file" class="custom-file-input" id="pharma-img">
                                <label class="custom-file-label">Choose file...</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-4 mb-3">
                            <label for="pharma-pass-1">Password</label>
                            <input type="password" class="form-control pharma-pass" id="pharma-pass-1" placeholder="Password">
                            <div class="invalid-feedback">Password should be at least 8 characters long</div>
                            <div class="invalid-feedback">Passwords do not match</div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="pharma-pass-2">Repeat password</label>
                            <form:input path="password" type="password" class="form-control pharma-pass" id="pharma-pass-2" placeholder="Password"/>
                            <div class="invalid-feedback">Password should be at least 8 characters long</div>
                            <div class="invalid-feedback">Passwords do not match</div>
                        </div>
                        <form:input type="hidden" path="role" value="PHARMA"/>
                    </div>
                    <button class="btn btn-outline-primary btn-form btn-add-pharma" type="submit">Add pharmacist</button>
                </form:form>
            </div>

            <h3 id="add_hospital">Add hospital</h3>
            <div class="no-gutters border rounded overflow-hidden flex-md-row mb-4 p-3 shadow-sm h-md-250 position-relative form-style">
                <form:form class="needs-validation hosp-form" action="/admin/addHospital" modelAttribute="hospital" method="post">
                    <div class="form-row">
                        <div class="col mb-3">
                            <label for="hosp-name">Hospital name</label>
                            <form:input type="text" class="form-control" id="hosp-name" placeholder="Hospital name" path="name"/>
                        </div>
                    </div>
                    <button class="btn btn-outline-primary btn-form btn-add-hosp" type="submit">Add hospital</button>
                </form:form>
            </div>

            <h3 id="add_patient">Add patient</h3>
            <div class="no-gutters border rounded overflow-hidden flex-md-row mb-4 p-3 shadow-sm h-md-250 position-relative form-style">
                <form:form class="needs-validation patient-form" action="/admin/addPatient" modelAttribute="patient" method="post">
                    <div class="form-row">
                        <div class="col-md-4 mb-3">
                            <label for="patient-first-name">First name</label>
                            <form:input type="text" class="form-control" id="patient-first-name" placeholder="First name" path="firstName"/>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="patient-last-name">Last name</label>
                            <form:input  type="text" class="form-control" id="patient-last-name" placeholder="Last name"  path="lastName"/>
                        </div>
                        <div class='col-md-4 mb-3'>
                            <label for="patient-date">Birthdate</label>
                            <form:input class="form-control" type="date" value="2019-01-01" id="patient-date" path="birthdate"/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col mb-3">
                            <form:select path="doctor" class="custom-select patient-doctor">
                                <option value="">Choose a doctor</option>
                                <c:forEach items="${doctors}" var="doctor">
                                    <option value="${doctor.userId}">${doctor.firstName} ${doctor.lastName}</option>
                                </c:forEach>
                            </form:select>
                            <div class="invalid-feedback">Choose a patient</div>
                        </div>
                    </div>
                    <button class="btn btn-outline-primary btn-form btn-add-patient" type="submit">Add patient</button>
                </form:form>
            </div>
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
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script src="<c:url value="/resources/js/admin.js" />"></script>
</body>
</html>
