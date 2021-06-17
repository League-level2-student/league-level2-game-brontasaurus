package game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
//starting screen
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartFrame extends JFrame implements KeyListener{

	Color startColor = Color.CYAN;
	JButton startButton = new JButton();
	StartPanel startPanel = new StartPanel();
	
	
	StartFrame(){
		this.add(startPanel);
		startPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		startButton.setPreferredSize(new Dimension(80, 40));
		startButton.setText("START");
		startPanel.add(startButton);
		
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


