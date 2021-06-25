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

@WebServlet("/TestDetailServlet")
public class TestDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// キャッシュを無効にする
		response.setHeader("Pragma","no-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires",0);

		if(request.getParameter("unit_id") != null) {
			String unitId = request.getParameter("unit_id");
			System.out.println(unitId);
			HttpSession session = request.getSession();
			session.setAttribute("unitId", unitId);
		}

		HttpSession session = request.getSession();
		UserBeans userbeans = (UserBeans) session.getAttribute("userbeans");

		try {
		//		ログイン確認処理

		int unitId = Integer.parseInt((String)session.getAttribute("unitId"));
		int userId = userbeans.getUser_id();
		request.setAttribute("unit_id", unitId);

		//スコアテーブルのデータをもらう処理
		ScoreDao sDao = new ScoreDao();
		List<NanikaBeans> scoreall = sDao.scoreAll(userId, unitId);

		request.setAttribute("scoreall", scoreall);
		for (NanikaBeans nanika : scoreall) {
			System.out.println("----------------ResultServlet");
			System.out.println("ユーザID:"+ nanika.getUser_id());
			System.out.println("テスト科目:"+ nanika.getUnit());
			System.out.println(nanika.getScore());
			System.out.println();
		}



		}catch(ClassCastException e) {
			int unitId = (int)session.getAttribute("unitId");
			int userId = userbeans.getUser_id();
			request.setAttribute("unit_id", unitId);

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
		}finally{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/test_detail.jsp");
			dispatcher.forward(request, response);
		}
	}

}
