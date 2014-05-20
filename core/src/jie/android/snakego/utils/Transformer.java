package jie.android.snakego.utils;

import jie.android.snakego.CommonConsts;

import com.badlogic.gdx.math.Vector2;

public class Transformer {
	public static final Vector2 matrixToScreen(int x, int y) {
		return new Vector2(x * CommonConsts.Box.WIDTH, y * CommonConsts.Box.HEIGHT);
	}
	
	public static final Vector2 screenToMatrix(float x, float y) {
		return new Vector2((int)(x / CommonConsts.Box.WIDTH), (int)(x / CommonConsts.Box.HEIGHT));
	}
}
