package fr.isika.cda12;

import java.util.Set;

public class UserSession {
	
	private UserSession instance;
	private User user;
	private String privileges;
	
	private UserSession(User user) {
        this.user= user;
    }
	
	public UserSession getInstance(User user) {
        if(instance == null) {
            instance = new UserSession(user);
        }
        return instance;
    }
	
	public User getUser() {
        return user;
    }
	
	public String getPrivileges() {
		Administrateur admin = null;
		Etudiant student = null;
		if (this.user.getClass().equals(admin.getClass())) {
			this.privileges = "admin";
		}
		else if (this.user.getClass().equals(student.getClass())) {
			this.privileges = "student";
		}
		else {
			this.privileges = null;
		}
		return privileges;
	}
	
	 public void cleanUserSession() {
         user = null;
     }
	 
	 @Override
     public String toString() {
         return "UserSession{" +
                 "user='" + user.getFirstName() + " " + user.getLastName() + '\'' +
                 "userId = '" + user.getId() + '\'' +
                 ", privileges=" + privileges +
                 '}';
     }

}
