package model;

public class ScoreBeans {

	private int user_id;
	private int unit_id;
	private String start_time;
	private String end_time;
	private int score;
	private int result;

	public ScoreBeans(int user_id, int unit_id, String start_time, String end_time, int score, int result) {
		super();
		this.user_id = user_id;
		this.unit_id = unit_id;
		this.start_time = start_time;
		this.end_time = end_time;
		this.score = score;
		this.result = result;
	}
	public ScoreBeans() {
		super();
	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getUnit_id() {
		return unit_id;
	}
	public void setUnit_id(int unit_id) {
		this.unit_id = unit_id;
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




}
