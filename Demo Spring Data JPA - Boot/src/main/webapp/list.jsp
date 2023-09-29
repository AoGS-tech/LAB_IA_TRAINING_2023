<%-- 
    Document   : index
    Created on : Aug 15, 2023, 10:39:23 AM
    Author     : liquidrekto
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table {
                border-collapse: collapse;
            }
            td, th {
                width: 10%;
                border: 1px solid black;
                
            }
        </style>
    </head>
    
    <body>
        <h1>Student Management Demo Data JPA</h1>
        <a href="${pageContext.request.contextPath}/student/add">Add new student</a>
        <table>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>DOB</th>
                <th>Address</th>
                <th>Class</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach items="${studentList.getContent()}" var="s">
                <tr>
                    <td>${s.getId()}</td>
                    <td>${s.getFirstName()}</td>
                    <td>${s.getLastName()}</td>
                    <fmt:parseDate value="${s.getDob()}" pattern="yyyy-MM-dd" var="parsedDate" type="date"/>
                    <td><fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${parsedDate}"/></td>
                    <td>${s.getAddress()}</td>
                    <td>${s.getStudentClass().getClassName()}</td>
                    <td><a href="${pageContext.request.contextPath}/student/${s.getId()}">Detail</a></td>
                    <td><a href="${pageContext.request.contextPath}/student/${s.getId()}/delete">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <p>
            <c:if test="${studentList.getNumber() ne 0}">
                <a href="${pageContext.request.contextPath}?offset=${studentList.getNumber()-1}"><</a>
            </c:if>
            
            <c:forEach begin="1" end="${studentList.getTotalPages()}" var="x">
                <c:choose>
                    <c:when test="${studentList.getNumber()+1 eq x}">
                        <b>${x}</b>
                    </c:when>
                    <c:otherwise>
                        <a href="${pageContext.request.contextPath}?offset=${x-1}">${x}</a>
                    </c:otherwise>
                </c:choose>
                        
            </c:forEach>
            
            <c:if test="${studentList.getNumber() ne studentList.getTotalPages() - 1}">
                <a href="${pageContext.request.contextPath}?offset=${studentList.getNumber()+1}">></a>
            </c:if>
        </p>
    </body>
</html>
