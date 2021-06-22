<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NANIKA</title>
<link rel="stylesheet" href="/NANIKA/css/common.css">
<link rel="stylesheet" href="/NANIKA/css/header.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<ul>
	<li><a href="/NANIKA/HomeServlet">メニュー</a></li> &gt;
	<li><a href="/NANIKA/TestSubjectServlet">テスト受験</a></li>
</ul>
<body>
	<div class="wrapper">
		<header>
			<jsp:include page="/header.jsp" />
		</header>

		<nav class="menu">
			<p>
				<a href="/NANIKA/HomeServlet">メニュー</a>
			</p>
			<p>
				<a href="/NANIKA/TestSubjectServlet">テスト受験</a>
			</p>
			<p>
				<a href="/NANIKA/ResultSubjectServlet">テスト結果一覧</a>
			</p>
		</nav>
		<nav>
			<c:forEach var="subject" items="${list}">
				<p>
					<a href="/NANIKA/UnitServlet" class="subject"
						name='${subject.subject_id}'>${subject.subject}</a>
				</p>
			</c:forEach>
			<!--
			<p><a href="/NANIKA/UnitServlet">ネットワーク</a></p>
			<p><a href="/NANIKA/UnitServlet">HTML</a></p>
  			<p><a href="">CSS</a></p>
			<p><a href="">JavaScript</a></p>
			<p><a href="">データベース</a></p>
			<p><a href="">Java</a>
			<p><a href="">品質・セキュリティ</a>
-->
		</nav>
</div>
		<script src="js/subject.js"></script>
</body>
</html>