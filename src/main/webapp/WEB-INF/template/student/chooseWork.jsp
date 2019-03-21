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
    <script src="/ssh/js/jquery.min.js"></script>
    <script src="/ssh/js/bootstrap.js"></script>
</head>
<body>
<div class="container">
    <h1>大作业评价系统-学生操作页面</h1>
    <hr/>
    <h2>当前登陆用户：${work.name}</h2>
    <hr/>
    <h3>
        <a href="#" id="chooseWork" type="button" class="btn btn-primary btn-sm">选择课题</a>
        <a href="#" id="addBigWork" type="button" class="btn btn-primary btn-sm">上交作业</a>
        <a href="/report/export" type="button" class="btn btn-primary btn-sm">作业浏览</a>
        <a href="/ssh/work/list" type="button" class="btn btn-primary btn-sm">互评</a>
        <a href="/report/export" type="button" class="btn btn-primary btn-sm">查看</a>
        <a href="/ssh/logout" type="button" class="btn btn-primary btn-sm">退出</a>
    </h3>

    <table class="table table-bordered table-striped">
        <tr>
            <th style="display: none">ID</th>
            <th>课题名称</th>
            <th>导师</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${workList}" var="work">
            <tr>
                <td style="display: none">${work.id}</td>
                <td>${work.name}</td>
                <td>${work.teacher.name}</td>
                <td>
                    <a href="/admin/works/show/${work.id}" type="button" class="btn btn-sm btn-success">选题</a>
                    <a href="/admin/works/show/${work.id}" type="button" class="btn btn-sm btn-success">详情</a>

                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<script>
  registerEvent();

  function registerEvent() {
    $("#addBigWork").click(function () {
      window.location.href = "/ssh/work/addBigWork?workId=" + ${work.id};
    })
  }
</script>
</body>
</html>

