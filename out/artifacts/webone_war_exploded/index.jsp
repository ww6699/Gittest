<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2018/8/8
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>aaa</title>

  </head>
  <body>
<form action="/Servlet1" method="post">
  <input type="button" name="userpass" value="注册" onclick="window.open('/user/Register.html')">
  <input type="button" name="name" value="登录" onclick="window.open('/user/Login.html')">

  <img src="#" id="a">
  <input type="file" id="file" onchange="upload()">

  <input type="submit">
  <script type="text/javascript">
    function upload() {
        var formData= new FormData();
        formData.append("file",$("#file")[0].files[0]);

    }
  </script>


</form>

  </body>
</html>
