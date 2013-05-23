package com.epam.ehalavachou.selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.ehalavachou.selenium.bean.Account;
import com.epam.ehalavachou.selenium.resource.Resource;
import com.epam.ehalavachou.selenium.service.UserLoginService;

public class TestLoginNegative {
	

	@Test
	public void assertLoginNegative() {
		Account account = new Account(Resource.getString(Resource.USER_LOGIN),
				Resource.getString(Resource.PASSWORD_INCORRECT));
		UserLoginService login = new UserLoginService();
		boolean loginResult =  login.loginUser(account);
		Assert.assertFalse(loginResult, "Login is success. Negative test failed.");
	}
}
