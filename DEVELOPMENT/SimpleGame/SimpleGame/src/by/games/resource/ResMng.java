/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.games.resource;


import java.util.ResourceBundle;

/**
 *
 * @author Usser
 */
public class ResMng {
    private ResourceBundle resourceBundle;
    private ResMng(){
	}

    public static final String IMG_EXIT_MENU_ICO = "exit.menu.ico";
    public static final String TEXT_MAIN_TITLE = "main.window.title";
    public static final String TEXT_MENU_FILE = "menu.file";
    public static final String TEXT_MENU_EXIT = "menu.file.exit";
    public static final String TEXT_EXIT_TIP = "menu.file.exit.tip";
    
    private static ResourceBundle textLine = ResourceBundle.getBundle("by.games.resource.text");
    private static ResourceBundle imagePref = ResourceBundle.getBundle("by.games.resource.image");
    

        public static String getText(String key) {
        return textLine.getString(key);
    }
        public static String getImage(String key) {
        return imagePref.getString(key);
    }


}
