package com.chatapp.client.gui;

import javax.swing.JFrame;

@Deprecated
public class MainFrame extends JFrame {

	private MainPanel mainPanel;

	public MainFrame() {
		mainPanel = new MainPanel();
		setTitle("Messenager");
		getContentPane().add(mainPanel);
		pack();
	}

}
