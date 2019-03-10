<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/WEB-INF/views/wallet/header.jsp"%>
<style>
    input{
        display: block;
        margin:15px 0;
        width: 100%;
    }
</style>
    <title>Stock Details</title>
</head>
<body>
<div class="p-3 mb-2 bg-white text-dark text-center container col-8">
    <table class="table table-striped">
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
</div>
<div class="p-3 mb-2 bg-dark text-white text-center container col-8">
    <form method="post" action="${pageContext.request.contextPath}/SE/${action}/${stock.id}" class="container col-2" >

    ${stock.unit} x <input name="quantity" placeholder="Enter Integer" class="form-input"/>
        <input type="submit" value="${submit}" class="btn btn-info">
    </form>
</div>


</body>
</html>
