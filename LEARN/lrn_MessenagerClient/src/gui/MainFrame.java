package gui;

import java.awt.Component;

import javax.swing.JFrame;

public class MainFrame extends JFrame{

	private MainPanel mainPanel;
	
	public MainFrame() {
		mainPanel = new MainPanel();
		setTitle("Messenager");
		getContentPane().add(mainPanel);
		pack();
	}
}
