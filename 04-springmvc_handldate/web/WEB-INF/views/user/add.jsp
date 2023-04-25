<%@ page import="cn.tulingxueyuan.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: zengjin
  Date: 2020-6-18
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>

<h1>添加用户</h1>

<form action="${pageContext.request.contextPath}/user" method="post" >
<%--  private Integer id;
    private String username;
    private Date birthday;
    private Double balance;   //￥5000
    private String[] hobbies;
    private Double salary; //工资  10,000.00
    private Double taskCount;// 任务完成百分比 90%--%>
    <p>
        id:<input type="text" name="id" value="${user.id}">${errors.id}
    </p>
    <p>
        username:<input type="text" name="username" value="${user.username}"> ${errors.username}
    </p>
    <p>
        birthday:<input type="text" name="birthday"  value="${user.birthday}">${errors.birthday}
    </p>
    <p>
        balance:<input type="text" name="balance" value="${user.balance}">${errors.balance}
    </p>
    <p>
        salary:<input type="text" name="salary" value="${user.salary}">${errors.salary}
    </p>
    <p>
        taskCount:<input type="text" name="taskCount" value="${user.taskCount}">${errors.taskCount}
    </p>
    <p>
        hobbies:
        <input type="checkbox" name="hobbies" value="唱歌"  >唱歌
        <input type="checkbox" name="hobbies" value="跳舞">跳舞
    </p>
    <p>

        <input type="submit" value="提交">
    </p>
</form>





<form:form action="${pageContext.request.contextPath}/form/user" method="post"  modelAttribute="user" >
    <p>
        id: <form:input path="id"></form:input><form:errors path="id"></form:errors>
    </p>
    <p>
        username: <form:input path="username"></form:input><form:errors path="username"></form:errors>
    </p>
    <p>
        birthday:<form:input path="birthday"></form:input><form:errors path="birthday"></form:errors>
    </p>
    <p>
        balance:<form:input path="balance"></form:input><form:errors path="balance"></form:errors>
    </p>
    <p>
        salary:<form:input path="salary"></form:input><form:errors path="salary"></form:errors>
    </p>
    <p>
        taskCount:<form:input path="taskCount"></form:input><form:errors path="taskCount"></form:errors>
    </p>
    <p>
        hobbies:
        <%--静态数据源--%>
        <form:checkbox path="hobbies" value="唱歌"></form:checkbox>
        <form:label path="hobbies">唱歌</form:label>
        <form:checkbox path="hobbies" value="跳舞"></form:checkbox>
        <form:label path="hobbies">跳舞</form:label>
<hr>
        <%--动态数据源--%>
        <form:checkboxes path="hobbies" items="${list}"></form:checkboxes>
        
        <%--<form:select path="hobbies"></form:select>--%>
    </p>
    <p>
        <form:button>提交</form:button>
        <input type="submit" value="提交">
    </p>
</form:form>


<%--spring 的form标签库是支持put 和delete的提交的--%>

<form:form  method="put" >
    11111111111
</form:form>
</body>
</html>
