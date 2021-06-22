<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>テスト受験</title>
<link rel="stylesheet" href="css/test_table.css">
</head>
<body>
	<header>
	</header>
<main>
	<div>
		<section id = "js-que">
		<form action="/NANIKA/TestServlet" method="post">
			<h1>テスト受験</h1>
			<p>テスト残り時間：  <span id="time_h"></span>:<span id="time_m"></span></p>
			<p>単元：${unitName}</p>
			<c:forEach var="q_list" items="${questList}" varStatus="status">
			<div class="que-contents-item" data-content="${status.index}">
			<p>問題文</p>
			<p>${q_list.question}</p>
			<input type="hidden" name="questionid${status.count}" value="${q_list.question_id}">
			<input type="hidden" name="answer${status.count}" value="${q_list.answer}">
				<table border="1">
					<tr>
					    <td><label><input type="radio" name="radiobutton${status.count}" value="${q_list.answer1}" checked> ${q_list.answer1}</label></td>
					</tr>
					<tr>
					    <td><label><input type="radio" name="radiobutton${status.count}" value="${q_list.answer2}"> ${q_list.answer2}</label></td>
					</tr>
					<tr>
					    <td><label><input type="radio" name="radiobutton${status.count}" value="${q_list.answer3}"> ${q_list.answer3}</label></td>
					</tr>
					<tr>
						<td><label><input type="radio" name="radiobutton${status.count}" value="${q_list.answer4}"> ${q_list.answer4}</label></td>
					</tr>
				</table>


				<button data-back="${status.index-1}" class="back ">戻る</button>
			    <button data-next="${status.count}" class="next ">次へ</button>


			</div>
			</c:forEach>
			<a><input type="submit" value="終了" id="checkButton" onclick="return disp()"></a>
			</form>
		</section>
	</div>
</main>

<hr>
<h2>確認用</h2>
<p>${unitId}</p>
<p>${unitName}</p>
<hr>
<c:forEach var="q_list" items="${questList}">
 <c:out value="${q_list.question_id}"/>
 <c:out value="${q_list.answer}"/>
 </c:forEach>
<script src="js/test.js"></script>
</body>
</html>
