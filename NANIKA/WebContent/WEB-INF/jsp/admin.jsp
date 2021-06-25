<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>ドラッグ&ドロップでファイルをアップロード</title>
</head>
<body>
<h1>画像アップロード</h1>
<form action="/NANIKA/AdminServlet" method="post" enctype="multipart/form-data">
    <div id="drop-zone" style="border: 1px solid; padding: 30px;">
        <p>ファイルをドラッグ＆ドロップもしくは</p>
        <input type="file" name="file" id="file-input" webkitRelativePath>
    </div>

<p class="aaa"></p>

    <h2>アップロードした画像</h2>
    <div id="preview"></div>
    <input type="submit" style="margin-top: 50px">
</form>

<script src="js/admin.js" ></script>
</body>
</html>
