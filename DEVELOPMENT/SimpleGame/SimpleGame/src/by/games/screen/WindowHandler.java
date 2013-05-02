
package by.games.screen;

import by.games.resource.ResMng;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class WindowHandler extends JPanel implements ActionListener {
    
   protected JButton buttonSwitch1, buttonSwitch2;
    
   public WindowHandler(){
       
        buttonSwitch1 = new JButton("Switch to ->");
        buttonSwitch2 = new JButton("<- Switch to");
        
        buttonSwitch1.setActionCommand("enable1");
        buttonSwitch2.setActionCommand("enable2");
        
        
        buttonSwitch2.setEnabled(false);
        
        buttonSwitch1.addActionListener(this);
        buttonSwitch2.addActionListener(this);
        
       // 
        add(buttonSwitch1);
        add(buttonSwitch2);
      // 
     //   setLocationRelativeTo(null);
     //   setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
   
       public static void createAndShowGUI() {
 
        //Create and set up the window.
        JFrame frame = new JFrame("ButtonDemo");
        
         JMenuBar menubar = new JMenuBar();
       // ImageIcon icon = new ImageIcon(getClass().getResource(ResMng.getImage(ResMng.IMG_EXIT_MENU_ICO)));
        JMenu menu = new JMenu(ResMng.getText(ResMng.TEXT_MENU_FILE));
        menu.setMnemonic(KeyEvent.VK_F);
        JMenuItem menuItem1 = new JMenuItem(ResMng.getText(ResMng.TEXT_MENU_EXIT));
        menuItem1.setMnemonic(KeyEvent.VK_C);
        menuItem1.setToolTipText(ResMng.getText(ResMng.TEXT_EXIT_TIP));
        menuItem1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(menuItem1);
        menubar.add(menu);
        frame.setJMenuBar(menubar);
        
        //Create and set up the content pane.
        WindowHandler newContentPane = new WindowHandler();
        
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);


        //Display the window.
        frame.pack();
        frame.setSize(300, 200);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
   
   private  JMenuBar addMenuBar(){
        JMenuBar menubar = new JMenuBar();
        ImageIcon icon = new ImageIcon(getClass().getResource(ResMng.getImage(ResMng.IMG_EXIT_MENU_ICO)));
        JMenu menu = new JMenu(ResMng.getText(ResMng.TEXT_MENU_FILE));
        menu.setMnemonic(KeyEvent.VK_F);
        JMenuItem menuItem1 = new JMenuItem(ResMng.getText(ResMng.TEXT_MENU_EXIT), icon);
        menuItem1.setMnemonic(KeyEvent.VK_C);
        menuItem1.setToolTipText(ResMng.getText(ResMng.TEXT_EXIT_TIP));
        menuItem1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(menuItem1);
        menubar.add(menu);
        return menubar;
   }

    @Override
    public void actionPerformed(ActionEvent e) {
            if ("enable1".equals(e.getActionCommand())){
            buttonSwitch1.setEnabled(false);
            buttonSwitch2.setEnabled(true);
        }
        else {
                        buttonSwitch1.setEnabled(true);
            buttonSwitch2.setEnabled(false);
        }
    }

    
}
