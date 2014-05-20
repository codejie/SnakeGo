package jie.android.snakego.screen.test;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;

public abstract class DrawableBox extends Box implements Disposable {

	protected final int type;
	
	protected Texture texture;
	
	public DrawableBox(float x, float y, int type) {
		super(x, y);
		
		this.type = type;
		
		if (this.type == 1) {
			texture = new Texture("header.png");
		} else {
			texture = new Texture("body.png");
		}
	}

	@Override
	public void dispose() {
		texture.dispose();
	}
	
	public void draw(final SpriteBatch batch, final Vector2 scale) {
		batch.draw(texture, position.x * scale.x, position.y * scale.y, texture.getWidth() * scale.x, texture.getHeight() * scale.y);
	}

}
