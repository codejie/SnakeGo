package jie.android.snakego.screen.snake;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;

import jie.android.snakego.CommonConsts;
import jie.android.snakego.SnakeGo;
import jie.android.snakego.screen.BaseScreen;
import jie.android.snakego.utils.Logger;
import jie.android.snakego.utils.Transformer;

public class SnakeScreen extends BaseScreen {

	private final Snake snake;
	private final Actor touchPad;
	
	private final Snake.OnUpdateListener listener = new Snake.OnUpdateListener() {

		@Override
		public void onXYUpdate(int x, int y, int dx, int dy) {
			onSnakeXYUpdate(x, y, dx, dy);
		}

	};	
	
	public SnakeScreen(final SnakeGo game) {
		super(game);
		
		this.snake = new Snake(this);
		
		touchPad = new Actor();
		touchPad.setBounds(0, 0, CommonConsts.Screen.WIDTH, CommonConsts.Screen.HEIGHT);
		touchPad.addListener(new EventListener() {

			@Override
			public boolean handle(Event event) {
				if (event instanceof InputEvent) {
					final InputEvent ie = (InputEvent)event;
					if (ie.getType() == InputEvent.Type.touchDown) {
						onTouchPadTouchDown(ie.getStageX(), ie.getStageY(), ie.getPointer());
						return true;
					} else if (ie.getType() == InputEvent.Type.touchUp) {
						onTouchPadTouchUp(ie.getStageX(), ie.getStageY(), ie.getPointer());
						return true;
					}
				}
				return false;
			}			
		});
		this.addActor(touchPad);
		
		this.snake.setUpdateListener(listener);
	}

	@Override
	public void update(float delta) {
		snake.update(delta);
	}

	protected void onSnakeUpdate(float x, float y) {
		final OrthographicCamera camera = (OrthographicCamera) this.getCamera();// game.getCamera();
		camera.translate(0.0f, 48.0f, 0.0f);
		camera.update();
		this.getSpriteBatch().setProjectionMatrix(camera.combined);		
	}

	protected void onTouchPadTouchDown(float stageX, float stageY, int pointer) {
		final Vector2 v2 = Transformer.screenToMatrix(stageX, stageY);
		snake.touchDown((int)v2.x, (int)v2.y);
	}

	protected void onTouchPadTouchUp(float stageX, float stageY, int pointer) {
		final Vector2 v2 = Transformer.screenToMatrix(stageX, stageY);
		snake.touchUp((int)v2.x, (int)v2.y);
	}

	protected void onSnakeXYUpdate(int x, int y, int dx, int dy) {
		final Vector2 v2 = Transformer.matrixToScreen(dx, dy);
		
		final Camera camera = this.getCamera();
		camera.translate(0.0f, v2.y, 0.0f);
		camera.update();
//		this.getSpriteBatch().setProjectionMatrix(camera.combined);
	}
	
}
