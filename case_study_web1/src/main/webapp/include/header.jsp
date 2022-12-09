<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 06/12/2022
  Time: 11:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>header</title>
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.css">
    <style>
       b {
            font: 2em/1 "Oswald", sans-serif;
            letter-spacing: 0;
            padding: .25em 0 .325em;
            display: block;
            margin-right: 5px;
            text-shadow: 0 0 80px rgba(255, 255, 255, 0.5);
            background: url(https://i.ibb.co/RDTnNrT/animated-text-fill.png) repeat-y;
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            -webkit-animation: aitf 80s linear infinite;
            -webkit-transform: translate3d(0,0,0);
            -webkit-backface-visibility: hidden;
        }
        @-webkit-keyframes aitf {
            0% { background-position: 0% 50%; }
            100% { background-position: 100% 50%; }
        }
    </style>
</head>
<body>
<nav class="navbar navbar-light" style="background: #addccf">
    <div class="container">
        <a class="navbar-brand" href="http://localhost:8080/">
            <img src="https://furamavietnam.com/wp-content/uploads/2018/10/logo.png" alt="" width="90" height="100" >
        </a>
        <b class="text-end">
            Cao Đức Kim Minh
        </b>
    </div>
</nav>
<div class="row bg-success sticky-top container-fluid g-0">
    <div class="col-lg-3"></div>
    <div class="col-lg-6 d-flex justify-content-center">
        <nav class="navbar navbar-expand-lg navbar-light bg-success sticky-top">
            <div class="container">
                <div class="collapse navbar-collapse" id="navbarSupportedContent1">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item navbar-brand">
                            <a class="nav-link active text-light" aria-current="page" href="http://localhost:8080/"><i
                                    class="fa-sharp fa-solid fa-house"></i> Home</a>
                        </li>
                        <li class="nav-item navbar-brand">
                            <a class="nav-link active text-light" aria-current="page"
                               href="/customer">Customer</a>
                        </li>
                        <li class="nav-item navbar-brand">
                            <a class="nav-link active text-light" aria-current="page"
                               href="#">Employee</a>
                        </li>
                        <li class="nav-item navbar-brand">
                            <a class="nav-link active text-light" aria-current="page" href="/facility">Service</a>
                        </li>
                        <li class="nav-item navbar-brand">
                            <a class="nav-link active text-light" aria-current="page" href="#">Contract</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <div class="col-lg-3"></div>
</div>
</body>
</html>
