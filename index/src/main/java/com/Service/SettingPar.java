package com.Service;

import java.util.List;

import javafx.scene.control.CheckBox;

public class SettingPar {
	private static SettingPar setpar = new SettingPar();
	
	private boolean OfferList = true;
	private boolean MyOffer = true;
	private boolean Tool = true;
	private boolean Balance = true;
	private boolean HistoryTrade = true;
	private int chastot = 2;
	private SettingPar() {
		// TODO Auto-generated constructor stub
	}
	public static SettingPar getSettingPar() {
		return setpar;
	}
	
	public boolean isOfferList() {
		return OfferList;
	}
	public void setOfferList(boolean offerList) {
		OfferList = offerList;
	}
	public boolean isMyOffer() {
		return MyOffer;
	}
	public void setMyOffer(boolean myOffer) {
		MyOffer = myOffer;
	}
	public boolean isTool() {
		return Tool;
	}
	public void setTool(boolean tool) {
		Tool = tool;
	}
	public boolean isBalance() {
		return Balance;
	}
	public void setBalance(boolean balance) {
		Balance = balance;
	}
	public boolean isHistoryTrade() {
		return HistoryTrade;
	}
	public void setHistoryTrade(boolean historyTrade) {
		HistoryTrade = historyTrade;
	}
	public int getChastot() {
		return chastot;
	}
	public void setChastot(int chastot) {
		this.chastot = chastot;
	}
	public void setBool(boolean OfferList,boolean MyOffer,boolean Tool,boolean Balance,boolean HistoryTrade) {
		this.OfferList = OfferList;
		this.MyOffer = MyOffer;
		this.Tool = Tool;
		this.Balance = Balance;
		this.HistoryTrade = HistoryTrade;
	}

	
}
