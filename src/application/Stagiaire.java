package application;

public class Stagiaire {
	
	private int id;
	private String prenom;
//	private String nom;	
//	private String mail;
//	private String tel;
//	private String dateBirth;
//	private String adresse;

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


	public Stagiaire(int id, String prenom) {
		super();
		this.id = id;
		this.prenom = prenom;
	}
	
	
	

}
