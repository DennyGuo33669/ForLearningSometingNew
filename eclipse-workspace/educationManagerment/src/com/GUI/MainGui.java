package com.GUI;

import javax.swing.*;

import com.Model.stuMod;

import java.awt.*;
import java.awt.event.*;


public class MainGui extends JFrame implements ActionListener{
	private JTextField jTextField=null;
	private JPanel jPanel=null;
	private JButton jButton_find=null,jButton_insert=null;
	private JTable jTable=null;
	private stuMod stumod=null;
	private JScrollPane jScrollPane=null;
	private JPanel jp=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainGui mainGui=new MainGui();
	}
	
	public MainGui() {
		
		int X=Toolkit.getDefaultToolkit().getScreenSize().width;
		int Y=Toolkit.getDefaultToolkit().getScreenSize().height;
		
		jTextField=new JTextField();
		jPanel=new JPanel();
		jPanel.setLayout(new GridLayout(1,2));
		
		jButton_find=new JButton("查找");
		jButton_find.addActionListener(this);
		jButton_find.setActionCommand("find");
		jp=new JPanel();
		
		jButton_insert=new JButton("录入成绩");
		jButton_insert.addActionListener(this);
		jButton_insert.setActionCommand("insert");
		jp.add(jButton_insert);
		
		jPanel.add(jTextField);
		jPanel.add(jButton_find);
		
		stumod=new stuMod();
		jTable=new JTable(stumod);
		
		jScrollPane=new JScrollPane(jTable);
		this.setSize(800, 600);
		this.setTitle("数据库管理系统");
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.NORTH,jPanel);
		this.add(BorderLayout.CENTER,jScrollPane);
		this.add(BorderLayout.SOUTH,jp);
		this.setLocation(X/2-300, Y/2-200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if("find".equals(e.getActionCommand())) {
			if(!jTextField.getText().equals("")) {
				stumod=new stuMod(jTextField.getText());
			}else {
				stumod=new stuMod();
			}
			jTable.setModel(stumod);
			
		}else if("insert".equals(e.getActionCommand())){
			stuAddDialog stuAddDialog=new stuAddDialog(this, "添加学生成绩", true);
			stumod=new stuMod();
			jTable.setModel(stumod);
		}
	}

}
