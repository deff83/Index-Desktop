package com.Table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.orders.CoinTool;
import com.orders.MyZayvkiForTable;
import com.orders.OrdersForTable;

import javafx.scene.chart.PieChart;

public class Sostin {
	private static Sostin sost = new Sostin();
	private int zCoinMain;
	private int sizeTable;
	private List<CoinTool> coinTools;
	private Map<Integer,CoinTool> mapIdCointools;
	private Double balance;
	private Double svobbalance;
	private boolean booladdOrder = false;
	private AddOrder addOrder;
	private boolean booldelOrder = false;
	private int delOrder;
	private boolean choiseclick = false;
	private boolean redaction = false;
	private boolean startOrder = false; //вызывать окно покупки продажи
	private List<MyZayvkiForTable> myOrderList;
	private List<OrdersForTable> priceList;
	private List<PieChart.Data> myCoinDiagram;
	private boolean propusk = false;
	
	private Sostin() {
		zCoinMain = 60;
		sizeTable = 20;
		// TODO Auto-generated constructor stub
	}
	public static Sostin getSostin() {
		return sost;
	}
	public int getzCoinMain() {
		return zCoinMain;
	}
	public void setzCoinMain(int zCoinMain) {
		this.zCoinMain = zCoinMain;
	}
	public List<CoinTool> getCoinTools() {
		
		return coinTools;
	}
	public void setCoinTools(List<CoinTool> coinTools) {
		this.coinTools = coinTools;
		mapIdCointools = new HashMap<>();
		for(int i = 0; i<coinTools.size(); i++) {
			mapIdCointools.put(coinTools.get(i).getId(), coinTools.get(i));
		}
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public boolean isBoolAddOrder() {
		return booladdOrder;
	}
	public void setBoolAddOrder(boolean addOrder) {
		this.booladdOrder = addOrder;
	}
	public AddOrder getOrderadd() {
		return addOrder;
	}
	public void setOrderadd(AddOrder orderadd) {
		this.addOrder = orderadd;
	}
	public Map<Integer, CoinTool> getMapIdCointools() {
		return mapIdCointools;
	}
	public void setMapIdCointools(Map<Integer, CoinTool> mapIdCointools) {
		this.mapIdCointools = mapIdCointools;
	}
	public boolean isBooldelOrder() {
		return booldelOrder;
	}
	public void setBooldelOrder(boolean booldelOrder) {
		this.booldelOrder = booldelOrder;
	}
	public int getDelOrder() {
		return delOrder;
	}
	public void setDelOrder(int delOrder) {
		this.delOrder = delOrder;
	}
	public Double getSvobbalance() {
		return svobbalance;
	}
	public void setSvobbalance(Double svobbalance) {
		this.svobbalance = svobbalance;
	}
	public boolean isChoiseclick() {
		return choiseclick;
	}
	public void setChoiseclick(boolean choiseclick) {
		this.choiseclick = choiseclick;
	}
	public List<MyZayvkiForTable> getMyOrderList() {
		return myOrderList;
	}
	public void setMyOrderList(List<MyZayvkiForTable> myOrderList) {
		this.myOrderList = myOrderList;
	}
	public int getSizeTable() {
		return sizeTable;
	}
	public void setSizeTable(int sizeTable) {
		this.sizeTable = sizeTable;
	}
	public boolean isRedaction() {
		return redaction;
	}
	public void setRedaction(boolean redaction) {
		this.redaction = redaction;
	}
	public List<OrdersForTable> getPriceList() {
		return priceList;
	}
	public void setPriceList(List<OrdersForTable> priceList) {
		this.priceList = priceList;
	}
	public boolean isStartOrder() {
		return startOrder;
	}
	public void setStartOrder(boolean startOrder) {
		this.startOrder = startOrder;
	}
	public List<PieChart.Data> getMyCoinDiagram() {
		return myCoinDiagram;
	}
	public void setMyCoinDiagram(List<PieChart.Data> myCoinDiagram) {
		this.myCoinDiagram = myCoinDiagram;
	}
	public boolean isPropusk() {
		return propusk;
	}
	public void setPropusk(boolean propusk) {
		this.propusk = propusk;
	}
	
	
}
