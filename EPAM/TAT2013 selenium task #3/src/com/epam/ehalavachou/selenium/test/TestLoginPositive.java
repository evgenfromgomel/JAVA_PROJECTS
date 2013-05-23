package com.epam.ehalavachou.selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.ehalavachou.selenium.bean.Account;
import com.epam.ehalavachou.selenium.resource.Resource;
import com.epam.ehalavachou.selenium.service.UserLoginService;

public class TestLoginPositive {


	@Test
	public void assertLoginPositive() {
		Account account = new Account(Resource.getString(Resource.USER_LOGIN),
				Resource.getString(Resource.PASSWORD_CORRECT));
		UserLoginService login = new UserLoginService();
		boolean loginResult =  login.loginUser(account);
		Assert.assertTrue(loginResult, "Login is not success. Positive test failed.");
	}
}
