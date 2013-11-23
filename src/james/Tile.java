package james;

import org.newdawn.slick.geom.Vector2f;

public class Tile {
	Vector2f position;
	int type;

	public Tile(int type) {
		position = new Vector2f(0f, 0f);
		this.type = type;
	}

}
