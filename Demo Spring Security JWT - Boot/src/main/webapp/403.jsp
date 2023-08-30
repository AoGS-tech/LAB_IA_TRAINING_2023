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
        <h1 class="mt-4 text-danger">Access denied</h1>
        <p>Sorry, you don't have permissions to access this page!</p>
        <a href="${pageContext.request.contextPath}/" type="button" class="my-2 btn btn-danger"> Go back to home </a>
    </body>
</html>
