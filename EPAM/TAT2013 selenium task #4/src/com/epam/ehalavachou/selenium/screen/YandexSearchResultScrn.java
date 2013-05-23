package com.epam.ehalavachou.selenium.screen;

import java.util.List;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import com.epam.ehalavachou.selenium.screen.element.SearchedLink;

public class YandexSearchResultScrn extends Screen {
	
	public YandexSearchResultScrn() {
		HtmlElementLoader.populatePageObject(this, browser.getDriver());
	}
	
	@FindBy(xpath = "//h2[@class = 'b-serp-item__title']")
	private List<SearchedLink> links;
	
	
	public boolean isReferenceSearched(String reference){
		boolean isSearched = false;;
		for(SearchedLink link : links){
			if(link.getHRef().equals(reference)){
			isSearched = true;
			}
			else isSearched =  false;
		}
		return isSearched;
	}

}
