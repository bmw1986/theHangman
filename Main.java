package thePackage;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
<<<<<<< HEAD
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
			private int lettersInArray = 0; 
			private boolean keepGoing = true;
			
			for (int i=0; i<19; i++) {
				usedLetters[i] = " ";
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
	//			int key = e.getKeyCode();
	////			CorrectOrNot = GameLogic.isItCorrect(key, theWord);
	//			
	//			String letter = Character.toString((char) (key+32));
	//			
	////			if (lettersInArray > 1 ) {
	////				for (int i=0; i < (lettersInArray-1); i++) {
	////				}
	////					if (letter.equals(usedLetters[lettersInArray]))
	////						keepGoing = false;
	////			}
	//			
	//			if (keepGoing = true) {
	//				
	//				usedLetters[lettersInArray] = letter;
	//				lettersInArray++;
	//				System.out.println(letter);
	//				CorrectOrNot = theWord.contains(letter);
	//				
	//				if (CorrectOrNot == false) {
	//					if (currentBodyPart < 5) {
	//						currentBodyPart++;
	//						System.out.println(currentBodyPart);
	//					} else
	//						currentBodyPart++;
	//						System.out.println("YOU LOSE HAHAHAHAH");
	//				}
	//				else {
	//					winnerYet++;
	//					if (lengthOfWord == winnerYet)
	//						System.out.println("YOU'VE WON");
	//					else
	//						System.out.println("Correct Letter Pressed");
	//				}
	//				
	//				if (currentBodyPart == 1) {
	//					Paint.getStatusOfPerson(1);
	//					theFrame.repaint(); }
	//				
	//				if (currentBodyPart == 2) {
	//					Paint.getStatusOfPerson(2);
	//					theFrame.repaint(); }
	//				
	//				if (currentBodyPart == 3) {
	//					Paint.getStatusOfPerson(3);
	//					theFrame.repaint(); }
	//				
	//				if (currentBodyPart == 4) {
	//					Paint.getStatusOfPerson(4);
	//					theFrame.repaint(); }
	//				
	//				if (currentBodyPart == 5) {
	//					Paint.getStatusOfPerson(5);
	//					theFrame.repaint(); }
	//				
	//				if (currentBodyPart == 6) {
	//					Paint.getStatusOfPerson(6);
	//					theFrame.repaint(); }
	//			}
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
=======
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;

import thePackage.Paint;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = null;
		String[] theWords = new String[10];
		try {
			in = new BufferedReader(new FileReader("/Volumes/The Data/Freddy/theWords.txt"));
			
			int index = 0;
			String l;
			while ((l = in.readLine()) != null) {
				System.out.println(l);
				theWords[index] = l;
				index++;
			}			
		} finally {
			if (in != null) 
				in.close();
		}
		
		int randomNum = 0 + (int)(Math.random()*10);
		
		String theWord = theWords[randomNum];
		
		JFrame theFrame = new JFrame();
		
//		Paint.paintStage(null);
//		
//		theFrame.repaint();
//		
//		KeyListener keyListener = new KeyListener() {
//			
//			@Override
//			public void keyReleased(KeyEvent e) {
//				int key = e.getKeyCode();
//				
//				if (key == KeyEvent.VK_1) {
//					System.out.println("You have pressed an \"1\" on the keyboard!");
//					Paint.paintHead(null);
////					theFrame.repaint();
//				}
//				if (key == KeyEvent.VK_2) {
//					System.out.println("You have pressed an \"2\" on the keyboard!");
//					Paint.paintBody(null);
////					theFrame.repaint();
//				}
//				if (key == KeyEvent.VK_3) {
//					System.out.println("You have pressed an \"3\" on the keyboard!");
//					Paint.paintLeftArm(null);
////					theFrame.repaint();
//				}
//				if (key == KeyEvent.VK_4) {
//					System.out.println("You have pressed an \"4\" on the keyboard!");
//					Paint.paintRightArm(null);
////					theFrame.repaint();
//				}
//				if (key == KeyEvent.VK_5) {
//					System.out.println("You have pressed an \"5\" on the keyboard!");
//					Paint.paintLeftLeg(null);
////					theFrame.repaint();
//				}
//				if (key == KeyEvent.VK_6) {
//					System.out.println("You have pressed an \"6\" on the keyboard!");
//					Paint.paintRightLeg(null);
////					theFrame.repaint();
//				}
//			}
//			
//			@Override
//			public void keyPressed(KeyEvent e) {
//				// TODO Auto-generated method stub
//			} 
//			
//			@Override
//			public void keyTyped(KeyEvent e) {
//				// TODO Auto-generated method stub
//			}
//		};
//		
//		theFrame.addKeyListener(keyListener);
		theFrame.pack();
	    theFrame.setSize(new Dimension(800, 600));
	    theFrame.setVisible(true);

>>>>>>> 4547088d1d450e695252eeb45262a96cc528c03a
	}
}