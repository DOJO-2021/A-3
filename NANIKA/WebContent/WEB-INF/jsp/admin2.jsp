<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NANIKA</title>
<link rel="shortcut icon" href="image/nanikafavicon.ico">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<style>
footer{
    position: absolute;/*←絶対位置*/
    bottom: 0; /*下に固定*/
    width:100%;
}
</style>
</style>
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
        <a class="nav-link" href="/NANIKA/Admin1Servlet">ホームに戻る <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/NANIKA/LoginServlet">ログアウトする</a>
      </li>

    </ul>

  </div>
</nav>
</header>
<div class="container mt-5">
	<div class="row">
	    <div class="col-3">
		    <div class="list-group">
		    <h4>テスト編集</h4>
		    <hr>
		    	<button type="button" class="list-group-item list-group-item-action active" aria-current="true"  style="background: #488a99;">テスト科目</button>

				<c:forEach var="list2" items="${subject_admin}">
					<form method="post"  action="/NANIKA/Admin2Servlet">
						<button class="btn btn-link  list-group-item list-group-item-action" type="submit"><c:out value="${list2.subject}" ></c:out></button>
					    <input type="hidden" name="subject_id" value="${list2.subject_id}">
					</form>
				</c:forEach>

			</div>
	    </div>



	    <div class="col-3">
	    </div>
	</div>
</div>



<footer class="bg-secondary text-center text-light p-5 mt-5">
(c) NANIKA.com
</footer>
</body>
</html>