package com.Table;

import com.getpost.Opiration;

public class User {
	private static User user = new User();
	private String initialisationfile;
	private String login, wmid, password, culture;
	
	private User() {
		// TODO Auto-generated constructor stub
	}
	public static User getUser() {
		return user;
	}
	public void setUser(String login, String wmid, String password, String culture) {
		this.login = login;
		this.wmid = wmid;
		this.password = password;
		this.culture = culture;
		Opiration.getOpiration().inicialisation(login, wmid, password, culture);
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getWmid() {
		return wmid;
	}
	public void setWmid(String wmid) {
		this.wmid = wmid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCulture() {
		return culture;
	}
	public void setCulture(String culture) {
		this.culture = culture;
	}
	public String getInitialisationfile() {
		return initialisationfile;
	}
	public void setInitialisationfile(String initialisationfile) {
		this.initialisationfile = initialisationfile;
	}
	

}
