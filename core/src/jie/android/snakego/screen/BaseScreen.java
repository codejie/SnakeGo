package jie.android.snakego.screen;

import jie.android.snakego.CommonConsts;
import jie.android.snakego.SnakeGo;
import jie.android.snakego.utils.Logger;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.Viewport;

public class BaseScreen extends Stage implements Screen {

	protected final SnakeGo game;	
	protected SpriteBatch batch;

	protected Viewport viewport;
	private final Image image;
	
	public BaseScreen(final SnakeGo game) {
		super();		
		this.game = game;

		image = new Image(new Texture("badlogic.jpg"));
//		image = new Image(new Texture("header.png"));
		image.setPosition(0, 0);
//		image.setWidth(64);
//		image.setHeight(64);
		this.addActor(image);
	}
	
	@Override
	public void render(float delta) {
		super.act(delta);
		super.draw();
	}

	@Override
	public void resize(int width, int height) {
		Logger.log("===", "screen resize();");
		
		Vector2 size = Scaling.fit.apply(CommonConsts.Screen.WIDTH, CommonConsts.Screen.HEIGHT, width, height);
//		
		Vector2 screenScaling = new Vector2((size.x / CommonConsts.Screen.WIDTH), (size.y / CommonConsts.Screen.HEIGHT));
		
		float s = CommonConsts.Screen.WIDTH / CommonConsts.Screen.HEIGHT;
//		//screenScaling = new Vector2(1.0f, 1.0f);
//		screenSize = new Vector2(width, height);
//		screenViewport = new Vector2(size);
//		
//
//		camera = new OrthographicCamera(size.x, size.y);
//		camera.update();
	    
	    int viewportX = (int)(width - size.x) / 2;
	    int viewportY = (int)(height - size.y) / 2;
	    int viewportWidth = (int)size.x;
	    int viewportHeight = (int)size.y;
	    
//		batch.setProjectionMatrix(camera.combined);
//		Gdx.gl.glViewport(viewportX, viewportY, viewportWidth, viewportHeight);				
		
		this.getViewport().update((int)size.x, (int)size.y, true);
		float w = image.getWidth() * screenScaling.x;
		float h = image.getHeight() * screenScaling.y;
//		image.setWidth(w);
//		image.setHeight(h);
		image.setScale(screenScaling.x, screenScaling.y);
//		this.getRoot().setScale(screenScaling.x * (CommonConsts.Screen.WIDTH /CommonConsts.Screen.HEIGHT) , screenScaling.y * (CommonConsts.Screen.WIDTH /CommonConsts.Screen.HEIGHT) );
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}


}
