package fr.isika.cda12.annuaire.model;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.collections.ObservableList;

public class Arbre {
	
	private Noeud racine;

	// public Arbre() {}

	public Arbre(String fileName, String critere) throws IOException {
		construire(fileName, critere);
	}

	public void ajouter(Stagiaire trainee, String critere) {
		if(critere.equals("Nom")) {
			racine = ajouterParNom(racine, trainee);
			//System.out.println(critere);
		}
		else if(critere.equals("Prénom")) {
			racine = ajouterParPrenom(racine, trainee);

		}
		
	}
	
	public Noeud ajouterParNom(Noeud rac, Stagiaire trainee) {
		if (rac == null) {
			Noeud nouveau = new Noeud(trainee);
			return nouveau;
		}
		if (trainee.getNom().compareTo(rac.getTrainee().getNom()) < 0) {
			rac.setFg(ajouterParNom(rac.getFg(), trainee));
		}
		else if (trainee.getNom().compareTo(rac.getTrainee().getNom()) == 0) {
			rac.setNbOcc(rac.getNbOcc() + 1);
		}
		else {
			rac.setFd(ajouterParNom(rac.getFd(), trainee));
		}
		
		return rac;
	}
	
	public Noeud ajouterParPrenom(Noeud rac, Stagiaire trainee) {
		if (rac == null) {
			Noeud nouveau = new Noeud(trainee);
			return nouveau;
		}
		if (trainee.getPrenom().compareTo(rac.getTrainee().getPrenom()) < 0) {
			rac.setFg(ajouterParPrenom(rac.getFg(), trainee));
		}
		else if (trainee.getPrenom().compareTo(rac.getTrainee().getPrenom()) == 0) {
			rac.setNbOcc(rac.getNbOcc() + 1);
		}
		else {
			rac.setFd(ajouterParPrenom(rac.getFd(), trainee));
		}
		return rac;
	}


	public void construire(String nomFichier, String critere) throws IOException {
		Scanner lecteur = new Scanner(new File(nomFichier));

		while (lecteur.hasNext()) {
			String[] splits = lecteur.next().split(",");
			String prenom = splits[0];
			String nom = "";
			if(splits[1] != null) {
				nom = splits[1];
			}
			String id = System.currentTimeMillis() + prenom + nom;
			Stagiaire trainee = new Stagiaire(nom, prenom, id);
			// System.out.println(trainee.getNom() + " " + trainee.getPrenom());
			this.ajouter(trainee, critere);
		}
	}

	public int hauteur() {
		return hauteur(racine);
	}

	private int hauteur(Noeud rac) {
		if (rac == null)
			return -1;
		int hg = hauteur(rac.getFg());
		int hd = hauteur(rac.getFd());
		if (hg < hd)
			return hd + 1;
		return hg + 1;
	}

	public void ecrireListeTriee() {
		ecrireListeTriee(racine);
	}

	public void ecrireListeTriee(Noeud rac) {
		if (rac != null) {
			ecrireListeTriee(rac.getFg());
			System.out.println(rac.getTrainee() + " (" + rac.getNbOcc() + " fois)");
			ecrireListeTriee(rac.getFd());
		}
	}

	public void afficherArbre(ObservableList<Stagiaire> liste) {
		System.out.println("Affichage de l'arbre :\n\n");
		afficherNoeud(racine, 0, hauteur(), liste);
		System.out.println();
	}

	public void afficherNoeud(Noeud currentNoeud, int currentLevel, int maxLevel, ObservableList<Stagiaire> liste) {

		if (currentNoeud != null) {
			afficherNoeud(currentNoeud.getFg(), currentLevel + 1, maxLevel, liste);
			for (int i = 0; i < (maxLevel - currentLevel - 1); i++) {
				// System.out.print(" ");
			}
			liste.add(currentNoeud.getTrainee());
			System.out.println(currentNoeud.getTrainee());
			afficherNoeud(currentNoeud.getFd(), currentLevel + 1, maxLevel, liste);
		} else {
			if (currentLevel < maxLevel) {
				afficherNoeud(null, currentLevel + 1, maxLevel, liste);
				// System.out.println("");
				afficherNoeud(null, currentLevel + 1, maxLevel, liste);
			}
		}
	}

