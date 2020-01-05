package com.GUI;

import javax.swing.*;
import javax.swing.table.TableModel;

import java.awt.*;
import java.awt.event.*;
import com.Model.*;

public class MainUI extends JFrame implements ActionListener {
	private JTextField jTextField = null;

	private JPanel jPanel = null;
	private JButton jButton_find = null, jButton_insert = null;
	private JTable jTable = null;
	private JScrollPane jScrollPane = null;
	private JPanel jp = null;
	private StuTableMod stuTableMod =null;


	
	public MainUI() {

		jTextField = new JTextField();
		jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(1, 2));

		jButton_find = new JButton("����");
		jButton_find.addActionListener(this);
		jButton_find.setActionCommand("find");
		jp = new JPanel();

		jButton_insert = new JButton("¼��ɼ�");
		jButton_insert.addActionListener(this);
		jButton_insert.setActionCommand("insert");
		jp.add(jButton_insert);

		jPanel.add(jTextField);
		jPanel.add(jButton_find);
		jTable =new JTable();
		jTable.setModel(new StuTableMod());
		jScrollPane = new JScrollPane(jTable);
		jTable =new JTable();
		//jScrollPane = new JScrollPane(jTable.setModle(testMod));
		this.setSize(800, 600);
		this.setTitle("���ݿ����ϵͳ");
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.NORTH, jPanel);
		this.add(BorderLayout.CENTER, jScrollPane);
		this.add(BorderLayout.SOUTH, jp);
		setLocationRelativeTo(null); // ���ھ���
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);//�ɼ�
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if("find".equals(e.getActionCommand())) {
			if(!jTextField.getText().equals("")) {
//				tm = new testMod();
				jTable.setModel(new StuTableMod(jTextField.getText()));
			}else {
//				tm = new testMod();
				jTable.setModel(new StuTableMod());
			}
			
			
			
		}else if("insert".equals(e.getActionCommand())){
			System.out.println("tian jia xuesheng bei diaoyong");
			
			AddData addData=new AddData(this, "���ѧ���ɼ�", true);
			stuTableMod=new StuTableMod();
			jTable.setModel(stuTableMod);

		}
	}
	
	

	public static void main(String[] args) {
		MainUI mainUI = new MainUI();
	}
}