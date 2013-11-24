package james;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

public class Mapy implements TileBasedMap {
	private TiledMap map;
	private TiledMap mapTileSet;
	public Tile[][] tileArray;
	public int mapX, mapY;
	public Image highlighted;

	public Mapy(String URL, String URL2) throws SlickException {
		map = new TiledMap(URL);
		mapTileSet = new TiledMap(URL2);
		highlighted = new Image("data/highlighted.png");
		loadMap();
	}

	private void loadMap() throws SlickException {
		StartUp.TFW.write("./output.txt", "data");

		tileArray = new Tile[map.getWidth()][map.getHeight()];

		for (int xAxis = 0; xAxis < map.getWidth(); xAxis++) {
			for (int yAxis = 0; yAxis < map.getHeight(); yAxis++) {

				int tileID = map.getTileId(xAxis, yAxis, 0);
				tileArray[xAxis][yAxis] = new Tile(Integer.parseInt(map
						.getTileProperty(tileID, "upgradeTime", "0")),
						(Integer.parseInt(map.getTileProperty(tileID,
								"upgradeTo", "0"))), (Integer.parseInt(map.getTileProperty(tileID, "make", "0"))), tileID);
			}
		}

	}
	
	public void changeTile(int x, int y, int layerIndex, int tileid){
		map.setTileId(x, y, layerIndex, tileid);
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
	
	public TiledMap getMapTileSet(){
		return mapTileSet;
	}

}
