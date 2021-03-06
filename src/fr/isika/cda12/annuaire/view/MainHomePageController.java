package fr.isika.cda12.annuaire.view;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import fr.isika.cda12.annuaire.model.Personne;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MainHomePageController extends Application implements Initializable{
	Personne user;
	
	@FXML
	private Button btnConnexion;
	
	@FXML
	private Button btnInscription;
	
	@FXML
	private Button btnHelp;
	
	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException {
		
		if (event.getSource() == btnConnexion) {
			Parent connexion_parent = FXMLLoader.load(getClass().getResource("Connexion.fxml"));
			Scene connexion_scene = new Scene (connexion_parent);
			Stage hp_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			hp_stage.hide();
			hp_stage.setScene(connexion_scene);
			hp_stage.show();
		} else if (event.getSource() == btnInscription){
			Parent inscription_parent = FXMLLoader.load(getClass().getResource("Inscription.fxml"));
			Scene inscription_scene = new Scene (inscription_parent);
			Stage hp_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			hp_stage.hide();
			hp_stage.setScene(inscription_scene);
			hp_stage.show();
		} else if (event.getSource() == btnHelp){
			openHelp();
		} else {
			System.out.println("veuillez réessayer");
		}
		
	}
	public void transferUser(Personne user) {
		this.user = user;
		
	}
	
	public void openHelp() {
		
		File pdfFile = new File("assets/Documentation utilisateur de l'annuaire.pdf");
        getHostServices().showDocument(pdfFile.toURI().toString());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
