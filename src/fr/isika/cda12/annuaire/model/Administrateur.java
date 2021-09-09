package fr.isika.cda12.annuaire.model;

import fr.isika.cda12.Arbre;
import javafx.collections.ObservableList;

public class Administrateur extends Personne {

	
	public Administrateur(String nom, String prenom, String mdp) {
		super(nom, prenom, mdp);
	}

	public void ajouterStagiaire(Stagiaire trainee, Arbre arbre, ObservableList<Stagiaire> liste) {
		arbre.ajouter(trainee, "Nom");
		arbre.afficherArbre(liste);
		FileManager.updateStudents(liste);
	}
	
	public void supprimerStagiaire(Stagiaire trainee, Arbre arbre, ObservableList<Stagiaire> liste) {
		arbre.supprimer(trainee);
		arbre.afficherArbre(liste);
	}

	public void modifierStagiaire(Stagiaire exTrainee, Stagiaire newTrainee, Arbre1 arbre, ObservableList<Stagiaire> liste) {
		arbre.modifier(exTrainee, newTrainee);
		arbre.afficherArbre(liste);
	}

}
