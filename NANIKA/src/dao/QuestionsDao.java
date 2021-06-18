package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.NanikaBeans;

public class QuestionsDao {

	//ユーザの受けたテストの解説情報の取得（ユーザ解説画面で使用）
		public List<NanikaBeans> getUserCommentary(int user_id,  String start_time){
			List<NanikaBeans> comentaryList = new ArrayList<NanikaBeans>();
			Connection conn = null;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する（仮）
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/A-3/NANIKA/database", "sa", "");

				// SELECT文を準備する //table_user_scoreのquestion_id などはテスト受験後に値が入力されているはず...
				String sql = "select  us.user_id, us.question_id, us.user_answer, us.start_time , "
						+ "q.question, q.commentary, q.answer_commentary1, q.answer_commentary2, "
						+ "q.answer_commentary3, q.answer_commentary4, q.answer1, q.answer2, q.answer3, "
						+ "q.answer4, q.answer "
						+ "from table_user_score us "
						+ "inner join table_question q  on  us.question_id  = q.question_id "
						+ "where us.user_id = ?  and  us.start_time = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				//-----  ---------------------------
				pStmt.setInt(1, user_id);
				pStmt.setString(2, start_time);
				//------

				// SELECT文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					NanikaBeans comentary = new NanikaBeans(
					//--------------------   変更しないといけない。   ---------------------------
					rs.getInt("user_id"),
					rs.getString("start_time"),
					rs.getInt("question_id"),
					rs.getString("question"),
					rs.getString("commentary"),
					rs.getString("answer_commentary1"),
					rs.getString("answer_commentary2"),
					rs.getString("answer_commentary3"),
					rs.getString("answer_commentary4"),
					rs.getString("answer1"),
					rs.getString("answer2"),
					rs.getString("answer3"),
					rs.getString("answer4"),
					rs.getString("answer"),
					rs.getString("user_answer")

					//------
					);
				comentaryList.add(comentary);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				comentaryList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				comentaryList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						comentaryList = null;
					}
				}
			}
			// 結果を返す
			return comentaryList;
		}



}
