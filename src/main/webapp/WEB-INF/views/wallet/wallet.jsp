<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/WEB-INF/views/wallet/header.jsp"%>
<style>
#div1,#div2{
    display: inline-block;
}
</style>
<title>Your Wallet</title>
</head>

<body>

<div id="div1" class="p-3 mb-2 bg-white text-dark text-center container col-5">
    <table class="table table-striped">
        <tr>
            <th>
                Stock prices
            </th>
        </tr>
        <tr>
            <th>Company</th>
            <th>Price</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${stocks}" var="stock">
            <tr>
                <td>${stock.code}</td>
                <td>${stock.price}</td>
                <td><a class="btn btn-dark" href="http://localhost:8080/SE/stock/${stock.id}">Buy</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

<div id="div2" class="p-3 mb-2 bg-white text-dark text-center container col-6">
    <table class="table table-striped">
        <tr>
            <th>My Wallet</th>
        </tr>
        <tr>
            <th>Company</th>
            <th>Unit price</th>
            <th>Amount</th>
            <th>Value</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${userStocks}" var="userStock">
            <tr>
                <td>${userStock.code}</td>
                <td>${userStock.price}</td>
                <td>${userStock.code}</td>
                <td>${userStock.code}</td>
                <td><a class="btn btn-dark" href="http://localhost:8080/SE/stock/${userStock.id}">Sell</a></td>
            </tr>

        </c:forEach>

        <tr>
            <td>
                <h5>Available money: ${currentUser.money}</h5>
            </td>
        </tr>
    </table>
</div>

</body>
</html>
