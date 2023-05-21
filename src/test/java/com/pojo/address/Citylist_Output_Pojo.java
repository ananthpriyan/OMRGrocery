package com.pojo.address;

import java.util.ArrayList;

public class Citylist_Output_Pojo {

	private int status;
	private String message;
	private ArrayList<CityList> data;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ArrayList<CityList> getData() {
		return data;
	}

	public void setData(ArrayList<CityList> data) {
		this.data = data;
	}

	public static class CityList {
		private int id;
		private String name;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

}
