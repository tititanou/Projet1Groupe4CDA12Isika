package fr.isika.cda12.annuaire.model;

public class Personne {
	
	private String nom;
	private String prenom;
	//private String id;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;	
	}
	
	public Personne() {
		
	}
	
	public boolean creerCompte ( String lastName, String firstName, String pwd1, String pwd2) {
		
		boolean result;
		Personne person = new Personne (lastName, firstName);
		
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
		
		return this.nom + " " + this.prenom;
	}

}
