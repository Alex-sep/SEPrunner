package gameWorld;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface DrawableMap {

	public void draw(SpriteBatch batch);
	public void initMap(int level);
	public void resetMap();
}
