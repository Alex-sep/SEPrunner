package core.ingame;

import gameObject.DrawableObject;

import java.util.List;

import com.badlogic.gdx.physics.box2d.World;

public interface Manageable {
	
	public boolean addDrawable(DrawableObject drawable);
	public boolean removeDrawable(DrawableObject drawable);
	public void clearDrawables();
	public List<DrawableObject> getDrawables();
	
	public boolean addWorld(World world);
	public boolean removeWorld(World world);
	public void clearWorlds();
	public List<World> getWorlds();
	
}
