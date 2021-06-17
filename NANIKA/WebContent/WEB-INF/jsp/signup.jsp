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
<h1>新規登録画面</h1>
	<form action="/NANIKA/SignupServlet" method="post" id="form_signup" >
		<label for="NAME">名前（必須）</label><br>
		<input type="text" name="NAME" id="NAME" required ><br>

		<label for="KANA">名前（カナ文字）（必須）</label><br>
		<input type="text" name="KANA" id="KANA"required><br>

		<label for="EMAIL">Email（必須）</label><br>
		<input type="email" name="EMAIL" id="EMAIL" required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"><br>

		<label for="PW">パスワード（必須）8～15</label><br>
		<input type="password" name="PW" id="PW" required  pattern=".{8,15}"><br>

		<label for="PW1">パスワード（※確認用）</label><br>
		<input type="password" name="PW1" id="PW1" required  pattern=".{8,}"><br>

		<input type="submit" name="" value="新規登録" onclick="return chack()">
		<input type="reset" name="" value="クリア">
	</form>
	<a href="/NANIKA/LoginServlet">ログイン画面に戻る</a>

	<script>
		var form = document.getElementById("form_signup");

		form.onsubmit = function() {
		    // エラーメッセージをクリアする
		    form.password.setCustomValidity("");
		    // パスワードの一致確認
		    if (form.PW.value != form.PW1.value) {
		      // 一致していなかったら、エラーメッセージを表示する
		      form.PW.setCustomValidity("パスワードと確認用パスワードが一致しません");
		    }
		  };

		  // 入力値チェックエラーが発生したときの処理
		  form.addEventListener("invalid", function() {
		    document.getElementById("errorMessage").innerHTML = "入力値にエラーがあります";
		  }, false);


	</script>
</body>
</html>