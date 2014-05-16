package jie.android.snakego.screen.test;

import jie.android.snakego.SnakeGo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector3;

public class TestScreen implements Screen {

	private final SnakeGo game;	
	private final Snake snake;	
	
	private final Snake.OnUpdateListener listener = new Snake.OnUpdateListener() {
		
		@Override
		public void onUpdate(float x, float y) {
			onSnakeUpdate(x, y);
		}
	};
	
	public TestScreen(final SnakeGo snakeGo) {
		this.game = snakeGo;
		
		this.snake = new Snake(listener);
	}

	@Override
	public void render(float delta) {
		
		snake.update(delta);
		
		game.getSpriteBatch().disableBlending();
		game.getSpriteBatch().begin();
		snake.draw(game.getSpriteBatch());
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
		final Vector3 pos = game.getCamera().position;
//		if (pos.y < y) {		
			pos.y += 32.0 * game.getScreenScale().y;
			game.getCamera().position.set(pos);
			game.getCamera().viewportWidth = (int)((768) * game.getScreenScale().x);//viewportWidth;
			game.getCamera().viewportHeight = (int)((1280) * game.getScreenScale().y);//viewportHeight;
			
			game.getCamera().update();
			
			Gdx.gl.glViewport((int)pos.x, (int)pos.y, (int)game.getCamera().viewportWidth, (int)game.getCamera().viewportHeight);
			
			//game.getSpriteBatch().setProjectionMatrix(game.getCamera().combined);
			
			
			

//		}
	}

}
