package com.epam.ehalavachou.selenuim.main;

import com.epam.ehalavachou.selenuim.handlers.FirefoxHandler;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String searchText = "Головачев";
		FirefoxHandler firefox = new FirefoxHandler();
		firefox.makeSearchByYandex(searchText);
		System.out.println("Test completed!");
	}

}
