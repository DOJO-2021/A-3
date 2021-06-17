package model;

import java.io.Serializable;

public class NanikaBeans implements Serializable  {
	private int user_id; //ユーザーID
	private String account_name; //アカウント名
	private String email; //メールアドレス
	private String password; //パスワード
	private String account_name_kana; //カナ文字

	private int subject_id;
	private String subject;

	private int unit_id;
	private String unit;

	private String start_time;
	private String end_time;
	private int score;
	private int result;

	private int question_id;
	private String question;
	private String commentary;
	private String answer_commentary1;
	private String answer_commentary2;
	private String answer_commentary3;
	private String answer_commentary4;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private String answer;

	private String user_answer; //ユーザーが選択した問題の選択肢

	public NanikaBeans(int user_id, String subject,int subject_id, int score) {
		super();
		this.user_id = user_id;
		this.subject = subject;
		this.score = score;
		this.subject_id = subject_id;
	}

	//ScoreDao.java で１．４ユーザが受けた、単元の一覧情報を取得する際に（ScoreDao.java→scoreAll(int user_id )）で使用する。
	public NanikaBeans(int user_id, String unit, String start_time, String end_time, int result) {
		super();
		this.user_id = user_id;
		this.unit = unit;
		this.start_time = start_time;
		this.end_time = end_time;
		this.result = result;
	}


	//UnitDaoで使うコンストラクタ
	public NanikaBeans(int unit_id, String unit, int subject_id) {
		super();
		this.unit_id = unit_id;
		this.unit = unit;
		this.subject_id = subject_id;
	}


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

	public int getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getUnit_id() {
		return unit_id;
	}

	public void setUnit_id(int unit_id) {
		this.unit_id = unit_id;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	public String getAnswer_commentary1() {
		return answer_commentary1;
	}

	public void setAnswer_commentary1(String answer_commentary1) {
		this.answer_commentary1 = answer_commentary1;
	}

	public String getAnswer_commentary2() {
		return answer_commentary2;
	}

	public void setAnswer_commentary2(String answer_commentary2) {
		this.answer_commentary2 = answer_commentary2;
	}

	public String getAnswer_commentary3() {
		return answer_commentary3;
	}

	public void setAnswer_commentary3(String answer_commentary3) {
		this.answer_commentary3 = answer_commentary3;
	}

	public String getAnswer_commentary4() {
		return answer_commentary4;
	}

	public void setAnswer_commentary4(String answer_commentary4) {
		this.answer_commentary4 = answer_commentary4;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public String getAnswer4() {
		return answer4;
	}

	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getUser_answer() {
		return user_answer;
	}

	public void setUser_answer(String user_answer) {
		this.user_answer = user_answer;
	}

}
