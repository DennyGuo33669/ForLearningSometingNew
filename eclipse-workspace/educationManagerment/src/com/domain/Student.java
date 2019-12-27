package com.domain;

public class Student {
	
	private String StuNo=null;
	private String ClassNo=null;
	private String ClassName=null;
	private Integer Credit_Hour;
	private Integer Credit1;
	private Integer Credit2;
	private Integer Credit3;
	private float All_credit;
	private float Real_credit;
	public String getStuNo() {
		return StuNo;
	}
	public void setStuNo(String stuNo) {
		StuNo = stuNo;
	}
	public String getClassNo() {
		return ClassNo;
	}
	public void setClassNo(String classNo) {
		ClassNo = classNo;
	}
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String className) {
		ClassName = className;
	}
	public float getCredit_Hour() {
		return Credit_Hour;
	}
	public void setCredit_Hour(Integer credit_Hour) {
		Credit_Hour = credit_Hour;
	}
	public float getCredit1() {
		return Credit1;
	}
	public void setCredit1(Integer credit1) {
		Credit1 = credit1;
	}
	public float getCredit2() {
		return Credit2;
	}
	public void setCredit2(Integer credit2) {
		Credit2 = credit2;
	}
	public float getCredit3() {
		return Credit3;
	}
	public void setCredit3(Integer credit3) {
		Credit3 = credit3;
	}
	public float getAll_credit() {
		return All_credit;
	}
	public void setAll_credit(float all_credit) {
		All_credit = all_credit;
	}
	public float getReal_credit() {
		return Real_credit;
	}
	public void setReal_credit(float real_credit) {
		Real_credit = real_credit;
	}
}
