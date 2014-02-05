package thePackage;

import gnu.io.*;

import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.TooManyListenersException;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GUI extends JPanel implements SerialPortEventListener {
	
    static boolean head = false;  static boolean body = false;  static boolean leftArm = false;
    static boolean rightArm = false;  static boolean leftLeg = false;  static boolean rightLeg = false;
    private static InputStream input = null;  static String outPut = "";
    static String logText = "";  static boolean goOnnnnn = false;
    private SerialPort serialPort = null; static String letter;
    popUpGUI window = null;
    
    @SuppressWarnings("rawtypes")
   	private Enumeration ports = null;
       //map the port names to CommPortIdentifiers
       @SuppressWarnings("rawtypes")
   	private HashMap portMap = new HashMap();

       //this is the object that contains the opened port
       private CommPortIdentifier selectedPortIdentifier = null;
       private static OutputStream output = null;

       //just a boolean flag that i use for enabling
       //and disabling buttons depending on whether the program
       //is connected to a serial port or not
       private boolean bConnected = false;

       //the timeout value for connecting with the port
       final static int TIMEOUT = 2000;

       //some ascii values for for certain things
       final static int SPACE_ASCII = 32;
       final static int DASH_ASCII = 45;
       final static int NEW_LINE_ASCII = 10;
    
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
		
	
		SerialPortEventListener listener = new SerialPortEventListener() {

			@Override
			public void serialEvent(SerialPortEvent evt) {
				if (evt.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
		            goOnnnnn = true;
		        	try {
		                byte singleData = (byte)input.read();

		                if (singleData != 10) {
		                    logText = new String(new byte[] {singleData});
		                    outPut = logText;
		                    logText = letter;
//		                    System.out.println(logText);
		                } else {
		                    System.out.println("\n");
		                }
		            }
		            catch (Exception e) {
		                logText = "Failed to read data. (" + e.toString() + ")";
		            }
		        	
		        	System.out.println("This is the value of letters: " + letter);
		        }
				System.out.println("This is the value: " + letter);
			}
			
//			if (goOnnnnn == true) {
//			try{
//			    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
//			    String s = bufferRead.readLine();
//		 
//			    System.out.println("This is s:" + s);
//			}
//			catch(IOException e)
//			{
//				e.printStackTrace();
//			}
//			
//				goOnnnnn = false;
		};
		
		
//		String letter = Communicator.getOutPut();
////		String letter = logText;
//		int key = toAscii(letter);
//		
//		if (key == 109)
//			key = 9;
//		
//		Communicator.writeData(key);
//		System.out.println("This is the value of key: " + key);
//		System.out.println(letter);
////		String letter = System.console().readLine();
//		
//		
//		outerLoop:
//		if (lettersInArray >= 0 ) {
//			for (int i=0; i < (lettersInArray); i++) {
//				if (letter.equals(usedLetters[i])) {
//					keepGoing = false;
//					System.out.println("Dude, you've already used that letter...step up your game.");
//					break outerLoop;
//				}
//			}
//		}
//		
//		if (keepGoing == true) {
//			
//			usedLetters[lettersInArray] = letter;
//			lettersInArray = lettersInArray + 1;
//			CorrectOrNot = theWord.contains(letter);
//			
//			if (CorrectOrNot == false) {
//				if (currentBodyPart < 5) {
//					currentBodyPart++;
//					System.out.println("Incorrect");
//				} else {
//					currentBodyPart++;
//					System.out.println("Wow, dude you suck.");
//					Paint.getStatusOfPerson(6, 2);
//					theFrame.repaint();
//					doneYet = 2; }
//			}
//			else {
//				winnerYet++;
//				if (distinctChars == winnerYet) {
//					System.out.println("You've won!");
//					Paint.getStatusOfPerson(0, 1);
//					theFrame.repaint();
//					doneYet = 1; }
//				else
//					System.out.println("Correct");
//			}
//			
//			if (currentBodyPart == 1) {
//				Paint.getStatusOfPerson(1, doneYet);
//				theFrame.repaint(); }
//			
//			if (currentBodyPart == 2) {
//				Paint.getStatusOfPerson(2, doneYet);
//				theFrame.repaint(); }
//			
//			if (currentBodyPart == 3) {
//				Paint.getStatusOfPerson(3, doneYet);
//				theFrame.repaint(); }
//			
//			if (currentBodyPart == 4) {
//				Paint.getStatusOfPerson(4, doneYet);
//				theFrame.repaint(); }
//			
//			if (currentBodyPart == 5) {
//				Paint.getStatusOfPerson(5, doneYet);
//				theFrame.repaint(); }
//			
//			if (currentBodyPart == 6) {
//				Paint.getStatusOfPerson(6, doneYet);
//				theFrame.repaint(); }
//			}
		
			//theFrame.addKeyListener(keyListener);
			theFrame.pack();
		    theFrame.setSize(new Dimension(800, 600));
		    theFrame.setContentPane(new Paint());
		    theFrame.setVisible(true);
		
	}
    
    //////////////////////////////////////////////////////////
