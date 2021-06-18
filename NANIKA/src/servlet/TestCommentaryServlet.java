package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuestionsDao;

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

		//テスト詳細画面の解説ボタンでPOSt
		//パラメータの取得
		int unit_id = request.getParameter("〇〇〇〇");
		String start_time = request.getParameter("〇〇〇〇");
		//QuestionDao(questionDao)をインスタンス
		QuestionsDao questionsDao = new QuestionsDao();
		//questionDaoのメソッドでselectする　おそらく返り値はNanikabeans;(返り値は未定)
		List queston_report  = (〇〇型)questionsDao.〇〇〇(〇〇〇);
		//sessionスコープに入れてリダイレクトする
		HttpSession session = request.getSession();
		session.setAttribute("〇〇〇", queston_report );

		this.doGet(request, response);



	}

}
