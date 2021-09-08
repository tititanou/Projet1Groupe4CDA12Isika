package fr.isika.cda12;

import fr.isika.cda12.annuaire.model.Personne;
import javafx.collections.ObservableList;

public class Administrateur extends Personne{
	
	public Administrateur(String nom, String prenom, String mdp) {
		super(nom, prenom, mdp);
	}
	
	// méthodes : ajouter étudiant _ mettre à jour étudiant _ supprimer étudiant _ création annuaire étudiant

	/**
	 * @param nom
	 * @param prenom
	 * @param mdp
	 

	public void ajoutEt(String prenom, Arbre arbre, ObservableList<Stagiaire> liste) {
		arbre.ajouter(prenom);
		arbre.afficherArbre(liste);
	}
	
	public void supprimerEt(String prenom, Arbre arbre, ObservableList<Stagiaire> liste) {
		arbre.supprimer(prenom);
		arbre.afficherArbre(liste);
	}

	public void modifierEt(String exPrenom, String newPrenom, Arbre arbre, ObservableList<String> liste) {
		arbre.modifier(exPrenom, newPrenom);
		arbre.afficherArbre(liste);
	}*/
	

}
