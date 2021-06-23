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
import dao.UnitDao;
import model.NanikaBeans;

/**
 * Servlet implementation class UnitServlet
 */
@WebServlet("/UnitServlet")
public class UnitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// キャッシュを無効にする
		response.setHeader("Pragma","no-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires",0);

//		HttpSession session = request.getSession();
//		session.getAttribute("id");
		HttpSession session = request.getSession();
//		List subject = (List) sessionsubject.getAttribute("list");

		int index = 0;
		session.setAttribute("index", index);

		int subjectId = Integer.parseInt((String)session.getAttribute("subject_id"));
		String menuTab = (String)session.getAttribute("menu_tab");
		UnitDao uDao = new UnitDao();
		List<NanikaBeans> UnitList = uDao.selectUnit(subjectId);
		request.setAttribute("UnitList", UnitList);

		int unitId = 0;

		if(session.getAttribute("unitId") == null) {
			System.out.println("nullだよ");
		}else {
			unitId = (int)session.getAttribute("unitId");
			System.out.println(unitId);
		}

		if(menuTab.equals("テスト受験")) {
			QuestionsDao qDao = new QuestionsDao();
			if(qDao.countQuestion(unitId) == false && qDao.testQuestion(unitId) == null) {
				request.setAttribute("error","問題が存在しません");
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/test_list_unit.jsp");
			dispatcher.forward(request, response);
		}

		if(menuTab.equals("テスト結果一覧")) {
			QuestionsDao qDao = new QuestionsDao();
			if(qDao.countQuestion(unitId) == false && qDao.testQuestion(unitId) == null) {
				request.setAttribute("error","問題が存在しません");
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result_list_unit.jsp");
			dispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// キャッシュを無効にする
		response.setHeader("Pragma","no-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires",0);

		request.setCharacterEncoding("UTF-8");
		String param1 = request.getParameter("param1");
		String param2 = request.getParameter("param2");
		System.out.println(param1+"+"+param2);
		HttpSession session = request.getSession();
		session.setAttribute("subject_id", param1);
		session.setAttribute("subjectName", param2);

		response.sendRedirect("/NANIKA/UnitServlet");
	}

}
