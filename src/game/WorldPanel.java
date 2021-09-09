package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class WorldPanel extends JPanel implements KeyListener, ActionListener {
	
	
	
	int keyPressed = 0;
	//boolean isPressed = false;
	Player user;
	int speed = 5;
	Timer timer = new Timer(1000/60, this);
	WorldPanel(Player player){
		user = player;
		timer.start();
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			keyPressed = KeyEvent.VK_LEFT;
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			keyPressed = KeyEvent.VK_RIGHT;
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			keyPressed = KeyEvent.VK_UP;
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			keyPressed = KeyEvent.VK_DOWN;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (keyPressed == e.getKeyCode()) {
			keyPressed = 0;
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("action");
		//System.out.println(user.getX() + " " + user.getY());
		if (keyPressed != 0) {
			switch(keyPressed) {
			case KeyEvent.VK_LEFT:
				user.setX(user.getX() - speed);
			break;
			case KeyEvent.VK_RIGHT:
				user.setX(user.getX() + speed);
			break;
			case KeyEvent.VK_UP:
				user.setY(user.getY() - speed);
			break;
			case KeyEvent.VK_DOWN:
				user.setY(user.getY() + speed);
			break;
			
			}
		}
		
	}

}
