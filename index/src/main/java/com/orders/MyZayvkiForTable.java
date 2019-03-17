package com.orders;

import javafx.beans.property.*;

public class MyZayvkiForTable {
	private StringProperty name, kindstring;
	private IntegerProperty zCoin, offerId, kind, notes;
	private StringProperty price;
	public MyZayvkiForTable(int zCoin, int offerId, String name, int kind, String price,int notes) {
		// TODO Auto-generated constructor stub
		this.name = new SimpleStringProperty(name);
		this.zCoin = new SimpleIntegerProperty(zCoin);
		this.offerId = new SimpleIntegerProperty(offerId);
		this.kind = new SimpleIntegerProperty(kind);
		this.notes = new SimpleIntegerProperty(notes);
		this.price = new SimpleStringProperty(price);
		if(kind==0) {
				this.kindstring = new SimpleStringProperty("продажа");
		}
		if(kind==1) {
			this.kindstring = new SimpleStringProperty("покупка");
		}
	}
	public StringProperty kindstringProperty() {return kindstring;}
	public String getKindstring(){ return kindstring.getValue(); } 
	public StringProperty nameProperty() {return name;}
	public String getName(){ return name.getValue(); } 
	public IntegerProperty zCoinProperty() {return zCoin;}
	public Integer getZCoin(){ return zCoin.getValue(); } 
	public IntegerProperty offerIdProperty() {return offerId;}
	public Integer getOfferId(){ return offerId.getValue(); } 
	public IntegerProperty kindProperty() {return kind;}
	public Integer getKind(){ return kind.getValue(); } 
	public IntegerProperty notesProperty() {return notes;}
	public Integer getNotes(){ return notes.getValue(); } 
	public StringProperty priceProperty() {return price;}
	public String getPrice(){ return price.getValue(); } 
}
