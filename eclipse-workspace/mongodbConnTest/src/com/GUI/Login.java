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

		// �˺�
		idNumber = new JLabel("�˺ţ�");
		idNumber.setFont(new Font("����", Font.BOLD, 18));
		idNumber.setBounds(96, 66, 95, 18);

		// �˺������
		idText = new JTextField(6);
//		idText.setToolTipText("�����˺�");
		idText.setBounds(155, 65, 170, 24);
		idText.setColumns(10);
		idText.setForeground(Color.lightGray);// ����ǰ��ɫΪ��ɫ
		idText.setEditable(false);// ����Ϊ���ɱ༭״̬
		idText.setBackground(Color.WHITE);// ���ñ���ɫΪ��ɫ
//		idText.addMouseListener(new MouseAdapter() {
//			// ��������ȥ������,�����ı���
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
//				//ʧȥ����ʱ��û���������ݣ���ʾ��ʾ����
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
//				//��ȡ����ʱ�������ʾ����
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
		// ����
		passwordNumber = new JLabel("���룺");
		passwordNumber.setFont(new Font("����", Font.BOLD, 18));
		passwordNumber.setBounds(96, 103, 95, 18);

		// ���������
		passwordText = (JPasswordField) new JTextField("��������");
//		passwordText.setToolTipText("Ĭ������ 123456");
		passwordText.setBounds(155, 102, 170, 24);
		passwordText.setColumns(10);
		passwordText.setForeground(Color.lightGray);// ����ǰ��ɫΪ��ɫ
		passwordText.setEditable(false);// ����Ϊ���ɱ༭״̬
		passwordText.setBackground(Color.WHITE);// ���ñ���ɫΪ��ɫ
//		passwordText.addMouseListener(new MouseAdapter() {
//			// ��������ȥ������,�����ı���
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

		// ��¼��ť
		confirmButton = new JButton("��¼");
		confirmButton.setFont(new Font("����", Font.BOLD, 18));
		confirmButton.setBounds(96, 148, 113, 27);

		// ���ð�ť
		resetButton = new JButton("����");
		resetButton.setFont(new Font("����", Font.BOLD, 18));
		resetButton.setBounds(223, 148, 113, 27);
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idText.setForeground(Color.lightGray);
				passwordText.setForeground(Color.lightGray);
				idText.setText("����ѧ��");
				passwordText.setText("��������");
				idText.setEditable(false);
				passwordText.setEditable(false);
			}
		});

		class getText implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				String idTextString = idText.getText();
				char[] passwordTextString = passwordText.getPassword();
//        		System.out.println("�˺�:"  +idTextString + "\n����:" + caredTextString);

				// ��¼��֤
				 if ((idTextString.equals("�����˺�") || idTextString.equals(""))
						&& (passwordTextString.equals("��������") || idTextString.equals(""))) {
					System.out.println("�������˺Ż�����!");
					JOptionPane.showMessageDialog(null, "�������˺Ż�����!", "��ʾ", JOptionPane.ERROR_MESSAGE);
				}

				// �˺�Լ������
				else if (idTextString.length() < 2 || idTextString.length() > 6) {
					JOptionPane.showMessageDialog(null, "�˺���2~10λ֮��!", "��ʾ", JOptionPane.ERROR_MESSAGE);
				} 
				else {
					AccountCheck accountCheck = new AccountCheck(idTextString);
					if (idTextString.equals(accountCheck.idString) && passwordTextString.equals(accountCheck.pwString)) {
						System.out.println("��¼�ɹ�!");
						JOptionPane.showMessageDialog(null, "��¼�ɹ�!", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
						new DatabaseUI();
					} else {
						System.out.println("�˺Ż��������!");
						JOptionPane.showMessageDialog(null, "�˺Ż��������!", "��ʾ", JOptionPane.ERROR_MESSAGE);
					}
				}

			}

		}

		// ���
		getContentPane().add(idNumber);
		getContentPane().add(idText);
		getContentPane().add(passwordNumber);
		getContentPane().add(passwordText);
		getContentPane().add(confirmButton);
		getContentPane().add(resetButton);

		confirmButton.addActionListener(new getText());

		// ���ھ���
		this.setLocation(X / 2 - 300, Y / 2 - 200);
		setTitle("��¼");
		setVisible(true);
		setSize(450, 300);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setFocusable(true);//��ù��

	}

	public static void main(String[] args) {
		new Login();
	}

}