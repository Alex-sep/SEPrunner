package core.ingame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HUD {

	private static HUD ui;
	
	private HUD() {
		
	}
	
	public static HUD getInstance() {
		if(ui == null)
			ui = new HUD();
		return ui;
	}
	
	public void draw(SpriteBatch batch) {
		
	}
	
}
