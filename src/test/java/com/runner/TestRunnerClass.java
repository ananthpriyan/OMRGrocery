package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\",tags="", dryRun=!true,publish=true, 
         glue="com.stepdefinition", stepNotifications = true,plugin= {"pretty", "json:target\\OMRGroceryApi.json"})


public class TestRunnerClass extends BaseClass {
	
	@AfterClass
	public static void afterClass() {
		
		Reporting.generateReports(System.getProperty("user.dir") + getPropertyfileValue("jsonpath"));

	}

}
