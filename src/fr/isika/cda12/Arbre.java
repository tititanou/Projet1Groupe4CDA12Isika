package fr.isika.cda12;


	import java.io.File;
    import java.io.IOException;
	import java.util.Scanner;
	
	
	  
	public class Arbre {
	    private Noeud racine;
	    
	    public Arbre() {}
	    
	    public Arbre(String noms)  throws IOException {
		construire("assets/noms.txt");	
	    }
	    
	    public void inserer(String mot) {
		racine = inserer(racine, mot);
	    }
	    
	    public Noeud inserer(Noeud rac, String mot ) {
		if (rac == null) {
		    Noeud nouveau = new Noeud(mot);
		    return nouveau;
		}
		if (mot.compareTo(rac.getMot()) < 0) rac.setFg(inserer(rac.getFg(), mot));
		else if (mot.compareTo(rac.getMot()) == 0) rac.setNbOcc(rac.getNbOcc() + 1);
		else rac.setFd(inserer(rac.getFd(), mot));
		return rac;
	    }
	    
	    public void construire(String nomFichier) throws IOException {
		Scanner lecteur = new Scanner(new File(nomFichier));
		
		while(lecteur.hasNext()) inserer(lecteur.next());
	    }
	    
	    public int hauteur() {
		return hauteur(racine);
	    }
	    
	    private int hauteur(Noeud rac) {
		if (rac == null) return -1;
		int hg = hauteur(rac.getFg());
		int hd = hauteur(rac.getFd());
		if (hg < hd) return hd + 1;
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
	}	  

