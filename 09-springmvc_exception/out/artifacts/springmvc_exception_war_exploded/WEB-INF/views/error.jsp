<%--
  Created by IntelliJ IDEA.
  User: zengjin
  Date: 2020-6-24
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
服务出错了~~~~~
<div style="display: none"> <%= ((Exception)request.getAttribute("ex")).getMessage()%></div>
</body>
</html>
