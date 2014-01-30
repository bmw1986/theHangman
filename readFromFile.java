package thePackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readFromFile {

	static String findWord()  throws IOException{
	
		BufferedReader in = null;
		String[] theWords = new String[10];
		try {
			in = new BufferedReader(new FileReader("/Volumes/The Data/Freddy/theWords.txt"));
			
			int index = 0;
			String l;
			while ((l = in.readLine()) != null) {
				//System.out.println(l);
				theWords[index] = l;
				index++;
			}			
		} finally {
			if (in != null) 
				in.close();
		}
		
		int randomNum = 0 + (int)(Math.random()*10);
		String theWord = theWords[randomNum];	
		return theWord;
	}
}