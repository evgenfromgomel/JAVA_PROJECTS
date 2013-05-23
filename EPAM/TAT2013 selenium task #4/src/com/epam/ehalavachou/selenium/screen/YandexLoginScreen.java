package com.epam.ehalavachou.selenium.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import com.epam.ehalavachou.selenium.resource.Resource;
import com.epam.ehalavachou.selenium.util.Browser;


public class YandexLoginScreen extends Screen {
	
	@FindBy(xpath = "//input[@id='id001']")
	private TextInput loginField;
	
	@FindBy(xpath = "//input[@id='id002']")
	private TextInput passwordField;
	
	@FindBy(xpath = "//input[@value='Войти']")
	private Button enter;
	
	WebElement errorWrongLogPass;
	
	public YandexLoginScreen() {
		HtmlElementLoader.populatePageObject(this, browser.getDriver());
	}
	
	public static YandexLoginScreen open(){
		Browser.get().loadBrowser(Resource.getURL(Resource.URL_YABY));
		return new YandexLoginScreen();
	}
	
	public YandexLoginScreen submitEnter(){
		Browser.setImplicitlyWait(30);
		enter.click();
		return this;
	}
	
	public YandexLoginScreen typeLogin(String login){
		Browser.setImplicitlyWait(30);
		loginField.clear();
		loginField.sendKeys(login);
		return this;
	}
	
	public YandexLoginScreen typePassword(String password){
		Browser.setImplicitlyWait(30);
		passwordField.clear();
		passwordField.sendKeys(password);
		return this;
	}
	
	public boolean isLoginSuccess(){
		boolean logined = true;
		By errorMessageLocator = By.xpath("//strong[text()='Неправильная пара логин-пароль!']");
		By capchaLocator = By.xpath("//td[@class='txt']/div[@class='l']");
		if(browser.isElementPresent(errorMessageLocator) || browser.isElementPresent(capchaLocator)) logined = false;
		return logined;
	}
	
	
	
	
	
	
}
