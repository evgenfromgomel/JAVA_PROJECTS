package com.epam.ehalavachou.selenuim.pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
	protected final WebDriver driver;
	
	public AbstractPage(WebDriver driver){
		this.driver = driver;
		System.out.println("Driver "+ driver.getClass().getSimpleName() + " accepted!" );
	}

}
