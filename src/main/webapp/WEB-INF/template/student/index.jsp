<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>hello</title>
</head>
<body>
hello
您好！${student.number };
<a href="logout.action">退出</a>
success.jsp
<c:if test="${not empty student }">
    ${student.password }
</c:if>
</body>
</html>
