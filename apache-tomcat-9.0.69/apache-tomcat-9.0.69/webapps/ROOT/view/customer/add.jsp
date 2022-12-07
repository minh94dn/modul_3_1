<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 05/12/2022
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Customer</title>
    <link rel="stylesheet" href="../../bootstrap/css/bootstrap.css">
    <%@include file="/include/background.jsp" %>
</head>
<body>
<div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-6" style="background: #e9f2ef">
        <h1 class="text-center">Add Customer</h1>
        <form method="post">
            <div class="mb-3">
                <label class="form-label fw-bold">Name Customer Type</label>
                <select class="form-select" name="nameCustomerType">
                    <option value="1">Diamond</option>
                    <option value="2">Platinium</option>
                    <option value="3">Gold</option>
                    <option value="4">Silver</option>
                    <option value="5">Member</option>
                </select>
            </div>
            <div class="mb-3">
                <label class="form-label fw-bold">Name Customer</label>
                <input type="text" class="form-control" name="nameCustomer">
            </div>
            <div class="mb-3">
                <label class="form-label fw-bold">Day Of Birth</label>
                <input type="date" class="form-control" name="dayOfBirth">
            </div>
            <div class="mb-3">
                <label class="form-label fw-bold">Gender</label> <br>
                <label><input class="form-check-input" type="radio" name="gender" value="true" checked> Male</label>
                <label><input class="form-check-input" type="radio" name="gender" value="false"> Female</label>
            </div>
            <div class="mb-3">
                <label class="form-label fw-bold">ID Card</label>
                <input type="text" class="form-control" name="idCard">
            </div>
            <div class="mb-3">
                <label class="form-label fw-bold">Phone Number</label>
                <input type="text" class="form-control" name="phoneNumber">
            </div>
            <div class="mb-3">
                <label class="form-label fw-bold">Email</label>
                <input type="text" class="form-control" name="email">
            </div>
            <div class="mb-3">
                <label class="form-label fw-bold">address</label>
                <input type="text" class="form-control" name="address">
            </div>

            <button type="submit" class="btn btn-primary">Save</button>
        </form>
    </div>
    <div class="col-md-3"></div>
</div>
<script src="../../bootstrap/js/bootstrap.js"></script>
</body>
</html>
