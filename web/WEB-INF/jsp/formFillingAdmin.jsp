<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css"/>
    <script type="text/javascript" src="js/formFilling.js"></script>
    <title>Form filling admin</title>
</head>
<body>
<form name="formFil" action="Controller" method="post" onSubmit="return validate_form()">
    <input type="hidden" name="cmd" value="formFillingCar"/>
    <center>
        <table border="0">
            <tr>
                <td>Brand:</td>
                <td><input type="text" name="pw1" value="<%=request.getAttribute("brand")%>" size="15"></td>
            </tr>
            <tr>
                <td>Make:</td>
                <td><input type="text" name="pw2" value="<%=request.getAttribute("make")%>" size="15"></td>
            </tr>
            <tr>
                <td>Equipment:</td>
                <td><input type="text" name="pw3" value="<%=request.getAttribute("equipment")%>" size="15"></td>
            </tr>
            <tr>
                <td>Status:</td>
                <td><input type="text" name="pw4" value="<%=request.getAttribute("stat")%>" size="15"></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" name="pw5" value="<%=request.getAttribute("price")%>" size="15"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Enter"></td>
            </tr>
        </table>
</form>
</body>
</html>
