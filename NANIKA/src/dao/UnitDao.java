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


	//UnitServletで使用  科目の単元IDの先頭から最後までを取得
		public int[] unitCount_for(int subject_id) {
			//箱を準備
			Connection conn = null;
//
//			List<Integer> unitCount = new ArrayList<Integer>();
			int[] unitCount = new int[2];

			//船を準備
			PreparedStatement pStmt=null;

			try {
				//JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				//データベースに接続
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/A-3/NANIKA/database","sa","");

				//SELECT文を準備
				String sql = "SELECT s.subject ,s.subject_id ,u.unit_id FROM TABLE_SUBJECT s "
						+ " left join table_unit u on u.subject_id  = s.subject_id  "
						+ "where  s.subject_id = ?  "
						+ "group by s.subject ,u.unit_id "
						+ "order by u.unit_id  limit 1";
				pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1,subject_id);

				//SELECT文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
					rs.next();
					unitCount[0]= rs.getInt("unit_id");

					//SELECT文を準備
				sql = "SELECT s.subject ,s.subject_id ,u.unit_id FROM TABLE_SUBJECT s "
							+ " left join table_unit u on u.subject_id  = s.subject_id  "
							+ "where  s.subject_id = ?  "
							+ "group by s.subject ,u.unit_id "
							+ "order by u.unit_id desc limit 1";
					pStmt = conn.prepareStatement(sql);
					pStmt.setInt(1,subject_id);

					//SELECT文を実行し、結果表を取得する
					rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					rs.next();
					unitCount[1]= rs.getInt("unit_id");


			}
			catch (SQLException e) {
				e.printStackTrace();

			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();

			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();

					}
				}
			}
			// 結果を返す
			return unitCount;
		}
}