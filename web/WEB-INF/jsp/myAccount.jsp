<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your account</title>
</head>
<body>
<center>
    <form name="myAccount" action="Controller" method="get">
        <input type="hidden" name="cmd" value="payment">
        <h1>Table your order</h1>
        <table border="1">
            <c:forEach items="${requestScope.listOrder}" var="list">
                <tr>
                    <td><input type="radio" name="idOrder" value="${list.id}"/>${list.toString()}</td>
                </tr>
            </c:forEach>
        </table>
        <br/>
        <input type="submit" value="Payment">
    </form>
    <form name="continue" action="Controller" method="post">
        <input type="hidden" name="cmd" value="continue">
        <input type="submit" name="con" value="Continue"/>
        <input type="submit" name="con" value="End"/>
    </form>
</center>
</body>
</html>
