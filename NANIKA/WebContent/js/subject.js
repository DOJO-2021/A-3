$(function(){

		const dc = document;
		let subject = dc.getElementsByClassName('subject');
		console.log(subject);
		for(let i = 0; i < subject.length; i++){
			subject[i].addEventListener("click",() => {

			let request = {
				param1 : subject[i].name,
				param2 : subject[i].textContent
			};

			$.ajax({
				type:"POST",
				url:"http://localhost:8080/NANIKA/ResultSubjectServlet",
				data:request,
				dateType:"json"
			}).done(function(data){
				console.log(data)
			});
			if(dc.getElementById('subjectTitle')){
				const subjectTitle = dc.getElementById('subjectTitle');
				subjectTitle.innerText = subject[i].textContent;
			}

			}, false);
		}
	});