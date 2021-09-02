package fr.isika.cda12;
import java.io.File;

import java.io.FileNotFoundException;  
import java.util.Scanner; 



public class importFile {

	public static void main(String[] args) {
		
		
	
    try {
    	File file = new File("assets/noms.txt");
    	String path = file.getAbsolutePath();
    	File myObj = new File(path);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
        
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
   
  }
}