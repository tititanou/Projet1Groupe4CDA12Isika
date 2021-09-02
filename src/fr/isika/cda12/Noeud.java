package fr.isika.cda12;

public class Noeud {
	private String mot;
	private Noeud fg, fd;
	private int nbOcc = 1;
	
	public Noeud(String mot) {
		this.mot = mot;
	}

	public int getNbOcc() {
		return nbOcc;
	}

	public void setNbOcc(int nbOcc) {
		this.nbOcc = nbOcc;
	}

	public void setMot(String mot) {
		this.mot = mot;
	}

	public String getMot() {
		return mot;
	}

	public void setDonnee(String mot) {
		this.mot = mot;
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
	}}
