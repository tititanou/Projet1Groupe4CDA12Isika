package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
//	public void start(Stage primaryStage) {
////		try {
////			BorderPane root = new BorderPane();
////			Scene scene = new Scene(root,400,400);
////			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
////			primaryStage.setScene(scene);
////			primaryStage.show();
////		} catch(Exception e) {
////			e.printStackTrace();
////		}
////	}
	
	public void start(Stage primaryStage) throws Exception{
		
		// on charge le fichier pas l'interface basique
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Gestion de stagiaires");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
