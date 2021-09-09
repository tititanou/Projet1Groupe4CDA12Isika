package fr.isika.cda12;

import fr.isika.cda12.annuaire.model.Stagiaire;

public class Noeud {
	public Stagiaire person;
	public Noeud fg, fd;
	private int nbOcc = 1;
	
	public Noeud(Stagiaire person) {
		this.person = person;
	}

	public int getNbOcc() {
		return nbOcc;
	}

	public void setNbOcc(int nbOcc) {
		this.nbOcc = nbOcc;
	}
	
	public void afficherNoeud() {
		  
	  	System.out.println(this.person.toString());
	  	if (this.fg != null)  this.fg.afficherNoeud();
	  	if (this.fd != null)  this.fd.afficherNoeud();
	  	
	}
	
}
