<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NANIKA | 単元一覧</title>
<link rel="stylesheet" href="/NANIKA/css/header.css">
<link rel="stylesheet" href="/NANIKA/css/common.css">
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
				<li><a href="/NANIKA/ResultSubjectServlet" id="js-menuTab">テスト結果一覧</a></li>
				<li><a href="/NANIKA/UnitServlet" id="subjectTitle"
					name='${subject_id}'>${subjectName}</a></li>
			</ul>
		</div>
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
		<nav class="subjectmenu">
			<c:forEach var="subject" items="${subjectList}">
				<p>
					<a href="/NANIKA/UnitServlet" class="subject"
						name='${subject.subject_id}'><c:out value="${subject.subject}"></c:out></a>
				</p>
			</c:forEach>
		</nav>
		<nav class="unitmenu">
			<c:forEach var="unit" items="${UnitList}">
				<p>
					<a href="/NANIKA/TestDetailServlet" class="js-unit"
						name='${unit.unit_id}'><c:out value="${unit.unit} " /></a>
				</p>
			</c:forEach>
		</nav>
		<hr>
		<canvas id="myRaderChart" style="background-color: #fff"></canvas>
		<hr>
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
	<script src="js/unit.js"></script>
</body>
</html>