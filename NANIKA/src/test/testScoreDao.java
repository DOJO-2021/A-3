package test;

import java.util.List;

import dao.ScoreDao;
import model.NanikaBeans;

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

			System.out.println();
			System.out.println();
		}

	}

}
