package fr.isika.cda12.annuaire.model;

public class Personne {
	
	private String nom;
	private String prenom;
	private String id;
	
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Personne(String nom, String prenom, String id) {
		this.nom = nom;
		this.prenom = prenom;
		this.id = id;
	}
	
	public void  CreerCompte ( String nom, String prenom,String motDePasse) {
		System.out.println("Nom: " +nom);
		System.out.println("Prenom: " +prenom);
		System.out.println("Mot de passe : " +motDePasse);
		System.out.println("Confirmation du mot de passe : " +motDePasse);
	}
	public void Connexion (String NomUtilisateur, String motDePasse ) {
		System.out.println("Nom de l'utilisateur:  " +NomUtilisateur);
		System.out.println( "Mot de passe:  "+motDePasse);
	}
	public void Deconnexion ( ) {
		
	}
	
	@Override
	public String toString() {
		
		return this.nom + " " + this.prenom;
	}

}
