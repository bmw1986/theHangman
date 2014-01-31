package thePackage;

public class GameLogic {

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
					repeats++;
				}
			}
		}
		
		if (repeats > length) 
			repeats = ((repeats - length) /2);
		else
			repeats = 0;
		
		return (length-repeats);
	}
}