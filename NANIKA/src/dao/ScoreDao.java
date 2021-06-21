package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.NanikaBeans;

public class ScoreDao {
	public List<NanikaBeans> radarData(int user_id){
		List<NanikaBeans> scoreList = new ArrayList<NanikaBeans>();
		Connection conn = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する（仮）
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/A-3/NANIKA/database", "sa", "");

			// SELECT文を準備する
			String sql = "select s.user_id , sub.subject, avg(score), sub.subject_id from table_score  s inner join  table_unit  u on  s.unit_id = u.unit_id inner join  table_subject  sub  on  u.subject_id = sub.subject_id where user_id = ? and (u.unit_id,end_time) in (select unit_id, max(end_time) from table_score group by unit_id) group by  s.user_id ,  sub.subject";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, user_id);

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				NanikaBeans score = new NanikaBeans(
				rs.getInt("user_id"),
				rs.getString("subject"),
				rs.getInt("avg(score)"),
				rs.getInt("subject_id")
				);
			scoreList.add(score);
		}
		}
		catch (SQLException e) {
			e.printStackTrace();
			scoreList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			scoreList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					scoreList = null;
				}
			}
		}
		// 結果を返す
		return scoreList;
	}



	//1.4テスト詳細画面用
	public List<NanikaBeans> scoreAll(int user_id, int unit_id){
		List<NanikaBeans> scoreall = new ArrayList<NanikaBeans>();
		Connection conn = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する（仮）
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/A-3/NANIKA/database", "sa", "");

			// SELECT文を準備する
			String sql = "select s.user_id, s.start_time, s.end_time, uni.unit, s.result  from table_score s "
					+ "inner join table_user u on u.user_id = s.user_id "
					+ "inner join table_unit uni on uni.unit_id = s.unit_id "
					+ "where s.user_id = ? AND uni.unit_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, user_id);
			pStmt.setInt(2, unit_id);

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				NanikaBeans score = new NanikaBeans(
				rs.getInt("user_id"),
				rs.getString("unit"),
				rs.getString("start_time"),
				rs.getString("end_time"),
				rs.getInt("result")
				);
				scoreall.add(score);
		}
		}
		catch (SQLException e) {
			e.printStackTrace();
			scoreall = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			scoreall = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					scoreall = null;
				}
			}
		}
		// 結果を返す
		return scoreall;
	}

	//選択した答えをinsertする
	public boolean insert(Nanika answer) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/A-3/NANIKA/database", "sa", "");

			// SQL文を準備する
			String sql = "insert into 作成したテーブル values (null,null,?,?)"


		}

}
