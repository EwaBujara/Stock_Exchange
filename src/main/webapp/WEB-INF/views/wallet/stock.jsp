<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/WEB-INF/views/wallet/header.jsp"%>
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
<form:form method="post"
                       action="${pageContext.request.contextPath}/user/registration"
                       modelAttribute="walletItem"
                       cssClass="container col-2" >
    ${stock.unit} x <form:input path="quantity" cssClass="form-input" id="inline2"/>
    <%--<form:errors path="quantity" cssClass="alert alert-danger" element="div"/>--%>
    <p></p>
        <input type="submit" value="Buy!" class="btn btn-dark">
</form:form>

</div>

</body>
</html>
