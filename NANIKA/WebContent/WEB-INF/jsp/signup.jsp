<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
		<link rel="stylesheet" href="/NANIKA/css/header.css">
		<link rel="stylesheet" href="/NANIKA/css/common.css">
		<link rel="stylesheet" href="/NANIKA/css/signup.css">
</head>
<body>
<div class=wrapper>
	<header>
			<h1 class = "logo"><a href="/NANIKA/LoginServlet"><img alt="ロゴ" src="image/logo3.png"></a></h1>
	</header>
	<main>
		<h1 class="signuph1">新規登録画面</h1>
		<form action="/NANIKA/SignupServlet" method="post" id="form_signup" >
		<table class="signuptable">
			<tr>
				<th for="NAME">名前<span class="error">※</span></th>
				<td><div class="cp_iptxt">
						<input type="text" name="NAME" id="NAME" required >
					</div>
				</td>
			</tr>
			<tr>
				<th for="KANA">名前（カナ文字）※</th>
				<td>
					<div class="cp_iptxt">
						<input type="text" name="KANA" id="KANA"required>
					</div>
				</td>
			</tr>
			<tr>
				<th for="EMAIL">Email ※</th>
				<td>
					<div class="cp_iptxt">
						<input type="email" name="EMAIL" id="EMAIL" required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$">
					</div>
				</td>
			</tr>
			<tr>
				<th for="PW">パスワード（8～15）※</th>
				<td>
					<div class="cp_iptxt">
						<input type="password" name="PW" id="PW" required  pattern=".{8,15}">
					</div>
				</td>
			</tr>
			<tr>
				<th for="PW1">パスワード（確認用）</th>
				<td>
					<div class="cp_iptxt">
						<input type="password" name="PW1" id="PW1" required  pattern=".{8,}">
					</div>
				</td>
			</tr>
		</table>

		<div class="submitbtn">
			<a href="/NANIKA/LoginServlet"  id="modoru">ログインに戻る</a>
	        <a class="custom-btn btn">
				<input class="custom-btn btn" type="submit" value="新規登録" onclick="return chack()">
			</a>
			<a class="custom-btn btn">
				<input class="custom-btn btn" type="reset" value="クリア">
			</a>

		</div>
			</form>
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