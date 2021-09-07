package fr.isika.cda12.annuaire.model;

import javafx.collections.ObservableList;

public class Administrateur extends Personne {

	
	public Administrateur(String nom, String prenom, String mdp) {
		super(nom, prenom, mdp);
		// TODO Auto-generated constructor stub
	}

	public void ajouterStagiaire(Stagiaire trainee, Arbre arbre, ObservableList<Stagiaire> liste) {
		
		arbre.ajouter(trainee, trainee.getNom());
		arbre.afficherArbre(liste);
	}
	
	public void supprimerStagiaire(Stagiaire trainee, Arbre arbre, ObservableList<Stagiaire> liste) {
		arbre.supprimer(trainee);
		arbre.afficherArbre(liste);
	}

	public void modifierStagiaire(Stagiaire exTrainee, Stagiaire newTrainee, Arbre arbre, ObservableList<Stagiaire> liste) {
		arbre.modifier(exTrainee, newTrainee);
		arbre.afficherArbre(liste);
	}

}
