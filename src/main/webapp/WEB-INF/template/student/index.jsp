<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>大作业评价系统</title>

    <link rel="stylesheet" href="/ssh/css/bootstrap.css">

</head>
<body>
<div class="container">
    <h1>大作业评价系统-学生操作页面</h1>
    <hr/>
    <h2>当前登陆用户：${student.name}</h2>
    <hr/>
    <h3><a href="/admin/students/add" type="button" class="btn btn-primary btn-sm">上交作业</a>
        <a href="/report/export" type="button" class="btn btn-primary btn-sm">作业浏览</a>
        <a href="/report/export" type="button" class="btn btn-primary btn-sm">互评</a>
        <a href="/report/export" type="button" class="btn btn-primary btn-sm">查看</a>
        <a href="/ssh/logout" type="button" class="btn btn-primary btn-sm">退出</a>
    </h3>

        <table class="table table-bordered table-striped">
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>作业</th>
                <th>分数</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${studentList}" var="student">
                <tr>
                    <td>${student.number}</td>
                    <td>${student.name}</td>
                    <td></td>
                    <td></td>
                    <td>
                        <a href="/admin/students/show/${student.id}" type="button" class="btn btn-sm btn-success">详情</a>
                        <a href="/admin/students/update/${student.id}" type="button" class="btn btn-sm btn-warning">修改</a>
                        <a href="/admin/students/delete/${student.id}" type="button" class="btn btn-sm btn-danger">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
</div>

<script src="/ssh/js/jquery.min.js"></script>
<script src="/ssh/js/bootstrap.js"></script>
</body>
</html>

