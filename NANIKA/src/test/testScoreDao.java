package test;

import java.util.List;

import dao.QuestionsDao;
import dao.ScoreDao;
import dao.UnitDao;
import model.NanikaBeans;
import model.QuestionBeans;

public class testScoreDao {

	public static void main(String[] args) {
		ScoreDao dao = new ScoreDao();

		// radarData()のテスト
		System.out.println("---------- radarData()のテスト ----------");
		List<NanikaBeans> nanikaList = dao.radarData(1);

		for (NanikaBeans nanika : nanikaList) {
			System.out.println(nanika.getUser_id());
			System.out.println(nanika.getSubject());
			System.out.println(nanika.getScore());
			System.out.println(nanika.getSubject_id());

			System.out.println();
			System.out.println();
		}

		// UnitDao()のテスト
		UnitDao dao1 = new UnitDao();

		System.out.println("---------- UnitDao()のテスト ----------");
		List<NanikaBeans> UnitList = dao1.selectUnit(1);

		for (NanikaBeans unit : UnitList) {
			System.out.println(unit.getUnit_id());
			System.out.println(unit.getUnit());
			System.out.println(unit.getSubject_id());

			System.out.println();
			System.out.println();
		}



		// QuestionsDao()のテスト
		QuestionsDao dao2 = new QuestionsDao();

		System.out.println("---------- QuestionsDao()のテスト ----------");
		List<NanikaBeans> comentaryList = dao2.getUserCommentary(1,"2021/06/14 14:36:00");

		for (NanikaBeans  comentary : comentaryList ) {
			System.out.println(comentary.getUser_id());
			System.out.println(comentary.getStart_time());
			System.out.println(comentary.getQuestion());
			System.out.println(comentary.getCommentary());
			System.out.println(comentary.getAnswer_commentary1());
			System.out.println(comentary.getAnswer_commentary2());
			System.out.println(comentary.getAnswer_commentary3());
			System.out.println(comentary.getAnswer_commentary4());
			System.out.println(comentary.getAnswer1());
			System.out.println(comentary.getAnswer2());
			System.out.println(comentary.getAnswer3());
			System.out.println(comentary.getAnswer4());
			System.out.println(comentary.getUser_answer());

			System.out.println();
			System.out.println();
		}



		// QuestionsDao()のテスト
		QuestionsDao dao3 = new QuestionsDao();

		System.out.println("---------- QuestionsDao()のテスト ----------");
		List<QuestionBeans> testQuestionList = dao3.testQuestion(1);

		for (QuestionBeans qb  : testQuestionList ) {
			System.out.println(qb.getQuestion_id());
			System.out.println(qb.getUnit_id());
			System.out.println(qb.getQuestion());
			System.out.println(qb.getAnswer1());
			System.out.println(qb.getAnswer2());
			System.out.println(qb.getAnswer3());
			System.out.println(qb.getAnswer4());
			System.out.println(qb.getAnswer());

			System.out.println();
			System.out.println();
		}

	}
}
