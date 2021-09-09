package fr.isika.cda12.annuaire.view;

import fr.isika.cda12.annuaire.model.Stagiaire;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StagiaireEditDialogController {
	
	  	@FXML
	    private TextField nomField;
	  	
	    @FXML
	    private TextField prenomField;
	    
	    @FXML
	    private TextField telField;
	    
	    @FXML
	    private TextField emailField;
	    
	    @FXML
	    private TextField adresseField;
	    
	    @FXML
	    private TextField villeField;
	    
	    @FXML
	    private TextField codePostalField;
	    
	    @FXML
	    private TextField birthdayField;


	    private Stage dialogStage;
	    private Stagiaire trainee;
	    private boolean okClicked = false;

	    @FXML
	    private void initialize() {
	    }
	    
	    public void setDialogStage(Stage dialogStage) {
	        this.dialogStage = dialogStage;
	    }
	    
	    public void setStagiaire(Stagiaire trainee) {
	        this.trainee = trainee;

	        nomField.setText(trainee.getNom());
	        prenomField.setText(trainee.getPrenom());
	        telField.setText(trainee.getTel());
	        emailField.setText(trainee.getEmail());
	        adresseField.setText(trainee.getAdresse());
	        villeField.setText(trainee.getVille());
	        codePostalField.setText(trainee.getCodePostal());
	        birthdayField.setText(trainee.getBirthday());
	        
	    }
	    
	    public boolean isOkClicked() {
	        return okClicked;
	    }
	    
	    @FXML
	    private void handleOk() {
	        if (isInputValid()) {
	            trainee.setNom(nomField.getText());
	            trainee.setPrenom(prenomField.getText());
	            trainee.setTel(telField.getText());
	            trainee.setEmail(emailField.getText());
	            trainee.setAdresse(adresseField.getText());
	            trainee.setVille(villeField.getText());
	            trainee.setCodePostal(codePostalField.getText());
	            trainee.setBirthday(birthdayField.getText());

	            okClicked = true;
	            dialogStage.close();
	        }
	    }
	    
	    @FXML
	    private void handleCancel() {
	        dialogStage.close();
	    }
	    
	    private boolean isInputValid() {
	        String errorMessage = "";

	        if (nomField.getText() == null || nomField.getText().length() == 0) {
	            errorMessage += "Nom invalide!\n";
	        }
	        if (prenomField.getText() == null || prenomField.getText().length() == 0) {
	            errorMessage += "Prénom invalide!\n";
	        }
	        if (telField.getText() == null || telField.getText().length() == 0) {
	            errorMessage += "Téléphone invalide!\n";
	        }
	        if (emailField.getText() == null || emailField.getText().length() == 0) {
	            errorMessage += "Email invalide!\n";
	        }
	        if (adresseField.getText() == null || adresseField.getText().length() == 0) {
	            errorMessage += "Adresse invalide!\n";
	        }
	        if (villeField.getText() == null || villeField.getText().length() == 0) {
	            errorMessage += "Ville invalide!\n";
	        }
	        if (codePostalField.getText() == null || codePostalField.getText().length() == 0) {
	            errorMessage += "Code postal invalide!\n";
	        }
	        if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
	            errorMessage += "Date de naissance invalide! Utiliser le format dd.mm.yyyy\n";
	        }
	        
//	        if (postalCodeField.getText() == null || postalCodeField.getText().length() == 0) {
//	            errorMessage += "No valid postal code!\n";
//	        } else {
//	            // try to parse the postal code into an int.
//	            try {
//	                Integer.parseInt(postalCodeField.getText());
//	            } catch (NumberFormatException e) {
//	                errorMessage += "No valid postal code (must be an integer)!\n";
//	            }
//	        }

	        

//	        if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
//	            errorMessage += "No valid birthday!\n";
//	        } else {
//	            if (!DateUtil.validDate(birthdayField.getText())) {
//	                errorMessage += "No valid birthday. Use the format dd.mm.yyyy!\n";
//	            }
//	        }

	        if (errorMessage.length() == 0) {
	            return true;
	        } else {
	            // Show the error message.
	            Alert alert = new Alert(AlertType.ERROR);
	            alert.initOwner(dialogStage);
	            alert.setTitle("Champs invalides");
	            alert.setHeaderText("Veuillez corriger les champs invalides");
	            alert.setContentText(errorMessage);

	            alert.showAndWait();

	            return false;
	        }
	    }
}
