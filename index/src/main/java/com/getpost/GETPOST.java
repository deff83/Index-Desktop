package com.getpost;

import java.util.ArrayList;
import java.util.List;

import com.Table.Sostin;
import com.orders.OrderPrice;
import com.orders.OrdersForTable;
import com.orders.OrdersPriceList;

public class GETPOST {
	private static GETPOST getpost = new GETPOST();
	private List<OrderPrice> listbuy;//левая колонка
	private List<OrderPrice> listsell;//левая колонка
	private GETPOST() {
		listbuy = new ArrayList<>();
		listsell = new ArrayList<>();
		// начальная инициализация полей листов прайс листа
	}
	public static GETPOST getInstanceGETPOST() {
		return getpost;
	}

	
	public List<OrdersForTable> getListOrders(int zCoin,int colOffer){
		Opiration o = Opiration.getOpiration();
		OrdersPriceList ordPriceList = o.getOfferList(zCoin, colOffer);
		if(ordPriceList==null) {return null;};
		List<OrdersForTable> orders = new ArrayList<>();
		List<OrderPrice> buy, sell;
		buy = ordPriceList.getListbuy();
		sell = ordPriceList.getListsell();
		OrdersForTable ordersForTable;
		
		for(int i = 0; i<colOffer; i++) {
			String buystring = "",sellstring = "";
			String buynotesstring = "",sellnotesstring = "";
			if(i<buy.size()) {
				buystring = buy.get(i).getPrice().toString();
				buynotesstring =String.valueOf(buy.get(i).getNotes());
				int myOrder = buy.get(i).getOfferid();
				if(myOrder!=0) buystring = "+ "+buystring;
			}
			if(i<sell.size()) {
				sellstring = sell.get(i).getPrice().toString();
				sellnotesstring =String.valueOf(sell.get(i).getNotes());
				int myOrder = sell.get(i).getOfferid();
				if(myOrder!=0) sellstring = "+ "+sellstring;
			}
			ordersForTable = new OrdersForTable(buystring, sellstring, buynotesstring,sellnotesstring);
			orders.add(ordersForTable);
		}
		Sostin.getSostin().setPriceList(orders);
		return orders;
		
	}
	public List<OrdersForTable> getListOrdersSell(){
		
		return null;
		
	}
	public List<OrdersForTable> getListOrdersBuy(){
		
		return null;
		
	}
	public boolean  getOfferList(int colOffer) {//colOffer - количество заявок в таблице
		
		return true;
		
	}
}
