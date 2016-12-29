<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css"/>
    <title>Form filling manager</title>
</head>
<body>
<center>
    <h1>New orders</h1>
    <service>
        <form action="Controller" method="post">
            <input type="hidden" name="cmd" value="changeStatus">
            <input type="hidden" name="idOrder" value="<%=request.getAttribute("idOrder")%>">
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
                    <td><i>Stat: <%=" " + request.getAttribute("stat")%>
                    </i></td>
                </tr>
                <tr>
                    <td>
                        <input type="radio" name="status" value="approved"><i>Approved</i>
                    </td>
                    <td>
                        <input type="radio" name="status" value="failure"><i>Failure</i>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Change status"/>
                    </td>
                </tr>
            </table>
        </form>
        <form name="continue" action="Controller" method="post">
            <br/>
            <input type="hidden" name="cmd" value="continue">
            <br/>
            <input type="submit" name="con" value="Continue"/>
            <input type="submit" name="con" value="End"/>
        </form>
    </service>
</center>
</body>
</html>
