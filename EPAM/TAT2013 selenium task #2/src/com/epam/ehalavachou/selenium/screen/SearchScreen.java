package com.epam.ehalavachou.selenium.screen;

import org.openqa.selenium.By;

import com.epam.ehalavachou.selenium.util.Browser;

public class SearchScreen extends Screen {
	
	Browser browser;
	VirtualKeyboard vkb;
	private By searchFieldLocator = By.id("text");
	private By searchButtonLocator = By.cssSelector("input.b-form-button__input");
	private By firstResultLocator = By.cssSelector("a.b-serp-item__title-link > span");
	private By numberResultsLocator = By.xpath("//strong[@class='b-head-logo__text']");
	
	public SearchScreen() {
		browser = Browser.getInstance();
		vkb = new VirtualKeyboard();
	}
	
	public SearchScreen submitSearch(){
		browser.getElement(searchButtonLocator).click();
		return this;
	}
	
	public SearchScreen typeSearchQuery(String str){
		browser.getElement(searchFieldLocator).clear();
		browser.getElement(searchFieldLocator).sendKeys(str);
		return this;
	}
	
	public SearchScreen typeSearchTextByVK(String str){
		vkb.typeText(str);
		return this;
	}
	
	public String getFirstResultText() {
		return browser.getElement(firstResultLocator).getText();
	}

	public String getNumberResultsText() {
		return browser.getElement(numberResultsLocator).getText();
	}
}
