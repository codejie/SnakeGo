package jie.android.snakego.screen.test;

import com.badlogic.gdx.math.Vector2;

public abstract class Box {

	public Vector2 position;
	public int type;
	
	public abstract void update(float delta);
	public abstract void draw();	
}
