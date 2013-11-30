package james;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.util.pathfinding.AStarPathFinder;
import org.newdawn.slick.util.pathfinding.Mover;
import org.newdawn.slick.util.pathfinding.Path;
import org.newdawn.slick.util.pathfinding.PathFinder;

import pathfinding.JamesHeuristic;
import states.StartUp;

public class Minion implements Mover {
	private float timeToMove;
	private Vector2f pos;
	public boolean carrying;
	public boolean busy;
	private PathFinder finder;
	private PathFinder resFinder;
	private Path path;
	public int pathLength;
	public int posOnPath;
	Mapy map;

	public Image sprite;

	public Minion(float x, float y, Image sprite, Mapy map) {
		this.map = map;
		pos = new Vector2f(x, y);
		this.sprite = sprite;
		carrying = false;
		busy = false;
		finder = new AStarPathFinder(map, 500, false);
		resFinder = new AStarPathFinder(map, 500, false, new JamesHeuristic());
	}

	public Vector2f getPos() {
		return pos;
	}

	public void update() {
		timeToMove++;
		if (timeToMove > (30 * Float
				.parseFloat(map.getThisMap()
						.getTileProperty(
								map.getThisMap().getTileId((int) pos.x,
										(int) pos.y, 0), "cost", "10")))
				&& path != null) {
			timeToMove = 0;
			posOnPath++;
			if (posOnPath < path.getLength()) {
				move(path.getStep(posOnPath));
			} else {
				path = null;
				busy = false;
			}

		}
	}

	public void move(Path.Step step) {
		pos.x = step.getX();
		pos.y = step.getY();
	}

	public void updatePath(int x, int y) {
		path = null;
		busy = true;
		path = finder.findPath(this, (int) pos.x, (int) pos.y, x
				/ StartUp.TILEHIGHT, y / StartUp.TILEHIGHT);
		posOnPath = 0;
	}
	
	public void findNearest(int i){
		path = null;
		busy = true;
		int rad = 1;
		for(int it = -rad;it == rad; it++)
		{
			
		}
	}

}
