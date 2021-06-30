<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>NANIKA</title>
    <link rel="shortcut icon" href="image/nanikafavicon.ico">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<link rel="shortcut icon" href="image/nanikafavicon.ico">
	<style type="text/css">
	table {
  border-collapse: collapse;
  border-spacing: 0;
}

td {
  font-size: 12px;
  padding: .2em .5em;
  border: solid 1px #ccc;
}

.btn{
  text-align:center;
  width:15%;
}
	</style>
</head>
<body>

<header  style="background-color:#488a99;">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="/NANIKA/Admin1Servlet">Admin</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/NANIKA/Admin1Servlet">ホームに戻る <span class="sr-only"></span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/NANIKA/LoginServlet">ログアウトする</a>
      </li>

    </ul>

  </div>
</nav>
</header>


<div class="container mt-5">
	<br>
		<h4 style="padding: 1rem 2rem; border-left: 4px solid #000; margin: 0 0 0 2px;">ファイルアップロード（csv）</h4>
		<hr>

	<div class="row-3">
			<form action="/NANIKA/AdminServlet" method="post" enctype="multipart/form-data">
		<div class="row-3">
			    <div id="drop-zone" style="border: 1px solid; padding: 30px; margin: auto 2px; width: 818px; height: 132px; border-radius: 10px;">
			        <p>ファイルをドラッグ＆ドロップもしくは</p>
			        <input type="file" name="file" id="file-input" accept=".csv" webkitRelativePath  >
			    </div>
		</div>
		<div class="row-3">

			<p class="aaa"></p>
		</div>

		<div class="row-3">

			<h4 style="padding: 1rem 2rem; border-left: 4px solid #000; margin: 0 0 0 2px;">ファイルアップロード</h4>
			<hr>
			    <table id="preview"></table>
			    <div id ="text"></div>
		</div>
			</form>

	</div>
	<div class="row-3">
		<form id ="text">
			<input type="submit"  class="btn btn-secondary"   style=" background:#488a99;">
		</form>
	</div>
</div>

<footer class="bg-secondary text-center text-light p-5 mt-5">
(c) NANIKA.com
</footer>

<script src="js/admin.js" ></script>
</body>
</html>
