package thePackage;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GUI extends JPanel {
	
    static boolean head = false;  static boolean body = false;  static boolean leftArm = false;
    static boolean rightArm = false;  static boolean leftLeg = false;  static boolean rightLeg = false;
	    
    public static void main(String[] args) throws IOException {
		
    	
    	///////////////////////////////////////////////////////////////
    	
//    	java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new popUpGUI().setVisible(true);
//            }
//        });
        
    	new popUpGUI().setVisible(true);
    	
    	///////////////////////////////////////////////////////////////
    	
    	final JFrame theFrame = new JFrame();
		
		final String theWord = ReadFromFile.findWord();
	   	final int distinctChars = GameLogic.determineIndivisualChars(theWord);
	   	final String[] usedLetters = new String[20];
	   	
	   	System.out.println(theWord);
		System.out.println(distinctChars);
		
		boolean CorrectOrNot;	
		int currentBodyPart = 0;	
		int winnerYet = 0;
		int doneYet = 0;
		int lettersInArray = 0;
		boolean keepGoing = true;
		

		keepGoing = true;	
		//String letter = Character.toString((char) (key+32));
		String letter = Communicator.getOutPut();
		System.out.println(letter);
		
		int key = toAscii(letter);
		
		if (key == 47)
			key = 9;
		
		Communicator.writeData(key);
		System.out.println("This is the value of key: " + key);

		outerLoop:
		if (lettersInArray >= 0 ) {
			for (int i=0; i < (lettersInArray); i++) {
				if (letter.equals(usedLetters[i])) {
					keepGoing = false;
					System.out.println("Dude, you've already used that letter...step up your game.");
					break outerLoop;
				}
			}
		}
		
		if (keepGoing == true) {
			
			usedLetters[lettersInArray] = letter;
			lettersInArray = lettersInArray + 1;
			CorrectOrNot = theWord.contains(letter);
			
			if (CorrectOrNot == false) {
				if (currentBodyPart < 5) {
					currentBodyPart++;
					System.out.println("Incorrect");
				} else {
					currentBodyPart++;
					System.out.println("Wow, dude you suck.");
					Paint.getStatusOfPerson(6, 2);
					theFrame.repaint();
					doneYet = 2; }
			}
			else {
				winnerYet++;
				if (distinctChars == winnerYet) {
					System.out.println("You've won!");
					Paint.getStatusOfPerson(0, 1);
					theFrame.repaint();
					doneYet = 1; }
				else
					System.out.println("Correct");
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
		}
		
		//theFrame.addKeyListener(keyListener);
		theFrame.pack();
	    theFrame.setSize(new Dimension(800, 600));
	    theFrame.setContentPane(new Paint());
	    theFrame.setVisible(true);
	}
    
    public static int toAscii (String s) {
        StringBuilder sb = new StringBuilder();
        String ascString = null;
        
        if (s.equals(""))
        	s = "1";
    
        int asciiInt;
                for (int i = 0; i < s.length(); i++){
                    sb.append((int)s.charAt(i));
                    char c = s.charAt(i);
                }
                ascString = sb.toString();
                asciiInt = Integer.parseInt(ascString);
                return asciiInt;
    }
}
    
    
    
    
    
    
    
//	KeyListener keyListener = new KeyListener() {
//	
//		private boolean CorrectOrNot;	
//		private int currentBodyPart = 0;	
//		private int winnerYet = 0;
//		private int doneYet = 0;
//		private int lettersInArray = 0;
//		private boolean keepGoing = true;
//		
//		@Override
//		public void keyReleased(KeyEvent e) {
//			int key = e.getKeyCode();
//			keepGoing = true;	
//			//String letter = Character.toString((char) (key+32));
//			String letter = Communicator.getOutPut();
//			System.out.println(letter);
//			
//			if (key == 47)
//				key = 9;
//			
//			Communicator.writeData(key);
//			
//			
//			
//			outerLoop:
//			if (lettersInArray >= 0 ) {
//				for (int i=0; i < (lettersInArray); i++) {
//					if (letter.equals(usedLetters[i])) {
//						keepGoing = false;
//						System.out.println("Dude, you've already used that letter...step up your game.");
//						break outerLoop;
//					}
//				}
//			}
//			
//			if (keepGoing == true) {
//				
//				usedLetters[lettersInArray] = letter;
//				lettersInArray = lettersInArray + 1;
//				CorrectOrNot = theWord.contains(letter);
//				
//				if (CorrectOrNot == false) {
//					if (currentBodyPart < 5) {
//						currentBodyPart++;
//						System.out.println("Incorrect");
//					} else {
//						currentBodyPart++;
//						System.out.println("Wow, dude you suck.");
//						Paint.getStatusOfPerson(6, 2);
//						theFrame.repaint();
//						doneYet = 2; }
//				}
//				else {
//					winnerYet++;
//					if (distinctChars == winnerYet) {
//						System.out.println("You've won!");
//						Paint.getStatusOfPerson(0, 1);
//						theFrame.repaint();
//						doneYet = 1; }
//					else
//						System.out.println("Correct");
//				}
//				
//				if (currentBodyPart == 1) {
//					Paint.getStatusOfPerson(1, doneYet);
//					theFrame.repaint(); }
//				
//				if (currentBodyPart == 2) {
//					Paint.getStatusOfPerson(2, doneYet);
//					theFrame.repaint(); }
//				
//				if (currentBodyPart == 3) {
//					Paint.getStatusOfPerson(3, doneYet);
//					theFrame.repaint(); }
//				
//				if (currentBodyPart == 4) {
//					Paint.getStatusOfPerson(4, doneYet);
//					theFrame.repaint(); }
//				
//				if (currentBodyPart == 5) {
//					Paint.getStatusOfPerson(5, doneYet);
//					theFrame.repaint(); }
//				
//				if (currentBodyPart == 6) {
//					Paint.getStatusOfPerson(6, doneYet);
//					theFrame.repaint(); }
//			}
//		}
//		
//		@Override
//		public void keyPressed(KeyEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//		@Override
//		public void keyTyped(KeyEvent e) {
//			// TODO Auto-generated method stub 
//		}			
//	};