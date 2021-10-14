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
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	int sealision(int a, int b) {
		int pixel = collisionImage.getRGB(a, b) & 0x00ffffff;
		switch(pixel) {
		case 0xfff200:
			return 1;
			
		case 0xff000:
			return 2;
			
		case 0x1500ff:
			return 3;
			
		case 0xff00ff:
			return 4;
			
		case 0x55ff00:
			return 5;
			
		case 0x00aaff:
			return 6;
			
		}
		
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
		if (!checkCollision(user.getX(), user.getY())) {
			
			switch(sealision(user.getX(), user.getY())) {
			
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			
			}
			
		if (v != 0) {
			
			switch(v) {
			case KeyEvent.VK_UP:
				if (!checkCollision(user.getX(), user.getY()-speed)) {
				user.setY(user.getY() - speed);
				}
			break;
			case KeyEvent.VK_DOWN:
				if (!checkCollision(user.getX(), user.getY()+speed)) {
				user.setY(user.getY() + speed);
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
			break;
			case KeyEvent.VK_RIGHT:
				if (!checkCollision(user.getX() + speed, user.getY())) {
				user.setX(user.getX() + speed);
				}
			break;
			
			}
		}
		}
		
		
		
		
	}

}
