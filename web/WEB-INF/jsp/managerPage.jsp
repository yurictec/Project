<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css"/>
</head>
<body>
<body>
<center>
    <h1>New orders</h1>
    <form name="tableOrdersForManager" action="Controller" method="post"/>
        <table border="1">
            <input type="hidden" name="cmd" value="managerCorrect"/>
            <c:forEach items="${requestScope.managerList}" var="orders">
                <tr>
                    <td><input type="radio" name="order" value="${orders.id}"/>${orders.toString()}</td>
                </tr>
            </c:forEach>
            <tr>
                <td>
                    <input type="submit" value="Change status"/>
                </td>
            </tr>
        </table>
    </form>
    <form name="continue" action="Controller" method="post">
        <input type="hidden" name="cmd" value="continue"/>
        <br/>
        <input type="submit" name="con" value="End"/>
    </form>
</center>
</body>
</html>
