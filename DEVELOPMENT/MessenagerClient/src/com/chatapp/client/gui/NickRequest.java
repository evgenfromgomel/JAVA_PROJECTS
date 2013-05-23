package com.chatapp.client.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class NickRequest extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5099765803314253291L;
	private JPanel contentPane;
	private JTextField tfName;

	/**
	 * Create the frame.
	 */
	public NickRequest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 203, 123);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfName = new JTextField();
		tfName.setBounds(10, 33, 173, 20);
		contentPane.add(tfName);
		tfName.setColumns(10);

		JLabel lblEnterYourName = new JLabel("Enter your name:");
		lblEnterYourName.setBounds(10, 11, 126, 14);
		contentPane.add(lblEnterYourName);

		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.setProperty("nick", tfName.getText());
				JFrame chat = new ChatWindow();
				dispose();
				chat.setVisible(true);
			}
		});
		btnContinue.setBounds(94, 64, 89, 23);
		contentPane.add(btnContinue);
	}
}
