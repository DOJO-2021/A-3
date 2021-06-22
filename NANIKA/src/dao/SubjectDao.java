package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.SubjectBeans;

public class SubjectDao {
	public List<SubjectBeans> subjectData(){
		List<SubjectBeans> subjectList = new ArrayList<SubjectBeans>();
		Connection conn = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する（仮）
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/A-3/NANIKA/database", "sa", "");

			// SELECT文を準備する
			String sql = "SELECT * FROM TABLE_SUBJECT ";
			PreparedStatement pStmt = conn.prepareStatement(sql);;

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				SubjectBeans subject = new SubjectBeans(
				rs.getInt("subject_id"),
				rs.getString("subject")
				);
			subjectList.add(subject);
		}
		}
		catch (SQLException e) {
			e.printStackTrace();
			subjectList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			subjectList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					subjectList = null;
				}
			}
		}
		// 結果を返す
		return subjectList;
	}
}
