package jie.android.snakego.screen.test;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

public abstract class DrawableBox extends Box implements Disposable {

	protected final int type;
	
	public DrawableBox(float x, float y, int type) {
		super(x, y);
		
		this.type = type;
	}

	@Override
	public void dispose() {		
	}
	
	public void draw(final SpriteBatch batch) {
		
	}

}
