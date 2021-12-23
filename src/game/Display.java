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
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
//game panel

public class Display extends JPanel implements KeyListener, ActionListener{
	
	public static BufferedImage image;
	public static BufferedImage playerImage;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	Timer frameDraw = new Timer(1000/60,this);
	Player player;
	public static enum gameState {START, WORLD, RETURN_TO_WORLD, FACE, END} 
	
	//public static gameState currentState = gameState.START;
	//GameState geemState = new GameState();
	BufferedImage windowWorld;
	//public Player user;
	
	Display(Player user) {
		player = user;
		frameDraw.start();
		//JFrame gameFrame = new StartFrame();
		//WorldMap map = new WorldMap(); 
		//this.add(map);
		//gameFrame.setBounds(0, 0, WIDTH, HEIGHT);
		//gameFrame.setVisible(true);
		//gameFrame.pack();
		if (needImage) {
	        //loadImage ("WorldMap1.jpg");
			loadImage ("worldmap.jpg", "PLayer.png");
		
		}
	}
	
	void loadImage(String imageFile, String pi) {
	    if (needImage) {
	    	System.out.println("trying to load " + imageFile);
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
	           playerImage = ImageIO.read(this.getClass().getResourceAsStream(pi));
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
//System.out.println(player.getX() + " " + player.getY());
		
		
		
		if (gotImage) {

			windowWorld = image.getSubimage(player.getX()-(Runner.WIDTH/2), player.getY()-(Runner.HEIGHT/2), Runner.WIDTH , Runner.HEIGHT);
			g.drawImage(windowWorld, 0, 0, Runner.WIDTH, Runner.HEIGHT, null);
		
			g.setColor(Color.ORANGE);
			
			double rotationRequired = Math.toRadians (Runner.gaamState.worldMap.worldPanel.rotation);
            double locationX = playerImage.getWidth() / 2;
            double locationY = playerImage.getHeight() / 2;
            AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
            
            BufferedImage jhk = op.filter(playerImage, null);
            // Drawing the rotated image at the required drawing locations
           // g2d.drawImage(op.filter(image, null), 365, 270, null);
            //150, 107
            
            if((Runner.gaamState.worldMap.worldPanel.rotation % 90)==0) {
            	g.drawImage(jhk, 290, 187, 80, 80, null);
            }
            else {
            	g.drawImage(jhk, 290, 187, 100, 100, null);
            }
            
			
			//g.fillRect(player.getX()-10, player.getY()-10, 20, 20);
			/*if (Runner.gaamState.getCurrentState() == Display.gameState.FACE) {
			Runner.gaamState.worldMap.shopPanel.drawShop();
			}*/
		} 
		
		else {
			g.setColor(Color.green);
			g.fillRect(0, 0, Runner.WIDTH, Runner.HEIGHT);
		}
	}
	
	
	@Override
	public void paintComponent(Graphics g){
		//System.out.println("painted");
		drawGame(g);
		
		if (Runner.gaamState.getCurrentState() == Display.gameState.FACE) {
			Runner.gaamState.worldMap.shopPanel.drawShop(g);
		}
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
