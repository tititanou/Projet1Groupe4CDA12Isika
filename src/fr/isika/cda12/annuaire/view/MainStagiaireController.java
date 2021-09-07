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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MainStagiaireController implements Initializable {

	@FXML
	private Button btnSimpleSearch;

	@FXML
	private Button btnAdvSearch;

	@FXML
	private Button btnPrint;

	@FXML
	private Button btnDeco;

	@FXML
	private TableView<Personne> tvStagiaire;

	@FXML
	private TableColumn<Personne, String> colNom;

	@FXML
	private TableColumn<Personne, String> colPrenom;

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
	private void handleButtonAction(ActionEvent event) throws IOException {

		if (event.getSource() == btnSimpleSearch) {

			Parent simpleSearch_parent = FXMLLoader.load(getClass().getResource("SimpleSearchStagiaire.fxml"));
			Scene simpleSearch_scene = new Scene(simpleSearch_parent);
			Stage ms_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			ms_stage.hide();
			ms_stage.setScene(simpleSearch_scene);
			ms_stage.show();
		} else if (event.getSource() == btnAdvSearch) {
			Parent advSearch_parent = FXMLLoader.load(getClass().getResource("AdvSearchStagiaire.fxml"));
			Scene advSearch_scene = new Scene(advSearch_parent);
			Stage ms_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			ms_stage.hide();
			ms_stage.setScene(advSearch_scene);
			ms_stage.show();
		} else if (event.getSource() == btnDeco){
			deconnecter();
			Parent hp_parent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
			Scene hp_scene = new Scene (hp_parent);
			Stage ms_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			ms_stage.hide();
			ms_stage.setScene(hp_scene);
			ms_stage.show();
		} else if (event.getSource() == btnPrint){
			imprimer();
		} else {
			System.out.println("veuillez réessayer");
		}
		
	}

	private void deconnecter() {
		// TODO Auto-generated method stub
		
	}

	private void imprimer() {
		final PrinterJob printerjob = PrinterJob.createPrinterJob();
		if (printerjob.showPrintDialog(tvStagiaire.getScene().getWindow())) {
			if(printerjob.printPage(tvStagiaire)) {
				printerjob.endJob();
			}
		}
	}

	public ObservableList<Personne> getStagiaires() {

		ObservableList<Personne> stagiaireListe = FXCollections.observableArrayList();

		Arbre arbre;
		try {
			arbre = new Arbre("assets/noms.txt", "Nom");
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
			List<Personne> list = this.getStagiaires();

			// colPrenom.setCellValueFactory(list);
			colPrenom.setCellValueFactory(new PropertyValueFactory<Personne, String>("prenom"));

			colNom.setCellValueFactory(new PropertyValueFactory<Personne, String>("nom"));

			tvStagiaire.getItems().clear();
			tvStagiaire.getItems().addAll(list);

		} catch (NullPointerException e) {
			System.err.println("Error" + e);
		}
	}

}
