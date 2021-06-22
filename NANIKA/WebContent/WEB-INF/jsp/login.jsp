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
		<link rel="stylesheet" href="/NANIKA/css/login.css">
	</head>
	<body>
		<div class=wrapper>
		<header>
			<h1 class = "logo"><a href="/NANIKA/LoginServlet"><img alt="ロゴ" src="image/logo2.png"></a></h1>
		</header>
		<main>
      <h1 class="h1login">Login</h1>
			<form action="/NANIKA/LoginServlet" method="post" >
       <table class="logintable">
         <tr>
           <th>Email:</th>
           <td>
        <div class="cp_iptxt">
	<input type="text" placeholder="Someone@example.com">
</div>
           </td>
         </tr>
				<tr>
          <th>Password:</th>
          <td>
             <div class="cp_iptxt">
	<input type="text" placeholder="Password">
</div>
          </td>
         </tr>
        </table>
        <p><c:out value="${err}"/></p>
        <a id="loginbtn_cover">
					<input id="loginbtn" type="submit" value="Login">
				</a>
        <form action="/NANIKA/SignupServlet" method="get">
				<a><input type="submit" value="Regist"></a>
			</form>
		</main>
		</div>
	</body>
</html>