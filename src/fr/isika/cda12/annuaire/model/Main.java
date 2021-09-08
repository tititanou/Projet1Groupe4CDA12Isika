package fr.isika.cda12.annuaire.model;

import java.io.IOException;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Main {

	public static void main(String[] args) {
		try {
			ObservableList<Stagiaire> liste = FXCollections.observableArrayList();
			Arbre arbre = new Arbre("assets/noms.txt", "Nom");
			
			//arbre.afficherArbre(liste);
			//arbre.ajouter("Justinien");
			//arbre.afficherArbre(liste);
			//System.out.println(arbre.rechercher_liste("in"));
			
			Administrateur admin = new Administrateur("Martin", "Jean", "yo");
			
			Stagiaire trainee1 = new Stagiaire ("Zorro", "Zack");
			
			admin.ajouterStagiaire(trainee1, arbre, liste);
			
//			
//			admin.ajoutEt("Zoé", arbre, liste);
//			
//			admin.supprimerEt("Walter", arbre, liste);
//			
//			admin.modifierEt("Zoé", "Zakaria", arbre, liste);
			
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
