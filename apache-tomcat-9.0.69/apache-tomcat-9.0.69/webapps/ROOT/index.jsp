<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 30/11/2022
  Time: 1:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style>
      body{
        width: 500px;
      }
      .num1{
        margin-left: 44px;
        margin-top: 10px;
      }
      .num2{
        margin-left: 20px;
        margin-top: 10px;
      }
      .option{
        margin-left: 66px;
        margin-top: 10px;
      }
      button{
        margin-top: 10px;
        margin-left: 130px;
      }
    </style>
  </head>
  <body>
  <form action="/calculator" method="post">
    <fieldset>
    <legend><h1>Calculator</h1></legend>
    <span>Firt operand:</span>
    <input name="num1" class="num1"><br>
    <span>Operator:</span>
    <select name="operator" class="option">
      <option value="+">Add</option>
      <option value="-">Subtract</option>
      <option value="*">Volume</option>
      <option value="/">Divide</option>
    </select><br>
    <span>Second operand:</span>
    <input name="num2" class="num2"><br>
    <button type="submit">Calculate</button>
    </fieldset>
  </form>
  </body>
</html>
