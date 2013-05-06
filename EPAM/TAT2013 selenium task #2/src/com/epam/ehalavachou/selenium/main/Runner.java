package com.epam.ehalavachou.selenium.main;


import java.util.ArrayList;
import java.util.List;

import com.epam.ehalavachou.selenium.resource.Resource;
import com.epam.ehalavachou.selenium.screen.SearchScreen;
import com.epam.ehalavachou.selenium.test.SearchTest;
import com.epam.ehalavachou.selenium.test.Test;
import com.epam.ehalavachou.selenium.util.Browser;


public class Runner {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Browser b = Browser.getInstance();
		/*List<String> testingData = Resource.getTextToSearch();
		List<Test> testsPool = new ArrayList<Test>();
		for(int i = 0; i < testingData.size(); i++){
			testsPool.add(new SearchTest());
		}
		for(int i = 0; i < testingData.size(); i++){
			testsPool.get(i).makeTest(testingData.get(i));
			b.back();
		}*/
		Test tst = new SearchTest();
		tst.makeTest("головачев");
		b.close();
	
	}

}
