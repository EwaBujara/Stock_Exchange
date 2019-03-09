<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/WEB-INF/views/wallet/header.jsp"%>
<title>Your Account</title>
</head>

<body>

<div class="p-3 mb-2 bg-dark text-white text-center container col-6">
    <h4>Your Balance: ${currentUser.getMoney()} PLN</h4>
    <a class="btn btn-info" href="http://localhost:8080/stock/withdraw">Withdraw</a>
    <a class="btn btn-info" href="http://localhost:8080/stock/deposit">Deposit</a>
</div>
</body>
</html>
