package com.epam.ehalavachou.selenium.resource;

import java.util.ResourceBundle;

public class Resource {
	
    private static ResourceBundle inputData = 
    	ResourceBundle.getBundle("com.epam.ehalavachou.selenium.resource.inputData");
   
    public static final String USER_LOGIN = "user.login";
    public static final String PASSWORD_CORRECT = "pass.corr";
    public static final String PASSWORD_INCORRECT  = "pass.incorr";
    public static final String CITY_MINSK  = "minsk";
    public static final String CITY_MOSCOW  = "moscow";
    
    public static String getInputData(String key) {
        return inputData.getString(key);
    }
    
    public static String getString(String key){
    	return inputData.getString(key);
    }
    
   
}