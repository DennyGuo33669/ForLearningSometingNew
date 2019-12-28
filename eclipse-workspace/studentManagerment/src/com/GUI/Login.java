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
	private JTextField idText;// �û���
	private JPasswordField passwordText;// ����
	static final String INFO_USERNAME = "�������û���";
	static final String INFO_USERPSD = "����������";
	static char defaultChar;// Ĭ�ϵ��ַ�, �����ϲ���Ǻ�, ��ô����Ϊ�Ǻ�Ҳ����
	private JLabel idLabel, passwordLabel;
	private JButton confirmButton, resetButton;

	public Login() {
		
		this.getContentPane().setLayout(null);// ���Բ���

		// �˺�
		idLabel = new JLabel("�û���");
		idLabel.setFont(new Font("����", Font.BOLD, 18));
		idLabel.setBounds(96, 66, 95, 18);

		// �˺������
		idText = new JTextField();
		idText.setBounds(155, 65, 170, 24);
		idText.setColumns(10);
		idText.setText(INFO_USERNAME);// ������ʾ����
		idText.setForeground(Color.LIGHT_GRAY);// ������ʾ���ֵ���ɫ

		// �ı���Ľ����¼�����
		idText.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {// ʧȥ�����ʱ��
				if (idText.getText().trim().equals("")) {// ���û���κ����� ,����ʾ�û�����
					idText.setText(INFO_USERNAME);
					idText.setForeground(Color.LIGHT_GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {// ��ý����ʱ��
				if (idText.getText().trim().equals(INFO_USERNAME)) {// �������ʾ���� ,�������ʾ����
					idText.setText("");
					idText.setForeground(Color.BLACK);
				}
			}
		});

		// ����
		passwordLabel = new JLabel("�ܡ���");
		passwordLabel.setFont(new Font("����", Font.BOLD, 18));
		passwordLabel.setBounds(96, 103, 95, 18);

		// ���������
		passwordText = new JPasswordField();
		defaultChar = passwordText.getEchoChar();// ���Ĭ�ϵ����������ַ�
		passwordText.setBounds(155, 102, 170, 24);
		passwordText.setColumns(10);
		passwordText.setEchoChar('\0');// \0 ���������ֻ�������ʾ
		passwordText.setText(INFO_USERPSD);// ��������������
		passwordText.setForeground(Color.LIGHT_GRAY);// ����������������ɫ

		// �����Ľ����¼�����
		passwordText.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {// ʧȥ�����ʱ��
				String pswd = new String(passwordText.getPassword()).trim();
				if (pswd.equals("")) {// ���û����������. �������� ��ʾ�û���������
					passwordText.setEchoChar('\0');
					passwordText.setText(INFO_USERPSD);
					passwordText.setForeground(Color.LIGHT_GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {// ��ý����ʱ��
				String pswd = new String(passwordText.getPassword()).trim();
				if (pswd.equals(INFO_USERPSD)) {// �����������ʾ���� ,��ô���������, ������������ʾ
					passwordText.setText("");
					passwordText.setEchoChar(defaultChar);
					passwordText.setForeground(Color.BLACK);
				}
			}
		});

		// ��¼��ť
		confirmButton = new JButton("��½");
		confirmButton.setFont(new Font("����", Font.BOLD, 18));
		confirmButton.setBounds(96, 148, 113, 27);

		// ��½��ť�Ľ����¼�����
		class LoginCheck implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				String idTextString = idText.getText();
				AccountCheck accountCheck = new AccountCheck(idTextString);
				String passwordTextString = new String(passwordText.getPassword());

				// ��¼��֤ && �˺�Լ������
				if ((idTextString.equals(INFO_USERNAME) || idTextString.equals(""))
						&& (passwordTextString.equals(INFO_USERPSD) || idTextString.equals(""))) {
					System.out.println("�������˺Ż�����!");
					JOptionPane.showMessageDialog(null, "�������˺Ż�����!", "��ʾ", JOptionPane.ERROR_MESSAGE);
				} else if (idTextString.length() < 2 || idTextString.length() > 6) {
					JOptionPane.showMessageDialog(null, "�˺���2~10λ֮��!", "��ʾ", JOptionPane.ERROR_MESSAGE);
				} else {
					if (idTextString.equals(accountCheck.getIdString())
							&& passwordTextString.equals(accountCheck.getpwdString())) {
						if(accountCheck.getDescriptionString().equals("����Ա")) {
							System.out.println("����Ա��¼�ɹ�!");
							JOptionPane.showMessageDialog(null, "����Ա��¼�ɹ�!", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
							new MainUI();
							dispose();
						}else {
							System.out.println("ѧ����¼�ɹ�!");
							JOptionPane.showMessageDialog(null, "ѧ����¼�ɹ�!", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
						}
						

					} else {
						System.out.println("�˺Ż��������!");
						
						//������Ϣ
						System.out.println("������˻���Ϊ" + idTextString);
						System.out.println("���ݿ��˻���Ϊ" + accountCheck.getIdString());

						System.out.println("���������Ϊ" + passwordTextString);
						System.out.println("���ݿ�����Ϊ" + accountCheck.getpwdString());

						JOptionPane.showMessageDialog(null, "�˺Ż��������!", "��ʾ", JOptionPane.ERROR_MESSAGE);
					}
				}
			}

		}
		confirmButton.addActionListener(new LoginCheck());

		// ���ð�ť
		resetButton = new JButton("����");
		resetButton.setFont(new Font("����", Font.BOLD, 18));
		resetButton.setBounds(223, 148, 113, 27);

		// ���ð�ť�Ľ����¼�����
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idText.setForeground(Color.lightGray);
				passwordText.setForeground(Color.lightGray);
				idText.setText(INFO_USERNAME);
				passwordText.setText(INFO_USERPSD);
			}
		});

		// ���
		this.getContentPane().add(idLabel);
		this.getContentPane().add(idText);
		this.getContentPane().add(passwordLabel);
		this.getContentPane().add(passwordText);
		this.getContentPane().add(confirmButton);
		this.getContentPane().add(resetButton);

		this.setTitle("��¼����"); // ����
		this.setVisible(true); // ���ÿɼ�
		this.setResizable(false); // ���ɵ������ڴ�С
		this.setSize(450, 300); // ���ڴ�С
		this.setLocationRelativeTo(null); // ���ھ���
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // ���ڵ���ر�ʱ,�˳�����
		this.requestFocus(); // ��ȡ����
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