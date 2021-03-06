package com.epam.ehalavachou.selenium.screen;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.epam.ehalavachou.selenium.util.Browser;
import com.epam.ehalavachou.selenium.util.TextHandler;


public class VirtualKeyboard {
	
	String locatorPattern = "//span[text()='?']";
	Browser browser;
	By kbActivateLoactor = By.xpath("//div[2]/i");
	By kbJsLoadLocator = By.xpath("//div[@onclick=\"return {name: 'b-keyboard', fake: false, lang: 'ru'};\"]");
	By specSymbolSwitcher = By.xpath("//tbody/tr/td//span[text()='� � { } ~']/..");

	public VirtualKeyboard() {
		browser = Browser.getInstance();
		
	}
	
	public void typeText(String text){
		browser.getElement(kbActivateLoactor).click();
		browser.getElement(kbJsLoadLocator).click();
		List<String> textArray = TextHandler.parseString(text);
		for(String s : textArray){
			if(TextHandler.isLetter(s))
				typeLetter(s);
			else typeSpecialSymbol(s);
		}
		browser.getElement(kbActivateLoactor).click();
	}
	/**
	 * There are troubles with virtual keyboard.
	 * Method click() can't perform this action on virtual keyboard.
	 * Therefore clicks to keyboard are replaced sending symbols to input.
	 * In case, if click can be perform, in comments line wrote code, witch must work. 
	 * */
	private void typeLetter(String letter){
		WebElement button = browser.getElement(makeLocator(letter));
		WebDriver driver = browser.getDriver();
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", button);
		//browser.getElement(By.xpath("//input[@id='text']")).sendKeys(letter);
	}
	
	private void typeSpecialSymbol(String symbol){
	//	browser.getElement(specSymbolSwitcher).click();
	//	browser.getElement(makeLocator(symbol)).click();
		browser.getElement(By.xpath("//input[@id='text']")).sendKeys(symbol);
	//	browser.getElement(specSymbolSwitcher).click();
	}
	
	private By makeLocator(String str){
		String locatorString = locatorPattern.replace("?", str);
		return By.xpath(locatorString);
	}
	
}

