package core.ingame;

import gameObject.DrawableObject;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;

public class GameManager implements Manageable {

	private static GameManager manager;
	
	private List<DrawableObject> drawables = new ArrayList<DrawableObject>();
	private List<World> worlds = new ArrayList<World>();
	
	private GameManager() {
		
	}
	
	public static GameManager getInstance() {
		if(manager == null)
			manager = new GameManager();
		return manager;
	}
	
	public synchronized boolean addDrawable(DrawableObject drawable) {
		return drawables.add(drawable);
	}
	
	public synchronized boolean removeDrawable(DrawableObject drawable) {
		return drawables.remove(drawable);
	}
	
	public void clearDrawables() {
		drawables.clear();
	}
	
	public List<DrawableObject> getDrawables() {
		return drawables;
	}
	
	public synchronized boolean addWorld(World world) {
		return worlds.add(world);
	}
	
	public synchronized boolean removeWorld(World world) {
		return worlds.remove(world);
	}
	
	public void clearWorlds() {
		worlds.clear();
	}
	
	public List<World> getWorlds() {
		return worlds;
	}
	
	public void toogleFullscreen() {
		if(Gdx.graphics.isFullscreen())
			Gdx.graphics.setDisplayMode(GameProperties.width, GameProperties.height, false);
		else
			setFullscreen();
	}
	
	public void setFullscreen() {
		if(Gdx.graphics.isFullscreen())
			return;
		Gdx.graphics.setDisplayMode(Gdx.graphics.getDesktopDisplayMode().width, Gdx.graphics.getDesktopDisplayMode().height, true);
	}

}
