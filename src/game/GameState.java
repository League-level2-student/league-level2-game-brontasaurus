package game;

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
				startFrame.setSize(Runner.WIDTH, Runner.HEIGHT);
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
				worldMap.setSize(Runner.WIDTH, Runner.HEIGHT);
				worldMap.addKeyListener(worldMap.worldPanel);
				
				worldMap.add(object);
				break;
			case FACE:
				System.out.println("shop face showing");
				worldMap.shopDisplay();
				break;
			case END:
	
				break;
				
		}
	}
	
	
}
