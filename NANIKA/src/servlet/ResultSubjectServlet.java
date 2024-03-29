package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * テスト結果一覧
 */
@WebServlet("/ResultSubjectServlet")
public class ResultSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// キャッシュを無効にする
		response.setHeader("Pragma","no-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires",0);

//		パンくずリスト用のスコープ（テスト結果一覧）
		HttpSession  session = request.getSession();
		session.setAttribute("menu_tab", "テスト結果一覧");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result_list_subject.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// キャッシュを無効にする
		response.setHeader("Pragma","no-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires",0);

		String param1 = request.getParameter("param1");
		String param2 = request.getParameter("param2");
		System.out.println(param1+"+"+param2);
		HttpSession session = request.getSession();
		session.setAttribute("subject_id", param1);
		session.setAttribute("subjectName", param2);

		response.sendRedirect("/NANIKA/UnitServlet");
	}

}
