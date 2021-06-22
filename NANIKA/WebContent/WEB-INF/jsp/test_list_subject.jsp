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
<body>
	<div class="wrapper">
		<header>
			<jsp:include page="/header.jsp" />
		</header>
		<ul class="explorer">
			<li><a href="/NANIKA/HomeServlet">メニュー</a></li> &gt;
			<li><a href="/NANIKA/TestSubjectServlet">テスト受験</a></li>
		</ul>

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
						name='${subject.subject_id}'>${subject.subject}</a>
				</p>
			</c:forEach>
		</nav>
	</div>
	<script src="js/subject.js"></script>
</body>
</html>