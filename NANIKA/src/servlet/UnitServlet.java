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

import dao.UnitDao;
import model.NanikaBeans;

/**
 * Servlet implementation class UnitServlet
 */
@WebServlet("/UnitServlet")
public class UnitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		session.getAttribute("id");
		HttpSession session = request.getSession();
//		List subject = (List) sessionsubject.getAttribute("list");


		int subjectId = Integer.parseInt((String)session.getAttribute("subject_id"));
		UnitDao uDao = new UnitDao();
		List<NanikaBeans> UnitList = uDao.selectUnit(subjectId);
		request.setAttribute("UnitList", UnitList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/test_list_unit.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("param");

		System.out.println(param);
		HttpSession session = request.getSession();
		session.setAttribute("subject_id", param);

		response.sendRedirect("/NANIKA/UnitServlet");
	}

}
