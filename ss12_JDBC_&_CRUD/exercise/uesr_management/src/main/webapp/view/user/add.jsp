<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 02/12/2022
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New User</title>
</head>
<body>
<h1>Add New User</h1>
<c:if test="${mess != null}">
    <p>${mess}</p>
</c:if>
<a href="/user">
    <button>Return</button>
</a>
<form method="post">
    <p>Name</p>
    <input name="name" type="text">
    <p>Email</p>
    <input name="email" type="text">
    <p>Country</p>
    <input name="country" type="text"><br>
    <br>
    <button type="submit">Save</button>
</form>
</body>
</html>
