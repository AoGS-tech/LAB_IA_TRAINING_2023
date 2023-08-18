<%-- 
    Document   : detail
    Created on : Aug 17, 2023, 12:39:32 PM
    Author     : WINDOWS
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Detailed information of student with id ${student.getId()}:</h1>
        <form method="post" action="${pageContext.request.contextPath}/student/${student.getId()}">
            <label>First Name</label>
            <input type="text" name="std_firstname" value="${student.getFirstName()}"/> <br/>
            <label>Last Name</label>
            <input type="text" name="std_lastname" value="${student.getLastName()}"/> <br/>
            <label>DOB</label>
            <input type="date" name="std_dob" value="${student.getDob()}"/> <br/>
            <label>Class</label>
            <select name="std_class_id">
                <c:forEach items="${classList}" var="c">
                    <option value="${c.getId()}" <c:if test="${student.getStudentClass().getId() eq c.getId()}">selected</c:if>>${c.getClassName()}</option>
                </c:forEach>
            </select> <br/>
            <label>Address</label>
            <input type="text" name="std_address" value="${student.getAddress()}"/> <br/>
            <input type="submit" value="Update"/>
        </form>
    </body>
</html>
