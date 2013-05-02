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
public class ServerMain {
      public static final int PORT = 8080;
      static Logger logger = Logger.getLogger(ServerMain.class);
      
   public static void main(String[] args) throws IOException {
      ServerSocket s = new ServerSocket(PORT);
      logger.info("Started: " + s);
      try {
         // Блокирует до тех пор, пока не возникнет соединение:
         Socket socket = s.accept();
         try {
            logger.info("Connection accepted: " + socket);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                  socket.getInputStream()));
            // Вывод автоматически выталкивается из буфера PrintWriter'ом
            PrintWriter out = new PrintWriter(new BufferedWriter(
                  new OutputStreamWriter(socket.getOutputStream())), true);
            while (true) {
               String str = in.readLine();
               if (str.equals("END"))
                  break;
               logger.info("Echoing: " + str);
               out.println(str);
            }
            // Всегда закрываем два сокета...
         }
         finally {
            logger.info("closing...");
            socket.close();
         }
      }
      finally {
         s.close();
      }
   }
}
