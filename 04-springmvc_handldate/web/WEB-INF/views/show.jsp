<%--
  Created by IntelliJ IDEA.
  User: zengjin
  Date: 2020-6-17
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--spring 标签库--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    id:${user.id}
</p>
<p>
    username:${user.username}
</p>
<p>
    birthday:<%--${user.birthday}--%>
    <%--显示格式化
    jstl标签库 fmt:formate   pattern
    --%>
    <spring:eval expression="user.birthday"></spring:eval>
</p>
<p>
    balance:  <spring:eval expression="user.balance"></spring:eval>
</p>
<p>
    <%--<spring:eval  一般用来显示格式化后的数据--%>
    salary:<spring:eval expression="user.salary"></spring:eval>
</p>
<p>
    taskCount:<spring:eval expression="user.taskCount"></spring:eval>
</p>
<p>
    hobbies:<spring:eval expression="user.hobbies"></spring:eval>  <%--1,2,3--%>
</p>
</body>
</html>
