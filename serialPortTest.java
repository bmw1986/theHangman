package thePackage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.TooManyListenersException;

import javax.comm.CommDriver;
import javax.comm.CommPortIdentifier;
import javax.comm.PortInUseException;
import javax.comm.SerialPort;
import javax.comm.SerialPortEvent;
import javax.comm.SerialPortEventListener;
import javax.comm.UnsupportedCommOperationException;

public class serialPortTest implements Runnable, SerialPortEventListener {

   static CommPortIdentifier portId;
   static CommPortIdentifier saveportId;
   static Enumeration     portList;
   InputStream       inputStream;
   SerialPort        serialPort;
   Thread        readThread;
 
   static String      messageString = "Hello, world!";
   static OutputStream    outputStream;
   static boolean     outputBufferEmptyFlag = false;
   public static void main(String[] args) {
    boolean      portFound = false;
    String       defaultPort;
        String driverName = "com.sun.comm.Win32Driver";
        System.setSecurityManager(null);
        try{
            CommDriver commdriver =
            (CommDriver)Class.forName(driverName).newInstance( );
            commdriver.initialize();
        }
            catch (Exception e2)
        {
            e2.printStackTrace();
        }
 
    String osname = System.getProperty("os.name","").toLowerCase();
    if ( osname.startsWith("windows") ) {
       // windows
       defaultPort = "COM1";
    } else if (osname.startsWith("linux")) {
       // linux
      defaultPort = "/dev/ttyUSB0";
    } else if ( osname.startsWith("mac") ) {
       defaultPort = "/dev/tty.usbmodem621";
    } else {
       System.out.println("Sorry, your operating system is not supported");
       return;
    }
    if (args.length > 0) {
       defaultPort = args[0];
    }
 
    System.out.println("Set default port to "+defaultPort);
    portList = CommPortIdentifier.getPortIdentifiers();
        System.out.println("portList has more elements? (any?): "+portList.hasMoreElements());
    while (portList.hasMoreElements()) {
       portId = (CommPortIdentifier) portList.nextElement();
           System.out.println("portId: "+portId.getName());
       if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
        if (portId.getName().equals(defaultPort)) {
           System.out.println("Found port: "+defaultPort);
           portFound = true;
           serialPortTest reader = new serialPortTest();
        }
       }
    }
    if (!portFound) {
       System.out.println("port " + defaultPort + " not found.");
    }
   }
   public void initwritetoport() {
    try {
       outputStream = serialPort.getOutputStream();
    } catch (IOException e) {}
//  try {
//     serialPort.notifyOnOutputEmpty(true);
//  } catch (Exception e) {
//     System.out.println("Error setting event notification");
//     System.out.println(e.toString());
//     System.exit(-1);
//  }
 
   }
   public void writetoport() {
    System.out.println("Writing \""+messageString+"\" to "+serialPort.getName());
    try {
       // write string to serial port
       outputStream.write(messageString.getBytes());
    } catch (IOException e) {}
   }
 
   public serialPortTest() {
    // initalize serial port
    try {
       serialPort = (SerialPort) portId.open("SimpleReadApp", 2000);
    } catch (PortInUseException e) {}

    try {
       inputStream = serialPort.getInputStream();
    } catch (IOException e) {}
    try {
       serialPort.addEventListener(this);
    } catch (TooManyListenersException e) {}
    serialPort.notifyondataavailable(true);
    try {
       serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8,
               SerialPort.STOPBITS_1,
               SerialPort.PARITY_NONE);
    } catch (UnsupportedCommOperationException e) {}
    // start the read thread
    readThread = new Thread(this);
    readThread.start();

   }
   public void run() {
    initwritetoport();
    try {
       while (true) {
        writetoport();
        Thread.sleep(1000);
       }
    } catch (InterruptedException e) {}
   }
   public void serialEvent(SerialPortEvent event) {
    switch (event.getEventType()) {
    case SerialPortEvent.BI:
    case SerialPortEvent.OE:
    case SerialPortEvent.FE:
    case SerialPortEvent.PE:
    case SerialPortEvent.CD:
    case SerialPortEvent.CTS:
    case SerialPortEvent.DSR:
    case SerialPortEvent.RI:
    case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
       break;
    case SerialPortEvent.DATA_AVAILABLE:
       // we get here if data has been received
       byte[] readBuffer = new byte[20];
       try {
        // read data
        while (inputStream.available() > 0) {
           int numBytes = inputStream.read(readBuffer);
        }
        String result  = new String(readBuffer);
        System.out.println("Reading input:"+result);
       } catch (IOException e) {}
 
       break;
    }
   }
}
