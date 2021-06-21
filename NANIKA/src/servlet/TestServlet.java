package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuestionsDao;
import dao.ScoreDao;
import model.NanikaBeans;
import model.QuestionBeans;
import model.ScoreBeans;
import model.UserBeans;

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
		HttpSession session = request.getSession();
		UserBeans nanikaBeans = (UserBeans) session.getAttribute("userbeans");
		int user_id = nanikaBeans.getUser_id();
		int unit_id = (int)session.getAttribute("unitId");

		//開始時刻取得
		Date TimeStamp = new Date();
		SimpleDateFormat d1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String start_time = String.valueOf(d1.format(TimeStamp));

		// リクエストパラメータを取i得する
		request.setCharacterEncoding("UTF-8");
		ScoreDao sDao = new ScoreDao();

		int count = 0;
		int index = 0;
		int result = 0;
		for(int i = 1;i<20;i++) {
			if(request.getParameter("questionid"+i) == null) {
				int score = (count/index)*100;
				System.out.println(score);
				if(score>=80) {
					result = 1;
				}
				System.out.println(result);
				//insertする(user_id、unit_id、start_time、end_time、score、result);
				boolean score_result = sDao.insert_table_score(new ScoreBeans(user_id,unit_id,start_time,start_time,score,result));
				if(score_result) {
					System.out.println("登録成功");
				}else {
					System.out.println("登録失敗");
				}
				break;
			}else{
				index++;
			}
			String answer = request.getParameter("answer"+i);
			String user_answer = request.getParameter("radiobutton"+i);
			if(answer.equals(user_answer)) {
				count++;
			}
		}

		for(int i = 1;i<20;i++) {
			if(request.getParameter("questionid"+i) == null) {
				break;
			}
			int question_id = Integer.parseInt((String)request.getParameter("questionid"+i));
			String user_answer = request.getParameter("radiobutton"+i);
			boolean user_result = sDao.insert_table_user_score(new NanikaBeans(user_id,question_id,start_time,user_answer));

			if(user_result) {
				System.out.println("登録成功");
			}else {
				System.out.println("登録失敗");
			}

		}



		//TestResultServletにリダイレクト
		response.sendRedirect("/NANIKA/TestResultServlet");

	}

}