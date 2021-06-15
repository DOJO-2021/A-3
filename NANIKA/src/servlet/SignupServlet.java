package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IdpwDao;
import model.UserBeans;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//登録ページにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String account_name = request.getParameter("NAME");
		String email = request.getParameter("EMAIL");
		String password = request.getParameter("PW");
		String re_password = request.getParameter("PW1");
		String account_name_kana = request.getParameter("KANA");

		// エラーが1つでもあれば新規登録に再遷移
		int count = 0;

		// 名前が入力してあるかのチェック　※漢字であるかの判定
		if(account_name == null || account_name == "") {
			String name_err = ("※名前を入力してください");
			request.setAttribute("name_err",name_err);
			count++;
		}

		// かなが入力してあるかのチェック　※ひらがなであるかの判定
		if(account_name_kana == null || account_name_kana == "") {
			String name_kana_err = ("※かなを入力してください");
			request.setAttribute("name_kana_err", name_kana_err);
			count++;
		}

		//emailが入力してあるかのチェック
		if(email == null || email == "") {
			String email_err = ("※メールアドレスを入力してください");
			request.setAttribute("email_err",email_err);
			count++;
		}

		//パスワードが8～15文字以内の半角英数字であるかのチェック ※半角英数字であるかの判定
		if(password.length() <=8 && password.length() >=15) {
			String pass_err = ("パスワードは8～15字以内の半角英数字で入力してください");
			request.setAttribute("pass_err",pass_err);
			count++;
		}

		//パスワード(確認用)とパスワードが一致しているかのチェック
		if(password != re_password) {
			String re_pass_err = ("※パスワードが一致しません");
			request.setAttribute("re_pass_err",re_pass_err);
			count++;
		}

		//エラーが出たら新規登録画面に再度遷移
		if(count > 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
		}else {
			// 登録処理を行う
			IdpwDao ipDao = new IdpwDao();
			ipDao.insert(new UserBeans(0,account_name,email,password,account_name_kana));

			//　ログインページにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
