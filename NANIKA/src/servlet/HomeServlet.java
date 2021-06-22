package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ScoreDao;
import model.NanikaBeans;
import model.UserBeans;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// キャッシュを無効にする
		response.setHeader("Pragma","no-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires",0);

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		UserBeans userbeans = (UserBeans)session.getAttribute("userbeans");
		String userName = userbeans.getAccount_name();
		session.setAttribute("userName", userName);

		try {

			if (userbeans.getAccount_name() == null) {
//				return;
			}

			//Daoからスコアをとってくる
			ScoreDao scoreDao = new ScoreDao();
			//引数とメソッドの名前と戻り値の型を聞く　引数( nanikaBeans )userbeansGetUser_id List型返り値 radarData　scoreDao
			ArrayList<NanikaBeans> list = (ArrayList<NanikaBeans>)scoreDao.radarData(userbeans.getUser_id());
			//セッション領域にセット
			session.setAttribute("list",list);
			//ホームページに遷移
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
			dispatcher.forward(request, response);

			for (NanikaBeans nanika : list) {
				System.out.println("----------------HomeServlet");
				System.out.println("ユーザID:"+nanika.getUser_id());
				System.out.println("テスト科目:"+nanika.getSubject());
				System.out.println("最新の平均点:"+nanika.getScore());
				System.out.println();
			}

			// メニューページにフォワードする
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
//			dispatcher.forward(request, response);

		}catch(NullPointerException e) {
			System.out.println("--------------------HomeServlet(doGet)");
			System.out.println("ログイン画面へ戻す（userbeansがsessionに存在しない為）");
			response.sendRedirect("/NANIKA/LoginServlet");
		}



	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
