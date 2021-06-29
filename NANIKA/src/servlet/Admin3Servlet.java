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
 * Servlet implementation class Admin3Servlet
 */
@WebServlet("/Admin3Servlet")
public class Admin3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin3Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int select_subject_admin = Integer.parseInt((String)session.getAttribute("subject_id_admin"));
		UnitDao uDao = new UnitDao();
		List<NanikaBeans> UnitList2 = uDao.selectUnit(select_subject_admin);
//		選択された科目の単元一覧と、単元ID
		session.setAttribute("UnitList2", UnitList2);

//		List<List<NanikaBeans>> questionList = new ArrayList<List<NanikaBeans>>();  //選択された科目の問題情報格納用
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin3.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String unit_id_admin = request.getParameter("unit_id");
//		System.out.println(subject_id_admin+"+");
		HttpSession session = request.getSession();
		session.setAttribute("unit_id_admin", unit_id_admin);
		response.sendRedirect("/NANIKA/Admin4Servlet");
	}

}






