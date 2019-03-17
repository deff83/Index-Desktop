package com.Service;

public class APIString {
	private static APIString apistring = new APIString();
	private APIString() {
		// TODO Auto-generated constructor stub
	}
	public static APIString getAPIString() {
		return apistring;
	}
	//поля ответов
	private String offerList;
	public String getOfferList() {
		return offerList;
	}
	public void setOfferList(String offerList) {
		this.offerList = offerList;
	}
	
	
	
}
