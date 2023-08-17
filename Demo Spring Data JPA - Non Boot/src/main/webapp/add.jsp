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
        <h1>Add new student:</h1>
        <form method="post" action="${pageContext.request.contextPath}/student/add">
            <label>First Name</label>
            <input type="text" name="std_firstname"/> <br/>
            <label>Last Name</label>
            <input type="text" name="std_lastname"/> <br/>
            <label>DOB</label>
            <input type="date" name="std_dob"/> <br/>
            <label>Class</label>
            <select name="std_class_id">
                <c:forEach items="${classList}" var="c">
                    <option value="${c.getId()}">${c.getClassName()}</option>
                </c:forEach>
            </select> <br/>
            <label>Address</label>
            <input type="text" name="std_address"/> <br/>
            <input type="submit" value="Add"/>
        </form>
    </body>
</html>
