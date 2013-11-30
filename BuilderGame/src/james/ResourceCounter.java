package james;

public class ResourceCounter {
	private int treeSeeds;
	private int cabbage;
	private int wood;

	public ResourceCounter() {
		treeSeeds = 10;
		cabbage = 10;
		wood = 0;
	}

	public boolean canUseTreeSeed() {
		if (treeSeeds > 0) {
			treeSeeds--;
			return true;
		} else
			return false;
	}

	public boolean canEat() {
		if (cabbage > 0) {
			cabbage--;
			return true;
		} else
			return false;
	}

	public int getTreeSeeds() {
		return treeSeeds;
	}

	public void addTreeSeeds(int howMany) {
		treeSeeds+= howMany;
	}

	public int getCabbage() {
		return cabbage;
	}

	public void addCabbage(int howMany) {
		cabbage += howMany;
	}

	public int getWood() {
		return wood;
	}

	public void addWood(int howMany) {
		wood+= howMany;
	}

}
