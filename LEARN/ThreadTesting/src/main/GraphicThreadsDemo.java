package main;

import java.awt.Color; 
import java.awt.Container; 
import java.awt.Graphics; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JPanel; 
 
public class GraphicThreadsDemo extends JFrame { 
  JPanel panel = new JPanel(); 
  Graphics g; 
  JButton btn = new JButton("�������� �����"); 
  int i; 
 
public GraphicThreadsDemo() { 
    setBounds(100, 200, 270, 350); 
    Container contentPane = getContentPane(); 
    contentPane.setLayout(null); 
    btn.setBounds(50, 10, 160, 20); 
    contentPane.add(btn); 
    panel.setBounds(30, 40, 200, 200); 
    panel.setBackground(Color.WHITE); 
    contentPane.add(panel); 
    btn.addActionListener(new ActionListener() { 
    public void actionPerformed(ActionEvent ev) { 
        new BallThread(panel).start(); 
        i++; 
        repaint(); 
      }
    }); 
} 
public static void main(String[] args) { 
  GraphicThreadsDemo frame =  
new GraphicThreadsDemo(); 
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  frame.setVisible(true); 
} 
public void paint(Graphics g){ 
  super.paint(g); 
   g.drawString("���������� �������: " + i, 65, 300); 
} 
} 