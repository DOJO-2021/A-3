<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>LoginPage</title>
		<link rel="stylesheet" href="/NANIKA/css/header.css">
		<link rel="stylesheet" href="/NANIKA/css/common.css">
	</head>
	<body>
		<div class=wrapper>
		<header>
			<h1 class = "logo"><a href="/NANIKA/LoginServlet"><img alt="ロゴ" src="image/logo2.png"></a></h1>
		</header>
		<main>
			<form action="/NANIKA/LoginServlet" method="post" >
				<p><label>E-mail<input type="email" placeholder="someone@example.com" name="EMAIL" class="login"></label></p>
				<p><label>Password<input type="password" placeholder="Password" name="PW" class="login"></label></p>
				<p><c:out value="${err}"/></p>
				<p><input type="submit" value="Login"></p>
			</form>
			<form action="/NANIKA/SignupServlet" method="get">
				<p><input type="submit" value="Regist"></p>
			</form>
		</main>
		</div>
	</body>
</html>