	public Noeud successeur(Noeud currentNoeud) {
		currentNoeud = currentNoeud.getFd();
		while (currentNoeud.getFg() != null) {
			currentNoeud = currentNoeud.getFg();
		}
		return currentNoeud;
	}

	public Noeud predecesseur(Noeud currentNoeud) {
		currentNoeud = currentNoeud.getFd();
		while (currentNoeud.getFg() != null) {
			currentNoeud = currentNoeud.getFg();
		}
		return currentNoeud;
	}

	public void supprimer(Stagiaire trainee) {
		racine = supprimer(racine, trainee);
	}

	public Noeud supprimer(Noeud currentNoeud, Stagiaire trainee) {
		if (currentNoeud == null)
			return currentNoeud;
		if (currentNoeud.getTrainee().getId().compareTo(trainee.getId()) == 0) {
			return supprimerRacine(currentNoeud);
		}
		if (currentNoeud.getTrainee().getId().compareTo(trainee.getId()) > 0) {
			currentNoeud.setFg(supprimer(currentNoeud.getFg(), trainee));
		}
		if (currentNoeud.getTrainee().getId().compareTo(trainee.getId()) < 0) {
			currentNoeud.setFd(supprimer(currentNoeud.getFd(), trainee));
		}
		return currentNoeud;
	}

	public Noeud supprimerRacine(Noeud currentNoeud) {

		if (currentNoeud.getFg() == null && currentNoeud.getFd() == null) {
			System.out.println("");
			return null;
		} else if (currentNoeud.getFg() != null && currentNoeud.getFd() == null)
			return currentNoeud.getFg();
		else if (currentNoeud.getFg() == null && currentNoeud.getFd() != null)
			return currentNoeud.getFd();
		else {
			currentNoeud.setTrainee(successeur(currentNoeud).getTrainee());
			currentNoeud.setFd(supprimer(currentNoeud.getFd(), currentNoeud.getTrainee()));
			return currentNoeud;
		}

	}

	public void modifier(Stagiaire exTrainee, Stagiaire newTrainee) {
		this.supprimer(exTrainee);
		this.ajouter(newTrainee, "Nom");
	}

	public List<Stagiaire> rechercher_liste(String selec, String valeur) {
		List<Stagiaire> listeRetour = new ArrayList<Stagiaire>();
		return rechercher_liste_annexe(listeRetour, racine, selec, valeur);
	}

	public List<Stagiaire> rechercher_liste_annexe(List<Stagiaire> listRetour, Noeud currentNoeud, String selec,
			String valeur) {

		if (selec.equals("nom")) {
			if (currentNoeud == null)
				return listRetour;
			else if (currentNoeud.getTrainee().getNom().compareTo(valeur) == 0) {
				listRetour.add(currentNoeud.getTrainee());
				rechercher_liste_annexe(listRetour, currentNoeud.getFd(), selec, valeur);
				return listRetour;
			} else if (currentNoeud.getTrainee().getNom().compareTo(valeur) > 0) {
				return rechercher_liste_annexe(listRetour, currentNoeud.getFg(), selec, valeur);
			} else {
				return rechercher_liste_annexe(listRetour, currentNoeud.getFd(), selec, valeur);
			}
		}
		else if (selec.equals("prenom")) {
			if (currentNoeud == null)
				return listRetour;
			else if (currentNoeud.getTrainee().getPrenom().compareTo(valeur) == 0) {
				listRetour.add(currentNoeud.getTrainee());
				rechercher_liste_annexe(listRetour, currentNoeud.getFd(), selec, valeur);
				return listRetour;
			} else if (currentNoeud.getTrainee().getPrenom().compareTo(valeur) > 0) {
				return rechercher_liste_annexe(listRetour, currentNoeud.getFg(), selec, valeur);
			} else {
				return rechercher_liste_annexe(listRetour, currentNoeud.getFd(), selec, valeur);
			}
		}
		else return null;

	}

}
