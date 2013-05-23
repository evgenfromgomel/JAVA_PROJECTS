package com.epam.ehalavachou.selenium.screen;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.epam.ehalavachou.selenium.util.Browser;


public class YandexLoginScreen extends Screen {
	
	WebElement inputLogin;
	WebElement inputPassword;
	WebElement buttonEnter;
	WebElement errorWrongLogPass;
	public YandexLoginScreen() {
		screenURL = "http://yandex.by/";
		browser = Browser.getInstance();
		
		browser.loadBrowser(screenURL);
		
		inputLogin = browser.getElement(By.xpath("//input[@id='id001']"));
		inputPassword = browser.getElement(By.xpath("//input[@id='id002']"));
		buttonEnter = browser.getElement(By.xpath("//input[@value='Войти']"));
	}
	
	public YandexLoginScreen submitEnter(){
		browser.setImplicitlyWait(30);
		buttonEnter.click();
		return this;
	}
	
	public YandexLoginScreen typeLogin(String login){
		browser.setImplicitlyWait(30);
		inputLogin.clear();
		inputLogin.sendKeys(login);
		return this;
	}
	
	public YandexLoginScreen typePassword(String password){
		browser.setImplicitlyWait(30);
		inputPassword.clear();
		inputPassword.sendKeys(password);
		return this;
	}
	
	public boolean isLoginSuccess(){
		boolean logined = true;
		By errorMessageLocator = By.xpath("//strong[text()='Неправильная пара логин-пароль!']");
		By capchaLocator = By.xpath("//td[@class='txt']/div[@class='l']");
		if(isElementPresent(errorMessageLocator) || isElementPresent(capchaLocator)) logined = false;
		return logined;
	}
	
	private boolean isElementPresent(By locator) {
        browser.setImplicitlyWait(0);
        List<WebElement> elements = browser.getDriver().findElements(locator);
        browser.setImplicitlyWait(30);
        return elements.size() > 0 && elements.get(0).isDisplayed();
    }
	
	
	
	
}
