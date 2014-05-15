package jie.android.snakego;

import jie.android.snakego.screen.test.TestInputProcessor;
import jie.android.snakego.screen.test.TestScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Scaling;

public class SnakeGo extends Game {

	public static final int WIDTH = 1920;
	public static final int HEIGHT = 768;
	
	private SpriteBatch batch;
	private OrthographicCamera camera;
	
	private TestInputProcessor inputProcessor = new TestInputProcessor();
	@Override
	public void create() {
		camera = new OrthographicCamera(1920, 768);
		
		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);
		Gdx.input.setInputProcessor(inputProcessor);
		
		setScreen(new TestScreen(this));
	}

	@Override
	public void render() {
		Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.graphics.getGL20().glEnable(GL20.GL_BLEND);
		Gdx.graphics.getGL20().glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		Vector2 size = Scaling.fit.apply(WIDTH, HEIGHT, width, height);
	    int viewportX = (int)(width - size.x) / 2;
	    int viewportY = (int)(height - size.y) / 2;
	    int viewportWidth = (int)size.x;
	    int viewportHeight = (int)size.y;
	    Gdx.gl.glViewport(viewportX, viewportY, viewportWidth, viewportHeight);
//	    camera.
//	    actorStage.setViewport(WIDTH, ScreenConfig.HEIGHT, true, viewportX, viewportY, viewportWidth, viewportHeight);

		super.resize(width, height);
	}
	
	public final SpriteBatch getSpriteBatch() {
		return batch;
	}
	
	public final OrthographicCamera getCamera() {
		return camera;
	}
	
	public void setScreen(final Screen screen) {
		super.setScreen(screen);
		inputProcessor.setScreen((TestScreen)screen);
		
	}
}
