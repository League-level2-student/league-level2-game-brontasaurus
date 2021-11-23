package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class WorldPanel extends JPanel implements KeyListener, ActionListener {
	
	
	int store = 0;
	int h = 0;
	int v = 0;
	//boolean isPressed = false;
	Player user;
	public static BufferedImage collisionImage;
	int speed = 3;
	Timer timer = new Timer(1000/60, this);
	WorldPanel(Player player){
		user = player;
		timer.start();
		try {
			collisionImage = ImageIO.read(this.getClass().getResourceAsStream("collisionC.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//returns true if touching not white
	boolean checkCollision(int a, int b) {
		int pixel = collisionImage.getRGB(a, b) & 0x00ffffff;
		//System.out.println(pixel);
		if(pixel != 0x00ffffff) {
			store = sealision(a, b);
			
			return true;
		}
		else {
			store = 0;
			return false;
		}
		
	}
	
	
	int sealision(int a, int b) {
		int pixel = collisionImage.getRGB(a, b) & 0x00ffffff;
		System.out.println(String.format("0x%08X", pixel));
		switch(pixel) {
		//yellow
		case 0x00FEF200:
			System.out.println("yellow");
			return 1;
			
		//red
		//case 0x00FFFFFB:
		case 0x00FEFEFC:
			System.out.println("red");
			return 2;
			
		case 0x00FFFEFF:
			System.out.println("blue");
			return 3;
			
		case 0xff00ff:
			return 4;
			
		case 0x55ff00:
			return 5;
			
		case 0x00aaff:
			return 6;
			
		}
		System.out.println("not shop");
		return 0;
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			h = KeyEvent.VK_LEFT;
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			h = KeyEvent.VK_RIGHT;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			v = KeyEvent.VK_UP;
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			v = KeyEvent.VK_DOWN;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (h == e.getKeyCode()) {
			h = 0;
		}
		if (v == e.getKeyCode()) {
			v = 0;
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("action");
		//System.out.println(user.getX() + " " + user.getY());
		//if (!checkCollision(user.getX(), user.getY())) {
		if (Runner.gaamState.getCurrentState() == Display.gameState.WORLD || 
				Runner.gaamState.getCurrentState() == Display.gameState.RETURN_TO_WORLD) {
			if (v != 0) {
				
				switch(v) {
				case KeyEvent.VK_UP:
					if (!checkCollision(user.getX(), user.getY()-speed)) {
					user.setY(user.getY() - speed);
					}
					else {
						checkShop();
					}
				break;
				case KeyEvent.VK_DOWN:
					if (!checkCollision(user.getX(), user.getY()+speed)) {
					user.setY(user.getY() + speed);
					}
					else {
						checkShop();
					}
				break;
				
				}
			}
			if (h != 0) {
				switch(h) {
				case KeyEvent.VK_LEFT:
					if (!checkCollision(user.getX() - speed, user.getY())) {
					user.setX(user.getX() - speed);
					}
					else {
						checkShop();
					}
				break;
				case KeyEvent.VK_RIGHT:
					if (!checkCollision(user.getX() + speed, user.getY())) {
					user.setX(user.getX() + speed);
					}
					else {
						checkShop();
					}
				break;
				
				}
			}
		}
		
			
	}
	
	public void checkShop() {
		h = 0;
		v = 0;
		System.out.println("colliding");

		if (store > 0) {
		Runner.gaamState.setCurrentState(Display.gameState.FACE);
		}
			
	}
			

		
		
		
	}


