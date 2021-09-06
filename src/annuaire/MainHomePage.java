package annuaire;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainHomePage extends Application {
	
	private Stage primaryStage;
    private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		
			this.primaryStage = primaryStage;

	        initRootLayout();

	        showHomePage();
		}
		
		
	    public void initRootLayout() {
	        try {
	           
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainHomePage.class.getResource("view/RootLayout.fxml"));
	            rootLayout = (BorderPane) loader.load();
	            
	            Scene scene = new Scene(rootLayout);
	            primaryStage.setScene(scene);
	            primaryStage.show();
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	   
	    public void showHomePage() {
	        try {
	            
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainHomePage.class.getResource("view/HomePage.fxml"));
	            AnchorPane homePage = (AnchorPane) loader.load();
	            
	            
	            rootLayout.setCenter(homePage);
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
