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
        <h1 class="mt-4">FPT School Management System</h1>
        <c:if test="${user eq null}">
            <p>Please sign in to access the dashboard</p>
            <a href="${pageContext.request.contextPath}/login" type="button" class="btn btn-primary"> Login now </a>
            <a href="${pageContext.request.contextPath}/register" type="button" class="btn btn-light"> Register account </a>
        </c:if>
        <c:if test="${user ne null}">
            <p> Glad to see you back, <span class="text-info">${user}</span> with roles 
                <c:forEach items="${roles}" var="r" varStatus="status">
                    <span class="text-info">${r}</span>
                    <c:if test="${!status.last}">
                        ,
                    </c:if>
                </c:forEach>
                !</p>
            <a href="${pageContext.request.contextPath}/admin/facilities" type="button" class="my-2 btn btn-light"> Facility management </a> <br/>
            <a href="${pageContext.request.contextPath}/teacher/takeattendance" type="button" class="my-2 btn btn-light"> Take attendance </a> <br/>
            <a href="${pageContext.request.contextPath}/student/registerclass" type="button" class="my-2 btn btn-light"> Register class </a> <br/>
            <a href="${pageContext.request.contextPath}/profile" type="button" class="my-2 btn btn-light"> View profile </a> <br/>
            <a href="${pageContext.request.contextPath}/logout" type="button" class="my-2 btn btn-danger"> Log out </a>
        </c:if>
        
    </body>
</html>
