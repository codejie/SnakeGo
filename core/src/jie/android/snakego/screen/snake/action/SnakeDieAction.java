package jie.android.snakego.screen.snake.action;

import jie.android.snakego.screen.snake.Brick;
import jie.android.snakego.screen.snake.BrickFrame;
import jie.android.snakego.screen.snake.Snake;
import jie.android.snakego.screen.snake.SnakeScreen;

public class SnakeDieAction extends Action {

	@Override
	protected void exec(Brick brick, BrickFrame frame, Snake snake,	SnakeScreen screen) {
		snake.stop();
		screen.showResult(false);
	}

}
