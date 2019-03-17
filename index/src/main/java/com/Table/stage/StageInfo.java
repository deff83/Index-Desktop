package com.Table.stage;

import com.Table.AddOrder;
import com.Table.Sostin;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StageInfo extends Stage {

	public StageInfo() {
		// TODO Auto-generated constructor stub
		BorderPane bpDeff83 = new BorderPane();
		Scene scenebuy = new Scene(bpDeff83, 400,150);
		this.setScene(scenebuy);
		this.setResizable(false);
		
		//bpDeff83.setTop(menubar);
		
		Group groupcenter = new Group();
		GridPane gridpane = new GridPane();
		gridpane.setBackground(new Background(new BackgroundFill(Color.DARKGOLDENROD, new CornerRadii(5), new Insets(0,0,0,0))));
		
		Image imgDeffLogo = new Image(this.getClass().getResource("logopr.png").toString());
		ImageView imgviewDeffLogo = new ImageView(imgDeffLogo);
		
		imgviewDeffLogo.setFitHeight(100);
		imgviewDeffLogo.setFitWidth(100);
		imgviewDeffLogo.smoothProperty();
		imgviewDeffLogo.preserveRatioProperty();
		gridpane.setMargin(imgviewDeffLogo, new Insets(5));
		gridpane.add(imgviewDeffLogo, 0, 0);
		
		Label labelDeff = new Label("Создатель \r\n DEFF83");
		//labelDeff.setMinWidth(280);
		labelDeff.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 30));
		//labelDeff.setAlignment(Pos.CENTER);
		final Light.Distant lightDistant = new Light.Distant();
		final Light.Point lightPoint = new Light.Point();
		final Light.Spot lightSpot = new Light.Spot();
		final Lighting effect = new Lighting();
		lightDistant.setElevation(1.0);
		lightPoint.setColor(Color.RED);
		lightSpot.setPointsAtX(1.0);
		labelDeff.setEffect(effect);
		Reflection reflection = new Reflection();
		labelDeff.setEffect(reflection);
		/*final ScaleTransition sta2 =
				new ScaleTransition(Duration.millis(1000),labelDeff);
				sta2.setByX(-1.5);
				sta2.setByY(-1.5);
				sta2.setCycleCount(2);
				sta2.setAutoReverse(true);*/
		final TranslateTransition ttF =
						new TranslateTransition(Duration.millis(5000),labelDeff);
						ttF.setCycleCount(500);
						ttF.setByX(100);
						//ttF.setToY(270.0);
						ttF.setAutoReverse(true);
		final RotateTransition rta1 =
				new RotateTransition(Duration.millis(5000),labelDeff);
				rta1.setByAngle(360);
				rta1.setAxis(new Point3D(0.0, 1.0, 0.0));
				rta1.setCycleCount(500);
				
				rta1.play();
						ttF.play();
		gridpane.add(labelDeff, 1, 0);
		
		Label labelOprog = new Label("Программа разработана Deff83, все права API на стороне Indx.ru");
		labelOprog.setMaxWidth(370);
		labelOprog.setMinWidth(370);
		
		labelOprog.setWrapText(true);
		//labelOprog.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 30));
		labelOprog.setAlignment(Pos.CENTER);
		labelOprog.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), new Insets(0,0,0,0))));
		
		gridpane.setMargin(labelOprog, new Insets(5));
		gridpane.add(labelOprog, 0, 1,2,1);
		
		groupcenter.getChildren().addAll(gridpane);
		bpDeff83.setAlignment(groupcenter, Pos.CENTER);
		bpDeff83.setMargin(groupcenter, new Insets(5));
		bpDeff83.setCenter(groupcenter);
		
		
		
		
	}

}
