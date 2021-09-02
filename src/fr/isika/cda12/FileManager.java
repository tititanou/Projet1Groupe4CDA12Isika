package fr.isika.cda12;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.*;

public class FileManager {

	public static void main(String[] args) {

		try {

			String content = "\nCeci est le contenu ajouté au fichier";

			File file = new File("assets/noms.txt");
			Scanner myReader = new Scanner(file);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
			// créer le fichier s'il n'existe pas
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

			System.out.println("Modification terminée!");

		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * try { List<String> lines = Arrays.asList("NOUVEAU", "PRENOM"); File file =
		 * new File("assets/noms.txt"); Path path = Paths.get("assets/noms.txt");
		 * //String path = file.getAbsolutePath(); File myObj = new
		 * File("assets/noms.txt"); Scanner myReader = new Scanner(myObj); while
		 * (myReader.hasNextLine()) { String data = myReader.nextLine();
		 * System.out.println(data); } Files.write(path, lines, StandardCharsets.UTF_8,
		 * StandardOpenOption.WRITE); Scanner myReaderB = new Scanner(myObj); while
		 * (myReaderB.hasNextLine()) { String data = myReaderB.nextLine();
		 * System.out.println(data); } myReader.close(); } catch (Exception e) {
		 * System.out.println("An error occurred."); e.printStackTrace(); }
		 */

	}
}