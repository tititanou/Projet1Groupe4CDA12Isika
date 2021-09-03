package fr.isika.cda12;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javafx.collections.ObservableList;

public class Arbre {
	private Noeud racine;

	// public Arbre() {}

	public Arbre(String fileName) throws IOException {
		construire(fileName);
	}

	public void ajouter(String mot) {
		racine = ajouter(racine, mot);
	}

	public Noeud ajouter(Noeud rac, String mot) {
		if (rac == null) {
			Noeud nouveau = new Noeud(mot);
			return nouveau;
		}
		if (mot.compareTo(rac.getMot()) < 0)
			rac.setFg(ajouter(rac.getFg(), mot));
		else if (mot.compareTo(rac.getMot()) == 0)
			rac.setNbOcc(rac.getNbOcc() + 1);
		else
			rac.setFd(ajouter(rac.getFd(), mot));
		return rac;
	}

	public void construire(String nomFichier) throws IOException {
		Scanner lecteur = new Scanner(new File(nomFichier));

		while (lecteur.hasNext())
			ajouter(lecteur.next());
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
			System.out.println(rac.getMot() + " (" + rac.getNbOcc() + " fois)");
			ecrireListeTriee(rac.getFd());
		}
	}

	public void afficherArbre(ObservableList<String> liste) {
		System.out.println("Affichage de l'arbre :\n\n");
		afficherNoeud(racine, 0, hauteur(), liste);
		System.out.println();
	}

	public void afficherNoeud(Noeud currentNoeud, int currentLevel, int maxLevel, ObservableList<String> liste) {

		if (currentNoeud != null) {
			afficherNoeud(currentNoeud.getFg(), currentLevel + 1, maxLevel, liste);
			for (int i = 0; i < (maxLevel - currentLevel - 1); i++) {
				// System.out.print(" ");
			}
			liste.add(currentNoeud.getMot());
			System.out.println(currentNoeud.getMot());
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

	public void supprimer(String mot) {
		racine = supprimer(racine, mot);
	}

	public Noeud supprimer(Noeud currentNoeud, String mot) {
		if (currentNoeud == null)
			return currentNoeud;
		if (currentNoeud.getMot().compareTo(mot) == 0) {
			return supprimerRacine(currentNoeud);
		}
		if (currentNoeud.getMot().compareTo(mot) > 0) {
			currentNoeud.setFg(supprimer(currentNoeud.getFg(), mot));
		}
		if (currentNoeud.getMot().compareTo(mot) < 0) {
			currentNoeud.setFd(supprimer(currentNoeud.getFd(), mot));
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
			currentNoeud.setMot(successeur(currentNoeud).getMot());
			currentNoeud.setFd(supprimer(currentNoeud.getFd(), currentNoeud.getMot()));
			return currentNoeud;
		}

	}
	
	public void modifier(String exValeur, String newValeur) {
		this.supprimer(exValeur);
		this.ajouter(newValeur);
	}

}
