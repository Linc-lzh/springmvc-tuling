<%--
  Created by IntelliJ IDEA.
  User: zengjin
  Date: 2020-6-20
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
   <a href="${pageContext.request.contextPath}/download">文件下载</a>

   <form enctype="multipart/form-data" action="${pageContext.request.contextPath}/upload01" method="post">
     <p>文件描述：<input type="text" name="desc" /></p>
     <p>文件：<input type="file" name="myfile" multiple accept="image/*"/></p>
     <p><input type="submit" value="上传单个文件"></p>
   </form>
   <hr>
  <form enctype="multipart/form-data" action="${pageContext.request.contextPath}/upload03" method="post">
    <p>文件描述：<input type="text" name="desc" /></p>
    <p>文件：<input type="file" name="myfile" multiple accept="image/*"/></p>
    <p><input type="submit" value="上传多个文件"></p>
  </form>

  </body>
</html>
