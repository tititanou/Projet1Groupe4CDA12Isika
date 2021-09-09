package fr.isika.cda12;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.isika.cda12.annuaire.model.Stagiaire;
import javafx.collections.ObservableList;

public class Arbre {
	private Noeud racine;

	// public Arbre() {}

	public Arbre(String fileName, String critere) throws IOException {
		this.racine = null;
		construire(fileName, critere);
	}

	public void ajouter(Stagiaire person, String critere) {
		if(critere.equals("Nom")) {
			this.racine = ajouterParNom(racine, person);
		}
		else if(critere.equals("Prénom")) {
			this.racine =  ajouterParPrenom(racine, person);
		}
		
	}

	public Noeud ajouterParNom(Noeud rac, Stagiaire person) {
		if (rac == null) {
			return new Noeud(person);
		}
		if (person.getNom().compareTo(rac.person.getNom()) < 0) {
			rac.fg = ajouterParNom(rac.fg, person);
		}
		
		if (person.getNom().compareTo(rac.person.getNom()) > 0) {
			rac.fd = ajouterParNom(rac.fd, person);
		}
		
		return rac;
	}

	public Noeud ajouterParPrenom(Noeud rac, Stagiaire person) {
		if (rac == null) {
			Noeud nouveau = new Noeud(person);
			return nouveau;
		} 
		if (person.getPrenom().compareTo(rac.person.getPrenom()) < 0) {
			rac.fg = ajouterParPrenom(rac.fg, person);
		}
		else if (person.getPrenom().compareTo(rac.person.getPrenom()) == 0) {
			rac.setNbOcc(rac.getNbOcc() + 1);
		}
		else {
			rac.fd = ajouterParPrenom(rac.fd, person);
		}
		return rac;
	}
	
	/*public Noeud<E> successeur(Noeud<E> currentNoeud){
   	 currentNoeud = currentNoeud.droit;
   	 while (currentNoeud.gauche!=null) {
   		 currentNoeud = currentNoeud.gauche;
   	 }
   	 return currentNoeud;
    }*/
    public void ajouterValeur(Stagiaire valeur) {
   	 ajouterValeur(racine,valeur);
    }
    public Noeud ajouterValeur(Noeud currentNoeud, Stagiaire valeur) {
   	 if (currentNoeud == null)
   		 return new Noeud(valeur);
   	 if (currentNoeud.person.getNom().compareTo(valeur.getNom())>0) {
   		 //System.out.println("fIlsG\n");
   		 currentNoeud.fg = ajouterValeur(currentNoeud.fg,valeur);
   	 }
   	 if (currentNoeud.person.getNom().compareTo(valeur.getNom())<=0) {
   		 //System.out.println("filsD\n");
   		 currentNoeud.fd = ajouterValeur(currentNoeud.fd,valeur);
   	 }
   	 return currentNoeud;
    }
	
	

	public void construire(String nomFichier, String critere) throws IOException {
		Scanner lecteur = new Scanner(new File(nomFichier));

		while (lecteur.hasNext()) {
			String[] splits = lecteur.next().split(",");
			if(splits.length < 0) {
			String prenom = splits[0];
			String nom = splits[1];
			String id = splits[2];
			String tel = " "; 
			//if(splits[3].exists()){
			//	tel = splits[3]; 
			//}
			String email = " "; 
			//if(splits[4] != null) {
			//	email = splits[4]; 
			//}
			Stagiaire person = new Stagiaire(nom, prenom, id, tel, email);
			//System.out.println(person.getNom() + " " + person.getPrenom());
			this.ajouter(person, critere);
			//System.out.println(person.toString());
			}
			
		}
		lecteur.close();
	}

	public int hauteur() {
		return hauteur(racine);
	}

	private int hauteur(Noeud rac) {
		if (rac == null)
			return -1;
		int hg = hauteur(rac.fg);
		int hd = hauteur(rac.fd);
		if (hg < hd)
			return hd + 1;
		return hg + 1;
	}

	public void ecrireListeTriee() {
		ecrireListeTriee(racine);
	}

	public void ecrireListeTriee(Noeud rac) {
		if (rac != null) {
			ecrireListeTriee(rac.fg);
			System.out.println(rac.person + " (" + rac.getNbOcc() + " fois)");
			ecrireListeTriee(rac.fd);
		}
	}

	public void afficherArbre(ObservableList<Stagiaire> liste) {
		System.out.println("Affichage de l'arbre :\n\n");
		afficherNoeud(racine, 0, hauteur(), liste);
		System.out.println();
	}

