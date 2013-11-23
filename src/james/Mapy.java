package james;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

public class Mapy implements TileBasedMap {
	private Tile[][] tileArray;
	private TiledMap map;
	public int mapX, mapY;
	public Image highlighted;

	public Mapy(String URL) throws SlickException {
		map = new TiledMap(URL);
		highlighted = new Image("data/highlighted.png");
		loadMap();
	}

	private void loadMap() throws SlickException {
		tileArray = new Tile[map.getWidth()][map.getHeight()];

		for (int xAxis = 0; xAxis < map.getWidth(); xAxis++) {
			for (int yAxis = 0; yAxis < map.getHeight(); yAxis++) {

				int tileID = map.getTileId(xAxis, yAxis, 0);
				tileArray[xAxis][yAxis] = new Tile(Integer.parseInt(map
						.getTileProperty(tileID, "type", "0")));
			}
		}
	}

	@Override
	public boolean blocked(PathFindingContext arg0, int arg1, int arg2) {
		return false;
	}

	@Override
	public float getCost(PathFindingContext arg0, int arg1, int arg2) {
		return 0;
	}

	@Override
	public int getHeightInTiles() {
		return map.getHeight();
	}

	@Override
	public int getWidthInTiles() {
		return map.getWidth();
	}

	@Override
	public void pathFinderVisited(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	public TiledMap getThisMap() {
		return map;
	}

}
