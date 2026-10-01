package com.example.api_versioning;

public class StudentV2 {

	private int stu_id;
	private String stu_name;
	private String stu_email;
	public StudentV2(int stu_id, String stu_name, String stu_email) {
		super();
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.stu_email = stu_email;
	}
	public int getStu_id() {
		return stu_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_email() {
		return stu_email;
	}
	public void setStu_email(String stu_email) {
		this.stu_email = stu_email;
	}
	
	
}
