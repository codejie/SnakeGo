package jie.android.snakego.screen.snake.action;

import jie.android.snakego.screen.snake.Brick;
import jie.android.snakego.screen.snake.BrickFrame;
import jie.android.snakego.screen.snake.Snake;
import jie.android.snakego.screen.snake.SnakeScreen;

public class BrickRemoveAction extends Action {

	@Override
	protected void exec(final Brick brick, final BrickFrame frame, final Snake snake, final SnakeScreen screen) {
		frame.removeBrick(brick);
	}

}
