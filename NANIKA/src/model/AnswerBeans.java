package model;

import java.io.Serializable;

public class AnswerBeans implements Serializable {

	private int user_id; //ユーザーID
	private int question_id; //問題I
	private String start_time; //開始時間
	private String user_answer; //ユーザーが選択した問題の選択肢

	//AnswerBeansクラスの、引数があるコンストラクタ
	public AnswerBeans(int user_id,int question_id,String start_time,String user_answer) {
		super ();
		this.user_id = user_id;
		this.question_id = question_id;
		this.start_time = start_time;
		this.user_answer = user_answer;
	}

	//引数のないコンストラクタ(デフォルトコンストラクタ)
		public AnswerBeans() {
			super();
			this.user_id = 0;
			this.question_id = 0;
			this.start_time = "";
			this.user_answer = "";
		}

	//ゲッター,セッターの生成

		public int getUser_id() {
			return user_id;
		}

		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}

		public int getQuestion_id() {
			return question_id;
		}

		public void setQuestion_id(int question_id) {
			this.question_id = question_id;
		}

		public String getStart_time() {
			return start_time;
		}

		public void setStart_time(String start_time) {
			this.start_time = start_time;
		}

		public String getUser_answer() {
			return user_answer;
		}

		public void setUser_answer(String user_answer) {
			this.user_answer = user_answer;
		}


}