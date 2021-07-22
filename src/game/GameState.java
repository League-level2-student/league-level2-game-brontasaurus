package game;

public class GameState {
	private Display.gameState currentState;
	Display object;
	public Display.gameState getCurrentState () {
		return currentState;
	}

	GameState(){
		setCurrentState(Display.gameState.START);
	}
	
	public void setCurrentState (Display.gameState x) {
		currentState = x;
		
		switch(currentState) {
		default:
			case START:
				System.out.println("yhn");
				StartFrame startFrame = new StartFrame();
				startFrame.add(startFrame.startPanel);
				startFrame.setVisible(true);
				startFrame.setSize(Runner.WIDTH, Runner.HEIGHT);
				startFrame.addKeyListener(startFrame.startPanel);
				object = new Display();
				break;
			case WORLD:
				System.out.println("bhn");
				
				WorldMap worldMap = new WorldMap();
				worldMap.add(worldMap.worldPanel);
				worldMap.setVisible(true);
				worldMap.setSize(Runner.WIDTH, Runner.HEIGHT);
				worldMap.addKeyListener(worldMap.worldPanel);
				break;
			case FACE:
	
				break;
			case END:
	
				break;
				
		}
	}
	
	
}
