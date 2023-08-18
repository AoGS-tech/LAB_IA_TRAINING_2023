<%-- 
    Document   : add
    Created on : Aug 17, 2023, 12:36:07 PM
    Author     : WINDOWS
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="POST">
            <label>Username:</label>
            <input type="text" name="username"/> <br/>
            <label>Password:</label>
            <input type="password" name="password"/> <br/>
            <input type="submit" value="Login"/>
        </form>
        
    </body>
</html>
