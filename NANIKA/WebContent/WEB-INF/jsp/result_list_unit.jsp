<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NANIKA | 単元一覧</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<ul>
	<li><a href="/NANIKA/HomeServlet">メニュー</a></li>
	<li><a href="/NANIKA/ResultSubjectServlet" id="js-menuTab">テスト結果一覧</a></li>
	<li><a href="/NANIKA/UnitServlet" id="subjectTitle" name='${subject_id}'>${subjectName}</a></li>
</ul>
<body>
	<nav>
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
					name='${subject.subject_id}'><c:out value="${subject.subject}"></c:out></a>
			</p>
		</c:forEach>
	</nav>
	<nav>
		<c:forEach var="unit" items="${UnitList}">
			<p>
				<a href="/NANIKA/TestDetailServlet" class="js-unit" name='${unit.unit_id}'><c:out value="${unit.unit} " /></a>
			</p>
		</c:forEach>
	</nav>
	<script src="js/subject.js"></script>
	<script src="js/unit.js"></script>
</body>
</html>