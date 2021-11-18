package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ShopPanel extends JPanel implements KeyListener{

	String message = "Player - Have you seen a goose around here by any chance?";
	int line = 0;
	JButton dialogButton = new JButton();
	JLabel textBox = new JLabel();
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	public static BufferedImage shopImage;
	
	
	
	void displayDialog() {
		
		textBox.setText(message);
		System.out.println("message shown");
	}
	
	void drawShop(Graphics g) {
		if (gotImage) {
			g.drawImage(shopImage, 0, 0, Runner.WIDTH, Runner.HEIGHT, null);
		}
		g.setColor(new Color(180, 180, 180, 225));
		g.fillRoundRect(5, 400, (Runner.WIDTH-23), 60, 10, 10);
		g.setColor(new Color(180, 180, 180, 255));
		g.drawRoundRect(5, 400, (Runner.WIDTH-23), 60, 10, 10);
		Font myFont = new Font("Monospaced", Font.BOLD, 20);
		g.setColor(Color.white);
		g.setFont(myFont);
		
		if (message.contains("\n")) {
			System.out.println("message entering");
			int beginIndex = message.indexOf("\n");
			String messageTwo = message.substring(beginIndex + 2, message.length());
			String messageOne = message.substring(0, beginIndex);
			//System.out.println(messageOne + " " + messageTwo);
			g.drawString(messageOne, 15, 420);
			g.drawString(messageTwo, 15, 440);
		}
		else {
		g.drawString(message, 15, 420);
		//this.add(textBox);
		//this.setVisible(true);
		//displayDialog();
	}
	}
	
	void setUp() {
		//this.add(dialogButton);
		//this.add(textBox);
		//this.setVisible(true);
		displayDialog();
		loadShopImage("face-draft.jpg");
		
	}
	
	void loadShopImage(String imageFile) {
	    if (needImage) {
	    	System.out.println("trying to load " + imageFile);
	        try {
	            shopImage = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
	           
		    gotImage = true;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        needImage = false;
	    }
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
		System.out.println();
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
		message = "Shop keep - Madeline from up the road might've seen \n something, try asking her";
		break;
		case 4:
		message = "Player - Ok! thank you";
		break;
		case 5:
		Runner.gaamState.user.setX(Runner.gaamState.user.getX()+20);
		Runner.gaamState.setCurrentState(Display.gameState.RETURN_TO_WORLD);
		break;
		}
		displayDialog();
		
		}
		
	}
	
	
	
	
	
}
