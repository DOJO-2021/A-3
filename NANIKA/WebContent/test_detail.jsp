<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>テスト詳細画面</title>
</head>
<body>
	<h3>のテスト詳細</h3>
	<c:forEach var = "i" begin = "0" end = "9" step = "1">
	<table frame="box">
		<tr>
		<td>---</td>
		<td></td>
		<td>開始時間</td>
		<td>終了時間</td>
		<td></td>
		<td>合否</td>
		<td></td>
		<td><input type="submit" name="REGIST" value="解説"></td>
		</tr>
	</table>
	</c:forEach>
</body>
</html>