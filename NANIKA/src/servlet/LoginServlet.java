package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.IdpwDao;
import model.UserBeans;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("EMAIL");
		String pw = request.getParameter("PW");
		HttpSession session = request.getSession();

		//ログイン処理
		IdpwDao iDao = new IdpwDao();
		//ログイン判定
		if(email.equals("admin@admin") && pw.equals("admin")){
			session.setAttribute("admin","管理者");
			response.sendRedirect("/NANIKA/AdminServlet");
		}else if(iDao.isLoginOK(email,pw)) {
			//ユーザIDとnameを取得
			UserBeans userbeans = iDao.login(email,pw);
			System.out.println("----------------LoginServlet");
			System.out.println("ユーザ："+ userbeans.getAccount_name());
			System.out.println("ユーザID："+ userbeans.getUser_id());
			System.out.println("ユーザのemail："+ userbeans.getEmail());

			// セッションスコープにIDを格納する

			session.setAttribute("userbeans", userbeans);
			// ホームサーブレットにリダイレクトする。ページが変わるのでリダイレクトを使用している。
			response.sendRedirect("/NANIKA/HomeServlet");
		}else {

			// リクエストスコープにエラーメッセージを設定
			request.setAttribute("err","IDまたはPWに間違いがあります。");
			this.doGet(request, response);

		}

	}

}
