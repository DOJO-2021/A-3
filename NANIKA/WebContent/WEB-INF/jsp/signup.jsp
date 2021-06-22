<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
		<link rel="stylesheet" href="/NANIKA/css/header.css">
		<link rel="stylesheet" href="/NANIKA/css/common.css">
		<link rel="stylesheet" href="/NANIKA/css/login.css">
</head>
<body>
<div class=wrapper>
	<header>
			<h1 class = "logo"><a href="/NANIKA/LoginServlet"><img alt="ロゴ" src="image/logo3.png"></a></h1>
	</header>
	<main>
		<h1>新規登録画面</h1>
		<form action="/NANIKA/SignupServlet" method="post" id="form_signup" >
		<table class="logintable">
			<tr>
				<th> for="NAME"名前（必須）</th>
				<td><div class="cp_iptxt">
						<input type="text" name="NAME" id="NAME" required >
					</div>
				</td>
			</tr>
			<tr>
				<th> for="KANA"名前（カナ文字）（必須）</th>
				<td><input type="text" name="KANA" id="KANA"required></td>
			</tr>
			<tr>
				<th> for="EMAIL"Email（必須）</th>
				<td><input type="email" name="EMAIL" id="EMAIL" required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"></td>
			</tr>
			<tr>
				<th> for="PW"パスワード（必須）8～15</th>
				<td><input type="password" name="PW" id="PW" required  pattern=".{8,15}"></td>
			</tr>
			<tr>
				<th> for="PW1"パスワード（※確認用）</th>
				<td><input type="password" name="PW1" id="PW1" required  pattern=".{8,}">
			</tr>

		</table>
			<input type="submit" name="" value="新規登録" onclick="return chack()">
			<input type="reset" name="" value="クリア">
		</form>

		<a href="/NANIKA/LoginServlet">ログイン画面に戻る</a>
	</main>
</div>
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