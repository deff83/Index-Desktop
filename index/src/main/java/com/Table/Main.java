package com.Table;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import com.Table.stage.TestPreloader;
import com.getpost.Opiration;
import com.sun.javafx.application.LauncherImpl;

import javafx.application.Application;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("IndexG");
		// TODO Auto-generated method stub
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try(BufferedReader br = new BufferedReader(new FileReader(User.getUser().getInitialisationfile()))){
					
					String login = br.readLine();
					String wmid = br.readLine();
					String password = br.readLine();
					String culture = br.readLine();
					User.getUser().setUser(login, wmid, password, culture);
					br.close();
					//Opiration.getOpiration().inicialisation(login, wmid, password, culture);
					
					Application.launch(MainApplication.class, args);
					
			} 
			catch (IOException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
				Application.launch(LoginApplication.class, args);
			}
			}
			
		};
		SwingUtilities.invokeLater(runnable);
	}

}
