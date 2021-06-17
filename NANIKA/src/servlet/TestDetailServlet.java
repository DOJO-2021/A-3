package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserScoreDao;
import model.Bc;
import model.NanikaBeans;

/**
 * Servlet implementation class TestDetailServlet
 */
@WebServlet("/TestDetailServlet")
public class TestDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ログイン確認処理
//		HttpSession session = request.getSession();
//		if (session.getAttribute("user_id") == null) {
//			response.sendRedirect("/NANIKA/LoginServlet");
//			return;
//		}
		//スコアテーブルのデータをもらう処理
		UserScoreDao sDao = new UserScoreDao();
		List<NanikaBeans> unitscoreList = sDao.select(new Bc(0, "", "", "", "",
				"", "", "", "", "", "", "", "", "", null));
		request.setAttribute("unitscoreList", unitscoreList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/test_detail.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
