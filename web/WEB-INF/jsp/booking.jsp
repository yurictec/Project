<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css"/>
    <title>Booking car</title>
</head>
<body>
<center>
    <h1>Select auto</h1>
    <form name="bookingForm" action="Controller" method="get" onsubmit="">
        <table border="1">
            <input type="hidden" name="cmd" value="booking"/>
            <c:forEach items="${requestScope.userList}" var="cars">
                <tr>
                    <td><input type="radio" name="car" value="${cars.id}"/>${cars.toString()}</td>
                </tr>
            </c:forEach>
            <td>
                Start date of hire cars: <input type="date" value="2015-01-01" name="start">
                End date of hire cars: <input type="date" value="2015-01-01" name="end">
            </td>
            <tr>
                <td>
                    <input type="submit" value="Booking"/>
                </td>
            </tr>
        </table>
    </form>
    <form name="myaccount" action="Controller" method="post">
        <input type="hidden" name="cmd" value="myaccount">
        <input type="submit" value="My account">
    </form>
</center>
</body>
</html>
