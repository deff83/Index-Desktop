package com.Service;

public class MessChat {
	private String mess = "";
	private String nick = "";
	private String wmidmess = "";
	private String urlimg = "";
	private String datecreated = "";
	private String attestatmes = "";
	private String idmesstr = "";
	
	public MessChat(String mess, String nick, String wmidmess, String urlimg, String datecreated, String attestatmes, String idmesstr) {

		this.mess = mess;
		this.nick = nick;
		this.wmidmess = wmidmess;
		this.urlimg = urlimg;
		this.datecreated = datecreated;
		this.attestatmes = attestatmes;
		this.idmesstr = idmesstr;
	}
	public String getMess() {
		return mess;
	}
	public void setMess(String mess) {
		this.mess = mess;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getWmidmess() {
		return wmidmess;
	}
	public void setWmidmess(String wmidmess) {
		this.wmidmess = wmidmess;
	}
	public String getUrlimg() {
		return urlimg;
	}
	public void setUrlimg(String urlimg) {
		this.urlimg = urlimg;
	}
	public String getDatecreated() {
		return datecreated;
	}
	public void setDatecreated(String datecreated) {
		this.datecreated = datecreated;
	}
	public String getAttestatmes() {
		return attestatmes;
	}
	public void setAttestatmes(String attestatmes) {
		this.attestatmes = attestatmes;
	}
	public String getIdmesstr() {
		return idmesstr;
	}
	public void setIdmesstr(String idmesstr) {
		this.idmesstr = idmesstr;
	}
	
	
	
}
