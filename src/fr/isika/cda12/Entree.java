package fr.isika.cda12;

public class Entree {
	 String nom ;

	   public Entree (String nom)
	   {
	      this.nom = nom ;
	     
	   }

	   int compareTo (String autreNom)
	   {
	     
	      if (nom.regionMatches (true , 0,
				     autreNom, 0, autreNom.length ()))
		 return 0 ;
	      return nom.toLowerCase().compareTo (autreNom.toLowerCase ()) ;
	   }

	   int compareTo (Entree autre)
	   {
	      return this.compareTo (autre.nom) ;
	   }

	   public String toString ()
	   {
	      return nom  ;
	   }
	}


