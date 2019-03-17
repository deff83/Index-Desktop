package com.Service;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.Table.AddOrder;
import com.Table.Sostin;
import com.Table.stage.StageBuy;
import com.Table.stage.StageSell;
import com.getpost.GETPOST;
import com.getpost.Opiration;
import com.orders.CoinTool;
import com.orders.MyHistoryTrade;
import com.orders.MyZayvkiForTable;
import com.orders.OrdersForTable;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.layout.FlowPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ServicePOST implements Runnable {
	private AudioClip audio=new AudioClip(this.getClass().getResource("audio.wav").toString());
	private int circleindication = 0;
	private FlowPane flpanelistCoin;
	private Circle circle;
	private Label infoAPI;
	private Label balancelabel;
	
	private GETPOST getpost = GETPOST.getInstanceGETPOST();
	
	private ObservableList<OrdersForTable> obslist; //прайс лист в таблице купить продать
	private TableView<OrdersForTable> tableview;
	private ObservableList<MyZayvkiForTable> obslistmyOrder; //таблица мои ордера
	private TableView<MyZayvkiForTable> tableMyZayvki;
	private Label seccsefull;
	
	private Label priceBuy = new Label(""), priceSell=new Label(""), priceTek=new Label("");
	private PieChart chart;
	private Label infoschetAPI;
	private TableView<MyHistoryTrade> myHistoryTrading;

	
	
	
	
	public ServicePOST(Circle circle, TableView<OrdersForTable> tableview, ObservableList<OrdersForTable> obslist, FlowPane flpanelistCoin, Label infoAPI, Label balance, TableView<MyZayvkiForTable> tableMyZayvki, Label seccsefull, PieChart chart, Label infoschetAPI, TableView<MyHistoryTrade> tableHistoryTrading) {
		this.flpanelistCoin = flpanelistCoin;
		this.circle = circle;
		this.tableview = tableview;
		this.obslist = obslist;
		this.infoAPI = infoAPI;
		this.balancelabel = balance;
		this.tableMyZayvki = tableMyZayvki;
		this.seccsefull = seccsefull;
		this.chart = chart;
		this.infoschetAPI = infoschetAPI;
		this.myHistoryTrading = tableHistoryTrading;
	}
	
	public Label getPriceBuy() {
		return priceBuy;
	}

	public void setPriceBuy(Label priceBuy) {
		this.priceBuy = priceBuy;
	}


	public Label getPriceSell() {
		return priceSell;
	}

	public void setPriceSell(Label priceSell) {
		this.priceSell = priceSell;
	}

	public Label getPriceTek() {
		return priceTek;
	}

	public void setPriceTek(Label priceTek) {
		this.priceTek = priceTek;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Opiration opirat = Opiration.getOpiration();
		opirat.setInfoschetAPI(infoschetAPI);
		// прайс лист
		Sostin.getSostin().setChoiseclick(false);
		circle.setFill(Color.RED);
		Platform.runLater(()->{infoAPI.setText("OfferList");});
		List<OrdersForTable> listtable = getpost.getListOrders(Sostin.getSostin().getzCoinMain(),Sostin.getSostin().getSizeTable());
		if(listtable!=null) {
		obslist = FXCollections.observableArrayList(listtable);//zCoin, colOffer
		tableview.setItems(obslist);
		Platform.runLater(()->{
			
				
			Double pricetableBuy = 0.0;
				try {
					pricetableBuy = Double.parseDouble(listtable.get(0).getBuy());
					
				}catch(Exception e) {
					try {
						StringBuilder sb = new StringBuilder(listtable.get(0).getBuy());
						String sbpod = sb.substring(2);
						pricetableBuy = Double.parseDouble(sbpod.toString());
						
					}catch(Exception ex) {
					//ex.printStackTrace();
					}
				}
				Double pricetableSell = 0.0;
				try {
					pricetableSell = Double.parseDouble(listtable.get(0).getSell());
					
				}catch(Exception e) {
					try {
						StringBuilder sb = new StringBuilder(listtable.get(0).getSell());
						String sbpod = sb.substring(2);
						pricetableSell = Double.parseDouble(sbpod.toString());
						
					}catch(Exception ex) {
					//ex.printStackTrace();
					}
				}
				Double pricetableBuyOLD = 0.0;
				try {
					pricetableBuyOLD = Double.parseDouble(priceBuy.getText());
					if(pricetableBuyOLD<pricetableBuy) {
					priceBuy.setTextFill(Color.LIGHTGREEN);
					}
					if(pricetableBuyOLD>pricetableBuy) {
						priceBuy.setTextFill(Color.RED);
					}
				}catch(Exception e) {
					try {
						StringBuilder sb = new StringBuilder(priceBuy.getText());
						String sbpod = sb.substring(2);
						pricetableBuyOLD = Double.parseDouble(sbpod.toString());
						if(pricetableBuyOLD<pricetableBuy) {
							priceBuy.setTextFill(Color.LIGHTGREEN);
							}
							if(pricetableBuyOLD>pricetableBuy) {
								priceBuy.setTextFill(Color.RED);
							}
					}catch(Exception ex) {
					//ex.printStackTrace();
					}
				}
				Double pricetableSellOLD = 0.0;
				try {
					pricetableSellOLD = Double.parseDouble(priceSell.getText());
					if(pricetableSellOLD<pricetableSell) {
						priceSell.setTextFill(Color.LIGHTGREEN);
						}
						if(pricetableSellOLD>pricetableSell) {
							priceSell.setTextFill(Color.RED);
						}
				}catch(Exception e) {
					try {
						StringBuilder sb = new StringBuilder(priceSell.getText());
						String sbpod = sb.substring(2);
						pricetableSellOLD = Double.parseDouble(sbpod.toString());
						if(pricetableSellOLD<pricetableSell) {
							priceSell.setTextFill(Color.LIGHTGREEN);
							}
							if(pricetableSellOLD>pricetableSell) {
								priceSell.setTextFill(Color.RED);
							}
					}catch(Exception ex) {
					//ex.printStackTrace();
					}
				}
				
			
			priceBuy.setText(listtable.get(0).getBuy());
			priceSell.setText(listtable.get(0).getSell());
		});
		}
		// список мои заявки
		
		circle.setFill(Color.BLUE);
		Platform.runLater(()->{infoAPI.setText("MyOffer");});
		List<MyZayvkiForTable> myOrderOLD = Sostin.getSostin().getMyOrderList(); 
		List<MyZayvkiForTable> myOrder = opirat.myOrders();
		if(myOrder!=null) {
		obslistmyOrder = FXCollections.observableArrayList(myOrder);//zCoin, colOffer
		tableMyZayvki.setItems(obslistmyOrder);
		int myOrderOLDint = 0;
		if(myOrderOLD!=null) {myOrderOLDint=myOrderOLD.size();}
		if(myOrderOLDint!=myOrder.size()) {
			
					// TODO Auto-generated method stub
					audio.play();
				
			
			
			}
		}
		
		//туулбар
		circle.setFill(Color.GREEN);
		Platform.runLater(()->{infoAPI.setText("Tools");});
		List<CoinTool> coinToolsOLD = Sostin.getSostin().getCoinTools();
		List<CoinTool> coinTools = opirat.getCoinTools();
		if(coinTools!=null) {
		Platform.runLater(()->{flpanelistCoin.getChildren().clear();});
		
		
		for(int i = 0; i<coinTools.size(); i++) {
			int zCoinp = coinTools.get(i).getId();
			
			String name = coinTools.get(i).getName();
			String price = coinTools.get(i).getPrice();
			String priceOLD = coinToolsOLD.get(i).getPrice();
			Label lab = new Label(name+":"+price);
			
			if(Double.parseDouble(price)>Double.parseDouble(priceOLD)) {
				lab.setStyle("-fx-text-fill:#00ff00;");
			}
			if(Double.parseDouble(price)<Double.parseDouble(priceOLD)) {
				lab.setStyle("-fx-text-fill:#ff0000;");
			}
			Platform.runLater(()->{flpanelistCoin.getChildren().add(lab);});
		}
		Platform.runLater(()->{
			Double pricetableTekOLD = 0.0;
			int zCoin = Sostin.getSostin().getzCoinMain();
			int texSpisok = 0;
			for(int i = 0; i<coinTools.size(); i++) {
				int zCoinp = coinTools.get(i).getId();
				if(zCoinp==zCoin)texSpisok=i;
			}
			String price = coinTools.get(texSpisok).getPrice();
			try {
				pricetableTekOLD = Double.parseDouble(priceTek.getText());
				if(pricetableTekOLD<Double.parseDouble(price)) {
					priceTek.setTextFill(Color.LIGHTGREEN);
				}
				if(pricetableTekOLD>Double.parseDouble(price)) {
					priceTek.setTextFill(Color.RED);
				}
			}catch(Exception e) {
				try {
					StringBuilder sb = new StringBuilder(priceTek.getText());
					String sbpod = sb.substring(2);
					pricetableTekOLD = Double.parseDouble(sbpod.toString());
					if(pricetableTekOLD<Double.parseDouble(price)) {
						priceTek.setTextFill(Color.LIGHTGREEN);
						}
						if(pricetableTekOLD>Double.parseDouble(price)) {
							priceTek.setTextFill(Color.RED);
						}
				}catch(Exception ex) {
				//ex.printStackTrace();
				}
			}
			priceTek.setText(price);
		});
		}
		//баланс
		circle.setFill(Color.YELLOW);
		Platform.runLater(()->{infoAPI.setText("Balance");});
		String balance = opirat.balance();
		if(balance!=null) {
			Platform.runLater(()->{
			List<PieChart.Data> listDataMyCoin = Sostin.getSostin().getMyCoinDiagram();
			ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(listDataMyCoin);
			chart.setData(pieChartData);
			balancelabel.setText(Sostin.getSostin().getBalance().toString()+"$("+Sostin.getSostin().getSvobbalance().toString()+")");});
		}
		Platform.runLater(()->{seccsefull.setText("");});
		//мои сделки
		circle.setFill(Color.BLUEVIOLET);
		Platform.runLater(()->{infoAPI.setText("HistoryTrade");});
		LocalDate datenow = LocalDate.now();
		LocalDate dateMesOldnow = LocalDate.now().minusMonths(1);
		String DateEnd = datenow.format(DateTimeFormatter.ofPattern("uuuuMMdd"));
		String DateStart = dateMesOldnow.format(DateTimeFormatter.ofPattern("uuuuMMdd"));
		List<MyHistoryTrade> mySdelky = opirat.getHistoryTrading(Sostin.getSostin().getzCoinMain(),DateStart,DateEnd);
		if (mySdelky!=null) {
			ObservableList<MyHistoryTrade> MyHistoryTradeObser = FXCollections.observableArrayList(mySdelky);
			myHistoryTrading.setItems(MyHistoryTradeObser);
		}
		
		//заявка на удаление ордера
		if(Sostin.getSostin().isBooldelOrder()) {
			circle.setFill(Color.WHITE);
			Platform.runLater(()->{infoAPI.setText("DEL Order");});
			String dellorder = opirat.delOrder(Sostin.getSostin().getDelOrder());
			Sostin.getSostin().setBooldelOrder(false);
			if(Sostin.getSostin().isRedaction()) {
				
				Sostin.getSostin().setBoolAddOrder(true);
				Sostin.getSostin().setRedaction(false);
			}
			if(Sostin.getSostin().isStartOrder()) {
				Sostin.getSostin().setStartOrder(false);
				Platform.runLater(()->{
					MyZayvkiForTable myzv = tableMyZayvki.getSelectionModel().getSelectedItem();
					if(myzv.getKind() == 1) {
						StageBuy popupr = new StageBuy(Sostin.getSostin().getzCoinMain());
						String price = "0";
						try {
							Double pricetable = Double.parseDouble(myzv.getPrice())+0.0002;
							price = String.format(Locale.US, "%.4f", pricetable);
						}catch(Exception e) {
							try {
								StringBuilder sb = new StringBuilder(myzv.getPrice());
								String sbpod = sb.substring(2);
								Double pricetable = Double.parseDouble(sbpod.toString())+0.0002;
								price = String.format(Locale.US, "%.4f", pricetable);
							}catch(Exception ex) {
							ex.printStackTrace();
							}
						}
						popupr.setPrice(price);
						popupr.setNotes("1");
						popupr.show();
					}
					if(myzv.getKind() == 0) {
						StageSell popup = new StageSell(Sostin.getSostin().getzCoinMain());
						String price= "999";
						try {
							Double pricetable = Double.parseDouble(myzv.getPrice())-0.0002;
							price = String.format(Locale.US, "%.4f", pricetable);
						}catch(Exception e) {
							try {
								StringBuilder sb = new StringBuilder(myzv.getPrice());
								String sbpod = sb.substring(2);
								Double pricetable = Double.parseDouble(sbpod.toString())-0.0002;
								price = String.format(Locale.US, "%.4f", pricetable);
							}catch(Exception ex) {
							ex.printStackTrace();
							}
						}
						popup.setPrice(price);
						popup.setNotes(myzv.getNotes().toString());
						popup.show();
					}
				});
				
				
			}
			Platform.runLater(()->{seccsefull.setText(dellorder);});
		}
		//заявка на добавление ордера
				if(Sostin.getSostin().isBoolAddOrder()) {
					circle.setFill(Color.BLACK);
					Platform.runLater(()->{infoAPI.setText("ADD Order");});
					AddOrder addordersostin = Sostin.getSostin().getOrderadd();
					String addorder = opirat.addOrder(addordersostin.getIsbid(), addordersostin.getzCoinadd(), addordersostin.getPrice_dialog(), addordersostin.getNotes_dialog());
					Sostin.getSostin().setBoolAddOrder(false);
					Platform.runLater(()->{seccsefull.setText(addorder);});
		}
		switch(circleindication) {
		case 0:
			
			
			circleindication=1;
			break;
		case 1:				
			
			
			circleindication=0;
			
		}
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}*/
	
	}
	

}
