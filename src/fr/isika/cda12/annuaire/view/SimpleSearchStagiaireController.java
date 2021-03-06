package fr.isika.cda12.annuaire.view;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import fr.isika.cda12.Arbre;
import fr.isika.cda12.annuaire.model.Arbre1;
import fr.isika.cda12.annuaire.model.Personne;
import fr.isika.cda12.annuaire.model.Stagiaire;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class SimpleSearchStagiaireController implements Initializable {
	Personne user;

	@FXML
	ComboBox<String> comBoxCriteres;

	@FXML
	TextField tfSearchSt;

	@FXML
	Button btnSearch;

	@FXML
	Button btnPrint;

	@FXML
	TableView<Stagiaire> tvStagiaire;

	@FXML
	TableColumn<Stagiaire, String> colPrenom;

	@FXML
	TableColumn<Stagiaire, String> colNom;

	File fileStudents;

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
			List<Stagiaire> students = rechercher();
			
			afficherStagiaire(students);
			fileStudents = prePrint(students);
		} else if (event.getSource() == btnPrint) {
			if (fileStudents != null) {
				imprimer(fileStudents);
			} else {
				System.out.println("coucou");
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Echec d'impression");
				alert.setContentText("Le fichier n'existe pas");
			}
		}
	}

	private List<Stagiaire> rechercher() {
		List<Stagiaire> stagiaireListe = new ArrayList<>();
		String critere = comBoxCriteres.getValue();
		System.out.println(critere);
		String valeur = tfSearchSt.getText();
		Arbre1 arbre;
		try {
			arbre = new Arbre1("assets/noms.txt", critere);
			arbre.rechercher_liste(critere, valeur, stagiaireListe);
			System.out.println(stagiaireListe.size());
			return stagiaireListe;
		} catch (IOException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Echec de la lecture du fichier");
			alert.setContentText("Un problème est survenu avec le fichier!");
			e.printStackTrace();
			return null;
		}
	}

	public void afficherStagiaire(List<Stagiaire> list) {
		try {

			colPrenom.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("prenom"));

			colNom.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("nom"));

			tvStagiaire.getItems().clear();
			tvStagiaire.getItems().addAll(list);

		} catch (NullPointerException e) {
			System.err.println("Error" + e);
		}
	}

	private void imprimer(File file) {
		try {
			java.awt.Desktop.getDesktop().print(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private File prePrint(List<Stagiaire> list) {

		String fileName = "Liste d'étudiants " + System.currentTimeMillis();
		File file = new File(fileName);
		try {
			file.createNewFile();

			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			for (Stagiaire person : list) {
				bw.write("Nom: " + person.getNom() + "\nPrénom: " + person.getPrenom()
						+ "\n-------------------------------------------------\n");
			}
			bw.close();
			return file;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}
	public void transferUser(Personne user) {
		this.user = user;
		System.out.println(user.toString());
	}

}
