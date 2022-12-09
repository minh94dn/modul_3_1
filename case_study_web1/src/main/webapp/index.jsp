<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 05/12/2022
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <title>Home</title>
</head>
<body>
<div class="container-fluid">
    <%@include file="/include/header.jsp"%>
    <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner abc">
            <div class="carousel-item active">
                <img src="https://angiangtourism.vn/so-dien-thoai-furama-resort-da-nang/imager_47897.jpg"
                     class="d-block w-100">
            </div>
            <div class="carousel-item abc">
                <img src="https://cf.bstatic.com/xdata/images/hotel/max1024x768/62371531.jpg?k=fb1828d64f739b526944dcb487699e4625ad8799986e0e4ef5c2c930dcf39b6c&o=&hp=1"
                     class="d-block w-100">
            </div>
            <div class="carousel-item abc">
                <img src="https://resortdanang.info/wp-content/uploads/2019/01/resort-furama-da-nang.jpg"
                     class="d-block w-100">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls"
                data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls"
                data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</div>
<%@include file="/include/footer.jsp"%>

<script src="bootstrap/js/bootstrap.js"></script>
</body>
</html>
