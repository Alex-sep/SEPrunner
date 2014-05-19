package launcher;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import core.GameProperties;
import core.ingame.GameRender;

public class MainLauncher {
	
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "LibGDXTest";
		cfg.useGL20 = false;
		cfg.width = GameProperties.width;
		cfg.height = GameProperties.height;
		
		new LwjglApplication(GameRender.getInstance(), cfg);
	}
}
