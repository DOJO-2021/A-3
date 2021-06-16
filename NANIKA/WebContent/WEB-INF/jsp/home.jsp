<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><a href="#"><img src="" alt="ロゴ"></a></h1>
	<h1>ホーム画面</h1>
	<!--メニュータブ （左） -->
	<div>
		<p><a href="">メニュー</a></p>
		<p><a href="/NANIKA/TestSubjectServlet">テスト受験</a></p>
		<p><a href="/NANIKA/ResultSubjectServlet">テスト結果一覧</a></p>
	</div>


	<!-- （右側） -->
	<canvas id="myRaderChart"></canvas>
	<div>
		<label>評価（システム）</label>
	</div>
	<div>
		<label>コメント</label>
	</div>

	<hr>
	<h2>確認用</h2>
	<c:forEach var="list_item" items="${list}">
		<p>スコア（確認用）： ${list_item.score} </p>
		<p>科目（確認用）： ${list_item.subject} </p><br>
	</c:forEach>


</body>

<!-- CDN -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>
<!-- レーダーチャート（仮） -->
<script>
    var ctx = document.getElementById("myRaderChart");
    var myRadarChart = new Chart(ctx, {
        type: 'radar',
        data: {
            labels: [

            	"(仮)アルゴリズム","(仮)ネットワーク", "（仮）HTML","（仮）CSS", "（仮）JavaScript","(仮)データベース",  "（仮）Java","（仮）品質・セキュリティ"

            	],
            datasets: [{
                label: '${userbeans.account_name}',
                data: [
                	92, 72, 86, 74, 86, 70, 39, 90
                	],
                backgroundColor: 'RGBA(225,95,150, 0.5)',
                borderColor: 'RGBA(225,95,150, 1)',
                borderWidth: 1,
                pointBackgroundColor: 'RGB(46,106,177)'
            }]
        },
        options: {
            title: {
                display: true,
                text: '試験成績'
            },
            scale:{
                ticks:{
                    suggestedMin: 0,
                    suggestedMax: 100,
                    stepSize: 10,
                    callback: function(value, index, values){
                        return  value +  '点'
                    }
                }
            }
        }
    });
    </script>

</html>
