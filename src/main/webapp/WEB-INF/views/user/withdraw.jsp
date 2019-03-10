<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<form method="post"
      action="${pageContext.request.contextPath}/account/withdraw"
      class="container col-4" >

    <input name="withdraw" placeholder="Withdraw" class="form-input"/>
    <input type="submit" value="Enter" class="btn btn-dark">
</form>
</body>
</html>
