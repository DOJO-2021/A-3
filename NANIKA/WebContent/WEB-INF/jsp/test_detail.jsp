<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NANIKA | テスト詳細</title>
		<link rel="stylesheet" href="/NANIKA/css/header.css">
		<link rel="stylesheet" href="/NANIKA/css/common.css">
		<link rel="stylesheet" href="/NANIKA/css/test_result_table.css">
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
				<li><a href="/NANIKA/TestSubjectServlet" id="js-menuTab">テスト受験</a></li>
				<li><a href="/NANIKA/UnitServlet" name='${subject_id}' id="subjectTitle">${subjectName}</a></li>
			</ul>
	</div>

	<nav class="menu">
			<ul>
				<li>
					<a href="/NANIKA/HomeServlet">メニュー</a>
				</li>
				<li>
					<a href="/NANIKA/ResultSubjectServlet">テスト結果一覧</a>
				</li>
			</ul>
		</nav>
	<nav class="subjectmenu">
		<c:forEach var="subject" items="${subjectList}">
		<ul>
			<li>
				<a href="/NANIKA/UnitServlet" class="subject"
					name='${subject.subject_id}'><c:out value="${subject.subject}"></c:out></a>
			</li>
		</ul>
		</c:forEach>
	</nav>
	<nav class="unitmenu">
		<c:forEach var="unit" items="${UnitList}">
		<ul>
			<li>
				<a href="/NANIKA/TestServlet" class="js-unit" name='${unit.unit_id}'><c:out value="${unit.unit} " /></a>
			</li>
		</ul>
		</c:forEach>
	</nav>
		<h3><c:out value="${unitName} " />のテスト詳細</h3>
	<table  border= "5" bordercolor ="slateblue">
		<tr>
			<th>回数</th>
			<th>開始時間</th>
			<th>終了時間</th>
			<th>正答率</th>
			<th>合否</th>
		</tr>
		<c:forEach var="scoreall" items="${scoreall}" varStatus="count">
			<form method="POST" action="/NANIKA/TestCommentaryServlet">
			<input type="hidden" name='unit_id' value="${unitId}" >
			<input type="hidden" name='start_time' value="${scoreall.start_time}">
				<tr>
					<td><c:out value="${count.index+1}" /></td>
					<td><c:out value="${scoreall.start_time} " /></td>
					<td><c:out value="${scoreall.end_time} " /></td>
					<td><c:out value="${scoreall.score}" /></td>
					<c:choose>
					<c:when test="${scoreall.result == 0}">
					<td>×</td>
					</c:when>
					<c:when test="${scoreall.result == 1}">
					<td>○</td>
					</c:when>
					</c:choose>
					<td><a class="commentary-btn"><input class="commentary-btn" type="submit" name="REGIST" value="解説"></a></td>
				</tr>
			</form>
		</c:forEach>
	</table>
</div>
	<script src="js/subject.js"></script>
	<script src="js/unit.js"></script>
</body>
</html>