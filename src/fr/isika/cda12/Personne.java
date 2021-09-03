package fr.isika.cda12;

public class Personne {

	String nom;
	String prenom;
	
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
	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
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

	}	
	
  