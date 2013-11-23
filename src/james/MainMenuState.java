package james;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenuState extends BasicGameState {
	int stateID = -1;

	MainMenuState(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		g.drawString("Push -a- to enter game", (container.getWidth() / 8),
				container.getHeight() / 8);
		g.drawString("Push -b- to enter credits",
				(container.getWidth() / 8), (container.getHeight() / 8)*2);

		// TODO Auto-generated method stub

	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// Create an Input reader called input.
		Input input = container.getInput();
		// If the A key is pressed, then StateBasedGame sbg should enter state
		// 2.
		if (input.isKeyDown(Input.KEY_A)) {
			game.enterState(2);
		}
		else if (input.isKeyDown(Input.KEY_B)){
			game.enterState(3);
		}
		Display.sync(60);

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return stateID;
	}

}
