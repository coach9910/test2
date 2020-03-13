<%--
  Created by IntelliJ IDEA.
  User: win7
  Date: 2020/3/9
  Time: 0:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>作业管理系统</title>
  </head>
  <body align = "center">

   <h1>作 业 管 理 系 统</h1>
   <br><br>
     <input type = "button" value = "添加学生" style="width:160px;height: 60px;font-size:16px" onclick = "window.location.href = 'student.jsp'">
  <br><br>
     <input type = "button" value = "添加作业" style="width:160px;height: 60px;font-size:16px" onclick = "window.location.href = 'homework.jsp'">
  <br><br>
     <input type = "button" value = "提交作业" style="width:160px;height: 60px;font-size:16px" onclick = "window.location.href = 'handin.jsp'">
  <br><br>
     <input type = "button" value = "显示作业提交情况" style="width:160px;height: 60px;font-size:16px" onclick = "window.location.href = 'studenthomework.jsp'">

  </body>
</html>
