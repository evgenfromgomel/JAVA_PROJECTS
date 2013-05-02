
package by.games.runnergame;

import by.games.screen.WindowHandler;
import javax.swing.SwingUtilities;


public class SimpleGame {

  
       public static void main(String[] args) {
      SwingUtilities.invokeLater( new Runnable() {
            @Override
            public void run() {     
                WindowHandler.createAndShowGUI();
            }
        });
      
    }
}
