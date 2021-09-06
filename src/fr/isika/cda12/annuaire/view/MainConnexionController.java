package fr.isika.cda12.annuaire.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainConnexionController implements Initializable {
	
	@FXML
	private Button btnBack;
	
	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException {
		
		if (event.getSource() == btnBack) {
			Parent homePage_parent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
			Scene homePage_scene = new Scene (homePage_parent);
			Stage con_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			con_stage.hide();
			con_stage.setScene(homePage_scene);
			con_stage.show();
		}  else {
			System.out.println("veuillez réessayer");
		}
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
