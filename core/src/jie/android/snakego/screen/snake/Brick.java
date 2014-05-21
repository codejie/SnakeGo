package jie.android.snakego.screen.snake;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import jie.android.snakego.screen.DrawableBox;

public class Brick extends DrawableBox {

	public Brick(int x, int y, int type) {
		super(x, y, Brick.makeImage(type));
	}
	
	public static final Image makeImage(int type) {
		if (type == 0) {
			return new Image(new Texture("header.png"));
		} else {
			return new Image(new Texture("body.png"));
		}
	}

	
}
