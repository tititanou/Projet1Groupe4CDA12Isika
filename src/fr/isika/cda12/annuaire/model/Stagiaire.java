package fr.isika.cda12.annuaire.model;

public class Stagiaire {
	
	private int id;
	private String prenom;
//	private String nom;	
//	private String mail;
//	private String tel;
//	private String dateBirth;
//	private String adresse;
//	private String ville;
//	private String codePostal;
//	private String promo;

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Stagiaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Stagiaire(String prenom) {
		super();
		this.id = 0;
		this.prenom = prenom;
	}


	public Stagiaire(int id, String prenom) {
		super();
		this.id = id;
		this.prenom = prenom;
	}

}
