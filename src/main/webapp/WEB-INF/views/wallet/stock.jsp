<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/WEB-INF/views/wallet/header.jsp"%>
    <title>Stock Details</title>
</head>
<body>
<div class="p-3 mb-2 bg-dark text-white text-center container col-8">
    <table class="table text-white">
        <tr>
            <th>Name</th>
            <th>Code</th>
            <th>Unit</th>
            <th>Price</th>
            <th>Total Quantity</th>
            <th>Available Quantity</th>
        </tr>
        <tr>
            <td>${stock.name}</td>
            <td>${stock.code}</td>
            <td>${stock.unit}</td>
            <td>${stock.price}</td>
            <td>${stock.totalQuantity}</td>
            <td>${stock.availableQuantity}</td>
        </tr>
    </table>
    <a class="btn btn-info" href="http://localhost:8080/stock/withdraw">Withdraw</a>
    <a class="btn btn-info" href="http://localhost:8080/stock/deposit">Deposit</a>
</div>

</body>
</html>
