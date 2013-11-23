package james;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class StartUp extends StateBasedGame {
	public static final float GRASS = 1;
	public static final float WOOD = 4; // res = 1
	public static final float CHOPPED = 2;
	public static final float ROAD = 0.5f;
	public static final int STONE = 10; // res = 2
	public static final int TILEHIGHT = 32;

	public StartUp() {
		super("BuilderGame");
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws SlickException
	 */
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new StartUp());
		app.setDisplayMode(800, 600, false);
		app.start();
		// TODO Auto-generated method stub

	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.addState(new MainMenuState(1));
		this.addState(new JamesGameState(2));
		this.addState(new CreditsState(3));

	}

}
