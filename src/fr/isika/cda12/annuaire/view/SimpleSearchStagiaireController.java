package fr.isika.cda12.annuaire.view;

import java.io.IOException;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import fr.isika.cda12.Arbre;
import fr.isika.cda12.Personne;
import fr.isika.cda12.annuaire.model.Stagiaire;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class SimpleSearchStagiaireController implements Initializable {
	
	@FXML
    ComboBox<String> comBoxCriteres;
    
    @FXML
    TextField tfSearchSt;
    
    @FXML
    Button btnSearch;
    
    @FXML
    Button btnPrint;
    
    @FXML
    TableView<Personne> tvStagiaire;
    
    @FXML
    TableColumn<Personne, String> colPrenom;

    @FXML
    TableColumn<Personne, String> colNom;

	// Reference to the main application.
    // private MainStagiaireOverview mainStagiaire;
	
	// Constructeur
	public SimpleSearchStagiaireController() {
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		comBoxCriteres.getSelectionModel().select("Critère de recherche");

		
		ObservableList<String> choix = FXCollections.observableArrayList();
		
		choix.addAll("Nom", "Prénom");
		
		comBoxCriteres.setItems(choix);
		
	}
	
	@FXML
	private void handleButtonAction(ActionEvent event) {
		
		if (event.getSource() == btnSearch) {
			
			afficherStagiaire(rechercher());
		}
		else if (event.getSource() == btnPrint) {
			
			imprimer();
		}
	}
	
	private List<Personne> rechercher() {
		
		String critere = comBoxCriteres.getValue();
		String valeur = tfSearchSt.getText();
		Arbre arbre;
		try {
			arbre = new Arbre("assets/noms.txt", critere);   
			return arbre.rechercher_liste(critere, valeur);
		} catch (IOException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Echec de la lecture du fichier");
			alert.setContentText("Un problème est survenu avec le fichier!");
			e.printStackTrace();
			return null;
		}
	}
	
	public void afficherStagiaire(List<Personne> list) {
		try {
			
			colPrenom.setCellValueFactory(new PropertyValueFactory<Personne, String>("prenom"));
			
			colNom.setCellValueFactory(new PropertyValueFactory<Personne, String>("nom"));
			
			tvStagiaire.getItems().clear();
			tvStagiaire.getItems().addAll(list);
			
			
		} catch (NullPointerException e) {
			System.err.println("Error" + e);
		}
	}
	
	private void imprimer() {
		final PrinterJob printerjob = PrinterJob.createPrinterJob();
		if (printerjob.showPrintDialog(tvStagiaire.getScene().getWindow())) {
			if(printerjob.printPage(tvStagiaire)) {
				printerjob.endJob();
			}
		}
	}

}
