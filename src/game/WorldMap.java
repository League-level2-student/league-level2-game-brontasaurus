package game;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
//background
import javax.swing.JFrame;

public class WorldMap extends JFrame implements KeyListener, ActionListener{
	
	Player user;
	WorldPanel worldPanel;
	ShopPanel shopPanel;
	
	
	WorldMap(Player player){
		user = player;
		worldPanel = new WorldPanel(user);
		this.add(worldPanel);
		worldPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		worldPanel.addKeyListener(this);
		
	}
	
	void shopDisplay(){
		shopPanel = new ShopPanel(worldPanel.store);
		this.add(shopPanel);
		//this.pack();
		shopPanel.addKeyListener(this);
		shopPanel.requestFocus();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("press");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Shop Key Released");
		shopPanel.keyReleased(e);
		
	}
	


}
