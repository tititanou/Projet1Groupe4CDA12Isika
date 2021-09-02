package fr.isika.cda12;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			Arbre arbre = new Arbre();
			
			arbre.afficherArbre();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
