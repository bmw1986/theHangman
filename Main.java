package thePackage;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;

import thePackage.Paint;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = null;
		String[] theWords = new String[10];
		try {
			in = new BufferedReader(new FileReader("/Volumes/The Data/Freddy/theWords.txt"));
			
			int index = 0;
			String l;
			while ((l = in.readLine()) != null) {
				System.out.println(l);
				theWords[index] = l;
				index++;
			}			
		} finally {
			if (in != null) 
				in.close();
		}
		
		int randomNum = 0 + (int)(Math.random()*10);
		
		String theWord = theWords[randomNum];
		
		JFrame theFrame = new JFrame();
		
//		Paint.paintStage(null);
//		
//		theFrame.repaint();
//		
//		KeyListener keyListener = new KeyListener() {
//			
//			@Override
//			public void keyReleased(KeyEvent e) {
//				int key = e.getKeyCode();
//				
//				if (key == KeyEvent.VK_1) {
//					System.out.println("You have pressed an \"1\" on the keyboard!");
//					Paint.paintHead(null);
////					theFrame.repaint();
//				}
//				if (key == KeyEvent.VK_2) {
//					System.out.println("You have pressed an \"2\" on the keyboard!");
//					Paint.paintBody(null);
////					theFrame.repaint();
//				}
//				if (key == KeyEvent.VK_3) {
//					System.out.println("You have pressed an \"3\" on the keyboard!");
//					Paint.paintLeftArm(null);
////					theFrame.repaint();
//				}
//				if (key == KeyEvent.VK_4) {
//					System.out.println("You have pressed an \"4\" on the keyboard!");
//					Paint.paintRightArm(null);
////					theFrame.repaint();
//				}
//				if (key == KeyEvent.VK_5) {
//					System.out.println("You have pressed an \"5\" on the keyboard!");
//					Paint.paintLeftLeg(null);
////					theFrame.repaint();
//				}
//				if (key == KeyEvent.VK_6) {
//					System.out.println("You have pressed an \"6\" on the keyboard!");
//					Paint.paintRightLeg(null);
////					theFrame.repaint();
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