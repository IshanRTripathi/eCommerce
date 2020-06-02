<%--
  Created by IntelliJ IDEA.
  User: itripathi
  Date: 31-May-20
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>You've been logged out</title>
</head>
<body>
<%=
    session.invalidate();
%>
<h1>You've been logged out<br>Login <a href="login.jsp"> here</a></h1>
</body>
</html>
