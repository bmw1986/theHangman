package thePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Paint extends JPanel {

    static boolean head = false;  static boolean body = false;  static boolean leftArm = false;
    static boolean rightArm = false;  static boolean leftLeg = false;  static boolean rightLeg = false;
    static boolean win = false;   static boolean lose = false;
	
    public static void getStatusOfPerson (int bodyPart, int doneYet) {
    	
	
    	if (bodyPart == 1)
    		head = true;
    	else if (bodyPart == 2)
    		body = true;
    	else if (bodyPart == 3)
    		leftArm = true;
    	else if (bodyPart == 4)
    		rightArm = true;
    	else if (bodyPart == 5)
    		leftLeg = true;
    	else if (bodyPart == 6)
    		rightLeg = true; 
	
    	if (doneYet == 1)
    		win = true;
    	else if (doneYet == 2)
    		lose = true;
    }
    
    
	@Override 
	public void paintComponent (Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(Color.gray);
        
        // Title
        g2.drawString("Welcome to Hangman",  340,  40);
        
        // Basic Setup
        g2.draw(new Line2D.Double(480, 100, 480, 480));
        g2.draw(new Line2D.Double(320, 100, 480, 100)); // Top Beam
        g2.draw(new Line2D.Double(320, 100, 320, 160)); // Rope
        g2.draw(new Line2D.Double(200, 480, 600, 480));        // Bottom Line

        if (head == true)
        	g2.draw(new Ellipse2D.Double(296, 160, 50, 60)); // Head
        
        if (body == true)
	        g2.draw(new Line2D.Double(320, 220, 320, 340)); // Body
        
	    if (leftArm == true)  
	        g2.draw(new Line2D.Double(320, 265, 280, 310)); // Left Arm
	    
	    if (rightArm == true)
	        g2.draw(new Line2D.Double(320, 265, 360, 310)); // Right Arm
	    
	    if (leftLeg == true)
	        g2.draw(new Line2D.Double(320, 340, 275, 430)); // Left Leg
	    
	    if (rightLeg == true)
	        g2.draw(new Line2D.Double(320, 340, 360, 430)); // Right Leg
	    
	    if (win == true) {
	    	g2.drawString("You've won!",  365,  60);
	    }
	    if (lose == true) {
	    	g2.drawString("Dude, you suck",  360,  60);
		}
	}
}