package com.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Adddata extends JDialog implements ActionListener{
//	private stuService stuService=null;
	private JLabel jl1=null,jl2=null,jl3=null,jl4=null,jl5=null,jl6=null,jl7=null;
	private JTextField jt1,jt2,jt3,jt4,jt5,jt6,jt7;
	private JButton jButton1,jButton2;
//	private Student student=null;
	private JPanel jp1,jp2,jp3;
	public Adddata(Frame owner, String title, boolean modal)  {
		
		super(owner,title,modal);
		jl1=new JLabel("学号");
		jl2=new JLabel("课程编号");
		jl3=new JLabel("课程名称");
		jl4=new JLabel("学分");
		jl5=new JLabel("平时成绩");
		jl6=new JLabel("实验成绩");
		jl7=new JLabel("卷面成绩");
		
		
		jt1=new JTextField();
		jt2=new JTextField();
		jt3=new JTextField();
		jt4=new JTextField();
		jt5=new JTextField();
		jt6=new JTextField();
		jt7=new JTextField();
		
		jButton1=new JButton("确定");
		jButton2=new JButton("取消");
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jp1.setLayout(new GridLayout(7, 1));
		jp2.setLayout(new GridLayout(7, 1));
		
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		jp1.add(jl7);
		
		jp2.add(jt1);
		jp2.add(jt2);
		jp2.add(jt3);
		jp2.add(jt4);
		jp2.add(jt5);
		jp2.add(jt6);
		jp2.add(jt7);
		
		jp3.add(jButton1);
		jp3.add(jButton2);
		
		jButton1.addActionListener(this);
		jButton1.setActionCommand("ensure");
		jButton2.addActionListener(this);
		jButton2.setActionCommand("exit");
		this.add(BorderLayout.WEST,jp1);
		this.add(BorderLayout.CENTER,jp2);
		this.add(BorderLayout.SOUTH,jp3);
		this.setSize(500,400);
		this.setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if("ensure".equals(e.getActionCommand())) {
			
			Integer Credit_Hour=null;
					
					
			Integer Credit1=null;
			
			Integer Credit2=null;
			Integer Credit3=null;
			
			if(!jt4.getText().equals("")&&!jt5.getText().equals("")&&!jt6.getText().equals("")&&!jt7.getText().equals("")&&!jt1.getText().equals("")&&!jt2.getText().equals("")&&!jt3.getText().equals("")) {

				try {
					Credit_Hour=Integer.parseInt(jt4.getText());
					Credit1=Integer.parseInt(jt5.getText());
					Credit2=Integer.parseInt(jt6.getText());
					Credit3=Integer.parseInt(jt7.getText());
				}catch(Exception e1) {
					JLabel jl=new JLabel("输入的信息有误!");
					JDialog jDialog=new JDialog(this,"提示",true);
					jDialog.setSize(300, 200);
					jDialog.add(BorderLayout.CENTER,jl);
					
					jDialog.setVisible(true);
					
					
					return;
				}
			}else {
				JLabel jl=new JLabel("输入的信息不能为空!");
				JDialog jDialog=new JDialog(this,"提示",true);
				jDialog.setSize(300, 200);
				jDialog.add(BorderLayout.CENTER,jl);
				
				jDialog.setVisible(true);
	
				return;
			}
			
			
			if(Credit_Hour<0||Credit1<0||Credit1>100||(Credit2<-1||Credit2>100||Credit3<0||Credit1>100)) {
				JLabel jl=new JLabel("输入的信息有误!");
				JDialog jDialog=new JDialog(this, "提示",true);
				jDialog.setSize(300, 200);
				jDialog.add(BorderLayout.CENTER,jl);
				jDialog.setVisible(true);
				return;
				
			}else {
				student=new Student();
				float All_credit=0;
				float Real_credit=0;
				student.setStuNo(jt1.getText());
				student.setClassNo(jt2.getText());
				student.setClassName(jt3.getText());
				student.setCredit_Hour(Credit_Hour);
				student.setCredit1(Credit1);
				student.setCredit2(Credit2);
				student.setCredit3(Credit3);
				if(Credit2==-1) {
					All_credit=(float) (Credit1*0.3+Credit3*0.7);
					
				}else if(Credit2!=-1){
					All_credit=(float) (Credit1*0.15+Credit2*0.15+Credit3*0.7);
				}
				student.setAll_credit(All_credit);
				
				if(All_credit<=100&&All_credit>=90) {
					Real_credit=(float) (Credit_Hour*1.0);
				}else if(All_credit<90&&All_credit>=80){
					Real_credit=(float) (Credit_Hour*0.8);
					
				}else if(All_credit<80&&All_credit>=70){
					Real_credit=(float) (Credit_Hour*0.75);
					
				}else if(All_credit<70&&All_credit>=60) {
					Real_credit=(float) (Credit_Hour*0.6);
				}else if(All_credit<60&&All_credit>=0) {
					Real_credit=(float) (Credit_Hour*0.0);
				}
				student.setReal_credit(Real_credit);
				
				stuService=new stuService();
				stuService.insertStu(student);
				this.dispose();
				
				
			}
			
		}else if("exit".equals(e.getActionCommand())) {
			this.dispose();
		}
	}
}

