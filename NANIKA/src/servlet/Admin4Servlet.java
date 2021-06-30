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

		unit_id_admin = Integer.parseInt((String)session.getAttribute("unit_id_admin"));

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
		request.setCharacterEncoding("UTF-8");
		String question_id = request.getParameter("question_id");
		String unit_id = request.getParameter("unit_id");
		int question_id_int = Integer.parseInt(question_id);
		int unit_id_int = Integer.parseInt(unit_id);

		String field1 = request.getParameter("field1");     //問題文
		String field2 = request.getParameter("field2");     //解説

		String field3 = request.getParameter("field3");     //選択肢1
		String field4 = request.getParameter("field4");     //解説1

		String field5 = request.getParameter("field5");     //選択肢2
		String field6 = request.getParameter("field6");     //解説2

		String field7 = request.getParameter("field7");     //選択肢3
		String field8 = request.getParameter("field8");     //解説3

		String field9 = request.getParameter("field9");     //選択肢4
		String field10 = request.getParameter("field10");   //解説4

		String field11 = request.getParameter("field11");   //解答

		System.out.println("----question_id " + question_id);
		System.out.println("----unit_id " +unit_id );
		System.out.println("----field1 問題文 " +field1 );
		System.out.println("----field1 解説 " +field2 );
		System.out.println("----field1 選択肢1 " +field3 );
		System.out.println("----field1 解説1 " +field4 );
		System.out.println("----field1 選択肢2 " +field5 );
		System.out.println("----field1 解説2 " +field6 );
		System.out.println("----field1 選択肢3 " +field7 );
		System.out.println("----field1 解説3 " +field8 );
		System.out.println("----field1 選択肢4 " +field9 );
		System.out.println("----field1 解説4 " +field10 );
		System.out.println("----field1 解答 " +field11 );



//		NanikaBeans nanika =
//				new NanikaBeans(unit_id_int,question_id_int,field1,field2,  field4,field6,field8,field10,  field3,field5,field7,field9, field11);
		NanikaBeans nanika =
				new NanikaBeans(unit_id_int,question_id_int,field1,field2,field3,field4,field5,field6,field7,field8,field9,field10,field11);
		AdminDao adminDao = new AdminDao();
		if(adminDao.insert_questions(nanika)) {
			request.setAttribute("result", "変更しました。");
			this.doGet(request, response);
			System.out.println("--------------------------------Admin4Servlet  insert_questions = true");
			System.out.println("--------------------------------Admin4Servlet  変更完了");
		}
//		HttpSession session = request.getSession();
//		System.out.println("--------------------------------Admin4Servlet  insert_questions =false");

















	}












}
