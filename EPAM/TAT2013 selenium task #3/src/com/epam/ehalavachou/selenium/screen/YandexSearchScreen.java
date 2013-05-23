package com.epam.ehalavachou.selenium.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.epam.ehalavachou.selenium.util.Browser;
import com.epam.ehalavachou.selenium.util.TextHandler;

public class YandexSearchScreen extends Screen {
	
	private WebElement searchField;
	private WebElement searchButton;
	private WebElement firstResult;
	private WebElement timeText;
	
	public YandexSearchScreen() {
		screenURL = "http://ya.ru";
		browser = Browser.getInstance();
		
		browser.loadBrowser(screenURL);
		browser.setImplicitlyWait(30);
		searchField = browser.getElement(By.id("text"));
		searchButton = browser.getElement(By.cssSelector("input.b-form-button__input"));
	}
	
	public YandexSearchScreen submitSearch(){
		browser.setImplicitlyWait(30);
		searchButton.click();
		return this;
	}
	
	public YandexSearchScreen typeSearchQuery(String str){
		browser.setImplicitlyWait(30);
		searchField.clear();
		searchField.sendKeys(str);
		return this;
	}
	
	public String getTimeResultText(){
		By timeTextLoc = By.xpath("//div[@class='z-city__info'][a[text()='Местное время']]");
		browser.waitElement(timeTextLoc, 30);
		timeText = browser.getElement(timeTextLoc);
		String timeResult = TextHandler.parseLocalTimeString(timeText.getText());
		return timeResult;
	}
	
	public String getFirstResultText() {
		firstResult = browser.getElement(By.cssSelector("a.b-serp-item__title-link > span"));
		String firstResultText = firstResult.getText(); 
		return firstResultText;
	}

}
