package james;

public class TileManager {
	int timesUpdated = 0;
	public TileManager(){
		
	}
	public void updateTiles(Tile[][] tileArray){
		for (int xAxis = 0; xAxis < tileArray.length; xAxis++) {
			for (int yAxis = 0; yAxis < tileArray.length; yAxis++) {
				Tile tempT = tileArray[xAxis][yAxis].update();
				tileArray[xAxis][yAxis] = tempT;
				JamesGameState.map.getThisMap().setTileId(xAxis, yAxis, 0, tempT.currentTileID);
			}
		}
	}
	
	public void changeTile(int x, int y, int layer, int ID){
		Tile tempT = JamesGameState.map.tileArrayTileSet[ID-1];
		JamesGameState.map.tileArray[x][y] = tempT;
		JamesGameState.map.getThisMap().setTileId(x, y, layer, tempT.currentTileID);
		
	}
	
}
