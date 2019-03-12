<%--
  Created by IntelliJ IDEA.
  User: 19414
  Date: 2019/3/11
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
        <span>用户：</span><input type="text" name="type"/><br>
        <span>用户名：</span><input type="text" name="number" id="username"/><br>
        <span>密码:</span><input type="password" name="password" id="password"/>
        <input type="submit" value="提交"/>
    </form>
</center>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>

<script type="text/javascript">
    $(function () {
      var $password = $("#password");

      $("#loginForm").submit(function () {
        if ($("#username").val() == "") {
          swal("Title", "用户名不能为空", "error");
          return false;
        }
        // if ($password.val() == "") {
        //   Dialog.alert("密码不能为空");
        //   return false;
        // }
        // var option = {
        //
        //   success: function (data) {
        //     if (data.result == 'error') {
        //       Dialog.alert(data.content);
        //     } else {
        //     }
        //   }
        // };
        // $(this).ajaxSubmit(option);
        // return false;
      });
    })

</script>
</body>
</html>
