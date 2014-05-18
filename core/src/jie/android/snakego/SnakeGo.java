package jie.android.snakego;

import jie.android.snakego.screen.test.TestInputProcessor;
import jie.android.snakego.screen.test.TestScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Scaling;

public class SnakeGo extends Game {

	public static final int WIDTH = 768;
	public static final int HEIGHT = 1280;
	
	private SpriteBatch batch;
	private OrthographicCamera camera;
	
	private Vector2 screenScaling;
	private Vector2 screenSize;
	private Vector2 screenViewport;

	
	private Texture img;
	
	private TestInputProcessor inputProcessor = new TestInputProcessor();
	@Override
	public void create() {
		
		img = new Texture("badlogic.jpg");
		
//		camera = new OrthographicCamera(WIDTH, HEIGHT);
//		camera.position.set(0, 0, 0);//(WIDTH / 2, HEIGHT / 2, 0);
//		camera.viewportHeight = HEIGHT;
//		camera.viewportWidth = WIDTH;
//		camera.update();
		
		batch = new SpriteBatch();
//		batch.setProjectionMatrix(camera.combined);
		Gdx.input.setInputProcessor(inputProcessor);
		
		setScreen(new TestScreen(this));
		//super.setScreen(new T2Screen(this));
	}

	private float y = 0.0f;
	@Override
	public void render() {
		
		Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.graphics.getGL20().glEnable(GL20.GL_BLEND);
		Gdx.graphics.getGL20().glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		
//		batch.disableBlending();
//		batch.begin();
//		y += 1.0f;// * scale.y;
//		batch.draw(img, (- WIDTH / 2) * screenScaling.x, (- HEIGHT / 2) * screenScaling.y, WIDTH * screenScaling.x, HEIGHT * screenScaling.y);
//		//batch.draw(img, (- WIDTH / 2), (- HEIGHT / 2), WIDTH, HEIGHT);
//		batch.end();
//		
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		
		Vector2 size = Scaling.fit.apply(WIDTH, HEIGHT, width, height);
//		
		screenScaling = new Vector2((size.x / WIDTH), (size.y / HEIGHT));
		//screenScaling = new Vector2(1.0f, 1.0f);
		screenSize = new Vector2(width, height);
		screenViewport = new Vector2(size);
		

		camera = new OrthographicCamera(size.x, size.y);
		camera.update();
	    
	    int viewportX = (int)(width - size.x) / 2;
	    int viewportY = (int)(height - size.y) / 2;
	    int viewportWidth = (int)size.x;
	    int viewportHeight = (int)size.y;
	    
		batch.setProjectionMatrix(camera.combined);
		Gdx.gl.glViewport(viewportX, viewportY, viewportWidth, viewportHeight);		

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

	public final Vector2 getScreenSize() {
		return screenSize;
	}

	public final Vector2 getScreenViewport() {
		return screenViewport;
	}

}
