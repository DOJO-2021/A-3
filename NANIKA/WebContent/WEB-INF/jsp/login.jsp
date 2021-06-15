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
			<p><label>E-mail<input type="email" placeholder="someone@example.com" name="EMAIL"></label></p>
			<p><label>Password<input type="password" placeholder="Password" name="PW"></label></p>
			<p><c:out value="${err}"/></p>
			<p><input type="submit" value="Login"></p>
		</form>
		<form action="/NANIKA/SignupServlet" method="get">
			<p><input type="submit" value="Regist"></p>
		</form>
	</body>
</html>