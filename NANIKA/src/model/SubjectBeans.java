package model;

import java.io.Serializable;

public class SubjectBeans implements Serializable{

	private int subject_id;
	private String subject;

	public SubjectBeans(int subject_id, String subject) {
		super();
		this.subject_id = subject_id;
		this.subject = subject;
	}

	public SubjectBeans() {
		super();
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


}
