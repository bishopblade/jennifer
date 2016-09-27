package com.pineapple.jennifer.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.pineapple.jennifer.Jennifer;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Jennifer";
		config.width = 800;
		config.height = 600;

		new LwjglApplication(new Jennifer(), config);
	}
}
