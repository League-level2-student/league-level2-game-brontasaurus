package game;

import javax.swing.JFrame;
//league invaders
public class Runner {

	//JFrame frame;
	//Display object;
	public static final int WIDTH = 750;
	public static final int HEIGHT = 500;
	public static int gameState = 0;
	
	public static void main(String[] args) {
		Runner game = new Runner();
		game.setUp();
		
	}
	
	
	
	void setUp() {
		StartFrame startFrame = new StartFrame();
		//object = new Display();
		startFrame.add(startFrame.startPanel);
		startFrame.setVisible(true);
		startFrame.setSize(WIDTH, HEIGHT);
		startFrame.addKeyListener(startFrame.startPanel);
		//startFrame.pack();
	}
	
}
