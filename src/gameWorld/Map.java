package gameWorld;

import gameObject.Drawable;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import core.Camera;

public class Map implements Drawable {

	private static Map map;
	private Texture mapTexture;
	private List<Background> backgrounds = new ArrayList<Background>();
	private Map() {
		
	}
	
	public void draw(float stateTime, SpriteBatch batch) {
		batch.draw(mapTexture, 0, 0);
		
		for(Background b : backgrounds)
			batch.draw(b.texture, 
					b.scrollFactorX * Camera.getInstance().position.x, 
					b.scrollFactorY * Camera.getInstance().position.y);
	}
	
	public static Map getInstance() {
		if(map == null)
			map = new Map();
		return map;
	}
	
	private class Background {
		private Texture texture;
		private float scrollFactorX, scrollFactorY;
	}
}
