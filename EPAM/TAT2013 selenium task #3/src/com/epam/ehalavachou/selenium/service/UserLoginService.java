package com.epam.ehalavachou.selenium.service;

import com.epam.ehalavachou.selenium.bean.Account;
import com.epam.ehalavachou.selenium.main.Runner;
import com.epam.ehalavachou.selenium.screen.YandexLoginScreen;
import com.epam.ehalavachou.selenium.util.Browser;

public class UserLoginService {
	
	public boolean loginUser(Account acc){
		Browser.getInstance().setupBrowser(Runner.GLOBAL_BROWSER_ID);
		YandexLoginScreen logScreen = new YandexLoginScreen();
		boolean logined = false;
		logined = logScreen.typeLogin(acc.getLogin()).typePassword(acc.getPassword()).submitEnter().isLoginSuccess();
		Browser.getInstance().getDriver().close();
		return logined;
		
	}
	
}
