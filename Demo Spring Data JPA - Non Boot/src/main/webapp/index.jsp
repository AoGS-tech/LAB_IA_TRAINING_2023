<%-- 
    Document   : index
    Created on : Aug 15, 2023, 10:39:23 AM
    Author     : liquidrekto
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
        <h1>Student Management Demo Data JPA</h1>

        <table>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>DOB</th>
                <th>Class</th>
            </tr>
            <c:forEach items="${studentList}" var="s">
                <tr>
                    <td>ID</td>
                    <td>First Name</td>
                    <td>Last Name</td>
                    <td>DOB</td>
                    <td>Class</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
