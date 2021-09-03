package fr.isika.cda12;

import javafx.collections.ObservableList;

public class Administrateur extends Personne {

	public Administrateur(String nom, String prenom) {
		super(nom, prenom);
	}
	
	// méthodes : ajouter étudiant _ mettre à jour étudiant _ supprimer étudiant _ création annuaire étudiant
	
	
	
	public void ajoutEt(String prenom, Arbre arbre, ObservableList<String> liste) {
		arbre.ajouter(prenom);
		arbre.afficherArbre(liste);
	}
	
	public void supprimerEt(String prenom, Arbre arbre, ObservableList<String> liste) {
		arbre.supprimer(prenom);
		arbre.afficherArbre(liste);
	}

	public void modifierEt(String exPrenom, String newPrenom, Arbre arbre, ObservableList<String> liste) {
		arbre.modifier(exPrenom, newPrenom);
		arbre.afficherArbre(liste);
	}
	

}
