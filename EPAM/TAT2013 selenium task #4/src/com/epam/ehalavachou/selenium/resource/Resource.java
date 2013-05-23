package com.epam.ehalavachou.selenium.resource;

import java.util.ResourceBundle;

public class Resource {
	
    private static ResourceBundle inputData = 
    	ResourceBundle.getBundle("com.epam.ehalavachou.selenium.resource.inputData");
    private static ResourceBundle urls = 
        	ResourceBundle.getBundle("com.epam.ehalavachou.selenium.resource.urls");
   
    public static final String USER_LOGIN = "user.login";
    public static final String PASSWORD_CORRECT = "pass.corr";
    public static final String PASSWORD_INCORRECT  = "pass.incorr";
    public static final String CITY_MINSK  = "minsk";
    public static final String CITY_MOSCOW  = "moscow";
    
    //URLs keys
    public static final String URL_YARU  = "url.yaRU";
    public static final String URL_YABY  = "url.yaBY";
    
    public static String getInputData(String key) {
        return inputData.getString(key);
    }
    
    public static String getString(String key){
    	return inputData.getString(key);
    }
    
    public static String getURL(String key){
    	return urls.getString(key);
    }
    
   
}