<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NANIKA | 単元一覧</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<ul>
	<li>メニュー</li> &gt;
	<li>テスト受験</li> &gt;
	<li>Java</li>
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
				<a href="/NANIKA/UnitServlet" class="subject" name = '${subject.subject_id}'><c:out value="${subject.subject}"></c:out></a>
			</p>
		</c:forEach>
	</nav>
	<nav>
		<c:forEach var="unit" items="${UnitList}">
			<p>
				<a href="/NANIKA/TestServlet"><c:out value="${unit.unit} " /></a>
			</p>
		</c:forEach>
	</nav>
	<script type="text/javascript">
	$(function(){

		const dc = document;
		let subject = dc.getElementsByClassName('subject');
		console.log(subject);
		for(let i = 0; i < subject.length; i++){
			subject[i].addEventListener("click",() => {

			let request = {
				param : subject[i].name
			};

			$.ajax({
				type:"POST",
				url:"http://localhost:8080/NANIKA/TestSubjectServlet",
				data:request,
				dateType:"json"
			}).done(function(date){
				alert(subject[i].textContent+"\n"+request);
			}).fall(function(){
				alert("fall");
			}).always(function(){

			});

			}, false);
		}
	});

	</script>
</body>
</html>