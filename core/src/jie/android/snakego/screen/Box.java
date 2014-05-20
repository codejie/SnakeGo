package jie.android.snakego.screen;

import jie.android.snakego.utils.Transformer;

import com.badlogic.gdx.math.Vector2;

public class Box {

	protected int x = 0;
	protected int y  = 0;
	protected final Vector2 position;
	
	public Box(int x, int y) {
		this.x = x;
		this.y = y;
		position = Transformer.matrixToScreen(x, y);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public final Vector2 getPosition() {
		return position;
	}
	
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;		
		position.set(Transformer.matrixToScreen(x, y));
	}
	
	public boolean hit(int x, int y) {
		return (this.x == x && this.y == y);
	}
	
}
