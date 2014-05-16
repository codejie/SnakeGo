package jie.android.snakego;

import jie.android.snakego.screen.test.T2Screen;
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

	public static final int WIDTH = 768;
	public static final int HEIGHT = 1280;
	
	private SpriteBatch batch;
	private OrthographicCamera camera;
	
	private Vector2 screenScaling;
	
	private TestInputProcessor inputProcessor = new TestInputProcessor();
	@Override
	public void create() {
		camera = new OrthographicCamera(WIDTH, HEIGHT);
		camera.position.set(WIDTH / 2, HEIGHT / 2, 0);
//		camera.update();
		
		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);
		Gdx.input.setInputProcessor(inputProcessor);
		
		//setScreen(new TestScreen(this));
		super.setScreen(new T2Screen(this));
	}

	@Override
	public void render() {
		camera.translate(0, 1, 0);
		camera.update();
		Gdx.gl.glViewport((int)camera.position.x, (int)camera.position.y, (int)camera.viewportWidth, (int)camera.viewportHeight);
//		batch.setProjectionMatrix(camera.combined);
		
		Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.graphics.getGL20().glEnable(GL20.GL_BLEND);
		Gdx.graphics.getGL20().glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		
//		camera.zoom = width / height;
//		camera.update();
		
		Vector2 size = Scaling.fit.apply(WIDTH, HEIGHT, width, height);
		
		screenScaling = new Vector2(size.x / width, size.y / height);
		
	    int viewportX = (int)(width - size.x) / 2;
	    int viewportY = (int)(height - size.y) / 2;
	    int viewportWidth = (int)size.x;
	    int viewportHeight = (int)size.y;
//	    Gdx.gl.glViewport(viewportX, viewportY, viewportWidth, viewportHeight);

//		float centerX = this.width / 2;
//		float centerY = this.height / 2;
//		camera.position.set(viewportX, viewportY, 0);
//		camera.viewportWidth = viewportWidth;
//		camera.viewportHeight = viewportHeight;
		
		Gdx.gl.glViewport(viewportX, viewportY, viewportWidth, viewportHeight);
	    
//		batch.setProjectionMatrix(camera.combined);

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
	
	public final Vector2 getScreenScale() {
		return screenScaling;
	}
}
