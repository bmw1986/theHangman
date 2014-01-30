package thePackage;

public class GameLogic {

	static boolean isItCorrect(int input, String theWord) {

		 String letter = Character.toString((char) input);
	
		return theWord.contains(letter);
	}
	
}