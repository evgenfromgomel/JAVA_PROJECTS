package com.epam.ehalavachou.selenium.util;

import org.kohsuke.args4j.Option;

public class Settings {
	
	@Option(name = "-tout", usage = "Time out general value" )
	public int timeout;
	
	@Option(name = "-br", usage = "Sets using browser", aliases = "--browser")
	public int browser;
	
	@Option(name = "-tstng", usage = "Sets testng.xml")
	public String testng;
	
	public void printSettigs(){
		System.out.println(timeout);
		System.out.println(browser);
		System.out.println(testng);
	}

}
