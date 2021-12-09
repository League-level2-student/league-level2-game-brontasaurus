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

	
	int shop = 0;
	String message = "[NEED TO SET STRING]";
	int line = 0;
	JButton dialogButton = new JButton();
	JLabel textBox = new JLabel();
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	public static BufferedImage shopImage;
	
	
	ShopPanel(int shop){
		this.shop = shop;  
	}
	
	
	
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
			//System.out.println("message entering");
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
		
		switch(shop + Runner.gaamState.key) {
		case 1:
			loadShopImage("shopkeep.jpg");
			message = "Player - Have you seen a goose around here by any chance?";
			break;
		case 2:
			loadShopImage("madeline.jpg");
			message = "Player - Hello! Have you seen a goose run by here?";
			break;
		case 3:
			loadShopImage("fisherman.jpg");
			message = "Player - Hey did the goose run by here?";
			break;
		case 4:
			loadShopImage("farmer-face.jpg");
			message = "Player - Hey a goose is in your barn and it stole my \n sandwitch, can I have the key to get in?";
			break;
		case 5:
			loadShopImage("barn-1.jpg");
			message = "Farmer's Note - The door is locked! I'm out in the field \n if you need me";
			break;
		case 16:
			loadShopImage("barn-2.jpg");
			message = "Hey! Goose! Give me back my sandwitch!";
			break;
		
		
		}
		//loadShopImage("face-draft.jpg");
		
	}
	
	void loadShopImage(String imageFile) {
	   // if (needImage) {
	    	System.out.println("trying to load " + imageFile);
	        try {
	            shopImage = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
	           
		    gotImage = true;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        needImage = false;
	   // }
	    
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
		System.out.println(shop + " " + Runner.gaamState.key + " " + line);
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
		line++;
	
		switch(line + (shop*10) + (Runner.gaamState.key)) {
		case 10:
		message = "Player - Have you seen a goose around here by any chance?";
		break;
		case 11:
		message = "Shop keep - I haven't, sorry";
		break;
		case 12:
		message = "Player - That's alright";
		break;
		case 13:
		message = "Shop keep - Madeline from up the road might've seen \n something, try asking her";
		break;
		case 14:
		message = "Player - Ok! thank you";
		break;
		case 15:
		Runner.gaamState.user.setX(873);
		Runner.gaamState.user.setY(3390);
		Runner.gaamState.setCurrentState(Display.gameState.RETURN_TO_WORLD);
		break;
		case 20:
		message = "Player - Hello! Have you seen a goose run by here?";
		break;
		case 21:
		message = "Madeline - Oh yes I have actually! It ran up the \n street a couple minutes ago";
		break;
		case 22:
		message = "Player - Oh really?";
		break;
		case 23:
		message = "Madeline - Yeah! Jeremy might know where it went";
		break;
		case 24:
		message = "Player - I'll ask him, thank you";
		break;
		case 25:
		Runner.gaamState.user.setX(627);
		Runner.gaamState.user.setY(2196);
		Runner.gaamState.setCurrentState(Display.gameState.RETURN_TO_WORLD);
		break;
		case 30:
		message = "Player - Hey did the goose run by here?";
		break;
		case 31:
		message = "Jeremy - It did, it went toward the barn.";
		break;
		case 32:
		message = "Player - Ok, I'll head there now. Thank you";
		break;
		case 33:
		message = "Jeremy - Anytime. Good luck!";
		break;
		case 34:
		Runner.gaamState.user.setX(3297);
		Runner.gaamState.user.setY(1287);
		Runner.gaamState.setCurrentState(Display.gameState.RETURN_TO_WORLD);
		break;
		case 40:
		message = "Player - Hey a goose is in your barn and it stole my sandwitch, can I have the key to get in?";
		break;
		case 41:
		message = "Farmer - Oh sure! The geese around here are brutal huh. \n Good luck getting your sandwitch";
		break;
		case 42:
		Runner.gaamState.user.setX(4845);
		Runner.gaamState.user.setY(3657);
	
		Runner.gaamState.setCurrentState(Display.gameState.RETURN_TO_WORLD);
		Runner.gaamState.key = 10;
		break;
		case 50:
		message = "Farmer's Note - The door is locked! I'm out in the field if you need me";
		break;
		case 51: 
			Runner.gaamState.user.setX(5478);
			Runner.gaamState.user.setY(1194);
		Runner.gaamState.setCurrentState(Display.gameState.RETURN_TO_WORLD);
		break;
		case 60:
		message = "Hey! Goose! Give me back my sandwitch!";
		break;
		case 61:
		//Change image to something
		break;
		
		}
		displayDialog();
		
		}
		
	}
	
	
	
	
	
}
