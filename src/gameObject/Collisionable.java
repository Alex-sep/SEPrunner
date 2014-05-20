package gameObject;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

public interface Collisionable {

	/**
	 * 
	 * @param world Kollisionsebene
	 * @param type Beweglichkeit
	 * @param position Positionsvektor
	 * @param density Dichte
	 * @param friction Reibungskoeffizient
	 * @param restitution Elastizitätskoeffizient
	 * @param sensor Durchlässigkeit
	 * @param shape geometrische Form
	 */
	public void initBody(World world, BodyDef.BodyType type, Vector2 position, 
			float density, float friction, float restitution, boolean sensor, Shape shape);
	
	
	public void addFixture(float density, float friction, float restitution, boolean sensor, Shape shape);
	
	public void setFixture(float density, float friction, float restitution, boolean sensor, Shape shape);
	
}
