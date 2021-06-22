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
		<form action="/NANIKA/TestServlet" method="post">
			<h1>テスト受験</h1>
			<p>テスト残り時間：  <span id="time_h"></span>:<span id="time_m"></span></p>
			<p>単元：${unitName}</p>
			<c:forEach var="q_list" items="${questList}" varStatus="status">
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


				<a><button type="submit" value="">戻る</button></a>
			    <a><button type="submit" value="" >次へ</button></a>



			</c:forEach>
			<a><input type="submit" value="終了" id="checkButton"></a>
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

<script type="text/javascript">
const timeL1 = document.getElementById('time_h');
const timeL2 = document.getElementById('time_m');
const timeLimit = 1740*1000; //(30分設定)
var startTime;
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

</body>
</html>
