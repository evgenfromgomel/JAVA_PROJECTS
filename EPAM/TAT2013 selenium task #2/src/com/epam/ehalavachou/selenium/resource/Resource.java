package com.epam.ehalavachou.selenium.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

public class Resource {
	
    private static ResourceBundle inputData = 
    	ResourceBundle.getBundle("com.epam.ehalavachou.selenium.resource.inputData");
   
    
    public static String getInputData(String key) {
        return inputData.getString(key);
    }
    
    public static List<String> getTextToSearch(){
    	List<String> list = new ArrayList<String>();
    	Set<String> keys = inputData.keySet();
    	for(String k : keys){
    		list.add(getInputData(k));
    	}
    	return list;
    }
    
   
}