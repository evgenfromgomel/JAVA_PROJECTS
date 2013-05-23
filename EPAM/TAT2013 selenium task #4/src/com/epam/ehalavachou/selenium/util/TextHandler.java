package com.epam.ehalavachou.selenium.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextHandler {
	
	public static List<String> parseString(String str){
		List<String> strArray = new ArrayList<String>();
		char[] chrs = str.toCharArray();
		for(char s : chrs){
			String newString = String.valueOf(s);
			strArray.add(newString);
		}
		return strArray;
	}
	
	public static boolean isLetter(String str){
		String reg = "[à-ÿÀ-ßa-zA-Z]";
		Pattern p1 = Pattern.compile(reg);
		Matcher m1 = p1.matcher(str);
		if(m1.matches())	
			return true;
		else
			return false;
	}
	
	public static String parseLocalTimeString(String str){
		int timeId = 2;
		String[] strArray = str.split(" ");
		return  strArray[timeId];
	}
	
	public static int getHourFromTime(String str){
		int hourId = 0;
		String[] time = str.split(":");
		return Integer.parseInt(time[hourId]);
	}
}
