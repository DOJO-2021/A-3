

    var dropZone = document.getElementById('drop-zone');
    var preview = document.getElementById('preview');
    var fileInput = document.getElementById('file-input');
    var aaa = document.getElementById('aaa');

    var upload_file_url;
    var url5;

    dropZone.addEventListener('dragover', function(e) {
        e.stopPropagation();
        e.preventDefault();
        this.style.background = '#e1e7f0';
    }, false);

    dropZone.addEventListener('dragleave', function(e) {
        e.stopPropagation();
        e.preventDefault();
        this.style.background = '#ffffff';
    }, false);

    fileInput.addEventListener('change', function () {
        previewFile(this.files[0]);
    });

    dropZone.addEventListener('drop', function(e) {
        e.stopPropagation();
        e.preventDefault();
        this.style.background = '#ffffff'; //背景色を白に戻す
        var files = e.dataTransfer.files; //ドロップしたファイルを取得

        if (files.length > 1) return alert('アップロードできるファイルは1つだけです。');
        fileInput.files = files; //inputのvalueをドラッグしたファイルに置き換える。
        console.log("---------");
        console.log(files[0].name);
        console.log("---------");
        console.log(files[0].webkitRelativePath+ "-----aaaa");
        console.log("----sss---");
        console.log(files[0]);

var url = location.href;
var urlaaa = encodeURI(url).toString();


// aaa.innerHTML = files[0].webkitRelativePath;
      console.log(urlaaa);

        previewFile(files[0]);

        // アップロードしたファイルのURLを取得
        // upload_file_url = URL.createObjectURL(files[0]).toString();
        // url5 = files[0].webkitRelativePath;
        // window.alert(url5);

    }, false);

    function previewFile(file) {
        /* FileReaderで読み込み、プレビュー画像を表示。 */
        var fr = new FileReader();
        fr.readAsDataURL(file);
        fr.onload = function() {
            var img = document.createElement('img');
            img.setAttribute('src', fr.result);

            preview.innerHTML = '';
            preview.appendChild(img);

        };
        // var relativePath = File.webkitRelativePath
        //
        // console.log(upload_file_url);
    }
