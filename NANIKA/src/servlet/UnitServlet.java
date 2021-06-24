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

import dao.ScoreDao;
import dao.UnitDao;
import model.NanikaBeans;
import model.UserBeans;

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

//（追加処理）
		int[] unit_ids = uDao.unitCount_for(subjectId);
		System.out.println("---------------unit_ids[0] "+unit_ids[0]);
		System.out.println("---------------unit_ids[1] "+unit_ids[1]);
		UserBeans userbeans = (UserBeans) session.getAttribute("userbeans");
		ScoreDao sDao = new ScoreDao();
		List<List<NanikaBeans>> UnitList_score = new ArrayList<List<NanikaBeans>>();
//		List<NanikaBeans>[] UnitList_score = new List[5];
		var count= 0;
		for(int i = unit_ids[0]; i< unit_ids[1]+1; i++) {
//			UnitList_score.add((List<NanikaBeans>) sDao.scoreNew(userbeans.getUser_id(), i));
//			System.out.println("-----------------UnitList_score.get(i) "+UnitList_score.get(i).get(i));
			try {

//				List<NanikaBeans> AA = sDao.scoreNew(userbeans.getUser_id(), i);
//				if(AA != null ) {
//					UnitList_score[i] = sDao.scoreNew(userbeans.getUser_id(), i);
//				}else {
//					List<NanikaBeans> aa = new ArrayList<NanikaBeans>();
//					NanikaBeans nn = new NanikaBeans();
//					aa.add(nn);
//					UnitList_score[i] = aa;
//				}

//				UnitList_score[count] = sDao.scoreNew2(userbeans.getUser_id(), i,subjectId);
				UnitList_score.add(sDao.scoreNew2(userbeans.getUser_id(), i,subjectId));

//				System.out.println("-------------UnitList_score Score  "+UnitList_score.get(0).get(count).getScore());
//				System.out.println(UnitList_score[count] +" Unit: "+i);
//				System.out.println(UnitList_score[count].get(0).getScore() +" count:"+count);
//				System.out.println(UnitList_score[count] +" count:"+count);
				count+= 1;
				System.out.println("count "+count);
//				System.out.println(UnitList_score[i].get(0).getUnit() +" Unit: "+i);
			}catch(IndexOutOfBoundsException e) {
//				List<NanikaBeans> aa = new ArrayList<NanikaBeans>();
//				NanikaBeans nn = new NanikaBeans();
//				aa.add(nn);
//				UnitList_score[i] = aa;
//				return;
				e.printStackTrace();
			}
		}
//		System.out.println("---------------UnitList_score.size "+UnitList_score.size());
		request.setAttribute("UnitList_score", UnitList_score);


		if(menuTab.equals("テスト受験")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/test_list_unit.jsp");
			dispatcher.forward(request, response);
		}

		if(menuTab.equals("テスト結果一覧")) {
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
