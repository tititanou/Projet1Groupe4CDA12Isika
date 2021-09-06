package fr.isika.cda12.annuaire.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.isika.cda12.Noeud;
import fr.isika.cda12.Personne;
import javafx.collections.ObservableList;

public class Arbre {
	
	private Noeud racine;

	// public Arbre() {}

	public Arbre(String fileName) throws IOException {
		construire(fileName);
	}

	public void ajouter(Personne person) {
		racine = ajouter(racine, person);
	}

	public Noeud ajouter(Noeud rac, Personne person) {
		if (rac == null) {
			Noeud nouveau = new Noeud(person);
			return nouveau;
		}
		if (person.getNom().compareTo(rac.getPerson().getNom()) < 0) {
			rac.setFg(ajouter(rac.getFg(), person));
		}
		else if (person.getNom().compareTo(rac.getPerson().getNom()) == 0) {
			rac.setNbOcc(rac.getNbOcc() + 1);
		}
		else {
			rac.setFd(ajouter(rac.getFd(), person));
		}
		return rac;
	}

	public void construire(String nomFichier) throws IOException {
		Scanner lecteur = new Scanner(new File(nomFichier));

		while (lecteur.hasNext()) {
			String[] splits = lecteur.next().split(",");
			String prenom = splits[0];
			String nom = "";
			if(splits[1] != null) {
				nom = splits[1];
			}
			String id = System.currentTimeMillis() + prenom + nom;
			Personne person = new Personne(nom, prenom, id);
			System.out.println(person.getNom() + " " + person.getPrenom());
			this.ajouter(person);
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
			System.out.println(rac.getPerson() + " (" + rac.getNbOcc() + " fois)");
			ecrireListeTriee(rac.getFd());
		}
	}

	public void afficherArbre(ObservableList<Personne> liste) {
		System.out.println("Affichage de l'arbre :\n\n");
		afficherNoeud(racine, 0, hauteur(), liste);
		System.out.println();
	}

	public void afficherNoeud(Noeud currentNoeud, int currentLevel, int maxLevel, ObservableList<Personne> liste) {

		if (currentNoeud != null) {
			afficherNoeud(currentNoeud.getFg(), currentLevel + 1, maxLevel, liste);
			for (int i = 0; i < (maxLevel - currentLevel - 1); i++) {
				// System.out.print(" ");
			}
			liste.add(currentNoeud.getPerson());
			System.out.println(currentNoeud.getPerson());
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

	public void supprimer(Personne person) {
		racine = supprimer(racine, person);
	}

	public Noeud supprimer(Noeud currentNoeud, Personne person) {
		if (currentNoeud == null)
			return currentNoeud;
		if (currentNoeud.getPerson().getId().compareTo(person.getId()) == 0) {
			return supprimerRacine(currentNoeud);
		}
		if (currentNoeud.getPerson().getId().compareTo(person.getId()) > 0) {
			currentNoeud.setFg(supprimer(currentNoeud.getFg(), person));
		}
		if (currentNoeud.getPerson().getId().compareTo(person.getId()) < 0) {
			currentNoeud.setFd(supprimer(currentNoeud.getFd(), person));
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
			currentNoeud.setPerson(successeur(currentNoeud).getPerson());
			currentNoeud.setFd(supprimer(currentNoeud.getFd(), currentNoeud.getPerson()));
			return currentNoeud;
		}

	}

	public void modifier(Personne exPerson, Personne newPerson) {
		this.supprimer(exPerson);
		this.ajouter(newPerson);
	}

	public List<Personne> rechercher_liste(String selec, String valeur) {
		List<Personne> listeRetour = new ArrayList<Personne>();
		return rechercher_liste_annexe(listeRetour, racine, selec, valeur);
	}

	public List<Personne> rechercher_liste_annexe(List<Personne> listRetour, Noeud currentNoeud, String selec,
			String valeur) {

		if (selec.equals("nom")) {
			if (currentNoeud == null)
				return listRetour;
			else if (currentNoeud.getPerson().getNom().compareTo(valeur) == 0) {
				listRetour.add(currentNoeud.getPerson());
				rechercher_liste_annexe(listRetour, currentNoeud.getFd(), selec, valeur);
				return listRetour;
			} else if (currentNoeud.getPerson().getNom().compareTo(valeur) > 0) {
				return rechercher_liste_annexe(listRetour, currentNoeud.getFg(), selec, valeur);
			} else {
				return rechercher_liste_annexe(listRetour, currentNoeud.getFd(), selec, valeur);
			}
		}
		else if (selec.equals("prenom")) {
			if (currentNoeud == null)
				return listRetour;
			else if (currentNoeud.getPerson().getPrenom().compareTo(valeur) == 0) {
				listRetour.add(currentNoeud.getPerson());
				rechercher_liste_annexe(listRetour, currentNoeud.getFd(), selec, valeur);
				return listRetour;
			} else if (currentNoeud.getPerson().getPrenom().compareTo(valeur) > 0) {
				return rechercher_liste_annexe(listRetour, currentNoeud.getFg(), selec, valeur);
			} else {
				return rechercher_liste_annexe(listRetour, currentNoeud.getFd(), selec, valeur);
			}
		}
		else return null;

	}

}
