package com.Table.stage;

import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.stage.Stage;

public class TestPreloader extends Preloader {

	private DownLoadStage downlodStage;



	public TestPreloader() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		downlodStage = new DownLoadStage("...Инициализация...");
		downlodStage.show();
	}

	

	@Override
	public void handleApplicationNotification(PreloaderNotification info) {
		// TODO Auto-generated method stub
		if(info instanceof ProgressNotification) {
			ProgressNotification pn = (ProgressNotification) info;
			if(pn.getProgress()==0.2) {
					
				
					
			}
			if(pn.getProgress()==0.5) {
				
					//downlodStage.setLabel("...Вход...");
				
			}
			if(pn.getProgress()==1.0) {
				
				downlodStage.close();
			
		}
		
		}
	}
}
