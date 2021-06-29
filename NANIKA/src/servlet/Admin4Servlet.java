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
 * Servlet implementation class Admin4Servlet
 */
@WebServlet("/Admin4Servlet")
public class Admin4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin4Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		//選択された単元をもってくる
		int unit_id_admin=1;
		try {
		unit_id_admin = Integer.parseInt((String)session.getAttribute("unit_id_admin"));
		}catch(NumberFormatException e) {
			e.printStackTrace();
			unit_id_admin=1;
			this.doGet(request, response);
		}
		//選択された単元の問題をとってくる
		AdminDao adminDao = new AdminDao();
		List<NanikaBeans> QuestionList = new ArrayList<NanikaBeans>();//格納用
		//選択された単元の各問題情報を取得
		QuestionList = adminDao.getQuestions_admin(unit_id_admin);
		session.setAttribute("QuestionList", QuestionList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin4.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
