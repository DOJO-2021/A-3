(() =>{

	const $doc = document;
	const $que = $doc.getElementById('js-que');
	console.log($que);
	const $nav = $que.querySelectorAll('[data-nav]');
	const $content = $que.querySelectorAll('[data-content]');

	//初期化
	const init = () => {
		$content[0].style.display ='block';
	}
	init();

	//クリックしたら起こる
	const handleClick = (e) => {
		e.preventDefault();

		//クリックされたnavとdataを取得
		const $this = e.target;
		const targetVal = $this.dataset.nav;

		//対象のnav, contentをすべてリセット
		let index = 0;
		while(index < $nav.length){
			$content[index].style.display = 'none';
			$nav[index].classList.remove('is-active');
			index++;
		}

		//対象のコンテンツをアクティブ化
		$que.querySelectorAll('[data-content="' + targetVal +'"]')[0].style.display = 'block';
		$nav[targetVal].classList.add('is-active');

	};

	//全要素に対して関数を適応
	let index = 0;
	while(index < $nav.length){
	$nav[index].addEventListener('click', (e) => handleClick(e));
	index++;
	}

})();