package james;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class JamesGameState extends BasicGameState {
	boolean debug = false;
	int stateID = -1;
	Mapy map;
	Vector2f hlTile; // the tile the highlighter has selected.
	Vector2f hlMap; // the coords to draw it on.

	JamesGameState(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		map = new Mapy("data/testmap.tmx");
		hlMap = new Vector2f(12*32,8*32);
		hlTile = new Vector2f(12, 8);
		// TODO Auto-generated method stub

	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		// Draw map
		map.getThisMap().render(map.mapX, map.mapY, 0);
		g.drawImage(map.highlighted, hlMap.x, hlMap.y);
		g.drawString(Integer.toString(map.mapX), 0, 0);
		g.drawString(Integer.toString(map.mapY), 0, 32);
		g.drawString(Float.toString(hlTile.x), 0, 64);
		g.drawString(Float.toString(hlTile.y), 0, 96);
		/*
		 * g.drawString("Push -a- to enter game", (container.getWidth() / 8),
		 * container.getHeight() / 8); g.drawString("Push -b- to enter credits",
		 * (container.getWidth() / 8), (container.getHeight() / 8) * 2);
		 */
		// TODO Auto-generated method stub

	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// Create an Input reader called input.
		Input input = container.getInput();
		hlMap.x = (12 * 32) + ((map.mapX % 32));
		hlMap.y = (8 * 32) + ((map.mapY % 32));
		hlTile.x=12-((map.mapX/32));
		hlTile.y=8-((map.mapY/32));
		
		if (input.isKeyDown(Input.KEY_LCONTROL)) {

			if (input.isKeyDown(Input.KEY_LEFT)) {
				map.mapX += 4;
			} else if (input.isKeyDown(Input.KEY_UP)) {
				map.mapY += 4;
			} else if (input.isKeyDown(Input.KEY_RIGHT)) {
				map.mapX -= 4;
			} else if (input.isKeyDown(Input.KEY_DOWN)) {
				map.mapY -= 4;
			} else if (input.isKeyPressed(Input.KEY_R)) {
				map.mapX = 0;
				map.mapY = 0;
			}
		}
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			container.exit();
		}
		Display.sync(60);

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return stateID;
	}

}
