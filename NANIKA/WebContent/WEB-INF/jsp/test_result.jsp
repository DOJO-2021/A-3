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
	<p><c:out value="${scorenew.unit}"></c:out>のテスト結果</p>
	<table border="1">
		<tr>
		<td>---</td>
		<td>開始時間</td>
		<td>終了時間</td>
		<td>正解率</td>
		<td>合否</td>
		<td><input type="submit" name="REGIST" value="解説"></td>
		<th>---</th>
		<th>開始時間</th>
		<th>終了時間</th>
		<th>正解率</th>
		<th>合否</th>
		</tr>
		<!--  		<c:forEach var="scoreall" items="${scoreall}">-->
			<form method="POST" action="/NANIKA/TestCommentaryServlet">
			<input type="hidden" name='unit_id' value="${unit_id}" >
			<input type="hidden" name='start_time' value="${scorenew.start_time}">
				<tr>
					<td>---</td>
					<td><c:out value="${scorenew.start_time} " /></td>
					<td><c:out value="${scorenew.end_time} " /></td>
					<td><c:out value="${scorenew.score} " /></td>
					<td><c:out value="${scorenew.result} " /></td>
					<td><input type="submit" name="REGIST" value="解説"></td>
				</tr>
			</form>
		<!--</c:forEach> -->

	</table>
	<br>
	<input type="button" name="REGIST" value="テスト詳細画面">
	<input type="button" name="REGIST" value="ホームに戻る">
	<form method="POST" action="/NANIKA/TestDetailServlet">
	<input type="hidden" name='unit_id' value="${unit_id}" >
		<input type="submit" name="REGIST" value="テスト詳細画面">
	</form>
	<a href= "/NANIKA/HomeServlet">ホームに戻る</a>
</body>
</html>