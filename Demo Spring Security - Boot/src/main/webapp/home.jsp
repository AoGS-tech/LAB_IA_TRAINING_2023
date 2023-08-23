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
        <h1 class="mt-4">Welcome to my page!</h1>
        <c:if test="${user eq null}">
            <p> It seems like you haven't been logged in yet </p>
            <a href="${pageContext.request.contextPath}/login" type="button" class="btn btn-primary"> Login now </a>
        </c:if>
        <c:if test="${user ne null}">
            <p> Glad to see you, <span class="text-info">${user}</span>!</p>
            <a href="${pageContext.request.contextPath}/logout" type="button" class="btn btn-danger"> Log out </a>
        </c:if>
        
    </body>
</html>
