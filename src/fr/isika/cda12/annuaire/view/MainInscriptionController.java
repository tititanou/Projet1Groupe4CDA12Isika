package fr.isika.cda12.annuaire.view;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

import fr.isika.cda12.annuaire.model.Personne;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainInscriptionController implements Initializable {
	
	@FXML
	private TextField tfPrenom;
	
	@FXML
	private TextField tfNom;
	
	@FXML
	private TextField tfMotDePasse;
	
	@FXML
	private TextField tfMotDePasse2;
	
	@FXML
	private Button btnBack;
	
	@FXML
	private Button btnValidate;
	
	
	
	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException {
		
		if (event.getSource() == btnBack) {
			Parent homePage_parent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
			Scene homePage_scene = new Scene (homePage_parent);
			Stage inscr_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			inscr_stage.hide();
			inscr_stage.setScene(homePage_scene);
			inscr_stage.show();
			
			}  else  if (event.getSource() == btnValidate) {
			System.out.println(tfNom.getText() + tfPrenom.getText());
			
			Personne person = new Personne (tfNom.getText(), tfPrenom.getText());
			boolean resultat = person.creerCompte(tfNom.getText(), tfPrenom.getText(), tfMotDePasse.getText(), tfMotDePasse2.getText());
			
			if (resultat == true) {
				
	
			Parent mainStagiaire_parent = FXMLLoader.load(getClass().getResource("MainStagiaire.fxml"));
			Scene mainStagiaire_scene = new Scene (mainStagiaire_parent);
			Stage inscr_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			inscr_stage.hide();
			inscr_stage.setScene(mainStagiaire_scene);
			inscr_stage.show();
			
			}
			
			} else {
				System.out.println("veuillez réessayer");
			}
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	

}
