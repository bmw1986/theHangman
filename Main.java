package thePackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import thePackage.readFromFile;

@SuppressWarnings("serial")
public class Main extends JPanel {
	
    static boolean head = false;  static boolean body = false;  static boolean leftArm = false;
    static boolean rightArm = false;  static boolean leftLeg = false;  static boolean rightLeg = false;
	
    public void paintStage (Graphics g) {		
    	super.paintComponent(g);
    	Graphics2D g2 = (Graphics2D) g;
 		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
 		g2.setPaint(Color.gray);
	
 		g2.draw(new Line2D.Double(320, 100, 480, 100)); // Top Beam
 		g2.draw(new Line2D.Double(320, 100, 320, 160)); // Rope
 		g2.draw(new Line2D.Double(200, 480, 600, 480));	// Bottom Line
    }
    
	public static void main(String[] args) throws IOException {
		
		String theWord = readFromFile.findWord();
	   	System.out.println(theWord);
		
		JFrame theFrame = new JFrame();
		theFrame.repaint();
		
//		KeyListener keyListener = new KeyListener() {
//			
//			@Override
//			public void keyReleased(KeyEvent e) {
//				int key = e.getKeyCode();
//				
//				if (key == KeyEvent.VK_1) {
//					System.out.println("Head");
//					head = true;
//				}
//				if (key == KeyEvent.VK_2) {
//					System.out.println("Body!");
//					body = true;
//				}
//				if (key == KeyEvent.VK_3) {
//					System.out.println("leftArm");
//					leftArm = true;
//				}
//				if (key == KeyEvent.VK_4) {
//					System.out.println("rightArm");
//					rightArm = true;
//				}
//				if (key == KeyEvent.VK_5) {
//					System.out.println("leftLeg");
//					leftLeg = true;
//				}
//				if (key == KeyEvent.VK_6) {
//					System.out.println("rightLeg");
//					rightLeg = true;
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
	}
}