package com.test;

public class Engineer extends Employee {
	private int workAge;
	
	Engineer(String name, double initSalary, int age, int workAge) {
		super(name, initSalary, age);
		this.workAge = workAge;
	}
	
	public double addSalary() {
		
		return setAfterSalary(getInitSalary() + 700);
	}
	
	public void show() {
		System.out.println("姓名:" + getName() );
		System.out.println("初始工资:" + getInitSalary());
		System.out.println("年龄:" + getAge());
		System.out.println("工龄:" + workAge);
		System.out.println("工程师" + getName() + "加薪后 薪水为:" + getAfterSalary());
		System.out.println();
	}
}
	
