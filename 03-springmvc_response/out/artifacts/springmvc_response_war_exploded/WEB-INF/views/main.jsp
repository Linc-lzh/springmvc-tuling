<%--
  Created by IntelliJ IDEA.
  User: zengjin
  Date: 2020-6-14
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    测试 :${requestScope.type}
    <p></p>
    session获取：${sessionScope.type}
<p></p>
用户:${requestScope.user}

</body>
</html>
