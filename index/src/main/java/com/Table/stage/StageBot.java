package com.Table.stage;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StageBot extends Stage {

	public StageBot() {
		// TODO Auto-generated constructor stub
		BorderPane bpbuy = new BorderPane();
		Scene scenebuy = new Scene(bpbuy, 400,600);
		this.setScene(scenebuy);
		this.setResizable(false);
		
	}

	

}
