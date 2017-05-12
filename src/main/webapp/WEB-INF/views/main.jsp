<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <body>

        <c:if test="${errMsg != null}">
                <p style="color: #f55">Error: ${errMsg}</p>
        </c:if>

        <c:url var="calcAction" value="/calc"/>
        <form action="${calcAction}" method="post">
            <div>
                <p>Input array of integers delimited by ','</p>
                <p>Example: 1,0,2,4,0,5</p>
                <input value="${inputArr}" name="inputArr"/>
             </div>
             <div>
                <input type="submit" value="<spring:message text="Calculate"/>" />
             </div>
        </form>

        <c:if test="${result != null}">
            <p>Result = ${result}</p>
        </c:if>
    </body>
</html>