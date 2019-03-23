package com.Table;

import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class LoginApplication extends Application {

	public LoginApplication() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start(Stage initstage) throws Exception {
		// TODO Auto-generated method stub
		
		initstage.setAlwaysOnTop(true);
		BorderPane bpinit = new BorderPane();
		
		Scene sceneinit = new Scene(bpinit, 500,500);
		initstage.setScene(sceneinit);
		initstage.setResizable(false);
		Group groupinit = new Group();
		FlowPane flpaneinit = new FlowPane(5,5);
		bpinit.setMargin(flpaneinit, new Insets(5,0,0,5));
		Image im = new Image(this.getClass().getResource("loginback.png").toString());
		ImageView imgview = new ImageView (im);
		imgview.setFitWidth(500);
		imgview.setFitHeight(500);
		//Paint impaint = new Paint();
		//bpinit.setStyle("-fx-background-image:loginback;");
		Image imlogo = new Image(this.getClass().getResource("logopr.png").toString());
		ImageView imglogoview = new ImageView (imlogo);
		imglogoview.setFitWidth(200);
		imglogoview.setFitHeight(200);
		TextField wmidtextfield = new TextField();
		wmidtextfield.setPromptText("WMID");
		
		wmidtextfield.setFocusTraversable(false);
		wmidtextfield.setPrefWidth(300);
		TextField logintextfield = new TextField();
		logintextfield.setPromptText("LOGIN");
		logintextfield.setFocusTraversable(false);
		
		logintextfield.setPrefWidth(300);
		TextField passwordtextfield = new TextField();
		passwordtextfield.setPromptText("PASSWORD");
		passwordtextfield.setFocusTraversable(false);
		
		passwordtextfield.setPrefWidth(300);
		Button buttonEnter = new Button("¬ход");
		buttonEnter.setPrefWidth(300);
		
		flpaneinit.getChildren().addAll(imglogoview,wmidtextfield,logintextfield,passwordtextfield,buttonEnter);
		flpaneinit.setMinWidth(500);
		flpaneinit.setAlignment(Pos.CENTER);
		flpaneinit.setLayoutY(100);
		groupinit.getChildren().add(imgview);
		groupinit.getChildren().add(flpaneinit);
		
		bpinit.setCenter(groupinit);
		buttonEnter.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String login = logintextfield.getText();
				String wmid = wmidtextfield.getText();
				String password = passwordtextfield.getText();
				String culture = "ru-RU";
				try(FileWriter fw = new FileWriter(User.getUser().getInitialisationfile())){
					fw.write(login+"\r\n");
					fw.write(wmid+"\r\n");
					fw.write(password+"\r\n");
					fw.write(culture+"\r\n");
					User.getUser().setUser(login, wmid, password, culture);
					
					String[] args = {login,wmid,password,culture};
					MainApplication mapp = new MainApplication();
					try {
						mapp.start(new Stage());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					initstage.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		initstage.show();
	}

}
