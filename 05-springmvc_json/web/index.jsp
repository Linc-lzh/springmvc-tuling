<%--
  Created by IntelliJ IDEA.
  User: zengjin
  Date: 2020-6-19
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="https://cdn.staticfile.org/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript">
      // 也没加载事件简写方式
      $(function(){

        $("#btnJson1").click(function(){
          $.ajax({
            url:"${pageContext.request.contextPath}/json/request01",
            method:"post",
            data:"张三",
            contentType:'application/json',
            dataType:"json",
            success:function(user){
              alert(user.name);
            }
          });
        });



        $("#btnJson2").click(function(){

          var user={'id':'1','name':'张三'};   // 定义js对象
          var jsonValue=JSON.stringify(user); // 对象转换为json字符串
          console.log(jsonValue)
          $.ajax({
            url:"${pageContext.request.contextPath}/json/request02",
            method:"post",
            data:'{"id":"1","name":"张三","birthady":"2019-01-01"}',
            contentType:'application/json',
            dataType:"json",
            success:function(user){
              alert(user.name);
            }
          });
        });


        $("#btnJson3").click(function(){

          $.ajax({
            url:"${pageContext.request.contextPath}/json/request03",
            method:"post",
            data:'{"idxx":"1","namexx":"张三","birthadyxx":"2019-01-01"}',
            contentType:'application/json',
            dataType:"json",
            success:function(user){
              alert(user.name);
            }
          });
        });


        $("#btnJson4").click(function(){
          var listUser=new Array();
          var user1={"id":"1","name":"张三","birthady":"2019-01-01"};
          var user2={"id":"2","name":"李四","birthady":"2019-01-01"};
          listUser.push(user1)
          listUser.push(user2)

          $.ajax({
            url:"${pageContext.request.contextPath}/json/request04",
            method:"put",
            //data:'[{"id":"1","name":"张三","birthady":"2019-01-01"},{"id":"2","name":"李四","birthady":"2019-01-01"}]',
            data:JSON.stringify(listUser),
            contentType:'application/json',
            dataType:"json",
            success:function(user){
              alert(user.name);
            }
          });
        });

      })

    </script>
  </head>
  <body>
<input type="button" value="发送单个参数的json数据" id="btnJson1"/><br/>
<input type="button" value="发送对象的json数据用javaBean接收" id="btnJson2"/><br/>
<input type="button" value="发送对象的json数据用Map接收" id="btnJson3"/><br/>
<input type="button" value="发送数组对象的json数据用List<User>接收" id="btnJson4"/><br/>
  </body>
</html>
