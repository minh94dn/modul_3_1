<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 01/12/2022
  Time: 10:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit Product</h1>
<form method="post">
    <p>Name</p>
    <input name="name" value="${product.getName()}" type="text">
    <p>Brand</p>
    <input name="brand" value="${product.getBrand()}" type="text">
    <p>Price</p>
    <input name="price" value="${product.getPrice()}" type="text">
    <button type="submit">Save</button>
</form>
</body>
</html>
