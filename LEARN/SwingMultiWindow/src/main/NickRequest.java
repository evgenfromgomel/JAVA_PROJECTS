package main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NickRequest extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NickRequest frame = new NickRequest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
				WindowLoader.loadWelcome(tfName.getText());
				dispose();
			}
		});
		btnContinue.setBounds(94, 64, 89, 23);
		contentPane.add(btnContinue);
	}
}
