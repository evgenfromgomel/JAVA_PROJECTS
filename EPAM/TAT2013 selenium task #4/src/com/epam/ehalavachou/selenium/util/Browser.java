package com.epam.ehalavachou.selenium.util;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Browser {
	
	public static final int MOZILLA_FIREFOX = 0x01;
	public static final int GOOGLE_CHROME = 0x02;
	public static final int IE = 0x03;
	public static final int SAFARI = 0x04;
	
	private static WebDriver webDriver;
	private static Browser instance;
	
	private Browser() {
	}
	
	public static Browser get(){
		if(instance == null){
			instance = new Browser();
		}
		return instance;
	}
	
	public void loadBrowser(String url){
		setImplicitlyWait(30);
		webDriver.get(url);
	}
	
	public WebDriver getDriver(){
		return webDriver;
	}
	
	public static void setImplicitlyWait(int duration){
		webDriver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
	}
	
	public void waitElement(By locator, int duration){
		WebDriverWait waiter = new WebDriverWait(webDriver, duration, 1000);
		waiter.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void exit(){
		webDriver.quit();
	}
	
	public void back(){
		webDriver.navigate().back();
	}
	
    public  boolean isElementPresent(By locator) {
    	webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        List<WebElement> elements = webDriver.findElements(locator);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return elements.size() > 0 && elements.get(0).isDisplayed();
    }
	
	public void setupBrowser(int browserType){
		switch(browserType){
			case MOZILLA_FIREFOX:
				webDriver = new FirefoxDriver();
				break;
			case GOOGLE_CHROME:
				webDriver = new ChromeDriver();
				break;
			case IE:
				webDriver = new InternetExplorerDriver();
				break;
			case SAFARI:
				webDriver = new SafariDriver();
				break;
		}
		
	}
	
	

}
