package com.Table.stage;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DownLoadStage extends Stage {

	private Label label;
	public DownLoadStage(String labelstr) {
		// TODO Auto-generated constructor stub
		BorderPane bp = new BorderPane();
		bp.setStyle("-fx-background-radius:6;"+"-fx-background-color:rgb(99,99,99),rgb(256,256,256);"+"-fx-background-insets:0,0 1 1 0;");
		Scene scenebuy = new Scene(bp, 200,100);
		this.initStyle(StageStyle.UNDECORATED);
		this.setScene(scenebuy);
		this.setResizable(false);
		label = new Label(labelstr);
		bp.setCenter(label);
		
	}
	public void setLabel(String lad) {
		Platform.runLater(()->{
		label.setText(lad);
		});
	}

}
