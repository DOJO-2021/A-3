$(function(){

		const dc = document;
		let unit = dc.getElementsByClassName('js-unit');
		const menuTab = dc.getElementById('js-menuTab');
		console.log(unit);
		for(let i = 0; i < unit.length; i++){
			unit[i].addEventListener("click",() => {

			let requestUnit = {
				unit_id : unit[i].name,
				unit_name : unit[i].textContent
			};
			if(menuTab.textContent === "テスト受験"){
			$.ajax({
				type:"GET",
				url:"http://localhost:8080/NANIKA/TestServlet",
				data:requestUnit,
				dateType:"json"
			}).done(function(data){
				console.log(data)
			});

			}

			if(menuTab.textContent === "テスト結果一覧"){
			$.ajax({
				type:"GET",
				url:"http://localhost:8080/NANIKA/TestDetailServlet",
				data:requestUnit,
				dateType:"json"
			}).done(function(data){
				console.log(data)
			});


			}

			}, false);
		}
	});

function disp(){

	if(window.confirm('本当に開始しますか？')){
		return true;
	}else{
		window.alert('キャンセルされました');
		return false;

	}
}

