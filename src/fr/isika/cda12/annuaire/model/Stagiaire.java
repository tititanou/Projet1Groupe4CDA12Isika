package fr.isika.cda12.annuaire.model;

public class Stagiaire {
	
	private String nom;
	private String prenom;
	private String id;
	private String tel;
	private String email;
	private String adresse;
	private String ville;
	private String codePostal;
	private String birthday;



//	private String dateBirth;
//	private String adresse;
//	private String ville;
//	private String codePostal;
//	private String promo;

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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Stagiaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Stagiaire(String nom, String prenom, String id, String tel, String email, String adresse, String ville,
			String codePostal, String birthday) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.id = id;
		this.tel = tel;
		this.email = email;
		this.adresse = adresse;
		this.ville = ville;
		this.codePostal = codePostal;
		this.birthday = birthday;
	}

	public Stagiaire(String nom, String prenom, String id, String tel, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.id =id;
		this.tel = tel;
		this.email = email;
		this.adresse = "";
		this.ville = "";
		this.codePostal = "";
		this.birthday = "";
	}
	
	public Stagiaire(String nom, String prenom, String id) {
		this.nom = nom;
		this.prenom = prenom;
		this.id = id;
		this.tel = "";
		this.email = "";
		this.adresse = "";
		this.ville = "";
		this.codePostal = "";
		this.birthday = "";
	}
	
	public Stagiaire(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		this.id = System.currentTimeMillis() + prenom + nom;
		this.tel = "";
		this.email = "";
		this.adresse = "";
		this.ville = "";
		this.codePostal = "";
		this.birthday = "";
	}
	
	@Override
	public String toString() {
		
		return this.nom + "," + this.prenom + "," +this.id + "," + this.tel + "," + this.email + "," + this.adresse
				 + "," + this.ville + "," + this.codePostal + "," + this.birthday;
	}
	

}
