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
    <link rel="stylesheet" href="/common/bootstrap-5.0.2-dist/css/bootstrap.css">
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css"/>
    <title>List Facility</title>
</head>
<body>
<%@include file="/include/header.jsp" %>
<center><h1 style="margin-top: 20px">List Facility</h1></center>

<div class="row mt-2">
    <div class="col-lg-12 d-flex justify-content-center align-items-center">
        <form class="d-flex">
            <input class="form-control me-2" type="search" placeholder="Search name" aria-label="Search"
                   name="searchName">
            <input class="form-control me-2" type="search" placeholder="Search cost" aria-label="Search"
                   name="searchCost">
            <input class="form-control me-2" type="search" placeholder="Search rent type" aria-label="Search"
                   name="searchRentType">
            <input type="hidden" name="action" value="search">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
    </div>
</div>
<p style="color:red; text-align: center; font-size: 20px" id="mess" id="mess">${mess}</p>
<table class="table table-striped" id="tableFacility">
    <thead>
    <tr style="background:#addccf;">
        <th>STT</th>
        <th>Name</th>
        <th>Area</th>
        <th>Cost</th>
        <th>Max people</th>
        <th>Rent Type</th>
        <th>Facility Type</th>
        <th>Standard Room</th>
        <th>Description Other Convenience</th>
        <th>Pool Area</th>
        <th>Number Of Floors</th>
        <th>Facility Free</th>
        <th></th>
        <th style="text-align: center"><a>
            <button onclick="location.href='/facility?action=add'" type="submit"><img
                    src="https://img.icons8.com/ios/50/null/add-user-group-man-man--v1.png" width="30"/></button>
        </a></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="facility" items="${facilityList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${facility.getName()}</td>
            <td>${facility.getArea()}</td>
            <td>${facility.getCost()}</td>
            <td>${facility.getMaxPeople()}</td>
            <td>${facility.getRentType().getName()}</td>
            <td>${facility.getFacilityType().getName()}</td>
            <td>${facility.getStandardRoom() == null ? "Not yet": facility.getStandardRoom()}</td>
            <td>${facility.getDescriptionOtherConvenience() == null ? "Not yet": facility.getDescriptionOtherConvenience()}</td>
            <td>${facility.getPoolArea() <=0 ? "Not yet" : facility.getPoolArea()}</td>
            <td>${facility.getNumberOfFloors()}</td>
            <td>${facility.getFacilityFree() == null ? "Not yet": facility.getFacilityFree()}</td>
            <td><a href="/facilityList?action=edit&id=${facility.getId()}">
                <button class="btn btn-primary">Edit</button>
            </a></td>
            <td>
                <button onclick="infoDelete('${facility.id}', '${facility.name}')" type="button" class="btn btn-danger"
                        data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Confirm</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="facility?action=delete" method="post">
                <div class="modal-body">
                    <input hidden id="deleteId" name="deleteId" type="text">
                    <span>do you want to delete the facility named </span><span id="deleteName"
                                                                                style="color: red">${facility.id}</span><span> ?</span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="/include/footer.jsp" %>
<script>
    function infoDelete(id, name) {
        document.getElementById("deleteId").value = id;
        document.getElementById("deleteName").innerText = name;
    }

    setTimeout(function () {
        close(document.getElementById("mess").style.display = "none")
    }, 3000);
</script>
<script src="../../bootstrap/js/bootstrap.js"></script>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableFacility').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</body>
</html>
