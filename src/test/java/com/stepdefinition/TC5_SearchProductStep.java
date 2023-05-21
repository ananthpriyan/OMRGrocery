package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pagemanager.PayloadManager;

import com.pojo.product.SearchProduct_Input_Pojo;
import com.pojo.product.SearchProduct_Output_Pojo;
import com.pojo.product.SearchProduct_Output_Pojo.Product;

import io.cucumber.java.en.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC5_SearchProductStep extends BaseClass {
	Response response;
	PayloadManager pom=new PayloadManager();
	
	@Given("User add headers for the Search Product")
	public void user_add_headers_for_the_search_product() {
		
		List<Header> listheader = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");

		listheader.add(h1);
		listheader.add(h2);

		Headers headers = new Headers(listheader);
		addHeaders(headers);
	}

	@When("User add request body to get Search Product {string}")
	public void user_add_request_body_to_get_search_product(String text) {
		
		SearchProduct_Input_Pojo searchProduct = pom.getProductpayload().searchProduct(text);
	    addBody(searchProduct);
	
	}

	@When("User send {string} request for Search Product and endpoint")
	public void user_send_request_for_search_product_and_endpoint(String reqtype) {
		
		response = addReqType(reqtype, Endpoints.SEARCHPRODUCT);
		
		int actstatusCode = getStatusCode(response);
		TC1_LoginStep.globalData.setStatuscode(actstatusCode);
	}

	@Then("User verify the Search Product response message matches {string}")
	public void user_verify_the_search_product_response_message_matches(String string) {
		
		SearchProduct_Output_Pojo searchProduct_Output_Pojo = response.as(SearchProduct_Output_Pojo.class);
		
		ArrayList<Product> data = searchProduct_Output_Pojo.getData();

		for (Product eachproduct : data) {

			String text = eachproduct.getText();
			System.out.println(text);

		}
		String actmessage = searchProduct_Output_Pojo.getMessage();
		System.out.println("Search product success message    :" + actmessage);
		Assert.assertEquals("Verify success message ", "OK", actmessage);
	}


	
}
