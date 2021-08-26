package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

//game panel

public class Display extends JPanel implements KeyListener, ActionListener{
	
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	Timer frameDraw = new Timer(1000/60,this);
	public static enum gameState {START, WORLD, FACE, END} 
	//public static gameState currentState = gameState.START;
	//GameState geemState = new GameState();
	BufferedImage windowWorld;
	public Player user;
	
	Display() {
		user = new Player();
		frameDraw.start();
		//JFrame gameFrame = new StartFrame();
		//WorldMap map = new WorldMap(); 
		//this.add(map);
		//gameFrame.setBounds(0, 0, WIDTH, HEIGHT);
		//gameFrame.setVisible(true);
		//gameFrame.pack();
		if (needImage) {
	        loadImage ("WorldMap1.jpg");
		}
	}
	
	void loadImage(String imageFile) {
	    if (needImage) {
	    	System.out.println("trying to load " + imageFile);
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        needImage = false;
	    }
	}
	
	void drawGame(Graphics g) {
		//g.setColor(Color.GREEN);
		//g.fillRect(0, 0, WIDTH, HEIGHT);
		//System.out.println(Runner.user.x);
		if (gotImage) {
			//g.drawImage(image, 0, 0, Runner.WIDTH, Runner.HEIGHT, null);
			//System.out.println((Runner.user.x-(Runner.WIDTH/2))+" "+ (Runner.user.y - (Runner.HEIGHT/2)) + " "+ (Runner.user.x+(Runner.WIDTH/2)) + " " +(Runner.user.y+(Runner.HEIGHT/2)));
			//windowWorld = image.getSubimage(Runner.user.x-Runner.WIDTH/2, Runner.user.y - Runner.HEIGHT/2,
					//Runner.user.x+Runner.WIDTH/2, Runner.user.y+Runner.HEIGHT/2);
			//windowWorld = image.getSubimage(375-Runner.WIDTH/2, 4250 - Runner.HEIGHT/2,
					//375 + Runner.WIDTH/2,4250 +Runner.HEIGHT/2);
			windowWorld = image.getSubimage(user.getX(), user.getY(), user.getX() + Runner.WIDTH , user.getY() + Runner.HEIGHT);
			g.drawImage(windowWorld, 0, 0, Runner.WIDTH, Runner.HEIGHT, null);
		} else {
			g.setColor(Color.green);
			g.fillRect(0, 0, Runner.WIDTH, Runner.HEIGHT);
		}
	}
	
	
	@Override
	public void paintComponent(Graphics g){
		//System.out.println("painted");
		drawGame(g);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		
		//if (e.getSource() == JButton) {
		
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
