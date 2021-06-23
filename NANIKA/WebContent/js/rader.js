const $doc = document;
var ctx = $doc.getElementById("myRaderChart");
const $score =$doc.getElementsByClassName('score');
const $subject = $doc.getElementsByClassName('subject');
const $user = $doc.getElementById('user');
console.log($user.textContent);
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
			backgroundColor : 'RGBA(225,95,150, 0.5)',
			borderColor : 'RGBA(225,95,150, 1)',
			borderWidth : 1,
			pointBackgroundColor : 'RGB(46,106,177)'

		} ]
	},
	options : {
		title : {
			display : true,
			text : '試験成績'
		},
		scale : {
			ticks : {
				suggestedMin : 0,
				suggestedMax : 100,
				stepSize : 10,
				callback : function(value, index, values) {
					return value + '点'
				}
			},
			pointLabels : {
				fontSize : 16
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