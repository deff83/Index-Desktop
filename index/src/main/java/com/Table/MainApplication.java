package com.Table;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.Service.ChatService;
import com.Service.ServicePOST;
import com.Service.SettingPar;
import com.Service.WebSite;
import com.Table.stage.DownLoadStage;
import com.Table.stage.MinStage;
import com.Table.stage.Setting;
import com.Table.stage.StageBot;
import com.Table.stage.StageBuy;
import com.Table.stage.StageInfo;
import com.Table.stage.StageSell;
import com.getpost.GETPOST;
import com.getpost.Opiration;
import com.orders.CoinTool;
import com.orders.MyHistoryTrade;
import com.orders.MyZayvkiForTable;
import com.orders.OrdersForTable;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.*;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;

public class MainApplication extends Application {
	


	private Label labelniz = new Label();
	private ScheduledExecutorService executor;

	
	private Circle circle;
	private int circleindication = 0;//состояние индикации
	private ObservableList<OrdersForTable> obslist; //прайс лист в таблице купить продать

	private TableColumn buycolumn;
	private int ipoi = 0;
	
	private ServicePOST timertask;
	private DownLoadStage downloadstage;
	public MainApplication() {
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		downloadstage = new DownLoadStage("Загрузка");
		downloadstage.show();
		//Stage stagebot = new StageBot();
		//stagebot.show();
		
		
		//stage.setAlwaysOnTop(true);
		stage.setTitle("Indx.ru");
		TableView<OrdersForTable> tableview = new TableView<>();//таблица
			
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			
			public void handle(WindowEvent arg0) {
				// TODO Auto-generated method stub
				Stage closestage = new Stage();
				BorderPane bpclose = new BorderPane();
				
				Scene scenebuy = new Scene(bpclose, 305,120);
				closestage.setScene(scenebuy);
				closestage.setResizable(false);
				FlowPane flpaneExit = new FlowPane(5,5);
				bpclose.setMargin(flpaneExit, new Insets(5,0,0,5));
				
				bpclose.setStyle("-fx-background-color:#ffeeee;");
				FlowPane flpaneExitVverch = new FlowPane(5,5);
				Label labelvverExit = new Label("Выход");
				InnerShadow is = new InnerShadow();
				flpaneExitVverch.setStyle("-fx-background-color:#ffffff;");
				flpaneExitVverch.setAlignment(Pos.CENTER);
				flpaneExitVverch.setPrefHeight(45);
				Reflection effect=new Reflection();
				effect.setBottomOpacity(0.0);
				effect.setTopOffset(-44.0);
				effect.setTopOpacity(0.7);
				effect.setInput(is);
				labelvverExit.setEffect(effect);
				labelvverExit.setFont(Font.font("Arial", FontWeight.BOLD,
						FontPosture.ITALIC, 20));
				Label labelexit = new Label("Остановить сервис?");
				labelexit.setPrefWidth(300);
				FlowPane flpaneExitNiz = new FlowPane(5,5);
				bpclose.setMargin(flpaneExitNiz, new Insets(5,0,5,5));
				Button buttonExitNo = new Button("Cancel");
				buttonExitNo.setPrefWidth(150);
				buttonExitNo.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						// TODO Auto-generated method stub
						closestage.close();
					}
					
				});
				Button buttonExitYes = new Button("Ок");
				buttonExitYes.setPrefWidth(150);
				buttonExitYes.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						// TODO Auto-generated method stub
						if (executor!=null) {
							executor.shutdownNow();
						}
						closestage.close();
						System.exit(0);
					}
					
				});
				flpaneExit.getChildren().addAll(labelexit);
				flpaneExitVverch.getChildren().add(labelvverExit);
				flpaneExitNiz.getChildren().addAll(buttonExitNo,buttonExitYes);
				bpclose.setTop(flpaneExitVverch);
				bpclose.setCenter(flpaneExit);
				bpclose.setBottom(flpaneExitNiz);
				closestage.show();
				System.out.println("CLOSE");
			}
		});
		//stage.setResizable(false);
		BorderPane bp = new BorderPane();
		Scene scene = new Scene(bp, 960,550);
		stage.setScene(scene);
		//верхняя главная панель
		Group fpvvvse = new Group();
		//fpvvvse.setOrientation(Orientation.VERTICAL);
		//fpvvvse.setMaxHeight(75);
		FlowPane fpvv = new FlowPane(20,2);
		fpvv.setMinHeight(60);
		fpvv.setMinWidth(960);
		fpvv.setAlignment(Pos.CENTER);
		fpvv.setStyle("-fx-background-color:#ffffff;");
		Label labelvver = new Label("INDX.RU  (DEFF83) v1");
		InnerShadow is = new InnerShadow();
		
		Reflection effect=new Reflection();
		effect.setBottomOpacity(0.0);
		effect.setTopOffset(-44.0);
		effect.setTopOpacity(0.7);
		effect.setInput(is);
		labelvver.setEffect(effect);
		labelvver.setFont(Font.font("Arial", FontWeight.BOLD,
				FontPosture.ITALIC, 20));
		fpvv.getChildren().add(labelvver);
		//МЕНЮ
		MenuBar menubar = new MenuBar();
		menubar.setLayoutY(60);
		menubar.setMinWidth(960);
		Menu menu = new Menu("File");
		Menu menuhelp = new Menu("Help");
		
		MenuItem menuitemDeff83 = new MenuItem("О программе");
		
		
		MenuItem menuitemBot = new MenuItem("Bot");
		MenuItem menuitemMinimiz = new MenuItem("Минимальное окно");
		MenuItem menuitemSetting = new MenuItem("Настройки");
		
		SeparatorMenuItem separatorFile = new SeparatorMenuItem();
		MenuItem menuitemExit = new MenuItem("Выход с учетной записи");
		EventHandler eventhandlermenu = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getSource().equals(menuitemBot)) {
					Stage popup = new StageBot();
					
					popup.show();
					
					
				}
				if(arg0.getSource().equals(menuitemMinimiz)) {
					SettingPar.getSettingPar().setBool(true, true, true, false, false);
					
					MinStage minstage = new MinStage(scene, stage, timertask);
					Sostin.getSostin().setChoiseclick(true);
					
					
				}
				if(arg0.getSource().equals(menuitemSetting)) {
					System.out.println(arg0.getSource().toString());
					Stage setting = new Setting();
					setting.show();
				}
				
				if(arg0.getSource().equals(menuitemExit)) {
				System.out.println(arg0.getSource().toString());
				
				try {
					File fileinit = new File("init.txt");
					
					System.out.println(fileinit.delete());
					}
					catch(Exception e){
						e.printStackTrace();
					}
					executor.shutdownNow();
					stage.close();
					LoginApplication la = new LoginApplication();
					try {
						la.start(new Stage());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				};
				if(arg0.getSource().equals(menuitemDeff83)) {
					
					StageInfo stageInfo = new StageInfo();
					stageInfo.show();
				}
			}
			
		};
		menuitemExit.setOnAction(eventhandlermenu);
		menuitemSetting.setOnAction(eventhandlermenu);
		menuitemMinimiz.setOnAction(eventhandlermenu);
		menuitemDeff83.setOnAction(eventhandlermenu);
		
		menu.getItems().addAll(menuitemMinimiz,menuitemBot,menuitemSetting,separatorFile,menuitemExit);
		menuhelp.getItems().addAll(menuitemDeff83);
		menubar.getMenus().addAll(menu, menuhelp);
		fpvvvse.getChildren().addAll( fpvv,menubar);
		bp.setTop(fpvvvse);
		bp.setAlignment(fpvvvse, Pos.CENTER);
		//центральная главная панель
		Group groupcenter = new Group();
		
		ChoiceBox<String> choice = new ChoiceBox<String>();
		
		FlowPane fpvertcenterflp = new FlowPane(0,2);
		
		//fpvertcenter.setPrefWidth(700);
		FlowPane fp = new FlowPane(20,2); //отступы компонентов
		fp.setOrientation(Orientation.HORIZONTAL);
		//fp.setStyle("-fx-background-color:#dddddd;");
		fp.setMinWidth(960);
		
			////левая панель
		BorderPane fpleft = new BorderPane();
		
		Label label = new Label("Таблица цен");//текст над таблицей
		
		fp.setMargin(fpleft, new Insets(5,0,0,5));
		GETPOST getpost = GETPOST.getInstanceGETPOST();
		
		
		
		tableview.setPrefSize(250, 350);
		tableview.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		Label downl = new Label("Ждите...");
		tableview.setPlaceholder(downl);
		buycolumn = new TableColumn("Цена \r\n продажи");
		buycolumn.setCellValueFactory(new PropertyValueFactory<OrdersForTable, String>("buy"));
		buycolumn.setSortable(false);
		buycolumn.setResizable(false);
		//buycolumn.setMinWidth(100);
		TableColumn sellcolumn = new TableColumn("Цена \r\n покупки");
		sellcolumn.setCellValueFactory(new PropertyValueFactory<OrdersForTable, String>("sell"));
		sellcolumn.setSortable(false);
		sellcolumn.setResizable(false);
		//sellcolumn.setMinWidth(100);
		TableColumn buynotescolumn = new TableColumn("Нот");
		buynotescolumn.setCellValueFactory(new PropertyValueFactory<OrdersForTable, String>("buynotes"));
		buynotescolumn.setSortable(false);
		buynotescolumn.setResizable(false);
		buynotescolumn.setMaxWidth(40);
		TableColumn sellnotescolumn = new TableColumn("Нот");
		sellnotescolumn.setCellValueFactory(new PropertyValueFactory<OrdersForTable, String>("sellnotes"));
		sellnotescolumn.setSortable(false);
		sellnotescolumn.setResizable(false);
		sellnotescolumn.setMaxWidth(40);
		tableview.setEditable(true);
		tableview.getColumns().addAll(buynotescolumn,buycolumn,sellnotescolumn,sellcolumn);
		ContextMenu contextMenuListOrder = new ContextMenu();
		MenuItem menuItemBuy = new MenuItem("Купить");
		MenuItem menuItemSell = new MenuItem("Продать");
		contextMenuListOrder.getItems().addAll(menuItemBuy,menuItemSell);
		
		EventHandler<ActionEvent> eventMenuContextList = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
				OrdersForTable myzv = tableview.getSelectionModel().getSelectedItem();
				if(myzv!=null) {
					
					
					if(event.getSource().equals(menuItemBuy)) {
						StageBuy popupr = new StageBuy(Sostin.getSostin().getzCoinMain());
						String price = "0";
						try {
							Double pricetable = Double.parseDouble(myzv.getBuy())+0.0001;
							price = String.format(Locale.US, "%.4f", pricetable);
						}catch(Exception e) {
							try {
								StringBuilder sb = new StringBuilder(myzv.getBuy());
								String sbpod = sb.substring(2);
								Double pricetable = Double.parseDouble(sbpod.toString())+0.0001;
								price = String.format(Locale.US, "%.4f", pricetable);
							}catch(Exception ex) {
							ex.printStackTrace();
							}
						}
						popupr.setPrice(price);
						popupr.setNotes("1");
						popupr.show();
					}
					if(event.getSource().equals(menuItemSell)) {
						StageSell popup = new StageSell(Sostin.getSostin().getzCoinMain());
						String price = "999";
						try {
							Double pricetable = Double.parseDouble(myzv.getSell())-0.0001;
							price = String.format(Locale.US, "%.4f", pricetable);
						}catch(Exception e) {
							try {
								StringBuilder sb = new StringBuilder(myzv.getSell());
								String sbpod = sb.substring(2);
								Double pricetable = Double.parseDouble(sbpod.toString())-0.0001;
								price = String.format(Locale.US, "%.4f", pricetable);
							}catch(Exception ex) {
							ex.printStackTrace();
							}
						}
						popup.setPrice(price);
						popup.setNotes("1");
						popup.show();
					}
					
				}
			}
			
		};
		menuItemBuy.setOnAction(eventMenuContextList);
		menuItemSell.setOnAction(eventMenuContextList);
		tableview.setContextMenu(contextMenuListOrder);
		
		FlowPane fpbuttonsellbuy = new FlowPane();
		fpbuttonsellbuy.setMaxWidth(250);
		Button buttonbuy = new Button("Купить");
		buttonbuy.setPrefWidth(fpbuttonsellbuy.getMaxWidth()/2);
		
		buttonbuy.setStyle("-fx-background-color:#ffcccc;-fx-border-width: 1px;-fx-border-color: #660066;-fx-border-radius: 7;");
		Button buttonsell = new Button("Продать");
		buttonsell.setPrefWidth(fpbuttonsellbuy.getMaxWidth()/2);
		buttonsell.setStyle("-fx-background-color:#ccffcc;-fx-border-width: 1px;-fx-border-color: #006666;-fx-border-radius: 7;");
		fpbuttonsellbuy.getChildren().addAll(buttonbuy, buttonsell);
		fpleft.setTop(label);
		fpleft.setCenter(tableview);
		fpleft.setBottom(fpbuttonsellbuy);//добавление компонентов в левую панель
			
			//правая панель
		Group groupleftcenter = new Group();
		//fpright.setOrientation(Orientation.VERTICAL);
		fp.setMargin(groupleftcenter, new Insets(5,0,0,0));
		FlowPane fpleftcenteru = new FlowPane();
		fpleftcenteru.setMinWidth(500);
		fpleftcenteru.setMinHeight(280);
		fpleftcenteru.setAlignment(Pos.TOP_CENTER);
		TabPane tabpane = new TabPane();
		tabpane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
		tabpane.setSide(Side.TOP);
		tabpane.setMinWidth(500);
		tabpane.setMinHeight(280);
		Tab tabChat = new Tab("чат");
		WebView webweiw = new WebView();
		WebEngine chatView = webweiw.getEngine();
		webweiw.setMaxWidth(500);
		webweiw.setMaxHeight(250);
		
		tabChat.setContent(webweiw);
		
		Tab tabGrafic = new Tab("Bitfinex");
		WebView webweiwgrafic = new WebView();
		WebEngine graficView = webweiwgrafic.getEngine();
		webweiwgrafic.setMaxWidth(500);
		webweiwgrafic.setMaxHeight(250);
		
		tabGrafic.setContent(webweiwgrafic);
		
		Tab tabMyCoin = new Tab("My Coins");
		
		PieChart chart = new PieChart();
		//chart.setLegendVisible(false);
		chart.setLegendSide(Side.LEFT);
		chart.setMaxHeight(250);
		chart.setAnimated(true);
		tabMyCoin.setContent(chart);
		
		Tab myHistoryTrading = new Tab("История торгов");
		TableView<MyHistoryTrade> tableHistoryTrading = new TableView();
		tableHistoryTrading.setPrefSize(500, 250);
		tableHistoryTrading.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		TableColumn idcolumnHistory = new TableColumn("Id");
		idcolumnHistory.setCellValueFactory(new PropertyValueFactory<MyHistoryTrade, String>("Id"));
		idcolumnHistory.setSortable(false);
		idcolumnHistory.setResizable(false);
		idcolumnHistory.setMaxWidth(60);
		TableColumn stampcolumnHistory = new TableColumn("Дата");
		stampcolumnHistory.setCellValueFactory(new PropertyValueFactory<MyHistoryTrade, String>("stamp"));
		stampcolumnHistory.setSortable(false);
		//stampcolumnHistory.setResizable(false);
		stampcolumnHistory.setMinWidth(140);
		TableColumn namecolumnHistory = new TableColumn("Coin");
		namecolumnHistory.setCellValueFactory(new PropertyValueFactory<MyHistoryTrade, String>("name"));
		namecolumnHistory.setSortable(false);
		namecolumnHistory.setResizable(false);
		//buycolumn.setMinWidth(100);
		TableColumn isbidcolumnHistory = new TableColumn("действие");
		isbidcolumnHistory.setCellValueFactory(new PropertyValueFactory<MyHistoryTrade, String>("isbidstr"));
		isbidcolumnHistory.setSortable(false);
		isbidcolumnHistory.setResizable(false);
		//buycolumn.setMinWidth(100);
		TableColumn notescolumnHistory = new TableColumn("нот");
		notescolumnHistory.setCellValueFactory(new PropertyValueFactory<MyHistoryTrade, String>("notes"));
		notescolumnHistory.setSortable(false);
		notescolumnHistory.setResizable(false);
		notescolumnHistory.setMaxWidth(40);
		TableColumn pricecolumnHistory = new TableColumn("цена");
		pricecolumnHistory.setCellValueFactory(new PropertyValueFactory<MyHistoryTrade, String>("price"));
		pricecolumnHistory.setSortable(false);
		pricecolumnHistory.setResizable(false);
		//buycolumn.setMinWidth(100);
		//ObservableList<OrdersForTable> obslist = FXCollections.observableArrayList(getpost.getListOrders());
		//tableview.setItems(obslist);                  тут
		tableHistoryTrading.getColumns().addAll(idcolumnHistory,stampcolumnHistory,namecolumnHistory,isbidcolumnHistory,notescolumnHistory,pricecolumnHistory);
		
		myHistoryTrading.setContent(tableHistoryTrading);
		tabpane.getTabs().addAll(tabChat,tabMyCoin,myHistoryTrading, tabGrafic);
		fpleftcenteru.getChildren().add(tabpane);
		FlowPane fpleftcentertable = new FlowPane();
		//fpleftcenter.setStyle("-fx-background-color:#ff0000;");
		
		fpleftcentertable.setMinWidth(500);
		fpleftcentertable.setMinHeight(400);
		fpleftcentertable.setAlignment(Pos.BOTTOM_CENTER);
		
		Label labelhtest = new Label("Мои заявки");
		TableView<MyZayvkiForTable> tableMyZayvki = new TableView();
		tableMyZayvki.setPrefSize(500, 100);
		tableMyZayvki.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		TableColumn namecolumn = new TableColumn("Coin");
		namecolumn.setCellValueFactory(new PropertyValueFactory<OrdersForTable, String>("name"));
		namecolumn.setSortable(false);
		namecolumn.setResizable(false);
		//buycolumn.setMinWidth(100);
		TableColumn zCoincolumn = new TableColumn("Id Coin");
		zCoincolumn.setCellValueFactory(new PropertyValueFactory<OrdersForTable, String>("zCoin"));
		zCoincolumn.setSortable(false);
		zCoincolumn.setResizable(false);
		//buycolumn.setMinWidth(100);
		TableColumn offerIdcolumn = new TableColumn("id заявки");
		offerIdcolumn.setCellValueFactory(new PropertyValueFactory<OrdersForTable, String>("offerId"));
		offerIdcolumn.setSortable(false);
		offerIdcolumn.setResizable(false);
		//buycolumn.setMinWidth(100);
		TableColumn kindcolumn = new TableColumn("действие");
		kindcolumn.setCellValueFactory(new PropertyValueFactory<OrdersForTable, String>("kindstring"));
		kindcolumn.setSortable(false);
		kindcolumn.setResizable(false);
		//buycolumn.setMinWidth(100);
		TableColumn notescolumn = new TableColumn("нот");
		notescolumn.setCellValueFactory(new PropertyValueFactory<OrdersForTable, String>("notes"));
		notescolumn.setSortable(false);
		notescolumn.setResizable(false);
		//buycolumn.setMinWidth(100);
		TableColumn pricecolumn = new TableColumn("цена");
		pricecolumn.setCellValueFactory(new PropertyValueFactory<OrdersForTable, String>("price"));
		pricecolumn.setSortable(false);
		pricecolumn.setResizable(false);
		//buycolumn.setMinWidth(100);
		//ObservableList<OrdersForTable> obslist = FXCollections.observableArrayList(getpost.getListOrders());
		//tableview.setItems(obslist);                  тут
		tableMyZayvki.getColumns().addAll(zCoincolumn,offerIdcolumn,namecolumn,notescolumn,kindcolumn,pricecolumn);
		
		
		
		ContextMenu contextMenuMyOrder = new ContextMenu();
		MenuItem menuItemDel = new MenuItem("Удалить");
		MenuItem menuItemRed = new MenuItem("Перепоставить");
		MenuItem menuItemRedaction = new MenuItem("Редактировать");
		contextMenuMyOrder.getItems().addAll(menuItemDel,menuItemRed,menuItemRedaction);
		
		EventHandler<ActionEvent> eventMenuContext = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
				MyZayvkiForTable myzv = tableMyZayvki.getSelectionModel().getSelectedItem();
				if(myzv!=null) {
					System.out.println(myzv.getOfferId());
					if(event.getSource().equals(menuItemRedaction)) {
						Sostin.getSostin().setDelOrder(myzv.getOfferId());
						Sostin.getSostin().setBooldelOrder(true);
						Sostin.getSostin().setStartOrder(true);
					}
					if(event.getSource().equals(menuItemDel)) {
						Sostin.getSostin().setDelOrder(myzv.getOfferId());
						Sostin.getSostin().setBooldelOrder(true);
					}
					if(event.getSource().equals(menuItemRed)) {
						Sostin.getSostin().setDelOrder(myzv.getOfferId());
						String price = "0";
						String kindstr = "true";
						if(myzv.getKind()==0) {
							price = "999";
							kindstr = "false";
							try {
								Double pricetable = Double.parseDouble(Sostin.getSostin().getPriceList().get(0).getSell())-0.0001;
								price = String.format(Locale.US, "%.4f", pricetable);
							}catch(Exception e) {
								try {
									StringBuilder sb = new StringBuilder(Sostin.getSostin().getPriceList().get(0).getSell());
									String sbpod = sb.substring(2);
									Double pricetable = Double.parseDouble(sbpod.toString())-0.0001;
									price = String.format(Locale.US, "%.4f", pricetable);
								}catch(Exception ex) {
								ex.printStackTrace();
								}
							}
						}
						if(myzv.getKind()==1) {
							price = "0";
							kindstr = "true";
							try {
								
								Double pricetable = Double.parseDouble(Sostin.getSostin().getPriceList().get(0).getBuy())+0.0001;
								price = String.format(Locale.US, "%.4f", pricetable);
							}catch(Exception e) {
								try {
									StringBuilder sb = new StringBuilder(Sostin.getSostin().getPriceList().get(0).getBuy());
									String sbpod = sb.substring(2);
									Double pricetable = Double.parseDouble(sbpod.toString())+0.0001;
									price = String.format(Locale.US, "%.4f", pricetable);
								}catch(Exception ex) {
								ex.printStackTrace();
								}
							}
						}
						//
						AddOrder addordersostinRed = new AddOrder(kindstr, Sostin.getSostin().getzCoinMain(), myzv.getNotes(), price);
						Sostin.getSostin().setOrderadd(addordersostinRed);
						Sostin.getSostin().setBooldelOrder(true);
						Sostin.getSostin().setRedaction(true);
					}
					
				}
			}
			
		};
		menuItemDel.setOnAction(eventMenuContext);
		menuItemRed.setOnAction(eventMenuContext);
		menuItemRedaction.setOnAction(eventMenuContext);
		
		tableMyZayvki.setContextMenu(contextMenuMyOrder);
		fpleftcentertable.getChildren().addAll(labelhtest,tableMyZayvki);
		groupleftcenter.getChildren().addAll(fpleftcentertable,fpleftcenteru);
		//правая панель цен коинов
		FlowPane flpanelistCoin = new FlowPane();
		
		flpanelistCoin.setOrientation(Orientation.VERTICAL);
		
		
		flpanelistCoin.setStyle("-fx-background-color:#ffffff;");
		flpanelistCoin.setMinWidth(100);
		
		
		//scroll.setRotate(5.0);
		Label balance = new Label();
		balance.setFont(Font.font("Arial", FontWeight.BOLD,
				FontPosture.ITALIC, 20));
		balance.setMinWidth(200);
		balance.setAlignment(Pos.CENTER);
		fp.getChildren().addAll(fpleft, groupleftcenter, flpanelistCoin);
		fpvertcenterflp.getChildren().addAll(choice,balance,fp);
		groupcenter.getChildren().addAll(fpvertcenterflp);
		bp.setCenter(groupcenter);
		//нижняя главная панель
		FlowPane fpniz = new FlowPane(20,2);
		Group groupniz = new Group();
		FlowPane fpniztest = new FlowPane(20,2);
		fpniztest.setMinWidth(scene.getWidth()-5);
		fpniztest.setAlignment(Pos.CENTER_RIGHT);
		circle = new Circle();
		circle.setCenterX(6);
		circle.setCenterY(6);
		circle.setRadius(6);
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.RED);
		circle.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println("CLICK");
				Sostin.getSostin().setPropusk(true);
			}
			
		});
		labelniz.setText("Вход выполнен для WMID "+User.getUser().getWmid());
		fpniz.setStyle("-fx-background-color:#ffffff;");
		Label infoAPI = new Label();
		Label infoschetAPI = new Label();
		fpniztest.getChildren().addAll(infoAPI,circle,infoschetAPI);
		Label seccsefull = new Label();
		seccsefull.setMinWidth(scene.getWidth()-5);
		seccsefull.setAlignment(Pos.CENTER);
		groupniz.getChildren().addAll(labelniz, seccsefull, fpniztest);
		fpniz.getChildren().addAll(groupniz);
		bp.setBottom(fpniz);
		//слушатели
		//кнопок купить продать
		buttonbuy.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				Stage popup = new StageBuy(Sostin.getSostin().getzCoinMain());
				
				popup.show();
			}
			
		});
		buttonsell.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Stage popup = new StageSell(Sostin.getSostin().getzCoinMain());
				
		
				popup.show();
			}
			
		});
	Runnable runnabledown = new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
	
	
		//notifyPreloader(new Preloader.ProgressNotification(0.2));
		Opiration opirat = Opiration.getOpiration();
		//баланс
		Platform.runLater(()->{
		downloadstage.close();
		downloadstage = new DownLoadStage("...Вход...");
		downloadstage.show();
		});
				String balanceAPI = opirat.balance();
				
				if(balanceAPI==null) {
					downloadstage.close();
					Platform.runLater(()->{
					try {
						File fileinit = new File("init.txt");
						
						System.out.println(fileinit.delete());
						}
						catch(Exception e){
							e.printStackTrace();
						}
						//executor.shutdownNow();
						
						LoginApplication la = new LoginApplication();
						try {
							
							la.start(new Stage());
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					});
				}else {
		//notifyPreloader(new Preloader.ProgressNotification(0.5));
		Platform.runLater(()->{
		downloadstage.close();
		downloadstage = new DownLoadStage("...Загрузка необходимых параметров...");
		downloadstage.show();
		});
		
		List<CoinTool> coinTools = opirat.getCoinTools();
	Platform.runLater(()->{
		downloadstage.close();
		List<String> toolsChoise = new ArrayList<>();
		for(int i = 0; i<coinTools.size(); i++) {
			String name = coinTools.get(i).getName();
			toolsChoise.add(name);
		}
		ObservableList<String> country = FXCollections.observableArrayList(toolsChoise);
		choice.setItems(country);
		choice.getSelectionModel().select(0);
		choice.getSelectionModel().selectedItemProperty().addListener(new
				ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> ov, String old_val, String
			new_val) {
				System.out.println(new_val);
				
				for(int i = 0; i<coinTools.size(); i++) {
					String name = coinTools.get(i).getName();
					if(name.equals(new_val)) {
						obslist = FXCollections.observableArrayList();
						tableview.setItems(obslist);
						Sostin.getSostin().setzCoinMain(coinTools.get(i).getId());
						Platform.runLater(()->{
							graficView.loadContent(WebSite.getWebSite().getGraphickTradView(Sostin.getSostin().getzCoinMain()));
							});
						Sostin.getSostin().setChoiseclick(true);
						System.out.println("choise^"+Sostin.getSostin().getzCoinMain());
					}
				}
				
				
			}});
		
		executor = Executors.newScheduledThreadPool(3);
		
		stage.show();
		//labelvver.setText("go");
		timertask = new ServicePOST(circle, tableview, obslist, flpanelistCoin, infoAPI, balance, tableMyZayvki, seccsefull, chart, infoschetAPI, tableHistoryTrading); 
		executor.scheduleWithFixedDelay(timertask, 0, 2, TimeUnit.SECONDS);
		
		Runnable chatrun = new ChatService(chatView);
		executor.scheduleWithFixedDelay(chatrun, 0, 2, TimeUnit.SECONDS);
		
		executor.schedule(()->{
			Platform.runLater(()->{
			graficView.loadContent(WebSite.getWebSite().getGraphickTradView(Sostin.getSostin().getzCoinMain()));
			});
		}, 10, TimeUnit.SECONDS);
	});
	}
				
				}
		//показать
		//downlodStage.close();
		//notifyPreloader(new Preloader.ProgressNotification(1.0));
				};
				Thread threadmainrunnable = new Thread(runnabledown);
				threadmainrunnable.start();
				
		
		
				
		
		
		
	}
	@Override
	public void stop() {
		
		System.out.println("CLOSEg");
	}

}
