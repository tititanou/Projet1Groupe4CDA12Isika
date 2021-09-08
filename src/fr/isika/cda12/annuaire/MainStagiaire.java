package fr.isika.cda12.annuaire;

import fr.isika.cda12.annuaire.view.MainStagiaireController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainStagiaire extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception{
		//Parent root = FXMLLoader.load(getClass().getResource("view/MainStagiaire.fxml"));
		FXMLLoader loader = new FXMLLoader(getClass().getResource("view/MainStagiaire.fxml"));
		AnchorPane anchorPane = loader.load();
		//MainStagiaireController controller = loader.getController();
		Scene scene = new Scene(anchorPane);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
