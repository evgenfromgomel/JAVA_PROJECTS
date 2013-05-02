/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package getip;

import java.net.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;


public class NetAppMain {
    
   static  Logger logger = Logger.getLogger(NetAppMain.class);

   public static void main(String[] args) throws Exception {
        Date date =  Calendar.getInstance().getTime();
        String currDate = new SimpleDateFormat("dd.MM.yy HH:mm").format(date);
        InetAddress a = InetAddress.getByName("UsserPC");
        JFrame frame = new CurrIP();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(500, 300);
        JLabel labelIp = (JLabel) frame.getContentPane().getComponent(1);
        labelIp.setText(a.getHostAddress());
        logger.debug(currDate + " " + a.getHostAddress());
        frame.pack();
        frame.setVisible(true); 
   }
}