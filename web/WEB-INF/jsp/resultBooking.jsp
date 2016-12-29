<%-- 
    Document   : resultbooking
    Created on : 02.12.2016, 1:28:21
    Author     : Администратор
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css"/>
    <title>Result booking</title>
</head>
<body>
<center>
    <h1>Booking complite!</h1>
    <service>
        <form action="Controller" method="get">
            <input type="hidden" name="cmd" value="continue">
            <table border="1">
                <tr>
                    <td><i><%="Order#" + request.getAttribute("idOrder")%>
                    </i></td>
                    <td><i><%=" " + request.getAttribute("carBrand")%><%=" " + request.getAttribute("carMake")%>
                    </i></td>
                    <td><i><%=" Customer: " + request.getAttribute("fname")%><%=" " + request.getAttribute("lname")%>
                    </i></td>
                    <td><i><%=" " + request.getAttribute("sum") + "$."%>
                    </i></td>
                    <td><i>Start: <%=" " + request.getAttribute("start")%>
                    </i></td>
                    <td><i>End: <%=" " + request.getAttribute("end")%>
                    </i></td>
                    <td><i>Stat: <%=" " + request.getAttribute("stat")%>
                    </i></td>
                </tr>
            </table>

                    <br/>
                    <input type="submit" name="con" value="Continue"/>
                    <input type="submit" name="con" value="End"/>
                </td>
            </tr>
        </form>
        <form name="myaccount" action="Controller" method="post">
            <br/>
            <input type="hidden" name="cmd" value="myaccount">
            <input type="submit" value="My account">
        </form>
    </service>
</center>
</body>
</html>
