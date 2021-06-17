package model;

import java.io.Serializable;

public class UnitBeans implements Serializable {
	private int unit_id;
	private String unit;
	private int subject_id;


	public UnitBeans(int unit_id,String unit,int subject_id) {
		super();
		this.unit_id = unit_id;
		this.unit = unit;
		this.subject_id = subject_id;
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

	public int getSubject_id() {
		return subject_id;
	}

	public void setSublect_id(int subject_id) {
		this.subject_id = subject_id;
	}


}
