package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pagemanager.PayloadManager;
import com.pojo.address.AddUserAddress_Input_Pojo;
import com.pojo.address.AddUserAddress_Output_Pojo;
import com.pojo.address.DeleteUserAdd_Input_pojo;
import com.pojo.address.DeleteUserAdd_Output_Pojo;
import com.pojo.address.GetUserAddress_Output_Pojo;
import com.pojo.address.UpdateUserAddress_Input_Pojo;
import com.pojo.address.UpdateUserAddress_Output_Pojo;

import io.cucumber.java.en.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC4_AddressStep extends BaseClass {
	Response response;
	PayloadManager pom = new PayloadManager();

	@Given("User add headers and bearer authorization for accessing add address")
	public void user_add_headers_and_bearer_authorization_for_accessing_add_address() {

		List<Header> listheader = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalData.getLogtoken());
		Header h3 = new Header("Content-Type", "application/json");

		listheader.add(h1);
		listheader.add(h2);
		listheader.add(h3);

		Headers headers = new Headers(listheader);
		addHeaders(headers);

	}

	@When("User add request body for add new address {string},{string},{string},{string},{int},{int},{int},{string},{string} and {string}")
	public void user_add_request_body_for_add_new_address_and(String firstname, String lastname, String mobile,
			String apartment, int stateid, int cityid, int country, String zipcode, String address,
			String addresstype) {

		AddUserAddress_Input_Pojo addUserAddress = pom.getAddresspayload().addUserAddress(firstname, lastname, mobile,
				apartment, TC1_LoginStep.globalData.getStateId(), TC1_LoginStep.globalData.getCityId(), country, zipcode,
				address, addresstype);

		addBody(addUserAddress);
	}

	@When("User send {string} request and endpoint for adduseraddress")
	public void user_send_request_and_endpoint_for_adduseraddress(String reqtype) {

		response = addReqType(reqtype, Endpoints.ADDADDRESS);

		int actstatusCode = getStatusCode(response);

		TC1_LoginStep.globalData.setStatuscode(actstatusCode);

	}

	@Then("User verify the add User Address response message matches {string}")
	public void user_verify_the_add_user_address_response_message_matches(String string) {

		AddUserAddress_Output_Pojo addUserAddress_Output_Pojo = response.as(AddUserAddress_Output_Pojo.class);

		int addressIdNum = addUserAddress_Output_Pojo.getAddress_id();
		System.out.println(addressIdNum);
		String addressId = String.valueOf(addressIdNum);
		TC1_LoginStep.globalData.setAddressId(addressId);

		String actmessage = addUserAddress_Output_Pojo.getMessage();
		System.out.println("Address added success message    :" + actmessage);
		Assert.assertEquals("Verify Address added successfully", "Address added successfully", actmessage);

	}

	@Given("User add headers and bearer authorization for accessing update address")
	public void user_add_headers_and_bearer_authorization_for_accessing_update_address() {

		List<Header> listheader = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalData.getLogtoken());
		Header h3 = new Header("Content-Type", "application/json");

		listheader.add(h1);
		listheader.add(h2);
		listheader.add(h3);

		Headers headers = new Headers(listheader);
		addHeaders(headers);

	}

	@When("User add request body for update new address {string},{string},{string},{string},{string},{int},{int},{int},{string},{string} and {string}")
	public void user_add_request_body_for_update_new_address_and(String addressId, String firstname, String lastname,
			String mobile, String apartment, int stateid, int cityid, int country, String zipcode,
			String address, String addresstype) {

		UpdateUserAddress_Input_Pojo updateUserAddress = pom.getAddresspayload().updateUserAddress(addressId, firstname,
				lastname, mobile, apartment, TC1_LoginStep.globalData.getStateId(),
				TC1_LoginStep.globalData.getCityId(), country, zipcode, address, addresstype);

		addBody(updateUserAddress);
	}

	@When("User send {string} request and endpoint for update user address")
	public void user_send_request_and_endpoint_for_update_user_address(String reqtype) {

		response = addReqType(reqtype, Endpoints.UPDATEADDRESS);

		int actstatusCode = getStatusCode(response);
		TC1_LoginStep.globalData.setStatuscode(actstatusCode);
	}

	@Then("User verify the update User Address response message matches {string}")
	public void user_verify_the_update_user_address_response_message_matches(String string) {

		UpdateUserAddress_Output_Pojo updateUserAddress_Output_Pojo = response.as(UpdateUserAddress_Output_Pojo.class);

		String actmessage = updateUserAddress_Output_Pojo.getMessage();
		System.out.println("Address updated success message    :" + actmessage);
		Assert.assertEquals("Verify Address updated successfully", "Address updated successfully", actmessage);

	}

	@Given("User add headers and bearer authorization for accessing get address")
	public void user_add_headers_and_bearer_authorization_for_accessing_get_address() {

		List<Header> listheader = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalData.getLogtoken());

		listheader.add(h1);
		listheader.add(h2);

		Headers headers = new Headers(listheader);
		addHeaders(headers);
	}

	@When("User send {string} request and endpoint to get user address")
	public void user_send_request_and_endpoint_to_get_user_address(String reqtype) {

		response = addReqType(reqtype, Endpoints.GETUSERADDRESS);

		int actstatusCode = getStatusCode(response);
		TC1_LoginStep.globalData.setStatuscode(actstatusCode);

	}

	@Then("User verify the get User Address response message matches {string}")
	public void user_verify_the_get_user_address_response_message_matches(String string) {
		
         GetUserAddress_Output_Pojo getUserAddress_Output_Pojo = response.as(GetUserAddress_Output_Pojo.class);
         String actmessage = getUserAddress_Output_Pojo.getMessage();
         System.out.println("Address Get success message    :" + actmessage);
 		Assert.assertEquals("Verify Address get successfully", "OK", actmessage);
		
	}

	@Given("User add headers and bearer authorization for accessing delete address")
	public void user_add_headers_and_bearer_authorization_for_accessing_delete_address() {

		List<Header> listheader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalData.getLogtoken());
		Header h3 = new Header("Content-Type", "application/json");
		listheader.add(h1);
		listheader.add(h2);
		listheader.add(h3);
		Headers headers = new Headers(listheader);
		addHeaders(headers);
	}

	@When("User add request body for delete user address {string}")
	public void user_add_request_body_for_delete_user_address(String addressId) {

		String addressId2 = TC1_LoginStep.globalData.getAddressId();
		DeleteUserAdd_Input_pojo deleteUserAddress = pom.getAddresspayload().deleteUserAddress(addressId2);
		addBody(deleteUserAddress);
		System.out.println("deleteUserAddress    :"+deleteUserAddress);
	}

	@When("User send {string} request and endpoint to delete User address")
	public void user_send_request_and_endpoint_to_delete_user_address(String reqtype) {

		response = addReqType(reqtype, Endpoints.DELETEADDRESS);
		int actstatusCode = getStatusCode(response);
		TC1_LoginStep.globalData.setStatuscode(actstatusCode);

	}

	@Then("User verify the delete User Address response message matches {string}")
	public void user_verify_the_delete_user_address_response_message_matches(String string) {

		DeleteUserAdd_Output_Pojo deleteUserAdd_Output_Pojo = response.as(DeleteUserAdd_Output_Pojo.class);

		String actmessage = deleteUserAdd_Output_Pojo.getMessage();
		System.out.println("Address deleted success message    :" + actmessage);
		Assert.assertEquals("Verify Address deleted successfully", "Address deleted successfully", actmessage);
	}

}
