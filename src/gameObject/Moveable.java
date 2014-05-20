package gameObject;

import com.badlogic.gdx.math.Vector2;

public interface Moveable extends Collisionable {
	
	public void applyForce(Vector2 force, boolean wake);

}
