package thePackage;

import gnu.io.SerialPortEvent;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.io.InputStream;

import javax.comm.SerialPortEventListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GUI extends JPanel implements SerialPortEventListener {
	
    static boolean head = false;  static boolean body = false;  static boolean leftArm = false;
    static boolean rightArm = false;  static boolean leftLeg = false;  static boolean rightLeg = false;
    private InputStream input = null;  static String outPut = "";
    static String logText = "";
    public static void main(String[] args) throws IOException {
		
    	new popUpGUI().setVisible(true);
    	
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
		
		//String letter = Communicator.getOutPut();
		String letter = logText;
		int key = toAscii(letter);
		
		if (key == 109)
			key = 9;
		
		Communicator.writeData(key);
		System.out.println("This is the value of key: " + key);
		
		letter = Communicator.getOutPut();
		key = toAscii(letter);
		
		if (key == 109)
			key = 9;
		
		Communicator.writeData(key);
		System.out.println("This is the value of key: " + key);
		
		keepGoing = true;	
//			String letter = Communicator.getOutPut();
//		String letter = System.console().readLine();
		System.out.println(letter);
		
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
    
    @Override
	public void serialEvent(javax.comm.SerialPortEvent evt) {
    	if (evt.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                byte singleData = (byte)input.read();

                if (singleData != 10) {
                    logText = new String(new byte[] {singleData});
                    outPut = logText;
                    System.out.println(logText);
                } else {
                    System.out.println("\n");
                }
            }
            catch (Exception e) {
                logText = "Failed to read data. (" + e.toString() + ")";
            }
        }
    }
    	
}