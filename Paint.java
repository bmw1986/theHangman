package thePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class Paint {

	public static void paintStage(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(Color.gray);
		
		// Title
		g2.drawString("Welcome to Hangman",  340,  40);
		
		// Basic Setup
		g2.draw(new Line2D.Double(480, 100, 480, 480));
		g2.draw(new Line2D.Double(320, 100, 480, 100)); // Top Beam
		g2.draw(new Line2D.Double(320, 100, 320, 160)); // Rope
		g2.draw(new Line2D.Double(200, 480, 600, 480));	// Bottom Line
		
	}
	
	public static void paintHead(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(Color.gray);
		g2.draw(new Ellipse2D.Double(296, 160, 50, 60)); // Head
	}
	
	public static void paintBody(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(Color.gray);
		g2.draw(new Line2D.Double(320, 220, 320, 340)); // Body
	}
	
	public static void paintLeftArm(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(Color.gray);
		g2.draw(new Line2D.Double(320, 265, 280, 310)); // Left Arm
	}
	
	public static void paintRightArm(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(Color.gray);
		g2.draw(new Line2D.Double(320, 265, 360, 310)); // Right Arm
	}
	
	public static void paintLeftLeg(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(Color.gray);
		g2.draw(new Line2D.Double(320, 340, 275, 430)); // Left Leg
	}
	
	public static void paintRightLeg(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(Color.gray);
		g2.draw(new Line2D.Double(320, 340, 360, 430)); // Right Leg
	}
	
}