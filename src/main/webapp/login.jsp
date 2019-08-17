<%@ page language="java" trimDirectiveWhitespaces="true" contentType="text/html;charset=utf-8" isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/login" method="post">
    UserName:<input type="text" name="userName" value="${user.userName}"/>
    password:<input type="password" name="password" value="${user.password}"/>
    <input type="submit" value="提交"/><font color="red">${errorInfo}</font>
</form>
</body>
</html>
