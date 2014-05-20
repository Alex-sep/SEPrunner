package core.ingame;

import gameObject.DrawableObject;
import gameObject.player.InputHandler;
import gameWorld.Map;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

public class GameRender implements ApplicationListener {
	
	private static GameRender render;
	
	private SpriteBatch batch;

	private GameRender() {
		
	}
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		Gdx.input.setInputProcessor(InputHandler.getInstance());
	}

	@Override
	public void dispose() {
		batch.dispose();
	}


	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		Camera.getInstance().update();
		batch.setProjectionMatrix(Camera.getInstance().combined);

		batch.begin();
		Map.getInstance().draw(batch);								//map
		
		for(DrawableObject d : GameManager.getInstance().getDrawables())	//gameObjects
			d.draw(Gdx.graphics.getDeltaTime(), batch);
		
		HUD.getInstance().draw(batch);								//userInterface
		batch.end();
		
		
		for(World w : GameManager.getInstance().getWorlds())
			w.step(Gdx.graphics.getDeltaTime(), 6, 4);
		
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}
	
	public static GameRender getInstance() {
		if(render == null)
			render = new GameRender();
		return render;
	}

}
