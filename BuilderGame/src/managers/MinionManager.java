package managers;

import james.Mapy;
import james.Minion;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MinionManager {
	ArrayList<Minion> minions;
	Image worker;
	Mapy map;

	public MinionManager(Mapy map) throws SlickException {
		this.map = map;
		minions = new ArrayList<Minion>();
		worker = new Image("data/sprite.png");
		minions.add(0, new Minion(4, 4, worker, map));
		minions.add(1, new Minion(5, 4, worker, map));
	}

	public void updateMinions() {
		for (Minion e : minions) {
			e.update();
		}

	}
	
	public void assignWork(int i){
		for(Minion e: minions){
			if(!e.busy){
				e.findNearest(i);
			}
		}
	}

	public void render(Graphics arg2) {
		for (Minion e : minions) {
			arg2.drawImage(e.sprite, (e.getPos().x * map.getThisMap()
					.getTileHeight()) + map.mapX, (e.getPos().y * map
					.getThisMap().getTileHeight()) + map.mapY);
		}
	}
}
