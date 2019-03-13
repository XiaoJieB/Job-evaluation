<%--
  Created by IntelliJ IDEA.
  User: 19414
  Date: 2019/3/11
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>login.jsp</title>
    <script src="js/sweet-alert.js"></script>
    <link rel="stylesheet" type="text/css" href="css/sweet-alert.css">
</head>
<body>
<center>
    <form action="login.action" method="post" id="loginForm">
        <span>用户：</span><input name="type" type="radio" checked="checked" value="0"/>学生
        <input name="type" type="radio" value="1"/>老师<br>
        <span>用户名：</span><input type="text" name="number" id="number"/><br>
        <span>密码:</span><input type="password" name="password" id="password"/>
        <input type="submit" value="提交"/>
    </form>
</center>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>

<script type="text/javascript">
  var form = $("#loginForm");
  $(function () {
    form.validate({
      submitHandler: function () {
        if ($('input:radio:checked').val() == "0") {
          $.ajax({
            type: "POST",
            data:{"number":$("#number").val(),"password":$("#password").val()},
            async: false,
            url: "/ssh/student/login.action",
            success:function (data) {
              if(data.code == "0") {
                window.location.href = "/ssh/student/list";
              } else {
                swal("警告",data.msg,"error");
              }
            }
          });
        } else {
          $.ajax({
            type: "POST",
            data:{"number":$("#number").val(),"password":$("#password").val()},
            async: false,
            url: "/ssh/teacher/login.action",
            success:function (data) {
              if(data.code == "0") {
                window.location.href = "/ssh/teacher/list";
              } else {
                swal("警告",data.msg,"error");
              }
            }
          });
        }
        return false;
      },
      rules: {
        number:{
          required:true,
          minlength: 3,
          maxlength:3
        },
        password:{
          required:true,
          // isMobile : true
        }
      },
      messages: {
        number:{
          required:"10位数",
        },
        password:{
          required:"必填",
          // isMobile : "请正确填写手机号码"
        }
      }
    });

  })

</script>
</body>
</html>
