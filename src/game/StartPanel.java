package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class StartPanel extends JPanel implements KeyListener{
	
	Color startColor = Color.CYAN;
	public static BufferedImage startImage;
	public static boolean needStartImage = true;
	public static boolean gotStartImage = false;
	
	
	StartPanel() {
		try {
            startImage = ImageIO.read(this.getClass().getResourceAsStream("startScreen.jpg"));
           
	    gotStartImage = true;
		} catch (Exception e) {
            e.printStackTrace();
        }
        needStartImage = false;
	}
	
	
	
	@Override
	public void paintComponent(Graphics g){
		drawGame(g);
		//System.out.println("start panel paint");
		if (gotStartImage) {
			g.drawImage(startImage, 0, 0, Runner.WIDTH, Runner.HEIGHT, null);
		}
	}
	
	void drawGame(Graphics g) {
		//System.out.println("soyo");
		//g.setColor(startColor);
		//g.fillRect(0, 0, Runner.WIDTH, Runner.HEIGHT);
		
		
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
