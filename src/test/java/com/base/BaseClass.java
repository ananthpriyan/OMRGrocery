package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author Anandharaj
 * @Date 03-05-2023
 * @see To maintain the reusable methods
 */
public class BaseClass {

	public RequestSpecification reqSpec;
	static public Response response;

	
	/**
	 * 
	 * @param key
	 * @return value
	 * @see used to get property file value
	 */
	public static String getPropertyfileValue(String key) {
		
		Properties properties= new Properties();
		try {
			properties.load(new FileInputStream(getProjectPath()+"\\Config\\config.properties"));
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
        
		Object object = properties.get(key);
		
		String string=(String) object;
		return string;
		
		
	}
	
	/**
	 * 
	 * @return path
	 * @see used to get project path
	 */
	public static String getProjectPath() {
		
		String path = System.getProperty("user.dir");
		return path;
	}
	
	
	/**
	 * 
	 * @param key
	 * @param value
	 * @see used to add header
	 */
	public void addHeader(String key, String value) {

		reqSpec = RestAssured.given().header(key, value);

	}
	
	
	public void addFormData(String key,File value ) {
		
	    reqSpec = reqSpec.multiPart(key, value);

	}

	public void addPathParam(String key, String value) {
		reqSpec = reqSpec.pathParam(key, value);

	}

	public void addQueryParam(String key, String value) {

		reqSpec = reqSpec.queryParam(key, value);

	}

	public void addBody(String body) {

		reqSpec = reqSpec.body(body);

	}

	public void addHeaders(Headers headers) {

		reqSpec = RestAssured.given().headers(headers);

	}

	public void addBody(Object body) {

		reqSpec = reqSpec.body(body);

	}

	public Response addReqType(String type, String endpoint) {

		switch (type) {
		case "GET":
			response = reqSpec.log().all().get(endpoint);
			break;
		case "POST":
			response = reqSpec.log().all().post(endpoint);
			break;
		case "PUT":
			response = reqSpec.log().all().put(endpoint);
			break;
		case "DELETE":
			response = reqSpec.log().all().delete(endpoint);
			break;
		case "PATCH":
			response = reqSpec.log().all().patch(endpoint);
			break;

		default:
			break;
		}

		return response;
	}

	public int getStatusCode(Response response) {

		int statusCode = response.getStatusCode();
		return statusCode;

	}

	public String getResBodyAsString(Response response) {

		String asString = response.asString();

		return asString;

	}

	public String getResBodyAsprettyString(Response response) {

		String asPrettyString = response.asPrettyString();

		return asPrettyString;
	}

	public void addBasicAuth(String user, String pass) {

		reqSpec = reqSpec.auth().preemptive().basic(user, pass);
	}

}
