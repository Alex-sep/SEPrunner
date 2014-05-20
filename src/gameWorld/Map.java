package gameWorld;

import gameWorld.DrawableMap;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import core.ingame.Camera;

public class Map implements DrawableMap {

	private static Map map;
	private boolean initialized = false;
	private Texture mapTexture;
	private List<Background> backgrounds = new ArrayList<Background>();
	private Map() {
		
	}
	
	public void draw(SpriteBatch batch) {
		if(!initialized)
			return;
		
		batch.disableBlending();
		for(Background b : backgrounds)
			batch.draw(b.texture, 
					b.scrollFactorX * Camera.getInstance().position.x, 
					b.scrollFactorY * Camera.getInstance().position.y);
		batch.enableBlending();
		
		batch.draw(mapTexture, 0, 0);
		
	}
	
	public void initMap(int level) {
		
		initialized = true;
	}
	
	public void resetMap() {
		
		initialized = false;
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
