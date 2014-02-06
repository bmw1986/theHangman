package thePackage;

import java.io.IOException;

public class GameLogic {

	static String theWord; static char[] charOfTheDay; static char[]guesses;
	static int keepPlaying = 0; static int distinctChars;
	
	static boolean isItCorrect(int input, String theWord) {

		 String letter = Character.toString((char) input);
	
		return theWord.contains(letter);
	}
	
	static int determineIndivisualChars(String theWord) {

		int length = theWord.length();
		int repeats = 0;
		char[] charsOfWord = new char[length];
		
		for (int i=0; i<length; i++)
			charsOfWord[i] = theWord.charAt(i);
		
		for (int j=0; j<length; j++) {
			for (int k=0; k<length; k++) {
				if (charsOfWord[j] == (charsOfWord[k])) {
					repeats++; }
			}
		}
		
		if (repeats > length) 
			repeats = ((repeats - length) /2);
		else
			repeats = 0;
		
		return (length-repeats);
	}
	
	static boolean keepPlaying () throws IOException {
		
		boolean yesOrNo = true;
		
		if (keepPlaying < 10) {
    		theWord = ReadFromFile.findWord();
			keepPlaying++;
			yesOrNo = true;
		} else
			yesOrNo = false;
		
		return yesOrNo;
	}
	
	static int getDistinctChars() {
		return distinctChars; }
	
	static String getTheWord() {
		return theWord; }
	
	static char[] getCharOfTheDay() {
		return charOfTheDay;}
		
	static char[] getGuesses() {
		return guesses; }
	
}