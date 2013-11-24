package james;

import org.newdawn.slick.geom.Vector2f;

public class Tile {
	Vector2f position;
	boolean manage;
	int timeNeededToUpgrade;
	int timeTillUpgrade;
	int tileIDToChangeTo;
	int resourceToGenerate; // 1 for wood, 2 for cabbage.

	/**
	 * 
	 * @param timeToUpgrade
	 *            Time needed to upgrade.
	 * @param tileIDToChangeTo
	 *            ID of what to upgrade into.
	 * @param resToGen
	 *            The resource to generate when upgrading. If 0 then nothing, 1
	 *            for wood, 2 for cabbage.
	 */
	public Tile(int timeNeededToUpgrade, int tileIDToChangeTo, int resToGen) {
		position = new Vector2f(0f, 0f);
		this.timeNeededToUpgrade = timeNeededToUpgrade;
		this.tileIDToChangeTo = tileIDToChangeTo;
		this.resourceToGenerate = resToGen;
		if (timeNeededToUpgrade == 0) {
			manage = false;
		}
	}

	public Tile update() {
		if (manage) {
			timeTillUpgrade--;
			if (timeTillUpgrade <= 0) {

				// Generate new resources (if necessary)
				switch (resourceToGenerate) {
				default:
					break;
				case 1:
					JamesGameState.resH.addWood();
					break;
				case 2:
					JamesGameState.resH.addCabbage();
					break;
				}

			}
		}
		return this;
	}

}
