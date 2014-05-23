package jie.android.snakego.screen.snake;

import java.util.HashMap;
import java.util.Map.Entry;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class BrickFrame {
	
	public class XY {
	    private final int x;
	    private final int y;

	    public XY(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof XY)) return false;
	        XY key = (XY) o;
	        return x == key.x && y == key.y;
	    }

	    @Override
	    public int hashCode() {
	        int result = x;
	        result = 31 * result + y;
	        return result;
	    }
	}
	
	private final Stage stage;
	
	private HashMap<XY, Brick> brickMap = new HashMap<XY, Brick>();
	
	public BrickFrame(final Stage stage) {
		this.stage = stage;
		
		init();
		put();
	}
	
	public boolean init() {
		Brick brick = new Brick(8, 20, 0, 0);		
		brickMap.put(new XY(brick.getX(), brick.getY()), brick);
		
		brick = new Brick(6, 20, 0, 1);
		brickMap.put(new XY(brick.getX(), brick.getY()), brick);
		
		return true;
	}
	
	public boolean load() {
		return false;
	}
	
	private void put() {
		for (final Entry<XY, Brick> entry : brickMap.entrySet()) {
			entry.getValue().put(stage);
		}
	}


	public final Brick getBrick(int x, int y) {
		return brickMap.get(new XY(x, y));
	}
	
	public void removeBrick(int x, int y) {
		final Brick brick = brickMap.get(new XY(x, y));
		if (brick != null) {
			removeBrick(brick);
		}
	}

	public void removeBrick(final Brick brick) {
		brick.remove(stage);
		brickMap.remove(new XY(brick.getX(), brick.getY()));		
	}
	
	
	public int checkCode(int x, int y) {
		final Brick brick = brickMap.get(new XY(x, y));
		if (brick != null) {
			return brick.getCode();
		}
		
		return -1;
	}
	
}
