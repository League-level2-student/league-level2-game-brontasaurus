package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ShopPanel extends JPanel implements KeyListener{

	String message = "Player - Have you seen a goose around here by any chance?";
	int line = 0;
	JButton dialogButton = new JButton();
	
	void displayDialog() {
		JOptionPane.showMessageDialog(null, message);
	}
	
	void setUp() {
		this.add(dialogButton);
		displayDialog();
	}
	
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		line++;
		
		switch(line) {
		case 0:
		message = "Player - Have you seen a goose around here by any chance?";
		break;
		case 1:
		message = "Shop keep - I haven't, sorry";
		break;
		case 2:
		message = "Player - That's alright";
		break;
		case 3:
		message = "Shop keep - [other person's name] from up the road might've seen something, try asking him";
		break;
		case 4:
		message = "Player - Ok! thank you";
		break;
		}
		displayDialog();
		
		}
		
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
