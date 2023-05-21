package com.stepdefinition;

import java.util.ArrayList;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.address.StateList;
import com.pojo.address.StateList_Output_Pojo;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

public class TC2_GetStateIdStep extends BaseClass {
	
	Response response;
	
	@Given("User add headers for the statelist")
	public void user_add_headers_for_the_statelist() {
		
		addHeader("accept", "application/json");
		
	}

	@When("User send the {string} request for statelist endpoint")
	public void user_send_the_request_for_statelist_endpoint(String reqtype) {
		
		 response = addReqType(reqtype, Endpoints.STATELIST);
		 int actstatusCode = getStatusCode(response);
		 TC1_LoginStep.globalData.setStatuscode(actstatusCode);
	}


	@Then("User verify the statelist response message matches {string} and save the state id")
	public void user_verify_the_statelist_response_message_matches_and_save_the_state_id(String state) {
	
		StateList_Output_Pojo stateList_Output_Pojo = response.as(StateList_Output_Pojo.class);

		ArrayList<StateList> stateList = stateList_Output_Pojo.getData();

		for (StateList eachState : stateList) {

			String stateName = eachState.getName();

			if (stateName.equals(state)) {

			int stateId = eachState.getId();
			TC1_LoginStep.globalData.setStateId(stateId);
			
            String stateIdNum=String.valueOf(stateId);
            TC1_LoginStep.globalData.setStateIdNum(stateIdNum);
             
            
             System.out.println("stateIdNum    :"+stateIdNum);
			 System.out.println("stateId   :" + stateId);
			 
             break;
			}

		}
		
		String actmessage = stateList_Output_Pojo.getMessage();
		
		Assert.assertEquals("Verify message ok","OK",actmessage );
	
	
	}

}
