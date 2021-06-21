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
			<p>単元：${unitName}</p>
	<c:forEach var="q_list" items="${questList}">
			<p>問題文</p>
			<p>${q_list.question}</p>

			<form action="/NANIKA/TestServlet" method="GET">
				<table border="1">
					<tr>
					    <td><input type="radio" name="radiobutton" value="answer1"> ${q_list.answer1}</td>
					</tr>
					<tr>
					    <td><input type="radio" name="radiobutton" value="answer2"> ${q_list.answer2}</td>
					</tr>
					<tr>
					    <td><input type="radio" name="radiobutton" value="answer3"> ${q_list.answer3}</td>
					</tr>
					<tr>
						<td> <input type="radio" name="radiobutton" value="answer4"> ${q_list.answer4}</td>
					</tr>
				</table>
			 </c:forEach>
				<a><input type="submit" value="戻る"></a>
			    <a><input type="submit" value="次へ" ></a>
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
 <c:out value="${q_list.unit_id}"/>
 <c:out value="${q_list.question_id}"/>
 <c:out value="${q_list.question}"/>
 <c:out value="${q_list.answer1}"/>
 <c:out value="${q_list.answer2}"/>
 <c:out value="${q_list.answer3}"/>
 <c:out value="${q_list.answer4}"/>
 <c:out value="${q_list.answer}"/>
 </c:forEach>
  -->
</body>
</html>