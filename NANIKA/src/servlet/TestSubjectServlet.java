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
 * テスト受験
 */
@WebServlet("/TestSubjectServlet")
public class TestSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestSubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//		パンくずリスト用のスコープ（home　＞　テスト受験）
		HttpSession  session = request.getSession();
		session.setAttribute("menu_tab", "テスト受験");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/test_list_subject.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param1 = request.getParameter("param1");
		String param2 = request.getParameter("param2");
		System.out.println(param1+"+"+param2);
		HttpSession session = request.getSession();
		session.setAttribute("subject_id", param1);
		HttpSession subject = request.getSession();
		subject.setAttribute("subjectName", param2);

		response.sendRedirect("/NANIKA/UnitServlet");
	}

}
