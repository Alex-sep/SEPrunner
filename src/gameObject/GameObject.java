package gameObject;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

import core.ingame.GameManager;
import core.ingame.GameProperties;

public class GameObject implements DrawableObject, Moveable {

	protected Body body;
	protected TextureRegion textRG;

	private boolean flip;
	private boolean visible;

	protected GameObject() {
		GameManager.getInstance().addDrawable(this);
	}
	
	@Override
	public void draw(float stateTime, SpriteBatch batch) {
		if (visible)
			batch.draw(textRG, GameProperties.meterToPixel(body.getPosition().x), GameProperties.meterToPixel(body.getPosition().y));
	}

	@Override
	public void setFlip(boolean flip) {
		if (this.flip == flip)
			return;
		flip();
	}

	@Override
	public void flip() {
		flip = !flip;
		textRG.flip(true, false);
	}

	@Override
	public boolean isFlipped() {
		return flip;
	}

	@Override
	public void addFixture(float density, float friction, float restitution, boolean sensor, Shape shape) {
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.density = density;
		fixtureDef.isSensor = sensor;
		fixtureDef.shape = shape;
		fixtureDef.friction = friction;
		fixtureDef.restitution = restitution;
		body.createFixture(fixtureDef);
		shape.dispose();
	}

	@Override
	public void setFixture(float density, float friction, float restitution, boolean sensor, Shape shape) {
		for (Fixture f : body.getFixtureList())
			body.destroyFixture(f);
		addFixture(density, friction, restitution, sensor, shape);
	}

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
	@Override
	public void initBody(World world, BodyDef.BodyType type, Vector2 position, 
			float density, float friction, float restitution, boolean sensor, Shape shape) {
		
		if(body != null)
			world.destroyBody(body);
		
		// init bodyDef
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = type;
		bodyDef.position.set(position);
		body = world.createBody(bodyDef);

		setFixture(density, friction, restitution, sensor, shape);
	}
	
	@Override
	public void applyForce(Vector2 force, boolean wake) {
		body.applyForceToCenter(force, wake);
	}
	
	public Body getBody() {
		return body;
	}

	@Override
	public void setVisible(boolean visible) {
		this.visible = visible;	
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

	@Override
	public void toogleVisible() {
		visible = !visible;
	}
}
