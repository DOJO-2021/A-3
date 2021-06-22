package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuestionsDao;
import model.NanikaBeans;
import model.UserBeans;

@WebServlet("/TestCommentaryServlet")
public class TestCommentaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// キャッシュを無効にする
		response.setHeader("Pragma","no-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires",0);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/test_commentary.jsp");
		dispatcher.forward(request, response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// キャッシュを無効にする
		response.setHeader("Pragma","no-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires",0);

		HttpSession session = request.getSession();
		//テスト詳細画面の解説ボタンでPOSt
		//パラメータの取得
		//test_detail.jspの「解説ボタン」formのsubmitされたものを貰う。
		UserBeans nanikaBeans = (UserBeans) session.getAttribute("userbeans");
		int user_id = nanikaBeans.getUser_id();
		//int unit_id = Integer.parseInt((String)session.getAttribute("unit_id"));

		String start_time = request.getParameter("start_time");
		//QuestionDao(questionDao)をインスタンス
		QuestionsDao questionsDao = new QuestionsDao();
		//questionDaoのメソッドでselectする　おそらく返り値はNanikabeans;(返り値は未定)
		List<NanikaBeans> queston_report = questionsDao.getUserCommentary(user_id, start_time);
		//sessionスコープに入れてリダイレクトする
		session.setAttribute("queston_report", queston_report );

		this.doGet(request, response);



	}

}
