package application;

import java.io.IOException;
import java.net.URL;


import java.util.List;
import java.util.ResourceBundle;

import fr.isika.cda12.Arbre;
import fr.isika.cda12.Personne;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
public class MainController implements Initializable {
	
	@FXML
	private TextField tfId;
	
	@FXML
	private TextField tfPrenom;
	
	@FXML
	private Button btnInsert;
	
	@FXML
	private Button btnUpdate;

	@FXML
	private Button btnDelete;
	
	@FXML
	private Button btnPrint;
	
	@FXML
	private TableView<Personne> tvStagiaire;
	
	@FXML
	private TableColumn<Personne, String> colNom;
	
	@FXML
	private TableColumn<Personne, String> colPrenom;
	

	
//	public Connection getConnexion() {
//		
//		Connection conn;
//		
//		try {
//			// connexion à la base de données mysql
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/annuaire?serverTimezone=UTC","root","");
//			return conn;
//		} catch (Exception ex) {
//			System.out.println("Error" + ex.getMessage());
//			return null;
//		}
//	}

	// on teste si on arrive à se connecter ou non
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Connection test = this.getConnexion();
		
		//if (test!=null)
		
//			Alert alert = new Alert(AlertType.INFORMATION);
//			alert.setTitle("Information");
//			alert.setHeaderText("Connexion à la base");
//			alert.setContentText("Connexion Reussi");
//			alert.showAndWait();
			afficherStagiaire();
			
//			try {
//				Thread.sleep(1000);
//				alert.close();
//			} catch (InterruptedException e) {
//				
//				e.printStackTrace();
//			}
		
		
//		else 
//		{
//		Alert errorAlert = new Alert(AlertType.ERROR);
//		errorAlert.setHeaderText("Connexion à la base");
//    	errorAlert.setContentText("Echec de connexion");
//    	errorAlert.show();
//    	try {
//			Thread.sleep(1000);
//			errorAlert.close();
//			Platform.exit();
//			
//		} catch (InterruptedException e) {
//		
//			e.printStackTrace();
//		}
//		
//	}
		
	}
	
	// méthode reliant le click sur boutons et action dans code
	@FXML
	private void handleButtonAction(ActionEvent event) {
		
		//System.out.println("test ok");
		
		if (event.getSource() == btnInsert) {
			
			ajouter();
			
		} else if (event.getSource() == btnUpdate) {
			
			miseAJour();
			
		} else if (event.getSource() == btnPrint) {
			
			imprimer();
			
		} else {
			
			supprimer();
		}
		afficherStagiaire();
	}
	
	// méthode pour afficher table view
//	public void afficherAnnuaire() {
//		try {
//			List<String> list = this.getStagiaires();
//			//System.out.println(list);
//			//colId.setCellValueFactory(new PropertyValueFactory<Stagiaire, Integer>("id"));
//			//System.out.println(colId);
//			colPrenom.setCellValueFactory(new PropertyValueFactory<String, String>("prenom"));
//			//System.out.println(colTitle);
//			
//			
//			tvStagiaire.getItems().clear();
//			tvStagiaire.getItems().addAll(list);
//			
//			
//		} catch (NullPointerException e) {
//			System.err.println("Error" + e);
//		}
//	}
	
	private void ajouter() {
		
//		String query = "INSERT INTO `stagiaire`(`id`, `prenom`) VALUES (" + tfId.getText() + ",'" + tfPrenom.getText() + "')";
//		
//		this.executeQuery(query);
//		Alert errorAlert = new Alert (AlertType.INFORMATION);
//		errorAlert.setHeaderText("La bibliothèque s'agrandit");
//    	errorAlert.setContentText("Ajout réussi");
//    	errorAlert.show();
		
	}
	
	private void miseAJour() {
		
		
//		// Requête sql
//		String query = "UPDATE `stagiaire` SET `id` =" + tfId.getText() + ",`prenom` ='" + tfPrenom.getText()+ "' WHERE id =" + tfId.getText() +"";
//		
//		// transforme la requête sql en objet querry
//		this.executeQuery(query);
		
	}
	
	private void supprimer() {
		 
//		 String query = "DELETE FROM `stagiaire` WHERE id = " + tfId.getText();
//		 
//		 this.executeQuery(query);
//		 
//			Alert alert = new Alert(AlertType.CONFIRMATION, "Vous êtes sûr de vouloir supprimer ce livre ?");
//			Optional<ButtonType> result = alert.showAndWait();
//			 if (result.isPresent() && result.get() == ButtonType.OK) {
//			     this.executeQuery(query);
//			     alert.show();
//					try {
//						Thread.sleep(3000);
//						alert.close();
//					} catch (InterruptedException e) {
//						
//						e.printStackTrace();
//					}
//			 } else {
//				 Platform.exit();
//			 }
//			 
//			 Alert alert2 = new Alert(AlertType.CONFIRMATION, "Votre livre a bien été supprimé");
//			 Optional<ButtonType> result2 = alert2.showAndWait();
//			 if (result2.isPresent() && result2.get() == ButtonType.OK) {
//			     this.executeQuery(query);
//			     alert2.show();
//					try {
//						Thread.sleep(3000);
//						alert2.close();
//					} catch (InterruptedException e) {
//						
//	
//						e.printStackTrace();
//					}
//			 } else {
//				 Platform.exit();
//			 }
	}
		 
	//private void executeQuery(String query) {
//	//Connection conn = this.getConnexion();
//	Statement st;
//					
//	try {
//		st = conn.createStatement();
//		st.executeUpdate(query);
//		} catch (Exception e) {
//			e.printStackTrace();
//			}
//	}
	
	// méthode qui met à jour automatiquement la collection
			public ObservableList<Personne> getStagiaires() {
				
				ObservableList<Personne> stagiaireListe = FXCollections.observableArrayList();
				
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
				
//				Connection conn = this.getConnexion();		// connection à la base
//				
//				String query = "SELECT * FROM stagiaire";
//				
//				Statement st;
//				ResultSet rs;		// les objets ne sont pas encore es objets Java
//				
//				try {
//					st = conn.createStatement();
//					rs = st.executeQuery(query);
//					
//					Stagiaire stagiaire;
//					
//					while (rs.next()) { 		// on récupère la base de données
//						stagiaire = new Stagiaire(rs.getInt("id"), rs.getString("prenom"));
//						
//						//System.out.println(livre);
						
//						stagiaireListe.add(stagiaire);
//					}
//					
//				} catch (Exception e) {
//					System.err.println("Error" + e);
//				}
				System.out.println(stagiaireListe);
				return stagiaireListe;
			}
			
			public void afficherStagiaire() {
				try {
					List<Personne> list = this.getStagiaires();
					//System.out.println(list);
					colNom.setCellValueFactory(new PropertyValueFactory<Personne, String>("nom"));
					//System.out.println(colId);
//					for (String stagiaire : list) {
//						System.out.println(stagiaire + " ok");
//					}
					colPrenom.setCellValueFactory(new PropertyValueFactory<Personne, String>("prenom"));
					//System.out.println(colPrenom);
					
					//colPrenom.getColumns().addAll(list<String>);
					
				
					//tvStagiaire.getColumns().add(colPrenom);
			
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
