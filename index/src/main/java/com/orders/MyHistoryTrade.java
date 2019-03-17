package com.orders;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MyHistoryTrade {
	private IntegerProperty id,isbid,notes;
	private StringProperty stamp;
	private StringProperty name;
	private DoubleProperty price;
	private StringProperty isbidstr;

	public MyHistoryTrade(int id, int isbid, int notes, String stamp, String name, Double price) {

		this.id = new SimpleIntegerProperty(id);
		this.isbid = new SimpleIntegerProperty(isbid);
		this.notes = new SimpleIntegerProperty(notes);
		this.stamp = new SimpleStringProperty(stamp);
		this.name = new SimpleStringProperty(name);
		this.price = new SimpleDoubleProperty(price);
		if (isbid == 1) this.isbidstr = new SimpleStringProperty("покупка");
		if (isbid == 0) this.isbidstr = new SimpleStringProperty("продажа");
	}
	
	public IntegerProperty idProperty() {return id;}
	public Integer getId(){ return id.getValue(); } 
	
	public IntegerProperty isbidProperty() {return isbid;}
	public Integer getIsbid(){ return isbid.getValue(); } 
	
	public IntegerProperty notesProperty() {return notes;}
	public Integer getNotes(){ return notes.getValue(); } 
	
	public StringProperty stampProperty() {return stamp;}
	public String getStamp(){ return stamp.getValue(); } 
	public StringProperty nameProperty() {return name;}
	public String getName(){ return name.getValue(); } 
	public DoubleProperty priceProperty() {return price;}
	public Double getPrice(){ return price.getValue(); } 
	public StringProperty isbidstrProperty() {return isbidstr;}
	public String getIsbidstr(){ return isbidstr.getValue(); } 
	
	
}
