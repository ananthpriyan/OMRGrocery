package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.login.Login_Output_Pojo;

import global.GlobalData;
import io.cucumber.java.en.*;
import io.restassured.response.Response;

public class TC1_LoginStep extends BaseClass {

	Response response;
	static GlobalData globalData = new GlobalData();

	@Given("User add header")
	public void user_add_header() {

		addHeader("accept", "application/json");

	}

	@Then("User add basic authentication for login")
	public void user_add_basic_authentication_for_login() {
		addBasicAuth(getPropertyfileValue("username"), getPropertyfileValue("password"));
	}

	@Then("User send {string} request for login endpoint")
	public void user_send_request_for_login_endpoint(String reqtype) {
		response = addReqType(reqtype, Endpoints.POSTMANBASICAUTH);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		globalData.setStatuscode(statusCode);
	}

	@Then("User verify the login response body firstname present as {string} and get the logtoken saved")
	public void user_verify_the_login_response_body_firstname_present_as_and_get_the_logtoken_saved(String expected) {

		Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);
		String actfirst_name = login_Output_Pojo.getData().getFirst_name();
		System.out.println("first_name     :" + actfirst_name);
		String logtoken = login_Output_Pojo.getData().getLogtoken();
		globalData.setLogtoken(logtoken);
		System.out.println("logtoken    :" + logtoken);
		Assert.assertEquals("Verify first name", expected, actfirst_name);
		
	}

}
