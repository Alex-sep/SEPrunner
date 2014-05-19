package gameObject;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AnimatedObject extends GameObject {
	
	private Animation animation;
	
	@Override
	public void draw(float stateTime, SpriteBatch batch) {
		textRG = animation.getKeyFrame(stateTime);
		super.draw(stateTime, batch);
	}

}
