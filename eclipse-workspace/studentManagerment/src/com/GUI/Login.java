package com.GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Login extends JFrame {
	private JTextField idText;// 用户名
	private JPasswordField passwordText;// 密码
	static final String INFO_USERNAME = "请输入用户名";
	static final String INFO_USERPSD = "请输入密码";
	static char defaultChar;// 默认的字符, 如果你喜欢星号, 那么设置为星号也可以
	private JLabel idLabel, passwordLabel;
	private JButton confirmButton, resetButton;

	public Login() {
		
		this.getContentPane().setLayout(null);// 绝对布局

		// 账号
		idLabel = new JLabel("用户名");
		idLabel.setFont(new Font("宋体", Font.BOLD, 18));
		idLabel.setBounds(96, 66, 95, 18);

		// 账号输入框
		idText = new JTextField();
		idText.setBounds(155, 65, 170, 24);
		idText.setColumns(10);
		idText.setText(INFO_USERNAME);// 设置提示文字
		idText.setForeground(Color.LIGHT_GRAY);// 设置提示文字的颜色

		// 文本框的焦点事件处理
		idText.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {// 失去焦点的时候
				if (idText.getText().trim().equals("")) {// 如果没有任何输入 ,就提示用户输入
					idText.setText(INFO_USERNAME);
					idText.setForeground(Color.LIGHT_GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {// 获得焦点的时候
				if (idText.getText().trim().equals(INFO_USERNAME)) {// 如果是提示文字 ,就清空提示文字
					idText.setText("");
					idText.setForeground(Color.BLACK);
				}
			}
		});

		// 密码
		passwordLabel = new JLabel("密　码");
		passwordLabel.setFont(new Font("宋体", Font.BOLD, 18));
		passwordLabel.setBounds(96, 103, 95, 18);

		// 密码输入框
		passwordText = new JPasswordField();
		defaultChar = passwordText.getEchoChar();// 获得默认的密码隐藏字符
		passwordText.setBounds(155, 102, 170, 24);
		passwordText.setColumns(10);
		passwordText.setEchoChar('\0');// \0 密码框的文字会明文显示
		passwordText.setText(INFO_USERPSD);// 设置密码框的内容
		passwordText.setForeground(Color.LIGHT_GRAY);// 设置密码框的文字颜色

		// 密码框的焦点事件处理
		passwordText.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {// 失去焦点的时候
				String pswd = new String(passwordText.getPassword()).trim();
				if (pswd.equals("")) {// 如果没有输入密码. 就用明文 提示用户输入密码
					passwordText.setEchoChar('\0');
					passwordText.setText(INFO_USERPSD);
					passwordText.setForeground(Color.LIGHT_GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {// 获得焦点的时候
				String pswd = new String(passwordText.getPassword()).trim();
				if (pswd.equals(INFO_USERPSD)) {// 如果是密码提示文字 ,那么就清空文字, 并设置密文显示
					passwordText.setText("");
					passwordText.setEchoChar(defaultChar);
					passwordText.setForeground(Color.BLACK);
				}
			}
		});

		// 登录按钮
		confirmButton = new JButton("登陆");
		confirmButton.setFont(new Font("宋体", Font.BOLD, 18));
		confirmButton.setBounds(96, 148, 113, 27);

		// 登陆按钮的焦点事件处理
		class LoginCheck implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				String idTextString = idText.getText();
				AccountCheck accountCheck = new AccountCheck(idTextString);
				String passwordTextString = new String(passwordText.getPassword());

				// 登录验证 && 账号约束条件
				if ((idTextString.equals(INFO_USERNAME) || idTextString.equals(""))
						&& (passwordTextString.equals(INFO_USERPSD) || idTextString.equals(""))) {
					System.out.println("请输入账号或密码!");
					JOptionPane.showMessageDialog(null, "请输入账号或密码!", "提示", JOptionPane.ERROR_MESSAGE);
				} else if (idTextString.length() < 2 || idTextString.length() > 6) {
					JOptionPane.showMessageDialog(null, "账号在2~10位之间!", "提示", JOptionPane.ERROR_MESSAGE);
				} else {
					if (idTextString.equals(accountCheck.getIdString())
							&& passwordTextString.equals(accountCheck.getpwdString())) {
						if(accountCheck.getDescriptionString().equals("管理员")) {
							System.out.println("管理员登录成功!");
							JOptionPane.showMessageDialog(null, "管理员登录成功!", "提示", JOptionPane.INFORMATION_MESSAGE);
							new MainUI();
							dispose();
						}else {
							System.out.println("学生登录成功!");
							JOptionPane.showMessageDialog(null, "学生登录成功!", "提示", JOptionPane.INFORMATION_MESSAGE);
						}
						

					} else {
						System.out.println("账号或密码错误!");
						
						//调试信息
						System.out.println("输入的账户名为" + idTextString);
						System.out.println("数据库账户名为" + accountCheck.getIdString());

						System.out.println("输入的密码为" + passwordTextString);
						System.out.println("数据库密码为" + accountCheck.getpwdString());

						JOptionPane.showMessageDialog(null, "账号或密码错误!", "提示", JOptionPane.ERROR_MESSAGE);
					}
				}
			}

		}
		confirmButton.addActionListener(new LoginCheck());

		// 重置按钮
		resetButton = new JButton("重置");
		resetButton.setFont(new Font("宋体", Font.BOLD, 18));
		resetButton.setBounds(223, 148, 113, 27);

		// 重置按钮的焦点事件处理
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idText.setForeground(Color.lightGray);
				passwordText.setForeground(Color.lightGray);
				idText.setText(INFO_USERNAME);
				passwordText.setText(INFO_USERPSD);
			}
		});

		// 面板
		this.getContentPane().add(idLabel);
		this.getContentPane().add(idText);
		this.getContentPane().add(passwordLabel);
		this.getContentPane().add(passwordText);
		this.getContentPane().add(confirmButton);
		this.getContentPane().add(resetButton);

		this.setTitle("登录窗口"); // 标题
		this.setVisible(true); // 设置可见
		this.setResizable(false); // 不可调整窗口大小
		this.setSize(450, 300); // 窗口大小
		this.setLocationRelativeTo(null); // 窗口居中
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // 窗口点击关闭时,退出程序
		this.requestFocus(); // 获取焦点
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {  
				new Login();
			}
		});
	}
}