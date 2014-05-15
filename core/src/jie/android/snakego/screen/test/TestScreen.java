package jie.android.snakego.screen.test;

import jie.android.snakego.SnakeGo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class TestScreen implements Screen {

	private final SnakeGo game;
	
	private final Snake snake;
	
	public TestScreen(final SnakeGo snakeGo) {
		this.game = snakeGo;
		
		this.snake = new Snake();
	}

	@Override
	public void render(float delta) {
		snake.update(delta);
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
		snake.setY(-32.0f);
		return true;
	}

}
