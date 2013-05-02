package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class BallThread extends JFrame implements Runnable { 
	  JPanel panel; 
	  private int posX, posY; 
	  private final int BALL_SIZE = 10; 
	  private double alpha; 
	  private int SPEED = 4; 
	 
	BallThread(JPanel p) { 
	    this.panel = p; 
	    //задание начальной позиции и направления шарика 
	posX = (int)((panel.getWidth() - BALL_SIZE)  
	* Math.random()); 
	    posY = (int)((panel.getHeight() - BALL_SIZE)  
	* Math.random()); 
	    alpha = Math.random() * 10; 
	  } 
	  public void run() { 
	    while(true) { 
	      posX += (int)(SPEED * Math.cos(alpha)); 
	      posY += (int)(SPEED * Math.sin(alpha)); 
	    //вычисление угла отражения 
	    if( posX >= panel.getWidth() - BALL_SIZE ) 
	      alpha = alpha + Math.PI - 2 * alpha; 
	    else if( posX <= 0 ) 
	        alpha = Math.PI - alpha; 
	    if( posY >= panel.getHeight() - BALL_SIZE ) 
	        alpha = -alpha; 
	    else if( posY <= 0 ) 
	        alpha = -alpha; 
	      paint(panel.getGraphics()); 
	    } 
	  } 
	public void paint(Graphics g) { 
	//прорисовка шарика 
	  g.setColor(Color.BLACK); 
	  g.fillArc(posX, posY, BALL_SIZE, BALL_SIZE, 0, 360); 
	  g.setColor(Color.WHITE); 
	  g.drawArc(posX + 1, posY + 1, BALL_SIZE, 
	BALL_SIZE, 120, 30); 
	    try { 
	      sleep(30); 
	    } catch(InterruptedException e) { 
	      e.printStackTrace(); 
	    } 
	  //удаление шарика 
	  g.setColor(panel.getBackground()); 
	  g.fillArc(posX, posY, BALL_SIZE, BALL_SIZE, 0, 360); 
	  } 
	} 
