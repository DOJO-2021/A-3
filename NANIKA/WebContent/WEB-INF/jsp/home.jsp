<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><a href="#"><img src="" alt="ロゴ"></a></h1>
	<!--メニュータブ （左） -->
	<div>
		<p><a href="">メニュー</a></p>
		<p><a href="">テスト受験</a></p>
		<p><a href="">テスト結果一覧</a></p>
	</div>


	<!-- （右側） -->
	<canvas id="myRaderChart"></canvas>
	<div>
		<label>評価（システム）</label>
	</div>
	<div>
		<label>コメント</label>
	</div>
</body>

<!-- CDN -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>
<!-- レーダーチャート（仮） -->
<script>
    var ctx = document.getElementById("myRaderChart");
    var myRadarChart = new Chart(ctx, {
        type: 'radar',
        data: {
            labels: ["(仮)java", "（仮）css", "（仮）html", "（仮）php", "（仮）javascript"],
            datasets: [{
                label: 'Aさん',
                data: [92, 72, 86, 74, 86],
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
