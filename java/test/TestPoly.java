package com.test;

public class Manager extends Employee{

	private String sector;
	Manager(String name, double initSalary, int age, String sector) {
		super(name, initSalary, age);
		this.sector = sector;
	}

	public double addSalary() {
		
		return setAfterSalary(getInitSalary() + 1000);
	
	}
	
	public void show() {
		System.out.println("姓名:" + getName() );
		System.out.println("初始工资:" + getInitSalary());
		System.out.println("年龄:" + getAge());
		System.out.println("部门:" + sector);
		System.out.println("经理" + getName() + "加薪后 薪水为:"+ getAfterSalary());
		System.out.println();
	}
}
