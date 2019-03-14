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
    <link href="/ssh/css/jquery-accordion-menu.css" rel="stylesheet" type="text/css" />
    <link href="/ssh/css/font-awesome.css" rel="stylesheet" type="text/css" />

        <style type="text/css">
                              *{box-sizing:border-box;-moz-box-sizing:border-box;-webkit-box-sizing:border-box;}
        body{background:#f0f0f0;}
        .content{width:260px;margin:20px auto;}
        #demo-list a{
            overflow:hidden;
            text-overflow:ellipsis;
            -o-text-overflow:ellipsis;
            white-space:nowrap;
            width:100%;
        }
    </style>


</head>
<body>
<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <h1>大作业评价系统-教师管理页面</h1>
        <hr/>
        <h2>当前登陆用户：${teacher.name}</h2>
        <hr/>
    </div>
</div>


<div class="row">
    <div class="col-md-3 content">
        <div id="jquery-accordion-menu" class="jquery-accordion-menu white">
        <div class="jquery-accordion-menu-header" id="form"></div>
        <ul id="demo-list">
            <li><a href="#"><i class="fa fa-cog"></i>作业管理</a>
                <ul class="submenu">
                    <li><a href="#">发布作业</a></li>
                    <li><a href="#">修改作业</a>
                        <%--<ul class="submenu">--%>
                            <%--<li><a href="#">Photoshop </a></li>--%>
                            <%--<li><a href="#">Fonts </a></li>--%>
                        <%--</ul>--%>
                    </li>
                    <li><a href="#">删除作业</a></li>
                    <li><a href="#">上传控制</a></li>
                    <li><a href="#">评价控制</a></li>
                </ul>
            </li>

            <li><a href="#"><i class="fa fa-cog"></i>信息管理</a>
                <ul class="submenu">
                    <li><a href="#">发布信息</a></li>
                    <li><a href="#">修改信息</a></li>
                    <li><a href="#">删除信息</a></li>
                </ul>
            </li>

            <li><a href="#"><i class="fa fa-cog"></i>评价统计</a>
                <ul class="submenu">
                    <li><a href="#">评价学生</a></li>
                    <li><a href="#">统计</a></li>
                </ul>
            </li>
        </ul>
        <div class="jquery-accordion-menu-footer">
            Footer
        </div>
    </div>
    </div>
    <div class="col-md-8  col-md-offset-1 container">
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
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/ssh/js/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/ssh/js/bootstrap.js"></script>

<script src="/ssh/js/jquery-accordion-menu.js" type="text/javascript"></script>

<script type="text/javascript">
  jQuery("#jquery-accordion-menu").jqueryAccordionMenu();
</script>

<script type="text/javascript">
  $(function(){
    //顶部导航切换
    $("#demo-list li").click(function(){
      $("#demo-list li.active").removeClass("active")
      $(this).addClass("active");
    })
  })
</script>
</body>
</html>
