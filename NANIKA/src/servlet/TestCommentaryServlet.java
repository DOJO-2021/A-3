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

/**
 * Servlet implementation class TestCommentaryServlet
 */
@WebServlet("/TestCommentaryServlet")
public class TestCommentaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestCommentaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/test_commentary.jsp");
		dispatcher.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

		HttpSession session = request.getSession();
		//テスト詳細画面の解説ボタンでPOSt
		//パラメータの取得
		//test_detail.jspの「解説ボタン」formのsubmitされたものを貰う。
		NanikaBeans nanikaBeans = (NanikaBeans) session.getAttribute("userbeans");
		int user_id = nanikaBeans.getUnit_id();
//		int unit_id = Integer.parseInt(request.getParameter("unit_id"));

		String start_time = request.getParameter("start_time");
		//QuestionDao(questionDao)をインスタンス
		QuestionsDao questionsDao = new QuestionsDao();
		//questionDaoのメソッドでselectする　おそらく返り値はNanikabeans;(返り値は未定)
		List queston_report  = questionsDao.getUserCommentary(user_id, start_time);
		//sessionスコープに入れてリダイレクトする
		session.setAttribute("queston_report", queston_report );

		this.doGet(request, response);



	}

}
