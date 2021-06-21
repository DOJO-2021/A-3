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
			<p>テスト残り時間：  <span id="time_h"></span>:<span id="time_m"></span></p>
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
<script>
const timeL1 = document.getElementById('time_h');
const timeL2 = document.getElementById('time_m');

const timeLimit = 1740*1000; //(30分設定)
var startTime;
function start(){
  // alert('スタートですね。');
  startTime = Date.now();
  updateTimer();
}
window.onload = function(){
  startTime = Date.now();
  updateTimer();
}

function updateTimer() {
  const timeLeft = (startTime+ timeLimit) -Date.now();
	var origin = (timeLeft/1000).toFixed(0);
  var hour = (origin/60).toFixed(0);
  var minuits = (origin%60);
  if(hour < 10){
    hour = '0'+hour;
  }
  if(minuits === 0){
    minuits = '0';
  }
  if(minuits < 10){
    minuits = '0'+minuits;
  }

  timeL1.textContent = hour;
  timeL2.textContent = minuits;
  console.log('timeLeft  '+timeLeft);

	const timeoutId = setTimeout(()=>{
		updateTimer();
	},10);
	if(timeLeft < 0){
		clearTimeout(timeoutId);
		// time.textContent='0.00';
		setTimeout(()=>{
			alert('とりあえず終わりです。');
			//*********
			//ここでテスト時間終了の処理を読んであげる。「テストの終了」処理はまだ完成していないはず。。
			//***********
		},100);
	}
}
</script>