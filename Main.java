package thePackage;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Main extends JPanel {
	
    static boolean head = false;  static boolean body = false;  static boolean leftArm = false;
    static boolean rightArm = false;  static boolean leftLeg = false;  static boolean rightLeg = false;
	
	public static void main(String[] args) throws IOException {

		final JFrame theFrame = new JFrame();
		
		final String theWord = ReadFromFile.findWord();
	   	final int lengthOfWord = theWord.length();
	   	final String[] usedLetters = new String[20];
	   	
	   	System.out.println(theWord);
			
		
		KeyListener keyListener = new KeyListener() {
		
			private boolean CorrectOrNot;	
			private int currentBodyPart = 0;	
			private int winnerYet = 0;
			private int doneYet = 0;
			private int lettersInArray = 0;
			private boolean keepGoing = true;
			
			
			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
				
				String letter = Character.toString((char) (key+32));
				
				outerLoop:
				if (lettersInArray >= 0 ) {
					for (int i=0; i < (lettersInArray); i++) {
						if (letter.equals(usedLetters[i])) {
							keepGoing = false;
							System.out.println("FALSE");
							break outerLoop;
							
						}
					}
				}
				
				if (keepGoing == true) {
					
					usedLetters[lettersInArray] = letter;
					lettersInArray = lettersInArray + 1;
					System.out.println(letter);
					CorrectOrNot = theWord.contains(letter);
					
					if (CorrectOrNot == false) {
						if (currentBodyPart < 5) {
							currentBodyPart++;
							System.out.println(currentBodyPart);
						} else {
							currentBodyPart++;
							System.out.println("YOU LOSE HAHAHAHAH");
							doneYet = 2;
						}
					}
					else {
						winnerYet++;
						if (lengthOfWord == winnerYet) {
							System.out.println("YOU'VE WON");
							doneYet = 1; }
						else
							System.out.println("Correct Letter Pressed");
					}
					
					if (currentBodyPart == 1) {
						Paint.getStatusOfPerson(1, doneYet);
						theFrame.repaint(); }
					
					if (currentBodyPart == 2) {
						Paint.getStatusOfPerson(2, doneYet);
						theFrame.repaint(); }
					
					if (currentBodyPart == 3) {
						Paint.getStatusOfPerson(3, doneYet);
						theFrame.repaint(); }
					
					if (currentBodyPart == 4) {
						Paint.getStatusOfPerson(4, doneYet);
						theFrame.repaint(); }
					
					if (currentBodyPart == 5) {
						Paint.getStatusOfPerson(5, doneYet);
						theFrame.repaint(); }
					
					if (currentBodyPart == 6) {
						Paint.getStatusOfPerson(6, doneYet);
						theFrame.repaint(); }
				
					keepGoing = true;	
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			} 
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		};
		
		theFrame.addKeyListener(keyListener);
		theFrame.pack();
	    theFrame.setSize(new Dimension(800, 600));
	    theFrame.setContentPane(new Paint());
	    theFrame.setVisible(true);
	}
}