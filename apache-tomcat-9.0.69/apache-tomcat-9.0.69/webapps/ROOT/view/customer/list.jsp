<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 05/12/2022
  Time: 1:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
    <link rel="stylesheet" href="../../bootstrap/css/bootstrap.css">
    <title>List Customer</title>
</head>
<body>
<%@include file="/include/header.jsp"%>
<h1>List Customer</h1>
<a href="/customer?action=add">
    <button class="btn btn-outline-primary">Add Customer</button>
</a>
<div class="row mt-2">
    <div class="col-lg-12 d-flex justify-content-center align-items-center">
<form class="d-flex">
    <input class="form-control me-2" type="search" placeholder="Search name" aria-label="Search" name="nameSearch">
    <input class="form-control me-2" type="search" placeholder="Search address" aria-label="Search" name="addressSearch">
    <input type="hidden" name="action" value="search">
    <button class="btn btn-outline-success" type="submit">Search</button>
</form>
</div></div>
<table class="table table-striped">
    <tr>
        <th>STT</th>
        <th>Customer Type</th>
        <th>Name</th>
        <th>Birthday</th>
        <th>Gender</th>
        <th>ID_Card</th>
        <th>Phone Number</th>
        <th>Email</th>
        <th>Address</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>

    <c:forEach var="customer" items="${customerList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${customer.getCustomerType().getName()}</td>
            <td>${customer.getName()}</td>
            <td>${customer.getDateOfBirth()}</td>
            <c:if test="${customer.isGender()}">
                <td>Male</td>
            </c:if>
            <c:if test="${!customer.isGender()}">
                <td>Female</td>
            </c:if>
            <td>${customer.getIdCard()}</td>
            <td>${customer.getPhoneNumber()}</td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getAddress()}</td>
            <td><a href="/customer?action=edit&id=${customer.getId()}">
                <button class="btn btn-primary">Edit</button>
            </a></td>
            <td>
                <button onclick="infoDelete('${customer.id}', '${customer.name}')" type="button" class="btn btn-danger"
                        data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>
</table>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Confirm</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="customer?action=delete" method="post">
                <div class="modal-body">
                    <input hidden id="deleteId" name="deleteId" type="text">
                    <span>do you want to delete the customer named </span><span id="deleteName"
                                                                                style="color: red">${customer.id}</span><span> ?</span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="/include/footer.jsp"%>
<script>
    function infoDelete(id, name) {
        document.getElementById("deleteId").value = id;
        document.getElementById("deleteName").innerText = name;
    }
</script>
<script src="../../bootstrap/js/bootstrap.js"></script>
</body>
</html>
