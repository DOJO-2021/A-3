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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="js/paginathing.js"></script>
<script type="text/javascript" src="js/paginathing.min.js"></script>

</head>
<style>
input[type="text"],input[type="password"]{
  border-radius: 4px;
  border: 1px solid #E5E5E5;
  padding: 3px;
  margin-bottom: 5px;
  width:80%;
}
button {
  text-align:center;
  width:50%;
}
hr {
  margin-bottom:10px;
}

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
	<h4>テスト編集</h4>
	<hr>
	<div class="row">
	    <div class="col-3">
		    <div class="list-group">
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
	    	<div class="list-group">
		    	<button type="button" class="list-group-item   list-group-item-action active" aria-current="true"  style="background: #488a99;">単元一覧</button>

				<c:forEach var="unitlist2" items="${UnitList2}">
					<form method="post"  action="/NANIKA/Admin3Servlet">
						<button class="btn btn-link  list-group-item list-group-item-action" type="submit"><c:out value="${unitlist2.unit}"></c:out></button>
					    <input type="hidden" name="unit_id" value="${unitlist2.unit_id}">
					</form>
				</c:forEach>
			</div>
	    </div>

<hr>
	    <div class="col-6">
		    <h2>編集画面</h2>
	    	<hr>
			<div class="items">
					<c:forEach var="questionlist" items="${QuestionList}" varStatus="status">
							<div class="item">
								<h4><c:out value="${questionlist.unit}"></c:out> 問<c:out value="${status.count}"></c:out></h4>
								<form name="form1" action="/NANIKA/Admin4Servlet" method="post">
								<input type="hidden" name="question_id" value="${questionlist.question_id }">
								<input type="hidden" name="unit_id" value="${questionlist.unit_id }">

								<div class="ite">
									<p>問題文<input type="text" value="${questionlist.question}" class="container-fluid"  name="field1"></p>
									<p>解説<input type="text" value="${questionlist.commentary}"  name="field2"> </p>
								 </div>

								<div class="ite ">
									<hr>
									<p>選択肢①<input type="text" value="${questionlist.answer1 }"  class="ppp"  name="field3"><br>
									解説　<input type="text" value="${questionlist.answer_commentary1 }"  name="field4"></p>
								</div>

								<div class="ite">
									<hr>
									<p>選択肢②<input type="text" value="${questionlist.answer2 }"  name="field5"><br>
									解説　<input type="text" value="${questionlist.answer_commentary2 }"  name="field6"></p>
								</div>

								<div class="ite">
									<hr>
									<p>選択肢③<input type="text" value="${questionlist.answer_commentary3 }"  name="field7"><br>
									解説　<input type="text" value="${questionlist.answer3 }"   name="field8"></p>
								</div>

								<div class="ite">
									<hr>
									<p>選択肢④<input type="text" value="${questionlist.answer4 }"  name="field9"><br>
									解説　<input type="text" value="${questionlist.answer_commentary4 }"  name="field10">  </p>
								</div>



								<div class="ite">
									<hr>
									<p>解答　<input type="text" value="${questionlist.answer}"   name="field11">
									<button type="submit" class="btn btn-secondary" width="50px" style="background: #488a99;">変更</button></p>
								</div>

							</form>
						</div>
						<hr>
				</c:forEach>
			</div>
		</div>

<!-- サンプルテスト -->



<div id="error" style="display: none">${result}</div>
	<script type="text/javascript">
		const $docc = document;
		const $error = $docc.getElementById('error');
		console.log("$error.textContent", $error.textContent);
		if ($error.textContent != null && $error.textContent != "") {
			alert($error.textContent);
		}
	</script>

</div>
</div>

<script type="text/javascript">


/*
  jQuery(document).ready(function($){
    for (var i = 1; i <= 150; i++) {
      $('.list-group').append('<li class="list-group-item"> Item ' + i + '</li>');
    }

    $('.list-group').paginathing({
      perPage: 5,
      limitPagination: 9,
      containerClass: 'panel-footer',
      pageNumbers: true
    })

    $('.items .item').paginathing({
      perPage: 1,
      insertAfter: '.items',
      pageNumbers: true
    });
  });
*/


jQuery(document).ready(function($){

    $('.table tbody').paginathing({
      perPage: 1,
      insertAfter: '.table',
      pageNumbers: true
    });



    $('.items ').paginathing({
      perPage: 2,
      insertAfter: '.items',
      pageNumbers: true
    });
    $('.first').addClass('page-link');
    $('.prev').addClass('page-link');
    $('.page').addClass('page-link');
    $('.next').addClass('page-link');
    $('.last').addClass('page-link');
    $('.pageNumbers').addClass('page-link');

    $('ul').on('click', function() {
	    $('.first').addClass('page-link');
	    $('.prev').addClass('page-link');
	    $('.page').addClass('page-link');
	    $('.next').addClass('page-link');
	    $('.last').addClass('page-link');
	    $('.pageNumbers').addClass('page-link');
    });

  });


</script>
<footer class="bg-secondary text-center text-light p-5 mt-5">
(c) NANIKA.com
</footer>

</body>
</html>