<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 01/12/2022
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Product</h1>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Brand</td>
        <td>Price</td>

    </tr>
    <c:forEach var="product" items="${productList}">
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getName()}</td>
            <td>${product.getBrand}</td>
            <td>${product.getPrice}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