//    public void connect()
//    {
//        String selectedPort = (String)window.cboxPorts.getSelectedItem();
//        selectedPortIdentifier = (CommPortIdentifier)portMap.get(selectedPort);
//
//        CommPort commPort = null;
//
//        try
//        {
//            //the method below returns an object of type CommPort
//            commPort = selectedPortIdentifier.open("theControlPanel", TIMEOUT);
//            //the CommPort object can be casted to a SerialPort object
//            serialPort = (SerialPort)commPort;
//
//            //for controlling GUI elements
//            setConnected(true);
//
//            //logging
//            logText = selectedPort + " opened successfully.";
//            window.txtLog.setForeground(Color.black);
//            window.txtLog.append(logText + "\n");
//
//            //CODE ON SETTING BAUD RATE ETC OMITTED
//            //XBEE PAIR ASSUMED TO HAVE SAME SETTINGS ALREADY
//            setSerialPortParameters();
//            
//            //enables the controls on the GUI if a successful connection is made
//            window.keybindingController.toggleControls();
//        }
//        catch (PortInUseException e)
//        {
//            logText = selectedPort + " is in use. (" + e.toString() + ")";
//            
//            window.txtLog.setForeground(Color.RED);
//            window.txtLog.append(logText + "\n");
//        }
//        catch (Exception e)
//        {
//            logText = "Failed to open " + selectedPort + "(" + e.toString() + ")";
//            window.txtLog.append(logText + "\n");
//            window.txtLog.setForeground(Color.RED);
//        }
//    }
    ///////////////////////////////////////////////////////////////////////
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
    ///////////////////////////////////////////////////////////////////////
    public static void writeData(int asciiToWrite) {
        try {
        	SerialPort serialPort = null;
        	OutputStream output = null;
        	output = serialPort.getOutputStream();
			output.write(asciiToWrite);
            output.flush();
        } catch (Exception e) {
            logText = "Failed to write data. (" + e.toString() + ")";
        }
    }
//    public static String getOutPut() {
//    	return logText;
//    }
    ///////////////////////////////////////////////////////////////////////
    public void initialize() {
        try {
            serialPort.addEventListener((gnu.io.SerialPortEventListener) this);
            serialPort.notifyOnDataAvailable(true);
        } catch (TooManyListenersException e) {
            logText = "Too many listeners. (" + e.toString() + ")"; }
    }
    ///////////////////////////////////////////////////////////////////////
//    public void searchForPorts()
//    {
//        ports = CommPortIdentifier.getPortIdentifiers();
//
//        while (ports.hasMoreElements())
//        {
//            CommPortIdentifier curPort = (CommPortIdentifier)ports.nextElement();
//
//            //get only serial ports
//            if (curPort.getPortType() == CommPortIdentifier.PORT_SERIAL)
//            {
//                window.cboxPorts.addItem(curPort.getName());
//                portMap.put(curPort.getName(), curPort);
//            }
//        }
//    }
    /////////////////////////////////////////////////////////////////////
    private void setSerialPortParameters() throws IOException {
        int baudRate = 9600;
 
        try {
            serialPort.setSerialPortParams(
                    baudRate,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
 
            serialPort.setFlowControlMode(
                    SerialPort.FLOWCONTROL_NONE);
        } catch (UnsupportedCommOperationException ex) {
            throw new IOException("Unsupported serial port parameter");
        }
    }
    ///////////////////////////////////////////////////////////////////////
    public boolean initIOStream()
    {
        //return value for whather opening the streams is successful or not
        boolean successful = false;

        try {
            //
            input = serialPort.getInputStream();
            output = serialPort.getOutputStream();
            writeData(0);
            
            successful = true;
            return successful;
        }
        catch (IOException e) {
            logText = "I/O Streams failed to open. (" + e.toString() + ")";
            window.txtLog.setForeground(Color.red);
            window.txtLog.append(logText + "\n");
            return successful;
        }
    }
    ///////////////////////////////////////////////////////////////////////
    public void disconnect()
    {
        //close the serial port
        try
        {
            writeData(0);

            serialPort.removeEventListener();
            serialPort.close();
            input.close();
            output.close();
            setConnected(false);
            window.keybindingController.toggleControls();

            logText = "Disconnected.";
            window.txtLog.setForeground(Color.red);
            window.txtLog.append(logText + "\n");
        }
        catch (Exception e)
        {
            logText = "Failed to close " + serialPort.getName() + "(" + e.toString() + ")";
            window.txtLog.setForeground(Color.red);
            window.txtLog.append(logText + "\n");
        }
    }

    final public boolean getConnected()
    {
        return bConnected;
    }
    ///////////////////////////////////////////////////////////////////////
    public void setConnected(boolean bConnected)
    {
        this.bConnected = bConnected;
    }

    //what happens when data is received
    //pre: serial event is triggered
    //post: processing on the data it reads
    public void serialEvent(SerialPortEvent evt) {
        if (evt.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                byte singleData = (byte)input.read();

                if (singleData != NEW_LINE_ASCII) {
                    logText = new String(new byte[] {singleData});
                    window.txtLog.append(logText);
                    outPut = logText;
                    System.out.println(logText);
                } else {
                    window.txtLog.append("\n");
                    System.out.println("\n");
                }
            }
            catch (Exception e) {
                logText = "Failed to read data. (" + e.toString() + ")";
                window.txtLog.setForeground(Color.red);
                window.txtLog.append(logText + "\n");
            }
        }
    }
    ///////////////////////////////////////////////////////////////////////
    public void initListener() {
        try {
            serialPort.addEventListener((gnu.io.SerialPortEventListener) this);
            serialPort.notifyOnDataAvailable(true);
        } catch (TooManyListenersException e) {
            logText = "Too many listeners. (" + e.toString() + ")"; }
    }
    ///////////////////////////////////////////////////////////////////////
}