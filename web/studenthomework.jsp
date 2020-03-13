<%@ page import="java.util.List" %>
<%@ page import="com.java.code.class1.model.StudentHomework" %>
<%@ page import="com.java.code.class1.jdbc.StudentHomeworkJdbc" %>
<%--
  Created by IntelliJ IDEA.
  User: win7
  Date: 2020/3/9
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StudentHomework</title>
</head>
<body>
<table align="center" width="960" border="1"
       bgcolor="black" cellpadding="1" cellspacing="1">
    <tr align="center" bgcolor="#7fffd4" height="50">
        <td>ID</td>
        <td>作业编号</td>
        <td>学生学号</td>
        <td>作业标题</td>
        <td>作业内容</td>
    </tr>
    <%
      List<StudentHomework> list = StudentHomeworkJdbc.selectALL();
      if(null == list || list.size() <= 0){
        out.print("None data.");
      }else {
        for (StudentHomework sh : list){
    %>
    <tr align="center" bgcolor="white" height="30">
        <td><%=sh.getNo()%></td>
        <td><%=sh.getHno()%></td>
        <td><%=sh.getSno()%></td>
        <td><%=sh.getHtitle()%></td>
        <td><%=sh.getHcontent()%></td>
    </tr>
        <%
        }
      }
    %>
</table>
</body>
</html>
