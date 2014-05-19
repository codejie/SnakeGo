package jie.android.snakego.screen.test;

import jie.android.snakego.SnakeGo;
import jie.android.snakego.screen.BaseScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class TestScreen implements Screen {

	private final SnakeGo game;	
	private final Snake snake;	
	
	private Texture img, img1;
	private final Snake.OnUpdateListener listener = new Snake.OnUpdateListener() {
		
		@Override
		public void onUpdate(float x, float y) {
			onSnakeUpdate(x, y);
		}
	};
	
	public TestScreen(final SnakeGo snakeGo) {
		this.game = snakeGo;
		
		this.snake = new Snake(listener);
		this.img = new Texture("body.png");
		this.img1 = new Texture("header.png");
	}

	@Override
	public void render(float delta) {
		
		snake.update(delta);
		
		game.getSpriteBatch().disableBlending();
		game.getSpriteBatch().begin();
		snake.draw(game.getSpriteBatch(), game.getScreenScale());
		
		game.getSpriteBatch().draw(img, 20 * game.getScreenScale().x, 300 * game.getScreenScale().y, 48 * game.getScreenScale().x, 48 * game.getScreenScale().y);
		game.getSpriteBatch().draw(img1, 200, 0);		
		game.getSpriteBatch().end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

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
	
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		Gdx.app.log("===", "onTouchDown() - x = " + screenX + " y = " + screenY + " p = " + pointer + " btn = " + button);

		if (pointer != 0) {
			return false;
		}
				
		Vector3 pos = new Vector3(screenX, screenY, 0);
		game.getCamera().unproject(pos);
		
		Gdx.app.log("===", "onTouchDown() pos - x = " + pos.x + " y = " + pos.y);
		
		return snake.onTouchDown(pos.x, pos.y);
	}

	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		Gdx.app.log("===", "onTouchUp() - x = " + screenX + " y = " + screenY + " p = " + pointer + " btn = " + button);

		if (pointer != 0) {
			return false;
		}
		
		Vector3 pos = new Vector3(screenX, screenY, 0);
		game.getCamera().unproject(pos);
		
		Gdx.app.log("===", "onTouchUp() pos - x = " + pos.x + " y = " + pos.y);
		
		game.setScreen(new BaseScreen(this.game));
		
		return snake.onTouchUp(pos.x, pos.y);		
	}

	public boolean touchDragged(int screenX, int screenY, int pointer) {
		Gdx.app.log("===", "onTouchDragged() - x = " + screenX + " y = " + screenY + " p = " + pointer);

		if (pointer != 0) {
			return false;
		}
		
		Vector3 pos = new Vector3(screenX, screenY, 0);
		game.getCamera().unproject(pos);
		
		Gdx.app.log("===", "onTouchDragged() pos - x = " + pos.x + " y = " + pos.y);
		
		return snake.onTouchDragged(pos.x, pos.y);		
	}
	
	public void onSnakeUpdate(float x, float y) {
		final OrthographicCamera camera = game.getCamera();
		camera.translate(0.0f, 48.0f * game.getScreenScale().y, 0.0f);
		camera.update();
		game.getSpriteBatch().setProjectionMatrix(camera.combined);
//		
//	    int viewportX = (int)((game.getScreenSize().x - game.getScreenViewport().x) / 2);
//	    int viewportY = (int)((game.getScreenSize().y - game.getScreenViewport().y) / 2);
//	    int viewportWidth = (int)game.getScreenViewport().x;
//	    int viewportHeight = (int)game.getScreenViewport().y;
//	    
//		Gdx.gl.glViewport(viewportX, viewportY, viewportWidth, viewportHeight);

	}

}
