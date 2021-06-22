<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <!--
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
 -->
 <link rel="stylesheet" href="/NANIKA/css/header.css">


<h1 class="logo">
	<a href="/NANIKA/HomeServlet"><img src="image/logo2.png" alt="NANIKA"></a>
</h1>
<nav class="name">
	<ul>
		<li><c:out value="${userName }" /></li>
		<li><a href="/NANIKA/LoginServlet">ログアウト</a></li>
	</ul>
</nav>