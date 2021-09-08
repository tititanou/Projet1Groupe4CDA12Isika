package fr.isika.cda12.annuaire.view;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.isika.cda12.Administrateur;
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

public class MainConnexionController implements Initializable {
	
	@FXML
	private Button btnBack;
	
	@FXML
	private Button btnValidate;
	
	@FXML
	private TextField tfId;
	
	@FXML
	private TextField tfMdp;
	
	List<Personne> usersList =new ArrayList<>();
	
	Personne user;
	
	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException {
		
		if (event.getSource() == btnBack) {
			Parent homePage_parent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
			Scene homePage_scene = new Scene (homePage_parent);
			Stage con_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			con_stage.hide();
			con_stage.setScene(homePage_scene);
			con_stage.show();
		}  else if (event.getSource() == btnValidate) {
			
			FXMLLoader loader;
			String id = tfId.getText();
			String mdp = tfMdp.getText();
			System.out.println(id + " " + mdp);
			if(verifUser(id, mdp)) {
				Administrateur admin = new Administrateur("bla", "bla", "bla");
				System.out.println(user.getClass());
				System.out.println(admin.getClass());
				if(user.getClass().equals(admin.getClass())) {
					System.out.println(user);
					loader = new FXMLLoader(getClass().getResource("Administrateur.fxml"));
					Parent main_parent = loader.load();
					MainAdministrateurController controller = loader.getController();
					controller.transferUser(user);
					Scene main_scene = new Scene(main_parent);
					main_scene.setUserData(main_scene);
					Stage connexion_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					connexion_stage.hide();
					connexion_stage.setScene(main_scene);
					connexion_stage.show();
				}
				else {
					loader = new FXMLLoader(getClass().getResource("MainStagiaire.fxml"));
					Parent main_parent = loader.load();
					MainStagiaireController controller = loader.getController();
					controller.transferUser(user);
					Scene main_scene = new Scene(main_parent);
					main_scene.setUserData(main_scene);
					Stage connexion_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					connexion_stage.hide();
					connexion_stage.setScene(main_scene);
					connexion_stage.show();
				}
				//Parent main_parent = loader.load();
				/*Scene main_scene = new Scene(main_parent);
				main_scene.setUserData(main_scene);
				Stage connexion_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				connexion_stage.hide();
				connexion_stage.setScene(main_scene);
				connexion_stage.show();*/
			};
			// System.out.println(tfNom.getText() + tfPrenom.getText());

			/*boolean resultat = Personne.creerCompte(tfNom.getText(), tfPrenom.getText(), tfMotDePasse.getText(),
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
			}*/

		}  else {
			System.out.println("veuillez réessayer");
		}
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	
	public Boolean verifUser(String id, String mdp) {
		Boolean connected = false;
		FileManager.readFile("usersFile", usersList);
		for(Personne usr :usersList) {
			System.out.println(usr);
			if (usr.getId().equals(id)) {
				if(usr.getMdp().equals(mdp)) {
					System.out.println("connexion");
					this.user = usr;
					return true;
				}else {
					connected = false;
				}
			}else {
				connected = false;
			}
		}
		return connected;
		
	}

}
