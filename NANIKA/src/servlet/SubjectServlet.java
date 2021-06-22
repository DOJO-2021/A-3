package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SubjectServlet")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// キャッシュを無効にする
		response.setHeader("Pragma","no-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires",0);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/test_list_subject.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// キャッシュを無効にする
		response.setHeader("Pragma","no-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires",0);

		String param = request.getParameter("param");

		System.out.println(param);
		HttpSession session = request.getSession();
		session.setAttribute("subject_id", param);

		response.sendRedirect("/NANIKA/UnitServlet");

	}

}
