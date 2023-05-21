package com.pojo.address;

public class AddUserAddress_Input_Pojo {
	
	
	 private String first_name;
	 private String last_name;
	 private String mobile;
	 private String apartment;
	 private int state;
	 private int city;
	 private int country;
	 private String zipcode;
	 private String address;
	 private String address_type;
	 
	 
	 
	 
	public AddUserAddress_Input_Pojo(String first_name, String last_name, String mobile, String apartment, int state,
			int city, int country, String zipcode, String address, String address_type) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile = mobile;
		this.apartment = apartment;
		this.state = state;
		this.city = city;
		this.country = country;
		this.zipcode = zipcode;
		this.address = address;
		this.address_type = address_type;
	}
	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}
	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the apartment
	 */
	public String getApartment() {
		return apartment;
	}
	/**
	 * @param apartment the apartment to set
	 */
	public void setApartment(String apartment) {
		this.apartment = apartment;
	}
	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(int state) {
		this.state = state;
	}
	/**
	 * @return the city
	 */
	public int getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(int city) {
		this.city = city;
	}
	/**
	 * @return the country
	 */
	public int getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(int country) {
		this.country = country;
	}
	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}
	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the address_type
	 */
	public String getAddress_type() {
		return address_type;
	}
	/**
	 * @param address_type the address_type to set
	 */
	public void setAddress_type(String address_type) {
		this.address_type = address_type;
	}
	
	

}
