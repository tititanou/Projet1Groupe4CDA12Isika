package fr.isika.cda12.annuaire.view;

import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.isika.cda12.annuaire.model.FileManager;
import fr.isika.cda12.annuaire.model.Personne;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MainInscriptionController implements Initializable {

	@FXML
	private TextField tfPrenom;

	@FXML
	private TextField tfNom;

	@FXML
	private TextField tfIdent;

	@FXML
	private TextField tfMotDePasse;

	@FXML
	private TextField tfMotDePasse2;

	@FXML
	private Button btnBack;

	@FXML
	private Button btnValidate;

	List<Personne> usersList = new ArrayList<>();

	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException {

		if (event.getSource() == btnBack) {
			Parent homePage_parent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
			Scene homePage_scene = new Scene(homePage_parent);
			Stage inscr_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			inscr_stage.hide();
			inscr_stage.setScene(homePage_scene);
			inscr_stage.show();

		} else if (event.getSource() == btnValidate) {
			// System.out.println(tfNom.getText() + tfPrenom.getText());

			boolean resultat = Personne.creerCompte(tfNom.getText(), tfPrenom.getText(), tfMotDePasse.getText(),
					tfMotDePasse2.getText());

			if (resultat == true) {
				Personne person = new Personne(tfNom.getText(), tfPrenom.getText(), tfMotDePasse.getText());

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information");
				alert.setHeaderText("Identifiant");
				alert.setContentText("Votre identifiant est : " + person.getId());
				alert.showAndWait();

				try {
					Thread.sleep(1000);
					alert.close();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				FileManager.updateFile("usersFile", "person," + person.toString());

				FXMLLoader loader = new FXMLLoader(getClass().getResource("MainStagiaire.fxml"));
				Parent mainStagiaire_parent = loader.load();
				MainStagiaireController controller = loader.getController();
				controller.transferUser(person);
				Scene mainStagiaire_scene = new Scene(mainStagiaire_parent);
				mainStagiaire_scene.setUserData(mainStagiaire_scene);
				Stage inscr_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				inscr_stage.hide();
				inscr_stage.setScene(mainStagiaire_scene);
				inscr_stage.show();

			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Erreur MdP");
				alert.setContentText("Les mots de passe ne correspondent pas!");
			}

		} else {
			System.out.println("veuillez réessayer");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		FileManager.readFile("usersFile", usersList);
	}

}
