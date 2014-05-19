package jie.android.snakego.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import jie.android.snakego.SnakeGo;
import jie.android.snakego.SnakeGoGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//new LwjglApplication(new SnakeGoGame(), config);
		
		config.width = 800 / 3;
		config.height = 400 / 3;
		
		new LwjglApplication(new SnakeGo(), config);
	}
}
