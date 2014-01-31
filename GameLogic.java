package thePackage;

public class GameLogic {

	static boolean isItCorrect(int input, String theWord) {

		 String letter = Character.toString((char) input);
	
		return theWord.contains(letter);
	}
	
	static int determineIndivisualChars(String theWord) {

		int length = theWord.length();
		char[] charsOfWord = new char[length];
		char[] charsOfWord2 = new char[length];
		for (int i=0; i<length; i++) {
			charsOfWord[i] = theWord.charAt(i);
			charsOfWord2[i] = theWord.charAt(i); }
		
		for (int j=0; j<length; j++) {
			for (int k=0; k<length; k++) {
				if (charsOfWord[j] == (charsOfWord2[k])) {
					
				}
			}
		}
		
		
		return length;
	}
}