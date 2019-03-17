package com.Service;

import java.util.List;

public class Chat {
	private String lastId = "x";
	private static Chat chat = new Chat();
	private List<MessChat> messChats;
	private String headhtml = "<html>"
			+ "<style>"
			+ "p{line-height:0.9em"
			+ "}"
			+ ".mesblock{clear:left}"
			+ ".separator{background:#DCDCDC;border-top:2px solid #FFFFFF;border-bottom:2px solid #FFFFFF;font-size:1px;height:2px;overflow:hidden;width:100%}"
			+ ".mess{}"
			+ ".img{float:left;width:30;height:30}"
			+ "</style>"
			+ "<script language=\"javascript\" type=\"text/javascript\">"
			+ "function scroll(){window.scrollTo(0,document.body.scrollHeight);}"
			+ "</script>"
			+ "<body onload='scroll()'>";
	private String endhtml = "<body></html>";
	private String bodyhtml = "";
	private Chat() {
		// TODO Auto-generated constructor stub
	}
	public static Chat getChat() {
		return chat;
	}
	public String getLastId() {
		return lastId;
	}
	public void setLastId(String lastId) {
		this.lastId = lastId;
	}
	public List<MessChat> getMessChats() {
		return messChats;
	}
	public void setMessChats(List<MessChat> messChats) {
		this.messChats = messChats;
	}
	public String getHeadhtml() {
		return headhtml;
	}
	public void setHeadhtml(String headhtml) {
		this.headhtml = headhtml;
	}
	public String getEndhtml() {
		return endhtml;
	}
	public void setEndhtml(String endhtml) {
		this.endhtml = endhtml;
	}
	public String getBodyhtml() {
		return bodyhtml;
	}
	public void setBodyhtml(String bodyhtml) {
		this.bodyhtml = bodyhtml;
	}
}
