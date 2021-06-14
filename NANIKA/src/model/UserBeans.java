package model;

import java.io.Serializable;

public class UserBeans implements Serializable {

	private int user_id; //ユーザーID
	private String account_name; //アカウント名
	private String email; //メールアドレス
	private String password; //パスワード
	private String account_name_kana; //カナ文字

	//UserBeansクラスの、引数があるコンストラクタ
	public UserBeans(int user_id,String account_name,String email,String password,String account_name_kana) {
		super ();
		this.user_id = user_id;
		this.account_name = account_name;
		this.email = email;
		this.password = password;
		this.account_name_kana = account_name_kana;
	}



	public UserBeans(int user_id, String account_name) {
		super();
		this.user_id = user_id;
		this.account_name = account_name;
	}



	//引数のないコンストラクタ(デフォルトコンストラクタ)
	public UserBeans() {
		super();
		this.user_id = 0;
		this.account_name = "";
		this.email = "";
		this.password = "";
		this.account_name_kana = "";
	}

	//ゲッター,セッターの生成
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccount_name_kana() {
		return account_name_kana;
	}

	public void setAccount_name_kana(String account_name_kana) {
		this.account_name_kana = account_name_kana;
	}


}