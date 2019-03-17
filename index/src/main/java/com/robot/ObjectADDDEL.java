package com.robot;

import com.Table.AddOrder;

public class ObjectADDDEL {
	private AddOrder addorder;
	private int delOrder;
	private int sostADDDELL;
	public ObjectADDDEL(int sostADDDELL, AddOrder addorder) {
		super();
		this.addorder = addorder;
		this.sostADDDELL = sostADDDELL;
	}
	public ObjectADDDEL(int sostADDDELL,int delOrder) {
		super();
		this.delOrder = delOrder;
		this.sostADDDELL = sostADDDELL;
	}
	public AddOrder getAddorder() {
		return addorder;
	}
	public void setAddorder(AddOrder addorder) {
		this.addorder = addorder;
	}
	public int getDelOrder() {
		return delOrder;
	}
	public void setDelOrder(int delOrder) {
		this.delOrder = delOrder;
	}
	public int getSostADDDELL() {
		return sostADDDELL;
	}
	public void setSostADDDELL(int sostADDDELL) {
		this.sostADDDELL = sostADDDELL;
	}
	
	
}
