package jie.android.snakego.screen.test;

import com.badlogic.gdx.math.Vector2;

public abstract class Box {

	protected Vector2 position;
	protected Vector2 prevPosition;
	
	public Box(float x, float y) {
		position = new Vector2(x, y);
		prevPosition = new Vector2(position);
	}

	public final Vector2 getPrevPosition() {
		return prevPosition;
	}
	
	public abstract void update(float dx, float dy);
}
