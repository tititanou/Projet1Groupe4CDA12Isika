package fr.isika.cda12.annuaire.model;

import java.io.*;

import java.util.*;

public class FileManager {
	
public static void readFile(String fileName) {
		
		File file = new File(fileName);
		Scanner myReader;
		try {
			myReader = new Scanner(file);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			//Alert alert = new Alert(AlertType.ERROR);
			//alert.setHeaderText("Echec de la lecture du fichier");
			//alert.setContentText("Un problème est survenu avec le fichier!");
		}
	}
	
	public static void updateFile(String fileName, String newData) {
		
		File file = new File(fileName);
		try {
		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
		BufferedWriter bw = new BufferedWriter(fw);
			bw.write("\n" + newData);
			bw.close();

			//Alert alert = new Alert(AlertType.CONFIRMATION);
			//alert.setHeaderText("Modification du fichier");
			//alert.setContentText("Votre fichier a été modifié avec succès");
			
		} catch (IOException e) {
			e.printStackTrace();
			//Alert alert = new Alert(AlertType.ERROR);
			//alert.setHeaderText("Echec de la modification du fichier");
			//alert.setContentText("Un problème est survenu avec l'écriture du fichier!");
		}
	}
	//Pour tester décommenter la méthode main
	/*public static void main(String[] args) {

		readFile("assets/noms.txt");
		updateFile("assets/noms.txt", "Phil");

	}*/

}
