package com.epam.ehalavachou.selenuim.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchingPage extends AbstractPage { 

	/**
	 * This static fields created for cases,
	 *  when elements id of this page will need
	 *  out from class
	 */
	
	
	public static String SEARCH_FIELD_ID = "text";
	public static String SEARCH_BTN_SELECTOR = "input.b-form-button__input";
	public static String RESULT_FRST_LNK_SELECTOR = "a.b-serp-item__title-link > span";
	
	public SearchingPage(WebDriver driver) {
		super(driver);
	}
	
	By searchFieldLoc = By.id(SEARCH_FIELD_ID);
	By searchBtnLoc = By.cssSelector(SEARCH_BTN_SELECTOR);
	By firstLink = By.cssSelector(RESULT_FRST_LNK_SELECTOR);
	
	/**
	 * There are lot of hardcode, but for an application
	 * of this scale it's excusably */
	
	public SearchingPage typeTextToSearch(String searchingText){
		driver.findElement(searchFieldLoc).clear();
		driver.findElement(searchFieldLoc).sendKeys(searchingText);
		System.out.println("Text " + searchingText + " was typed successfully!");
		return this;
	}
	
	public SearchingPage submitSearch(){
		driver.findElement(searchBtnLoc).click();
		System.out.println("Search button was click!");
		return this;
	}
	
	public SearchingPage readFirstResult(){
		String linkText = "Empty result!";
		linkText = driver.findElement(firstLink).getText();
		System.out.println("Text of first link:\n" + linkText);
		return this;
	}
}
