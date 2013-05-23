package com.epam.ehalavachou.selenium.screen;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import com.epam.ehalavachou.selenium.resource.Resource;
import com.epam.ehalavachou.selenium.util.Browser;

public class YandexSearchScreen extends Screen {
	
	
	@FindBy(id = "text")
	private TextInput searchField;
	
	@FindBy(css = "input.b-form-button__input")
	private Button searchButton;
	
	public YandexSearchScreen() {
		HtmlElementLoader.populatePageObject(this, browser.getDriver());
	}
	
	public static YandexSearchScreen open(){
		Browser.get().loadBrowser(Resource.getURL(Resource.URL_YARU));
		return new YandexSearchScreen();
	}
	
	public YandexSearchResultScrn submitSearch(){
		Browser.setImplicitlyWait(30);
		searchButton.click();
		return new YandexSearchResultScrn();
	}
	
	public YandexSearchScreen typeSearchQuery(String str){
		Browser.setImplicitlyWait(30);
		searchField.clear();
		searchField.sendKeys(str);
		return this;
	}
	

}
