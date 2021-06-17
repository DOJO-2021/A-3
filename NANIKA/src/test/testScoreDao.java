package test;

import java.util.List;

import dao.ScoreDao;
import dao.UnitDao;
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
	}
}
