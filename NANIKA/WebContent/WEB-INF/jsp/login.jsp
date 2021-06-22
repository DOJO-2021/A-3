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
			<h1 class = "logo"><a href="/NANIKA/LoginServlet"><img alt="ロゴ" src="image/logo3.png"></a></h1>
		</header>
		<main>
      <h1 class="h1login"><b>Login</b></h1>
			<form action="/NANIKA/LoginServlet" method="post" >
       <table class="logintable">
         <tr>
           <th>Email:</th>
           <td>
        <div class="cp_iptxt">
	<input type="text" placeholder="Someone@example.com" name="EMAIL" class="login">
</div>
           </td>
         </tr>
				<tr>
          <th>Password:</th>
          <td>
             <div class="cp_iptxt">
	<input type="password" placeholder="Password" name="PW" class="login">
</div>
          </td>
         </tr>
        </table>
        <p class="error"><c:out value="${err}"/></p>
        <div class="submitbtn">
	        <a class="custom-btn btn">
						<input class="custom-btn btn" type="submit" value="Login">
					</a>
	        <form action="/NANIKA/SignupServlet" method="get">
					<a class="custom-btn btn"><input type="submit" value="Regist" class="custom-btn btn"></a>
			</form>
		</div>
		</main>
		</div>
	</body>
</html>