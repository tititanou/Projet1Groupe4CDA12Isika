package fr.isika.cda12.annuaire.model;

public class Personne {
	
	private String nom;
	private String prenom;
	private String id;
	private String mdp;
	
	public Personne(String nom, String prenom, String mdp) {
		this.nom = nom;
		this.prenom = prenom;
		this.id = nom + "_" + prenom;
		this.mdp = mdp;
	}
	
	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		this.id = nom + "_" + prenom;
		this.mdp = null;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public String getId() {
		return id;
	}
	
	public String getMdp() {
		return mdp;
	}
	
	
	public static boolean creerCompte ( String lastName, String firstName, String pwd1, String pwd2) {
		
		boolean result;
		
		if (pwd1.length() != pwd2.length()) {
			System.out.println("Les mots de passe sont différents");
			result = false;
	
		} else {
		    
		    if (pwd1.equals(pwd2)) {
		    	System.out.println("le compte est créé");
		    	result = true;
		    } else {
		    	System.out.println("Les mots de passe sont différents");
		    	result = false;
		    }
		    
		}
		
		System.out.println("Nom: " +lastName);
		System.out.println("Prenom: " +firstName);
		System.out.println("Mot de passe : " +pwd1);
		
		return result;
	}
	
	public void connexion (String NomUtilisateur, String motDePasse ) {
		System.out.println("Nom de l'utilisateur:  " +NomUtilisateur);
		System.out.println( "Mot de passe:  "+motDePasse);
	}
	
	public void deconnexion ( ) {
		
	}
	
	@Override
	public String toString() {
		
		return this.nom + "," + this.prenom + "," + this.id + "," + this.mdp;
	}

}
