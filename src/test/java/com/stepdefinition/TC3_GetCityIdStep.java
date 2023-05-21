package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pagemanager.PayloadManager;
import com.payload.AddressPayload;
import com.pojo.address.Citylist_Input_Pojo;
import com.pojo.address.Citylist_Output_Pojo;
import com.pojo.address.Citylist_Output_Pojo.CityList;

import global.GlobalData;
import io.cucumber.java.en.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC3_GetCityIdStep extends BaseClass {

	Response response;

	PayloadManager pom = new PayloadManager();

	@Given("User add headers for the citylist")
	public void user_add_headers_for_the_citylist() {

		List<Header> listheader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");

		listheader.add(h1);
		listheader.add(h2);

		Headers headers = new Headers(listheader);
		addHeaders(headers);
	}

	@When("User add request body for the city list {string}")
	public void user_add_request_body_for_the_city_list(String stateid) {

		String stateId2 = TC1_LoginStep.globalData.getStateIdNum();
		System.out.println(stateId2);

		Citylist_Input_Pojo cityList = pom.getAddresspayload().cityList(stateId2);
		// Citylist_Input_Pojo cityList2 = addresspayload.cityList(stateId2);
		System.out.println("cityList   :" + cityList);
		addBody(cityList);

	}

	@When("User send {string} request for citylist and endpoint")
	public void user_send_request_for_citylist_and_endpoint(String reqtype) {
		response = addReqType(reqtype, Endpoints.CITYLIST);
		int actstatusCode = getStatusCode(response);
		TC1_LoginStep.globalData.setStatuscode(actstatusCode);

	}

	@Then("User verify citylist response message matches {string} and save the city id")
	public void user_verify_citylist_response_message_matches_and_save_the_city_id(String city) {

		Citylist_Output_Pojo citylist_Output_Pojo = response.as(Citylist_Output_Pojo.class);

		ArrayList<CityList> cityList = citylist_Output_Pojo.getData();

		for (CityList eachCity : cityList) {

			String cityName = eachCity.getName();

			if (cityName.equals(city)) {

				int cityId = eachCity.getId();
				System.out.println("cityId   :" + cityId);

				TC1_LoginStep.globalData.setCityId(cityId);
				break;
			}

		}

		String actmessage = citylist_Output_Pojo.getMessage();

		Assert.assertEquals("Verify message ok", "OK", actmessage);

	}

}
