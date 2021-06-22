package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.UserBeans;

public class IdpwDao {
	public boolean isLoginOK(String email, String pw) {
		Connection conn = null;
		boolean loginResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する（仮）
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/A-3/NANIKA/database", "sa", "");

			// SELECT文を準備する
			String sql = "select count(*) from table_user where email = ? and password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, email);
			pStmt.setString(2, pw);

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// メールアドレスとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				loginResult = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}

		// 結果を返す
		return loginResult;


	}



//	ログイン時（ユーザ情報取得用）
	public UserBeans login(String email, String pw) {
		Connection conn = null;
//		boolean loginResult = false;
		UserBeans userbeans=null; //返り値用


		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する（仮）
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/A-3/NANIKA/database", "sa", "");

			// SELECT文を準備する
			String sql = "select user_id, account_name  from table_user where email = ? and password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, email);
			pStmt.setString(2, pw);

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// メールアドレスとパスワードが一致するユーザーがいたかどうかをチェックする
			while(rs.next()) {
				userbeans = new UserBeans(
						rs.getInt("user_id"),
						rs.getString("account_name")
					);
			}


		}
		catch (SQLException e) {
			e.printStackTrace();
//			loginResult = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
//			loginResult = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
//					loginResult = false;
				}
			}
		}
		// 結果を返す
		return userbeans;


	}


	// 新規登録用（サインアップ）
	public boolean signUp(UserBeans param) {
		Connection conn = null;
		boolean result = false;
		//UserBeans userbeans=null; //返り値用


		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する（仮）
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/A-3/NANIKA/database", "sa", "");

			// INSERT文を準備する
			String sql = "insert into table_user values (null, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, param.getAccount_name());
			pStmt.setString(2, param.getEmail());
			pStmt.setString(3, param.getPassword());
			pStmt.setString(4, param.getAccount_name_kana());

			// INSERT文を正常に実行できたかの判断
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}


		}
		catch (SQLException e) {
			e.printStackTrace();
//			loginResult = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
//			loginResult = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
//					loginResult = false;
				}
			}
		}
		// 結果を返す
		return result;


	}



}
