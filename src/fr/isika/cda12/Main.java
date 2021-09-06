package fr.isika.cda12;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Main {

	public static void main(String[] args) {
		try {
			ObservableList<String> liste = FXCollections.observableArrayList();
			Arbre arbre = new Arbre("assets/noms.txt");
			//arbre.afficherArbre(liste);
			//arbre.ajouter("Justinien");
			//arbre.afficherArbre(liste);
			//System.out.println(arbre.rechercher_liste("in"));
			
//			Administrateur admin = new Administrateur("Martin", "Jean");
//			
//			admin.ajoutEt("Walter", arbre, liste);
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
