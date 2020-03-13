<%--
  Created by IntelliJ IDEA.
  User: win7
  Date: 2020/3/12
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
</head>
<body align="center">
<h1>添 加 学 生</h1>

<form action="addstudent" method="post">
            学生I D:<label>
    <input type="text" name="studentno">
</label><br>
            学生姓名:<label>
    <input type="text" name="studentname">
</label><br>
     <input type="submit" id="submit" value="添加学生">

</form>
</body>
</html>