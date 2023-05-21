package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;

import io.cucumber.java.en.Then;

public class CommonStep extends BaseClass{

	@Then("User verify the statuscode is {int}")
	public void user_verify_the_statuscode_is(int expected) {
	
		int actstatusCode = TC1_LoginStep.globalData.getStatuscode();
		
		Assert.assertEquals("Verify status code", expected, actstatusCode);
		
	}

}
