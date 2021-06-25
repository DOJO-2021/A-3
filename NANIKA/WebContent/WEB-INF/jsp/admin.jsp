<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>NANIKA</title>
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
	</style>
</head>
<body>

<ul class="nav ">
  <li class="nav-item">
    <a class="nav-link  disabled" href="#"><c:out value="${admin}"></c:out></a>
  </li>

  <li class="nav-item">
    <a class="nav-link active" href="/NANIKA/LoginServlet">Logout</a>
  </li>
</ul>

<h2 style="padding: 1rem 2rem;
  border-left: 4px solid #000; margin: 0 0 0 2px;">ファイルアップロード</h2>

<br>
<form action="/NANIKA/AdminServlet" method="post" enctype="multipart/form-data">
    <div id="drop-zone" style="border: 1px solid; padding: 30px; margin: auto 2px; width: 818px; height: 132px; border-radius: 10px;">
        <p>ファイルをドラッグ＆ドロップもしくは</p>
        <input type="file" name="file" id="file-input" accept=".csv" webkitRelativePath>
    </div>

<p class="aaa"></p>

    <h2 style="padding: 1rem 2rem;
  border-left: 4px solid #000; margin: 0 0 0 2px;">アップロード結果</h2>
    <table id="preview"></table>
    <input type="submit" style="margin-top: 50px">
</form>

<script src="js/admin.js" ></script>
</body>
</html>
