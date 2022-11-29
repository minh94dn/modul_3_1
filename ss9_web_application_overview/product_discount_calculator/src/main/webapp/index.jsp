<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 29/11/2022
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/product" method="post">
    <h3>Mô tả của sản phẩm </h3>
    <input name="product" type="text"><br>
    <h3>Giá niêm yết của sản phẩm </h3>
    <input name="price" type="text"><br>
    <h3>Tỷ lệ chiết khấu (phần trăm)</h3>
    <input name="discount" type="text"><br>
    <button type="submit">Calculate Discount</button>
</form>
</body>
</html>
