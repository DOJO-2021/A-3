package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.NanikaBeans;


public class UnitDao {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<NanikaBeans> selectUnit(int subject_id) {
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
			String sql = "Select * from table_unit where subject_id = ?";
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
}