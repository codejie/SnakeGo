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
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class BaseScreen extends Stage implements Screen {

	protected final SnakeGo game;	
	
	public BaseScreen(final SnakeGo game) {
		super(new ScalingViewport(Scaling.fit, CommonConsts.Screen.WIDTH, CommonConsts.Screen.HEIGHT, new OrthographicCamera()), new SpriteBatch());		

		this.game = game;
		
		Gdx.input.setInputProcessor(this);
	}
	
	@Override
	public void render(float delta) {
		update(delta);		
		super.act(delta);
		super.draw();
	}

	protected void update(float delta) {		
	}
	
	@Override
	public void resize(int width, int height) {
		Logger.log("===", "screen resize();");
		this.getViewport().update(width, height, true);
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
