package com.test;

public class Employee {
	private String name;
	private double initSalary;
	private int age;
	private double afterSalary;
	
	Employee(String name, double initSalary, int age){
		this.setName(name);
		this.setInitSalary(initSalary);
		this.setAge(age);

	}
	public double addSalary() {
		
		return setAfterSalary(getInitSalary() + 500);
	}
	
	public void show() {
		System.out.println("姓名:" + name );
		System.out.println("初始工资:" + getInitSalary());
		System.out.println("年龄:" + getAge());
		System.out.println("员工"+ getName() +"加薪后 薪水为:"+ getAfterSalary());
		System.out.println();

	}
	public double getInitSalary() {
		return initSalary;
	}
	public void setInitSalary(double initSalary) {
		this.initSalary = initSalary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getAfterSalary() {
		return afterSalary;
	}
	public double setAfterSalary(double afterSalary) {
		this.afterSalary = afterSalary;
		return afterSalary;
	}
}
