package com.robot;

import java.util.ArrayList;
import java.util.List;

public class RobotADDDEL {
	private static RobotADDDEL robot = new RobotADDDEL();
	private List<ObjectADDDEL> listADDDEl = new ArrayList<>();
	private RobotADDDEL() {
		// TODO Auto-generated constructor stub
	}
	public RobotADDDEL getRobotADDDEL() {
		return robot;
	}
	public void add(ObjectADDDEL obj) {
		listADDDEl.add(obj);
	}
	public void remove() {
		listADDDEl.remove(0);
	}
	public List<ObjectADDDEL> getListADDDEl() {
		return listADDDEl;
	}
	public void setListADDDEl(List<ObjectADDDEL> listADDDEl) {
		this.listADDDEl = listADDDEl;
	}
	
}
