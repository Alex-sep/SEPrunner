package core.ingame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Camera extends OrthographicCamera{
	
	private static Camera camera;
	
	private Camera() {
		super.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
	
	public void update() {
		super.update();
		//relativ zur Spielfigur bewegen
	}
	
	public static Camera getInstance() {
		if(camera == null)
			camera = new Camera();
		return camera;
	}
	
	
}
