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
		<td>---</td>
		<td>開始時間</td>
		<td>終了時間</td>
		<td>正解率</td>
		<td>合否</td>
		</tr>
		<form >

		</form>
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