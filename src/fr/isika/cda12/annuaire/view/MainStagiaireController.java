package fr.isika.cda12.annuaire.view;

import java.io.IOException;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import fr.isika.cda12.Arbre;
import fr.isika.cda12.annuaire.model.Stagiaire;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainStagiaireController implements Initializable {
	
	@FXML
	private TextField tfNom;
	
	@FXML
	private TextField tfPrenom;
	
	@FXML
    private Label nomLabel;
	
    @FXML
    private Label prenomLabel;
	
	@FXML
	private Button btnSearch;
	
	@FXML
	private TableView<String> tvStagiaire;
	
//	@FXML
//	private TableColumn<String, String> colNom;
	
	@FXML
	private TableColumn<String, String> colPrenom;
	
	// Reference to the main application.
    // private MainStagiaireOverview mainStagiaire;
	
	// Constructeur
	public MainStagiaireController() {
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		afficherStagiaire();
	}
	
	@FXML
	private void handleButtonAction(ActionEvent event) {
		
		if (event.getSource() == btnSearch) {
			
			Rechercher();
		}
			
		afficherStagiaire();
	}
	
	private void Rechercher() {
		
	}
	
	
	public ObservableList<String> getStagiaires() {
		
		ObservableList<String> stagiaireListe = FXCollections.observableArrayList();
		
		Arbre arbre;
		try {
			arbre = new Arbre("assets/noms.txt");
			arbre.afficherArbre(stagiaireListe);
		} catch (IOException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Echec de la lecture du fichier");
			alert.setContentText("Un problème est survenu avec le fichier!");
			e.printStackTrace();
		}
		
		return stagiaireListe;
	}
	
	public void afficherStagiaire() {
		try {
			List<String> list = this.getStagiaires();
			
			//colPrenom.setCellValueFactory(list);
			colPrenom.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("prenom"));
			
			// colNom.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("nom"));
			
			tvStagiaire.getItems().clear();
			tvStagiaire.getItems().addAll(list);
			
			
		} catch (NullPointerException e) {
			System.err.println("Error" + e);
		}
	}

}
