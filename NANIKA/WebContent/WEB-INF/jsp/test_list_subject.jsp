<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NANIKA | 単元一覧</title>
<link rel="stylesheet" href="/NANIKA/css/common.css">
<link rel="stylesheet" href="/NANIKA/css/header.css">
<link rel="shortcut icon" href="image/nanikafavicon.ico">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
	<div class="wrapper">
		<header>
			<jsp:include page="/header.jsp" />
		</header>

		<div class="explorer">
			<ul>
				<li><a href="/NANIKA/HomeServlet">メニュー</a></li>
				<li><a href="/NANIKA/TestSubjectServlet">テスト受験</a></li>
			</ul>
		</div>
	<main>
		<nav class="menu">
			<ul>
				<li>
					<a href="/NANIKA/HomeServlet">メニュー</a>
				</li>
				<li>
					<a href="/NANIKA/TestSubjectServlet">テスト受験</a>
				</li>
			</ul>
		</nav>
		<nav class="subjectmenu">
			<c:forEach var="subject" items="${subjectList}">
			<ul>
				<li>
					<a href="/NANIKA/UnitServlet" class="subject"
						name='${subject.subject_id}'>${subject.subject}</a>
				</li>
			</ul>
			</c:forEach>
		</nav>
	</main>
		<br>
		<h1>Radar Chart</h1>

		<div id="canvas" style="position: relative; width: 950px; height: 500px; background-color: #488a99; border: ridge 10px; margin: 0 0 0 10px;">
			<canvas id="myRaderChart" style="background-color: #488a99"></canvas>
		</div>

		<div>
			<label>評価（システム）</label>
		</div>
		<hr>
		<div>
			<label>コメント</label>
		</div>

		<hr>
	</div>
	<div style="display: none">
	<div id = "content">総合</div>
		<c:forEach var="list_item" items="${list}">
			<p class="score" style="display: block">${list_item.score}</p>
			<p class="subjectl" style="display: block">${list_item.subject}</p>
			<br>
		</c:forEach>
		<c:forEach var="list_item" items="${subjectList}">
			<p class="subject" style="display: block">${list_item.subject}</p>
			<br>
		</c:forEach>
		<p id="user">${userName}</p>
	</div>
	<!-- CDN -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>
	<!-- レーダーチャート（仮） -->

	<script src="js/rader.js"></script>
	<script src="js/subject.js"></script>
</body>
</html>