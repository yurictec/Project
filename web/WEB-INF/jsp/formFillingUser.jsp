<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css"/>
    <script type="text/javascript" src="js/formFilling.js"></script>
    <title>Form filling</title>
</head>
<body>
<form name="formFil" action="Controller" method="post" onSubmit="return validate_form()">
    <input type="hidden" name="cmd" value="formFilling"/>
    <center>
        <table border="0">
            <tr>
                <td>First name:</td>
                <td><input type="text" name="pw1" value="<%=request.getAttribute("fname")%>" size="15"></td>
            </tr>
            <tr>
                <td>Last name:</td>
                <td><input type="text" name="pw2" value="<%=request.getAttribute("lname")%>" size="15"></td>
            </tr>
                <input type="hidden" name="pw3" value="<%=request.getAttribute("email")%>" size="15">
            <tr>
                <td>Age:</td>
                <td><input type="text" name="pw4" value="<%=request.getAttribute("age")%>" size="15"></td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td><input type="text" name="pw5" value="<%=request.getAttribute("phone")%>" size="15"></td>
            </tr>
            <tr>
                <td>Car:</td>
                <td><input type="text" name="pw6" value="<%=request.getAttribute("car")%>" size="15"></td>
            </tr>
            <tr>
                <td>Start:</td>
                <td><input type="text" name="pw7" value="<%=request.getAttribute("start")%>" size="15"></td>
            </tr>
            <tr>
                <td>End:</td>
                <td><input type="text" name="pw8" value="<%=request.getAttribute("end")%>" size="15"></td>
            </tr>
            <tr>
                <td>Sum: </td>
                <td><input type="text" name="pw9" value="<%=request.getAttribute("sum")%>" size="15"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Enter"></td>
            </tr>
        </table>
</form>
</body>
</html>
