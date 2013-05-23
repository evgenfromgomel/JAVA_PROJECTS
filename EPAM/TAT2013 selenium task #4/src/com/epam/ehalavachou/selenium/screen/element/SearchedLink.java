package com.epam.ehalavachou.selenium.screen.element;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

public class SearchedLink extends HtmlElement {
	
	@FindBy(className = "b-serp-item__title-link")
	private Link seacherdLink;
	
	public String getHRef(){
		return seacherdLink.getReference();
	}

}
