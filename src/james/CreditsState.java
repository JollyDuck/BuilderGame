package james;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class CreditsState extends BasicGameState {
	
	int stateID = -1;
	
	CreditsState(int ID){
		stateID = ID;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		arg2.drawString("Tile art from http://opengameart.org/content/8x8-tileset-by-soundlust", arg0.getWidth()/8, arg0.getHeight()/8);
		arg2.drawString("Sprites from Philipp Lenssen at outer-court.com",arg0.getWidth()/8, arg0.getHeight()/4);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return stateID;
	}

}
