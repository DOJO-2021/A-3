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

@WebServlet("/TestResultServlet")
public class TestResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TestResultServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserBeans userbeans = (UserBeans) session.getAttribute("userbeans");
		int userId = userbeans.getUser_id();
		int unitId = (int)session.getAttribute("unitId");
		request.setAttribute("unit_id", unitId);

		ScoreDao nDao = new ScoreDao();
		List<NanikaBeans> scorenew = nDao.scoreNew(userId, unitId);

		request.setAttribute("scorenew", scorenew);
		for(NanikaBeans nanika : scorenew) {
			System.out.println("----------------TestServlet");
			System.out.println("ユーザID:"+ nanika.getUser_id());
			System.out.println("テスト科目:"+ nanika.getUnit());
			System.out.println("開始時間:"+ nanika.getStart_time());
			System.out.println("終了時間:"+ nanika.getEnd_time());
			System.out.println("正解率:"+ nanika.getScore());
			System.out.println("合否:"+ nanika.getResult());
			System.out.println();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/test_result.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
