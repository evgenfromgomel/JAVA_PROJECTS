package com.chatapp.client.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import com.chatapp.client.messages.MessageParser;
import com.chatapp.client.system.ClientLogic;

public class ChatWindow extends JFrame implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2397311484075702228L;
	static final String CONNECT_TEXT = "Connect";
	static final String DISCONNECT_TEXT = "Disconnect";
	static final String LABEL_CONNECT_TEXT = "<html><font color = 'green'>Connected!</font></html>";
	static final String LABEL_DISCONNECT_TEXT = "<html><font color = 'red'>Disconnected!</font></html>";
	static final String BODY_CLOSE = "</body>";
	static final String NEW_LINE = "<br>";

	private JPanel contentPane;
	private JTextField tfMessPanel;
	private JEditorPane editorPane;
	private String currText = "";
	private JButton btnConnect;
	private JLabel lbStatus;
	private MessageParser parser;

	public ChatWindow() {
		parser = new MessageParser();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 277, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPressButtonTo = new JLabel("Press button to connect:");
		lblPressButtonTo.setBounds(10, 11, 128, 14);
		contentPane.add(lblPressButtonTo);

		btnConnect = new JButton("Connect");
		btnConnect.setBounds(10, 28, 89, 23);
		btnConnect.addActionListener(this);
		contentPane.add(btnConnect);

		lbStatus = new JLabel("");
		lbStatus.setBounds(120, 32, 119, 14);
		contentPane.add(lbStatus);

		JLabel lbLoginfo = new JLabel("");
		lbLoginfo.setBounds(10, 62, 247, 14);
		lbLoginfo.setText("You are login as " + System.getProperty("nick"));
		contentPane.add(lbLoginfo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 87, 247, 313);
		contentPane.add(scrollPane);

		editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setFont(new Font("Serif", Font.PLAIN, 14));
		editorPane.setContentType("text/html; charset=EUC-JP");
		editorPane.setText("");
		scrollPane.setViewportView(editorPane);

		tfMessPanel = new JTextField();
		tfMessPanel.setBounds(10, 411, 247, 20);
		tfMessPanel.addKeyListener(this);
		contentPane.add(tfMessPanel);
		tfMessPanel.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (CONNECT_TEXT.equals(btnConnect.getText())) {
			try {
				if (ClientLogic.runClient()) {
					lbStatus.setText(LABEL_CONNECT_TEXT);
					btnConnect.setText(DISCONNECT_TEXT);
					tfMessPanel.requestFocusInWindow();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			ClientLogic.shutdownClient();
			btnConnect.setText(CONNECT_TEXT);
			lbStatus.setText(LABEL_DISCONNECT_TEXT);
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {

		if (KeyEvent.VK_ENTER == arg0.getKeyCode()) {
			String inputString = tfMessPanel.getText();
			currText = editorPane.getText();
			ClientLogic.sendMessage(inputString);
			try {
				int insertIndex = currText.indexOf(BODY_CLOSE);
				String head = currText.substring(0, insertIndex);
				String tail = currText.substring(insertIndex);
				head += "<font color = 'red'>"
						+ ClientLogic.printMessage() + "</font>" + NEW_LINE;
				currText = head + tail;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			editorPane.setText(parser.insertSmiles(currText));
			tfMessPanel.setText("");
		}
		// TODO Auto-generated method stub
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
