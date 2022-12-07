<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 05/12/2022
  Time: 10:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Customer</title>
    <link rel="stylesheet" href="../../bootstrap/css/bootstrap.css">
    <%@include file="/include/background.jsp" %>
</head>
<body>
<div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-6" style="background: #e9f2ef">
        <h1 class="text-center">Edit Customer</h1>
        <form method="post">
            <div class="mb-3">
                <label class="form-label fw-bold">Name Customer Type</label>
                <select class="form-select" name="nameCustomerType">
                    <c:forEach var="customerType" items="${customerTypeList}">
                        <option value="${customerType.id}"
                                <c:if test="${customerType.id == customer.getCustomerTypeId()}">selected</c:if>>${customerType.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label class="form-label fw-bold">Name Customer</label>
                <input type="text" class="form-control" name="nameCustomer" value="${customer.getName()}">
            </div>
            <div class="mb-3">
                <label class="form-label fw-bold">Day Of Birth</label>
                <input type="date" class="form-control" name="dayOfBirth" value="${customer.getDateOfBirth()}">
            </div>
            <div class="mb-3">
                <label class="form-label fw-bold">Gender</label> <br>
                <label><input class="form-check-input" type="radio" name="gender" value="true"
                              <c:if test="${customer.isGender()}">checked</c:if>>Male</label>
                <label><input class="form-check-input" type="radio" name="gender" value="false"
                              <c:if test="${!customer.isGender()}">checked</c:if>>Female</label>
            </div>
            <div class="mb-3">
                <label class="form-label fw-bold">ID Card</label>
                <input type="text" class="form-control" name="idCard" value="${customer.getIdCard()}">
            </div>
            <div class="mb-3">
                <label class="form-label fw-bold">Phone Number</label>
                <input type="text" class="form-control" name="phoneNumber" value="${customer.getPhoneNumber()}">
            </div>
            <div class="mb-3">
                <label class="form-label fw-bold">Email</label>
                <input type="text" class="form-control" name="email" value="${customer.getEmail()}">
            </div>
            <div class="mb-3">
                <label class="form-label fw-bold">address</label>
                <input type="text" class="form-control" name="address" value="${customer.getAddress()}">
            </div>
            <button type="submit" class="btn btn-primary">Update</button>
        </form>
    </div>
    <div class="col-md-3"></div>
</div>
<script src="../../bootstrap/js/bootstrap.js"></script>
</body>
</html>
