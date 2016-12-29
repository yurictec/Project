<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css"/>
</head>
<body>
<center>
    <h1>Table car</h1>
    <form name="adminservice" action="Controller" method="post">
        <table border="1">
            <input type="hidden" name="cmd" value="adminservice"/>
            <c:forEach items="${requestScope.adminList}" var="cars">
            <tr>
                <td><input type="radio" name="carCorr" value="${cars.id}"/>${cars.toString()}</td>
            </tr>
            </c:forEach>
            <tr>
                <td>
                    <input type="submit" value="Correct"/>
                    <br/>
                    <a href="../login.jsp">EXIT</a>
                </td>
            </tr>
    </form>
</center>
</body>
</html>
