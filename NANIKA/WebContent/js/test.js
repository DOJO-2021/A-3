(() =>{

	const $doc = document;
	const $content = $doc.querySelectorAll('[data-content]');
	const $next = $doc.querySelectorAll('[data-next]');
	const $back = $doc.querySelectorAll('[data-back]');
	const contentLen = $content.length;

	//初期化
	const init = () => {
		$content[0].style.display ='block';
	}
	init();

	const backClick = (e) => {
		e.preventDefault();
		const $this = e.target;
		const targetVal = $this.dataset.back;
		console.log("targetVal", targetVal);

		//contentをすべてリセット
		let index = 0;
		while(index < contentLen){
			$content[index].style.display = 'none';
			index++;
		}

		//対象のコンテンツをアクティブ化
		$doc.querySelectorAll('[data-content="' + targetVal +'"]')[0].style.display = 'block';

	}

	const nextClick = (e) => {
		e.preventDefault();
		const $this = e.target;
		const targetVal = $this.dataset.next;
		console.log("targetVal", targetVal);

		//contentをすべてリセット
		let index = 0;
		while(index < contentLen){
			$content[index].style.display = 'none';
			index++;
		}

		$doc.querySelectorAll('[data-content="' + targetVal +'"]')[0].style.display = 'block';

	}

	//全要素に対して関数を適応
	let index = 0;
	while(index < contentLen){

		if(index == contentLen-1){
			$next[index].style.display = 'none';
		}

		if(index == 0){
			$back[index].style.display = 'none';
		}

		$next[index].addEventListener('click', (e) => nextClick(e));
		$back[index].addEventListener('click', (e) => backClick(e));
		index++;
	}

})();

function disp(){

	if(window.confirm('本当に終了しますか？')){
		return true;
	}else{
		window.alert('キャンセルされました');
		return false;

	}
}