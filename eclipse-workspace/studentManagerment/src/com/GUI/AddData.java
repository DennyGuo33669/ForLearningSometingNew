package com.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.domain.*;
import com.service.*;


public class AddData extends JDialog implements ActionListener{
	private stuService stuService=null;
	private JLabel jl1=null,jl2=null,jl3=null,jl4=null,jl5=null,jl6=null,jl7=null;
	private JTextField jt1,jt2,jt3,jt4,jt5,jt6,jt7;
	private JButton jButton1,jButton2;
	private Student student=null;
	private JPanel jp1,jp2,jp3;
	public AddData(Frame owner, String title, boolean modal)  {
		
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
		if("ensure".equals(e.getActionCommand())) {
			
			double creditHour;
			double regularScore;
			double experimentalScore;
			double examinationScore;
			
			if(!jt4.getText().equals("")&&!jt5.getText().equals("")&&!jt6.getText().equals("")&&!jt7.getText().equals("")&&!jt1.getText().equals("")&&!jt2.getText().equals("")&&!jt3.getText().equals("")) {

				try {
					creditHour=Double.valueOf(jt4.getText());
					regularScore=Double.valueOf(jt5.getText());
					experimentalScore=Double.valueOf(jt6.getText());
					examinationScore=Double.valueOf(jt7.getText());
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
			
			
			if(creditHour<0||regularScore<0||regularScore>100||(experimentalScore<-1||experimentalScore>100||examinationScore<0||regularScore>100)) {
				JLabel jl=new JLabel("输入的信息有误!");
				JDialog jDialog=new JDialog(this, "提示",true);
				jDialog.setSize(300, 200);
				jDialog.add(BorderLayout.CENTER,jl);
				jDialog.setVisible(true);
				return;
				
			}else {
				student=new Student();
				double comprehensiveScore=0;
				double realCredit=0;
				student.setStuNo(jt1.getText());
				student.setClassNo(jt2.getText());
				student.setClassName(jt3.getText());
				student.setCreditHour(creditHour);
				student.setRregularScore(regularScore);
				student.setExperimentalScore(experimentalScore);
				student.setExaminationScore(examinationScore);
				if(experimentalScore==-1) {
					comprehensiveScore=regularScore*0.3+examinationScore*0.7;
					
				}else if(experimentalScore!=-1){
					comprehensiveScore=regularScore*0.15+experimentalScore*0.15+examinationScore*0.7;
				}
				student.setComprehensiveScore(comprehensiveScore);
				
				if(comprehensiveScore<=100&&comprehensiveScore>=90) {
					realCredit=creditHour*1.0;
				}else if(comprehensiveScore<90&&comprehensiveScore>=80){
					realCredit=creditHour*0.8;
					
				}else if(comprehensiveScore<80&&comprehensiveScore>=70){
					realCredit=creditHour*0.75;
					
				}else if(comprehensiveScore<70&&comprehensiveScore>=60) {
					realCredit=creditHour*0.6;
				}else if(comprehensiveScore<60&&comprehensiveScore>=0) {
					realCredit=creditHour*0.0;
				}
				student.setRealcredit(realCredit);
				
				stuService=new stuService();
				stuService.insertStu(student);
				this.dispose();
				
				
			}
			
		}else if("exit".equals(e.getActionCommand())) {
			this.dispose();
		}
	}
}

