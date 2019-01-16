package com.example.hashtable;
class Student {
	
	private String name;
	private String roll_no;
	private double cagpa;
	public Student(String name, String roll_no, double cagpa) {
		super();
		this.name = name;
		this.roll_no = roll_no;
		this.cagpa = cagpa;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(String roll_no) {
		this.roll_no = roll_no;
	}
	public double getCagpa() {
		return cagpa;
	}
	public void setCagpa(double cagpa) {
		this.cagpa = cagpa;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", roll_no=" + roll_no + ", cagpa=" + cagpa + "]";
	}
}