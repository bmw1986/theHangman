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

import thePackage.*;

@SuppressWarnings("serial")
public class Main extends JPanel {
	
    static boolean head = false;  static boolean body = false;  static boolean leftArm = false;
    static boolean rightArm = false;  static boolean leftLeg = false;  static boolean rightLeg = false;
	
	public static void main(String[] args) throws IOException {
		
		String theWord = readFromFile.findWord();
	   	System.out.println(theWord);
	   	
		final JFrame theFrame = new JFrame();
		theFrame.repaint();
		
		
		KeyListener keyListener = new KeyListener() {
		
		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			
			if (key == KeyEvent.VK_1) {
				System.out.println("Head");
				Paint.getStatusOfPerson(1);
				theFrame.repaint();
			}
			if (key == KeyEvent.VK_2) {
				System.out.println("Body!");
				Paint.getStatusOfPerson(2);
				theFrame.repaint();
			}
			if (key == KeyEvent.VK_3) {
				System.out.println("leftArm");
				Paint.getStatusOfPerson(3);
				theFrame.repaint();
			}
			if (key == KeyEvent.VK_4) {
				System.out.println("rightArm");
				Paint.getStatusOfPerson(4);
				theFrame.repaint();
			}
			if (key == KeyEvent.VK_5) {
				System.out.println("leftLeg");
				Paint.getStatusOfPerson(5);
				theFrame.repaint();
			}
			if (key == KeyEvent.VK_6) {
				System.out.println("rightLeg");
				Paint.getStatusOfPerson(6);
				theFrame.repaint();
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

