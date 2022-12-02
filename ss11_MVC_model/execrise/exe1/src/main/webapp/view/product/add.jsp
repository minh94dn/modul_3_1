<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 01/12/2022
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Add new product</h1>
<form action="/product?action=add" method="post">
    <p>ID</p>
    <input name="id" type="text">
    <p>Name</p>
    <input name="name" type="text">
    <p>Brand</p>
    <input name="brand" type="text">
    <p>Price</p>
    <input name="price" type="text">
    <button type="submit">Save</button>
</form>
</body>
</html>
