<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>大作业评价系统</title>

    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
</head>
<body>
<div class="container">
    <h1>大作业评价系统-教师管理页面</h1>
    <hr/>
    <h2>当前登陆用户：${teacher.name}</h2>
    <hr/>
    <h3><a href="/admin/teachers/add" type="button" class="btn btn-primary btn-sm">上交作业</a>
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

            <c:forEach items="${teacherList}" var="teacher">
                <tr>
                    <td>${teacher.number}</td>
                    <td>${teacher.name}</td>
                    <td></td>
                    <td></td>
                    <td>
                        <a href="/admin/teachers/show/${teacher.id}" type="button" class="btn btn-sm btn-success">详情</a>
                        <a href="/admin/teachers/update/${teacher.id}" type="button" class="btn btn-sm btn-warning">修改</a>
                        <a href="/admin/teachers/delete/${teacher.id}" type="button" class="btn btn-sm btn-danger">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script>
    // $("#logout").click(function () {
    //   $.ajax({
    //     type: "POST",
    //     async: false,
    //     data:{},
    //     url: "http://localhost:8080/ssh/logout.action"
    //   });
    // })
</script>
</body>
</html>

