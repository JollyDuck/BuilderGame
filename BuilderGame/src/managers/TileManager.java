package managers;

import james.Tile;

import org.newdawn.slick.Image;

import states.JamesGameState;

public class TileManager {
	public Image selectedTileImage;
	public int selectedTile;

	public TileManager() {
		selectedTile = 16;
		selectedTileImage = JamesGameState.map.getMapTileSet().getTileImage(
				selectedTile - 1, 0, 0);
	}

	public void updateSelectedTile(int i) {
		selectedTile += i;
		if (selectedTile >= 24) {
			selectedTile = 1;
		}
		if (selectedTile <= 0) {
			selectedTile = 23;
		}
		selectedTileImage = JamesGameState.map.getMapTileSet().getTileImage(
				selectedTile - 1, 0, 0);
	}

	public void updateTiles(Tile[][] tileArray) {
		for (int xAxis = 0; xAxis < tileArray.length; xAxis++) {
			for (int yAxis = 0; yAxis < tileArray.length; yAxis++) {
				Tile tempT = tileArray[xAxis][yAxis].update();
				tileArray[xAxis][yAxis] = tempT;
				JamesGameState.map.getThisMap().setTileId(xAxis, yAxis, 0,
						tempT.currentTileID);
			}
		}
	}

	public void changeTile(int x, int y, int layer) {
		/*
		 * Check with resH to see if change is allowed. Check if writing over
		 * base.
		 */
		Tile tempT = JamesGameState.map.tileArrayTileSet[selectedTile - 1];
		// If not writing over base
		if (x == 13 && y == 7) {
			// Do nothing
		} else {
			JamesGameState.map.tileArray[x][y] = tempT;
			JamesGameState.map.getThisMap().setTileId(x, y, layer,
					tempT.currentTileID);
		}

	}

}
