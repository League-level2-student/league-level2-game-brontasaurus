package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class StartPanel extends JPanel implements KeyListener{
	
	Color startColor = Color.CYAN;
	
	@Override
	public void paintComponent(Graphics g){
		drawGame(g);
		//System.out.println("start panel paint");
	}
	
	void drawGame(Graphics g) {
		//System.out.println("soyo");
		g.setColor(startColor);
		g.fillRect(0, 0, Runner.WIDTH, Runner.HEIGHT);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
