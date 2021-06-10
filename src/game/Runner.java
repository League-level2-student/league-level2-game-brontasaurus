package game;

import javax.swing.JFrame;
//league invaders
public class Runner {

	JFrame frame;
	Display object;
	public static final int WIDTH = 1500;
	public static final int HEIGHT = 1000;
	
	public static void main(String[] args) {
		Display game;
	}
	
	void setUp() {
		
		frame = new JFrame();
		object = new Display(frame);
		frame.add(object);
		frame.setVisible(true);
		frame.addKeyListener(object);
	}
	
}
