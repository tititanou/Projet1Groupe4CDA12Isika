package fr.isika.cda12.annuaire;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SimpleSearchStagiaire extends Application {
	
	private Stage primaryStage;
    private BorderPane rootLayout;
    
    @Override
	public void start(Stage primaryStage) {
		
		this.primaryStage = primaryStage;

        initRootLayout();

        showStagiaireOverview();
		
	}
	
	public void initRootLayout() {
        try {
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SimpleSearchStagiaire.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void showStagiaireOverview() {
        try {
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SimpleSearchStagiaire.class.getResource("view/SimpleSearchStagiaire.fxml"));
            AnchorPane stagiaireOverview = (AnchorPane) loader.load();
            
            rootLayout.setCenter(stagiaireOverview);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	
}
