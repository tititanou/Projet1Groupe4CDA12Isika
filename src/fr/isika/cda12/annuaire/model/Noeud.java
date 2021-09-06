package fr.isika.cda12.annuaire.model;



public class Noeud {
	
	private Personne person;
	private Noeud fg, fd;
	private int nbOcc = 1;
	
	public Noeud(Personne person) {
		this.person = person;
	}

	public int getNbOcc() {
		return nbOcc;
	}

	public void setNbOcc(int nbOcc) {
		this.nbOcc = nbOcc;
	}

	public void setPerson(Personne person) {
		this.person = person;
	}

	public Personne getPerson() {
		return person;
	}

	public void setDonnee(Personne person) {
		this.person = person;
	}

	public Noeud getFg() {
		return fg;
	}
	public void setFg(Noeud fg) {
		this.fg = fg;
	}

	public Noeud getFd() {
		return fd;
	}

	public void setFd(Noeud fd) {
		this.fd = fd;
	}
	
	public void afficherNoeud() {
		  
	  	System.out.println(this.toString());
	  	if (this.fg != null)  this.fg.afficherNoeud();
	  	if (this.fd != null)  this.fd.afficherNoeud();
	  	
	}

}
