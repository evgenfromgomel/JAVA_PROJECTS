package by.gstu.Testing.resource;


import java.util.ResourceBundle;

/**
 * Class extracts info from files errors.properties, db.properies, jspParams.properties
 *
 */
public class Resource {

    private static ResourceBundle errors = ResourceBundle.getBundle("by.gstu.Testing.resource.errors");
    private static ResourceBundle dbProperties = ResourceBundle.getBundle("by.gstu.Testing.resource.db");
    private static ResourceBundle jspParams = ResourceBundle.getBundle("by.gstu.Testing.resource.jspParams");

    
    public static String getStrErr(String key) {
        return errors.getString(key);
    }
     
    public static String getDBProperties(String key) {
        return dbProperties.getString(key);
    }
    
    public static String getJspParams(String key) {
        return jspParams.getString(key);
    }
}