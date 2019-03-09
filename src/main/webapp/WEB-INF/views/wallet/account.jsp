<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/WEB-INF/views/wallet/header.jsp"%>
<title>Your Account</title>
</head>

<body>
<div>
    You have: ${currentUser.getMoney()} PLN
</div>
</body>
</html>
