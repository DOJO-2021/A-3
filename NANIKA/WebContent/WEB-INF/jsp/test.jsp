<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>テスト受験</title>
<link rel="stylesheet" href="css/test_table.css">
<link rel="stylesheet" href="/NANIKA/css/common.css">
<link rel="stylesheet" href="/NANIKA/css/header.css">
<link rel="shortcut icon" href="image/nanikafavicon.ico">
</head>
<body>
	<header class="header">
		<jsp:include page="/header.jsp" />
	</header>
	<main>
	<h1>テスト受験</h1>
		<div class="testquestion">
			<section id="js-que">
				<form action="/NANIKA/TestServlet" method="post">
					<div class="t_timer">
						<p>
							テスト残り時間： <span id="time_h"></span>:<span id="time_m"></span>
						</p>
					</div>
					<div>
						<p id="titleunit">単元：${unitName}</p>
					</div>
					<c:forEach var="q_list" items="${questList}" varStatus="status">

						<div class="que-contents-item" data-content="${status.index}">

							<!--  <p>問題文</p> -->
							<div class="box1">
								<p>${q_list.question}</p>
							</div>

							<input type="hidden" name="questionid${status.count}"
								value="${q_list.question_id}"> <input type="hidden"
								name="answer${status.count}" value="${q_list.answer}">
							<table class="questionform" border="5">
								<tr>
									<td class="questiontext"><label><input
											type="radio" name="radiobutton${status.count}"
											value="${q_list.answer1}" checked> ${q_list.answer1}</label></td>
								</tr>
								<tr>
									<td class="questiontext"><label><input
											type="radio" name="radiobutton${status.count}"
											value="${q_list.answer2}"> ${q_list.answer2}</label></td>
								</tr>
								<tr>
									<td class="questiontext"><label><input
											type="radio" name="radiobutton${status.count}"
											value="${q_list.answer3}"> ${q_list.answer3}</label></td>
								</tr>
								<tr>
									<td class="questiontext"><label><input
											type="radio" name="radiobutton${status.count}"
											value="${q_list.answer4}"> ${q_list.answer4}</label></td>
								</tr>
							</table>

							<br>
							<div class="selectbutton">
								<button data-back="${status.index-1}" class="back ">戻る</button>
								<button data-next="${status.count}" class="next ">次へ</button>
							</div>

						</div>
					</c:forEach>
					<div>
						<input type="submit" value="終了" onclick="return disp()" id="end"
							class="end">
					</div>
				</form>
			</section>
		</div>
	</main>

	<!--
<hr>
<h2>確認用</h2>
<p>${unitId}</p>
<p>${unitName}</p>
<hr>
<c:forEach var="q_list" items="${questList}">
 <c:out value="${q_list.question_id}"/>
 <c:out value="${q_list.answer}"/>
 </c:forEach> -->
	<script src="js/test.js"></script>
</body>
</html>
