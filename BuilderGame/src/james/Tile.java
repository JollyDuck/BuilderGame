package james;

import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.tiled.TiledMap;

public class Tile {
	Vector2f position;
	boolean manage = true;
	int currentTileID;
	int upgradeTime;
	private int timeTillUpgrade;
	int tileIDToChangeTo;
	int resourceToGenerate; // 1 for wood, 2 for cabbage.

	/**
	 * 
	 * @param upgradeTime
	 *            Time needed to upgrade.
	 * @param tileIDToChangeTo
	 *            ID of what to upgrade into.
	 * @param resToGen
	 *            The resource to generate when upgrading. If 0 then nothing, 1
	 *            for wood, 2 for cabbage.
	 */
	public Tile(int upgradeTime, int tileIDToChangeTo, int resToGen, int tileID) {
		position = new Vector2f(0f, 0f);
		this.upgradeTime = upgradeTime*10;
		timeTillUpgrade = upgradeTime*10;
		this.tileIDToChangeTo = tileIDToChangeTo;
		this.resourceToGenerate = resToGen;
		currentTileID = tileID;
		if (upgradeTime == 0) {
			manage = false;
		}
	}
	
	public Tile update() {
		if (manage) {
			timeTillUpgrade--;
			if (timeTillUpgrade <= 0) {
				StartUp.TFW.write("./successfully.txt", "timeTillUpgrade =" + Integer.toString(timeTillUpgrade));

				// Generate new resources (if necessary)
				switch (resourceToGenerate) {
				default:
					break;
				case 1:
					JamesGameState.resH.addWood(4);
					break;
				case 2:
					JamesGameState.resH.addCabbage(16);
					break;
				}

				return makeNewTile(this);
			}
		}
		return this;
	}

	/**
	 * Makes a new tile based on the tileIDToChangeTo from the current Tile.
	 * 
	 * @param tile
	 *            The current Tile that has information about the target tile.
	 *            Could change this so that it only takes in the target tile
	 *            information, in theory.
	 * @return returns the new tile to be made.
	 */
	private Tile makeNewTile(Tile tile) {
		int targetTileid = tile.tileIDToChangeTo;
		int nextTimeToUpgrade, nextTileIDToChangeTo, nextResToGen;
		TiledMap mapTileSet = JamesGameState.map.getMapTileSet();
		nextTimeToUpgrade = Integer.parseInt(mapTileSet.getTileProperty(
				targetTileid, "upgradeTime", "0"));
		nextTileIDToChangeTo = Integer.parseInt(mapTileSet.getTileProperty(
				targetTileid, "upgradeTo", "0"));
		nextResToGen = Integer.parseInt(mapTileSet.getTileProperty(
				targetTileid, "make", "0"));
		return new Tile(nextTimeToUpgrade, nextTileIDToChangeTo, nextResToGen, targetTileid);

	}

}
