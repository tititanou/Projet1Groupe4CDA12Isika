package fr.isika.cda12.annuaire.model;



public class Noeud {
	
	private Stagiaire trainee;
	private Noeud fg, fd;
	private int nbOcc = 1;
	
	public Noeud(Stagiaire trainee) {
		this.trainee = trainee;
	}

	public int getNbOcc() {
		return nbOcc;
	}

	public void setNbOcc(int nbOcc) {
		this.nbOcc = nbOcc;
	}

	public void setTrainee(Stagiaire trainee) {
		this.trainee = trainee;
	}

	public Stagiaire getTrainee() {
		return trainee;
	}

	public void setDonnee(Stagiaire trainee) {
		this.trainee = trainee;
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
