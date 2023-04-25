<%--
  Created by IntelliJ IDEA.
  User: zengjin
  Date: 2020-6-11
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setAttribute("basepath",request.getContextPath()); %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${basepath}/rest/user/1" method="get">
    <input type="submit" value="查询">
</form>


<form action="${basepath}/rest/user" method="post">
    id：<input name="id" type="text"> <p></p>
    姓名：<input name="name" type="text"> <p></p>
    <input type="submit" value="新增">
</form>

<form action="${basepath}/rest/user/1" method="post">  <%--method默认是get--%>
    <input type="hidden" value="put" name="_method">
    id：<input name="id" type="text"> <p></p>
    姓名：<input name="name" type="text"> <p></p>
    <input type="submit" value="修改">
</form>

<form action="${basepath}/rest/user/1" method="post">
    <input type="hidden" value="delete" name="_method">
    <input type="submit" value="删除">
</form>


</body>
</html>
