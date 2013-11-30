package pathfinding;

import org.newdawn.slick.util.pathfinding.AStarHeuristic;
import org.newdawn.slick.util.pathfinding.Mover;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

public class JamesHeuristic implements AStarHeuristic{

	@Override
	public float getCost(TileBasedMap arg0, Mover arg1, int arg2, int arg3,
			int arg4, int arg5) {
		return 0;
	}

}
