<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>

<body>
<h1>用户注册</h1>
<p>${param.msg}</p>
<form action="${pageContext.request.contextPath}/user/register" method="post">
    用户名：<input type="text" name="username"/><br/>
    真实姓名：<input type="text" name="realname"><br/>
    密码： <input type="password" name="password"/><br/>
    性别： 男<input type="radio" name="gender" value="true"/>
          女<input type="radio" name="gender" value="false"/><br/>
    验证码： <input type="text" name="code"/> <img src="${pageContext.request.contextPath}/user/generateImageCode" id="anotherPict">
<a href="javascript:;" onclick="document.getElementById('anotherPict').src = '${pageContext.request.contextPath}/user/generateImageCode?' + new Date().getTime()">换一张</a>
    <br/>
    <input type="submit" value="注册"/>

</form>

</body>
</html>