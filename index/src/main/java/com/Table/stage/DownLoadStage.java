package com.Table.stage;



import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DownLoadStage extends Stage {

	private Label label;
	private BorderPane bp;
	private ProgressBar prBar;
	public DownLoadStage(String labelstr) {
		// TODO Auto-generated constructor stub
		bp = new BorderPane();
		bp.setStyle("-fx-background-radius:10;"+"-fx-background-color:rgb(99,99,99),rgb(256,256,256);"+"-fx-background-insets:0,0 1 1 0;");
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
	public void setUpdate(double percent) {
		// TODO Auto-generated method stub
		Platform.runLater(()->{
			try {
				label.setText("Загрузка обновлений ("+Math.round(percent*100)+"%)");
				prBar.setProgress(percent);
			}catch(Exception e) {}
		});
	}
	public void changeView() {
		Platform.runLater(()->{
			Group group = new Group();
			
		FlowPane fpvvvse = new FlowPane(20, 5);
			prBar = new ProgressBar();
			prBar.setMinWidth(150);
			
			fpvvvse.setOrientation(Orientation.VERTICAL);
			fpvvvse.setAlignment(Pos.CENTER);
			fpvvvse.getChildren().addAll(label,prBar);
			fpvvvse.setMaxHeight(40);
			group.getChildren().add(fpvvvse);
			label.setText("Получение обновлений");
			bp.setCenter(group);
		});
	}

}
