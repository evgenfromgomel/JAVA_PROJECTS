package main;

import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;

public class WindowLoader {
	
	public static void loadWelcome(String name){
		
		WelcomeWindow window = new WelcomeWindow();
		JLabel lbl = (JLabel) window.getContentPane().getComponent(0);
		lbl.setText("Hello, " + name);
		window.setVisible(true);
		//JPanel contentPane = (JPanel) ;
		//System.out.println(window.getFrame().getContentPane()); 
		
	}

}
