package thePackage;

import java.awt.*; 
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;

//import javax.comm.*;
import java.util.*;

import thePackage.Paint;

@SuppressWarnings("serial")

public class Main extends JApplet implements ActionListener {

	Button yesButton, noButton;
	JLabel welcome, areYouSure;
	
	public void init() {
		setBackground(Color.white);
		setForeground(Color.white);
		setLayout(new FlowLayout());
	}
	
	public void actionPerformed (ActionEvent evt) {
		if (evt.getSource() == yesButton) {
			repaint();
		} else if (evt.getSource() == noButton) 
			repaint();
	}
	
	public static void main(String[] args) {
		
		// Create the Program Frame
	    final JFrame theFrame = new JFrame("Hangman for CompE Junior Lab");
	
	    final Graphics g = theFrame.getGraphics();
//	   
//	    final Graphics2D g2 = (Graphics2D) g;
//		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		g2.setPaint(Color.gray);
	    
	    //////////////////////// RS232 ////////////////////////////
	    
	    
	    
	    ///////////////////////////////////////////////////////////
	    
	    KeyListener keyListener = new KeyListener() {
		
			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
				
				if (key == KeyEvent.VK_1) {
					System.out.println("You have pressed an \"1\" on the keyboard!");
					Paint.paintComponent(g);
//					theFrame.repaint();
				}
				if (key == KeyEvent.VK_2) {
					System.out.println("You have pressed an \"2\" on the keyboard!");
//					g2.draw(new Line2D.Double(320, 220, 320, 340)); // Body
				}
				if (key == KeyEvent.VK_3) {
					System.out.println("You have pressed an \"3\" on the keyboard!");
//					g2.draw(new Line2D.Double(320, 265, 280, 310)); // Left Arm
				}
				if (key == KeyEvent.VK_4) {
					System.out.println("You have pressed an \"4\" on the keyboard!");
//					g2.draw(new Line2D.Double(320, 265, 360, 310)); // Right Arm
				}
				if (key == KeyEvent.VK_5) {
					System.out.println("You have pressed an \"5\" on the keyboard!");
//					g2.draw(new Line2D.Double(320, 340, 275, 430)); // Left Leg
				}
				if (key == KeyEvent.VK_6) {
					System.out.println("You have pressed an \"6\" on the keyboard!");
//					g2.draw(new Line2D.Double(320, 340, 360, 430)); // Right Leg
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
		
		theFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent e) {
	            System.exit(0);
	         }
	      });
		
	    JApplet applet = new Main();
	    theFrame.getContentPane().add("Center", applet);
	    applet.init();
	      
	    theFrame.pack();
	    theFrame.setSize(new Dimension(800, 600));
	    theFrame.setVisible(true);
	}
}