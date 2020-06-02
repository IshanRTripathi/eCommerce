<%--
  Created by IntelliJ IDEA.
  User: ishan
  Date: 28-05-2020
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Form</title>
</head>
<body>
<form action="/login" method="post">
    username: <input type="text" name="username" value="Ishan" width="30"/>
    <br>
    password: <input type="password" name="password" value="password" width="30"/>
    <br>
    <input type="submit" value="Login"/>
</form>
</body>
</html>
