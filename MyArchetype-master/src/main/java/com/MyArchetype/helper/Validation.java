package com.MyArchetype.helper;

import org.testng.Assert;

public class Validation {
	public void validate(String actual, String expected, String errorMessage) {
		Assert.assertEquals(actual, expected, errorMessage);
	}
}
