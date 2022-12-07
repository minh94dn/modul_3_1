<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 02/12/2022
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<h1>Edit User</h1>
<p style="color: red">${mess}</p>
<form method="post">
    <p>Name</p>
    <input type="text" name="name" value="${user.getName()}">
    <p>Email</p>
    <input type="text" name="email" value="${user.getEmail()}">
    <p>Country</p>
    <input type="text" name="country" value="${user.getCountry()}">
    <br>
    <br>
    <button type="submit">Update</button>
</form>
</body>
</html>
