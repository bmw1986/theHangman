package thePackage;

import gnu.io.*;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.TooManyListenersException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import sun.security.util.Length;

@SuppressWarnings("serial")
public class GUI extends JPanel implements SerialPortEventListener {
	
	
	///////////////////////////       Variables       //////////////////////////////
    static boolean head = false;  static boolean body = false;  static boolean leftArm = false;
    static boolean rightArm = false;  static boolean leftLeg = false;  static boolean rightLeg = false;
    private static InputStream input = null;  static String outPut = "";
    static String logText = "";  popUpGUI window = null; @SuppressWarnings("rawtypes")
	private Enumeration ports = null; @SuppressWarnings("rawtypes")	private HashMap portMap = new HashMap();
	private CommPortIdentifier selectedPortIdentifier = null; private static SerialPort serialPort = null;
	private static OutputStream output = null; private boolean bConnected = false;
	final static int TIMEOUT = 2000; final static int SPACE_ASCII = 32;
	final static int DASH_ASCII = 45; final static int NEW_LINE_ASCII = 10; static JFrame theFrame;
	static String theWord = null; static int distinctChars; static String[] usedLetters = new String[20];
	static boolean CorrectOrNot; static int currentBodyPart = 0; static int winnerYet = 0;
	static int doneYet = 0; static int lettersInArray = 0; 	static boolean keepGoing = true;
	static String letter = null; static char theChar; static int ascii = 0;
	///////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) throws IOException {
		
    	new popUpGUI().setVisible(true);
    	theFrame = new JFrame();
	   	
		theWord = ReadFromFile.findWord();
		distinctChars = GameLogic.determineIndivisualChars(theWord);
	   	
	   	System.out.println(theWord);
		System.out.println(distinctChars);
    	
