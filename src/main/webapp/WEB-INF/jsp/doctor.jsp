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
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/doctor.css" />">
</head>

<body>
<header>
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
        <h5 class="my-0 mr-md-auto font-weight-normal">
            <img src="/resources/img/dark-logo.png" width="40" height="50">
            Company name</h5>
        <nav class="my-2 my-md-0 mr-md-3">
            <a class="p-2 text-dark" href="">Home</a>
            <a class="p-2 text-dark" href="#add-prescription">Make prescription</a>
            <a class="p-2 text-dark" href="doctor/settings/${doctor.username}">Settings</a>
        </nav>
        <form:form class="form-inline" action="${pageContext.request.contextPath}/logout" method="post">
            <button class="btn btn-outline-primary my-2 my-sm-0 btn-form" type="submit">Logout</button>
        </form:form>
    </div>
</header>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                <div class="col-auto d-none d-md-block">
                    <img src="<c:url value="doctor/getPhoto/${doctor.photoId}" />" alt="" class="img-fluid"
                         style="max-height: 450px">
                </div>
                <div class="col p-4 d-flex flex-column position-static">
                    <strong class="d-inline-block mb-2 text-primary">
                        <h4>Doctor</h4>
                    </strong>
                    <h3 class="mb-0">${doctor.firstName} ${doctor.lastName}</h3>
                    <div class="mb-1 text-muted">${doctor.hospital.name}</div>
                    <div class="mb-3 text-muted">${doctor.email}</div>
                </div>
            </div>

            <h3 id="add-prescription">Make prescription</h3>
            <div class="no-gutters border rounded overflow-hidden flex-md-row mb-4 p-3 shadow-sm h-md-250 position-relative form-style">
                <form:form class="prescription-form" action="/doctor/addPrescription" modelAttribute="prescription" method="post">
                    <div class="form-row">
                        <div class="col-6 mb-3">
                            <label>Select a patient</label>
                            <form:select path="patient" class="custom-select patient">
                                <option value="">Choose a patient</option>
                                <c:forEach items="${patients}" var="patient">
                                    <option value="${patient.patientId}">${patient.firstName} ${patient.lastName}</option>
                                </c:forEach>
                            </form:select>
                            <div class="invalid-feedback">Select a patient</div>
                        </div>
                        <div class="col-6 mb-3">
                            <label>Select a medicine</label>
                            <form:select path="medicineName" class="custom-select medicine">
                                <option value="">Choose a medicine</option>
                                <option value="Lisinopril">Lisinopril</option>
                                <option value="Levothyroxine">Levothyroxine</option>
                                <option value="Azithromycin">Azithromycin</option>
                                <option value="Metformin">Metformin</option>
                                <option value="Lipitor">Lipitor</option>
                                <option value="Amlodipine">Amlodipine</option>
                                <option value="Amoxicillin">Amoxicillin</option>
                            </form:select>
                            <div class="invalid-feedback">Select a medicine</div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-6 mb-3">
                            <label>Prescription text</label>
                            <form:textarea path="prescrText" class="form-control prescrText"  rows="3"></form:textarea>
                            <div class="invalid-feedback">The prescription is too long</div>
                        </div>
                    </div>
                    <form:input type="hidden" path="doctor" value="${doctor.userId}"/>
                    <form:input type="hidden" path="prescrCode" value="${prescrCode}"/>
                    <button type="button" class="btn btn-outline-primary btn-form" data-toggle="modal" data-target="#prescriptionModal">
                        Prescribe
                    </button>
                    <div class="modal fade" id="prescriptionModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title">Prescription info</h5>
                                </div>
                                <div class="modal-body">
                                    The prescription number is: <h3>${prescrCode}</h3>
                                    Tell this number to the patient only. <br>
                                    The pharmacist will be able to hand out the prescription <b>by this code only</b>!
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-outline-primary btn-form" data-dismiss="modal">Cancel</button>
                                    <button class="btn btn-outline-primary btn-form btn-prescribe" type="submit">Prescribe</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script src="<c:url value="/resources/js/doctor.js" />"></script>
</body>

</html>
