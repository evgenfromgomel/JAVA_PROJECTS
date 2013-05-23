package com.epam.ehalavachou.selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.ehalavachou.selenium.resource.Resource;
import com.epam.ehalavachou.selenium.service.TimeCompareService;

public class TestTimeDiffComparation {

	@Test
	public void assertTimeDiff() {
		TimeCompareService timeCompare = new TimeCompareService();
		int needTimeDiff = 1;
		int difference = timeCompare.getTimeDiffer(Resource.getString(Resource.CITY_MINSK),
				Resource.getString(Resource.CITY_MOSCOW));
		Assert.assertEquals(difference, needTimeDiff, "Times difference is not as expected!");

	}
}
