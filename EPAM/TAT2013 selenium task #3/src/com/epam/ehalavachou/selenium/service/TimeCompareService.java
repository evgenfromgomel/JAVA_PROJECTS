package com.epam.ehalavachou.selenium.service;

import com.epam.ehalavachou.selenium.main.Runner;
import com.epam.ehalavachou.selenium.screen.YandexSearchScreen;
import com.epam.ehalavachou.selenium.util.Browser;
import com.epam.ehalavachou.selenium.util.TextHandler;

public class TimeCompareService {
	
	public int getTimeDiffer(String city1, String city2){
		Browser.getInstance().setupBrowser(Runner.GLOBAL_BROWSER_ID);
		YandexSearchScreen searchScreen = new YandexSearchScreen();
		String firstCityTime = searchScreen.typeSearchQuery(city1).submitSearch().getTimeResultText();
		searchScreen = new YandexSearchScreen();
		String secondCityTime = searchScreen.typeSearchQuery(city2).submitSearch().getTimeResultText();
		int firstCityHour = TextHandler.getHourFromTime(firstCityTime);
		int secondCityHour = TextHandler.getHourFromTime(secondCityTime);
		int differ = Math.abs(secondCityHour - firstCityHour);
		Browser.getInstance().getDriver().close();
		return differ;
	}

}
