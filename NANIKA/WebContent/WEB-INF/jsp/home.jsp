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
	<div class=wrapper>
	<header>
		<jsp:include page="/header.jsp"/>
	</header>
	<main>
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
	<!--
	<h2>確認用</h2>
	<c:forEach var="list_item" items="${list}" >
		<p class="score" style="display: block">${list_item.score}</p>
		<p class="subject" style="display: block">${list_item.subject}</p><br>
	</c:forEach>
	 -->
	</main>
	</div>
</body>

<!-- CDN -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>
<!-- レーダーチャート（仮） -->
<script>

    var ctx = document.getElementById("myRaderChart");
    const score = document.getElementsByClassName('score');
    const subject = document.getElementsByClassName('subject');
    const scoreLen = score.length;
    const subjectLen = subject.length;
    let index = 0;
    while(index < scoreLen){
    	console.log(score[index].textContent);
    	index++;
    }
    index = 0;
    while(index < subjectLen){
    	console.log(subject[index].textContent);
        index++;
    }

    var myRadarChart = new Chart(ctx, {
        type: 'radar',
        data: {
            labels: [

            	subject[0].textContent,subject[1].textContent, "（仮）HTML","（仮）CSS", "（仮）JavaScript","(仮)データベース",  "（仮）Java","（仮）品質・セキュリティ"

            	],
            datasets: [{
                label: '${userbeans.account_name}',
                data: [
                	score[0].textContent, score[1].textContent, 86, 74, 86, 70, 39, 90

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
                },
                pointLabels: {
                	fontSize: 16
                }
            },

                legend: {
                    label: {
                        // This more specific font property overrides the global property
                        fontSize: 14
                    }
                }

        }

    });
    </script>

</html>
