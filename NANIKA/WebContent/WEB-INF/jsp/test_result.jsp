<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NANIKA</title>
<title>NANIKA | テスト結果簡易表示</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

</head>
<body>
	<h1>テスト結果簡易表示</h1>
	<p><c:out value="${unitName}"></c:out>のテスト結果</p>
	<table border="1">
		<tr>
		<td>回数</td>
		<td>開始時間</td>
		<td>終了時間</td>
		<td>正解率</td>
		<td>合否</td>
		<td>解説</td>
		</tr>
		<c:forEach var="scorenew" items="${scorenew}" varStatus="count">
			<form method="POST" action="/NANIKA/TestCommentaryServlet">
			<input type="hidden" name='unit_id' value="${unitId}" >
			<input type="hidden" name='start_time' value="${scorenew.start_time}">
				<tr>
					<td><c:out value="${count.index+1}" /></td>
					<td><c:out value="${scorenew.start_time} " /></td>
					<td><c:out value="${scorenew.end_time} " /></td>
					<td><c:out value="${scorenew.score} " /></td>
					<c:choose>
					<c:when test="${scorenew.result == 0}">
					<td>×</td>
					</c:when>
					<c:when test="${scorenew.result == 1}">
					<td>○</td>
					</c:when>
					</c:choose>
					<td><input type="submit" name="REGIST" value="解説"></td>
				</tr>
			</form>
		</c:forEach>
	</table>
	<br>
	<form method="get" action="/NANIKA/TestDetailServlet">
		<input type="hidden" name='unit_id' value="${unitId}" >
		<input type="submit" name="REGIST" value="テスト詳細画面">
	</form>
	<a href= "/NANIKA/HomeServlet">ホームに戻る</a>
</body>
</html>