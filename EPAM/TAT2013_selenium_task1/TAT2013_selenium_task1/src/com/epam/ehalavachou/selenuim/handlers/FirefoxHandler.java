package com.epam.ehalavachou.selenuim.handlers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.epam.ehalavachou.selenuim.pages.SearchingPage;


public class FirefoxHandler {
	
	private final WebDriver driver;
	
	public FirefoxHandler(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void makeSearchByYandex(String searchText){
		driver.get("http://ya.ru/");
		SearchingPage search = new SearchingPage(driver);
		search.typeTextToSearch(searchText).submitSearch().readFirstResult();
		System.out.println("Searching by Yandex was complete!");
		driver.quit();
	}

}
