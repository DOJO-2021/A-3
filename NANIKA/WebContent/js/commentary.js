(() =>{

	const $doc = document;
	const $que = $doc.getElementById('js-que');
	const $content = $que.querySelectorAll('[data-content]');
	const $next = $que.querySelectorAll('[data-next]');
	const $back = $que.querySelectorAll('[data-back]');
	const $nav = $que.querySelectorAll('[data-nav]');
	const $select = $que.querySelectorAll('[data-select]');
	const $answer = $que.querySelectorAll('[data-answer]');
	const $true = $que.querySelectorAll('[data-true]');
	const $false = $que.querySelectorAll('[data-false]');
	const navLen = $nav.length;

	const select =() => {
		let index = 0;
		while(index < $select.length){
			if($select[index].textContent !== $answer[index].textContent){
				$answer[index].innerHTML = "";
			}
			if($select[index].textContent === $answer[index].textContent){
				$answer[index].innerHTML = "✓";
			}
			if($true[index].textContent !== $select[index].textContent){
				$false[index].innerHTML = "×";
			}
		index++;
		}
	}
	select();

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
		console.log("targetVal", targetVal);

		//対象のnav, contentをすべてリセット
		let index = 0;
		while(index < navLen){
			$content[index].style.display = 'none';
			$nav[index].classList.remove('is-active');
			index++;
		}

		//対象のコンテンツをアクティブ化
		$que.querySelectorAll('[data-content="' + targetVal +'"]')[0].style.display = 'block';
		$nav[targetVal].classList.add('is-active');

	};

	const backClick = (e) => {
		e.preventDefault();
		const $this = e.target;
		const targetVal = $this.dataset.back;
		console.log("targetVal", targetVal);

		//対象のnav, contentをすべてリセット
		let index = 0;
		while(index < navLen){
			$content[index].style.display = 'none';
			$nav[index].classList.remove('is-active');
			index++;
		}

		//対象のコンテンツをアクティブ化
		$que.querySelectorAll('[data-content="' + targetVal +'"]')[0].style.display = 'block';
		$nav[targetVal].classList.add('is-active');

	}

	const nextClick = (e) => {
		e.preventDefault();
		const $this = e.target;
		const targetVal = $this.dataset.next;
		console.log("targetVal", targetVal);

		//対象のnav, contentをすべてリセット
		let index = 0;
		while(index < navLen){
			$content[index].style.display = 'none';
			$nav[index].classList.remove('is-active');
			index++;
		}

		//対象のコンテンツをアクティブ化
		$que.querySelectorAll('[data-content="' + targetVal +'"]')[0].style.display = 'block';
		$nav[targetVal].classList.add('is-active');

	}

	//全要素に対して関数を適応
	let index = 0;
	while(index < navLen){
		if(!$nav[0].classList.contains('is-active')){
			$nav[0].classList.add('is-active');
		}
		if(index == navLen-1){
			$next[index].style.display = 'none';
		}

		if(index == 0){
			$back[index].style.display = 'none';
		}

		$nav[index].addEventListener('click', (e) => handleClick(e));
		$next[index].addEventListener('click', (e) => nextClick(e));
		$back[index].addEventListener('click', (e) => backClick(e));
		index++;
	}

})();