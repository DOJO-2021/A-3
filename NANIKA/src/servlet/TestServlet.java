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
import model.QuestionBeans;

//TestServlet(uniiが押された後に飛んできてテスト受験画面に遷移する)
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();


		if(request.getParameter("unit_id") != null) {
			int unitId = Integer.parseInt((String)request.getParameter("unit_id"));
			String unitName = request.getParameter("unit_name");
			System.out.println(unitId+"+"+unitName);
			session.setAttribute("unitId", unitId);
			session.setAttribute("unitName", unitName);

			//QuestionsDaoから単元に当てはまるテスト問題を持ってくる
			QuestionsDao qDao = new QuestionsDao();
			List<QuestionBeans> questList = qDao.testQuestion(unitId);

			//テスト問題をリクエストスコープに入れる
			session.setAttribute("questList", questList);
		}

		//テスト受験画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/test.jsp");
		dispatcher.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");

	}

}
