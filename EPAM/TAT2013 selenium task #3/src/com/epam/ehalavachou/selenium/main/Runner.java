package com.epam.ehalavachou.selenium.main;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import com.epam.ehalavachou.selenium.util.Browser;

public class Runner {

	/**
	 * @param args
	 */
	
	public static int GLOBAL_BROWSER_ID = Browser.MOZILLA_FIREFOX;
	
	public static void main(String[] args){ 
		
		TestNG tng = new TestNG();
		XmlSuite suite = new XmlSuite();
		List<String> file = new ArrayList<String>();
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		file.add("testng.xml");
		suite.setSuiteFiles(file);
		suites.add(suite);
		tng.setXmlSuites(suites);
		tng.run();

	}

}