		theFrame.pack();
	    theFrame.setSize(new Dimension(800, 600));
	    theFrame.setContentPane(new Paint());
	    theFrame.setVisible(true);
	}
    
	///////////////////////////////////////////////////////////////////////////////
	
	public GUI(popUpGUI window) {
		this.window = window;
	}
	
	///////////////////////////////////////////////////////////////////////////////
	
    public static int toAscii (String s) {
        StringBuilder sb = new StringBuilder();
        String ascString = null;
        
        if (s.equals(""))
        	s = "1";
    
        int asciiInt;
                for (int i = 0; i < s.length(); i++){
                    sb.append((int)s.charAt(i));
                    s.charAt(i);
                }
                ascString = sb.toString();
                asciiInt = Integer.parseInt(ascString);
                return asciiInt;
    }
    
	///////////////////////////////////////////////////////////////////////////////

    @SuppressWarnings("unchecked")
	public void searchForPorts()
    {
        ports = CommPortIdentifier.getPortIdentifiers();

        while (ports.hasMoreElements())
        {
            CommPortIdentifier curPort = (CommPortIdentifier)ports.nextElement();

            //get only serial ports
            if (curPort.getPortType() == CommPortIdentifier.PORT_SERIAL)
            {
                window.cboxPorts.addItem(curPort.getName());
                portMap.put(curPort.getName(), curPort);
            }
        }
    }

	///////////////////////////////////////////////////////////////////////////////

    public void connect()
    {
        String selectedPort = (String)window.cboxPorts.getSelectedItem();
        selectedPortIdentifier = (CommPortIdentifier)portMap.get(selectedPort);

        CommPort commPort = null;

        try
        {
            //the method below returns an object of type CommPort
            commPort = selectedPortIdentifier.open("theControlPanel", TIMEOUT);
            //the CommPort object can be casted to a SerialPort object
            setSerialPort((SerialPort)commPort);

            //for controlling GUI elements
            setConnected(true);

            //logging
            logText = selectedPort + " opened successfully.";
            window.txtLog.setForeground(Color.black);
            window.txtLog.append(logText + "\n");

            //CODE ON SETTING BAUD RATE ETC OMITTED
            //XBEE PAIR ASSUMED TO HAVE SAME SETTINGS ALREADY
            setSerialPortParameters();
            
            //enables the controls on the GUI if a successful connection is made
            window.keybindingController.toggleControls();
        }
        catch (PortInUseException e)
        {
            logText = selectedPort + " is in use. (" + e.toString() + ")";
            
            window.txtLog.setForeground(Color.RED);
            window.txtLog.append(logText + "\n");
        }
        catch (Exception e)
        {
            logText = "Failed to open " + selectedPort + "(" + e.toString() + ")";
            window.txtLog.append(logText + "\n");
            window.txtLog.setForeground(Color.RED);
        }
    }
    
	///////////////////////////////////////////////////////////////////////////////

    private void setSerialPortParameters() throws IOException {
        int baudRate = 9600;
 
        try {
            getSerialPort().setSerialPortParams(
                    baudRate,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
 
            getSerialPort().setFlowControlMode(
                    SerialPort.FLOWCONTROL_NONE);
        } catch (UnsupportedCommOperationException ex) {
            throw new IOException("Unsupported serial port parameter");
        }
    }
    
	///////////////////////////////////////////////////////////////////////////////

    public boolean initIOStream()
    {
        //return value for whether opening the streams is successful or not
        boolean successful = false;

        try {
            //
            input = getSerialPort().getInputStream();
            output = getSerialPort().getOutputStream();
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

	///////////////////////////////////////////////////////////////////////////////

    public void initListener()
    {
        try
        {
            getSerialPort().addEventListener(this);
            getSerialPort().notifyOnDataAvailable(true);
        }
        catch (TooManyListenersException e)
        {
            logText = "Too many listeners. (" + e.toString() + ")";
            window.txtLog.setForeground(Color.red);
            window.txtLog.append(logText + "\n");
        }
    }

	///////////////////////////////////////////////////////////////////////////////

    public void disconnect()
    {
        //close the serial port
        try
        {
            writeData(0);

            getSerialPort().removeEventListener();
            getSerialPort().close();
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
            logText = "Failed to close " + getSerialPort().getName() + "(" + e.toString() + ")";
            window.txtLog.setForeground(Color.red);
            window.txtLog.append(logText + "\n");
        }
    }
    
	///////////////////////////////////////////////////////////////////////////////

    final public boolean getConnected()
    {
        return bConnected;
    }
    
	///////////////////////////////////////////////////////////////////////////////

    public void setConnected(boolean bConnected)
    {
        this.bConnected = bConnected;
    }

	///////////////////////////////////////////////////////////////////////////////

    public void serialEvent(SerialPortEvent evt) {
       
    	if (evt.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
        	try {
                byte singleData = (byte)input.read();

                if (singleData != NEW_LINE_ASCII) {
                    logText = new String(new byte[] {singleData});
                    window.txtLog.append(logText);
                    outPut = logText;
                	letter = logText;
            		int key = toAscii(letter);
            		
            		if (key == 109)
            			key = 9;
            		
            		writeData(key);
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
        	
        	writeData(9);
        	
//        	for (int i=0; i < lettersInArray; i++) {
//        		if (usedLetter[i])
//        			
//        	}
        	
        	theChar = theWord.charAt(0); ascii = (int) theChar;
        	writeData(ascii);
        	theChar = theWord.charAt(1); ascii = (int) theChar;
        	writeData(ascii);
        	theChar = theWord.charAt(2); ascii = (int) theChar;
        	writeData(ascii);
        	theChar = theWord.charAt(3); ascii = (int) theChar;
        	writeData(ascii);
        	theChar = theWord.charAt(4); ascii = (int) theChar;
        	writeData(ascii);
        	writeData(20);
        	writeData(20);
        	writeData(20);
        	writeData(20);
        	writeData(20);
        	writeData(20);
        	writeData(20);
        	writeData(20);
        	writeData(20);
        	writeData(20);
        	writeData(20);
        	writeData(20);
        	writeData(20);
        	writeData(20);
        	writeData(20);
        	writeData(20);
        	writeData(20);
        	writeData(20);
        	writeData(20);
        	writeData(20);
        	
        }
    }

	///////////////////////////////////////////////////////////////////////////////

    public static void writeData(int asciiToWrite) {
        try {
			output.write(asciiToWrite);
            output.flush();
        } catch (Exception e) {
            logText = "Failed to write data. (" + e.toString() + ")";
        }
    }

    ///////////////////////////////////////////////////////////////////////////////

    public static String getOutPut() {
    	return outPut;
    }

	///////////////////////////////////////////////////////////////////////////////

	public static SerialPort getSerialPort() {
		return serialPort;
	}

	///////////////////////////////////////////////////////////////////////////////

	public static void setSerialPort(SerialPort serialPort) {
		GUI.serialPort = serialPort;
	}
	///////////////////////////////////////////////////////////////////////////////

}