	public void afficherNoeud(Noeud currentNoeud, int currentLevel, int maxLevel, ObservableList<Stagiaire> liste) {

		if (currentNoeud != null) {
			afficherNoeud(currentNoeud.fg, currentLevel + 1, maxLevel, liste);
			for (int i = 0; i < (maxLevel - currentLevel - 1); i++) {
				// System.out.print(" ");
			}
			liste.add(currentNoeud.person);
			System.out.println(currentNoeud.person);
			afficherNoeud(currentNoeud.fd, currentLevel + 1, maxLevel, liste);
			
		} else {
			if (currentLevel < maxLevel) {
				afficherNoeud(null, currentLevel + 1, maxLevel, liste);
				// System.out.println("");
				afficherNoeud(null, currentLevel + 1, maxLevel, liste);
			}
		}
	}

	public Noeud successeur(Noeud currentNoeud) {
		currentNoeud = currentNoeud.fd;
		while (currentNoeud.fg != null) {
			currentNoeud = currentNoeud.fg;
		}
		return currentNoeud;
	}

	public Noeud predecesseur(Noeud currentNoeud) {
		currentNoeud = currentNoeud.fd;
		while (currentNoeud.fg != null) {
			currentNoeud = currentNoeud.fg;
		}
		return currentNoeud;
	}

	public void supprimer(Stagiaire person) {
		racine = supprimer(racine, person);
	}

	public Noeud supprimer(Noeud currentNoeud, Stagiaire person) {
		if (currentNoeud == null)
			return currentNoeud;
		if (currentNoeud.person.getId().compareTo(person.getId()) == 0) {
			return supprimerRacine(currentNoeud);
		}
		if (currentNoeud.person.getId().compareTo(person.getId()) > 0) {
			currentNoeud.fg = supprimer(currentNoeud.fg, person);
		}
		if (currentNoeud.person.getId().compareTo(person.getId()) < 0) {
			currentNoeud.fd = supprimer(currentNoeud.fd, person);
		}
		return currentNoeud;
	}

	public Noeud supprimerRacine(Noeud currentNoeud) {

		if (currentNoeud.fg == null && currentNoeud.fd == null) {
			System.out.println("");
			return null;
		} else if (currentNoeud.fg != null && currentNoeud.fd == null)
			return currentNoeud.fg;
		else if (currentNoeud.fg == null && currentNoeud.fd != null)
			return currentNoeud.fd;
		else {
			currentNoeud.person = successeur(currentNoeud).person;
			currentNoeud.fd = supprimer(currentNoeud.fd, currentNoeud.person);
			return currentNoeud;
		}

	}

	public void modifier(Stagiaire exPerson, Stagiaire newPerson) {
		this.supprimer(exPerson);
		this.ajouter(newPerson, "Nom");
	}

	public List<Stagiaire> rechercher_liste(String selec, String valeur) {
		List<Stagiaire> listeRetour = new ArrayList<Stagiaire>();
		System.out.println(selec + " " + valeur);
		return rechercher_liste_annexe(listeRetour, racine, selec, valeur);
	}

	public List<Stagiaire> rechercher_liste_annexe(List<Stagiaire> listRetour, Noeud currentNoeud, String selec,
			String valeur) {
		System.out.println("coucou!");
		if (selec.equals("Nom")) {
			if (currentNoeud == null) {
				System.out.println("null last name " + listRetour);
				return listRetour;
			}
			else if (currentNoeud.person.getNom().compareTo(valeur) == 0) {
				listRetour.add(currentNoeud.person);
				rechercher_liste_annexe(listRetour, currentNoeud.fd, selec, valeur);
				System.out.println("0  last name " + listRetour);
				return listRetour;
			} else if (currentNoeud.person.getNom().compareTo(valeur) > 0) {
				
				return rechercher_liste_annexe(listRetour, currentNoeud.fg, selec, valeur);
			} else {
				return rechercher_liste_annexe(listRetour, currentNoeud.fd, selec, valeur);
			}
		}
		else if (selec.equals("Prénom")) {
			if (currentNoeud == null) {
				System.out.println("null first name " + listRetour);
				return listRetour;
			}
			else if (currentNoeud.person.getPrenom().compareTo(valeur) == 0) {
				listRetour.add(currentNoeud.person);
				rechercher_liste_annexe(listRetour, currentNoeud.fd, selec, valeur);
				System.out.println("0 first name " + listRetour);
				return listRetour;
			} else if (currentNoeud.person.getPrenom().compareTo(valeur) > 0) {
				System.out.println(">0");
				return rechercher_liste_annexe(listRetour, currentNoeud.fg, selec, valeur);
			} else {
				System.out.println("<0");
				return rechercher_liste_annexe(listRetour, currentNoeud.fd, selec, valeur);
			}
		}
		else return null;

	}

}
