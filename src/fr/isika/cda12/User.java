package fr.isika.cda12;

public class User {

	private String id;
	private String firstName;
	private String lastName;
	private String pwd;
	
	

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param pwd
	 */
	public User(String firstName, String lastName, String pwd) {
		this.id = firstName + "_" + lastName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pwd = pwd;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@Override
	public String toString() {
		return this.firstName + " " + this.lastName + " / " + this.id;
	}
	
}
