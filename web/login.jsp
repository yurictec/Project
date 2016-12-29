<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/login.js"></script>
        <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
        <title>Login</title>
    </head>
    <body>
    <center>
        <h1>Welcome! Please enter your login and password</h1>
    </center>
    <form name="loginForm" action="Controller" method="post" onsubmit="return validate_form()" >
            <center>
                <table border="0">
                    <input type="hidden" name="cmd" value="login"/>
                    <tr>
                        <td>Email:<td/><td><input type="email" name="email" value="" size="15"/><td/>
                    <tr/>
                    <tr>
                        <td>Password:<td/><td><input type="password" name="pass" value="" size="15"/><td/>
                    <tr/>
                    <tr>
                        <td colspan="" align="center"><td/><td><input type="submit" value="Enter"/><td/>
                    <tr/>
                <table/>
            <center/>
    </form>
        <a id="link" href="/registration.jsp"><h1>Registration</h1></a>
    </body>
</html>
