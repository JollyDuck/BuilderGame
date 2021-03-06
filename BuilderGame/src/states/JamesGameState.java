package states;

import james.*;
import managers.*;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class JamesGameState extends BasicGameState {
	public static InputHandler inpH;
	public static ResourceCounter resH;
	public static TileManager tilM;
	public static MinionManager minM;
	public int stateID = -1;
	public static Mapy map;
	public static Vector2f hlTile; // the tile the highlighter has selected.
	public static Vector2f hlMap; // the coords to draw it on.

	JamesGameState(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		map = new Mapy("data/testmap.tmx", "data/tileSetInMap.tmx");
		tilM = new TileManager();
		inpH = new InputHandler();
		resH = new ResourceCounter();
		minM = new MinionManager(map);
		hlMap = new Vector2f(12 * 32, 8 * 32);
		hlTile = new Vector2f(12, 8);
		// TODO Auto-generated method stub

	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		// Draw map
		map.getThisMap().render(map.mapX, map.mapY, 0);
		g.drawImage(map.highlighted, hlMap.x, hlMap.y);
		minM.render(g);
		g.drawString(Integer.toString(map.mapX), 0, 0);
		g.drawString(Integer.toString(map.mapY), 0, 32);
		g.drawString(Float.toString(hlTile.x), 0, 64);
		g.drawString(Float.toString(hlTile.y), 0, 96);
		g.drawString(Integer.toString(resH.getTreeSeeds()), 700, 0);
		g.drawString(Integer.toString(resH.getCabbage()), 700, 32);
		g.drawImage(tilM.selectedTileImage, 650, 0);
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
		inpH.InputFromGameState(container, input);
		tilM.updateTiles(map.tileArray);
		minM.updateMinions();
		hlMap.x = (12 * 32) + ((map.mapX % 32));
		hlMap.y = (8 * 32) + ((map.mapY % 32));
		hlTile.x = 12 - ((map.mapX / 32));
		hlTile.y = 8 - ((map.mapY / 32));
		Display.sync(60);

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return stateID;
	}

}
