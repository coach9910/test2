<%--
  Created by IntelliJ IDEA.
  User: win7
  Date: 2020/3/12
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>提交作业</title>
</head>
<body align="center">
<h1>提 交 作 业</h1>
<form action="handin" method="post">
    学生学号:<label>
    <input type="text" name="studentno">
</label><br>
    作业序号:<label>
    <input type="text" name="homeworkno">
</label><br>
    作业题目:<label>
    <input type="text" name="homeworktitle">
</label><br>
    作业内容:<label>
    <input type="text" name="homeworkcontent">
</label><br>
    <input type="submit" id="submit" value="上交作业">

</form>
</body>
</html>
