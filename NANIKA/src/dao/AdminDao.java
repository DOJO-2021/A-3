package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.NanikaBeans;

public class AdminDao {
	public List<NanikaBeans> selectUnit2(int subject_id) {
		//箱を準備
		Connection conn = null;
		List<NanikaBeans> UnitList = new ArrayList<NanikaBeans>();

		//船を準備
		PreparedStatement pStmt=null;

		try {
			//JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			//データベースに接続
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/A-3/NANIKA/database","sa","");

			//SELECT文を準備
			String sql = "Select * from table_unit  where subject_id = ?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,subject_id);

			//SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
						while (rs.next()) {
							NanikaBeans unit = new NanikaBeans(
							rs.getInt("unit_id"),
							rs.getString("unit"),
							rs.getInt("subject_id")
							);
						UnitList.add(unit);
					}


		}
		catch (SQLException e) {
			e.printStackTrace();
			UnitList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			UnitList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					UnitList = null;
				}
			}
		}
		// 結果を返す
		return UnitList;
	}

	public List<NanikaBeans> subject2() {
		//箱を準備
		Connection conn = null;
		List<NanikaBeans> subject2 = new ArrayList<NanikaBeans>();

		//船を準備
		PreparedStatement pStmt=null;

		try {
			//JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			//データベースに接続
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/A-3/NANIKA/database","sa","");

			//SELECT文を準備
			String sql = "Select * from table_subject";
			pStmt = conn.prepareStatement(sql);

			//SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
						while (rs.next()) {
							NanikaBeans unit = new NanikaBeans(
							rs.getInt("subject_id"),
							rs.getString("subject")

							);
							subject2.add(unit);
					}


		}
		catch (SQLException e) {
			e.printStackTrace();
			subject2 = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			subject2 = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					subject2 = null;
				}
			}
		}
		// 結果を返す
		return subject2;
	}

	public List<NanikaBeans> getQuestions_admin(int unit_id) {
		//箱を準備
		Connection conn = null;
		List<NanikaBeans> Questions = new ArrayList<NanikaBeans>();

		//船を準備
		PreparedStatement pStmt=null;

		try {
			//JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			//データベースに接続
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/A-3/NANIKA/database","sa","");

			//SELECT文を準備
			String sql = "Select * from table_question where unit_id = ?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,unit_id);

			//SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
						while (rs.next()) {
							NanikaBeans question = new NanikaBeans(
							rs.getInt("QUESTION_ID"),
							rs.getInt("UNIT_ID"),
							rs.getString("QUESTION"),
							rs.getString("COMMENTARY"),
							rs.getString("ANSWER_COMMENTARY1"),
							rs.getString("ANSWER_COMMENTARY2"),
							rs.getString("ANSWER_COMMENTARY3"),
							rs.getString("ANSWER_COMMENTARY4"),
							rs.getString("ANSWER1"),
							rs.getString("ANSWER2"),
							rs.getString("ANSWER3"),
							rs.getString("ANSWER4"),
							rs.getString("ANSWER")
							);
							Questions.add(question);
					}


		}
		catch (SQLException e) {
			e.printStackTrace();
			Questions = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			Questions = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					Questions = null;
				}
			}
		}
		// 結果を返す
		return Questions;
	}
}
