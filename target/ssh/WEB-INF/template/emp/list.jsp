<%--
  Created by IntelliJ IDEA.
  User: 19414
  Date: 2019/2/25
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="/emps">list all employees</a>

    <c:if test="${empty page}">
        没有任何记录
    </c:if>
</body>
</html>
