package com.epam.ehalavachou.selenium.test;

import com.epam.ehalavachou.selenium.service.SearchService;

public class SearchTest extends Test {

	SearchService searching;
	
	public SearchTest() {
		searching = new SearchService();
	}
	
	@Override
	public void makeTest(String s) {
		searching.findText(s);
		String firstResult = searching.getFirstResult();
		String numResults =	searching.getNumResults();
		System.out.println("----------------------------------");
		System.out.println("String " + s + " are searched");
		System.out.println("First result: " + firstResult);
		System.out.println("Number of results: " + numResults);
		System.out.println("----------------------------------");
	}

}
