package game;

import java.awt.Dimension;

public class GameState {
	private Display.gameState currentState;
	Display object;
	StartFrame startFrame = null;
	WorldMap worldMap = null;
	public Player user;
	public Display.gameState getCurrentState () {
		return currentState;
	}
	
	

	GameState(){
		user = new Player();
		setCurrentState(Display.gameState.START);
		
	}
	
	public void setCurrentState (Display.gameState x) {
		currentState = x;
		
		
		
		switch(currentState) {
		default:
			
			case START:
				System.out.println("creating start");
				startFrame = new StartFrame();
				startFrame.add(startFrame.startPanel);
				startFrame.setVisible(true);
				startFrame.pack();
				startFrame.setSize(Runner.WIDTH + 12, Runner.HEIGHT+35);
				startFrame.addKeyListener(startFrame.startPanel);
				object = new Display(user);
				
				break;
			case WORLD:
				if (startFrame != null)
				startFrame.dispose();
				System.out.println("creating world map");
				
				worldMap = new WorldMap(user);
				worldMap.add(worldMap.worldPanel);
				worldMap.setVisible(true);
				worldMap.pack();
				worldMap.setSize(Runner.WIDTH + 12, Runner.HEIGHT+35);
				worldMap.addKeyListener(worldMap.worldPanel);
				
				worldMap.add(object);
				
				break;
			case RETURN_TO_WORLD:
				worldMap.remove(worldMap.shopPanel);
				worldMap.requestFocus();
				break;
			case FACE:
				System.out.println("shop face showing");
				
				worldMap.shopDisplay();
				worldMap.shopPanel.setUp();
				worldMap.shopPanel.setVisible(true);
				worldMap.shopPanel.setPreferredSize(new Dimension(Runner.WIDTH, Runner.HEIGHT));
				
				break;
			case END:
	
				break;
				
		}
	}
	
	
}
