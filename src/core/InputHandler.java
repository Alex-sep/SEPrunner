package core;

import java.util.Set;
import java.util.TreeSet;

import com.badlogic.gdx.InputProcessor;

public class InputHandler implements InputProcessor {

	private static InputHandler handler;

	private Set<Integer> pressedKeys = new TreeSet<Integer>();

	private InputHandler() {

	}

	public boolean isKeyDown(int key) {
		return pressedKeys.contains(key);
	}

	public static InputHandler getInstance() {
		if (handler == null)
			handler = new InputHandler();
		return handler;
	}

	@Override
	public boolean keyDown(int keycode) {
		pressedKeys.add(keycode);
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		pressedKeys.remove(new Integer(keycode));
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
