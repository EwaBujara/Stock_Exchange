<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/WEB-INF/views/wallet/header.jsp"%>
    <title>Deposit</title>
    <%--<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">--%>
    <style>
        input{
            display: block;
            margin:15px 0;
            width: 100%;
        }
    </style>
</head>
<body class="p-3 mb-2 bg-white text-dark">
<div class="p-3 mb-2 bg-dark text-white text-center container col-6">
    <h4>Your Balance: ${currentUser.getMoney()} PLN</h4>
    <h4>Your Balance: <fmt:formatNumber type = "number"
                                        maxFractionDigits = "2" value = "${currentUser.getMoney()}}"/> PLN</h4>
</div>
<form method="post"
           action="${pageContext.request.contextPath}/account/deposit"
           class="container col-4" >

    <input name="deposit" placeholder="Deposit" class="form-input"/>
    <input type="submit" value="Enter" class="btn btn-dark">
</form>
</body>
</html>
