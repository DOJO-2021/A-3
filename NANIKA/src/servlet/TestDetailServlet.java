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

import dao.ScoreDao;
import model.NanikaBeans;

/**
 * Servlet implementation class TestDetailServlet
 */
@WebServlet("/TestDetailServlet")
public class TestDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ログイン確認処理
		HttpSession session = request.getSession();
		int userId = Integer.parseInt((String)session.getAttribute("userbeans"));
		int unitId = Integer.parseInt((String)session.getAttribute("unitId"));
//		if (session.getAttribute("user_id") == null) {
//			response.sendRedirect("/NANIKA/LoginServlet");
//			return;
//		}
//		HttpSession session = request.getSession();
//		UserBeans UserBeans = (UserBeans)session.getAttribute("userbeans");
		//スコアテーブルのデータをもらう処理
		ScoreDao sDao = new ScoreDao();
		List<NanikaBeans> scoreall = sDao.scoreAll(userId, unitId);

		request.setAttribute("scoreall", scoreall);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/test_detail.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
