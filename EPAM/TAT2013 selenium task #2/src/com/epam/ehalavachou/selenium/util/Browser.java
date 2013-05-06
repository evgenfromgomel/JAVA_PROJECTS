package com.epam.ehalavachou.selenium.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Browser {
	
	WebDriver webDriver;
	private static Browser instance;
	String link = "http://ya.ru/";
	
	public Browser() {
		webDriver = new FirefoxDriver();
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		loadBrowser(link);
	}
	
	public void loadBrowser(String url){
		webDriver.get(url);
	}
	
	public WebDriver getDriver(){
		return webDriver;
	}
	
	public void close(){
		webDriver.quit();
	}
	
	public void back(){
		webDriver.navigate().back();
	}
	
	public WebElement getElement(By locator){
		return webDriver.findElement(locator);
	}
	

	
	public static Browser getInstance(){
		if(instance == null){
			instance = new Browser();
		}
		return instance;
	}

}
