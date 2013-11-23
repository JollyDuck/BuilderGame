package james;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class InputHandler {

	public void InputFromGameState(GameContainer c, Input input,
			JamesGameState jamesGameState) {

		if (input.isKeyDown(Input.KEY_LCONTROL)) {

			if (input.isKeyDown(Input.KEY_LEFT)) {
				jamesGameState.map.mapX += 4;
			} else if (input.isKeyDown(Input.KEY_UP)) {
				jamesGameState.map.mapY += 4;
			} else if (input.isKeyDown(Input.KEY_RIGHT)) {
				jamesGameState.map.mapX -= 4;
			} else if (input.isKeyDown(Input.KEY_DOWN)) {
				jamesGameState.map.mapY -= 4;
			} else if (input.isKeyPressed(Input.KEY_R)) {
				jamesGameState.map.mapX = 0;
				jamesGameState.map.mapY = 0;
			}
		}
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			c.exit();
		} else if (input.isKeyPressed(Input.KEY_B)) {
			jamesGameState.map.getThisMap().setTileId(
					(int) jamesGameState.hlTile.x,
					(int) jamesGameState.hlTile.y, 0, 12);
		}

	}

}
