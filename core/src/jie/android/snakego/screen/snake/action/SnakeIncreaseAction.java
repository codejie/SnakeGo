package jie.android.snakego.screen.snake.action;

import jie.android.snakego.screen.snake.Brick;
import jie.android.snakego.screen.snake.BrickFrame;
import jie.android.snakego.screen.snake.Snake;
import jie.android.snakego.screen.snake.SnakeScreen;

public class SnakeIncreaseAction extends Action {

	private final int total;
	private final int type; 
	
	public SnakeIncreaseAction(int total, int type) {
		this.total = total;
		this.type = type;
	}
	@Override
	protected void exec(final Brick brick, final BrickFrame frame, final Snake snake, final SnakeScreen screen) {
		
		frame.removeBrick(brick);
		
		for (int i = 0; i < total; ++ i) {
			snake.getBody().addSegment(screen, type);
		}
	}

}
