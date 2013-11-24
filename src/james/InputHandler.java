package james;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class InputHandler {

	public void InputFromGameState(GameContainer c, Input input) {
		if (input.isKeyDown(Input.KEY_LCONTROL)) {
			if (input.isKeyPressed(Input.KEY_LEFT)) {
				JamesGameState.tilM.updateSelectedTile(-1);
			} else if (input.isKeyPressed(Input.KEY_RIGHT)) {
				JamesGameState.tilM.updateSelectedTile(1);
			}
		} else if (input.isKeyDown(Input.KEY_LEFT)) {
			JamesGameState.map.mapX += 4;
		} else if (input.isKeyDown(Input.KEY_UP)) {
			JamesGameState.map.mapY += 4;
		} else if (input.isKeyDown(Input.KEY_RIGHT)) {
			JamesGameState.map.mapX -= 4;
		} else if (input.isKeyDown(Input.KEY_DOWN)) {
			JamesGameState.map.mapY -= 4;
		} else if (input.isKeyPressed(Input.KEY_R)) {
			JamesGameState.map.mapX = 0;
			JamesGameState.map.mapY = 0;
		}

		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			c.exit();
		} else if (input.isKeyPressed(Input.KEY_B)) {
			JamesGameState.tilM.changeTile((int) JamesGameState.hlTile.x,
					(int) JamesGameState.hlTile.y, 0);
		}

	}

}
