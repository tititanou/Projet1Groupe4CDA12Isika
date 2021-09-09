package fr.isika.cda12;

import java.io.IOException;

import fr.isika.cda12.annuaire.model.Arbre1;
import fr.isika.cda12.annuaire.model.FileManager;
import fr.isika.cda12.annuaire.model.Stagiaire;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Main {

	public static void main(String[] args) {
		/*
		 * try { ObservableList<Stagiaire> liste = FXCollections.observableArrayList();
		 * Arbre arbre = new Arbre("assets/noms.txt","Nom"); //Arbre1 tree = new
		 * Arbre1("assets/noms.txt"," Nom"); arbre.afficherArbre(liste);
		 * //tree.afficherArbre(liste); Stagiaire nouveau = new Stagiaire("Alvaro",
		 * "rojas"); arbre.ajouter(nouveau, "Nom"); Stagiaire azert = new
		 * Stagiaire("Ball", "rojas"); arbre.ajouterValeur(azert);
		 * arbre.afficherArbre(liste); FileManager.updateFile("assets/noms.txt",
		 * nouveau.toString()); //arbre.ajouter("Justinien");
		 * //arbre.afficherArbre(liste);
		 * //System.out.println(arbre.rechercher_liste("in"));
		 * 
		 * // Administrateur admin = new Administrateur("Martin", "Jean"); // //
		 * admin.ajoutEt("Walter", arbre, liste); // // admin.ajoutEt("Zoé", arbre,
		 * liste); // // admin.supprimerEt("Walter", arbre, liste); // //
		 * admin.modifierEt("Zoé", "Zakaria", arbre, liste);
		 * 
		 * 
		 * } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		
		FileManager.initStudents();

		
	}

}
