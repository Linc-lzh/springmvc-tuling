<%--
  Created by IntelliJ IDEA.
  User: zengjin
  Date: 2020-6-9
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>简单参数演示</h2>
<form action="${pageContext.request.contextPath}/params03" method="post" enctype="multipart/form-data">
姓名：<input name="name" type="text"> <p></p>
    <input type="submit" value="提交">

</form>

<h2>复杂类型参数演示--List<User></h2>
<form action="${pageContext.request.contextPath}/params02" method="post"  >
    id：<input name="user.id" type="text"> <p></p>
    姓名：<input name="user.name" type="text"> <p></p>
    外号：<input name="user.alias" type="checkbox" value="狗剩" checked>狗剩
          <input name="user.alias" type="checkbox" value="柱子" checked>柱子 <p></p>
    爱好：<input name="user.hobbies[0]" type="checkbox" value="唱歌" checked>唱歌
    <input name="user.hobbies[1]" type="checkbox" value="跳舞" checked>跳舞 <p></p>
    亲属：<input name="user.relatives['father']" type="checkbox" value="爸爸" checked>爸爸
    <input name="user.relatives['mum']" type="checkbox" value="妈妈" checked>妈妈 <p></p>

    角色：<input name="user.role.name" type="text"> <p></p>
    朋友: <input name="user.friends[0].name" type="text" value="张三"><br>
    <input name="user.friends[1].name" type="text" value="李四"><p></p>


    <h2>新增角色</h2>
    id：<input name="role.id" type="text"> <p></p>
    角色：<input name="role.name" type="text"> <p></p>
    <input type="submit" value="提交">
</form>



<h2>复杂类型参数演示--User</h2>
<form action="${pageContext.request.contextPath}/params03" method="post"  >
    id：<input name="id" type="text"> <p></p>
    姓名：<input name="name" type="text"> <p></p>
    外号：<input name="alias" type="checkbox" value="狗剩" checked>狗剩
    <input name="alias" type="checkbox" value="柱子" checked>柱子 <p></p>
    爱好：<input name="hobbies[0]" type="checkbox" value="唱歌" checked>唱歌
    <input name="hobbies[1]" type="checkbox" value="跳舞" checked>跳舞 <p></p>
    亲属：<input name="relatives['father']" type="checkbox" value="爸爸" checked>爸爸
    <input name="relatives['mum']" type="checkbox" value="妈妈" checked>妈妈 <p></p>

    角色：<input name="role.name" type="text"> <p></p>
    朋友: <input name="friends[0].name" type="text" value="张三"><br>
    <input name="friends[1].name" type="text" value="李四"><p></p>


    <input type="submit" value="提交">
</form>

</body>
</html>
