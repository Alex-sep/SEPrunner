package core.ingame;

import com.badlogic.gdx.Input.Keys;

public abstract class GameProperties {

	public static int width = 1280;
	public static int height = 800;

	public static boolean menu = false;
	public static boolean ingame = false;

	public static float musicVolume = 1.0f;
	public static float soundVolume = 1.0f;
	public static float gamma = 1.0f;
	public static float brightness = 1.0f;

	public static int keyLeft = Keys.A, 
			keyRight = Keys.D, 
			keyJump = Keys.W, 
			keyCrouch = Keys.S, 
			keyAction = Keys.E;

	final public static float PIXELPROMETER = 100;

	public static float meterToPixel(float meter) {
		return meter * PIXELPROMETER;
	}

	public static float pixelToMeter(float pixel) {
		return pixel / PIXELPROMETER;
	}

}
