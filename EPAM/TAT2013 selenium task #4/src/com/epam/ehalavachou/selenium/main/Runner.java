package com.epam.ehalavachou.selenium.main;

import com.epam.ehalavachou.selenium.screen.YandexLoginScreen;
import com.epam.ehalavachou.selenium.screen.YandexMailScreen;
import com.epam.ehalavachou.selenium.util.Browser;

public class Runner {

	/**
	 * @param args
	 */

	// public static int GLOBAL_BROWSER_ID = Browser.MOZILLA_FIREFOX;

	public static void main(String[] args) {

		Browser.get().setupBrowser(Browser.MOZILLA_FIREFOX);
		boolean flag = YandexLoginScreen.open().typeLogin("TestNGtask3")
				.typePassword("Tester123").submitEnter().isLoginSuccess();
		if (flag) {
			YandexMailScreen mail = new YandexMailScreen();
			boolean flag2 = mail.clickCompose()
					.typeMailTo("TestNGtask3@yandex.by").typeSubject("test 1")
					.clickSend().isMessageSent("test 1");
			// mail.checkMail("test 1");
			System.out.println(flag2);

		}

		Browser.get().exit();

		/*
		 * TestNG tng = new TestNG(); XmlSuite suite = new XmlSuite();
		 * List<String> file = new ArrayList<String>(); List<XmlSuite> suites =
		 * new ArrayList<XmlSuite>(); file.add("testng.xml");
		 * suite.setSuiteFiles(file); suites.add(suite);
		 * tng.setXmlSuites(suites); tng.run();
		 */

		/*
		 * Settings sets = new Settings(); CmdLineParser cli = new
		 * CmdLineParser(sets); try { cli.parseArgument(args);
		 * sets.printSettigs(); } catch (CmdLineException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

	}

}
