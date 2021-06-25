const $doc = document;
var ctx = $doc.getElementById("myRaderChart");
const $score =$doc.getElementsByClassName('score');
const $subject = $doc.getElementsByClassName('subject');
const $user = $doc.getElementById('user');
const $content = $doc.getElementById('content');
console.log($content.textContent);
const scoreLen = $score.length;
const subjectLen = $subject.length;

let index = 0;
while (index < scoreLen) {
	if($score[index].textContent == ""){
	 $score[index].textContent = 0;
	}
	index++;
}
index = 0;
while (index < subjectLen) {
	console.log($subject[index].textContent);
	index++;
}

var myRadarChart = new Chart(ctx, {
	type : 'radar',
	data : {
		labels : [ $subject[0].textContent, $subject[1].textContent,$subject[2].textContent,$subject[3].textContent,$subject[4].textContent ],
		datasets : [ {
			label : [$user.textContent],
			data : [$score[0].textContent, $score[1].textContent, $score[2].textContent, $score[3].textContent, $score[4].textContent],
			backgroundColor : 'RGBA(196,153,255, 0.5)',
			borderColor : 'RGBA(0,0,0, 1)',
			borderWidth : 1,
			pointBackgroundColor : '#474655'

		} ]
	},
	options : {
		title : {
			display : true,
			text : [$content.textContent+'の試験成績'],
			fontSize: 20,
			fontColor: "#474655"
		},
		scale : {
			ticks : {
				suggestedMin : 0,
				suggestedMax : 100,
				stepSize : 10,
				callback : function(value, index, values) {
					return value + '点'
				},
				fontColor: "red"
			},
			pointLabels : {
				fontSize : 16,
				fontColor: '#474655'    // 文字の色
			},
			angleLines: {        // 軸（放射軸）
                display: true,
                color: "white"
            },
            gridLines: {         // 補助線（目盛の線）
                display: true,
                color: '#2b2b2b'
            }

		},

		legend : {
			label : {
				// This more specific font property overrides the global property
				fontSize : 14
			}
		}

	}

});