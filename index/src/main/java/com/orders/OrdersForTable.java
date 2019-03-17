package com.orders;


import javafx.beans.property.*;

public class OrdersForTable {
	private StringProperty buynotes;
	private StringProperty buy;
	private StringProperty sell;
	private StringProperty sellnotes;
	public OrdersForTable(String buy, String sell, String buynotes, String sellnotes) {
		
		this.buy=new SimpleStringProperty(buy);
		this.sell=new SimpleStringProperty(sell);
		this.buynotes=new SimpleStringProperty(buynotes);
		this.sellnotes=new SimpleStringProperty(sellnotes);
	}
	public StringProperty buyProperty() {return buy;}
	public String getBuy(){ return buy.getValue(); } 
	public StringProperty sellProperty() {return sell;}
	public String getSell(){ return sell.getValue(); } 
	public StringProperty buynotesProperty() {return buynotes;}
	public String getBuyNotes(){ return buynotes.getValue(); } 
	public StringProperty sellnotesProperty() {return sellnotes;}
	public String getSellNotes(){ return sellnotes.getValue(); } 
}
