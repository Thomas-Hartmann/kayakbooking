<%-- 
    Document   : login
    Created on : Nov 11, 2016, 12:25:03 AM
    Author     : Thomas Hartmann - tha@cphbusiness.dk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Login" method="POST">
            <input type="text" name="username" placeholder="username" /><br>
            <input type="password" name="password" placeholder="password" /><br>
            <input type="submit" value="log in">
        </form>
    </body>
</html>
