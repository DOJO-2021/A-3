<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>テスト受験</title>
</head>
<body>
	<header>
	</header>
<main>
	<div>
		<section>
			<h1>テスト受験</h1>
			<p>テスト残り時間：00:00:00</p>
			<p>単元：${tangen.title}</p>
			<p>問題文</p>
			<p>問題</p>
			<p>選択肢</p>
			<form action="/NANIKA/TestServlet" method="GET">
				<table border="1">
					<tr>
					    <td><input type="radio" name="radiobutton" value="answer1"> 答え1</td>
					</tr>
					<tr>
					    <td><input type="radio" name="radiobutton" value="answer2"> 答え2</td>
					</tr>
					<tr>
					    <td><input type="radio" name="radiobutton" value="answer3"> 答え3</td>
					</tr>
					<tr>
						<td> <input type="radio" name="radiobutton" value="answer4"> 答え4</td>
					</tr>
				</table>
				<a><input type="submit" value="戻る"></a>
			    <a><input type="submit" value="次へ" ></a>
			</form>
		</section>
	</div>
</main>

<hr>
<h2>確認用</h2>
<p>${unitId}</p>
<p>${unitName}</p>

</body>
</html>