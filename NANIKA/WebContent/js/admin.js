    var dropZone = document.getElementById('drop-zone');
    var preview = document.getElementById('preview');
    var fileInput = document.getElementById('file-input');
    var aaa = document.getElementById('aaa');

    // ドラッグ&ドロップを許可する領域を取得

	// 対象領域にファイルがドラッグされた際のイベントを登録
	dropZone.addEventListener('dragover', (event) => {
		event.stopPropagation();
		event.preventDefault();
		this.style.background = '#e1e7f0';
		// ドラッグしているファイルの表示を変更
		event.dataTransfer.dropEffect = 'copy';
	}, false);

	fileInput.addEventListener('change', function () {
        getFiles(this.files);
    });

	// 対象領域外へファイルがドラッグされた際のイベントを登録
	dropZone.addEventListener('dragleave', (event) => {
		event.stopPropagation();
		event.preventDefault();
	}, false);

	// 対象領域にファイルがドロップされた際のイベントを登録
	dropZone.addEventListener('drop', (event) => {

		//ドラッグされたファイルを、ブラウザが開かないように設定
		event.stopPropagation();
		event.preventDefault();

		//ドロップしたファイルを取得
		var files = event.dataTransfer.files;
		if (files.length > 1) return alert('アップロードできるファイルは1つだけです。');
        fileInput.files = files; //inputのvalueをドラッグしたファイルに置き換える。
	   	getFiles(files);
	});

function getFiles(files) {
	for (let file of files) {
		const dataArray = []; //配列を用意
		const reader = new FileReader();

		//テキスト形式で読み込む
		reader.readAsText(file);

		// テキストの読み込みが完了した際のイベントを登録
		reader.onload = (event) => {

		const text = event.target.result;

		const csv = text.split('\n');

		for (let i = 0; i < csv.length; i++) { //あるだけループ
        	dataArray[i] = csv[i].split(',');
    	}
		console.log(csv);
		let insertElement = '';
		dataArray.forEach((element) => { //配列の中身を表示
	        insertElement += '<tr>';
	        element.forEach((childElement) => {
	            insertElement += `<td>${childElement}</td>`
	        });
	        insertElement += '</tr>';
	    });
		preview.innerHTML = insertElement;

      }
   }

}
