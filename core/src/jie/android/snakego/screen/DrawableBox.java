package jie.android.snakego.screen;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Disposable;

public class DrawableBox extends Box implements Disposable {

	protected Image image;
	public DrawableBox(int x, int y, final Image image) {
		super(x, y);
		setImage(image);
	}
	
	@Override
	public void dispose() {
		if (image != null) {
			image.clear();
		}		
	}
	
	public void put(final Stage stage) {
		if (image != null) {
			stage.addActor(image);
		}
	}

	@Override
	public void setXY(int x, int y) {
		super.setXY(x, y);
		image.setPosition(this.getPosition().x, this.getPosition().y);		
	}
	
	public final Image getImage() {
		return image;
	}
	
	public void setImage(final Image image) {
		if (image != null) {
			image.clear();
		}
		this.image = image;
		this.image.setPosition(this.getPosition().x, this.getPosition().y);
	}
	
}
