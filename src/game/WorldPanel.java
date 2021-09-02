package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class WorldPanel extends JPanel implements KeyListener {
	Player user;
	int speed = 5;

	WorldPanel(Player player){
		user = player;
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("left");
			user.setX(user.getX() - speed);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("right");
			user.setX(user.getX() + speed);
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("up");
			user.setY(user.getY() - speed);
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("down");
			user.setY(user.getY() + speed);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
