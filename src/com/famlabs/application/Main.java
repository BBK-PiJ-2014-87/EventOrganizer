/*
 * Copyright (c) 2015 Famlabs.com. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * 
 * This code is free software. You can redistribute it and/or modify it
 * under the terms of the GNU General Public License, as published by the
 * Free Software Foundation.
 * 
 * FAMLABS MAKES NO REPRESENTATIONS OR WARRANTIES ANOUT THE SUITABILITY
 * OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BU NOT LIMITED TO
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE,
 * OR NON-INFRINGEMENT. FAMLABS WILL NOT BE LIABLE FOA NAY DAMAGES SUFFERED
 * BY A LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE.
 */

package com.famlabs.application;
	
import java.io.IOException;

import com.famlabs.controller.EventOverviewController;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	/**
	 * Application data is stored as an Observable List of events.
	 */
	
	private ObservableList<Event> eventData = FXCollections.observableArrayList();
	
	/**
	 * Non argument constructor.
	 */
	
	public Main(){
		eventData.add(new Event("Broadband EU", "Informa"));
		eventData.add(new Event("Tech UK", "Clarion"));
		eventData.add(new Event("CES London", "Samsung"));
		eventData.add(new Event("SaaS UK", "Oracle"));
		eventData.add(new Event("Machine Learning", "UCL"));
		eventData.add(new Event("Biga Data", "Google"));
		eventData.add(new Event("Networking", "Linkedin"));
		eventData.add(new Event("TechStundetAwards", "Google"));
		eventData.add(new Event("World Forum", "Informa"));
		
	}
	
	/**
	 * Method return all data in application
	 * @return Returns data as an observable list of Events.
	 */
	
	public ObservableList<Event> getEventData(){
		return eventData;
	}
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("EventApp");
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/com/famlabs/fxml/RootLayout.fxml"));
			rootLayout = (BorderPane)loader.load();
			Scene scene = new Scene(rootLayout,630,440);			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		//Places EventOverview into BorderPane
		showEventOverview();
	}
	
	/**
	 * Returns the main stage.
	 * @param
	 */
	
	public Stage getPrimaryStage(){
		return primaryStage;
	}
	
	/**
	 * Show event overview scene
	 */
	
	public void showEventOverview(){
		try{
			//Load fxml file and set into the center of the main layout
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/com/famlabs/fxml/EventOverview.fxml"));
			AnchorPane overviewPage = (AnchorPane) loader.load();
			rootLayout.setCenter(overviewPage);
			
			//Give the controller access to the main app
			EventOverviewController controller = loader.getController();
			controller.setMain(this);
			
		}catch (IOException e){
			//Exception gets thrown if the fxml file couldn't be found
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
