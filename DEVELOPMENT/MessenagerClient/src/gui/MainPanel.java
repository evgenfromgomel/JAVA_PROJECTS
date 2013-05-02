package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Key;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import system.ClientLogic;

import messages.MessageParser;

public class MainPanel extends JPanel implements ActionListener, KeyListener {

	static final int LEFT_ALIGN = 5;
	static final int BOTTOM_BORDER = 5;
	static final String CONNECT_TEXT = "Connect";
	static final String DISCONNECT_TEXT = "Disconnect";
	static final String LABEL_CONNECT_TEXT = "<html><font color = 'green'>Connected!</font></html>";
	static final String LABEL_DISCONNECT_TEXT = "<html><font color = 'red'>Disconnected!</font></html>";
	static final String BODY_CLOSE = "</body>";
	static final String NEW_LINE = "<br>";
	static final int COMPONENT_COORD = 25;
	static final int TEXT_COMPONENT_WIDTH = 220;
	static final int TEXT_AREA_HEIGHT = 260;
	static final int MAX_ROWS = 15;
	private int rowCounter;
	private int currTextAreaHeight;
	private String currText = "";
	private String currText2 = "" ;
	private MessageParser parser;
	
	JButton button;
	JLabel label1;
	JLabel label2;
	JTextField textField;
	JEditorPane textArea;
	JScrollPane scrollPane;
	ByteArrayInputStream inputString;

	public MainPanel() {
		super();
		parser = new MessageParser();
		rowCounter = 1;
		currTextAreaHeight = 260;
		button = new JButton(CONNECT_TEXT);
		label1 = new JLabel("Press button to connect:");
		label2 = new JLabel("");
		textField = new JTextField();
		textArea = new JEditorPane();
		scrollPane = new JScrollPane(textArea);

		textArea.setEditable(false);
		textArea.setBackground(Color.white);
		textArea.setPreferredSize(new Dimension(TEXT_COMPONENT_WIDTH,
				currTextAreaHeight));
		textArea.setAutoscrolls(true);
		textArea.setFont(new Font("Serif", Font.PLAIN, 14));
		textArea.setContentType("text/html; charset=EUC-JP");
		textArea.setText("");

		scrollPane.setPreferredSize(new Dimension(TEXT_COMPONENT_WIDTH,
				TEXT_AREA_HEIGHT));
		scrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setAutoscrolls(true);

		button.addActionListener(this);
		textField.addKeyListener(this);

		label1.setBounds(LEFT_ALIGN, BOTTOM_BORDER, 150, 20);
		button.setBounds(LEFT_ALIGN, BOTTOM_BORDER + COMPONENT_COORD, 100, 20);
		label2.setBounds(LEFT_ALIGN, BOTTOM_BORDER + COMPONENT_COORD * 2, 150,
				20);
		scrollPane.setBounds(LEFT_ALIGN, BOTTOM_BORDER + COMPONENT_COORD * 3,
				TEXT_COMPONENT_WIDTH, TEXT_AREA_HEIGHT);
		textField.setBounds(LEFT_ALIGN, BOTTOM_BORDER + 340,
				TEXT_COMPONENT_WIDTH, 20);
		setLayout(null);
		add(button);
		add(label1);
		add(label2);
		add(textField);
		add(scrollPane);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (CONNECT_TEXT.equals(button.getText())) {
			try {
				if (ClientLogic.runClient()) {
					label2.setText(LABEL_CONNECT_TEXT);
					button.setText(DISCONNECT_TEXT);
					textField.requestFocusInWindow();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			ClientLogic.shutdownClient();
			button.setText(CONNECT_TEXT);
			label2.setText(LABEL_DISCONNECT_TEXT);
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {

		if (KeyEvent.VK_ENTER == arg0.getKeyCode()) {
			String inputString = textField.getText();
			currText = textArea.getText();
			ClientLogic.sendMessage(inputString);
			try {
				int insertIndex = currText.indexOf(BODY_CLOSE);
				String head = currText.substring(0, insertIndex);
				String tail = currText.substring(insertIndex);
				head += "<font color = 'green'>" + inputString + "</font>"
						+ NEW_LINE + "<font color = 'red'>"  + ClientLogic.printMessage() + "</font>" + NEW_LINE;
				currText = head + tail;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			textArea.setText(parser.insertSmiles(currText));
			textField.setText("");
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
