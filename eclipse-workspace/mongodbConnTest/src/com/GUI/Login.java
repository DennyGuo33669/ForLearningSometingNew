package com.GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	private JTextField idText;
//	private JTextField 
	private JPasswordField passwordText;
	private JLabel idNumber;
	private JLabel passwordNumber;
	private JButton confirmButton;
	private JButton resetButton;

	public Login() {


		getContentPane().setLayout(null);

		// 账号
		idNumber = new JLabel("账号：");
		idNumber.setFont(new Font("宋体", Font.BOLD, 18));
		idNumber.setBounds(96, 66, 95, 18);

		// 账号输入框
		idText = new JTextField(6);
//		idText.setToolTipText("输入账号");
		idText.setBounds(155, 65, 170, 24);
		idText.setColumns(10);
		idText.setForeground(Color.lightGray);// 设置前景色为灰色
		idText.setEditable(false);// 设置为不可编辑状态
		idText.setBackground(Color.WHITE);// 设置背景色为白色
//		idText.addMouseListener(new MouseAdapter() {
//			// 点击输入框去除文字,激活文本框
//			public void mouseClicked(MouseEvent e) {
//				if (e.getButton() == MouseEvent.BUTTON1) {
//					if (!idText.isEditable()) {
//						idText.setText("");
//						idText.setForeground(Color.BLACK);
//						idText.setEditable(true);
//						idText.requestFocus();
//						
//					}
//				}
//			}
//		});

//		idText.addFocusListener(new FocusListener() {
//			
//			@Override
//			public void focusLost(FocusEvent e) {
//				//失去焦点时，没有输入内容，显示提示内容
//				String temp = idText.getText();
//				if(temp.equals("")) {
//					idText.setForeground(Color.GRAY);
//					idText.setText("123456");
//				}
//				
//			}
//			
//			@Override
//			public void focusGained(FocusEvent e) {
//				//获取焦点时，清空提示内容
//				String temp = idText.getText();
//				if(temp.equals("123456")) {
//					idText.setText("");
//					idText.setForeground(Color.BLACK);
//				}
//				
//			}
//		});
// 
// 
		// 密码
		passwordNumber = new JLabel("密码：");
		passwordNumber.setFont(new Font("宋体", Font.BOLD, 18));
		passwordNumber.setBounds(96, 103, 95, 18);

		// 密码输入框
		passwordText = (JPasswordField) new JTextField("输入密码");
//		passwordText.setToolTipText("默认密码 123456");
		passwordText.setBounds(155, 102, 170, 24);
		passwordText.setColumns(10);
		passwordText.setForeground(Color.lightGray);// 设置前景色为灰色
		passwordText.setEditable(false);// 设置为不可编辑状态
		passwordText.setBackground(Color.WHITE);// 设置背景色为白色
//		passwordText.addMouseListener(new MouseAdapter() {
//			// 点击输入框去除文字,激活文本框
//			public void mouseClicked(MouseEvent e) {
//				if (e.getButton() == MouseEvent.BUTTON1) {
//					if (!passwordText.isEditable()) {
//						passwordText.setText("");
//						passwordText.setForeground(Color.BLACK);
//						passwordText.setEditable(true);
//						passwordText.requestFocus();
//					}
//				}
//			}
//		});

		// 登录按钮
		confirmButton = new JButton("登录");
		confirmButton.setFont(new Font("宋体", Font.BOLD, 18));
		confirmButton.setBounds(96, 148, 113, 27);

		// 重置按钮
		resetButton = new JButton("重置");
		resetButton.setFont(new Font("宋体", Font.BOLD, 18));
		resetButton.setBounds(223, 148, 113, 27);
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idText.setForeground(Color.lightGray);
				passwordText.setForeground(Color.lightGray);
				idText.setText("输入学号");
				passwordText.setText("输入密码");
				idText.setEditable(false);
				passwordText.setEditable(false);
			}
		});

		class getText implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				String idTextString = idText.getText();
				char[] passwordTextString = passwordText.getPassword();
//        		System.out.println("账号:"  +idTextString + "\n密码:" + caredTextString);

				// 登录验证
				 if ((idTextString.equals("输入账号") || idTextString.equals(""))
						&& (passwordTextString.equals("输入密码") || idTextString.equals(""))) {
					System.out.println("请输入账号或密码!");
					JOptionPane.showMessageDialog(null, "请输入账号或密码!", "提示", JOptionPane.ERROR_MESSAGE);
				}

				// 账号约束条件
				else if (idTextString.length() < 2 || idTextString.length() > 6) {
					JOptionPane.showMessageDialog(null, "账号在2~10位之间!", "提示", JOptionPane.ERROR_MESSAGE);
				} 
				else {
					AccountCheck accountCheck = new AccountCheck(idTextString);
					if (idTextString.equals(accountCheck.idString) && passwordTextString.equals(accountCheck.pwString)) {
						System.out.println("登录成功!");
						JOptionPane.showMessageDialog(null, "登录成功!", "提示", JOptionPane.INFORMATION_MESSAGE);
						new DatabaseUI();
					} else {
						System.out.println("账号或密码错误!");
						JOptionPane.showMessageDialog(null, "账号或密码错误!", "提示", JOptionPane.ERROR_MESSAGE);
					}
				}

			}

		}

		// 面板
		getContentPane().add(idNumber);
		getContentPane().add(idText);
		getContentPane().add(passwordNumber);
		getContentPane().add(passwordText);
		getContentPane().add(confirmButton);
		getContentPane().add(resetButton);

		confirmButton.addActionListener(new getText());

		// 窗口居中
		this.setLocation(X / 2 - 300, Y / 2 - 200);
		setTitle("登录");
		setVisible(true);
		setSize(450, 300);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setFocusable(true);//获得光标

	}

	public static void main(String[] args) {
		new Login();
	}

}