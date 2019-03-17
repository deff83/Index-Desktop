package com.Table.stage;

import com.Service.ServicePOST;
import com.Service.SettingPar;
import com.Table.Sostin;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class MinStage {
	
	private Scene mainScene;
	private Stage mainstage;
	public MinStage(Scene mainScene, Stage stage, ServicePOST timertask) {
		BorderPane bp = new BorderPane();
		Scene scene = new Scene(bp, 210, 80);
		this.mainScene = mainScene;
		this.mainstage = stage;
		// TODO Auto-generated constructor stub


		// TODO Auto-generated constructor stub
		
		FlowPane flpcenter = new FlowPane();
		flpcenter.setStyle("-fx-background-color:#ffffff;");
		flpcenter.setOrientation(Orientation.HORIZONTAL);
		
		Button buttrazvernuti = new Button("развернуть");
		buttrazvernuti.setMinWidth(200);
		buttrazvernuti.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				stage.setScene(mainScene);
				stage.setAlwaysOnTop(false);
				SettingPar.getSettingPar().setBool(true, true, true, true, true);
			}
			
		});
		Label priceTek = new Label("Price");
		priceTek.setMinWidth(200);
		priceTek.setFont(Font.font("Arial", FontWeight.BOLD,FontPosture.ITALIC, 20));
		priceTek.setAlignment(Pos.CENTER);
		Label priceBuy = new Label("Buy");
		priceBuy.setMinWidth(100);
		priceBuy.setFont(Font.font("Arial", FontWeight.BOLD,FontPosture.ITALIC, 20));
		priceBuy.setAlignment(Pos.CENTER);
		Label priceSell = new Label("Sell");
		priceSell.setMinWidth(100);
		priceSell.setFont(Font.font("Arial", FontWeight.BOLD,FontPosture.ITALIC, 20));
		priceSell.setAlignment(Pos.CENTER);
		timertask.setPriceBuy(priceBuy);
		timertask.setPriceSell(priceSell);
		timertask.setPriceTek(priceTek);
		
		flpcenter.getChildren().addAll(priceTek,priceBuy,priceSell,buttrazvernuti);
		bp.setMargin(flpcenter, new Insets(5));
		bp.setCenter(flpcenter);
		mainstage.setScene(scene);
		mainstage.setAlwaysOnTop(true);
		
	}

}
