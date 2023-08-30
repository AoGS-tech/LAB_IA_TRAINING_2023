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
        <%@include file="common.jsp" %>
    </head>
    <body class="text-center">
        <h1>Login</h1>
        <c:if test="${not empty param['error']}">
            <p style="color:red">Incorrect username or password!</p>
        </c:if>
        <form class="w-25 my-0 mx-auto text-left" action="login-process" method="POST">
            <div class="form-group">
                <label for="exampleInputUsername">Username</label>
                <input type="text" name="username" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter username...">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword">Password</label>
                <input type="password" name="password" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter password...">
            </div>
            <input class="btn btn-primary" type="submit" value="Login"/>
        </form>

    </body>
</html>
