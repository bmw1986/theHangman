package thePackage;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.comm.*;

import java.util.*;

@SuppressWarnings("serial")
public class Main extends JPanel {
	
    static boolean head = false;  static boolean body = false;  static boolean leftArm = false;
    static boolean rightArm = false;  static boolean leftLeg = false;  static boolean rightLeg = false;
	
	public static void main(String[] args) throws IOException, UnsupportedCommOperationException {

//		String wantedPortName = "/dev/tty1";
//		@SuppressWarnings("rawtypes")
//		Enumeration portIdentifiers = CommPortIdentifier.getPortIdentifiers();
//		
//		CommPortIdentifier portId = null;  // will be set if port found
//		while (portIdentifiers.hasMoreElements())
//		{
//		    CommPortIdentifier pid = (CommPortIdentifier) portIdentifiers.nextElement();
//		    if(pid.getPortType() == CommPortIdentifier.PORT_SERIAL &&
//		       pid.getName().equals(wantedPortName)) 
//		    {
//		        portId = pid;
//		        break;
//		    }
//		}
//		if(portId == null)
//		{
//		    System.err.println("Could not find serial port " + wantedPortName);
//		    System.exit(1);
//		}
//		SerialPort port = null;
//		try {
//		    port = (SerialPort) portId.open(
//		        "name", // Name of the application asking for the port 
//		        10000   // Wait max. 10 sec. to acquire port
//		    );
//		} catch(PortInUseException e) {
//		    System.err.println("Port already in use: " + e);
//		    System.exit(1);
//		}
//		
//		port.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
//
//		BufferedReader is = null;  // for demo purposes only. A stream would be more typical.
//		PrintStream    os = null;
//
//		try {
//		  is = new BufferedReader(new InputStreamReader(port.getInputStream()));
//		} catch (IOException e) {
//		  System.err.println("Can't open input stream: write-only");
//		  is = null;
//		}
//		
//		os = new PrintStream(port.getOutputStream(), true);
//		
//		if (is != null) is.close();
//		if (os != null) os.close();
//		if (port != null) port.close();
//		
//		os.print("AT");
//		os.print("\r\n"); // Append a carriage return with a line feed
//
//		is.readLine(); // First read will contain the echoed command you sent to it. In this case: "AT"
//		is.readLine(); // Second read will remove the extra line feed that AT generates as output
//
//		String response = is.readLine(); // if you sent "AT" then response == "OK"
//		
//		System.out.println(response);
		
		final JFrame theFrame = new JFrame();
		
		final String theWord = ReadFromFile.findWord();
	   	final int distinctChars = GameLogic.determineIndivisualChars(theWord);
	   	final String[] usedLetters = new String[20];
	   	
	   	System.out.println(theWord);
		System.out.println(distinctChars);
		
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
				keepGoing = true;	
				String letter = Character.toString((char) (key+32));
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