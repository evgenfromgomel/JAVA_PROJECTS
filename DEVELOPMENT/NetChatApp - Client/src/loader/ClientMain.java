/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package loader;

import java.io.*;
import java.net.*;
import org.apache.log4j.Logger;


/**
 *
 * @author evgen
 */
public class ClientMain {
    
    static Logger logger = Logger.getLogger(ClientMain.class);
    
    public static int PORT = 8080;
      public static void main(String[] args) throws IOException {
  
      InetAddress addr = InetAddress.getByName(null);
    
      logger.info("addr = " + addr);
      Socket socket = new Socket(addr, PORT);
      try {
         logger.info("socket = " + socket);
         BufferedReader in = new BufferedReader(new InputStreamReader(socket
               .getInputStream()));
         PrintWriter out = new PrintWriter(new BufferedWriter(
               new OutputStreamWriter(socket.getOutputStream())), true);
         for (int i = 0; i < 10; i++) {
            out.println("howdy " + i);
            String str = in.readLine();
            logger.info(str);
         }
         out.println("END");
      }
      finally {
         logger.info("closing...");
         socket.close();
      }
   }
}
