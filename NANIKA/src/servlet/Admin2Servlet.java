package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import model.NanikaBeans;

/**
 * Servlet implementation class Admin2Servlet
 */
@WebServlet("/Admin2Servlet")
public class Admin2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDao adminDao = new AdminDao();
		List<List<NanikaBeans>> UnitList_admin = new ArrayList<List<NanikaBeans>>();
		for(int i=1; i<6; i++) {
			UnitList_admin.add(adminDao.selectUnit2(i));
		}
		List<NanikaBeans> subject_admin = new ArrayList<NanikaBeans>();
		subject_admin = adminDao.subject2();

		HttpSession session = request.getSession();
		session.setAttribute("UnitList_admin", UnitList_admin);
		session.setAttribute("subject_admin", subject_admin);


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin2.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String subject_id_admin = request.getParameter("subject_id");
		System.out.println(subject_id_admin+"+");
		HttpSession session = request.getSession();
		session.setAttribute("subject_id_admin", subject_id_admin);
		response.sendRedirect("/NANIKA/Admin3Servlet");
	}

}
