package com.stepdefinition;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.base.BaseClass;
import com.endpoints.Endpoints;

import global.GlobalData;
import io.cucumber.java.en.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC6_ChangeProfilePicStep extends BaseClass {

	Response response;
	
	@Given("User add header to change profile picture")
	public void user_add_header_to_change_profile_picture() {
		
		
		List<Header> header= new ArrayList<>();
		
		Header h1=new Header("accept","application/json");
		Header h2=new Header("Authorization","Bearer "+ TC1_LoginStep.globalData.getLogtoken());
		Header h3=new Header("Content-Type","multipart/form-data");
	
		header.add(h1);
		header.add(h2);
		header.add(h3);
	
		Headers headers=new Headers(header);
		addHeaders(headers);
	}

	@When("User add form data for change profile picture")
	public void user_add_form_data_for_change_profile_picture() {
		
		addFormData("profile_picture", new File(getProjectPath()+getPropertyfileValue("profilepicturepath")));
	
	
	}

	@When("User send {string} request type and endpoint to change profile picture")
	public void user_send_request_type_and_endpoint_to_change_profile_picture(String reqtype) {
	
	 response = addReqType(reqtype, Endpoints.CHANGEPROFILEPIC);
	 
	 int actstatusCode = getStatusCode(response);
	 TC1_LoginStep.globalData.setStatuscode(actstatusCode);
		
	}


	@Then("User verify status code is {int}")
	public void user_verify_status_code_is(Integer int1) {
	
	
	}

	@Then("User verify profile picture response message matches {string}")
	public void user_verify_profile_picture_response_message_matches(String string) {
	
	
	}

}
