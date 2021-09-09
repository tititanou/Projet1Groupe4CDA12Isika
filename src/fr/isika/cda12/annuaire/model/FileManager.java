package fr.isika.cda12.annuaire.model;

import java.io.*;

import java.util.*;

import fr.isika.cda12.Administrateur;
import javafx.collections.ObservableList;

public class FileManager {

	public static void readFile(String fileName, List<Personne> usersList) {

		File file = new File(fileName);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Scanner myReader;
		try {
			myReader = new Scanner(file);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] userDatas = data.split(",");
				if (userDatas[0].equals("admin")) {
					Administrateur user = new Administrateur(userDatas[1], userDatas[2], userDatas[4]);
					usersList.add(user);
				} else if (userDatas[0].equals("person")) {
					Personne user = new Personne(userDatas[1], userDatas[2], userDatas[4]);
					usersList.add(user);
				}

			}
			myReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void initStudents() {
		List<Stagiaire> studentsList = new ArrayList<>();
		File file = new File("assets/noms.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Scanner myReader;
		try {
			myReader = new Scanner(file);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] studentDatas = data.split(",");
				Stagiaire user = new Stagiaire(studentDatas[0], studentDatas[1]);
				studentsList.add(user);

			}
			myReader.close();
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			for (Stagiaire student : studentsList) {
				bw.write(student.toString() + "\n");
			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ObservableList<Stagiaire> updateStudents(ObservableList<Stagiaire> studentsList) {
		File file = new File("assets/noms.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
				
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				for(Stagiaire student : studentsList)
				bw.write(student.toString() + "\n");
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return studentsList;
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

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// Pour tester décommenter la méthode main
	/*
	 * public static void main(String[] args) {
	 * 
	 * readFile("assets/noms.txt"); updateFile("assets/noms.txt", "Phil");
	 * 
	 * }
	 */

}
