<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link rel="stylesheet" href="../css/style.css" media="screen" type="text/css" />
        <script type="text/javascript" src="../js/registration.js"></script>
        <title>Registration Page</title>
    </head>
    <body>
        <form name="regForm" action="../Controller" method="post" onSubmit="return checkPw(this), validate_form()">
            <input type="hidden" name="cmd" value="registration"/>
            <center>
                <table border="0">
                    <tr>
                        <td>First name: </td><td><input type="text" name="pw3" size="15"></td>
                    </tr><tr>
                        <td>Last name: </td><td><input type="text" name="pw4" size="15"></td>
                    </tr><tr>
                        <td>Email: </td><td><input type="email" name="pw5" size="15"></td>
                    </tr><tr>
                        <td>Password: </td><td><input type="password" name="pw1" size="15"></td>
                    </tr><tr>
                        <td>Confirm password: </td><td><input type="password" name="pw2" size="15"></td>
                    </tr><tr>
                        <td colspan="2" align="center"><input type="submit" value="Enter"></td>
                    </tr>
                </table>
        </form>
    </body>
</html>
