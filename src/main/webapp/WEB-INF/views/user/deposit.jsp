<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deposit</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <style>
        input, select{
            display: block;
            margin:15px 0;
            width: 100%;
        }
    </style>
    <div class="p-3 mb-2 bg-dark text-white">
        <h3 class="text-center">Enjoy Stock Exchange!</h3>
    </div>
</head>
<body class="p-3 mb-2 bg-info text-white">

<form method="post"
           action="${pageContext.request.contextPath}/account/deposit"
           class="container col-6" >

    <input name="deposit" placeholder="Deposit" class="form-input"/>
    <input type="submit" value="Enter" class="btn btn-dark">
</form>
</body>
</html>
