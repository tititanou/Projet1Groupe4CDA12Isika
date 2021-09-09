package fr.isika.cda12;

import java.io.*;

import java.util.*;

import com.apple.eawt.UserSessionListener;

import fr.isika.cda12.annuaire.model.Personne;


public class FileManager {
	
	

	public static void readFile(String fileName, List<Personne> usersList) {
		System.out.println("hello1");
		File file = new File(fileName);
		Scanner myReader;
		try {
			System.out.println("hello2");
			myReader = new Scanner(file);
			while (myReader.hasNextLine()) {
				System.out.println("hello3");
				String data = myReader.nextLine();
				String[] userDatas = data.split(",");
				Personne user = new Personne(userDatas[0],userDatas[1],userDatas[2]);
				usersList.add(user);
				System.out.println(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("hello4");
			e.printStackTrace();
			//Alert alert = new Alert(AlertType.ERROR);
			//alert.setHeaderText("Echec de la lecture du fichier");
			//alert.setContentText("Un problème est survenu avec le fichier!");
		}
		System.out.println("FM" + usersList);
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