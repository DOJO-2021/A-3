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
import model.UserBeans;

/**
 * Servlet implementation class TestDetailServlet
 */
@WebServlet("/TestDetailServlet")
public class TestDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("unit_id") != null) {
			String unitId = request.getParameter("unit_id");
			System.out.println(unitId);
			HttpSession session = request.getSession();
			session.setAttribute("unitId", unitId);
		}

		//		ログイン確認処理
		HttpSession session = request.getSession();
		UserBeans userbeans = (UserBeans) session.getAttribute("userbeans");
		int unitId = Integer.parseInt((String)session.getAttribute("unitId"));
		int userId = userbeans.getUser_id();

		//スコアテーブルのデータをもらう処理
		ScoreDao sDao = new ScoreDao();
		List<NanikaBeans> scoreall = sDao.scoreAll(userId, unitId);

		request.setAttribute("scoreall", scoreall);
		for (NanikaBeans nanika : scoreall) {
			System.out.println("----------------ResultServlet");
			System.out.println("ユーザID:"+ nanika.getUser_id());
			System.out.println("テスト科目:"+ nanika.getUnit());
			System.out.println();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/test_detail.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
