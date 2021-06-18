<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="css/table_commentary.css">
	</head>
	<body>
		<div>
			<p><a href="/NANIKA/HomeServlet">メニュー</a></p>
			<p><a href="">テスト受験</a></p>
			<p><a href="">テスト結果一覧</a></p>
		</div>

			<div id="js-que">
				<div class="que-contents">

					<c:forEach var="i" begin="0" end="9" step="1">
				    <div class="que-contents-item" data-content="${i}">
				    <div>
				        <h2>問題${i+1}</h2>
				        <div>
				        	問題文
				        </div>
				        <h2>解説</h2>
				        <div>
				        	解説文
				        </div>
			        </div>
					<div class="commentary">
						<table>
							<tr><th>正解</th><th>選択</th><th>選択肢</th><th>解説</th></tr>
							<c:forEach var="i" begin="1" end="4" step="1">
							<tr><td>○or×</td><td>✓orNULL<td ><div>選択肢${i}</div></td><td><div>解説${i}</div></td></tr>
							</c:forEach>
						</table>
						<div>
							<button>次へ<!--　最後消す？  --></button>
							<button>戻る</button>
				            <button>終了</button>
	                    </div>
					</div>
					</div>
					</c:forEach>
				</div>
				<br>


			<div class="list-nav">
				<div class="ulist">
					<c:forEach var="i" begin="0" end="9" step="1">
					<a href="#"  class="list" data-nav="${i}">${i+1}<br/>○</a>
					</c:forEach>
				</div>
			</div>
		</div>



	<script type="text/javascript" src="js/commentary.js"></script>
	</body>
</html>