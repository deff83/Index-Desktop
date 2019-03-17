package com.Table.stage;

import com.Service.SettingPar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Setting extends Stage {

	public Setting() {
		// TODO Auto-generated constructor stub
		BorderPane bp = new BorderPane();
		
		Scene scenebuy = new Scene(bp, 305,200);
		this.setScene(scenebuy);
		this.setResizable(false);
		Group group = new Group();
		SettingPar setpar = SettingPar.getSettingPar();
		FlowPane flowpaneMain = new FlowPane();
		flowpaneMain.setOrientation(Orientation.VERTICAL);
		Label label = new Label("Частота запросов в сек");
		TextField textfield = new TextField();
		textfield.setText(String.valueOf(setpar.getChastot()));
		Button buttok = new Button("Ok");
		Separator sep = new Separator();
		
		
		FlowPane flowpane = new FlowPane();
		flowpane.setMaxHeight(150);
		flowpane.setMaxWidth(150);
		FlowPane flowpaner = new FlowPane();
		flowpane.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), new Insets(2))));
		
		flowpaner.setOrientation(Orientation.VERTICAL);
		flowpaner.setMaxHeight(100);
		CheckBox checkBoxOfferList = new CheckBox("Прайс Лист");
		if(setpar.isOfferList()) checkBoxOfferList.setSelected(true);
		Circle circle = new Circle();
		circle.setCenterX(6);
		circle.setCenterY(6);
		circle.setRadius(6);
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.RED);
		checkBoxOfferList.setGraphic(circle);
		CheckBox checkBoxMyOffer = new CheckBox("Мои заявки");
		if(setpar.isMyOffer()) checkBoxMyOffer.setSelected(true);
		Circle circleblue = new Circle();
		circleblue.setCenterX(6);
		circleblue.setCenterY(6);
		circleblue.setRadius(6);
		circleblue.setStroke(Color.BLACK);
		circleblue.setFill(Color.BLUE);
		checkBoxMyOffer.setGraphic(circleblue);
		CheckBox checkBoxTool = new CheckBox("ToolBar");
		if(setpar.isTool()) checkBoxTool.setSelected(true);
		Circle circlegreen = new Circle();
		circlegreen.setCenterX(6);
		circlegreen.setCenterY(6);
		circlegreen.setRadius(6);
		circlegreen.setStroke(Color.BLACK);
		circlegreen.setFill(Color.GREEN);
		checkBoxTool.setGraphic(circlegreen);
		CheckBox checkBoxBalance = new CheckBox("Balance");
		if(setpar.isBalance()) checkBoxBalance.setSelected(true);
		Circle circleyellow = new Circle();
		circleyellow.setCenterX(6);
		circleyellow.setCenterY(6);
		circleyellow.setRadius(6);
		circleyellow.setStroke(Color.BLACK);
		circleyellow.setFill(Color.YELLOW);
		checkBoxBalance.setGraphic(circleyellow);
		CheckBox checkBoxHistoryTrade = new CheckBox("HistoryTrade");
		if(setpar.isHistoryTrade()) checkBoxHistoryTrade.setSelected(true);
		Circle circleBLUEVIOLET = new Circle();
		circleBLUEVIOLET.setCenterX(6);
		circleBLUEVIOLET.setCenterY(6);
		circleBLUEVIOLET.setRadius(6);
		circleBLUEVIOLET.setStroke(Color.BLACK);
		circleBLUEVIOLET.setFill(Color.BLUEVIOLET);
		checkBoxHistoryTrade.setGraphic(circleBLUEVIOLET);
		flowpaner.getChildren().addAll(checkBoxOfferList, checkBoxMyOffer,checkBoxTool,checkBoxBalance,checkBoxHistoryTrade);
		flowpane.setMargin(flowpaner, new Insets(5));
		flowpane.getChildren().add(flowpaner);
		
		
		
		flowpaneMain.getChildren().addAll(label,textfield,buttok,sep,flowpane);
		group.getChildren().addAll(flowpaneMain);
		bp.setCenter(group);
		EventHandler evhandBox = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				CheckBox check = (CheckBox) event.getSource();
				System.out.println("PRESS");
				switch(check.getText()) {
				case "Прайс Лист":
					setpar.setOfferList(check.isSelected());
					break;
				case "Мои заявки":
					setpar.setMyOffer(check.isSelected());
					break;
				case "ToolBar":
					setpar.setTool(check.isSelected());
					break;
				case "Balance":
					setpar.setBalance(check.isSelected());
					break;
				case "HistoryTrade":
					setpar.setHistoryTrade(check.isSelected());
					break;
					
				
				}
			}
			
		};
		checkBoxHistoryTrade.setOnMouseClicked(evhandBox);
		checkBoxOfferList.setOnMouseClicked(evhandBox);
		checkBoxMyOffer.setOnMouseClicked(evhandBox);
		checkBoxTool.setOnMouseClicked(evhandBox);
		checkBoxBalance.setOnMouseClicked(evhandBox);
		
		
		buttok.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				try {
				SettingPar.getSettingPar().setChastot(Integer.parseInt(textfield.getText()));
				}
				catch(Exception e) {
					
				}
				close();
			}
			
		});
		
	}



}
