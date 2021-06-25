<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NANIKA | 単元一覧</title>
<link rel="stylesheet" href="/NANIKA/css/common.css">
<link rel="stylesheet" href="/NANIKA/css/header.css">
<link rel="shortcut icon" href="image/nanikafavicon.ico">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
	<div class="wrapper">
		<header>
			<jsp:include page="/header.jsp" />
		</header>
		<div class="explorer">
			<ul>
				<li><a href="/NANIKA/HomeServlet">メニュー</a></li>
				<li><a href="/NANIKA/TestSubjectServlet" id="js-menuTab">テスト受験</a></li>
				<li><a href="/NANIKA/UnitServlet" name='${subject_id}' id="subjectTitle">${subjectName}</a></li>
			</ul>
		</div>
		<nav class="menu">
			<ul>
				<li>
					<a href="/NANIKA/HomeServlet">メニュー</a>
				</li>
				<li>
					<a href="/NANIKA/ResultSubjectServlet">テスト結果一覧</a>
				</li>
			</ul>
		</nav>
		<nav class="subjectmenu">
			<c:forEach var="subject" items="${subjectList}">
			<ul>
				<li>
					<a href="/NANIKA/UnitServlet" class="subject"
						name='${subject.subject_id}'>${subject.subject}</a>
				</li>
			</ul>
			</c:forEach>
		</nav>
		<nav class="unitmenu">
			<c:forEach var="unit" items="${UnitList}">
			<ul>
				<li>
					<a href="/NANIKA/TestServlet" class="js-unit"
						name='${unit.unit_id}' onclick="return disp()"><c:out
							value="${unit.unit} " /></a>
				</li>
			</ul>
			</c:forEach>
		</nav>
		<br>
		<h1>Radar Chart</h1>
		<div id="canvas" style="position: relative; width: 950px; height: 470px; background-color: #488a99; border: ridge 10px; margin: 0 0 0 10px;">
			<canvas id="MyRaderChart" style="broder-radius: 50px;"></canvas>
		</div>
		<hr>
		<div>
			<label>評価（システム）</label>
		</div>
		<hr>
		<div>
			<label>コメント</label>
		</div>

		<hr>
	</div>
	<div style="display: block">
		<div id = "content">各単元</div>
		<c:forEach var="unitLists" items="${UnitList_score}">     <!-- List<NanikaBeans>[] UnitList_score = new List[5]; -->
															<!-- UnitList_score = sDao.scoreNew2(userbeans.getUser_id(), i,subjectId); 返り値「List<NanikaBeans>」 -->
			<c:forEach var="list_item" items="${unitLists}">             <!-- 変更前 ${ list }-->
				<p class="score" style="display: block">${list_item.score}</p>
				<p class="superSubject" style="display: block">${list_item.unit}</p> <!-- 変更前 ${ list_item.subject }-->
				<br>
			</c:forEach>
		</c:forEach>
		<!--
		<c:forEach var="list_item" items="${UnitList}">
			<p class="subject" style="display: block">${list_item.subject}</p>
			<br>
		</c:forEach>
		--><!-- 変更前 ${ subjectList }  82行目-->
		<p id="user">${userName}</p>
	</div>
	<!-- CDN -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>
	<!-- レーダーチャート（仮） -->

	<script src="js/rader2.js"></script>
	<script src="js/subject.js"></script>
	<script src="js/unit.js"></script>
	<div id="error" style="display: none">${error}</div>
	<script type="text/javascript">
		const $docc = document;
		const $error = $docc.getElementById('error');
		console.log("$error.textContent", $error.textContent);
		if ($error.textContent != null && $error.textContent != "") {
			alert($error.textContent);
		}
	</script>
</body>
</html>