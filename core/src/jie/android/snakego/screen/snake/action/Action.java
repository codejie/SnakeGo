package jie.android.snakego.screen.snake.action;

import jie.android.snakego.screen.snake.Brick;
import jie.android.snakego.screen.snake.BrickFrame;
import jie.android.snakego.screen.snake.Snake;
import jie.android.snakego.screen.snake.SnakeScreen;

public abstract class Action {

	public static final Action makeAction(final Brick brick) {
		if (brick.getCode() == 0) {
			return new BrickRemoveAction();
		} else if (brick.getCode() == 1) {
			return new SnakeIncreaseAction(1, brick.getType());
		} else {
			return null;
		}
	}

	public static void doAction(final Brick brick, final BrickFrame frame, final Snake snake, final SnakeScreen screen) {
		final Action act = Action.makeAction(brick);
		if (act != null) {
			act.exec(brick, frame, snake, screen);
		}
	}
	
	protected abstract void exec(final Brick brick, final BrickFrame frame, final Snake snake, final SnakeScreen screen);

}
