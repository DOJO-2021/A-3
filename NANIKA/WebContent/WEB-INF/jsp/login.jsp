<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginPage</title>
</head>
<body>
<h1><a href="login.jsp"><img alt="ロゴ" src=""></a></h1>
<form action="/NANIKA/LoginServlet" method="post">
<label>E-mail<input type="email" placeholder="someone@example.com" name="EMAIL"></label><br>
<label>Password<input type="password" placeholder="Password" name="PW"></label><br>
<c:out value="${err}"/>
<input type="submit" value="Login"><br>
</form>
<form action="#" method="post">
<input type="submit" value="Regist">
</form>

</body>
</html>