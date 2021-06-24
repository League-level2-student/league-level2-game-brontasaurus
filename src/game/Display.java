package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

//game panel

public class Display extends JPanel implements KeyListener, ActionListener{
	
	Timer frameDraw = new Timer(1000/60,this);
	
	Display() {
		frameDraw.start();
		JFrame gameFrame = new StartFrame();
		//WorldMap map = new WorldMap(); 
		//this.add(map);
		gameFrame.setBounds(0, 0, WIDTH, HEIGHT);
		gameFrame.setVisible(true);
		gameFrame.pack();
		
	}
	
	
	
	void drawGame(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, WIDTH, HEIGHT);
	}
	
	
	@Override
	public void paintComponent(Graphics g){
		System.out.println("painted");
		drawGame(g);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
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
