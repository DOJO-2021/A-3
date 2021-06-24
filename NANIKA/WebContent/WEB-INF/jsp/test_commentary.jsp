<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/NANIKA/css/header.css">
<link rel="stylesheet" href="/NANIKA/css/common.css">
<link rel="stylesheet" href="/NANIKA/css/table_commentary.css">
<link rel="shortcut icon" href="image/nanikafavicon.ico">
</head>
<body>
	<header>
		<jsp:include page="/header.jsp" />
	</header>
	<div>
		<p>
			<a href="/NANIKA/HomeServlet">メニュー</a>
		</p>
		<p>
			<a href="/NANIKA/TestSubjectServlet">テスト受験</a>
		</p>
		<p>
			<a href="/NANIKA/ResultSubjectServlet">テスト結果一覧</a>
		</p>
	</div>

	<div id="js-que">
		<div class="que-contents">

			<c:forEach var="report" items="${queston_report}" varStatus="status">
				<div class="que-contents-item" data-content="${status.index}">
					<div>
						<h2>問題${status.count}</h2>
						<div>
							<c:out value="${report.question}" />
						</div>
						<h2>解説</h2>
						<div>
							<c:out value="${report.commentary}" />
						</div>
					</div>
					<br> <br>
					<div class="commentary">
						<table class="commentary">
							<tr>
								<th>正解</th>
								<th>選択</th>
								<th id="selectcomm">選択肢</th>
								<th id="comm">解説</th>
							</tr>
							<tr>
								<td data-false>○</td>
								<td><div data-answer>${report.user_answer}</div>
								<td><div data-select>${report.answer1}</div></td>
								<td><div>${report.answer_commentary1}</div></td>
							</tr>
							<tr>
								<td data-false>○</td>
								<td><div data-answer>${report.user_answer}</div>
								<td><div data-select>${report.answer2}</div></td>
								<td><div>${report.answer_commentary2}</div></td>
							</tr>
							<tr>
								<td data-false>○</td>
								<td><div data-answer>${report.user_answer}</div>
								<td><div data-select>${report.answer3}</div></td>
								<td><div>${report.answer_commentary3}</div></td>
							</tr>
							<tr>
								<td data-false>○</td>
								<td><div data-answer>${report.user_answer}</div>
								<td><div data-select>${report.answer4}</div></td>
								<td><div>${report.answer_commentary4}</div></td>
							</tr>
						</table>
						<div class="answer" data-true>${report.answer}</div>
						<div class="answer" data-true>${report.answer}</div>
						<div class="answer" data-true>${report.answer}</div>
						<div class="answer" data-true>${report.answer}</div>
						<div class="js-button">
							<button data-back="${status.index-1}" class="back ">
								戻る
								<!--　最後消す？  -->
							</button>
							<button data-next="${status.count}" class="next ">次へ</button>
							<button class="end"
								onclick="location.href='/NANIKA/TestDetailServlet'">終了</button>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

		<br>


		<div class="list-nav">
			<div class="ulist">
				<c:forEach var="report" items="${queston_report}" varStatus="status">
					<a href="#" class="list" data-nav="${status.index}">${status.count}<br />○
					</a>
				</c:forEach>
			</div>
		</div>
	</div>
	<!--
<h2>確認用</h2>
				<hr>
				<c:forEach var="report" items="${queston_report}">
					<c:out value="${report.start_time}"></c:out>         <br>
					<c:out value="${report.question_id}"></c:out>        <br>
					<c:out value="${report.question}"></c:out>           <br>
					<c:out value="${report.commentary}"></c:out>         <br>
					<c:out value="${report.answer_commentary1}"></c:out>         <br>
					<c:out value="${report.answer_commentary2}"></c:out>         <br>
					<c:out value="${report.answer_commentary3}"></c:out>         <br>
					<c:out value="${report.answer_commentary4}"></c:out>         <br>
					<c:out value="${report.answer1}"></c:out>         <br>
					<c:out value="${report.answer2}"></c:out>         <br>
					<c:out value="${report.answer3}"></c:out>         <br>
					<c:out value="${report.answer4}"></c:out>         <br>
					<c:out value="${report.answer}"></c:out>          <br>
					<c:out value="${report.user_answer}"></c:out>     <br>
				</c:forEach>

-->
	<script type="text/javascript" src="js/commentary.js"></script>
</body>
</html>