package com.Table.stage;

import com.Table.AddOrder;
import com.Table.Sostin;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StageSell extends Stage {
	private TextField pricetextfield = new TextField();
	private TextField nottextfield = new TextField();
	public StageSell(int zCoin) {
		// TODO Auto-generated constructor stub
		String zCoinlabel = "-";
		try {
			zCoinlabel = Sostin.getSostin().getMapIdCointools().get(zCoin).getName();
		}catch(Exception e) {
			
		}
		BorderPane bpbuy = new BorderPane();
		
		Scene scenebuy = new Scene(bpbuy, 305,120);
		this.setScene(scenebuy);
		this.setResizable(false);
		
		FlowPane flpanebuy = new FlowPane(5,5);
		bpbuy.setMargin(flpanebuy, new Insets(5,0,0,5));
		bpbuy.setStyle("-fx-background-color:#ccffcc;");
		//компоненты
		Label labelvverch = new Label("Продать "+zCoinlabel);
		labelvverch.setPrefWidth(330);
		labelvverch.setAlignment(Pos.CENTER);
		labelvverch.setFont(Font.font("Arial", FontWeight.BOLD,
				FontPosture.ITALIC, 20));
		InnerShadow is = new InnerShadow();
		Reflection effect=new Reflection();
		effect.setBottomOpacity(0.0);
		effect.setTopOffset(-44.0);
		effect.setTopOpacity(0.7);
		effect.setInput(is);
		labelvverch.setEffect(effect);
		Label notlabel = new Label("Количество нот:");
		notlabel.setPrefWidth(130);
		
		nottextfield.setPrefWidth(170);
		Label pricelabel = new Label("Цена продажи:");
		pricelabel.setPrefWidth(130);
		
		pricetextfield.setPrefWidth(170);
		Button buttonok = new Button("Ok");
		buttonok.setPrefWidth(150);
		Button buttoncancel = new Button("Cancel");
		buttoncancel.setPrefWidth(150);
		flpanebuy.getChildren().addAll(labelvverch,notlabel,nottextfield,pricelabel,pricetextfield,buttoncancel, buttonok);
		bpbuy.setCenter(flpanebuy);
		EventHandler eventhandlermenu = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getSource().equals(buttonok)) {
					int note = 0;
					try {
					 note = Integer.parseInt(nottextfield.getText());
					}catch(Exception e) {}
					AddOrder addorder = new AddOrder("false", zCoin, note, pricetextfield.getText());
					Sostin.getSostin().setOrderadd(addorder);
					Sostin.getSostin().setBoolAddOrder(true);
					close();
				}
				
				if(arg0.getSource().equals(buttoncancel)) {
					close();				
				};
			}
			
		};
		buttonok.setOnAction(eventhandlermenu);
		buttoncancel.setOnAction(eventhandlermenu);
	}
	public void setPrice(String price) {
		pricetextfield.setText(price);
	}
	public void setNotes(String note) {
		nottextfield.setText(note);
	}

}
