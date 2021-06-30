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
			String sql = "Select * from table_question q left join table_unit u  "
					+ " on q.unit_id = u.unit_id "
					+ " where q.unit_id = ?";
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
							rs.getString("ANSWER"),
							rs.getString("UNIT")
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





	// テスト編集  Admin4Servletで使用
		public boolean insert_questions(NanikaBeans param) {
			Connection conn = null;
			boolean result = false;
			//UserBeans userbeans=null; //返り値用


			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する（仮）
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/A-3/NANIKA/database", "sa", "");

				// INSERT文を準備する
				String sql = "update table_question set "
						+ "question = ? ,"
						+ "commentary = ? ,"
						+ "answer_commentary1 = ? ,"
						+ "answer_commentary2 = ? ,"
						+ "answer_commentary3 = ? ,"
						+ "answer_commentary4 = ? ,"
						+ "answer1 = ? ,"
						+ "answer2 = ? ,"
						+ "answer3 = ? ,"
						+ "answer4 = ? ,"
						+ "answer = ?  "
						+ " where question_id  = ?  and unit_id = ?";

				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, param.getQuestion());
				pStmt.setString(2, param.getCommentary());
				pStmt.setString(3, param.getAnswer_commentary1());
				pStmt.setString(4, param.getAnswer_commentary2());
				pStmt.setString(5, param.getAnswer_commentary3());
				pStmt.setString(6, param.getAnswer_commentary4());
				pStmt.setString(7, param.getAnswer1());
				pStmt.setString(8, param.getAnswer2());
				pStmt.setString(9, param.getAnswer3());
				pStmt.setString(10, param.getAnswer4());
				pStmt.setString(11, param.getAnswer());
				pStmt.setInt(12, param.getQuestion_id());
				pStmt.setInt(13, param.getUnit_id());


				// INSERT文を正常に実行できたかの判断
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}


			}
			catch (SQLException e) {
				e.printStackTrace();
//				loginResult = false;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
//				loginResult = false;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
//						loginResult = false;
					}
				}
			}
			// 結果を返す
			return result;


		}









}
