package jie.android.snakego;

import jie.android.snakego.screen.test.TestInputProcessor;
import jie.android.snakego.screen.test.TestScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SnakeGo extends Game {

	private SpriteBatch batch;
	private OrthographicCamera camera;
	
	@Override
	public void create() {
		camera = new OrthographicCamera(1920, 768);
		
		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);
		
		this.setScreen(new TestScreen(this));
		
		Gdx.input.setInputProcessor(new TestInputProcessor());
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
		// TODO Auto-generated method stub
		super.resize(width, height);
	}	
}
