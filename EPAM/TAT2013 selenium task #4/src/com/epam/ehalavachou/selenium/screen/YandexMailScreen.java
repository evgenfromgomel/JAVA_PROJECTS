package com.epam.ehalavachou.selenium.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import com.epam.ehalavachou.selenium.util.Browser;

public class YandexMailScreen extends Screen {
	
	@FindBy(xpath = "//a[@title='Написать']")
	public Link composeButton;
	
	@FindBy(css = "div.js-compose-mail-input_to > input.b-mail-input_yabbles__focus")
	public WebElement mailToField;
	
	@FindBy(id = "compose-submit")
	public Button sendButton;
	
	@FindBy(xpath = "//input[@name='subj']")
	public TextInput subjField;
	
	public Select mailSelect;
	
	public YandexMailScreen() {
		HtmlElementLoader.populatePageObject(this, browser.getDriver());
		PageFactory.initElements(browser.getDriver(), this);
	}
	
	public YandexMailScreen clickCompose(){
		Browser.setImplicitlyWait(30);
		composeButton.click();
		return this;
	}
	
	
	
	public YandexMailScreen typeMailTo(String str){
		Browser.setImplicitlyWait(30);
		
		/**
		 * There is some tricks in this method, because Yandex's Mail To
		 * input don't work with @method sendKeys() directly
		 * */
		
		subjField.clear();
		subjField.sendKeys(str);
		subjField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		subjField.sendKeys(Keys.chord(Keys.CONTROL, "x"));
		mailToField.sendKeys(Keys.chord(Keys.CONTROL, "v"));
		
		return this;
	}
	
	public YandexMailScreen typeSubject(String str){
		Browser.setImplicitlyWait(30);
		subjField.clear();
		subjField.sendKeys(str);
		return this;
	}
	
	public YandexMailScreen clickSend(){
		Browser.setImplicitlyWait(30);
		sendButton.click();
		return this;
	}
	
	public YandexMailScreen checkMail(String subject){
		Browser.setImplicitlyWait(30);
		String locator = String.format("//span[@title='%1s']/../../../label/input", subject);
		WebElement mailSelect1 = browser.getDriver().findElement(By.xpath(locator));
		mailSelect1.click();
		return this;
	}
	
	public boolean isMessageSent(){
		Browser.setImplicitlyWait(30);
		By sendSuccessMessBox = By.xpath("//div[text()='Письмо успешно отправлено.']");
		if(browser.isElementPresent(sendSuccessMessBox)) return true;
		else return false;
	}
	
}
