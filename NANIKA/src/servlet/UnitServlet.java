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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		session.getAttribute("id");
		HttpSession sessionsubject = request.getSession();
		NanikaBeans subject = (NanikaBeans)sessionsubject.getAttribute("subject");

		UnitDao uDao = new UnitDao();
		List<NanikaBeans> UnitList = UnitDao.selectUnit(subject);
		request.setAttribute("UnitList", UnitList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/test_list_unit.jsp");
		dispatcher.forward(request, response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
