package com.epam.ehalavachou.selenium.service;

import com.epam.ehalavachou.selenium.screen.SearchScreen;

public class SearchService {
	
	SearchScreen screen;
	String linkText = "Нашлось";
	
	public SearchService() {
		screen = new SearchScreen();
	}
	 
	public void findText(String text){
		screen.typeSearchTextByVK(text).submitSearch();
	}
	
	public String getFirstResult(){
		return screen.getFirstResultText();
	}
	
	public String getNumResults(){
		String numStr = screen.getNumberResultsText();
		return numStr.substring(linkText.length());
	}

}
