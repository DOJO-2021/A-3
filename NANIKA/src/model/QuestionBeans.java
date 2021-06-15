package model;

import java.io.Serializable;

public class QuestionBeans implements Serializable {
	private int question_id;
	private int unit_id;
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

	//------------------------------------------------
	public QuestionBeans() {
		super();
	}
	//------------------------------------------------
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	//------------------------------------------------
	public int getUnit_id() {
		return unit_id;
	}
	public void setUnit_id(int unit_id) {
		this.unit_id = unit_id;
	}
	//------------------------------------------------
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	//------------------------------------------------
	public String getCommentary() {
		return commentary;
	}
	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}
	//------------------------------------------------
	public String getAnswer_commentary1() {
		return answer_commentary1;
	}
	public void setAnswer_commentary1(String answer_commentary1) {
		this.answer_commentary1 = answer_commentary1;
	}
	//------------------------------------------------
	public String getAnswer_commentary2() {
		return answer_commentary2;
	}
	public void setAnswer_commentary2(String answer_commentary2) {
		this.answer_commentary2 = answer_commentary2;
	}
	//------------------------------------------------
	public String getAnswer_commentary3() {
		return answer_commentary3;
	}
	public void setAnswer_commentary3(String answer_commentary3) {
		this.answer_commentary3 = answer_commentary3;
	}
	//------------------------------------------------
	public String getAnswer_commentary4() {
		return answer_commentary4;
	}
	public void setAnswer_commentary4(String answer_commentary4) {
		this.answer_commentary4 = answer_commentary4;
	}
	//------------------------------------------------
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	//------------------------------------------------
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	//------------------------------------------------
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	//------------------------------------------------
	public String getAnswer4() {
		return answer4;
	}
	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}
	//------------------------------------------------
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}


}


